package com.inhabitr.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.inhabitr.basetest.BaseTest;

public class ChooseYourSchemePageTest extends BaseTest{
	
	@BeforeMethod(alwaysRun = true)
	public void setupPage() throws InterruptedException {
		homePage.openLoginPage();
		loginPage.loginWithValidCredentials(inputFileReader.getValidEmail(), inputFileReader.getValidPassword());
		myProjectsPage.openAddProjectPage();
		addProjectDetailsPage.updateAddProjectDetails(inputFileReader.getPropertyNameField(),inputFileReader.getSelectAddress(),inputFileReader.getExpectedAddress(),inputFileReader.getBillingEntity(),inputFileReader.getHotelFranchiseCode(),
				inputFileReader.getSelectMonth(),inputFileReader.getSelectYear(),inputFileReader.getFloorPlan(),inputFileReader.getRoomType(),inputFileReader.getRoomCount(),inputFileReader.getTotalRoomCount());
		categoriesAndProductsPage.openChooseYourSchemePage();
		chooseYourSchemePage.openSummaryPage();
	}
	
	@Test
	public void selectScheme() {
		createNode("Select your scheme ");
		chooseYourSchemePage.openSummaryPage();
		childTest.pass("Scheme selected successfully");
	}
}
