package com.inhabitr.pages;
 
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
 
import com.inhabitr.base.BasePage;
 
public class HomePage extends BasePage {
 
	@FindBy(xpath = "//button[text()='Login']")
	private WebElement loginButton;
	@FindBy(xpath = "//button[text()='Get Started']")
	private WebElement getStartedButton;
 
	public HomePage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
 
	public boolean getLogo() {
		boolean value = isLogoDisplayed();
		return value;
	}
 
	public LoginPage openLoginPage() {
		safeClick(getLoginButton());
		return new LoginPage(driver);
	}
 
	public WebElement getLoginButton() {
		wait.waitForVisibilityOfElement(loginButton);
		return loginButton;
	}
 
	public RegistrationPage openRegistrationPage() {
		safeClick(getGetStartedButton());
		return new RegistrationPage(driver);
 
	}
 
	public WebElement getGetStartedButton() {
		wait.waitForVisibilityOfElement(getStartedButton);
		return getStartedButton;
	}
 
	
 
}