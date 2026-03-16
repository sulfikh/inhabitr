package com.inhabitr.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.inhabitr.base.BasePage;

public class ConnectWithIHGsAIAgentPage extends BasePage{

	public ConnectWithIHGsAIAgentPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath = "//*[@id=\"root\"]/div/button")
	private WebElement aiAgentButton;
	@FindBy(xpath = "//span[normalize-space()='Canada']")
	private WebElement selectRegion;
	@FindBy(xpath = "//div[contains(text(),'Furnish a New Property')]")
	private WebElement typeOfProject;
	@FindBy(xpath = "//textarea[@placeholder='Ask a question...']")
	private WebElement textField;
	@FindBy(xpath = "//*[name()='path' and contains(@d,'M3.478 2.4')]")
	private WebElement enterBtn;
	@FindBy(xpath = "//img[contains(@alt,'No Image')]")
	private WebElement brand;
	@FindBy(xpath = "//img[@src='https://sphere-admin.s3.amazonaws.com/prod/brandImages/Holiday_Inn_Express_Blue_Logo.svg.png' and @alt='No Image']")
	private WebElement subBrand;
	/*
	@FindBy(xpath = "")
	private WebElement enterBtn;
	@FindBy(xpath = "")
	private WebElement enterBtn;
	@FindBy(xpath = "")
	private WebElement enterBtn;
	@FindBy(xpath = "")
	private WebElement enterBtn;
	
	*/
	
	public WebElement selectTypeOfProject() {
		wait.waitForVisibilityOfElement(typeOfProject);
		return typeOfProject;
	}
	
	public WebElement setTextField() {
		wait.waitForVisibilityOfElement(textField);
		return textField;
	}
	
	public WebElement setEnterBtn() {
		wait.waitForVisibilityOfElement(enterBtn);
		return enterBtn;
	}
	public WebElement selectBrand() {
		wait.waitForVisibilityOfElement(brand);
		return enterBtn;
	}
	public WebElement selectSubBrand() {
		wait.waitForVisibilityOfElement(subBrand);
		return subBrand;
	}
	
	
	public WebElement selectAiAgentButton() {
		wait.waitForVisibilityOfElement(aiAgentButton);
		return aiAgentButton;
	}
	public WebElement selectRegion() {
		wait.waitForVisibilityOfElement(selectRegion);
		return selectRegion;
	}
	public void selectRegiontile() {
		safeClick(selectRegion());
	}
	public void selectTypeOfProjectName() {
		safeClick(selectTypeOfProject());
	}
	
	public void clickAiAgentButton() {
		safeClick(selectAiAgentButton());
	}
	public void selectBrandName() {
		safeClick(selectBrand());
	}
	public void selectSubBrandName() {
		safeClick(selectSubBrand());
	}
	
	
	//Actions action = new Actions(driver);
	public void createNewProjectDetails(String pName, String pAddress,String bEName, String fCode,String dMonth, String dYear)throws InterruptedException {
		clickAiAgentButton();
		selectRegiontile();
		selectTypeOfProjectName();	
		new WebDriverWait(driver, Duration.ofSeconds(10));

		setTextField().sendKeys(pName);
		safeClick(setEnterBtn());
		setTextField().sendKeys(pAddress);
		safeClick(setEnterBtn());
		setTextField().sendKeys(bEName);
		safeClick(setEnterBtn());
		setTextField().sendKeys(fCode);
		safeClick(setEnterBtn());
		setTextField().sendKeys(dMonth);
		safeClick(setEnterBtn());
		setTextField().sendKeys(dYear);
		safeClick(setEnterBtn());
		selectBrandName();
		selectSubBrandName();
		
		
		
	}
	
	
}
