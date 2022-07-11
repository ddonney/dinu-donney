package com.automation.demo.pages;

import com.automation.demo.utilities.ConfigFileReader;
import com.automation.demo.utilities.Wait;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

/**
 * Author: dinudonney
 * Date: 11/07/22
 */
public class TransactionPage {
    public TransactionPage(AppiumDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
    @AndroidFindBy(xpath = "//android.widget.ImageButton[contains(@content-desc,'navigation')]")
    WebElement btnBack;

    @AndroidFindBy(id = "com.monefy.app.lite:id/buttonKeyboard1")
    WebElement btn1;

    @AndroidFindBy(id = "com.monefy.app.lite:id/buttonKeyboard2")
    WebElement btn2;

    @AndroidFindBy(id = "com.monefy.app.lite:id/buttonKeyboard3")
    WebElement btn3;

    @AndroidFindBy(id = "com.monefy.app.lite:id/buttonKeyboard4")
    WebElement btn4;

    @AndroidFindBy(id = "com.monefy.app.lite:id/buttonKeyboard5")
    WebElement btn5;

    @AndroidFindBy(id = "com.monefy.app.lite:id/buttonKeyboard6")
    WebElement btn6;

    @AndroidFindBy(id = "com.monefy.app.lite:id/buttonKeyboard7")
    WebElement btn7;

    @AndroidFindBy(id = "com.monefy.app.lite:id/buttonKeyboard8")
    WebElement btn8;

    @AndroidFindBy(id = "com.monefy.app.lite:id/buttonKeyboard9")
    WebElement btn9;

    @AndroidFindBy(id = "com.monefy.app.lite:id/buttonKeyboard0")
    WebElement btn0;

    @AndroidFindBy(id = "com.monefy.app.lite:id/buttonKeyboardDot")
    WebElement btnDot;

    @AndroidFindBy(id = "com.monefy.app.lite:id/textViewNote")
    WebElement txtNote;

    @AndroidFindBy(id = "com.monefy.app.lite:id/keyboard_action_button")
    WebElement btnChooseCategory;

    @AndroidFindBy(xpath = "//android.view.ViewGroup/android.widget.TextView")
    WebElement btnTransactionType;

    @AndroidFindBy(id = "com.monefy.app.lite:id/show_keyboard_fab")
    WebElement btnKeypad;

    @AndroidFindBy(id = "com.monefy.app.lite:id/keyboard_action_button")
    WebElement btnAddTransfer;

    @AndroidFindBy(id = "com.monefy.app.lite:id/spinnerAccountFrom")
    WebElement ddFromAccount;

    @AndroidFindBy(id = "com.monefy.app.lite:id/spinnerAccountTo")
    WebElement ddToAccount;

    public void setAmount(String amount){
        for(int i=0;i<amount.length();i++){
            switch (amount.charAt(i)){
                case '0':
                    btn0.click();
                    break;
                case '1':
                    btn1.click();
                    break;
                case '2':
                    btn2.click();
                    break;
                case '3':
                    btn3.click();
                    break;
                case '4':
                    btn4.click();
                    break;
                case '5':
                    btn5.click();
                    break;
                case '6':
                    btn6.click();
                    break;
                case '7':
                    btn7.click();
                    break;
                case '8':
                    btn8.click();
                    break;
                case '9':
                    btn9.click();
                    break;
                case '.':
                    btnDot.click();
                    break;
            }
        }
    }

    public void addNote(String note){
        txtNote.sendKeys(note);
    }

    public void chooseCategory(AppiumDriver driver, String category){
        btnChooseCategory.click();
        int catLength = 16;
        if (btnTransactionType.getText().contains("income")){
            catLength = 4;
        }
        for(int i=1;i<catLength;i++){
            String xpath = "//android.widget.FrameLayout[" + i + "]/android.widget.LinearLayout/android.widget.TextView";
            if(driver.findElement(By.xpath(xpath)).getText().equalsIgnoreCase(category)){
                driver.findElement(By.xpath(xpath)).click();
                break;
            }
        }
    }

    public void openKeypad(AppiumDriver driver){
        Wait.until(driver,5,btnKeypad);
        btnKeypad.click();
    }

    public void addTransfer(){
        btnAddTransfer.click();
    }

    public void selectFromAccounts(AppiumDriver driver, String fromAccount){
        ConfigFileReader conf = new ConfigFileReader();
        ddFromAccount.click();
        if(driver.findElement(By.xpath(conf.getValue("xpath1"))).getText().equalsIgnoreCase(fromAccount)){
            Wait.until(driver,5,driver.findElement(By.xpath(conf.getValue("xpath1"))));
            driver.findElement(By.xpath(conf.getValue("xpath1"))).click();
        } else {
            Wait.until(driver,5,driver.findElement(By.xpath(conf.getValue("xpath2"))));
            driver.findElement(By.xpath(conf.getValue("xpath2"))).click();
        }
    }

    public void selectToAccounts(AppiumDriver driver, String toAccount){
        ConfigFileReader conf = new ConfigFileReader();
        ddToAccount.click();
        if(driver.findElement(By.xpath(conf.getValue("xpath2"))).getText().equalsIgnoreCase(toAccount)){
            Wait.until(driver,5,driver.findElement(By.xpath(conf.getValue("xpath2"))));
            driver.findElement(By.xpath(conf.getValue("xpath2"))).click();
        } else {
            Wait.until(driver,5,driver.findElement(By.xpath(conf.getValue("xpath1"))));
            driver.findElement(By.xpath(conf.getValue("xpath1"))).click();
        }
    }
}
