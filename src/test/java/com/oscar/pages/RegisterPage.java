package com.oscar.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends PageBase {
    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "id_registration-email")
    WebElement emailField;

    @FindBy(id = "id_registration-password1")
    WebElement passwordField;

    @FindBy(id = "id_registration-password2")
    WebElement password2Field;

    @FindBy(name = "registration_submit")
    WebElement registerBtn;


    public HomePage fillRegisterForm(String email, String password) {

        type(emailField, email);
        type(passwordField, password);
        type(password2Field, password);
        registerBtn.click();


        return new HomePage(driver);
    }

    @FindBy(id = "login_link")
    WebElement loginTab;

    public boolean isLoginTabPresent() {
        return loginTab.isDisplayed();
    }

    @FindBy(xpath = "//strong[contains(.,'Oops! We found some errors')]")
    WebElement errorMsg;

    public boolean isErrorMsgPresent() {
        return errorMsg.isDisplayed();
    }
}
