package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.XLUtils;

public class TC005_LoginDDTSecondExcel extends BaseClass{
	
	@Test(dataProvider="LoginData", groups={"Regression", "Master", "DataDriven"})
	public void loginDDTest(String email, String pwd, String exp) {
		

        logger.info("****** Starting TC005_LoginDDTSecondExcel *****");
		try
		{
		HomePage hp= new HomePage(driver);
		hp.clickMyAccountlink();
		hp.clickLogin();
		
		LoginPage lp =new LoginPage(driver);
		lp.setEmail(email);
		lp.setPassword(pwd);
		lp.clickLoginButton();
		
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
			

		logger.info("****** Finished TC005_LoginDDTSecondExcel *****");

		
	}
	
	@DataProvider(name="LoginData")
	String [][] getData() throws IOException{
		
		String path=".\\testData\\DDT.xlsx";
		
		int rownum=XLUtils.getRowCount(path, "loginDDT");
		int colnum=XLUtils.getCellCount(path, "loginDDT", 1);
		
		String logindata[][]=new String[rownum][colnum];
		
		for(int i=1;i<=rownum;i++) {
			
			for(int j=0;j<colnum;j++) {
				
				logindata[i-1][j]=XLUtils.getCellData(path, "loginDDT", i, j);
				
			}
		}
		return logindata;
		
	}

}
