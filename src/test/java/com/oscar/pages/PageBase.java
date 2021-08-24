package com.oscar.pages;

import com.google.common.io.Files;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class PageBase {
    protected WebDriver driver;

    public PageBase(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void type(WebElement element, String text) {
        if (text != null) {
            element.click();
            element.clear();
            element.sendKeys(text);
        }
    }
    public void pause(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void selectDropDownbyValue(WebElement element, String value){
        Select select =new Select(element);
        select.selectByValue(value);
    }

    public String takeScreenshot() {
        File tmp = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File screenshot = new File("screenshot/screen" + System.currentTimeMillis() + ".png");
        try {
            Files.copy(tmp, screenshot);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return screenshot.getAbsolutePath();
    }

    public Screenshot takeScreenshotWithScrollDown() {

        Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000))
                .takeScreenshot(driver);
        try {
            ImageIO.write(screenshot.getImage(), "PNG",
                    new File("screenshot/screen" + System.currentTimeMillis() + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return screenshot;
    }

}
