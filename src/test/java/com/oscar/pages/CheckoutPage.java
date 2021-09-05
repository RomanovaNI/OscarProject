package com.oscar.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class CheckoutPage extends PageBase {
    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "id_first_name")
    WebElement firstNameTab;

    @FindBy(id = "id_last_name")
    WebElement lastNameTab;

    @FindBy(id = "id_line1")
    WebElement addressTab;

    @FindBy(id = "id_line4")
    WebElement cityTab;

    @FindBy(id = "id_postcode")
    WebElement zipCodeTab;

    @FindBy(id = "id_country")
    WebElement countryTab;

    @FindBy(css = "[type='submit']")
    WebElement continueTab;



    public CheckoutPage fillShippingForm(String name, String lName, String address, String city, String index, String country) {

        type(firstNameTab, name);
        type(lastNameTab, lName);
        type(addressTab,address);
        type(cityTab, city);
        type(zipCodeTab, index);

        Select select = new Select(countryTab);
        select.selectByVisibleText(country);

        List<WebElement> options = select.getOptions();

        for (int i = 0; i < options.size(); i++) {

        }

        continueTab.click();

        return this;

    }

    @FindBy(id = "view_preview")
    WebElement continueFromPaymentTab;

    public CheckoutPage clickContinueFromPayment() {
        continueFromPaymentTab.click();
        return this;
    }

    @FindBy (id = "place-order")
    WebElement placeOrderTab;

    public CheckoutPage clickPlaceOrder() {
        placeOrderTab.click();
        return this;
    }

    @FindBy(xpath = "//a[contains(.,'Continue shopping')]")
    WebElement continueFromConfirmationTab;

    public HomePage clickContinueFromConfirmation() {
        continueFromConfirmationTab.click();
        return new HomePage(driver);
    }

    @FindBy(xpath = "//span[contains(.,' The postcode')]")
    WebElement errorPostcode;

    public boolean isErrorMsgIndexPresent() {
        return errorPostcode.isDisplayed();
    }

    @FindBy(xpath = "//label[@for='id_options_1']")
    WebElement radio3NewCustomerAndCreateAccount;

    public CheckoutPage chooseNewCustomerAndCreateAccount() {
        radio3NewCustomerAndCreateAccount.click();
        return this;
    }

    @FindBy(xpath = "//h1[contains(.,'Who are you?')]")
    WebElement whoAreYouAlert;

    public boolean isWhoRUPresent() {
       return whoAreYouAlert.isDisplayed();
    }
}
