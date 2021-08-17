package com.oscar.tests;

import com.oscar.pages.HomePage;
import com.oscar.pages.ProductPage;
import com.oscar.pages.RegisterPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegisterPageTests extends TestBase{
    HomePage homePage;
    RegisterPage registerPage;

    @BeforeMethod
    public void pageInit(){
        homePage= PageFactory.initElements(driver, HomePage.class);
        registerPage=PageFactory.initElements(driver, RegisterPage.class);

    }

    @Test
    public void registrationPositiveTest(){
        homePage.clickLogin().fillRegisterForm("lo"+System.currentTimeMillis()+"@lo.lo", "Lo123456%");
        Assert.assertTrue(homePage.isLogoutTabPresent());
    }

    @Test
    public void registrationNegativeEmailTest(){
        homePage.clickLogin().fillRegisterForm("@lo.lo", "Lo123456%");
        Assert.assertTrue(registerPage.isLoginTabPresent());

    }
    @Test
    public void registrationNegativePasswordTest(){
        homePage.clickLogin().fillRegisterForm("lo@lo.lo", "Lo123");
        Assert.assertTrue(registerPage.isErrorMsgPresent());

    }

}
