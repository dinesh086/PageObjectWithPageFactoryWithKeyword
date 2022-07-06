package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


import base.BasePage;

public class WebCartPage extends BasePage{

	public WebCartPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath = "//*[@id=\"post-1220\"]/div/div/div/div/div[2]/div/div/a")
	public WebElement proceedToCheckoutBtn;
	
	
	
	public WebCheckoutPage pressProceedToCheckoutBtn() {
		click(proceedToCheckoutBtn,"Clicked on Checkout Button");
		return new WebCheckoutPage(driver);
	}
}
