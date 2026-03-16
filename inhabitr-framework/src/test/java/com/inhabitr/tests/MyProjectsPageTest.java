package com.inhabitr.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.inhabitr.basetest.BaseTest;

public class MyProjectsPageTest extends BaseTest {

	@BeforeMethod(alwaysRun = true)
	public void setupPage() {
		homePage.openLoginPage();
		myProjectsPage = loginPage.loginWithValidCredentials(inputFileReader.getValidEmail(),
				inputFileReader.getValidPassword());
	}

	@Test
	public void clickOnAddProjectButtonTest() {
		createNode("Open Add Project Page");
		myProjectsPage.openAddProjectPage();
		childTest.pass("Opened Add Project Details page");
	}
	

	public void filter() {
	    myProjectsPage.selectFilter(inputFileReader.getFilterSelected());
	}
	
	public void switchView() {
	    myProjectsPage.openSwitchedView();
	}

	public void applySort() {
	    myProjectsPage.openApplySort(inputFileReader.getSortSelected());
	}

	public void search() {
	    myProjectsPage.openSearch(inputFileReader.getSearchText());
	}

	public void deleteProjectFromMyProject() {
		myProjectsPage.deleteProject();
	}

	public void viewProjectFromMyProject() {
		myProjectsPage.viewProject();
	}
	public void editProjectFromMyProject() {
		myProjectsPage.editProject();
	}
}
