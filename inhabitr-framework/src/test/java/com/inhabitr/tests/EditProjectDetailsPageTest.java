package com.inhabitr.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.inhabitr.basetest.BaseTest;

public class EditProjectDetailsPageTest extends BaseTest {

	@BeforeMethod(alwaysRun = true)
	public void setupPage() {
		homePage.openLoginPage();
		loginPage.loginWithValidCredentials(inputFileReader.getValidEmail(),inputFileReader.getValidPassword());
		
}
	

	@Test
	public void editProject() {
		createNode("Open Edit Project Page");		
		editProjectDetailsPage.editProject(inputFileReader.getSearchProject(), inputFileReader.getSelectMonth(),inputFileReader.getSelectYear());
		orderSummaryPage.clickEmailOrSave();
		orderSummaryPage.viewSalesOrder();		
		
		childTest.pass("Opened Edit Project Details page By clicking on Edit icon");
		
	}

	
	
}