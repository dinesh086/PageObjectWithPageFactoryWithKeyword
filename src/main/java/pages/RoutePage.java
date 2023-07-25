package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


import base.BasePage;

public class RoutePage extends BasePage{

	public RoutePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div[1]/div[1]/h1")
	public WebElement routeLabel;
	
	
	public RoutePage typeText(WebElement element,String txt,String logMsg) {
		sendKeys(element, txt,logMsg);
		return this;
	}
	public String getErrTxt(WebElement e, String logMsg) throws Exception {
		String err = getText(e, logMsg);
		return err;
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
