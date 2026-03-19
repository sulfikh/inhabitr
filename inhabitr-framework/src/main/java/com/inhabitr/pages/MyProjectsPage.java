package com.inhabitr.pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.inhabitr.base.BasePage;

public class MyProjectsPage extends BasePage {

	public MyProjectsPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//button[normalize-space()='Add Project']")
	private WebElement addProjectButton;
	@FindBy(xpath = "//button[text()='Filters']")
	private WebElement filters;
	@FindBy(xpath = "//button[text()='Apply']")
	private WebElement applyButton;
	@FindBy(xpath = "//img[@src='/icon_list.svg']")
	private WebElement listView;
	@FindBy(xpath = "//img[@src='/icon_grid.svg']")
	private WebElement gridView;
	@FindBy(xpath = "//span[@class='text-overflow-view']")
	private WebElement sortDropdown;
	@FindBy(xpath = "//ul[contains(@class,'property-dropdown-list')]//li")
	private List<WebElement> sortList;
	@FindBy(xpath = "//input[@placeholder='Search for anything...']")
	private WebElement searchTextBox;
	@FindBy(xpath = "//img[@title='Delete Project']")
	private WebElement deleteProjectIcon;
	@FindBy(xpath = "//button[text()='Delete Project']")
	private WebElement deleteProjectButton;
	@FindBy(xpath = "//p[text()='Property deleted successfully']")
	private WebElement toastMessage;
	@FindBy(xpath = "//img[@src='/eye.svg']")
	private WebElement viewProjectIcon;
	@FindBy(xpath = "//img[@src='/edit_2.svg']")
	private WebElement editProjectIcon;
	@FindBy(xpath = "//img[@src='/icon_back_arrow.svg']")
	private WebElement backArrowIcon;
	
	
	
	
	public String getToastMessage() {
		wait.waitForVisibilityOfElement(toastMessage);
		return toastMessage.getText();
	}

	public WebElement getfilters() {
		wait.waitForVisibilityOfElement(filters);
		return filters;
	}

	public WebElement btnAddProject() {
		wait.waitForVisibilityOfElement(addProjectButton);
		return addProjectButton;
	}
	public WebElement deleteProjectIcon() {
		wait.waitForVisibilityOfElement(deleteProjectIcon);
		return deleteProjectIcon;
	}
	public WebElement backArrowIcon() {
		wait.waitForVisibilityOfElement(backArrowIcon);
		return backArrowIcon;
	}
	public WebElement viewProjectIcon() {
		wait.waitForVisibilityOfElement(viewProjectIcon);
		return viewProjectIcon;
	}
	public WebElement editProjectIcon() {
		wait.waitForVisibilityOfElement(editProjectIcon);
		return editProjectIcon;
	}
	public WebElement btnDeleteProject() {
		wait.waitForVisibilityOfElement(deleteProjectButton);
		return deleteProjectButton;
	}
	public WebElement txtSeach() {
		wait.waitForVisibilityOfElement(searchTextBox);
		return searchTextBox;
	}

	public WebElement btnApply() {
		wait.waitForVisibilityOfElement(applyButton);
		return applyButton;
	}

	public WebElement getSortDropdown() {
		wait.waitForVisibilityOfElement(sortDropdown);
		return sortDropdown;
	}

	public WebElement btnListView() {
		wait.waitForVisibilityOfElement(listView);
		return listView;
	}

	public WebElement btnGridView() {
		wait.waitForVisibilityOfElement(gridView);
		return gridView;
	}

	public WebElement getfilterOption(String value) {
		WebElement filterSelected = driver.findElement(By.xpath("//label/span[text()='" + value + "']"));
		return filterSelected;
	}

	public AddProjectDetailsPage openAddProjectPage() {
		safeClick(btnAddProject());
		return new AddProjectDetailsPage(driver);
	}

	public void openFilters() {
		safeClick(getfilters());
	}

	public void selectFilter(String value) {
		openFilters();
		safeClick(getfilterOption(value));
		safeClick(btnApply());
	}

	public void openSwitchedView() {
		safeClick(btnListView());
		safeClick(btnGridView());
	}

	public void openApplySort(String sortType) {
		openSortDropdown();
		selectSortOption(sortType);
	}

	public void selectSortOption(String sortType) {

		for (WebElement option : sortList) {
			if (option.getText().equals(sortType)) {
				option.click();
				break;
			}
		}
	}

	public void openSortDropdown() {
		safeClick(getSortDropdown());
	}
	public void openSearch(String searchText) {
		txtSeach().sendKeys(searchText);	
	}
	public void deleteProject() {
		safeClick(deleteProjectIcon());
		safeClick(btnDeleteProject());
		System.out.println("Toast Message:" + getToastMessage());
	}

	public void viewProject() {		
		safeClick(viewProjectIcon());
		//safeClick(backArrowIcon());
	}

	public void editProject() {
		safeClick(editProjectIcon());
		
		
	}
}
