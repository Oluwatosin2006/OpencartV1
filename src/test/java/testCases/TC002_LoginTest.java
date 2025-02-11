package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass{
	
	@Test(groups={"Sanity", "Master"})
	public void loginTest() {
		
        logger.info("****** Starting TC002_LoginTest *****");		
		try
		{
        //Create HomePage Object
        HomePage hp= new HomePage(driver);
		hp.clickMyAccountlink();
		hp.clickLogin();
		
		//Create LoginPage Object
		LoginPage lp =new LoginPage(driver);
		lp.setEmail(pro.getProperty("email"));
		lp.setPassword(pro.getProperty("password"));
		lp.clickLoginButton();
		
		//Create MyAccountPage Object
		MyAccountPage myAccount=new MyAccountPage(driver);
		boolean targetPge=myAccount.accountDisplayed();
		
		Assert.assertTrue(targetPge);   //Assert.assertEquals(targetPge, true, "Login failed");
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		
		
		logger.info("****** Finished TC002_LoginTest *****");
		
		
		
	}

}
