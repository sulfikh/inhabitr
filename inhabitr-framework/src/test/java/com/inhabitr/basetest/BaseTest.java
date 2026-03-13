package com.inhabitr.basetest;

import java.lang.reflect.Method;
import java.time.Duration;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;
import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.inhabitr.pages.*;
import com.inhabitr.testdatareaders.ExcelReader;
import com.inhabitr.utils.*;

public class BaseTest {

	protected static ThreadLocal<WebDriver> localDriver = new ThreadLocal<>();

	protected static ExtentReports extent;
	protected ExtentTest parentTest;
	protected ExtentTest childTest;

	protected HomePage homePage;
	protected RegistrationPage registrationPage;
	protected LoginPage loginPage;
	protected MyProjectsPage myProjectsPage;
	protected AddProjectDetailsPage addProjectDetailsPage;
	protected CategoriesAndProductsPage categoriesAndProductsPage;
	protected ChooseYourSchemePage chooseYourSchemePage;
	protected SummaryPage summaryPage;
	protected OrderSummaryPage orderSummaryPage;
	protected SignSalesOrderPage signSalesOrderPage;
	protected EditProjectDetailsPage editProjectDetailsPage;
	protected ConnectWithIHGsAIAgentPage connectWithIHGsAIAgentPage;
	

	protected ConfigReader configReader;
	protected InputFileReader inputFileReader;
	protected ExcelReader excelReader;
	


	public static WebDriver getDriver() {
		return localDriver.get();
	}

	// ---------- EXTENT SETUP ----------
	@BeforeSuite
	public void setupReport() {
		extent = getExtentReport();
	}

	// ---------- DRIVER + TEST SETUP ----------
	@BeforeMethod(alwaysRun = true)
	public void baseSetup(Method method) {

		parentTest = extent.createTest(method.getName());

		configReader = new ConfigReader();
		inputFileReader = new InputFileReader();

		WebDriver driver = createDriver(configReader.getBrowser());
		localDriver.set(driver);

		driver.get(configReader.getQAURL());

		String sessionId = ((RemoteWebDriver) driver).getSessionId().toString();
		System.out.println("Session ID: " + sessionId);

		homePage = new HomePage(driver);
		registrationPage = new RegistrationPage(driver);
		loginPage = new LoginPage(driver);
		myProjectsPage = new MyProjectsPage(driver);
		addProjectDetailsPage = new AddProjectDetailsPage(driver);
		categoriesAndProductsPage = new CategoriesAndProductsPage(driver);
		chooseYourSchemePage = new ChooseYourSchemePage(driver);
		summaryPage = new SummaryPage(driver);
		orderSummaryPage = new OrderSummaryPage(driver);
		signSalesOrderPage = new SignSalesOrderPage(driver);
		editProjectDetailsPage = new EditProjectDetailsPage(driver);
		connectWithIHGsAIAgentPage = new ConnectWithIHGsAIAgentPage(driver);
	}

	// ---------- CHILD NODE ----------
	protected void createNode(String nodeName) {
		childTest = parentTest.createNode(nodeName);
	}

	// ---------- CREATE DRIVER ----------
	private WebDriver createDriver(String browser) {
		WebDriver driver;

		if (browser.equalsIgnoreCase("chrome")) {
			ChromeOptions options = new ChromeOptions();
			options.setPageLoadStrategy(PageLoadStrategy.EAGER);
			driver = new ChromeDriver(options);
		} else if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else {
			driver = new EdgeDriver();
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));

		return driver;
	}

	// ---------- EXTENT REPORT ----------
	public static ExtentReports getExtentReport() {
		if (extent == null) {
			ExtentSparkReporter reporter = new ExtentSparkReporter("extent-reports/extent.html");

			reporter.config().setReportName("Inhabitr Automation Report");
			reporter.config().setDocumentTitle("UI Automation");

			extent = new ExtentReports();
			extent.attachReporter(reporter);
		}
		return extent;
	}

//	@DataProvider(name = "loginData")
//	public Object[][] getLoginData() {
//		String path = System.getProperty("user.dir") + "/src/test/resources/test-data/test-data.xlsx";
//		return ExcelReader.getData(path);
//	}


	
	// ---------- DRIVER TEARDOWN ----------
	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		if (getDriver() != null) {
			getDriver().quit();
			localDriver.remove();
		}
	}

	// ---------- REPORT FLUSH ----------
	@AfterSuite(alwaysRun = true)
	public void flushReport() {
		if (extent != null) {
			extent.flush();
		}
	}
}
