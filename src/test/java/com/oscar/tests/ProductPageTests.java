package com.oscar.tests;

import com.oscar.pages.HomePage;
import com.oscar.pages.ProductPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ProductPageTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        new HomePage(driver).openProductCatalogue();

    }

    @Test
    public void checkRedirectToFictionCategoryTest(){
        new ProductPage(driver).goToFictionCatalogue();
        Assert.assertTrue(new ProductPage(driver).isFictionCategoryDisplayed());
    }

    @Test
    public void checkRedirectToNonFictionCategoryTest(){
        new ProductPage(driver).goToNonFictionCatalogue();
        Assert.assertTrue(new ProductPage(driver).isNonFictionCategoryDisplayed());
    }
}
