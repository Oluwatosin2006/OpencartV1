package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.SearchProductPage;
import testBase.BaseClass;

public class TC006b_SearchProductTest extends BaseClass{
	
	@Test(groups={"Smoke"})
	public void searchProduct() {
		
        logger.info("****** Starting TC006_SearchProductTest *****");		
		try
		{

        HomePage hp= new HomePage(driver);
		hp.clickMyAccountlink();
		hp.clickLogin();
		logger.info("click on the login link");
		
		LoginPage lp =new LoginPage(driver);
		lp.setEmail(pro.getProperty("email"));
		lp.setPassword(pro.getProperty("password"));
		lp.clickLoginButton();
		logger.info("login with valid details");
		
		SearchProductPage searchProduct=new SearchProductPage(driver);
		searchProduct.searchField(pro.getProperty("searchProductName"));
		searchProduct.searchButton();
		searchProduct.iphoneImage();
		logger.info("search for Iphone");
		
		boolean search=searchProduct.vilidateSearchBreadcrum();
		
		Assert.assertTrue(search);   //Assert.assertEquals(search, true, "Login failed");
		}
		catch(Exception e)
		    
		{
			e.printStackTrace();
			Assert.fail();
		}
		
		
		logger.info("****** Finished TC006_SearchProductTest *****");
		
		
		
	}

}
