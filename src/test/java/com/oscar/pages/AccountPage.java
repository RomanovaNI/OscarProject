package com.oscar.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountPage extends PageBase {

    public AccountPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "delete_profile")
    WebElement deleteProfileTab;

    @FindBy(id = "id_password")
    WebElement pswdField;

    @FindBy(xpath = "//button[contains(.,'Delete')]")
    WebElement deleteTab;


    public HomePage deleteAccount(String pswd) {
        deleteProfileTab.click();
        type(pswdField, pswd);
        deleteTab.click();

        return new HomePage(driver);
    }

    @FindBy(xpath = "//li[contains(.,'Order History')]")
    WebElement orderHistoryTab;

    public AccountPage clickOrderHistory() {
        orderHistoryTab.click();
        return this;
    }

    @FindBy(xpath = "//tr[contains(.,'20 Aug 2021')]")
    WebElement dateOfOrder;

    public boolean isOrderPresent() {
       return dateOfOrder.isDisplayed();
    }
}
