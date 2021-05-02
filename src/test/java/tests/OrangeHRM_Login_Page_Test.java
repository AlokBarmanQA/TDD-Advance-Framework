package tests;


import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.OrangeHRM_Login_Page_Objects;
import testBase.TestBase;
import utilities.PropertiesReader;

public class OrangeHRM_Login_Page_Test extends TestBase{
	
	OrangeHRM_Login_Page_Objects login_page_Objects = new OrangeHRM_Login_Page_Objects();
	
	@Test
	public void orangeHRMLoginTest() throws InterruptedException {
		login_page_Objects.login_application(PropertiesReader.getPropertyValueByKey("userId"), PropertiesReader.getPropertyValueByKey("password"));
		Assert.assertEquals("true", "false");
	}
}
