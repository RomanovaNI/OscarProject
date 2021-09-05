package com.oscar.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BooksPage extends PageBase {
    public BooksPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//form[@action='/en-gb/basket/add/209/']")
    WebElement addFirstBookToBasketTab;

    @FindBy(xpath = "(//button[contains(.,'Add to basket')])[1]")
    WebElement addItemToBasketTab;

    @FindBy(xpath = "//div[@class='alertinner '][contains(.,' has been added to your basket.')]")
    WebElement confirmMsgItemIsInBasket;


    @FindBy(xpath = "//a[contains(.,'Checkout now')]")
    WebElement checkoutTab;

    @FindBy(xpath = "//a[contains(.,'Essential programming')]")
    WebElement essentialProgrammingTab;

    @FindBy(css = "[title='Agile Retrospective']")
    WebElement unavailableBook;

    @FindBy(css = "[title='Hackers']")
    WebElement hackersBook;

    @FindBy(xpath = "//button[@type='submit'][contains(.,'Notify')]")
    WebElement notifyMeTab;


    @FindBy(xpath = "//a[contains(.,'next')]")
    WebElement btnNext;

    @FindBy(xpath = "//a[contains(.,'previous')]")
    WebElement btnPrevious;

    @FindBy(xpath = "//button[contains(.,'Add to wish list')]")
    WebElement addToWishListTab;

    public BooksPage addFirstItemToBasket() {
        addFirstBookToBasketTab.click();
        return this;
    }

    public BooksPage addItemToBasket() {
       addItemToBasketTab.click();
        return this;
    }

    public boolean isConfirmMsgPresent() {
        return addFirstBookToBasketTab.isDisplayed();
    }

    public CheckoutPage clickCheckout() {
        checkoutTab.click();
        return new CheckoutPage(driver);
    }

    public BooksPage chooseEssenProgrammingSection() {
        essentialProgrammingTab.click();
        return this;
    }

    public BooksPage chooseUnavailbleBook() {
        unavailableBook.click();
        return this;
    }

    public BooksPage clickNotifyMe() {
        notifyMeTab.click();
        return this;
    }

    public BooksPage clickNextBtn() {
        clickWithAction(btnNext, 0, 2000);
        return this;
    }

    public BooksPage clickPreviousBtn() {
        btnPrevious.click();
        return this;
    }


    public void clickAddToWishList() {
        addToWishListTab.click();
    }

    public BooksPage chooseHackersBook() {
        hackersBook.click();
        return this;
    }

    @FindBy(xpath = "//div//h1")
    WebElement bookNameCell;

    public boolean isBookContainsText(String bookName) {
        return bookNameCell.getText().contains(bookName);
    }

    @FindBy(xpath = "//li[@class='current'][contains(.,'Page 3')]")
    WebElement page3;

    public boolean is3rdPagePresent() {
        return page3.isDisplayed();
    }

    public boolean isPreviousBtnPresent() {
        return btnPrevious.isDisplayed();
    }
    @FindBy(css = "[title='Agile Retrospective']")
    WebElement titleAgile;

    public String getNameOfUnavailableBook() {
        return titleAgile.getText();
    }

    public String getBookName() {
        return bookNameCell.getText();
    }
}
//a[contains(.,' Continue shopping')]
