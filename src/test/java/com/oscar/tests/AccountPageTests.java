package com.oscar.tests;

import com.oscar.pages.AccountPage;
import com.oscar.pages.BooksPage;
import com.oscar.pages.CheckoutPage;
import com.oscar.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AccountPageTests extends TestBase {
    @BeforeMethod
    public void ensurePreconditions() {
        new HomePage(driver).clickLoginOrRegister().fillLoginForm("lola@ll.ua", "Lola1234$");

    }

    @Test
    public void orderHistoryPositiveTest() {
        new HomePage(driver).chooseBooksMenu().addFirstItemToBasket();
        Assert.assertTrue(new BooksPage(driver).isConfirmMsgPresent());
        new BooksPage(driver).clickCheckout().fillShippingForm("Lola", "Ivanova", "Humboldt str", "Berlin", "13085", "Germany")
                .clickContinueFromPayment().clickPlaceOrder().clickContinueFromConfirmation()
                .clickAccount().clickOrderHistory();

        Assert.assertTrue(new AccountPage(driver).isOrderPresent());
    }

    @Test
    public void orderHistoryNegativeTest() {
        new HomePage(driver).chooseBooksMenu().addFirstItemToBasket();
        Assert.assertTrue(new BooksPage(driver).isConfirmMsgPresent());
        new BooksPage(driver).clickCheckout().fillShippingForm("Lola", "Ivanova", "Humboldt str", "Berlin", "1085", "Germany");

        Assert.assertTrue(new CheckoutPage(driver).isErrorMsgIndexPresent());
    }

    @Test
    public void changePswdPositiveTest() {
        String oldPswd = "Lola1234$";
        String newPswd = "LoLo1234%";
        new HomePage(driver).clickAccount().clickChangePswd().fillChangePswdForm(oldPswd, newPswd).clickEmailHistory();

        Assert.assertTrue(new AccountPage(driver).isPswdChangedSubjectPresent());
        //  Assert.assertTrue(new AccountPage(driver).isPswdUpdatedPresent());
    }

    @Test
    public void changePswdNegativeTest() {
        String oldPswd = "Lola1234$";
        String newPswd = "12345";
        new HomePage(driver).clickAccount().clickChangePswd().fillChangePswdForm(oldPswd, newPswd);
        Assert.assertTrue(new AccountPage(driver).isErrorMsgPresent());

    }

    @Test
    public void editProfileInfoTest() {
        new HomePage(driver).clickAccount().clickEditProfile().filleditProfileForm("Lola");
        Assert.assertTrue(new AccountPage(driver).isProfileUpdatedPresent());
    }

    @Test
    public void addNewAddressPositiveTest() {
        new HomePage(driver).clickAccount().clickAddressBook().clickAddNewAddress()
                .fillAddressForm("Ms", "Lola", "Ivanova", "Humboldt str", "Berlin", "13086", "Germany", "3rd floor");
        Assert.assertTrue(new AccountPage(driver).isSuccessAlertPresent());
    }

    @Test
    public void addNewAddressNegativeTest() {
        new HomePage(driver).clickAccount().clickAddressBook().clickAddNewAddress()
                .fillAddressForm("Ms", "Lola", "Ivanova", "Humboldt str", "Berlin", "130", "Russian Federation", "3rd floor");
        Assert.assertTrue(new AccountPage(driver).isErrorMsgPresent());
    }

    @Test
    public void alertProductInAccountTest() {
        new HomePage(driver).chooseBooksMenu().chooseEssenProgrammingSection().chooseUnavailbleBook()
                .clickNotifyMe();
        new HomePage(driver).clickAccount().clickProductAlert();

        Assert.assertTrue(new AccountPage(driver).isBookContainsText("Agile Retrospective"));


    }

    @Test
    public void addToWishListTest() {
        String pswd = "Lo123456%";
        new HomePage(driver).clickLogout().clickLoginOrRegister()
                .fillRegisterForm("lo" + System.currentTimeMillis() + "@lo.lo", pswd)
                .chooseBooksMenu().clickNextBtn().chooseHackersBook().clickAddToWishList();

        new HomePage(driver).clickAccount().clickWishLists().clickDeafaultList();
        Assert.assertTrue(new AccountPage(driver).isBookContainsText("Hackers"));
        new HomePage(driver).clickAccount().deleteAccount(pswd);
    }


}
