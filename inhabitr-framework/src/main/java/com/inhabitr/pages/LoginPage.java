package com.inhabitr.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.inhabitr.base.BasePage;

public class LoginPage extends BasePage {

//	WebElements on signIn page
	@FindBy(id = "org_email_id")
	private WebElement emailField;
	@FindBy(id = "password")
	private WebElement passwordField;
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement loginButton;
	@FindBy(xpath = "//p[text()='Invalid Email/Password']")
	private WebElement toastMessage;

	public LoginPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);

	}

//	setter  Methods for WebElements

	public WebElement setEmailField() {
		wait.waitForVisibilityOfElement(emailField);
		return emailField;
	}

	public WebElement setPasswordField() {
		wait.waitForVisibilityOfElement(passwordField);
		return passwordField;
	}

	public WebElement btnLogin() {
		wait.waitForVisibilityOfElement(loginButton);
		return loginButton;
	}

	public String getToastMessage() {
		wait.waitForVisibilityOfElement(toastMessage);
		return toastMessage.getText();
	}

	public void loginWithInvalidCredentials(String inValidEmail, String inValidPassword) {
		setEmailField().clear();
		setEmailField().sendKeys(inValidEmail);
		setPasswordField().clear();
		setPasswordField().sendKeys(inValidPassword);
		safeClick(btnLogin());
		System.out.println("Toast Message:" + getToastMessage());
	}

	//new -ve cases 
	public boolean isLoginButtonEnabled() {
	        return loginButton.isEnabled();
	    }
	 public void loginWithInvalidEmailFormat(String inValidEmailFormat, String validPassword) {
		    setEmailField().clear();
			setEmailField().sendKeys(inValidEmailFormat);
			setPasswordField().clear();
			setPasswordField().sendKeys(validPassword);
			safeClick(btnLogin());
			//System.out.println("Toast Message:" + getToastMessage());
	 }

	
	public MyProjectsPage loginWithValidCredentials(String validEmail, String validPassword) {
		setEmailField().clear();
		setEmailField().sendKeys(validEmail);
		setPasswordField().clear();
		setPasswordField().sendKeys(validPassword);
		safeClick(btnLogin());
		return new MyProjectsPage(driver);
	}
}
