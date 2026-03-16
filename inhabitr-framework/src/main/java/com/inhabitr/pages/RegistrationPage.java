package com.inhabitr.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.inhabitr.base.BasePage;

public class RegistrationPage extends BasePage {

	public RegistrationPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "fname")
	private WebElement firstNameField;
	@FindBy(id = "lname")
	private WebElement lastNameField;
	@FindBy(id = "org_email_id")
	private WebElement orgEmailIDField;
	@FindBy(id = "phone")
	private WebElement contactNumberField;
	@FindBy(id = "companyName")
	private WebElement companyNameField;
	@FindBy(xpath="//input[@placeholder='Company Website']")
	private WebElement companyWebsiteField;
	@FindBy(xpath = "//div[@data-testid='dropdown-role']")
	private WebElement roleDropDown;
	@FindBy(xpath = "//input[@type='checkbox']")
	private WebElement checkBoxSelect;
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement verifyEmailButton;
	@FindBy(xpath = "//p[contains(text(),'Verification link has']")
	private WebElement registrationSuccessText;

	@FindBy(xpath = "//li[@class='p-2 cursor-pointer  hover:bg-gray-200']")
	private List<WebElement> roleOptions;

	public WebElement setFirstNameField() {
		wait.waitForVisibilityOfElement(firstNameField);
		return firstNameField;
	}

	public WebElement setLastNameField() {
		wait.waitForVisibilityOfElement(lastNameField);
		return lastNameField;
	}
	public WebElement setCompanyNameField() {
		wait.waitForVisibilityOfElement(companyNameField);
		return companyNameField;
	}

	public WebElement setCompanyWebsiteField() {
		wait.waitForVisibilityOfElement(companyWebsiteField);
		return companyWebsiteField;
	}

	public WebElement setOrgEmailIDField() {
		wait.waitForVisibilityOfElement(orgEmailIDField);
		return orgEmailIDField;
	}

	public WebElement setContactNumberField() {
		wait.waitForVisibilityOfElement(contactNumberField);
		return contactNumberField;
	}

	public WebElement setRoleDropDown() {
		wait.waitForVisibilityOfElement(roleDropDown);
		return roleDropDown;
	}

	public WebElement btnVerifyEmail() {
		wait.waitForVisibilityOfElement(verifyEmailButton);
		return verifyEmailButton;
	}

	public WebElement getCheckBoxSelection() {
		wait.waitForVisibilityOfElement(checkBoxSelect);
		return checkBoxSelect;
	}

	public String setRegistrationSuccessMessage() {
		wait.waitForVisibilityOfElement(registrationSuccessText);
		System.out.println(registrationSuccessText.getText());
		return registrationSuccessText.getText();
	}

	public void selectRoleFromList(String roleName) {
		setRoleDropDown().click();
		for (WebElement option : roleOptions) {
			if (option.getText().equalsIgnoreCase(roleName)) {
				option.click();
				System.out.println("Selected role: " + roleName);
				break;
			}
		}
	}

	public void registerWithValidCredentials(String firstName, String lastName,String companyName,String companyWebsite, String email, String contactNumber,
			String role) {
		setFirstNameField().clear();
		setFirstNameField().sendKeys(firstName);
		setLastNameField().clear();
		setLastNameField().sendKeys(lastName);
		setCompanyNameField().clear();
		setCompanyNameField().sendKeys(companyName);
		setCompanyWebsiteField().clear();
		setCompanyWebsiteField().sendKeys(companyWebsite);
		setContactNumberField().clear();
		setContactNumberField().sendKeys(contactNumber);
		setOrgEmailIDField().clear();
		setOrgEmailIDField().sendKeys(email);
		selectRoleFromList(role);
		if (!getCheckBoxSelection().isSelected()) {
			safeClick(getCheckBoxSelection());
		}
		safeClick(btnVerifyEmail());

	}

	public void registerWithInvalidCredentials(String firstName, String lastName,String companyName,String companyWebsite,String orgEmailId,String contactNumber,String role) {
		setFirstNameField().clear();
		setFirstNameField().sendKeys(firstName);
		setLastNameField().clear();
		setLastNameField().sendKeys(lastName);
		setContactNumberField().clear();
		setContactNumberField().sendKeys(contactNumber);
		setCompanyNameField().clear();
		setCompanyNameField().sendKeys(companyName);
		setCompanyWebsiteField().clear();
		setCompanyWebsiteField().sendKeys(companyWebsite);
		setOrgEmailIDField().clear();
		setOrgEmailIDField().sendKeys(orgEmailId);
		selectRoleFromList(role);
		if (!getCheckBoxSelection().isSelected()) {
			safeClick(getCheckBoxSelection());
		}
		if (btnVerifyEmail().isEnabled() == false) {
			System.out.println("\t Verify Email Button not enabled - invalid credantials");
		} else {
			System.out.println("\t Verify Email Button  enabled - valid credantials");
		}

	}

}