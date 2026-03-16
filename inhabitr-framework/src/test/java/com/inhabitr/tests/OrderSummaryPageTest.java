package com.inhabitr.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.inhabitr.basetest.BaseTest;

public class OrderSummaryPageTest extends BaseTest {
	
	//private WindowUtils windowUtils;

	@BeforeMethod(alwaysRun = true)
	public void setupPage() throws InterruptedException {
		homePage.openLoginPage();
		loginPage.loginWithValidCredentials(inputFileReader.getValidEmail(), inputFileReader.getValidPassword());
		myProjectsPage.openAddProjectPage();
		addProjectDetailsPage.updateAddProjectDetails(inputFileReader.getPropertyNameField(),
				inputFileReader.getSelectAddress(), inputFileReader.getExpectedAddress(),
				inputFileReader.getBillingEntity(), inputFileReader.getHotelFranchiseCode(),
				inputFileReader.getSelectMonth(), inputFileReader.getSelectYear(), inputFileReader.getFloorPlan(),
				inputFileReader.getRoomType(), inputFileReader.getRoomCount(), inputFileReader.getTotalRoomCount());
		categoriesAndProductsPage.openChooseYourSchemePage();
		chooseYourSchemePage.openSummaryPage();
		summaryPage.openOrderSummaryPage();
		
	}
	@Test
	public void clickEmailOrSave() {
		createNode("Send Email or Save button");
		orderSummaryPage.clickEmailOrSave();
		childTest.pass("Clicked and Email sent successfully");
	}


	@Test
	public void selectViewSalesOrder() {
		//windowUtils.switchToNewWindow();
		createNode("Open view sales order");
		orderSummaryPage.viewSalesOrder();
		childTest.pass("Opened view sales order successfully");
	}
}
