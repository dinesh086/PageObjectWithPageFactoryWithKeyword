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
import pages.RoutePage;


public class LoginTest extends BaseTest {

	
	LoginPage loginPage;
	DashboardPage homePage;
	RoutePage routePage;
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
			routePage = new RoutePage(driver);
	  }
	
	  @Test(priority=0)
	  public void testBlankEmailPassword() throws Exception {
		  loginPage.pressLoginBtn();
		  String actualEmailValidation = loginPage.getErrTxt(loginPage.emailValidationText,"Verfied Email validation Text");
		  String expectedEmailValidation = strings.get("EmailValidationMsg");
		  String actualPasswordValidation = loginPage.getErrTxt(loginPage.passwordValidationText,"Verfied Password validation Text");
		  String expectedPasswordValidation = strings.get("PasswordValidationMsg");
		  Assert.assertEquals(actualEmailValidation, expectedEmailValidation);
		  Assert.assertEquals(actualPasswordValidation, expectedPasswordValidation);
		
	  }
	  @Test(priority=1)
	  public void testInvalidEmail() throws Exception {
		  loginPage.enterUserEmail(loginUsers.getJSONObject("invalidEmail").getString("email"));
		  loginPage.enterPassword(loginUsers.getJSONObject("invalidEmail").getString("password"));
		  loginPage.pressLoginBtn();
		  String actualErrTxt = loginPage.getErrTxt(loginPage.validationText, "InvalidEmail and Password verification");
		  String expectedErrTxt = strings.get("LoginErrorMsg");
		  Assert.assertEquals(actualErrTxt, expectedErrTxt);
		
	  }
	  @Test(priority=2)
	  public void testInvalidPassword() throws Exception {
		  loginPage.clear(loginPage.emailTxt);
		  loginPage.clear(loginPage.passwordTxt);
		  loginPage.enterUserEmail(loginUsers.getJSONObject("invalidPassword").getString("email"));
		  loginPage.enterPassword(loginUsers.getJSONObject("invalidPassword").getString("password"));
		  loginPage.pressLoginBtn();
		  String actualErrTxt = loginPage.getErrTxt(loginPage.validationText, "InvalidEmail and Password verification");
		  String expectedErrTxt = strings.get("LoginErrorMsg");
		  Assert.assertEquals(actualErrTxt, expectedErrTxt);
	  }
	
	  @Test(priority=3)
	    public void testForgottenPasswordElement() {
	        // Verify the presence and visibility of all elements on the change login screen
	        Assert.assertTrue(loginPage.isForgottenPasswordDisplayed());
	        
	    }
	   
	    
	  @Test(priority=4)
	  public void testForgotPasswordLinkTest() {
		  loginPage.pressForgotPasswordPageButtonForLoginPage();
	      String expectedUrl = "https://wbtransit.azurewebsites.net/forget-password";
	      String actualUrl = driver.getCurrentUrl();
	      Assert.assertEquals(actualUrl, expectedUrl, "Forgot password link redirection failed!");
	      driver.navigate().back();
	  }
	 
	  
	  @Test(priority=5)
	  public void testValidUser() throws Exception {
		  loginPage.clear(loginPage.emailTxt);
		  loginPage.clear(loginPage.passwordTxt);
		  loginPage.enterUserEmail(loginUsers.getJSONObject("validUser").getString("email"));
		  loginPage.enterPassword(loginUsers.getJSONObject("validUser").getString("password"));
		  loginPage.pressLoginBtn();
		  String actualErrTxt = routePage.getErrTxt(routePage.routeLabel, "Checking Route Page Heading");
		  String expectedErrTxt = strings.get("heading");
		  Assert.assertEquals(actualErrTxt, expectedErrTxt);
	  
	  }
	  
}
