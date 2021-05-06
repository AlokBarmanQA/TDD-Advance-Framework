package pageObjects;

import org.openqa.selenium.By;

import testBase.DriverFactory;
import testBase.TestBase;

public class OrangeHRM_Login_Page_Objects extends TestBase{
	
	By TXT_BOX_USERNAME = By.name("txtUsername");
	By TXT_BOX_PASSWORD = By.id("txtPassword");
	By BTN_LOGIN = By.xpath("//*[@id='btnLogin']");
	By TXT_DASHBOARD = By.xpath("//*[@id='content']/div/div[1]/h1");	
	By TXT_WELCOME = By.id("welcome");
	By ERROR_MESSAGE =By.cssSelector("span#spanMessage");

	public String get_page_title() {
		return DriverFactory.getInstance().getDriver().getTitle();
	}
	public void login_application(String un, String pwd) {
		custom_sendKeys(DriverFactory.getInstance().getDriver().findElement(TXT_BOX_USERNAME), "UsernameTextBox", un);
		custom_sendKeys(DriverFactory.getInstance().getDriver().findElement(TXT_BOX_PASSWORD), "PasswordTextBox", pwd);
		custom_click(DriverFactory.getInstance().getDriver().findElement(BTN_LOGIN), "LoginButton");
	}
	public String get_dashboard_text() {
		return custom_getText(DriverFactory.getInstance().getDriver().findElement(TXT_DASHBOARD), "DashboardText");
	}
	public String verify_welcome_text() {
		return custom_getText(DriverFactory.getInstance().getDriver().findElement(TXT_WELCOME), "WelcomeText");
	}
	public String verify_error_message() {
		return custom_getText(DriverFactory.getInstance().getDriver().findElement(ERROR_MESSAGE), "InvalidCredentialsErrorMessage");
	}
}
