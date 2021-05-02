package testBase;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import utilities.ActionFactory;
import utilities.PropertiesReader;

public class TestBase extends ActionFactory{
	
	BrowserFactory browserFactory = new BrowserFactory();
	
	@BeforeMethod
	public void launchBrowser() {
		String browser = PropertiesReader.getPropertyValueByKey("browser");
		String url = PropertiesReader.getPropertyValueByKey("applicationURL");
		DriverFactory.getInstance().setDriver(browserFactory.createBrowserInstance(browser));
		WebDriver driver = DriverFactory.getInstance().getDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.navigate().to(url);
	}
	
	@AfterMethod
	public void tearDown() {
		DriverFactory.getInstance().closeCurrentBrowserInstance();
	}
}
