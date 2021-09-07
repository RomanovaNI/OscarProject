package com.oscar.tests;

import com.oscar.pages.BooksPage;
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
    public void checkRedirectToFictionCategoryTest() {
        new ProductPage(driver).goToFictionCatalogue();
        Assert.assertTrue(new ProductPage(driver).isFictionCategoryDisplayed());
    }

    @Test
    public void checkRedirectToNonFictionCategoryTest() {
        new ProductPage(driver).goToNonFictionCatalogue();
        Assert.assertTrue(new ProductPage(driver).isNonFictionCategoryDisplayed());
    }

    @Test
    public void verifyCorrectNameBookOnRedirectPageTest() {
        new BooksPage(driver).chooseEssenProgrammingSection();
        String bookNameFromList = new BooksPage(driver).getNameOfBookFromList(12);
        new BooksPage(driver).chooseBookFromTheList(12);
        String bookName=new BooksPage(driver).getNameOfBook();
        // Assert.assertTrue(new BooksPage(driver).isBookContainsText("Agile Retrospective"));
        Assert.assertEquals(bookName, bookNameFromList);
    }

    @Test
    public void addItemToBasketFromAllProductsPageTest() {
        new BooksPage(driver).addFirstItemToBasket();
        Assert.assertTrue(new BooksPage(driver).isConfirmMsgPresent());
    }

    @Test
    public void checkPaginationNextTest() {
        new BooksPage(driver).clickNextBtn().clickNextBtn();
        Assert.assertTrue(new BooksPage(driver).isPreviousBtnPresent());
    }

    @Test
    public void checkPaginationPreviousTest() {
        new BooksPage(driver).clickNextBtn().clickNextBtn().clickNextBtn().clickPreviousBtn();
        Assert.assertTrue(new BooksPage(driver).is3rdPagePresent());
    }

    @Test
    public void redirectToHomePageWithOscarIcon() {
        new ProductPage(driver).clickOscarIcon();
        Assert.assertTrue(new HomePage(driver).isWelcomeGreetingsPresent());
    }
}
