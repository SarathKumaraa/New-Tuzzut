package org.base;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class ReRunFailedTC implements IRetryAnalyzer{

	int minCount=0, maxCount=2;
	public boolean retry(ITestResult result) {
		if(minCount<maxCount) {
			minCount++;
			return true;
		}
		return false;
	}
	
	
	

}
