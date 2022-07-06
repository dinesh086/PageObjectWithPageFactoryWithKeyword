package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


import base.BasePage;

public class WebHomePage extends BasePage{

	public WebHomePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath = "//*[@id=\"post-61\"]/div/div[1]/div/div/div/div/div[1]/a")
	public WebElement shopNowBtn;
	
	public WebStorePage pressShopNowBtn() {
		click(shopNowBtn,"Clicked on Shop Now Button");
		return new WebStorePage(driver);
	}
}
