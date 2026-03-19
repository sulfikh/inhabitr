package com.inhabitr.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.inhabitr.base.BasePage;

public class SignSalesOrderPage extends BasePage{

	public SignSalesOrderPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		this.driver = driver;
        
	}
	@FindBy(xpath = "//button[normalize-space()='Sign Sales Order']")
	private WebElement signSalesOrderBtn;
	@FindBy(xpath = "//div[contains(@class,'text-textThemeColor font-weight600 max-md:max-w-full max-md:text-xl')]")
	private WebElement windowName;
	@FindBy(xpath = "//button[@class='review-document-button']")
	private WebElement reviewDocumentBtn;	
	@FindBy(xpath = "//iframe[contains(@id,'js-library-iframe')]")
	private WebElement iFrameElement;	
	@FindBy(xpath = "//div[contains(@data-qa,'ersd-modal-body')]")
	private WebElement popWindowName;
	@FindBy(xpath = "//span[contains(@data-qa,'ersd-agree-checkbox-label-text')]")	
	private WebElement checkAgreement;
	@FindBy(xpath = "//div[@class='tab-text']")
	private WebElement signBtn;
	@FindBy(xpath = "//button[@class='olv-button olv-ignore-transform css-13x797']")
	private WebElement nextBtn;
	@FindBy(xpath = "//span[text()='Continue']")
	private WebElement continueBtn;
	@FindBy(xpath = "//a[text()='Proceed to My Projects']")
	private WebElement proceedtoProjects;
	
	
	
	public WebElement btnSignSalesOrder() {
		wait.waitForVisibilityOfElement(signSalesOrderBtn);
		return signSalesOrderBtn;
	}
	
	public WebElement getWindowName() {
		wait.waitForVisibilityOfElement(windowName);
		return windowName;
	}
	
	public WebElement getReviewDocumentButton() {		
		wait.waitForVisibilityOfElement(reviewDocumentBtn);
		return reviewDocumentBtn;
	}

	
	public WebElement getChkAgreement() {
		wait.waitForVisibilityOfElement(checkAgreement);
		return checkAgreement;
	}
	public WebElement getSign() {
		wait.waitForVisibilityOfElement(signBtn);
		return signBtn;
	}
	public WebElement getcontinueBtn() {
		wait.waitForVisibilityOfElement(continueBtn);
		return continueBtn;
	}
//	
//	 public void waitForPopup() {
//	        wait.until(ExpectedConditions.visibilityOf(checkAgreement));
//	    }
	 public WebElement getProceedtoProjects() {
		 wait.waitForVisibilityOfElement(proceedtoProjects);
		 return proceedtoProjects;
		 
	 }
	
	 public void clickSignSalesOrder() {
		    safeClick(signSalesOrderBtn);
		}
	 
	 public void clickReviewDocument() throws InterruptedException {
		    safeClick(reviewDocumentBtn);
		    System.out.println("First pop up is loaded ");
		}	
	
	public void checkIframesPopup() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		System.out.println("Iframe wait is over");
		System.out.println("Checking the iframe pop-up elements");
		WebElement element=null;
		List<WebElement> iframes=driver.findElements(By.tagName("iframe"));
		for (int i=0; i<iframes.size(); i++) {
		driver.switchTo().frame(i);
		try {
		element=driver.findElement(By.id("myElement"));
		System.out.println("Element found inside iframe index: "+i);
		break;
		    } catch (NoSuchElementException e) {
		driver.switchTo().defaultContent();
		    }
		}
		if (element==null) {
		System.out.println("Element not found in any iframe");
		}
    }
	
	public void checkKeyboardAction() {
	    System.out.println("Checking the pop-up with Keyboard actions");
	    
	    Actions actions = new Actions(driver);

	        // Wait until checkbox is clickable
	    actions.sendKeys(Keys.TAB)
	       .pause(Duration.ofMillis(300))
	       .sendKeys(Keys.TAB)
	       .pause(Duration.ofMillis(300))
	       .sendKeys(Keys.SPACE)
	       .pause(Duration.ofSeconds(3))
	       .sendKeys(Keys.TAB)
	       .pause(Duration.ofSeconds(3))
	       .sendKeys(Keys.ENTER)
	       .perform();	       

	}
 public void signOnSalesOrderAgreement() throws AWTException {	
	 System.out.println("Put Sign on Sales Order Agreement");
	 Actions actions = new Actions(driver);
	 actions.sendKeys(Keys.TAB).pause(Duration.ofSeconds(2))
            .sendKeys(Keys.TAB).pause(Duration.ofSeconds(2))
            .sendKeys(Keys.ENTER).pause(Duration.ofSeconds(3))
            .sendKeys(Keys.TAB).pause(Duration.ofSeconds(2))
	        .sendKeys(Keys.TAB).pause(Duration.ofSeconds(2))
	        .sendKeys(Keys.TAB).pause(Duration.ofSeconds(2))
	        .sendKeys(Keys.ARROW_RIGHT).pause(Duration.ofSeconds(2))
	        .sendKeys(Keys.ARROW_RIGHT).pause(Duration.ofSeconds(2))
	        .sendKeys(Keys.ENTER).pause(Duration.ofSeconds(3))
	        .sendKeys(Keys.TAB).pause(Duration.ofSeconds(2))	        
	        .sendKeys(Keys.TAB).pause(Duration.ofSeconds(2))
	        .sendKeys(Keys.ENTER).pause(Duration.ofSeconds(3)).perform();	 
	 
	// Use Robot to handle the dialog
			 Robot robot = new Robot();
			 robot.delay(2000);

			 // Copy the file path to clipboard
			 StringSelection filePath = new StringSelection("C:\\Users\\sojij\\OneDrive\\Pictures\\sojisign.png");
			 Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filePath, null);

			 // Paste the path (CTRL+V)
			 robot.keyPress(KeyEvent.VK_CONTROL);
			 robot.keyPress(KeyEvent.VK_V);
			 robot.keyRelease(KeyEvent.VK_V);
			 robot.keyRelease(KeyEvent.VK_CONTROL);

			 // Press ENTER to confirm
			 robot.keyPress(KeyEvent.VK_ENTER);
			 robot.keyRelease(KeyEvent.VK_ENTER);
			 

			 Actions actions1 = new Actions(driver);
			 actions1.sendKeys(Keys.TAB).pause(Duration.ofSeconds(3))		 
			 .sendKeys(Keys.ENTER).pause(Duration.ofSeconds(5))
			 .sendKeys(Keys.TAB).pause(Duration.ofSeconds(3))
			 .sendKeys(Keys.TAB).pause(Duration.ofSeconds(3))
			 .sendKeys(Keys.ENTER).pause(Duration.ofSeconds(5))
			 .perform();
			 
			 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

			// Example: wait until element is visible
			WebElement proceedtoProjects = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Proceed to My Projects']")));			
			proceedtoProjects.click();
				
			 	
	 
}
}