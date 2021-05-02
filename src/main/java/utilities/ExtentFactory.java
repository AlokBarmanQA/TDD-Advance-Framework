package utilities;

import com.aventstack.extentreports.ExtentTest;

public class ExtentFactory {
	// Singleton pattern
	private ExtentFactory() {
		
	}
	
	private static ExtentFactory instance = new ExtentFactory();
	
	public static ExtentFactory getInstance() {
		return instance;
	}
	
	// Factory pattern
	ThreadLocal<ExtentTest> extent = new ThreadLocal<ExtentTest>();
	
	public void setExtent(ExtentTest extentTestObject) {
		extent.set(extentTestObject);
	}
	
	public ExtentTest getExtent() {
		return extent.get();
	}
	
	public void removeCurrentExtentObject() {
		extent.remove();
	}
}
