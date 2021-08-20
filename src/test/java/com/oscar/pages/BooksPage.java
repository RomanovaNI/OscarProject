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

    @FindBy(xpath = "///div[@class='alertinner '][contains(.,' has been added to your basket.')]")
    WebElement confirmMsgItemIsInBasket;

    
    @FindBy(xpath = "//a[contains(.,'Checkout now')]")
    WebElement checkoutTab;

    public BooksPage addItemToBasket() {
        addFirstBookToBasketTab.click();
        return this;
    }

    public boolean isConfirmMsgPresent() {
        return addFirstBookToBasketTab.isDisplayed();
    }

    public CheckoutPage clickCheckout() {
        checkoutTab.click();
        return  new CheckoutPage(driver);
    }
}
    //a[contains(.,' Continue shopping')]
