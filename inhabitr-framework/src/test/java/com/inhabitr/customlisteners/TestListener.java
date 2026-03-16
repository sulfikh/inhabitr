package com.inhabitr.customlisteners;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.IAnnotationTransformer;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.ITestAnnotation;

import com.inhabitr.basetest.BaseTest;

public class TestListener extends BaseTest implements ITestListener, IAnnotationTransformer {

	@Override
	public void onTestStart(ITestResult result) {
//	    	user this method to perform some action when test is started
		System.out.println("\nTest Started: " + result.getName());
		 
	}
	
	 
    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("\nTest Passed: " + result.getName());
    }


	@Override
	public void onTestFailure(ITestResult result) {

		System.out.println("\nTest Failed: " + result.getName());

		WebDriver driver = getDriver();

		if (driver == null) {
			System.out.println("Driver is null. Screenshot not captured.");
			return;
		}

		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss");
		String screenshotName = result.getName() + "_" + formatter.format(now);

		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		try {
			FileUtils.copyFile(src, new File(
					System.getProperty("user.dir") + "/src/test/resources/Screenshots/" + screenshotName + ".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
		annotation.setRetryAnalyzer(RetryAnalyzer.class);
	}

}
