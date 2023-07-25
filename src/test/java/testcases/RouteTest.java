package testcases;
import java.io.InputStream;
import java.lang.reflect.Method;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BasePage;
import base.BaseTest;
import pages.DashboardPage;
import pages.LoginPage;


public class RouteTest extends BaseTest {

	
	LoginPage loginPage;
	DashboardPage homePage;
	JSONObject loginUsers;

	  @BeforeClass
	  public void beforeClass() throws Exception {
			InputStream datais = null;
		  try {
			  String dataFileName = "excel/loginUsers.json";
			  datais = getClass().getClassLoader().getResourceAsStream(dataFileName);
			  JSONTokener tokener = new JSONTokener(datais);
			  loginUsers = new JSONObject(tokener);
		  } catch(Exception e) {
			  e.printStackTrace();
			  throw e;
		  } finally {
			  if(datais != null) {
				  datais.close();
			  }
		  }
		
	  }
	
	 @BeforeMethod
	  public void beforeMethod(Method m) {
		
		  loginPage = new LoginPage(driver);
	  }
	
	  
}
