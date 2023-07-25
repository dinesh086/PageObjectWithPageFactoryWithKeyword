package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


import base.BasePage;

public class DashboardPage extends BasePage{

	public DashboardPage(WebDriver driver) {
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
	@FindBy(xpath = "//*[@id=\"billing_email\"]")
	public WebElement emailAddress;	
	@FindBy(xpath = "//*[@id=\"place_order\"]")
	public WebElement placeAnOrderBtn;
	
	public DashboardPage typeText(WebElement element,String txt,String logMsg) {
		sendKeys(element, txt,logMsg);
		return this;
	}
	/*
	public LoginPage typefirstName() {
		type(firstName, "Dinesh",", in First name text box");
		return new LoginPage(driver);
	}
	public LoginPage typeLastName() {
		type(lastName, "Kumar", ", in Last name text box");
		return new LoginPage(driver);
	}
	public LoginPage typeAddresDetails() {
		type(streetAddress, "San Francisco", ", in Address text box");
		return new LoginPage(driver);
	}
	public LoginPage typeTownCity() {
		type(townCity, "San Francisco", ", in Town City text box");
		return new LoginPage(driver);
	}
	public LoginPage typePostcode() {
		type(postcode, "94188", ", in Postcode text box");
		return new LoginPage(driver);
	}
	public LoginPage typeEmail() {
		type(emailAddress, "dineshkumar@gmail.com", ", in Email text box");
		return new LoginPage(driver);
	}
	
	public WebOrderReceivedPage pressAnOrderBtn() {
		click(placeAnOrderBtn, "Placed an order by clicking on Order Button");
		return new WebOrderReceivedPage(driver);
	}
	*/
	
}
