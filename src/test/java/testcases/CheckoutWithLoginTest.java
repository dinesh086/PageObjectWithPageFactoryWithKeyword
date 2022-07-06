package testcases;
import org.testng.annotations.Test;
import base.BaseTest;
import pages.WebCartPage;
import pages.WebCheckoutPage;
import pages.WebHomePage;
import pages.WebOrderReceivedPage;
import pages.WebStorePage;

public class CheckoutWithLoginTest extends BaseTest {

	WebHomePage webHomePage;	
	WebStorePage webStorePage;	
	WebCartPage webCartPage;	
	WebCheckoutPage webCheckoutPage;
	WebOrderReceivedPage webOrderReceivedPage;
		
	  @Test(priority=1)
	  public void MyFirstTestCase() throws Exception {
		  webHomePage = new WebHomePage(driver);
		  webStorePage = webHomePage.pressShopNowBtn();
		  webCartPage = webStorePage.typeSearchTxtBox().pressSearchBtn().pressFirstItem().pressFirstItemViewCart();
		  webCheckoutPage= webCartPage.pressProceedToCheckoutBtn();
		  webOrderReceivedPage = webCheckoutPage.typefirstName().typeLastName().typeAddresDetails().typeTownCity().typePostcode().typeEmail().pressAnOrderBtn();
	      Thread.sleep(10000);
	  
	  }
	  
	
}
