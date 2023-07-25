package testcases;
import java.io.InputStream;
import java.lang.reflect.Method;

import org.json.JSONObject;
import org.json.JSONTokener;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import base.BaseTest;
import pages.DashboardPage;
import pages.LoginPage;
import pages.ForgotPasswordPage;
import pages.RoutePage;


public class ForgotPasswordTest extends BaseTest {


	LoginPage loginPage;
	DashboardPage homePage;
	RoutePage routePage;
	JSONObject loginUsers;
	ForgotPasswordPage forgotPasswordPage;

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
		forgotPasswordPage = loginPage.pressForgotPasswordPageButtonForForgotPasswordPage();


	}


	@Test
	public void testValidEmail() {
		// Enter a valid email and click Submit

		forgotPasswordPage.enterEmail("valid_email@example.com");
		forgotPasswordPage.clickSubmitButton();

		// Assert the success message or perform other validations
		// ...
	}

	@Test
	public void testInvalidEmail() {
		// Enter an invalid email and click Submit
		forgotPasswordPage.enterEmail("invalid_email");
		forgotPasswordPage.clickSubmitButton();

		// Assert the error message or perform other validations
		// ...
	}

	@Test
	public void testEmptyEmail() {
		// Leave the email field empty and click Submit
		forgotPasswordPage.clickSubmitButton();

		// Assert the error message or perform other validations
		// ...
	}
}
