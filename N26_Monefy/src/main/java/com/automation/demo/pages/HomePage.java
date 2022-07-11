package com.automation.demo.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

/**
 * Author: dinudonney
 * Date: 11/07/22
 */
public class HomePage {
    public HomePage(AppiumDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
    @AndroidFindBy(accessibility = "Open navigation")
    WebElement btnNav;

    @AndroidFindBy(accessibility = "Settings")
    WebElement btnSettings;

    @AndroidFindBy(accessibility = "Search records")
    WebElement btnSearch;

    @AndroidFindBy(id = "com.monefy.app.lite:id/et_search")
    WebElement txtSearch;

    @AndroidFindBy(xpath = "//android.widget.ImageButton[contains(@content-desc,'navigation')]")
    WebElement btnBack;

    @AndroidFindBy(accessibility = "Transfer")
    WebElement btnTransfer;

    @AndroidFindBy(id = "com.monefy.app.lite:id/piegraph")
    WebElement imgPieGraph;

    @AndroidFindBy(id = "com.monefy.app.lite:id/leftLinesImageView")
    WebElement btnLeftBal;

    @AndroidFindBy(id = "com.monefy.app.lite:id/rightLinesImageView")
    WebElement btnRightBal;

    @AndroidFindBy(id = "com.monefy.app.lite:id/buttonChooseListSortingMode")
    WebElement btnToggleView;

    @AndroidFindBy(id = "com.monefy.app.lite:id/balance_amount")
    WebElement btnBalance;

    @AndroidFindBy(id = "com.monefy.app.lite:id/expense_button")
    WebElement btnExpense;

    @AndroidFindBy(id = "com.monefy.app.lite:id/income_button")
    WebElement btnIncome;

    @AndroidFindBy(id = "com.monefy.app.lite:id/income_amount_text")
    WebElement txtLabelIncome;

    @AndroidFindBy(id = "com.monefy.app.lite:id/expense_amount_text")
    WebElement txtLabelExpense;

    @AndroidFindBy(id = "com.monefy.app.lite:id/buttonBuyFullApp")
    WebElement btnPay;

    public boolean isHomePageDisplayed(){
        try {
            imgPieGraph.isDisplayed();
            btnNav.isDisplayed();
            btnSettings.isDisplayed();
            btnSearch.isDisplayed();
            btnTransfer.isDisplayed();
            btnLeftBal.isDisplayed();
            btnRightBal.isDisplayed();
            btnBalance.isDisplayed();
            btnExpense.isDisplayed();
            btnIncome.isDisplayed();
            txtLabelIncome.isDisplayed();
            txtLabelExpense.isDisplayed();
        } catch (NoSuchElementException e){
            return false;
        }
        return true;
    }

    public void openNav(){
        if(isHomePageDisplayed()){
            btnNav.click();
        }
    }

    public void openSettings(){
        if(isHomePageDisplayed()){
            btnSettings.click();
        }
    }

    public void Search(String searchText){
        if(isHomePageDisplayed()){
            btnSearch.click();
            txtSearch.clear();
            txtSearch.sendKeys(searchText);
        }
    }

    public void clickBack(){
        btnBack.click();
    }

    public void clickTransfer(){
        if(isHomePageDisplayed()){
            btnTransfer.click();
        }
    }

    public void clickExpense(){
        if(isHomePageDisplayed()){
            btnExpense.click();
        }
    }

    public void clickIncome(){
        if(isHomePageDisplayed()){
            btnIncome.click();
        }
    }

    public void clickBalance(){
        if(isHomePageDisplayed()){
            btnBalance.click();
        }
    }

    public void toggleView(){
        btnToggleView.click();
    }

    public void skipPay(AppiumDriver driver){
        if(btnPay.isDisplayed()){
            driver.navigate().back();
        }
    }
}
