package com.inhabitr.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.inhabitr.base.BasePage;

public class EditProjectDetailsPage extends BasePage{

	public EditProjectDetailsPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	

	@FindBy(xpath = "//input[@placeholder='Search for anything...']")
	private WebElement searchTextBox;
	@FindBy(xpath = "//img[@src='/edit_2.svg']")
	private WebElement editProjectIcon;
	@FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/main/div[3]/div/div/div[1]/div/div[1]")
	private WebElement goldTheme;
	@FindBy(xpath = "//div[@data-testid='dropdown-month']")
	private WebElement freightMonthDrpDwn;
	@FindBy(xpath = "//ul[contains(@class,'overflow-y-scroll')]//li")
	private List<WebElement> monthOptions;
	@FindBy(xpath = "//div[@data-testid='dropdown-year']")
	private WebElement freightYearDrpDwn;
	@FindBy(xpath = "//ul[contains(@class,'overflow-y-scroll')]//li")
	private List<WebElement> yearOptions;
	@FindBy(xpath = "//button[contains(text(),'View Sales Order')]/parent::div")
	private WebElement viewSalesOrderButton;
	@FindBy(xpath = "(//div[normalize-space()='Total']/ancestor::tr//div[contains(@class,'no-break')])[2]")
	private WebElement summaryTotal;
	@FindBy(xpath = "//img[@src='/icon_email.svg']")
	private WebElement emailOrSaveBtn;
	@FindBy(xpath = "//button[text()='Next']")
	private WebElement nextButton;
	@FindBy(xpath = "//button[text()='Review Order Summary']")
	private WebElement rvwOrdrSummaryBtn;	
	@FindBy(xpath = "//button[text()='Continue']")
	private WebElement continueBtn;
	
	
	


	public WebElement getsearchTextBox() {
		wait.waitForVisibilityOfElement(searchTextBox);
		return searchTextBox;		
	}

	public WebElement getEditProjectIcon() {
		wait.waitForVisibilityOfElement(editProjectIcon);
		return editProjectIcon;		
	}
	
	public WebElement clickViewSalesOrder() {
		wait.waitForVisibilityOfElement(viewSalesOrderButton);
		return viewSalesOrderButton;
	}
	
	public WebElement getGoldTheme() {
		wait.waitForVisibilityOfElement(goldTheme);
		return goldTheme;
	}
	public WebElement getSummaryTot() {
		wait.waitForVisibilityOfElement(summaryTotal);
		return summaryTotal;
	}
	public WebElement btnEmail() {
		wait.waitForVisibilityOfElement(emailOrSaveBtn);
		return emailOrSaveBtn;
	}
	public WebElement getNextButton(){
		wait.waitForVisibilityOfElement(nextButton);
		return nextButton;
	}
	
	public WebElement getReviewOrderSummary() {
		wait.waitForVisibilityOfElement(rvwOrdrSummaryBtn);
		return rvwOrdrSummaryBtn;
	}
	
	public WebElement clickContinueBtn() {
		wait.waitForVisibilityOfElement(continueBtn);
		return continueBtn;
	}
	public void clickScheme() {
		
		safeClick(getGoldTheme());
	}
	
	public void clickEditProjectIcon(){
		safeClick(getEditProjectIcon());
	}
	public void selectMonth(String month) {
		wait.waitForVisibilityOfElement(freightMonthDrpDwn);
		safeClick(freightMonthDrpDwn);
		wait.waitForVisibilityOfElements(monthOptions);
		for (WebElement option : monthOptions) {
			if (option.getText().trim().equalsIgnoreCase(month)) {
	            safeClick(option); 
	            return;

			}
		}
		throw new IllegalArgumentException("Month option not found: " + month);

	}
	

	public void selectYear(String year) {
		wait.waitForVisibilityOfElement(freightYearDrpDwn);
	    safeClick(freightYearDrpDwn);
	    wait.waitForVisibilityOfElements(yearOptions);
	    for (WebElement option : yearOptions) {
	        if (option.getText().trim().equals(year)) {
	            safeClick(option);
	            return;
	        }
	    }
	    throw new IllegalArgumentException("Year option not found: " + year);
	}
	
	public void selectFromDropdown(List<WebElement> options, String value) {
	    wait.waitForVisibilityOfElements(options);
	    for (WebElement option : options) {
	        if (option.getText().trim().equalsIgnoreCase(value)) {
	            safeClick(option);
	            return;
	        }
	    }
	    throw new IllegalArgumentException("Option not found: " + value);
	}
	
	
	
	public OrderSummaryPage emailAndVIewSalesOrder() {
		safeClick(btnEmail());
		safeClick(clickViewSalesOrder());

		System.out.println("Summary Page :"+getSummaryTot().getText());
		return new OrderSummaryPage(driver);
	}
	
	public ChooseYourSchemePage openChooseYourSchemePage() {
		safeClick(getNextButton());		
		return new ChooseYourSchemePage(driver);
	}
	
	public SummaryPage reviewOrderSummaryPage() {
		safeClick(getReviewOrderSummary());
		return new SummaryPage(driver);
	}
	private boolean isContinueSuccessful() {
		// TODO Auto-generated method stub
		return false;
	}

	private boolean isReviewPageDisplayed() {
		// TODO Auto-generated method stub
		return false;
	}
	

	
	

	public void editProject(String search, String month, String year) {	
		
		getsearchTextBox().sendKeys(search);//1
		safeClick(getEditProjectIcon());
		
		String currentURL = driver.getCurrentUrl();
		System.out.println("Fetched url is :" + currentURL);
		
		if(currentURL.contains("checkout") ) {
			selectMonth(month);
			selectYear(year);			
			emailAndVIewSalesOrder();
		}
		if(currentURL.contains("style")) {
			clickScheme();	
			openChooseYourSchemePage();
			reviewOrderSummaryPage();			
			if(isReviewPageDisplayed() || isContinueSuccessful()) {
				selectMonth(month);
				selectYear(year);
				System.out.println("month and year" + month+year);	
				emailAndVIewSalesOrder();
				
			}else {
			clickContinueBtn();
			}		
		}	
		
			    
	}	
	public void dusplau() {
		System.out.println("dffds");
	}
}
