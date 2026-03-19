package com.inhabitr.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.inhabitr.basetest.BaseTest;

public class ViewQuoteTest extends BaseTest{
	
	
	@BeforeMethod(alwaysRun = true)
	public void setupPage() throws InterruptedException {
		homePage.openLoginPage();
		myProjectsPage = loginPage.loginWithValidCredentials(inputFileReader.getValidEmail(),
				inputFileReader.getValidPassword());

}
	
	@Test
	public void clickOnFloorPlanLink() {
		createNode("FloorPlan should be Opened");	
		viewQuotePage.filter();
		editProjectDetailsPage.searchProject(inputFileReader.getSearchProject());		
		myProjectsPage.viewProject();
		viewQuotePage.toViewFloorPlan();
		childTest.pass("FloorPlan Opened succesffully");
		
	}
	
	@Test
	public void clickOnSignedSalesOrderLink() {
		createNode("Signed sales order should be Opened");	
		viewQuotePage.filter();
		editProjectDetailsPage.searchProject(inputFileReader.getSearchProject());		
		myProjectsPage.viewProject();
		viewQuotePage.toViewSignedSalesOrder();
		childTest.pass("Signed sales order Opened successfully");
		
	}
	
	@Test
	public void clickOnDuplicateButtonk() throws InterruptedException {
		createNode("Project should be duplicated");	
		viewQuotePage.filter();
		editProjectDetailsPage.searchProject(inputFileReader.getSearchProject());		
		myProjectsPage.viewProject();
		viewQuotePage.toDuplicateProject();
		childTest.pass("Project duplicated successfully");
		
	}
	@Test
	public void deleteProject() throws InterruptedException {
		createNode("Project should be deleted");			
		editProjectDetailsPage.searchProject(inputFileReader.getSearchProject());		
		myProjectsPage.deleteProject();			
		childTest.pass("Project deleted successfully");
	}
	
	@Test
	public void clickOnViewQuote() throws InterruptedException {
		
		createNode("Quote view should be displayed");	
		viewQuotePage.filter();
		editProjectDetailsPage.searchProject(inputFileReader.getSearchProject());		
		myProjectsPage.viewProject();			
		viewQuotePage.toViewQuote();
		viewQuotePage.search();
		viewQuotePage.toDownloadQuotes();		
		childTest.pass("Quote viewed and downloaded successfully");
	}
	
}
