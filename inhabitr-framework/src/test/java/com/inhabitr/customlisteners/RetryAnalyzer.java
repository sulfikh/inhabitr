package com.inhabitr.customlisteners;
 
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
 
public class RetryAnalyzer implements IRetryAnalyzer {
	
	private int retryCount = 0;
	private int max_retryCount =1;
			
 
	@Override
	public boolean retry(ITestResult result) {
		if(retryCount<max_retryCount && !result.isSuccess()) {
			retryCount++;
			System.out.println("\nRetrying the Test ==> "+result.getName()+"\nAttempt No. ==>"+ retryCount);
			return true;
		}
		return false;
	}
 
}
 