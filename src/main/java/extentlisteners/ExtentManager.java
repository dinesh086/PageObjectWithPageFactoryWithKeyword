package extentlisteners;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import base.BasePage;



public class ExtentManager {

	private static ExtentReports extent;
	public static String fileName;
	
	

	    public static ExtentReports createInstance(String fileName) {
	        ExtentSparkReporter htmlReporter = new ExtentSparkReporter(fileName);
	       
	        
	        htmlReporter.config().setTheme(Theme.DARK);
	        htmlReporter.config().setDocumentTitle(fileName);
	        htmlReporter.config().setEncoding("utf-8");
	        htmlReporter.config().setReportName(fileName);
	        
	        extent = new ExtentReports();
	        extent.attachReporter(htmlReporter);
	        extent.setSystemInfo("Automation Tester", "Dinesh Kumar");
	        extent.setSystemInfo("Organization", "Datamatics");
	        extent.setSystemInfo("Build no", "APP-12345");
	        
	        
	        return extent;
	    }

	    
		public static void captureScreenshot() throws IOException {
			
			Date d = new Date();
			 fileName = d.toString().replace(":", "_").replace(" ", "_")+".jpg";

			 String Path = System.getProperty("user.dir")+"/reports/"; 
			
			File screeshot = ((TakesScreenshot)  BasePage.driver).getScreenshotAs(OutputType.FILE);
		
			try {
				FileUtils.copyFile(screeshot, new File(Path+fileName));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
		

		public static void captureElementScreenshot(WebElement element) throws IOException {
			
			Date d = new Date();
			String fileName = d.toString().replace(":", "_").replace(" ", "_")+".jpg";

			 String Path = System.getProperty("user.dir")+"/reports/"; 
			
			File screeshot = ((TakesScreenshot) element).getScreenshotAs(OutputType.FILE);
			
			try {
				FileUtils.copyFile(screeshot, new File(Path+"Element_"+fileName));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	 
		/*  public static String screenshotPath;
		public static String screenshotName;
		
		public static void captureScreenshotNew() {

			File scrFile = ((TakesScreenshot) BasePage.driver).getScreenshotAs(OutputType.FILE);

			Date d = new Date();
			screenshotName = d.toString().replace(":", "_").replace(" ", "_") + ".jpg";

			try {
				FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir") + "\\reports\\" + screenshotName));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		
		}*/
	

	}
