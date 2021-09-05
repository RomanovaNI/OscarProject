package com.oscar.tests;

import com.oscar.pages.BasketPage;
import com.oscar.pages.CheckoutPage;
import com.oscar.pages.HomePage;
import com.oscar.pages.homePage.HomePageForHomePage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BasketPageTests extends TestBase {
    @BeforeMethod
    public void ensurePreconditions() {
        new HomePage(driver).chooseBooksMenu().clickNextBtn().chooseHackersBook().addItemToBasket();
        new HomePageForHomePage(driver).goToBasket();
    }

    @Test
    public void checkTotalPriceAfterUpdateTest() {
        String priceForOneItem = new BasketPage(driver).savePriceOfOneItem();
        new BasketPage(driver).changeQuantity("2");
        Assert.assertNotEquals(new BasketPage(driver).checkTotalPrice(), priceForOneItem);
    }

    @Test
    public void deleteItemFromBasketTest() {
        new BasketPage(driver).changeQuantity("0");
        Assert.assertTrue(new BasketPage(driver).isEmptyBasketAlertPresenrt());
    }

    @Test
    public void checkDeleteItemFromBasketByTitleTest() {
        new HomePageForHomePage(driver).clickOscarIcon();
        new HomePage(driver).chooseBooksMenu().addFirstItemToBasket();
        new HomePageForHomePage(driver).goToBasket();
        String bookName = new BasketPage(driver).saveBookname();
        new BasketPage(driver).changeQuantity("0");
        Assert.assertNotEquals(new BasketPage(driver).checkNameOfBookAfterDelete(), bookName);
    }

    @Test
    public void checkDeleteItemFromBasketByPriceTest() {
        new HomePageForHomePage(driver).clickOscarIcon();
        new HomePage(driver).chooseBooksMenu().addFirstItemToBasket();
        new HomePageForHomePage(driver).goToBasket();
        String totalPrice = new BasketPage(driver).checkTotalPrice();
        new BasketPage(driver).changeQuantity("0");
        Assert.assertNotEquals(new BasketPage(driver).checkTotalPriceAfterDelete(), totalPrice);
    }

    @Test
    public void checkOutAsUnregisteredUser() {
        new BasketPage(driver).proceedToCheckout().chooseNewCustomerAndCreateAccount();
        Assert.assertTrue(new CheckoutPage(driver).isWhoRUPresent());
    }
}
