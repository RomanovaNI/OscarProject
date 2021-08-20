package com.oscar.tests;

import com.oscar.pages.HomePage;
import com.oscar.pages.RegisterPage;
import com.oscar.utils.DataProviders;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class RegisterPageTests extends TestBase{
    HomePage homePage;
    RegisterPage registerPage;

    @BeforeMethod
    public void pageInit(){
        homePage= PageFactory.initElements(driver, HomePage.class);
        registerPage=PageFactory.initElements(driver, RegisterPage.class);

    }

    @Test(priority = 2)
    public void registrationPositiveTest(){
        String pswd="Lo123456%";
        homePage.clickLoginOrRegister().fillRegisterForm("lo"+System.currentTimeMillis()+"@lo.lo", pswd);
       // homePage.clickLoginOrRegister().fillRegisterForm("lo@lo.lo", "lololololololo");
        Assert.assertTrue(homePage.isLogoutTabPresent());
        homePage.clickAccount().deleteAccount(pswd);
        Assert.assertTrue(registerPage.isLoginTabPresent());

    }

    @Test(priority = 1)
    public void registrationNegativeEmailTest(){
        homePage.clickLoginOrRegister().fillRegisterForm("@lo.lo", "Lo123456%");
        Assert.assertTrue(registerPage.isLoginTabPresent());

    }
    @Test
    public void registrationNegativePasswordTest(){
        homePage.clickLoginOrRegister().fillRegisterForm("lo@lo.lo", "Lo123");
        Assert.assertTrue(registerPage.isErrorMsgPresent());

    }
    @Test (dataProviderClass= DataProviders.class, dataProvider = "registerNegativeEmailUsingFile")
    public void registrationNegativeEmailDataProviderTest(String email){
        homePage.clickLoginOrRegister().fillRegisterForm(email, "Lo123456%");
        Assert.assertTrue(registerPage.isLoginTabPresent());

    }
    @Test(dataProviderClass= DataProviders.class, dataProvider = "registerNegativePswdUsingFile", priority = 3)
    public void registrationNegativePasswordDataProviderTest(String pswd){
        //homePage.clickLoginOrRegister().fillRegisterForm("lo@lo.lo", pswd);
        new HomePage(driver).clickLoginOrRegister().fillRegisterForm("lo@lo.lo", pswd);
        Assert.assertTrue(registerPage.isErrorMsgPresent());

    }
}
