package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AddToCartPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import pageObjects.SearchProductPage;
import pageObjects.ShoppingCartPage;
import testBase.BaseClass;

public class TC009_EneToEndTest extends BaseClass{
	
	@Test(groups={"Master"})
	public void enetoendTest() {
		

		LoginPage lp;
		
		logger.info("****** Starting TC009_EndToEndTest *****");		
		try
		{
			HomePage hp= new HomePage(driver);
			hp.clickMyAccountlink();
			hp.clickLogin();
			
			
			lp =new LoginPage(driver);
			lp.setEmail(pro.getProperty("email"));
			lp.setPassword(pro.getProperty("password"));
			lp.clickLoginButton();
			
			SearchProductPage searchProduct=new SearchProductPage(driver);
			searchProduct.searchField(pro.getProperty("searchProductName"));
			searchProduct.searchButton();
			searchProduct.iphoneImage();
			logger.info("search for Iphone");
			
			AddToCartPage addtocart = new AddToCartPage(driver);
			addtocart.txt_Quantity(pro.getProperty("quantity"));
			addtocart.clickAddtocartButton();
			addtocart.shoppingCart();
	        logger.info("shopping cart message");
	        
	        ShoppingCartPage shoppingCart = new ShoppingCartPage(driver);
	        Double unitPrice=shoppingCart.getUnitPrice();
	        Double totalPrice=shoppingCart.getTotalPrice1();
	        Double totalExpectedPrice=(unitPrice*2)+4; //unitprice multiply by 4 and plus tax price
	        Assert.assertEquals(totalPrice, totalExpectedPrice);
	        shoppingCart.clickContinueButton();
	        
	        MyAccountPage myAccount= new MyAccountPage(driver);
	        myAccount.clickLogoutButton();
	    
		}
		catch(Exception e) {
			
			Assert.fail();
		}
	        
		
		logger.info("****** Finished TC009_EndToEndTest *****");
		

		
		
	}

}
