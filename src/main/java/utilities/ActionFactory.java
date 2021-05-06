package utilities;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.aventstack.extentreports.Status;

import testBase.DriverFactory;

public class ActionFactory {
	
	public void custom_sendKeys(WebElement element, String fieldName, String valueToBeSent) {
		try {
			element.sendKeys(valueToBeSent);
			ExtentFactory.getInstance().getExtent().log(Status.PASS, fieldName+"==>entered value as: "+valueToBeSent);
		} catch (Exception e) {
			ExtentFactory.getInstance().getExtent().log(Status.FAIL, "Value entered in field: "+fieldName+" is failed due to exception: "+e);
		}
	}
	public void custom_click(WebElement element, String fieldName) {
		try {
			element.click();
			ExtentFactory.getInstance().getExtent().log(Status.PASS, fieldName+" ==> clicked successfully");
		} catch (Exception e) {
			ExtentFactory.getInstance().getExtent().log(Status.FAIL, "Unable to click on: "+fieldName+" due to exception: "+e);
		}
	}
	public void custom_clear(WebElement element, String fieldName) {
		try {
			element.clear();
			Thread.sleep(1000);
			ExtentFactory.getInstance().getExtent().log(Status.PASS, fieldName+" ==> Data cleared successfully");
		} catch (Exception e) {
			ExtentFactory.getInstance().getExtent().log(Status.FAIL, "Unable to clear data on: "+fieldName+" due to exception: "+e);
		}
	}
	public void custom_moveToElement(WebElement element, String fieldName) {
		try {
			JavascriptExecutor js = (JavascriptExecutor)DriverFactory.getInstance().getDriver();
			js.executeScript("arguments[0].scrollIntoView(true);", element);
			Actions actions = new Actions(DriverFactory.getInstance().getDriver());
			actions.moveToElement(element).build().perform();
			ExtentFactory.getInstance().getExtent().log(Status.PASS, fieldName+" ==> Mouse hovered successfully!");
			Thread.sleep(1000);
		} catch (Exception e) {
			ExtentFactory.getInstance().getExtent().log(Status.FAIL, "Unable to mouse hover on: "+fieldName+" due to exception: "+e);
		}
	}
	public boolean custom_isElementPresent(WebElement element, String fieldName) {
		boolean flag = false;
		try {
			flag = element.isDisplayed();
			ExtentFactory.getInstance().getExtent().log(Status.PASS, fieldName+" ==> is displayed::"+flag);
			return flag;
		} catch (Exception e) {
			ExtentFactory.getInstance().getExtent().log(Status.FAIL, "Presence of field: "+fieldName+" not tested due to exception: "+e);
			return  flag;
		}
	}
	public void custom_selectByVisibleText(WebElement element, String fieldName, String dropdownText) {
		try {
			Select select = new Select(element);
			select.selectByVisibleText(dropdownText);
			ExtentFactory.getInstance().getExtent().log(Status.PASS, fieldName+" ==> Dropdown value selected by "+dropdownText);
		} catch (Exception e) {
			ExtentFactory.getInstance().getExtent().log(Status.FAIL, "Dropdown value is not selected for field: "+fieldName+" due to exception: "+e);
		}
	}
	public void custom_selectByValue(WebElement element, String fieldName, String dropdownValue) {
		try {
			Select select = new Select(element);
			select.selectByVisibleText(dropdownValue);
			ExtentFactory.getInstance().getExtent().log(Status.PASS, fieldName+" ==> Dropdown value selected by  "+dropdownValue);
		} catch (Exception e) {
			ExtentFactory.getInstance().getExtent().log(Status.FAIL, "Dropdown value is not selected for field: "+fieldName+" due to exception: "+e);
		}
	}
	public void custom_assertEquals(String actual, String expected, String locatorName) {
		try {
			Assert.assertEquals(actual, expected);
			ExtentFactory.getInstance().getExtent().log(Status.PASS, "String assertion is successful on filed  "+locatorName+" Expected value was: "+expected);
		} catch (Exception e) {
			ExtentFactory.getInstance().getExtent().log(Status.FAIL, "String assertion FAILED for field: "+locatorName+" Expected value was: "+expected+" due to exception: "+e);
		}
	}
	public String custom_getText(WebElement element, String fieldName) {
		String text = "";
		try {
			text = element.getText();
			ExtentFactory.getInstance().getExtent().log(Status.PASS, fieldName+" ==> Text retrieve is  "+text);
		} catch (Exception e) {
			ExtentFactory.getInstance().getExtent().log(Status.FAIL, fieldName+" ==> Text unable to retrieve due to exception "+e);
		}
		return text;
	}

	public boolean isAlertPresent() {
	      try{
	    	  DriverFactory.getInstance().getDriver().switchTo().alert();
	          return true;
	      }
	      catch(NoAlertPresentException ex){
	          return false;
	      }
	}
	public void custom_alert_popup_handle() {
	    if(isAlertPresent()){
			try {
				Alert alert = DriverFactory.getInstance().getDriver().switchTo().alert();
				alert.accept();
				ExtentFactory.getInstance().getExtent().log(Status.PASS, "Alert is accepted");
			} catch (Exception e) {
				ExtentFactory.getInstance().getExtent().log(Status.FAIL, "Alert is unable to accept "+" due to: "+e);
			}
	    }
	}
}
