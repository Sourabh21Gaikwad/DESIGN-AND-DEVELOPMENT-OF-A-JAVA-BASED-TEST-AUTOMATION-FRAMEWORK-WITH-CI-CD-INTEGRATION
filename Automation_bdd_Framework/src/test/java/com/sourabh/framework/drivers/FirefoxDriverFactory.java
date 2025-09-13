package com.sourabh.framework.drivers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxDriverFactory {
    public static WebDriver getFirefoxDriver() {
        WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver(); // Correct instantiation of FirefoxDriver
    }
}
