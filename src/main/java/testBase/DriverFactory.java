package testBase;

import org.openqa.selenium.WebDriver;

public class DriverFactory {
	// Singleton pattern
	// private constructor
	private DriverFactory() {
		
	}
	//  private static object/ instance of this class
	private static DriverFactory instance = new DriverFactory();
	// public get instance methods
	public static DriverFactory getInstance() {
		return instance;
	}
	
	// Factory design pattern
	ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	// set driver
	public void setDriver(WebDriver driverParameter) {
		driver.set(driverParameter);
	}
	// get driver
	public WebDriver getDriver() {
		return driver.get();
	}
	// close current browser instance
	public void closeCurrentBrowserInstance() {
		driver.get().close();
		driver.remove();
	}
}
