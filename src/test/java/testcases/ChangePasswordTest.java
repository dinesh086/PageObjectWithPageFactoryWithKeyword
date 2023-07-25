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


public class ChangePasswordTest extends BaseTest {

	
	LoginPage loginPage;
	DashboardPage homePage;
	JSONObject loginUsers;
	ChangePasswordPage changePasswordPage;

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
		
		 
		  changePasswordPage = new ChangePasswordPage(driver);
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
	    

	    @Test
	    public void testPasswordCriteriaCount() {
	        // Verify the number of password criteria items
	        int expectedCriteriaCount = 4;
	        int actualCriteriaCount = changePasswordPage.getPasswordCriteriaCount();
	        Assert.assertEquals(expectedCriteriaCount, actualCriteriaCount);
	    } 

	   @Test
	    public void testValidNewPasswordEnablesSubmitButton() {
		   changePasswordPage.clear(changePasswordPage.newPasswordField);
		   changePasswordPage.clear(changePasswordPage.confirmPasswordField);
	        // Enter a valid new password
	        String newPassword = "ValidPassword123";
	        changePasswordPage.enterNewPassword(newPassword);

	        // Verify that the "Submit" button is enabled
	        Assert.assertTrue(changePasswordPage.isSubmitButtonEnabled());
	    }
	   

	   @Test
	    public void testInvalidNewPasswordDisablesSubmitButton() {
		   changePasswordPage.clear(changePasswordPage.newPasswordField);
		   changePasswordPage.clear(changePasswordPage.confirmPasswordField);
	        // Enter an invalid new password
	        String newPassword = "invalid";
	        changePasswordPage.enterNewPassword(newPassword);

	        // Verify that the "Submit" button is disabled
	        Assert.assertFalse(changePasswordPage.isSubmitButtonEnabled());
	    }

	   
	
	    @Test
	    public void testValidNewPasswordAndConfirmPasswordEnablesSubmitButton() {
	        // Enter a valid new password and confirm it
	        String newPassword = "ValidPassword123";
	        changePasswordPage.enterNewPassword(newPassword);
	        changePasswordPage.enterConfirmPassword(newPassword);

	        // Verify that the "Submit" button is enabled
	        Assert.assertTrue(changePasswordPage.isSubmitButtonEnabled());
	    }
	    

	    @Test
	    public void testInvalidNewPasswordAndConfirmPasswordDisablesSubmitButton() {
	    	// changePasswordPage.clear(changePasswordPage.newPasswordField);
			  // changePasswordPage.clear(changePasswordPage.confirmPasswordField);
	        // Enter an invalid new password and confirm it
	        String newPassword = "invalid";
	        changePasswordPage.enterNewPassword(newPassword);
	        changePasswordPage.enterConfirmPassword(newPassword);

	        // Verify that the "Submit" button is disabled
	        Assert.assertFalse(changePasswordPage.isSubmitButtonEnabled());
	    }

	 
	    @Test
	    public void testSubmitButtonTriggersPasswordChangeProcess() {
	        // Click the "Submit" button
	        changePasswordPage.clickSubmitButton();

	        // Add appropriate assertions to verify that the password change process is triggered
	        // ...
	    }
	    
	    
	    
	    @Test
	    public void testToggleNewPasswordVisibility() {
	    	//String newPassword = "ValidPassword123";
	       // changePasswordPage.enterNewPassword(newPassword);
	        // Toggle the visibility of the "New password" field
	        changePasswordPage.toggleNewPasswordVisibility();
             try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        // Verify that the password is visible
	        Assert.assertTrue(changePasswordPage.isNewPasswordVisible());

	        // Toggle the visibility of the "New password" field again
	        changePasswordPage.toggleNewPasswordVisibility();

	        // Verify that the password is hidden
	        Assert.assertFalse(changePasswordPage.isNewPasswordVisible());
	    }

	    @Test
	    public void testToggleConfirmPasswordVisibility() {
	        // Toggle the visibility of the "Confirm password" field
	        changePasswordPage.toggleConfirmPasswordVisibility();

	        // Verify that the password is visible
	        Assert.assertTrue(changePasswordPage.isConfirmPasswordVisible());

	        // Toggle the visibility of the "Confirm password" field again
	        changePasswordPage.toggleConfirmPasswordVisibility();

	        // Verify that the password is hidden
	        Assert.assertFalse(changePasswordPage.isConfirmPasswordVisible());
	    }

	
	
}
