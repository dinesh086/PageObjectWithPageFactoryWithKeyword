package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


import base.BasePage;

public class WebStorePage extends BasePage{

	public WebStorePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath = "//*[@id=\"woocommerce-product-search-field-0\"]")
	public WebElement searchTxtBox;
	
	@FindBy(xpath = "//*[@id=\"woocommerce_product_search-1\"]/form/button")
	public WebElement searchBtn;
	
	@FindBy(xpath = "//*[@id=\"main\"]/div/ul/li[1]/div[2]/a[2]")
	public WebElement firstItem;
	
	@FindBy(xpath = "//*[@id=\"main\"]/div/ul/li[1]/div[2]/a[3]")
	public WebElement firstItemViewCart;
	
	public WebStorePage typeSearchTxtBox() {
		type(searchTxtBox,"blue",", in Search box");
		return new WebStorePage(driver);
	}
	public WebStorePage pressSearchBtn() {
		click(searchBtn, "Clicked on Search Button");
		return new WebStorePage(driver);
	}
	public WebStorePage pressFirstItem() {
		click(firstItem, "Clicked on First Item");
		return new WebStorePage(driver);
	}
	public WebCartPage pressFirstItemViewCart() {
		click(firstItemViewCart,"Clicked on First Item View Cart");
		return new WebCartPage(driver);
	}
	
}
