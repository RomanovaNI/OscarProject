package com.oscar.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BasketPage extends PageBase {
    public BasketPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class='page-header action'][contains(.,'Basket')]")
    WebElement basketTitle;

    @FindBy(id = "id_form-0-quantity")
    WebElement numberOfBooks;

    @FindBy(xpath = "//button[contains(.,'Update')]")
    WebElement updateTab;

    public boolean isBasketTitlePresent() {
        return basketTitle.isDisplayed();
    }

    public BasketPage changeQuantity(String quantity) {
        type(numberOfBooks, quantity);
        updateTab.click();

        return this;
    }

    @FindBy(xpath = "(//p[@class='price_color align-right'])[1]")
    WebElement priceOfOneItem;

    @FindBy(xpath = "(//p[@class='price_color align-right'])[2]")
    WebElement priceTotal;

    public String savePriceOfOneItem() {
        return priceOfOneItem.getText();
    }

    public String checkTotalPrice() {
        return priceTotal.getText();
    }

    @FindBy(xpath = "//p[contains(.,'Your basket is now empty')]")
    WebElement alertBasketIsEmpty;

    public boolean isEmptyBasketAlertPresenrt() {
        return alertBasketIsEmpty.isDisplayed();
    }

    @FindBy(xpath = "//form/div[1]/div[1]/div[2]/h3[1]/a[1]")
    WebElement nameOfFirstItem;

    public String saveBookname() {
        //.basket-items:nth-child(6) h3 a
        return nameOfFirstItem.getText();
    }

    public String checkNameOfBookAfterDelete() {
        return nameOfFirstItem.getText();
    }

    @FindBy(css = "tr:nth-child(2) th:nth-child(2)")
    WebElement totalPriceInTotals;

    public String checkTotalPriceInTotals() {
        return totalPriceInTotals.getText();
    }

    public String checkTotalPriceAfterDelete() {
        return totalPriceInTotals.getText();
    }

    @FindBy(xpath = "//a[contains(.,'Proceed to checkout')]")
    WebElement proccedToCheckoutTab;

    public CheckoutPage proceedToCheckout() {
        proccedToCheckoutTab.click();
        return new CheckoutPage(driver);
    }

    public Double getPrice() {
        double num = Double.parseDouble(priceTotal.getText().replace("£", ""));
        return num;

    }
}
