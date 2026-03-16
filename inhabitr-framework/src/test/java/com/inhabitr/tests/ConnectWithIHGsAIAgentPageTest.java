package com.inhabitr.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.inhabitr.basetest.BaseTest;

public class ConnectWithIHGsAIAgentPageTest extends BaseTest{
	
	@BeforeMethod(alwaysRun = true)
	public void setupPage() throws InterruptedException {
		homePage.openLoginPage();
		loginPage.loginWithValidCredentials(inputFileReader.getValidEmail(), inputFileReader.getValidPassword());
		
	
	}
	
	@Test
	public void clickConnectWithIHGsAIAgent() throws InterruptedException {
		createNode("Connect with IHG's AI agent");		
		//connectWithIHGsAIAgentPage.createNewProjectDetails();
		childTest.pass("Connect with IHG's AI agent");
	}
	
}
