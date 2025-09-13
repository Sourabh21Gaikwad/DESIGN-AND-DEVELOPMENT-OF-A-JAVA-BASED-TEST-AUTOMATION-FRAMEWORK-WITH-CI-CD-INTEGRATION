package com.sourabh.framework.pages;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {

    // Define locators for the login page elements

    @FindBy(xpath = "//input[@name='username']")
    private WebElement usernameField;
    @FindBy(xpath = "//input[@name='password']")
    private WebElement userpassword;
    @FindBy(xpath = "//*[@type='submit']")
    private WebElement loginBtn;

    // Method to perform login
    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

    public void doLogin(String username, String password) throws InterruptedException {
        try {
            enterText(usernameField, username);
            enterText(userpassword, password);
            clickElement(loginBtn);
        } catch (Exception e) {
            System.out.println("❌ Failed to perform login | Reason: " + e.getMessage());
            throw e;
        }
    }
}
