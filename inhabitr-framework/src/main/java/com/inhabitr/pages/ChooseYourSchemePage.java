package com.inhabitr.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.inhabitr.base.BasePage;

public class ChooseYourSchemePage extends BasePage {
	public ChooseYourSchemePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = "div.scheme-card")
	private WebElement goldTheme;
	@FindBy(xpath = "//button[text()='Next']")
	private WebElement nextButton;
	
	public WebElement btnNext() {
		wait.waitForVisibilityOfElement(nextButton);
		return nextButton;
	}
	public WebElement setGoldTheme() {
		wait.waitForVisibilityOfElement(goldTheme);
		return goldTheme;
	}
	public SummaryPage openSummaryPage() {
		safeClick(setGoldTheme());
		safeClick(btnNext());
		return new SummaryPage(driver);
	}
	
}
