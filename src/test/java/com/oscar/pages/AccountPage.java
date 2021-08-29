package com.oscar.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

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

    @FindBy(xpath = "//a[contains(.,'Address Book')]")
    WebElement addressBookTab;

    @FindBy(xpath = "//a[contains(.,'Product Alerts')]")
    WebElement productAlertTab;

    @FindBy(xpath = "//a[contains(.,'Wish Lists')]")
    WebElement wishListsTab;

    public AccountPage clickOrderHistory() {
        orderHistoryTab.click();
        return this;
    }

    public AccountPage clickEmailHistory() {
        emailHistoryTab.click();
        return this;
    }

    public AccountPage clickAddressBook() {
        addressBookTab.click();
        return this;
    }

    public AccountPage clickWishLists() {
        wishListsTab.click();
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

    @FindBy(xpath = "//div[@id='messages'][contains(.,'Profile updated')]")
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
        type(firstNameField, name);
        saveTab.click();
        return this;
    }

    @FindBy(xpath = "//a[@href='/en-gb/accounts/addresses/add/']")
    WebElement addAddressTab;

    public AccountPage clickAddNewAddress() {

        addAddressTab.click();
        return this;
    }

    @FindBy(id = "id_title")
    WebElement titleField;

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

    @FindBy(id = "id_notes")
    WebElement instructionsField;

    @FindBy(xpath = "//form[@class='form-horizontal ']//button[@type='submit']")
    WebElement saveAddressTab;


    public AccountPage fillAddressForm(String title, String name, String lName, String address, String city, String index, String country, String notes) {

        Select select1 = new Select(titleField);
        select1.selectByVisibleText(title);

        List<WebElement> options1 = select1.getOptions();

        for (int i = 0; i < options1.size(); i++) {

        }

        type(firstNameTab, name);
        type(lastNameTab, lName);
        type(addressTab, address);
        type(cityTab, city);
        type(zipCodeTab, index);

        Select select2 = new Select(countryTab);
        select2.selectByVisibleText(country);

        List<WebElement> options2 = select2.getOptions();

        for (int i = 0; i < options2.size(); i++) {

        }
        type(instructionsField, notes);

        saveAddressTab.click();

        return this;
    }

    @FindBy(xpath = "//div[@class='alert alert-success  fade in']")
    WebElement successAlert;

    public boolean isSuccessAlertPresent() {
        return successAlert.isDisplayed();
    }

    public AccountPage clickProductAlert() {
        productAlertTab.click();

        return this;
    }

    @FindBy(css = "tr:nth-child(2)")
    WebElement bookNameCell;

    public boolean isBookContainsText(String bookName) {
        return bookNameCell.getText().contains(bookName);

    }

    @FindBy(xpath = "//a[contains(.,'Default')]")
    //css = "tr:nth-child(2) > td"
    WebElement deafaultWishList;

    public AccountPage clickDeafaultList() {
        deafaultWishList.click();
        return this;
    }
}
