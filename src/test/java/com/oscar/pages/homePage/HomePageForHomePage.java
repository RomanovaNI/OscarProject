package com.oscar.pages.homePage;

import com.oscar.pages.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePageForHomePage extends PageBase {

    public HomePageForHomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(name = "language")
    WebElement languageSelector;

    @FindBy (xpath = "//form[@id='language_selector']//button[@type='submit']")
    WebElement goTab;


    @FindBy(xpath = "//a[contains(.,'Oscar')]")
    WebElement homeIcon;

    @FindBy(xpath = "//strong[contains(.,'Basket total')]")
    WebElement basketTotal;

    @FindBy (xpath = "//span//a[@href='/en-gb/basket/']")
    WebElement viewBasketTab;

    @FindBy(id = "id_q")
    WebElement searchField;

    @FindBy(xpath = "//input[@type='submit']")
    WebElement searchTab;

    @FindBy(xpath = "//li[contains(.,'Browse store')]")
    WebElement browseStoreMenu;



    public boolean isLanguageSelectorPresent (){
      return   languageSelector.isDisplayed();
    }


    public boolean isGoBtnPresent() {
        return goTab.isDisplayed();
    }

    public boolean isHomeIconPresent() {
        return homeIcon.isDisplayed();
    }

    public boolean isSearchFieldPresent() {
        return searchField.isDisplayed();
    }

    public boolean isSearchBtnPresent() {
        return searchTab.isDisplayed();
    }

    public boolean isBasketTotalPresent() {
        return basketTotal.isDisplayed();
    }

    public boolean isViewBasketBtnPresent() {
        return viewBasketTab.isDisplayed();
    }
    public boolean isBrowseStoreMenuPresent() {
        return browseStoreMenu.isDisplayed();
    }

}
