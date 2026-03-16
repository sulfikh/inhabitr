package com.inhabitr.utils;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PopupHandler {
	
	private WebDriver driver;
	private WebDriverWait wait;

    public PopupHandler(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Handle JavaScript Alerts
    public void acceptAlert() {
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
    }

    public void dismissAlert() {
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().dismiss();
    }

    public String getAlertText() {
        wait.until(ExpectedConditions.alertIsPresent());
        return driver.switchTo().alert().getText();
    }

    // Handle HTML Modal Popups
    public void clickElementInPopup(WebElement webElement) {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(webElement));
        element.click();
    }

    public void selectCheckboxInPopup(WebElement windowName1) {
        WebElement checkbox = wait.until(ExpectedConditions.elementToBeClickable(windowName1));
        if (!checkbox.isSelected()) {
            checkbox.click();
        }
    }

    // Handle New Window Popups
    public void switchToNewWindow() {
        String parent = driver.getWindowHandle();
        for (String window : driver.getWindowHandles()) {
            if (!window.equals(parent)) {
                driver.switchTo().window(window);
                break;
            }
        }


}
    }