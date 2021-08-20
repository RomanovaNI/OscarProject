package com.oscar.tests;

import com.oscar.pages.AccountPage;
import com.oscar.pages.BooksPage;
import com.oscar.pages.CheckoutPage;
import com.oscar.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AccountPageTest extends TestBase{
    @BeforeMethod
    public void ensurePreconditions() {
        new HomePage(driver).clickLoginOrRegister().fillLoginForm("lola@ll.ua", "Lola1234$");

    }
    @Test
    public void orderHistoryPositiveTest(){
        new HomePage(driver).chooseBooksMenu().addItemToBasket();
        Assert.assertTrue(new BooksPage(driver).isConfirmMsgPresent());
        new BooksPage(driver).clickCheckout().fillShippingForm("Lola", "Ivanova", "Humboldt str", "Berlin","13085", "Germany")
                .clickContinueFromPayment().clickPlaceOrder().clickContinueFromConfirmation()
                .clickAccount().clickOrderHistory();

        Assert.assertTrue(new AccountPage(driver).isOrderPresent());
    }

    @Test
    public void orderHistoryNegativeTest(){
        new HomePage(driver).chooseBooksMenu().addItemToBasket();
        Assert.assertTrue(new BooksPage(driver).isConfirmMsgPresent());
        new BooksPage(driver).clickCheckout().fillShippingForm("Lola", "Ivanova", "Humboldt str", "Berlin","1085", "Germany");

        Assert.assertTrue(new CheckoutPage(driver).isErrorMsgIndexPresent());
    }
}
