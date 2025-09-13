package com.sourabh.framework.base;

import org.openqa.selenium.WebDriver;

public class BaseTest {
    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void setDriver(WebDriver driverInstance) {
        driver.set(driverInstance);
    }

    public static void unloadDriver() {
        driver.remove();
    }
}
