package com.sourabh.framework.stepdefs;

import com.sourabh.framework.base.BaseTest;
import org.openqa.selenium.WebDriver;

public class CommonSteps {
    WebDriver driver;

    public static void loginToApp() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("🔥 Login step triggered!");
        WebDriver driver = BaseTest.getDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();
    }

}
