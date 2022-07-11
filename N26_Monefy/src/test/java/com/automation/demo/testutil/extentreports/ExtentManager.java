package com.automation.demo.testutil.extentreports;

/**
 * Author: dinudonney
 * Date: 11/07/22
 */
import com.automation.demo.utilities.ConfigFileReader;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {
    public static final ExtentReports extentReports = new ExtentReports();
    public synchronized static ExtentReports createExtentReports() {
        ConfigFileReader conf = new ConfigFileReader();
        ExtentSparkReporter reporter = new ExtentSparkReporter(conf.getValue("pathHTML"));
        reporter.config().setReportName("Test Report");
        extentReports.attachReporter(reporter);
        return extentReports;
    }
}
