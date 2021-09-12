package com.oscar.addition;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class BrokenImagesTests {
    WebDriver driver;
    String URL = "https://the-internet.herokuapp.com/broken_images";
    String status;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(URL);

    }

    @Test
    public void brokenImageTestWithAttribute() {
        //find all the images on the page
        Integer brokenImageCount = 0;
        try {
            List<WebElement> imageList = driver.findElements(By.tagName("img"));
            //Print the total of images on the page
            System.out.println("The page has " + imageList.size() + " images");
            for (WebElement img : imageList) {
                if (img != null) {
                    //Read the naturalWidth attribute
                    if (img.getAttribute("naturalWidth").equals("0")) {
                        System.out.println(img.getAttribute("outerHTML") + " is broken.");
                        brokenImageCount++;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            status = "failed";
            System.out.println(e.getMessage());
        }
        status = "passed";
        System.out.println("The page " + URL + " has " + brokenImageCount + " broken images");

    }

    @Test
    public void brokenImageTestWithHttpClient() {
        //find all the images on the page
        Integer brokenImageCount = 0;
        try {
            List<WebElement> imageList = driver.findElements(By.tagName("img"));
            //Print the total of images on the page
            System.out.println("The page has " + imageList.size() + " images");
            for (WebElement img : imageList) {
                if (img != null) {
                    HttpClient client = HttpClientBuilder.create().build();
                    //Create a new instance of HttpGet
                    HttpGet request = new HttpGet(img.getAttribute("src"));
                    //Receive the response object
                    HttpResponse response = client.execute(request);
                    //Read status code
                    if (response.getStatusLine().getStatusCode() != 200) {
                        System.out.println(img.getAttribute("outerHTML") + " is broken");
                    brokenImageCount++;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            status = "failed";
            System.out.println(e.getMessage());
        }
        status = "passed";
        System.out.println("The page " + URL + " has " + brokenImageCount + " broken images");

    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
