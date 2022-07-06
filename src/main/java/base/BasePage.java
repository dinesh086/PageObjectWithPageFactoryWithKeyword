package base;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;


import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import extentlisteners.ExtentListeners;


public class BasePage {
	
	public static WebDriver driver;
	public static CarBase carBase;
	private static Logger log = Logger.getLogger(BasePage.class);
	public static ExtentTest test;
	
	
	
	public BasePage(WebDriver driver) {
		
		BasePage.driver = driver;
		carBase = new CarBase(driver);
		PageFactory.initElements(driver,this);
	}
	public static void click(WebElement element,String msg) {

		element.click();
		log.info(msg);
		ExtentListeners.test.log(Status.INFO, msg);
	}
	
	
	public static void type(WebElement element, String value, String msg) {

		element.sendKeys(value);
		log.info(" Entered value as : "+value+msg);		
		ExtentListeners.test.log(Status.INFO," Entered value as :" +value +msg);

	}
	

}
