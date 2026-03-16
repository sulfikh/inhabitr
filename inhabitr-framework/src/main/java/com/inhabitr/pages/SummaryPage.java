package com.inhabitr.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.inhabitr.base.BasePage;

public class SummaryPage extends BasePage {

	public SummaryPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//button[text()='Review Order Summary']")
	private WebElement reviewOrderSummaryButton;
	@FindBy(xpath = "(//div[normalize-space()='Total']/ancestor::tr//div[contains(@class,'no-break')])[2]")
	private WebElement summaryTotal;
	
	public WebElement getsummaryTotal() {
		wait.waitForVisibilityOfElement(summaryTotal);
		return summaryTotal;
	}
	public WebElement btnReviewOrderSummary() {
		wait.waitForVisibilityOfElement(reviewOrderSummaryButton);
		return reviewOrderSummaryButton;
	}
	public OrderSummaryPage openOrderSummaryPage() {
		safeClick(btnReviewOrderSummary());

		System.out.println("Summary Page :"+getsummaryTotal().getText());
		return new OrderSummaryPage(driver);
	}
	

}
