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

    public boolean isBasketTitlePresent() {
        return basketTitle.isDisplayed();
    }

}
