package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


import base.BasePage;

public class WebCheckoutPage extends BasePage{

	public WebCheckoutPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath = "//*[@id=\"billing_first_name\"]")
	public WebElement firstName;
	@FindBy(xpath = "//*[@id=\"billing_last_name\"]")
	public WebElement lastName;
	@FindBy(xpath = "//*[@id=\"billing_address_1\"]")
	public WebElement streetAddress;
	@FindBy(xpath = "//*[@id=\"billing_city\"]")
	public WebElement townCity;
	@FindBy(xpath = "//*[@id=\"billing_postcode\"]")
	public WebElement postcode;
	@FindBy(xpath = "//*[@id=\"billing_email\"]")
	public WebElement emailAddress;	
	@FindBy(xpath = "//*[@id=\"place_order\"]")
	public WebElement placeAnOrderBtn;
	
	public WebCheckoutPage typefirstName() {
		type(firstName, "Dinesh",", in First name text box");
		return new WebCheckoutPage(driver);
	}
	public WebCheckoutPage typeLastName() {
		type(lastName, "Kumar", ", in Last name text box");
		return new WebCheckoutPage(driver);
	}
	public WebCheckoutPage typeAddresDetails() {
		type(streetAddress, "San Francisco", ", in Address text box");
		return new WebCheckoutPage(driver);
	}
	public WebCheckoutPage typeTownCity() {
		type(townCity, "San Francisco", ", in Town City text box");
		return new WebCheckoutPage(driver);
	}
	public WebCheckoutPage typePostcode() {
		type(postcode, "94188", ", in Postcode text box");
		return new WebCheckoutPage(driver);
	}
	public WebCheckoutPage typeEmail() {
		type(emailAddress, "dineshkumar@gmail.com", ", in Email text box");
		return new WebCheckoutPage(driver);
	}
	public WebOrderReceivedPage pressAnOrderBtn() {
		click(placeAnOrderBtn, "Placed an order by clicking on Order Button");
		return new WebOrderReceivedPage(driver);
	}
}
