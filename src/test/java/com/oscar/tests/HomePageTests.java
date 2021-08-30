package com.oscar.tests;

import com.oscar.pages.HomePage;
import com.oscar.pages.ProductPage;
import com.oscar.pages.homePage.HomePageForHomePage;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTests extends TestBase {
    HomePage homePage;
    ProductPage productPage;
    HomePageForHomePage homePageForHomePage;

    @BeforeMethod
    public void pageInit() {
        homePage = PageFactory.initElements(driver, HomePage.class);
        productPage = PageFactory.initElements(driver, ProductPage.class);
        homePageForHomePage = PageFactory.initElements(driver, HomePageForHomePage.class);

    }

    @Test
    public void userCanSelectProductMenuTests() {
        homePage.selectCategory();
        Assert.assertTrue(productPage.isProductPage());
    }

    @Test
    public void isElementsVisibleTests() {
        Assert.assertTrue(homePageForHomePage.isLanguageSelectorPresent());
        Assert.assertTrue(homePageForHomePage.isGoBtnPresent());
        Assert.assertTrue(homePageForHomePage.isHomeIconPresent());
        Assert.assertTrue(homePageForHomePage.isSearchFieldPresent());
        Assert.assertTrue(homePageForHomePage.isSearchBtnPresent());
        Assert.assertTrue(homePageForHomePage.isBasketTotalPresent());
        Assert.assertTrue(homePageForHomePage.isViewBasketBtnPresent());
        Assert.assertTrue(homePage.isLoginOrRegisterPresent());
        Assert.assertTrue(homePageForHomePage.isBrowseStoreMenuPresent());

    }
}
