package testCases;


import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.ExcelProvider;


public class TC004_LoginDDTExcel extends BaseClass{
	
	
	
	@Test(dataProviderClass=ExcelProvider.class, dataProvider="TestLogin",  groups={"Sanity", "Master", "DataDriven"})
	public void loginDDT(String user, String pass, String exp) {
		
        logger.info("****** Starting TC004_LoginDDTExcel *****");		
		try
		{
        //HomePage Object
        HomePage hp= new HomePage(driver);
		hp.clickMyAccountlink();
		hp.clickLogin();
		
		//LoginPage Object
		LoginPage lp =new LoginPage(driver);
		
	
		lp.setEmail(user);
		lp.setPassword(pass);
		lp.clickLoginButton();
		
		//MyAccountPage Object
		MyAccountPage myAccount=new MyAccountPage(driver);
		boolean targetPge=myAccount.accountDisplayed();
		
		if(exp.equalsIgnoreCase("Valid"))
		{
			if(targetPge==true)
			{
				myAccount.clickLogoutButton();
				Assert.assertTrue(true);
			}
			else {
		
				Assert.assertTrue(false);
			}
			
		}
			
			if(exp.equalsIgnoreCase("Invalid"))
			{
				if(targetPge==true) {
					
					myAccount.clickLogoutButton();
					Assert.assertTrue(false);
				}
				else {
					
					Assert.assertTrue(true);
				}
			}
			
		

		
		}
		catch(Exception e) {
			
			Assert.fail();
			
		}
		
		logger.info("****** Finished TC004_LoginDDTExcel *****");
		
		
		}		


}
