package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage{
	
      
	public AccountRegistrationPage(WebDriver driver) {
		
		super(driver);
	}
	
	
	@FindBy(xpath="//input[@id='input-firstname']")
	private WebElement txt_Firstname;
	
	@FindBy(xpath="//input[@id='input-lastname']")
	
	private WebElement txt_Lastname;
	
	@FindBy(xpath="	//input[@id='input-email']")
	
	private WebElement txt_Email;

    @FindBy(xpath="//input[@id='input-telephone']")
 
    private WebElement txt_PhNumber;
    
    @FindBy(xpath="//input[@id='input-password']")

    private WebElement createPassword;

    @FindBy(xpath="//input[@id='input-confirm']")
    
    private WebElement confirmPassword;

	@FindBy(xpath="//input[@name='agree']")

	private WebElement policyAgreement;
    
	@FindBy(xpath="//input[@value='Continue']")

	private WebElement continueButton ;
	
	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
	private WebElement msgConfirmation;



   public void txtFirstName(String firstName) {
		
		txt_Firstname.sendKeys(firstName);
	}
	
	public void txtLastName(String lastName) {
		
		txt_Lastname.sendKeys(lastName);;
	}
    public void emailField(String email) {
        txt_Email.sendKeys(email);
    }
    
    public void txtPhoneNumber(String phone) {
	
	txt_PhNumber.sendKeys(phone);
   }
    
    public void newPassword(String pwd) {
	
	createPassword.sendKeys(pwd);
   }
   
    public void confirmPassword(String pwd) {
	
	confirmPassword.sendKeys(pwd);
   }
   
    public void agreementPolicy() {
	
	   policyAgreement.click();
   }	

   public void clickContinueButton() {
	   
	   //sol1
	   continueButton.click();
	   
	   /*sol2 using submit method
	   continueButton.submit();
	   
	   sol3 using Actions method
	   Actions act=new Actions(driver);
	   act.moveToElement(continueButton).click().perform();
	   
	   sol4 using JavaStript Interface
	   JavascriptExecutor js=(JavascriptExecutor)driver;
	   js.executeScript("arguments[0].click();", continueButton);
	   
	   sol5 using sendKey method and RETURN or ENTER
	   continueButton.sendKeys(Keys.RETURN);
	   
	   sol6 using WebDriverWait
	   WebDriverWait mywait = new WebDriverWait(driver, Duration.ofSeconds(10));
	   mywait.until(ExpectedConditions.elementToBeClickable(continueButton)).click();
	   */
	   
	   
	   
  }
   
  public String getConfirmationMsg() {
	  
	  try { 
	   return msgConfirmation.getText();
	  } catch(Exception e) {
		  return (e.getMessage());
	  }
	
  }

}
