package com.oscar.tests;

import com.oscar.pages.HomePage;
import com.oscar.pages.RegisterPage;
import com.oscar.utils.DataProviders;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPageTests extends TestBase {
    @BeforeMethod
    public void ensurePreconditions() {
        new HomePage(driver).clickLoginOrRegister();

    }

    @Test
    public void LoginPositiveTest(){
        new RegisterPage(driver).fillLoginForm("lola@ll.ua", "Lola1234$");
        Assert.assertTrue(new HomePage(driver).isLogoutTabPresent());
    }

    @Test(dataProviderClass= DataProviders.class, dataProvider = "loginNegativeEmailUsingFile")
    public void LoginNegativeEmailTest(String email){
        new RegisterPage(driver).fillLoginForm(email, "Lola1234$");
        Assert.assertTrue(new RegisterPage(driver).isLoginFormPresent());
    }
    @Test(dataProviderClass= DataProviders.class, dataProvider = "loginNegativePswdUsingFile")
    public void LoginNegativePswdTest(String pswd){
        new RegisterPage(driver).fillLoginForm("lola@ll.ua", pswd);
        Assert.assertTrue(new RegisterPage(driver).isLoginFormPresent());
    }
}
