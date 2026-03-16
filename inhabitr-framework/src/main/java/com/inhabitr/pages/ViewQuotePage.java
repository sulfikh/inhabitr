package com.inhabitr.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.inhabitr.base.BasePage;

public class ViewQuotePage extends BasePage{

	public ViewQuotePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
@FindBy(xpath = "//span[normalize-space()='floor plan']")
private WebElement floorPlan;
@FindBy(xpath = "//span[@class='capitalize text-[#D89F12]' and contains(text(),'signed sales order')]")
private WebElement signedSalesOrder;
@FindBy(xpath = "//button[@data-testid='copy-project-button-b45f5cf9']")
private WebElement duplicateProject;
@FindBy(xpath = "//img[@src='/icon_quote_view_grey.svg']")
private WebElement viewQuote;

public WebElement getViewQuote() {
	wait.waitForVisibilityOfElement(viewQuote);
	return viewQuote;
}
public WebElement getDuplicateProject() {
	wait.waitForVisibilityOfElement(duplicateProject);
	return duplicateProject;
}

public void toDuplicateProject() {
	safeClick(duplicateProject);
}

public void toViewQuote() {
	 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    WebElement clickableElement = wait.until(ExpectedConditions.elementToBeClickable(viewQuote));
	    safeClick(clickableElement);
	    
	  //  System.out.println("quote button clicked successfully");

}



	
}
