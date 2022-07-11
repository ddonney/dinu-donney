package com.automation.demo.managers;

import com.automation.demo.pages.HomePage;
import com.automation.demo.pages.OverlayPage;
import com.automation.demo.pages.TransactionPage;
import io.appium.java_client.AppiumDriver;

/**
 * Author: dinudonney
 * Date: 11/07/22
 */
public class PageObjectManager {

    private final AppiumDriver driver;
    private OverlayPage overlayPage;
    private HomePage homePage;
    private TransactionPage transactionPage;

    public PageObjectManager(AppiumDriver driver) {
        this.driver = driver;
    }

    public OverlayPage getOverlayPage(){
        return (overlayPage == null) ? overlayPage = new OverlayPage(driver) : overlayPage;
    }

    public HomePage getHomePage(){
        return (homePage == null) ? homePage = new HomePage(driver) : homePage;
    }

    public TransactionPage getTransactionPage(){
        return (transactionPage == null) ? transactionPage = new TransactionPage(driver) : transactionPage;
    }
}
