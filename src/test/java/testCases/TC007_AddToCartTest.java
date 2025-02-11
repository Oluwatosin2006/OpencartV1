package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AddToCartPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.SearchProductPage;
import pageObjects.ShoppingCartPage;
import testBase.BaseClass;

public class TC007_AddToCartTest extends BaseClass{
	
	@Test(groups={"Smoke", "Master"})
	public void addtocartTest() {
		
        logger.info("****** Starting TC007_AddToCartTest *****");		
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
		searchProduct.searchField(pro.getProperty("searchPruductName"));
		searchProduct.searchButton();
		searchProduct.iphoneImage();
		logger.info("search for Iphone");
		
		AddToCartPage addtocart = new AddToCartPage(driver);
		addtocart.txt_Quantity(pro.getProperty("quantity"));
		addtocart.clickAddtocartButton();
		addtocart.shoppingCart();
        logger.info("shopping cart message");
        
        ShoppingCartPage shopcart = new ShoppingCartPage(driver);
        String txt_Mess=shopcart.validateMessage();
        
        Assert.assertEquals(txt_Mess, pro.getProperty("shoppingMsg"));
		
		/*if(txt_Mess.equals(pro.getProperty("shoppingMsg"))) {
			
			Assert.assertTrue(true);
			logger.info("validation passed");
		}
		else
		{
			Assert.assertTrue(false);
			logger.info("validation failed");
		}*/
		
		
		}
		
		catch(Exception e)
		{
			e.getMessage();
			Assert.fail();
		}
		
		
            logger.info("****** Finished TC007_AddToCartTest *****");
		
			
	}

}
