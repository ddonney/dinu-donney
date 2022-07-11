package com.automation.demo.init;

/**
 * Author: dinudonney
 * Date: 08/07/22
 */

import com.automation.demo.utilities.ConfigFileReader;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class TestBase {

    protected static AppiumDriver driver;
    protected static final ConfigFileReader conf = new ConfigFileReader();

    public AppiumDriver getDriver(){
        return driver;
    }

    @BeforeTest
    public void setDriver() throws MalformedURLException {
        //Set up desired capabilities and pass the Android app-activity and app-package to Appium
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "emulator-5554");
        capabilities.setCapability("noReset", false);
        capabilities.setCapability("app", System.getProperty("user.dir") + conf.getValue("appPath"));
        capabilities.setCapability("appPackage", "com.monefy.app.lite");
        capabilities.setCapability("appActivity", "com.monefy.activities.main.MainActivity_");

        driver = new AndroidDriver(new URL(conf.getValue("url")), capabilities);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
    }

    @AfterTest
    public void quitDriver() {
        // Log.info("Closing Driver..!");
        driver.quit();
    }
}