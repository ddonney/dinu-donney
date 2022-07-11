package com.automation.demo.testutil.listeners;

/**
 * Author: dinudonney
 * Date: 11/07/22
 */
import com.automation.demo.init.TestBase;
import com.automation.demo.testutil.extentreports.ExtentManager;
import com.automation.demo.testutil.logs.Log;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.util.Objects;

import static com.automation.demo.testutil.extentreports.ExtentTestManager.getTest;

public class TestListener extends TestBase implements ITestListener {

    private static String getTestMethodName(ITestResult iTestResult) {
        return iTestResult.getMethod().getConstructorOrMethod().getName();
    }

    public void onStart(ITestContext iTestContext) {
        Log.info("Started Method: " + iTestContext.getName());
        iTestContext.setAttribute("WebDriver", driver);
    }

    public void onFinish(ITestContext iTestContext) {
        Log.info("Finished Method: " + iTestContext.getName());
        //Do tier down operations for ExtentReports reporting!
        ExtentManager.extentReports.flush();
    }

    public void onTestStart(ITestResult iTestResult) {
        Log.info(getTestMethodName(iTestResult) + " Test Started.");
    }

    public void onTestSuccess(ITestResult iTestResult) {
        Log.info(getTestMethodName(iTestResult) + " Test Success.");
        //ExtentReports log operation for passed tests.
        getTest().log(Status.PASS, "Test Passed");
    }

    public void onTestFailure(ITestResult iTestResult) {
        Log.info(getTestMethodName(iTestResult) + " Test Failed.");
        //Get driver from BaseTest and assign to local web-driver variable.
        Object testClass = iTestResult.getInstance();
        WebDriver driver = ((TestBase) testClass).getDriver();
        //Take base64Screenshot screenshot for extent reports
        String base64Screenshot = "data:image/png;base64," + ((TakesScreenshot) Objects.requireNonNull(driver)).getScreenshotAs(OutputType.BASE64);
        //ExtentReports log and screenshot operations for failed tests.
        getTest().log(Status.FAIL, "Test Failed", getTest().addScreenCaptureFromBase64String(base64Screenshot).getModel().getMedia().get(0));
    }

    public void onTestSkipped(ITestResult iTestResult) {
        Log.info(getTestMethodName(iTestResult) + " Test Skipped.");
        //ExtentReports log operation for skipped tests.
        getTest().log(Status.SKIP, "Test Skipped");
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
        Log.info("Test Failed but is in defined success ratio " + getTestMethodName(iTestResult));
    }
}
