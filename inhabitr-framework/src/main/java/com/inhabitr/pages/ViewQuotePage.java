package com.inhabitr.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.inhabitr.base.BasePage;

public class ViewQuotePage extends BasePage{

	public ViewQuotePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	
@FindBy(xpath = "//button[text()='Filters']")
private WebElement filter;	
@FindBy(xpath = "//span[@class='leading-tight text-sm text-zinc-800 undefined' and contains(text(), 'Signed')]")
private WebElement signed;	
@FindBy(xpath = "//button[text()='Apply']")
private WebElement applyBtn;	
@FindBy(xpath = "(//img[@title='View Project'])[1]")
private WebElement eyeIcon;
@FindBy(xpath = "//span[normalize-space()='floor plan']")
private WebElement floorPlan;
@FindBy(xpath = "//span[text()='signed sales order']")
private WebElement signedSalesOrder;
@FindBy(xpath = "//img[@src='/copy.svg']")
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
@FindBy(xpath = "//button[@aria-label=\"Search\"]//*[name()=\"svg\"]")  
private WebElement searchIcon;
@FindBy(xpath = "//input[@placeholder='Enter to search']")  
private WebElement searchBox;




public WebElement getFilter() {
	wait.waitForVisibilityOfElement(filter);
	return filter;
}
public WebElement getSign() {
	wait.waitForVisibilityOfElement(signed);
	return signed;
}
public WebElement getFloorPlan() {
	wait.waitForVisibilityOfElement(floorPlan);
	return floorPlan;
}

public WebElement getSignedSalesOrder() {
	wait.waitForVisibilityOfElement(signedSalesOrder);
	return signedSalesOrder;
}
public WebElement getApplyBtn() {
	wait.waitForVisibilityOfElement(applyBtn);
	return applyBtn;
}
public WebElement getEyeIcon() {
	wait.waitForVisibilityOfElement(eyeIcon);
	return eyeIcon;
}
public WebElement getViewQuote() {
	wait.waitForVisibilityOfElement(viewQuote);
	return viewQuote;
}
public WebElement getSearch() {
	wait.waitForVisibilityOfElement(searchIcon);
	return searchIcon;
}
public WebElement getDownloadQuote() {
	wait.waitForElementToBeClickable(downloadQuote);
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
public void search() throws InterruptedException {
	Thread.sleep(10000);
		searchIcon.click();
		searchBox.sendKeys("Product Total");
		searchBox.sendKeys(Keys.ENTER);	
}

public void filter() {
	safeClick(getFilter());
	safeClick(getSign());
	safeClick(getApplyBtn());
	
}

public void toDuplicateProject() throws InterruptedException {
	safeClick(duplicateProject);
	Thread.sleep(1000);
	
}

public void toViewQuote() {   	 
	
		safeClick(getViewQuote());	      	    
	    System.out.println("Total Product Cost (with GST/HST) :" + getTotalProdCost().getText());
	    
	 
}

public void toViewFloorPlan() {
	safeClick(getFloorPlan());
}

public void toViewSignedSalesOrder() {
	safeClick(getSignedSalesOrder());
}


public void toDownloadQuotes() throws InterruptedException {

	    safeClick(getDownloadQuote()); 	  	   
	    safeClick(getExcel());
	    Thread.sleep(1000);
	    safeClick(getPDF());
	    
}
}	

