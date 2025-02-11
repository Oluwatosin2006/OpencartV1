package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders_ExcelUtility;

public class TC003_LoginDDTDataProvider extends BaseClass{
	
	@Test(dataProvider="LoginTest", dataProviderClass=DataProviders_ExcelUtility.class, groups={"Regression", "Master", "DataDriven"})
	public void loginDDT(String email, String pwd, String exp) throws InterruptedException {
		
        logger.info("****** Starting TC002_LoginTest *****");		
		try
		{
        //HomePage Object
        HomePage hp= new HomePage(driver);
		hp.clickMyAccountlink();
		hp.clickLogin();
		
		//LoginPage Object
		LoginPage lp =new LoginPage(driver);
		lp.setEmail(email);
		lp.setPassword(pwd);
		lp.clickLoginButton();
		
		//MyAccountPage Object
		MyAccountPage myAccount=new MyAccountPage(driver);
		boolean targetPage=myAccount.accountDisplayed();
		
		if(exp.equalsIgnoreCase("Valid"))
		{
			if(targetPage==true)
			{
				myAccount.clickLogoutButton();
				Assert.assertTrue(true);
			}
			else
			{
				Assert.assertTrue(false);
			}
			
		}
			
			if(exp.equalsIgnoreCase("Invalid"))
			{
				if(targetPage==true) {
					
					myAccount.clickLogoutButton();
					Assert.assertTrue(false);
				}
				else {
					
					Assert.assertTrue(true);
				}
			}
		
		}catch(Exception e) {
			
			Assert.fail();
			
		}
		Thread.sleep(3000);
		logger.info("****** Finished TC003_LoginDDT *****");
		
		
		}		

}
