package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


import base.BasePage;

public class ForgotPasswordPage extends BasePage{

	public ForgotPasswordPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	    @FindBy(xpath = "//*[@id=\"email\"]")
	    private WebElement emailField;

	    @FindBy(xpath = "//*[@id=\"root\"]/div[1]/div[2]/div[1]/div/form/button")
	    private WebElement submitButton;

	    @FindBy(xpath = "//*[@id=\"root\"]/div[1]/div[2]/div[1]/div/div[2]/a")
		public WebElement forgottenPasswordForPage;
	 

	    public void enterEmail(String email) {
	        emailField.sendKeys(email);
	    }

	    public void clickSubmitButton() {
	        submitButton.click();
	    }
	    
	    public ForgotPasswordPage pressForgotPasswordPageButtonForForgotPasswordPage() {
			click(forgottenPasswordForPage, "ForgottenPassword button clicked");
			return this;
		}
	  
}

