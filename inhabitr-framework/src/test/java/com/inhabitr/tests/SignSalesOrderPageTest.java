package com.inhabitr.tests;

import java.awt.AWTException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.inhabitr.basetest.BaseTest;

public class SignSalesOrderPageTest extends BaseTest{

	@BeforeMethod(alwaysRun = true)
	public void setupPage() throws InterruptedException {
		homePage.openLoginPage();
		loginPage.loginWithValidCredentials(inputFileReader.getValidEmail(), inputFileReader.getValidPassword());
		myProjectsPage.openAddProjectPage();
		addProjectDetailsPage.updateAddProjectDetails(inputFileReader.getPropertyNameField(),
				inputFileReader.getSelectAddress(), inputFileReader.getExpectedAddress(),
				inputFileReader.getBillingEntity(), inputFileReader.getHotelFranchiseCode(),
				inputFileReader.getSelectMonth(), inputFileReader.getSelectYear(),inputFileReader.getFloorPlan(),
				inputFileReader.getRoomType(), inputFileReader.getRoomCount(), inputFileReader.getTotalRoomCount());
		categoriesAndProductsPage.openChooseYourSchemePage();
		chooseYourSchemePage.openSummaryPage();
		summaryPage.openOrderSummaryPage();		
		orderSummaryPage.viewSalesOrder();
	}
	
	
	@Test
	public void testPopupCheckbox() throws InterruptedException, AWTException {
		createNode("Open sign sales order");	
		signSalesOrderPage.clickSignSalesOrder();
		signSalesOrderPage.clickReviewDocument();		
		signSalesOrderPage.checkIframesPopup();
		signSalesOrderPage.checkKeyboardAction();	
		signSalesOrderPage.signOnSalesOrderAgreement();	
		
		
		
		//signSalesOrderPage.selectTermsAndSubmit();
		childTest.pass("Opened pop and done agree successfully");
	}

	
}
