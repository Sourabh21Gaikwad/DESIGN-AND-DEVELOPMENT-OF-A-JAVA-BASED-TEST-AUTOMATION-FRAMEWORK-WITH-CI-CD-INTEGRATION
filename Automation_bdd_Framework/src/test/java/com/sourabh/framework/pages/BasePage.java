package com.sourabh.framework.pages;

import com.sourabh.framework.base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage() {
        this.driver = BaseTest.getDriver();
        // Initialize WebElements with PageFactory
        PageFactory.initElements(driver, this);
        // Setup explicit wait
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void clickElement(WebElement element) throws InterruptedException {
        try {
            Thread.sleep(2000);
            wait.until(ExpectedConditions.elementToBeClickable(element)).click();
        } catch (Exception e) {
            System.out.println("❌ Failed to click element: " + element + " | Reason: " + e.getMessage());
            throw e;
        }
    }

    public String getElementText(WebElement element) {
        try {
            return wait.until(ExpectedConditions.visibilityOf(element)).getText();
        } catch (Exception e) {
            System.out.println("❌ Failed to get text from element: " + element + " | Reason: " + e.getMessage());
            throw e;
        }
    }

    public void scrollDown() {
        try {
//            javascriptExecutor js = (JavascriptExecutor) driver;
//            js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
            ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,500);");
        } catch (Exception e) {
            System.out.println("❌ Failed to scroll down | Reason: " + e.getMessage());
            throw e;
        }

    }

    public void scrollToElement(WebElement element) throws InterruptedException {
        try {
            if (element.isDisplayed()) {
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", element);
                Thread.sleep(500); // helps with slow UI shifts
            } else {
                System.out.println("⚠️ Element is not displayed on page.");
            }
        } catch (Exception e) {
            System.out.println("❌ Failed to scroll to element: " + e.getMessage());
            throw e;
        }
    }


    public void enterText(WebElement element, String text) {
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
            element.clear();
            element.sendKeys(text);
        } catch (Exception e) {
            System.out.println("❌ Failed to enter text in element: " + element + " | Reason: " + e.getMessage());
            throw e;
        }

    }

    public void waitUntilAndClick(WebElement element,String role) {
        try {

            WebElement enabledOption = wait.until(ExpectedConditions.visibilityOfElementLocated((By) element));
            enabledOption.click();
        } catch (Exception e) {
            System.out.println("❌ Failed to wait for element | Reason: " + e.getMessage());
            throw e;
        }
    }

    public void moveToElement(WebElement element) {
        try {
            Actions actions = new Actions(driver);
            actions.moveToElement(element).perform();
        } catch (Exception e) {
            System.out.println("❌ Failed to move to element: " + element + " | Reason: " + e.getMessage());
            throw e;
        }
    }

    public void waitForVisibility(WebElement element) {
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
        } catch (Exception e) {
            System.out.println("❌ Failed to wait for visibility of element: " + element + " | Reason: " + e.getMessage());
            throw e;
        }
    }

    public void waitForClickability(WebElement element) {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(element));
        } catch (Exception e) {
            System.out.println("❌ Failed to wait for clickability of element: " + element + " | Reason: " + e.getMessage());
            throw e;
        }
    }

    public void jsClick(WebElement element) {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(element));
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
        } catch (Exception e) {
            System.out.println("❌ Failed to perform JS click on element: " + element + " | Reason: " + e.getMessage());
        }
    }

    //Switch to frame by index
    public void switchToFrameByIndex(int index) {
        try {
            driver.switchTo().frame(index);
        } catch (Exception e) {
            System.out.println("❌ Failed to switch to frame by index: " + index + " | Reason: " + e.getMessage());
            throw e;
        }
    }

    //Switch to frame by name or ID
    public void switchToFrameByName(String nameOrId) {
        try {
            driver.switchTo().frame(nameOrId);
        } catch (Exception e) {
            System.out.println("❌ Failed to switch to frame by name or ID: " + nameOrId + " | Reason: " + e.getMessage());
            throw e;
        }
    }

    //Switch to frame by WebElement
    public void switchToFrameByElement(WebElement frameElement) {
        try {
            driver.switchTo().frame(frameElement);
        } catch (Exception e) {
            System.out.println("❌ Failed to switch to frame by WebElement: " + frameElement + " | Reason: " + e.getMessage());
            throw e;
        }
    }

    //Switch back to default content
    public void switchToDefaultContent() {
        try {
            driver.switchTo().defaultContent();
        } catch (Exception e) {
            System.out.println("❌ Failed to switch back to default content | Reason: " + e.getMessage());
            throw e;
        }

    }

    //Select dropdown by visible text
    public void selectDropdownByVisibleText(WebElement dropdownElement, String visibleText) {
        try {
            Select select = new Select(dropdownElement);
            select.selectByVisibleText(visibleText);
        } catch (Exception e) {
            System.out.println("❌ Failed to switch back to default content | Reason: " + e.getMessage());
            throw e;
        }

    }

    //Select dropdown by value
    public void selectDropdownByValue(WebElement dropdownElement, String value) {
        try {
            Select select = new Select(dropdownElement);
            select.selectByValue(value);
        } catch (Exception e) {
            System.out.println("❌ Failed to select dropdown by value: " + value + " | Reason: " + e.getMessage());
            throw e;
        }

    }

    //Select dropdown by index
    public void selectDropdownByIndex(WebElement dropdownElement, int index) {
        try {
            Select select = new Select(dropdownElement);
            select.selectByIndex(index);
        } catch (Exception e) {
            System.out.println("❌ Failed to select dropdown by index: " + index + " | Reason: " + e.getMessage());
            throw e;
        }
    }

    public void selectDropdownByText(WebElement dropdownElement, String text) {
        try {
            Select select = new Select(dropdownElement);
            select.selectByVisibleText(text);
        } catch (Exception e) {
            System.out.println("❌ Failed to select dropdown by text: " + text + " | Reason: " + e.getMessage());
            throw e;
        }

    }

    //Get all dropdown options as text
    public List<String> getAllDropdownOptions(WebElement dropdownElement) {
        try {
            Select select = new Select(dropdownElement);
            List<WebElement> options = select.getOptions();
            return options.stream().map(WebElement::getText).toList();
        } catch (Exception e) {
            System.out.println("❌ Failed to get all dropdown options | Reason: " + e.getMessage());
            throw e;
        }

    }

    //Handle multiple browser windows/tabs
    public void switchToWindowByIndex(int windowIndex) {
        try {
            List<String> windowHandles = new ArrayList<>(driver.getWindowHandles());
            if (windowIndex < windowHandles.size()) {
                driver.switchTo().window(windowHandles.get(windowIndex));
            } else {
                throw new RuntimeException("Invalid window index");
            }
        } catch (Exception e) {
            System.out.println("❌ Failed to switch to window by index: " + windowIndex + " | Reason: " + e.getMessage());
            throw e;
        }
    }

    //Get current window handle
    public String getCurrentWindowHandle() {
        return driver.getWindowHandle();
    }

    //Get all window handles
    public Set<String> getAllWindowHandles() {
        return driver.getWindowHandles();
    }
}
