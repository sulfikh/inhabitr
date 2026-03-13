package com.inhabitr.tests;

import org.testng.Assert;
import com.inhabitr.basetest.BaseTest;

public class HomePageTest extends BaseTest {

	public void verifyHomePageURLTest() {
	    String actualUrl = homePage.getCurrentPageURL();
	    System.out.println("Page URL: " + actualUrl);
	    String expectedUrl = configReader.getQAURL();
	    Assert.assertEquals(actualUrl, expectedUrl, "Error - Home Page URL does not match");
	}
	

	public void verifyLogoPresenceTest() {
	    boolean logo = homePage.getLogo();
	    System.out.println("Logo:"+ logo);
	    Assert.assertTrue(homePage.isLogoDisplayed(), "Error - Logo is not displayed on Home Page");
	}
	
	public void verifyHomePageTitleTest() {
		String actualTitle = homePage.getTitleOfThePage();
		System.out.println("Page Title :" + actualTitle);
		Assert.assertEquals(actualTitle, inputFileReader.getHomePageTitle(), "Error - Home Page title does not match");
	}

	
	public void verifyLoginButtonPresenceTest() {
		Assert.assertTrue(homePage.getLoginButton().isDisplayed(),
				"Error - Login button is not displayed on Home Page");
	}

	public void verifyLoginButtonClickNavigatesToLoginPageTest() {
		homePage.openLoginPage();
		String loginPageTitle = loginPage.getTitleOfThePage();
		System.out.println("loginPageTitle: " + loginPageTitle);
		Assert.assertEquals(loginPageTitle, inputFileReader.getLoginPageTitle(),
				"Error - Login Page title does not match after clicking Login button");
	}
	

	public void verifyRegisterButtonPresenceTest() {
		Assert.assertTrue(homePage.getGetStartedButton().isDisplayed(),
				"Error - Register button is not displayed on Home Page");
	}


	public void verifyRegisterButtonClickNavigatesToRegisterPageTest() {
		homePage.openRegistrationPage();
		String registerPageTitle = registrationPage.getTitleOfThePage();
		System.out.println("RegisterPageTitle: "+ registerPageTitle);
	
		Assert.assertEquals(registerPageTitle, inputFileReader.getRegisterPageTitle(),
				"Error - Register Page title does not match after clicking Login button");
	}

}
