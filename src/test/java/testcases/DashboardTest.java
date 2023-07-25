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
import pages.ChangePasswordPage;
import pages.DashboardPage;
import pages.LoginPage;


public class DashboardTest extends BaseTest {


	LoginPage loginPage;
	DashboardPage homePage;
	JSONObject loginUsers;
	ChangePasswordPage changePasswordPage;
	DashboardPage dashboardpage;

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
		
		 
		  DashboardPage dashboardpage = new DashboardPage(driver);
	  }
	
	 @Test
	    public void testChangePasswordScreenElements() {
	        // Verify the presence and visibility of all elements on the change password screen
	        Assert.assertTrue(changePasswordPage.isChangePasswordHeadingDisplayed());
	        Assert.assertTrue(changePasswordPage.isNewPasswordLabelDisplayed());
	        Assert.assertTrue(changePasswordPage.isNewPasswordInputDisplayed());
	        Assert.assertTrue(changePasswordPage.isConfirmPasswordLabelDisplayed());
	        Assert.assertTrue(changePasswordPage.isConfirmPasswordInputDisplayed());
	        Assert.assertTrue(changePasswordPage.areTogglePasswordButtonsDisplayed());
	        Assert.assertTrue(changePasswordPage.isSubmitButtonDisplayed());
	    }
	    

	  

	
	
}
