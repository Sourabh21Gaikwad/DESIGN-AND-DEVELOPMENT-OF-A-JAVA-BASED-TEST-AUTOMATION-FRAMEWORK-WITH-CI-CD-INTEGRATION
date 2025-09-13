package com.sourabh.framework.drivers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeDriverFactory {
    public static WebDriver getChromeDriver() {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }
}
