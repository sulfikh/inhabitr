package com.inhabitr.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.inhabitr.base.BasePage;

public class OrderSummaryPage extends BasePage {
	


	public OrderSummaryPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		
		
	}

	
	@FindBy(xpath = "//button[contains(text(),'View Sales Order')]/parent::div")
	private WebElement viewSalesOrderButton;
	@FindBy(xpath = "//span[contains(text(),'Total Product Cost')]/following-sibling::span[2]")
	private WebElement totalProductCostwithsalestax;
	@FindBy(xpath = "//img[@src='/icon_email.svg']")
	private WebElement emailOrSaveBtn;
	@FindBy(xpath = "//div[@class='text-sm font-medium text-gray-900']")
	private WebElement toastMessage;
	

	public WebElement getTotalProductCostwithsalestax() {		
		wait.waitForVisibilityOfElement(totalProductCostwithsalestax);
		return totalProductCostwithsalestax;
	}

	
	public WebElement btnViewSalesOrder() {
		wait.waitForVisibilityOfElement(viewSalesOrderButton);
		return viewSalesOrderButton;
	}
	
	public WebElement btnEmailOrSave() {
		wait.waitForVisibilityOfElement(emailOrSaveBtn);
		return emailOrSaveBtn;
	}
	
	public WebElement getToastMessage() {
		wait.waitForVisibilityOfElement(toastMessage);
		return toastMessage;
	}

	
	public void viewSalesOrder() {
		safeClick(btnViewSalesOrder());
		System.out.println("Sales order total:"+ getTotalProductCostwithsalestax().getText());
		
	}
	
	public void clickEmailOrSave() {
		safeClick(btnEmailOrSave());
		System.out.println("Toast Message is : " + getToastMessage());
	}
	
	

}

