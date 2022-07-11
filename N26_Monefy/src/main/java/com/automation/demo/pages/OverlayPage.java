package com.automation.demo.pages;

/**
 * Author: dinudonney
 * Date: 08/07/22
 */

import com.automation.demo.utilities.Wait;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class OverlayPage {

    public OverlayPage(AppiumDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
    @AndroidFindBy(id = "com.monefy.app.lite:id/buttonContinue")
    WebElement btnNext;

    @AndroidFindBy(id = "com.monefy.app.lite:id/textViewHeader")
    WebElement headerLabel;

    @AndroidFindBy(id = "com.monefy.app.lite:id/textViewDetails")
    WebElement txtLabel;

    @AndroidFindBy(id = "com.monefy.app.lite:id/buttonClose")
    WebElement btnClose;

    @AndroidFindBy(id = "com.monefy.app.lite:id/buttonPurchase")
    WebElement btnPurchase;

    public boolean isOverlayPageDisplayed(){
        try {
            headerLabel.isDisplayed();
            txtLabel.isDisplayed();
            btnNext.isDisplayed();
        } catch (NoSuchElementException e){
            return false;
        }
        return true;
    }

    public void clickNext(AppiumDriver driver) {
        if(isOverlayPageDisplayed()){
            btnNext.click();
            Wait.until(driver, 5, btnNext);
            clickNext(driver);
        }
    }

    public void close(){
        btnClose.click();
    }

    public void purchase(){
        btnPurchase.click();
    }
}
