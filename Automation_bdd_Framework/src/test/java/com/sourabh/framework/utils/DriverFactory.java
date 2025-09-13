package com.sourabh.framework.utils;

import com.sourabh.framework.drivers.ChromeDriverFactory;
import com.sourabh.framework.drivers.FirefoxDriverFactory;
import org.openqa.selenium.WebDriver;

public class DriverFactory {
    public static WebDriver initDriver(String browser) {
        switch (browser.toLowerCase()) {
            case "chrome":
                return ChromeDriverFactory.getChromeDriver();
            case "firefox":
                return FirefoxDriverFactory.getFirefoxDriver();
            default:
                throw new IllegalArgumentException("Browser not supported: " + browser);
        }
    }
}
