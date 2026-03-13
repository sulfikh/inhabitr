package com.inhabitr.base;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.inhabitr.pages.HomePage;
import com.inhabitr.pages.LoginPage;
import com.inhabitr.utils.ConfigReader;
import com.inhabitr.utils.CustomWait;

public class BasePage {

	protected WebDriver driver;
	protected CustomWait wait;
	protected ConfigReader configReader;

	public BasePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		configReader = new ConfigReader();
		this.wait = new CustomWait(driver, Duration.ofSeconds(configReader.getGlobalWaitValue()));
	}
	

	@FindBy(xpath = "//img[@class='max-w-full w-[120px]']")
	protected WebElement logo;
	@FindBy(xpath = "//img[@alt='menu icon']")
	protected WebElement menuIcon;
	@FindBy(xpath = "//button[text()='My Orders']")
	protected WebElement myOrders;
	@FindBy(xpath = "//button[text()='My Account']")
	protected WebElement myAccount;
	@FindBy(xpath = "//button[text()='My Projects']")
	protected WebElement myProjects;
	@FindBy(xpath = "//button[text()='Logout']")
	protected WebElement logOut;
	@FindBy(xpath = "//img[@src='/icon_cross_black.svg']")
	protected WebElement closeMenuButton;
		
	
	public String getCurrentPageURL() {
		return driver.getCurrentUrl();
	}

	public String getTitleOfThePage() {
		return driver.getTitle();
	}

	public boolean isLogoDisplayed() {
		wait.waitForVisibilityOfElement(logo);
		return logo.isDisplayed();

	}
	public WebElement btnCloseMenu() {
		wait.waitForVisibilityOfElement(closeMenuButton);
		return closeMenuButton;
	}
	public WebElement getMenuIcon() {
		wait.waitForVisibilityOfElement(menuIcon);
		return menuIcon;
	}
	public WebElement getMyAccount() {
		wait.waitForVisibilityOfElement(myAccount);
		return myAccount;
	}
	public WebElement getMyProjects() {
		wait.waitForVisibilityOfElement(myProjects);
		return myProjects;
	}
	public WebElement getMyOrders() {
		wait.waitForVisibilityOfElement(myOrders);
		return myOrders;
	}
	public WebElement getLogOut() {
		wait.waitForVisibilityOfElement(logOut);
		return logOut;
	}

	public void navigateBack() {
		driver.navigate().back();
	}

	public void navigateForward() {
		driver.navigate().forward();
	}

	public void refreshPage() {
		driver.navigate().refresh();
	}
	protected void safeClick(WebElement element) {
	    try {
	        wait.waitForElementToBeClickable(element);
	        ((JavascriptExecutor) driver)
	                .executeScript("arguments[0].scrollIntoView({block:'center'});", element);
	        element.click();
	    } catch (Exception e) {
	        ((JavascriptExecutor) driver)
	                .executeScript("arguments[0].click();", element);
	    }
	}
	
	public void displayMenu()
	{
		safeClick(getMenuIcon());
	}
	public void displayMyOrders()
	{
		displayMenu();
		safeClick(getMyOrders());
	}
	public void displayMyAccount()
	{
		displayMenu();
		safeClick(getMyAccount());
	}
	public void displayMyProjects()
	{
		displayMenu();
		safeClick(getMyProjects());
	}
	public void logOut() {
		displayMenu();
		safeClick(getLogOut());
	}
	public void closeMenu() {
		displayMenu();
		safeClick(btnCloseMenu());
	}
}
