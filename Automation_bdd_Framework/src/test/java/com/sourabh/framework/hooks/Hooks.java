package com.sourabh.framework.hooks;

import com.sourabh.framework.base.BaseTest;
import com.sourabh.framework.pages.LoginPage;
import com.sourabh.framework.stepdefs.CommonSteps;
import com.sourabh.framework.utils.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;


public class Hooks {

    WebDriver driver;

    @Before
    public void setUp() throws InterruptedException {
        // Defaulting to chrome or read from system property
        String browser = System.getProperty("browser", "chrome");
        driver = DriverFactory.initDriver(browser);
        BaseTest.setDriver(driver);
        System.out.println("🔥 Setting up the driver for browser: " + browser);
        CommonSteps.loginToApp();
        LoginPage loginPage = new LoginPage();
        loginPage.doLogin("admin", "admin123");
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            BaseTest.unloadDriver();
        }
    }
}
