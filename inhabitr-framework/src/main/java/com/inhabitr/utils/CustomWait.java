package com.inhabitr.utils;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CustomWait {
	private WebDriver driver;
	private WebDriverWait wait;

	public CustomWait(WebDriver driver, Duration timeout) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, timeout);
	}

	// wait for an element to be visible
	public void waitForVisibilityOfElement(WebElement element) {
		try {
			wait.until(ExpectedConditions.visibilityOf(element));
		} catch (TimeoutException e) {
//			e.printStackTrace();
			System.err.println("Element is not visible after Waiting:" + e.getMessage());
		}
	}

	// wait for an element to be clickable
	public void waitForElementToBeClickable(WebElement element) {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(element));
		} catch (TimeoutException e) {
//				e.printStackTrace();
			System.err.println("Element is not clickable after Waiting:" + e.getMessage());
		}
	}

	// wait for an element to be invisible
	public void waitForInvisibilityOfElement(WebElement element) {
		try {
			wait.until(ExpectedConditions.invisibilityOf(element));
		} catch (TimeoutException e) {
//					e.printStackTrace();
			System.err.println("Element is not invisible after Waiting:" + e.getMessage());
		}
	}

	public void waitForVisibilityOfElements(List<WebElement> elements) {
	    try {
	        wait.until(ExpectedConditions.visibilityOfAllElements(elements));
	    } catch (TimeoutException e) {
	        System.err.println("Elements are not visible after waiting: " + e.getMessage());
	    }
	}


	// wait for presence of element located
	public WebElement waitForPresenceOfElementLocated(By locator) {
	    try {
	        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	    } catch (TimeoutException e) {
	        System.err.println("Element not present after waiting: " + e.getMessage());
	        return null;
	    }
	}
	
	public <T> T waitForCondition(ExpectedCondition<T> condition) {
	    try {
	        return wait.until(condition);
	    } catch (TimeoutException e) {
	        System.err.println("Condition not met: " + e.getMessage());
	        return null;
	    }
	}

	public void until(ExpectedCondition<WebElement> visibilityOf) {
		// TODO Auto-generated method stub
		
	}

}
