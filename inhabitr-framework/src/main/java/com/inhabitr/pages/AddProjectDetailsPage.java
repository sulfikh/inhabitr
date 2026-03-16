package com.inhabitr.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.inhabitr.base.BasePage;

public class AddProjectDetailsPage extends BasePage {

	public AddProjectDetailsPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//span[text()='Canada']")
	private WebElement canadaTitle;
	@FindBy(xpath = "//input[@name='billingEntity']")
	private WebElement billingEntityField;
	@FindBy(xpath = "//input[@name='franchisePropertyCode']")
	private WebElement franchisePropertyCodeField;
	@FindBy(xpath = "//div[text()='Furnish a New Property']")
	private WebElement furnishANewPropertyCard;
	@FindBy(xpath = "//img[@data-testid='brand-Holiday Inn Express']")
	private WebElement holidayInnExpressCard;
	@FindBy(xpath = "//div[text()='Add Project Details']")
	private WebElement addProjectDetailsTitle;
	@FindBy(xpath = "//input[@name='projectName']")
	private WebElement propertyNameField;
	@FindBy(id = "autocomplete")
	private WebElement addressInput;
	@FindBy(xpath = "//ul[@aria-label='Suggestions']/li")
	private List<WebElement> addressSuggestions;
	@FindBy(xpath = "//div[@data-testid='dropdown-month']")
	private WebElement monthDropdown;
	@FindBy(xpath = "//ul[contains(@class,'overflow-y-scroll')]//li")
	private List<WebElement> monthOptions;
	@FindBy(xpath = "//div[@data-testid='dropdown-year']")
	private WebElement yearDropdown;
	@FindBy(xpath = "//ul[contains(@class,'overflow-y-scroll')]//li")
	private List<WebElement> yearOptions;
	@FindBy(xpath = "//button[text()='Add Room Type or Floorplan']")
	private WebElement addRoomTypeOrFloorPlanButton;
	@FindBy(xpath = "//button[text()='Upload Floorplan']")
	private WebElement uploadFloorPlanButton;
	@FindBy(xpath = "//select[@name='roomsManual.0.floorPlanId']")
	private WebElement selectRoomTypeDropdown;
	@FindBy(css = "div.shadow-lg")
	private WebElement aIWaitCompletion;
	@FindBy(xpath = "//input[@placeholder='Enter Zip Code']")
	private WebElement zipCodeField;
	@FindBy(xpath = "//input[@name='roomsManual.0.count']")
	private WebElement enterRoomCountField;
	@FindBy(xpath = "//button[text()='Add New']")
	private WebElement addNewButton;
	@FindBy(xpath = "//input[@name='masterRoom.0.count']")
	private WebElement totalRoomCountField;
	@FindBy(xpath = "//button[.='Submit Property']")
	private WebElement submitPropertyButton;

	By fileInput = By.xpath("//input[@type='file']");

	public WebElement setAIWaitCompletion() {
//		wait.waitForVisibilityOfElement(aIWaitCompletion);
		return aIWaitCompletion;
	}

	public WebElement btnsubmitProperty() {
		wait.waitForVisibilityOfElement(submitPropertyButton);
		return submitPropertyButton;
	}

	public WebElement btnAddNew() {
		wait.waitForVisibilityOfElement(addNewButton);
		return addNewButton;
	}
	public WebElement setCanadaTitle() {
		wait.waitForVisibilityOfElement(canadaTitle);
		return canadaTitle;
	}
	public WebElement setFranchisePropertyCodeField() {
		wait.waitForVisibilityOfElement(franchisePropertyCodeField);
		return franchisePropertyCodeField;
	}
	public WebElement setBillingEntityField() {
		wait.waitForVisibilityOfElement(billingEntityField);
		return billingEntityField;
	}
	public WebElement setFurnishANewPropertyCard() {
		wait.waitForVisibilityOfElement(furnishANewPropertyCard);
		return furnishANewPropertyCard;
	}
	public WebElement setEnterRoomCountField() {
		wait.waitForVisibilityOfElement(enterRoomCountField);
		return enterRoomCountField;
	}

	public WebElement setTotalRoomCountField() {
		wait.waitForVisibilityOfElement(totalRoomCountField);
		return totalRoomCountField;
	}

	public WebElement setZipCodeField() {
		wait.waitForVisibilityOfElement(zipCodeField);
		return zipCodeField;
	}

	public WebElement setselectRoomTypeDropdown() {
		wait.waitForVisibilityOfElement(selectRoomTypeDropdown);
		return selectRoomTypeDropdown;
	}

	public void selectRoomTypeByVisibleText(String roomType) {
		// Proper AI wait
		waitForAICompletion();
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});",
				selectRoomTypeDropdown);
		Select select = new Select(selectRoomTypeDropdown);
		select.selectByVisibleText(roomType);
	}

	public WebElement setHolidayInnExpressCard() {
		wait.waitForVisibilityOfElement(holidayInnExpressCard);
		return holidayInnExpressCard;
	}

	public WebElement setpropertyNameField() {
		wait.waitForVisibilityOfElement(propertyNameField);
		return propertyNameField;
	}

	public WebElement setFileUploadField() {
		return wait.waitForPresenceOfElementLocated(fileInput);
	}

	public WebElement setUploadFloorPlanButton() {
		wait.waitForVisibilityOfElement(uploadFloorPlanButton);
		return uploadFloorPlanButton;
	}

	public WebElement setaddRoomTypeOrFloorPlanButton() {
		wait.waitForVisibilityOfElement(addRoomTypeOrFloorPlanButton);
		return addRoomTypeOrFloorPlanButton;
	}

	public WebElement setAddProjectDetails() {
		wait.waitForVisibilityOfElement(addProjectDetailsTitle);
		return addProjectDetailsTitle;
	}

	public void selectAddress(String searchText, String expectedAddress) {

		wait.waitForVisibilityOfElement(addressInput);
		addressInput.clear();
		addressInput.sendKeys(searchText);
		new WebDriverWait(driver, Duration.ofSeconds(15))
				.until(driver -> addressSuggestions.stream().anyMatch(e -> e.getText().contains(expectedAddress)));
		for (WebElement suggestion : addressSuggestions) {
			if (suggestion.getText().contains(expectedAddress)) {
				suggestion.click();
				break;
			}
		}
	}

	public void selectMonth(String month) {
		wait.waitForVisibilityOfElement(monthDropdown);
		monthDropdown.click();

		for (WebElement option : monthOptions) {
			if (option.getText().equalsIgnoreCase(month)) {
				option.click();
				break;
			}
		}
	}

	public void selectYear(String year) {
		wait.waitForVisibilityOfElement(yearDropdown);
		yearDropdown.click();

		for (WebElement option : yearOptions) {
			if (option.getText().equals(year)) {
				option.click();
				break;
			}
		}
	}

	public void waitForAICompletion() {
		// Wait until AI analysis modal disappears
		wait.waitForInvisibilityOfElement(aIWaitCompletion);

	}
	



	public CategoriesAndProductsPage updateAddProjectDetails(String propertyNamefield, String address,
			String expectedAddress,String billingEntity, String franchisePropertyCodeField, String month, String year, String floorPlan, String roomType, String roomCount,
			String totalRoomCount) throws InterruptedException {
		
		safeClick(setCanadaTitle());
		safeClick(setFurnishANewPropertyCard());
		safeClick(setHolidayInnExpressCard());
		setAddProjectDetails();
		setpropertyNameField().sendKeys(propertyNamefield);
		selectAddress(address, expectedAddress);
		setBillingEntityField().sendKeys(billingEntity);
		setFranchisePropertyCodeField().sendKeys(franchisePropertyCodeField);
		selectMonth(month);
		selectYear(year);
		safeClick(setaddRoomTypeOrFloorPlanButton());
		setFileUploadField().sendKeys(floorPlan);
		safeClick(setUploadFloorPlanButton());
		selectRoomTypeByVisibleText(roomType);
		setEnterRoomCountField().sendKeys(roomCount);
		safeClick(btnAddNew());
//		setTotalRoomCountField().sendKeys(totalRoomCount);
		safeClick(btnsubmitProperty());
		return new CategoriesAndProductsPage(driver);
	}
}