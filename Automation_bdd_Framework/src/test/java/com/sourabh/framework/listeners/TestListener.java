package com.sourabh.framework.listeners;

import com.sourabh.framework.base.BaseTest;
import com.sourabh.framework.utils.ScreenshotUtil;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {
    @Override
    public void onTestFailure(ITestResult result) {
        WebDriver driver = BaseTest.getDriver();
        String methodName = result.getMethod().getMethodName();

        String screenshotPath = ScreenshotUtil.captureScreenshot(driver, methodName);
        System.out.println("❌ Test Failed! Screenshot saved at: " + screenshotPath);
    }

    // Optional: implement others if needed
    @Override
    public void onTestStart(ITestResult result) {
    }

    @Override
    public void onTestSuccess(ITestResult result) {
    }

    @Override
    public void onTestSkipped(ITestResult result) {
    }

    @Override
    public void onStart(ITestContext context) {
    }

    @Override
    public void onFinish(ITestContext context) {
        String screenshotDir = new java.io.File("target/screenshots").getAbsolutePath().replace("\\", "/");
        System.out.println("✅ All tests finished. If there were failures, screenshots are here:");
        System.out.println("📁 file:///" + screenshotDir);
    }
}
