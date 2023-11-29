package org.example;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

public class Utils {

    //Captures screenshot using command and if test fails
    public static void captureScreenshot(String screenShotName)
    {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(source, new File("ScreenshotsTS\\" + screenShotName +timeStamp()+ ".png"));
            System.out.println("Screenshot taken");
        } catch (
                IOException e) {
            System.out.println("Exception while taking screenshot" + e.getMessage());
        }
    }

    protected static WebDriver driver;

    //Creates timestamp to return using the date in year, month, day, hour, minute and second
    public static String timeStamp(){
        String timeStamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new java.util.Date());
        return timeStamp;
    }

    //Clicks on element
    public static void clickElement(By by) {
        driver.findElement(by).click();
    }

    //Gets text from element
    public static String getTextFromElement(By by) {
        return driver.findElement(by).getText();
    }

    //Types text into element
    public static void typeText(By by, String string) {
        driver.findElement(by).sendKeys(string);
    }

    //Waits until element is invisible
    public static void waitForInvisible(By by, Duration timeout) {
        Duration timeoutSeconds = Duration.ofSeconds((int) (timeout.toMillis() / 1000));
        WebDriverWait wait = new WebDriverWait(driver, timeoutSeconds);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
    }

    //Waits until element is visible
    public static void waitForVisible(By by, Duration timeout) {
        Duration timeoutSeconds = Duration.ofSeconds((int) (timeout.toMillis() / 1000));
        WebDriverWait wait = new WebDriverWait(driver, timeoutSeconds);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    //Waits for element to be clickable
    public static void waitForClickable(By by, Duration timeout) {
        Duration timeoutSeconds = Duration.ofSeconds((int) (timeout.toMillis() / 1000));
        WebDriverWait wait = new WebDriverWait(driver, timeoutSeconds);
        wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    //Waits for element to disappear
    public static void waitForDisappear(By by, Duration timeout) {
        Duration timeoutSeconds = Duration.ofSeconds((int) (timeout.toMillis() / 1000));
        WebDriverWait wait = new WebDriverWait(driver, timeoutSeconds);

        //Waits for element to be invisible and not be clickable
        wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
        wait.until(ExpectedConditions.not(elementToBeClickable(by)));
    }

    //Waits for url to be
    public static void waitForURLToBe(String url, Duration timeout) {
        Duration timeoutSeconds = Duration. ofSeconds((int) (timeout.toMillis() / 1000));
        WebDriverWait wait = new WebDriverWait(driver, timeoutSeconds);
        wait.until(ExpectedConditions.urlToBe(url));
    }

    //Returns a list from a list of strings from a webpage
    public static String returnList(By by) {
        List<WebElement> listElements = driver.findElements(by);
        List <String> list = new ArrayList<>();
        for (WebElement element:listElements) {
            list.add(element.getText());
        }
        return list.toString();
    }

    public static void selectFromDropDownList(By by, int index) {
        Select select = new Select(driver.findElement(by));
        select.selectByIndex(index);
    }
}