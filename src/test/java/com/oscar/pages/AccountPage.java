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

    @FindBy(xpath = "//a[contains(.,'Change password')]")
    WebElement changePswdBtn;

    @FindBy(xpath = "//a[contains(.,'Edit profile')]")
    WebElement editProfileBtn;


    public HomePage deleteAccount(String pswd) {
        deleteProfileTab.click();
        type(pswdField, pswd);
        deleteTab.click();

        return new HomePage(driver);
    }

    public AccountPage clickChangePswd() {
        changePswdBtn.click();
        return this;
    }

    public AccountPage clickEditProfile() {
        editProfileBtn.click();
        return this;
    }

    @FindBy(xpath = "//li[contains(.,'Order History')]")
    WebElement orderHistoryTab;

    @FindBy(xpath = "//li[contains(.,'Email History')]")
    WebElement emailHistoryTab;

    public AccountPage clickOrderHistory() {
        orderHistoryTab.click();
        return this;
    }

    public AccountPage clickEmailHistory() {
        emailHistoryTab.click();
        return this;
    }

    @FindBy(xpath = "//tr[contains(.,'20 Aug 2021')]")
    WebElement dateOfOrder;

    public boolean isOrderPresent() {
        return dateOfOrder.isDisplayed();
    }



    @FindBy(name = "old_password")
    WebElement oldPswdField;

    @FindBy(name = "new_password1")
    WebElement newPswdField;

    @FindBy(name = "new_password2")
    WebElement newPswdConfirmField;

    @FindBy(xpath = "//button[contains(.,'Save')]")
    WebElement saveTab;

    public AccountPage fillChangePswdForm(String oldPswd, String newPswd) {
        type(oldPswdField, oldPswd);
        type(newPswdField, newPswd);
        type(newPswdConfirmField, newPswd);
        saveTab.click();
        return this;
    }

    @FindBy(xpath = "//strong[contains(.,'Oops! We found some errors')]")
    WebElement errorMsg;

    public boolean isErrorMsgPresent() {
        return errorMsg.isDisplayed();
    }

    @FindBy(xpath = "//tr[3][contains(.,'Your password changed')]")
    WebElement pswdChangedSubject;

    public boolean isPswdChangedSubjectPresent() {
        return pswdChangedSubject.isDisplayed();
    }

    @FindBy (xpath = "//div[@id='messages'][contains(.,'Profile updated')]")
    WebElement profileUpdatedMsg;

    @FindBy(xpath = "//div[@id='messages'][contains(.,'Password updated')]")
    WebElement pswdUpdatedMsg;

    public boolean isProfileUpdatedPresent() {
        return profileUpdatedMsg.isDisplayed();
    }
    public boolean isPswdUpdatedPresent() {
        return pswdUpdatedMsg.isDisplayed();
    }

    @FindBy(name = "first_name")
    WebElement firstNameField;

    public AccountPage filleditProfileForm(String name) {
        type(firstNameField,name);
        saveTab.click();


        return this;
    }
}
