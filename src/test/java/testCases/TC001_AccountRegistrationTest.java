package testCases;

import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass{
	
	
	@Test(groups={"Regression", "Master"})
	public void registrationTest() {
		
		logger.info("****** Starting TC001_AccountRegistrationTest *****");
		
		try {
		HomePage hp=new HomePage(driver);
		hp.clickMyAccountlink();
		logger.info("Clicked on MyAccount Link");
		hp.myRegisterlink();
		logger.info("Clicked on MyRegister Link");
		
		
		AccountRegistrationPage regpage=new AccountRegistrationPage(driver);
		
		logger.info("Providing customer details.....");
		regpage.txtFirstName(randomString().toUpperCase());
		regpage.txtLastName(randomString().toUpperCase());
		regpage.emailField(randomString()+"@gmail.com");
		regpage.txtPhoneNumber(randomNumber());
		
		String password=randomAlphaNumeric(); // for common password
		logger.info("Creating dynamic password.....");
		regpage.newPassword(password);
		regpage.confirmPassword(password);
		logger.info("Creating Password.....");
		regpage.agreementPolicy();
		regpage.clickContinueButton();
		
        logger.info("Validating expected message");
		String msg=regpage.getConfirmationMsg();
		
		if(msg.equals("Your Account Has Been Created!")) {
			Assert.assertTrue(true);
		}
		else
		{
			logger.error("Test failed");
			logger.debug("Debug logs");
			Assert.assertTrue(false);
		}
	
		
		}
		
		catch(Exception e) {
		
			Assert.fail();
			
		}
		
		logger.info("****** Finished TC001_AccountRegistrationTest *****");
		
		
		
		}	
	}


