package com.automation.demo.utilities;

/**
 * Author: dinudonney
 * Date: 11/07/22
 */
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Wait {
    public static void until(AppiumDriver driver, int timeOutInSeconds, WebElement element) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(timeOutInSeconds));
        try {
            webDriverWait.until(ExpectedConditions.visibilityOf(element));
        } catch (StaleElementReferenceException s){
            // Log.info(s.getMessage());
        }
        catch (Exception e) {
            // Log.info(e.getMessage());
        }
    }
}
