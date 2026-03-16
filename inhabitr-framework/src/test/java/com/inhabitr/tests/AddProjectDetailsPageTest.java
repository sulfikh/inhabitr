package com.inhabitr.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.inhabitr.basetest.BaseTest;

public class AddProjectDetailsPageTest extends BaseTest {

	@BeforeMethod(alwaysRun = true)
	public void setupPage() {
		homePage.openLoginPage();
		loginPage.loginWithValidCredentials(inputFileReader.getValidEmail(), inputFileReader.getValidPassword());
		myProjectsPage.openAddProjectPage();
	}

	@Test
	public void SelectTypeOfProjectTest() throws InterruptedException {
		createNode("Select Type of Project, Brand and project details");
		addProjectDetailsPage.updateAddProjectDetails(inputFileReader.getPropertyNameField(),
				inputFileReader.getSelectAddress(), inputFileReader.getExpectedAddress(),inputFileReader.getBillingEntity(),inputFileReader.getHotelFranchiseCode(),
				inputFileReader.getSelectMonth(), inputFileReader.getSelectYear(),inputFileReader.getFloorPlan(),inputFileReader.getRoomType(),inputFileReader.getRoomCount(),inputFileReader.getTotalRoomCount());
		childTest.pass("Updated project details");

	}

}
