package com.oscar.tests;

import com.oscar.pages.BasketPage;
import com.oscar.pages.HomePage;
import com.oscar.pages.ProductPage;
import com.oscar.pages.RegisterPage;
import com.oscar.pages.homePage.HomePageForHomePage;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTests extends TestBase {
    HomePage homePage;
    ProductPage productPage;
    HomePageForHomePage homePageForHomePage;
    RegisterPage registerPage;
    BasketPage basketPage;

    @BeforeMethod
    public void pageInit() {
        homePage = PageFactory.initElements(driver, HomePage.class);
        productPage = PageFactory.initElements(driver, ProductPage.class);
        homePageForHomePage = PageFactory.initElements(driver, HomePageForHomePage.class);
        registerPage = PageFactory.initElements(driver, RegisterPage.class);
        basketPage = PageFactory.initElements(driver, BasketPage.class);


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

    @Test
    public void isElementsClickableTests() {
        Assert.assertTrue(homePageForHomePage.isIconElementClickable());
        Assert.assertTrue(homePageForHomePage.isBrowseStoreElementClickable());
        Assert.assertTrue(homePageForHomePage.isBasketTotalElementClickable());
    }

    @Test
    public void isElementsRedirectToRegisterPageTests() {
        homePage.clickLoginOrRegister();
        Assert.assertTrue(registerPage.isLoginFormPresent());


    }

    @Test
    public void isElementsRedirectToProductPageTests() {
        homePage.selectCategory();
        Assert.assertTrue(productPage.isBookTitlePresent());


    }

    @Test
    public void isElementsRedirectToBasketPageTests() {
        homePageForHomePage.goToBasket();
        Assert.assertTrue(basketPage.isBasketTitlePresent());


    }
}
