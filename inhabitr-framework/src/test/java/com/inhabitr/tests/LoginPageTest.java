package com.inhabitr.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.inhabitr.basetest.BaseTest;

public class LoginPageTest extends BaseTest {

	@BeforeMethod(alwaysRun = true)
	public void setupPage() {
		homePage.openLoginPage();
	}

	@Test
	public void userLoginTest() {
		createNode("Login Page testcases");
		loginPage.loginWithInvalidCredentials(inputFileReader.getInValidEmail(), inputFileReader.getInValidPassword());
		childTest.pass("Invalid login validated");
		loginPage.loginWithInvalidEmailFormat(inputFileReader.getInvalidEmailFormat(), inputFileReader.getValidPassword());
		childTest.pass("Invalid Email Format should not enabled the Login button");
		loginPage.loginWithValidCredentials(inputFileReader.getValidEmail(), inputFileReader.getValidPassword());
//		loginPage.loginWithValidCredentials(username,password);		
		childTest.pass("Valid login successful");
//		loginPage.displayMyAccount();
//		loginPage.logOut();

	}

	public void getPageTitleTest() {
		String actualTitle = loginPage.getTitleOfThePage();
		System.out.println("Page Title: " + actualTitle);
		Assert.assertEquals(loginPage.getTitleOfThePage(), inputFileReader.getLoginPageTitle(),
				"Error- Page Title does not match");
	}

	public void getCurrentPageURLTest() {
		String actualUrl = loginPage.getCurrentPageURL();
		System.out.println("Page URL :" + actualUrl);
		Assert.assertEquals(loginPage.getCurrentPageURL(), configReader.getLoginPageUrl(),
				"Error- Page URL does not match");
	}
	 
	public void verifyLoginButtonState() {
	     	       
	        boolean buttonState = loginPage.isLoginButtonEnabled();
	        Assert.assertTrue(buttonState, "Login button should be disabled!");
	    }

	

}