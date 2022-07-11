package com.automation.demo.tests;

import com.automation.demo.init.TestBase;
import com.automation.demo.managers.PageObjectManager;
import com.automation.demo.pages.HomePage;
import com.automation.demo.pages.OverlayPage;
import com.automation.demo.pages.TransactionPage;
import com.automation.demo.testutil.logs.Log;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.automation.demo.testutil.extentreports.ExtentTestManager.startTest;

/**
 * Author: dinudonney
 * Date: 11/07/22
 */
public class TestTransaction extends TestBase {
    @Test(priority = 0)
    public void openDashboard(){
        startTest(this.getClass().getSimpleName(), conf.getValue("TestDescription01"));
        PageObjectManager pageObjectManager = new PageObjectManager(driver);
        OverlayPage overlayPage = pageObjectManager.getOverlayPage();
        HomePage homePage = pageObjectManager.getHomePage();
        overlayPage.clickNext(driver);
        overlayPage.close();
        Log.info("Overlay Page has been closed successfully..!");
        Assert.assertTrue(homePage.isHomePageDisplayed());
        Log.info("Home Page has been loaded successfully..!");
    }

    @Test(priority = 1)
    public void transferAmount(){
        startTest(this.getClass().getSimpleName(), conf.getValue("TestDescription02"));
        PageObjectManager pageObjectManager = new PageObjectManager(driver);
        HomePage homePage = pageObjectManager.getHomePage();
        TransactionPage transactionPage = pageObjectManager.getTransactionPage();
        homePage.clickTransfer();
        transactionPage.addNote("Received Cash");
        transactionPage.selectFromAccounts(driver,"Cash");
        transactionPage.selectToAccounts(driver,"Payment Card");
        transactionPage.openKeypad(driver);
        transactionPage.setAmount("200");
        transactionPage.addTransfer();
        Assert.assertTrue(homePage.isHomePageDisplayed());
        Log.info("Transferred successfully..!");
    }

    @Test(priority = 2)
    public void addIncome(){
        startTest(this.getClass().getSimpleName(), conf.getValue("TestDescription03"));
        PageObjectManager pageObjectManager = new PageObjectManager(driver);
        HomePage homePage = pageObjectManager.getHomePage();
        TransactionPage transactionPage = pageObjectManager.getTransactionPage();
        homePage.clickIncome();
        transactionPage.setAmount("500");
        transactionPage.addNote("Stock Dividend");
        transactionPage.chooseCategory(driver,"Deposits");
        homePage.clickIncome();
        transactionPage.setAmount("1000");
        transactionPage.addNote("July Salary");
        transactionPage.chooseCategory(driver,"Salary");
        homePage.clickIncome();
        transactionPage.setAmount("300");
        transactionPage.addNote("Savings Bank Account");
        transactionPage.chooseCategory(driver,"Savings");
        homePage.skipPay(driver);
        Assert.assertTrue(homePage.isHomePageDisplayed());
        Log.info("Added Income successfully..!");
    }

    @Test(priority = 3)
    public void addExpense(){
        startTest(this.getClass().getSimpleName(), conf.getValue("TestDescription04"));
        PageObjectManager pageObjectManager = new PageObjectManager(driver);
        HomePage homePage = pageObjectManager.getHomePage();
        TransactionPage transactionPage = pageObjectManager.getTransactionPage();
        homePage.clickExpense();
        transactionPage.setAmount("10.25");
        transactionPage.addNote("Pet Grooming");
        transactionPage.chooseCategory(driver,"Pets");
        homePage.clickExpense();
        transactionPage.setAmount("13.75");
        transactionPage.addNote("Car Fuel");
        transactionPage.chooseCategory(driver,"Car");
        homePage.clickExpense();
        transactionPage.setAmount("17.33");
        transactionPage.addNote("Groceries");
        transactionPage.chooseCategory(driver,"Food");
        homePage.clickExpense();
        transactionPage.setAmount("6.55");
        transactionPage.addNote("Airport");
        transactionPage.chooseCategory(driver,"Taxi");
        homePage.clickExpense();
        transactionPage.setAmount("11.99");
        transactionPage.addNote("Checkup");
        transactionPage.chooseCategory(driver,"Health");
        Assert.assertTrue(homePage.isHomePageDisplayed());
        Log.info("Added Expenses successfully..!");
    }
}
