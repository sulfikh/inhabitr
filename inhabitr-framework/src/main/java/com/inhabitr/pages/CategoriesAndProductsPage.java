package com.inhabitr.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.inhabitr.base.BasePage;

public class CategoriesAndProductsPage extends BasePage {
	public CategoriesAndProductsPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//button[text()='Next']")
	private WebElement nextButton;
	

	public WebElement btnNext() {
		wait.waitForVisibilityOfElement(nextButton);
		return nextButton;
	}
	
		public ChooseYourSchemePage openChooseYourSchemePage() {
		safeClick(btnNext());
		return new ChooseYourSchemePage(driver);
	}
	
	
	
}
