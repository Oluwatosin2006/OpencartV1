package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


public class ShoppingCartPage extends BasePage{
	
	
	public ShoppingCartPage(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"content\"]/form/div/table/tbody/tr/td[5]")
	@CacheLookup
	private WebElement unitPrice;
	
	@FindBy(how = How.XPATH, using = "//body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/table[1]/tbody[1]/tr[4]/td[2]")
	@CacheLookup
	private WebElement totalPrice;
	
	@FindBy(how = How.XPATH, using = "//a[@class='btn btn-primary']")
	@CacheLookup
	private WebElement clickCheckoutButton;
	
	@FindBy(how = How.XPATH, using = "//*[@class='alert alert-danger alert-dismissible']")
	@CacheLookup
	private WebElement txt_Message;
	
	@FindBy(how = How.XPATH, using = "//a[normalize-space()='Continue Shopping']")
	@CacheLookup
	private WebElement continueButton;
	
	@FindBy(how = How.XPATH, using = "	//*[@id=\"content\"]/form/div/table/tbody/tr/td[4]/div/input")
	@CacheLookup
	private WebElement modify;
	
	@FindBy(how = How.XPATH, using = "//*[@type='submit']")
	@CacheLookup
	private WebElement update;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"checkout-cart\"]/div[1]")
	@CacheLookup
	private WebElement getTextMessage;
	
	
	//*[@id="content"]/form/div/table/tbody/tr/td[4]/div/input

	//*[@id="checkout-cart"]/div[1]	

	
	public double getUnitPrice() {
		
		String unitprice=unitPrice.getText();
		String unit=unitprice.replaceAll("[^a-zA-Z0-9]", ""); // regular expression to remove $ and . sign
		double finalUnitPrice=Double.parseDouble(unit); // convert to double through wrapper class
		return finalUnitPrice/100;
	}
	
    public double getTotalPrice1() {
		
		String totalprice=totalPrice.getText();
		String total=totalprice.replaceAll("[^a-zA-Z0-9]", ""); // regular expression with blank "" to remove $ and . sign
		double finalTotalPrice=Double.parseDouble(total); // convert to double through wrapper class
		return finalTotalPrice/100; // to get the dot sign back
	}
    
   /* public void modifyQuantity(String modif) {
		
        //modify.clear();
		JavascriptExecutor js = (JavascriptExecutor)driver;   
		js.executeScript("arguments[0].setAttribute('value', 'modif')", modify);
	}
	
	public void updateQ() {
		
	    update.click();
		
	}*/
	
	public void clickCheckout() {
		
		clickCheckoutButton.click();
	}
	
	public String validateMessage() {
		
	    return txt_Message.getText();
	}
	
    public String validateSecondMessage() {
		
	    return getTextMessage.getText();
	}
	
	public void clickContinueButton() {
		
	    continueButton.click();
	}
	 
	//a[normalize-space()='Use Coupon Code']
			//id=input-coupon
			//id=button-coupon
			//div[@class='alert alert-danger alert-dismissible'] message
			
			//a[normalize-space()='Use Gift Certificate']
			//id=input-voucher
			//id=button-voucher
			//div[@class='alert alert-danger alert-dismissible']
			
			
			//a[normalize-space()='Continue Shopping']
			
			
}
