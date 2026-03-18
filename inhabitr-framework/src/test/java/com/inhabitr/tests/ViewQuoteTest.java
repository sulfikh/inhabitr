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
	public void clickOnViewQuote() throws InterruptedException {
		
		createNode("Quote view should be displayed");		
		editProjectDetailsPage.searchProject(inputFileReader.getSearchProject());
		myProjectsPage.viewProject();
		viewQuotePage.toViewQuote();
		viewQuotePage.toDownloadQuotes();
		
		
		
		//viewQuotePage.toDuplicateProject();	
		
		childTest.pass("Quote viewed successfully");
	}
	
}
