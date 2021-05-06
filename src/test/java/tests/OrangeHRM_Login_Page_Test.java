package tests;


import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageObjects.OrangeHRM_Login_Page_Objects;
import testBase.TestBase;
import utilities.PropertiesReader;

public class OrangeHRM_Login_Page_Test extends TestBase{
	
	OrangeHRM_Login_Page_Objects login_page_Objects = new OrangeHRM_Login_Page_Objects();
	
	@Test
	public void orangeHRMLoginTestWithValidCredential() {
		login_page_Objects.login_application(PropertiesReader.getPropertyValueByKey("userId"), PropertiesReader.getPropertyValueByKey("password"));
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(login_page_Objects.get_dashboard_text(), "Dashboard");
		softAssert.assertEquals(login_page_Objects.get_page_title(), "OrangeHRM");
		softAssert.assertTrue(login_page_Objects.verify_welcome_text().contains("Welcome"));
		softAssert.assertAll();
	}
	@Test
	public void orangeHRMLoginTestWithInvalidCredential() {
		login_page_Objects.login_application("admin", "admin");
		Assert.assertEquals(login_page_Objects.verify_error_message(), "Invalid credentials");
	}
	@Test
	public void orangeHRMLoginTestWithEmptyCredentials() {
		login_page_Objects.login_application("", "");
		Assert.assertEquals(login_page_Objects.verify_error_message(), "Username cannot be empty");
	}
	@Test
	public void orangeHRMLoginTestWithEmptyUsername() {
		login_page_Objects.login_application("", "admin123");
		Assert.assertEquals(login_page_Objects.verify_error_message(), "Username cannot be empty");
	}
	@Test
	public void orangeHRMLoginTestWithEmptyPassword() {
		login_page_Objects.login_application("Admin", "");
		Assert.assertEquals(login_page_Objects.verify_error_message(), "Password cannot be empty");
	}
}
