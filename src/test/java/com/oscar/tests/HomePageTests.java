package com.oscar.tests;

import com.oscar.pages.HomePage;
import com.oscar.pages.ProductPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTests extends TestBase{
    HomePage homePage;
    ProductPage productPage;

    @BeforeMethod
    public void pageInit(){
        homePage= PageFactory.initElements(driver, HomePage.class);
    productPage=PageFactory.initElements(driver, ProductPage.class);

    }

    @Test
    public void userCanSelectProductMenuTets(){
        homePage.selectCategory();
        Assert.assertTrue(productPage.isProductPage());
    }
}
