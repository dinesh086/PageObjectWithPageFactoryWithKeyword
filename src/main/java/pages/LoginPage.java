package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


import base.BasePage;

public class LoginPage extends BasePage{

	public LoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath = "//*[@id=\"email\"]")
	public WebElement emailTxt;
	@FindBy(xpath = "//*[@id=\"password\"]")
	public WebElement passwordTxt;
	@FindBy(xpath = "//*[@id=\"root\"]/div[1]/div[2]/div[1]/div/form/button")
	public WebElement loginBtn;
	@FindBy(xpath = "//*[@id=\"root\"]/div[1]/div[2]/div[1]/div/form/div[1]/div[2]")
	public WebElement emailValidationText;
	@FindBy(xpath = "//*[@id=\"root\"]/div[1]/div[2]/div[1]/div/form/div[2]/div[2]")
	public WebElement passwordValidationText;
	
	@FindBy(xpath = "//*[@id=\"root\"]/div[1]/div[2]/div[1]/div/p/following-sibling::div[@class='alert alert-danger']")
	public WebElement validationText;
	
	@FindBy(xpath = "//*[@id=\"root\"]/div[1]/div[2]/div[1]/div/div[3]/a")
	public WebElement forgottenPassword;
	
	@FindBy(xpath = "//*[@id=\"root\"]/div[1]/div[2]/div[1]/div/div[2]/a")
	public WebElement forgottenPasswordForPage;
	
	 public boolean isForgottenPasswordDisplayed() {
	        return forgottenPassword.isDisplayed();
	    }
	 
	 
	    public LoginPage enterUserEmail(String email) {
	 		clear(emailTxt);	
			sendKeys(emailTxt, email, "email entered");
			return this;
		}

		public LoginPage enterPassword(String password) {
			clear(passwordTxt);
			sendKeys(passwordTxt, password, "password entered");
			return this;
		}

		public RoutePage pressLoginBtn() {
			click(loginBtn, "login button clicked");
			return new RoutePage(driver);
		}
		
		public ForgotPasswordPage pressForgotPasswordPageButtonForLoginPage() {
			click(forgottenPassword, "ForgottenPassword button clicked");
			return new ForgotPasswordPage(driver);
		}
		public ForgotPasswordPage pressForgotPasswordPageButtonForForgotPasswordPage() {
			click(forgottenPasswordForPage, "ForgottenPassword button clicked");
			return new ForgotPasswordPage(driver);
		}

		public RoutePage login(String username, String password) {
			enterUserEmail(username);
			enterPassword(password);
			return pressLoginBtn();
		}

		
		

	public String getErrTxt(WebElement e, String logMsg) throws Exception {
		String err = getText(e, logMsg);
		return err;
	}

	public LoginPage clearField(WebElement e) {
		clear(e);
		return this;
	}
}
