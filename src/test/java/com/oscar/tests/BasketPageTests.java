package com.oscar.tests;

import com.oscar.pages.BasketPage;
import com.oscar.pages.CheckoutPage;
import com.oscar.pages.HomePage;
import com.oscar.pages.homePage.HomePageForHomePage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class BasketPageTests extends TestBase {
    @BeforeMethod
    public void ensurePreconditions() {
        new HomePage(driver).chooseBooksMenu().clickNextBtn().chooseHackersBook().addItemToBasket();
        new HomePageForHomePage(driver).goToBasket();
    }

    @Test
    public void checkTotalPriceAfterUpdateTest1() {
        String priceForOneItem = new BasketPage(driver).savePriceOfOneItem();
        new BasketPage(driver).changeQuantity("2");
        Assert.assertNotEquals(new BasketPage(driver).checkTotalPrice(), priceForOneItem);
    }

    @Test
    public void checkTotalPriceAfterUpdateTest2() {
        double price = new BasketPage(driver).getPrice();
        System.out.println(price);
        new BasketPage(driver).changeQuantity("2");
        Assert.assertEquals(new BasketPage(driver).getPrice(), price * 2);
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

        new BasketPage(driver).changeQuantity("0");
        Assert.assertFalse(new BasketPage(driver).getItemTitleList("Hackers"));
    }

    @Test
    public void checkDeleteItemFromBasketByQuantityTest() {
        new HomePageForHomePage(driver).clickOscarIcon();
        new HomePage(driver).chooseBooksMenu().addFirstItemToBasket();
        new HomePageForHomePage(driver).goToBasket();
        int itemList = new BasketPage(driver).getItemCountList();
        new BasketPage(driver).changeQuantity("0");
        Assert.assertEquals(new BasketPage(driver).getItemCountList(), itemList - 1);
    }

    @Test
    public void checkDeleteItemFromBasketByPriceTest() {
        new HomePageForHomePage(driver).clickOscarIcon();
        new HomePage(driver).chooseBooksMenu().addFirstItemToBasket();
        new HomePageForHomePage(driver).goToBasket();
        double priceFirstItem = new BasketPage(driver).getPrice();
        double priceTotalBasket = new BasketPage(driver).getTotalPriceInTotals();
        System.out.println(priceFirstItem);
        System.out.println(priceTotalBasket);
        new BasketPage(driver).changeQuantity("0");
        double priceAfterDelete = new BasketPage(driver).getTotalPriceInTotals();
        System.out.println(priceAfterDelete);
        Assert.assertEquals(priceAfterDelete, priceTotalBasket - priceFirstItem, 0.01);
    }

    @Test
    public void checkOutAsUnregisteredUser() {
        new BasketPage(driver).proceedToCheckout().chooseNewCustomerAndCreateAccount();
        Assert.assertTrue(new CheckoutPage(driver).isWhoRUPresent());
    }
}
