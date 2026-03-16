package com.inhabitr.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.inhabitr.basetest.BaseTest;

public class RegistrationPageTest extends BaseTest {

	@BeforeMethod(alwaysRun = true)
	public void setupPage() {
		// open the Login page from home page of inhibitr
		homePage.openRegistrationPage();
	}

	@Test
	public void userRegistrationTest() {
		createNode("Registration Test cases");
		registrationPage.registerWithInvalidCredentials("aaa","aaa","swjhfsgh","asdf","asd","dsdfe","Developer");
		childTest.pass("Invalid registration validated");
		registrationPage.registerWithValidCredentials("soji", "test","inhabitr","", "soji@test.com", "1234513232", "Designer");
		childTest.pass("Valid registration validated");
	}

	public void getPageTitleTest() {
		String actualTitle = registrationPage.getTitleOfThePage();
		System.out.println(actualTitle);
		Assert.assertEquals(registrationPage.getTitleOfThePage(), configReader.getRegisterPageTitle(),
				"Error- Page Title does not match");
	}

	public void getCurrentPageURLTest() {
		String actualUrl = registrationPage.getCurrentPageURL();
		System.out.println(actualUrl);
		Assert.assertEquals(registrationPage.getCurrentPageURL(), configReader.getRegistrationPageUrl(),
				"Error- Page URL does not match");
	}

}
