package com.sefra.utils;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;

public class SeleniumUtil {

    private static Logger logger = Logger.getLogger(SeleniumUtil.class);

    public static void populateDropDown(WebDriver driver, By by, String value) {
        Select select = new Select(driver.findElement(by));
        select.selectByValue(value);
    }

    public static ExpectedCondition<WebElement> visibilityOfElementLocated(final By locator) {
        return new ExpectedCondition<WebElement>() {
            public WebElement apply(WebDriver driver) {
                WebElement toReturn = driver.findElement(locator);
                if (toReturn.isDisplayed()) {
                    return toReturn;
                }
                return null;
            }
        };
    }

    public static void populateTextBox(WebDriver driver, By by, String value) {
        WebElement inputElement = driver.findElement(by);
        if ("".equals(value)) {
            inputElement.clear();
        } else {
            inputElement.sendKeys(value);
        }
    }

    public static void checkRadio(WebDriver driver, By by) {
        WebElement inputElement = driver.findElement(by);
        inputElement.click();
    }


    public static void goToTab(WebDriver driver, By by) {
        waitUntilClickable(driver, by);
        driver.findElement(by).click();
    }

    public static WebElement waitForVisibility(WebDriver driver, By by) {
        return waitForVisibility(driver, by, 45);
    }

    public static WebElement waitUntilClickable(WebDriver driver, By by) {
        WebDriverWait wait = new WebDriverWait(driver, 45);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(by));
        return element;
    }

    public static WebElement waitForVisibility(WebDriver driver, By by, int waitTime) {
        Wait<WebDriver> wait = new WebDriverWait(driver, waitTime);
        WebElement divElement = wait.until(visibilityOfElementLocated(by));
        return divElement;
    }


    public static WebElement switchToNewWindow(WebDriver driver, String iframeId) {
        driver.switchTo().frame(iframeId);
        WebElement window = driver.switchTo().activeElement();
        return window;
    }


    public static WebElement findElement(WebDriver driver, By by, int timeoutInSeconds) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
            wait.until(ExpectedConditions.presenceOfElementLocated(by));
        } catch (TimeoutException e) {
            logger.error(e.getMessage(), e);
            e.printStackTrace();
            return null;
        }
        return driver.findElement(by);
    }

    public static boolean isEnabled(WebDriver driver, String eachField) {
        return (driver.findElement(By.id(eachField)).isEnabled());
    }

    public static boolean isDisabled(WebDriver driver, String eachField) {
        return (!driver.findElement(By.id(eachField)).isEnabled());
    }

    public static boolean isVisible(WebDriver driver, String eachField) {
        return (driver.findElement(By.id(eachField)).isDisplayed());
    }

    public static boolean isInvisible(WebDriver driver, String eachField) {
        return (!driver.findElement(By.id(eachField)).isDisplayed());
    }


    public static String captureScreenshot(WebDriver driver, String folder, String fileName) {

        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File targetFile = new File(folder, fileName + ".png");
        try {
            FileUtils.copyFile(screenshotFile, targetFile);
        } catch (IOException e) {
            logger.error("Error while writing file ", e);
        }

        return targetFile.getAbsolutePath();
    }
}