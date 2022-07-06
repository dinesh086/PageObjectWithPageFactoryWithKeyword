package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.BasePage;

public class NewCarPage extends BasePage{
	
	
	
	public NewCarPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(linkText = "Toyota")
	public WebElement toyota;
	
	@FindBy(linkText = "Hyundai")
	public WebElement hyundai;
	
	@FindBy(linkText = "BMW")
	public WebElement bmw;


	public ToyotoCarPage gotoToyota() {
		
		//toyota.click();
		click(this.toyota, "Clicked on Toyota");
		return new ToyotoCarPage(driver);
	}
	
	
	public HyundaiCarPage gotoHyundai() {
		
		//hyundai.click();
		click(this.hyundai,"Clicked on Hyundai");
		
		return new HyundaiCarPage(driver);
	}
	
	
	public BMWCarPage gotoBMW() {
		
		//bmw.click();
		click(this.bmw, "Clicked on BMW");
		
		return new BMWCarPage(driver);
	}

}
