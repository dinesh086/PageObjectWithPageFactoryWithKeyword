package base;

import java.time.Duration;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.ExtentReports;



import extentlisteners.ExtentListeners;


public class BasePage {
	
	public static WebDriver driver;
	public static CarBase carBase;
	private static Logger log = Logger.getLogger(BasePage.class);
	//public static ExtentTest test;
	//public static ExtentReports extent;
	
	
	
	
	public BasePage(WebDriver driver) {
		
		BasePage.driver = driver;
		carBase = new CarBase(driver);
		PageFactory.initElements(driver,this);
	}
	public static void click(WebElement element,String msg) {

		element.click();
		log.info(msg);
		ExtentListeners.testReport.get().log(Status.INFO, msg);
		
	}
	
	
	public static void sendKeys(WebElement element, String value, String msg) {

		element.sendKeys(value);
		log.info(" Entered value as : "+value+", As: "+msg);		
		ExtentListeners.testReport.get().log(Status.INFO," Entered value as: " +value+", As: "+msg);

	}
	 public void waitForVisibility(WebElement e) {
		  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		  wait.until(ExpectedConditions.visibilityOf(e));
	  }
	public String getAttribute(WebElement e, String attribute) {
		  waitForVisibility(e);
		  return e.getAttribute(attribute);
	  }
	public String getText(WebElement e, String logMsg)  {
		  waitForVisibility(e);
		  String txt = e.getText();
		  log.info(" Validation Text is: "+txt);	
		  ExtentListeners.testReport.get().log(Status.INFO,"  Validation Text is: " +txt);
		  return txt;
	  }
	  public void clear(WebElement e) {
		  waitForVisibility(e);
		  e.clear();
	  }
	  
	

}
