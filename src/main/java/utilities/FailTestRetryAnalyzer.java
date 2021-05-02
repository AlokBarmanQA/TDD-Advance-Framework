package utilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class FailTestRetryAnalyzer implements IRetryAnalyzer {
	
	int counter = 1;
	int retryLimit = Integer.valueOf(PropertiesReader.getPropertyValueByKey("failTestRetryCount"));
	
	@Override
	public boolean retry(ITestResult result) {
		if(counter<retryLimit) {
			counter++;
			return true;
		}
		return false;
	}

}
