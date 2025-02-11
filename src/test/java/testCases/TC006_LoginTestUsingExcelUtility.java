package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders_ExcelUtility;



    
    public class TC006_LoginTestUsingExcelUtility extends BaseClass{
    	
    	
    @Test(dataProvider="LoginData", dataProviderClass=DataProviders_ExcelUtility.class, groups={"Master", "DataDriven"}) // getting data provider drom different class
    public void loginExcelUtil(String email, String password, String exp) {
	
	logger.info("****** Starting TC006_LoginTestUsingExcelUtility *****");		
	try {
    HomePage hp= new HomePage(driver);
	hp.clickMyAccountlink();
	hp.clickLogin();
	
	LoginPage lp =new LoginPage(driver);
	lp.setEmail(email);
	lp.setPassword(password);
	lp.clickLoginButton();
	
	MyAccountPage myAccount=new MyAccountPage(driver);
	boolean targetPage=myAccount.accountDisplayed();
	
	/*Data is valid - login success - test pass - logout
	                  login failed - test fail
	 
	 * Data is invalid - login success -test fail - logout
	                     login failed - test pass 
	 */
	
	if(exp.equalsIgnoreCase("valid")) {
		
		if(targetPage==true) {
			
			myAccount.clickLogoutButton();
			Assert.assertTrue(true);
			
		}
		else {
			
			Assert.assertTrue(false);
		}
	}
	
	if(exp.equalsIgnoreCase("invalid")) {
		
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
	
	logger.info("****** TC006_LoginTestUsingExcelUtility *****");

}
    }
