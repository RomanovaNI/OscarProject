package com.oscar.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends PageBase {


    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".dropdown-submenu")
    WebElement submenuBooks;


    public ProductPage selectCategory() {
        submenuBooks.click();
        return new ProductPage(driver);
    }

    @FindBy(id = "login_link")
    WebElement loginTab;

    public RegisterPage clickLoginOrRegister() {
        loginTab.click();
        return new RegisterPage(driver);
    }

    @FindBy(id = "logout_link")
    WebElement logOutTab;

    public boolean isLogoutTabPresent() {
        return logOutTab.isDisplayed();
    }

    public HomePage clickLogout() {
        logOutTab.click();
        return this;
    }

    @FindBy(css = ".icon-user")
    WebElement accountTab;

    public AccountPage clickAccount() {
        accountTab.click();
        return new AccountPage(driver);
    }

    @FindBy(xpath = "//li[@class='dropdown-submenu']")
    WebElement booksSubMenuTab;


    public BooksPage chooseBooksMenu() {
        booksSubMenuTab.click();
        return new BooksPage(driver);
    }

    public boolean isLoginOrRegisterPresent() {
        return loginTab.isDisplayed();
    }

    @FindBy(xpath = "//a[@href='/en-gb/catalogue/']")
    WebElement allProductCatalogue;

    public ProductPage openProductCatalogue() {
        allProductCatalogue.click();
        return new ProductPage(driver);

    }

    @FindBy(xpath = "//div[@class='sub-header'][contains(.,'Welcome')]")
    WebElement welcomeGreetingsHeader;

    public boolean isWelcomeGreetingsPresent() {
        return welcomeGreetingsHeader.isDisplayed();
    }
}
