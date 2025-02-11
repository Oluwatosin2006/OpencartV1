package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AddToCartPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.SearchProductPage;
import pageObjects.ShoppingCartPage;
import testBase.BaseClass;

public class TC008_ShoppingCartTest extends BaseClass{
	
	@Test(groups={"Sanity", "Master"})
	public void shoppingTest() {
		
        logger.info("****** Starting TC008_ShoppingCartTest *****");		
		try
		{
			HomePage hp= new HomePage(driver);
			hp.clickMyAccountlink();
			hp.clickLogin();
			
			
			LoginPage lp =new LoginPage(driver);
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
	        
	        //shoppingCart.modifyQuantity(pro.getProperty("quantity"));
	        //shoppingCart.updateQ();
	        
	        //String secondMessage=shoppingCart.validateSecondMessage();
	        //Assert.assertEquals(secondMessage, pro.getProperty("modify"));
	        
	        shoppingCart.clickCheckout();
	        //shoppingCart.clickContinueButton();
	        
	        /*String txt_Message=shoppingCart.validateMessage();
			
			if(txt_Message.equals(pro.getProperty("shoppingMsg"))) {
				
				Assert.assertTrue(false);
				logger.info("validation passed");
				//.clickContinueButton();
				
			}
			else
			{
				Assert.assertTrue(true);
				logger.info("validation failed");
				shoppingCart.clickContinueButton();
			}*/
			
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Assert.fail();
		}
		
		
		logger.info("****** Finished TC008_ShoppingCartTest *****");
		


		
	}

}
