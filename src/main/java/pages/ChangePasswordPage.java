package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


import base.BasePage;

public class ChangePasswordPage extends BasePage{

	public ChangePasswordPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	@FindBy(xpath = "//h2[contains(text(), 'Change password')]")
    public WebElement changePasswordHeading;

    @FindBy(id = "newPassword")
    public WebElement newPasswordField;
 

    @FindBy(id = "confirmPassword")
    public WebElement confirmPasswordField;
    
    @FindBy(xpath = " //*[@id=\"root\"]/div[1]/div[2]/div[1]/div/form/div[1]/label")
    public WebElement newPasswordText;
    
    @FindBy(xpath = "//*[@id=\"root\"]/div[1]/div[2]/div[1]/div/form/div[2]/label")
    public WebElement confirmPasswordText;
    
    @FindBy(css = ".toggle-password-button")
    public WebElement newTogglePasswordButton;
 

    @FindBy(xpath = "//*[@id=\"root\"]/div[1]/div[2]/div[1]/div/form/div[2]/div/div/div/button")
    public WebElement confirmPasswordToggleButton;
    
    @FindBy(css = ".c-btn.login-button")
    public WebElement submitButton;
    
    @FindBy(css = ".password-criteria li")
    public List<WebElement> passwordCriteriaItems;

    public boolean isChangePasswordHeadingDisplayed() {
        return changePasswordHeading.isDisplayed();
    }
    public boolean isNewPasswordLabelDisplayed() {
        return newPasswordText.isDisplayed();
    }
    public boolean isConfirmPasswordLabelDisplayed() {
        return confirmPasswordText.isDisplayed();
    }
    public boolean isConfirmPasswordInputDisplayed() {
        return confirmPasswordField.isDisplayed();
    }
    public boolean isNewPasswordInputDisplayed() {
        return newPasswordField.isDisplayed();
    }
    public boolean areTogglePasswordButtonsDisplayed() {
        return newTogglePasswordButton.isDisplayed();
    }
    public boolean isNewPasswordVisible() {
         String password= newPasswordField.getAttribute("type");
         String expPassword = "text";
         if(password.equalsIgnoreCase(expPassword)) {
        	 return true;
        	
         }else {
        	 return false;
         }
    }
    public boolean isConfirmPasswordVisible() {
        String password= confirmPasswordField.getAttribute("type");
        String expPassword = "text";
        if(password.equalsIgnoreCase(expPassword)) {
       	 return true;
       	
        }else {
       	 return false;
        }
   }
   
    public boolean isSubmitButtonDisplayed() {
        return submitButton.isDisplayed();
    }
    public boolean isSubmitButtonEnabled() {
        return submitButton.isEnabled();
    }
   
    public void enterNewPassword(String newPassword) {
        newPasswordField.sendKeys(newPassword);
    }

    public void enterConfirmPassword(String confirmPassword) {
        confirmPasswordField.sendKeys(confirmPassword);
    }

    public void toggleNewPasswordVisibility() {
    	newTogglePasswordButton.click();
    }
    public void toggleConfirmPasswordVisibility() {
    	confirmPasswordToggleButton.click();
    }

    public void clickSubmitButton() {
        submitButton.click();
    }
    public int getPasswordCriteriaCount() {
        return passwordCriteriaItems.size();
    }

    public ChangePasswordPage clearField(WebElement e) {
		clear(e);
		return this;
	}


}
