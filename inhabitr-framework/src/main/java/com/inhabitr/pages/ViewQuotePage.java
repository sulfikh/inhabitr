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

@FindBy(xpath = "(//img[@title='View Project'])[1]")
private WebElement eyeIcon;
@FindBy(xpath = "//span[normalize-space()='floor plan']")
private WebElement floorPlan;
@FindBy(xpath = "//span[@class='capitalize text-[#D89F12]' and contains(text(),'signed sales order')]")
private WebElement signedSalesOrder;
@FindBy(xpath = "//button[@data-testid='copy-project-button-b45f5cf9']")
private WebElement duplicateProject;
@FindBy(xpath = "//img[@src='/icon_quote_view_grey.svg']")
private WebElement viewQuote;
@FindBy(xpath = "//span[contains(text(),'Total Product Cost')]/following-sibling::span[2]")
private WebElement totProdCost;
@FindBy(xpath = "//button[@class='cursor-pointer hover:opacity-70 ']")
private WebElement downloadQuote;
@FindBy(xpath = "//a[text()='Download PDF']")  
private WebElement downloadPDF;
@FindBy(xpath = "//a[text()='Download Excel']")  
private WebElement downloadExcel;



public WebElement getEyeIcon() {
	wait.waitForVisibilityOfElement(eyeIcon);
	return eyeIcon;
}
public WebElement getViewQuote() {
	wait.waitForVisibilityOfElement(viewQuote);
	return viewQuote;
}
public WebElement getDownloadQuote() {
	wait.waitForVisibilityOfElement(downloadQuote);
	return downloadQuote;
}
public WebElement getExcel() {
	wait.waitForVisibilityOfElement(downloadExcel);
	return downloadExcel;
}
public WebElement getPDF() {
	wait.waitForVisibilityOfElement(downloadPDF);
	return downloadPDF;
}


public WebElement getDuplicateProject() {
	wait.waitForVisibilityOfElement(duplicateProject);
	return duplicateProject;
}
public WebElement getTotalProdCost() {
	wait.waitForVisibilityOfElement(totProdCost);
	return totProdCost;
}


public void toDuplicateProject() {
	safeClick(duplicateProject);
}

public void toViewQuote() {   	 
	
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    WebElement clickableElement = wait.until(ExpectedConditions.elementToBeClickable(viewQuote));
	    safeClick(clickableElement);	  	    
	    System.out.println("Total Product Cost (with GST/HST) :" + getTotalProdCost().getText());
	    
	 
}

public void toDownloadQuotes() {

	    //safeClick(getDownloadQuote()); 
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	    WebElement clickableElement = wait.until(ExpectedConditions.elementToBeClickable(getDownloadQuote()));
	    safeClick(clickableElement);	  	    
	    //Thread.sleep(10000);
	    safeClick(getExcel());
	   // Thread.sleep(10000);
	    safeClick(getPDF());
	    
}
}	

