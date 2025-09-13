package com.sourabh.framework.stepdefs;

import com.sourabh.framework.base.BaseTest;
import com.sourabh.framework.pages.BasePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminSteps extends BasePage {
    WebDriver driver;
    @FindBy(xpath = "//a[contains(@href,'admin')]")
    private WebElement adminLink;

    @FindBy(xpath = "//button[contains(@class,'menu-button')]")
    private WebElement menuButton;

    @FindBy(xpath = "//button[contains(@class,'oxd-button--ghost')]")
    private WebElement resetBtnOnAdminPage;

    @FindBy(xpath = "(//input[contains(@class,'input--active')])[2]")
    private WebElement adminUserName;

    @FindBy(xpath = "//label[text()='User Role']/following::div[contains(@class,'oxd-select-wrapper')][1]")
    private WebElement adminUserRoleDropdown;

    @FindBy(xpath = "//div[@role='listbox']//span[text()='Admin']")
    private WebElement adminUserRoleOptionValue;

    @FindBy(xpath = "//div[@role='listbox']")
    private WebElement adminUserRoleDropdownList;

    @FindBy(xpath = "//input[contains(@placeholder,'Type for hints...')]")
    private WebElement adminEmployeeNameInput;

    @FindBy(xpath = "(//*[text()='-- Select --'])[2]")
    private WebElement adminStatusDropdown;

    @FindBy(xpath = "//button[contains(@class,'orangehrm-left-space')]")
    private WebElement adminSearchButton;
    private String username;

    public AdminSteps() {
        driver = BaseTest.getDriver();
        PageFactory.initElements(driver, this);
    }

    @When("I navigate to the dashboard")
    public void navigateAndVerifyTheDashboard() throws InterruptedException {
        Thread.sleep(2000); // Wait for the page to load
        clickElement(adminLink);
    }


    @And("enter the employee name {string}")
    public void enterTheEmployeeName(String name) {
        enterText(adminEmployeeNameInput, name);
    }

    @And("select the role {string}")
    public void selectTheRole(String role) throws InterruptedException {
        clickElement(adminUserRoleDropdown);
        waitUntilAndClick(adminUserRoleOptionValue,role);
    }

    @Then("enter the username {string}")
    public void enterTheUsername(String username) {
        this.username = username;
        enterText(adminUserName, username);
    }

    @And("select the status {string}")
    public void selectTheStatus(String status) throws InterruptedException {
        selectDropdownByText(adminStatusDropdown, status);

    }

    @Then("click on the search button")
    public void clickOnTheSearchButton() throws InterruptedException {
        clickElement(adminSearchButton);
    }

}
