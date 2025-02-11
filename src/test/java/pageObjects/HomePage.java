package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
	
	public HomePage(WebDriver driver) {
		
		super(driver);
	}
	
	
	@FindBy(xpath="//span[normalize-space()='My Account']")
	private WebElement myAccountlink;
	
	@FindBy(xpath="//a[normalize-space()='Register']")
	WebElement registerLink;
	
	@FindBy(linkText="Login")
	private WebElement loginLink;
	
	public void clickMyAccountlink() {
		
		myAccountlink.click();
	}
	
	public void myRegisterlink() {
		
		registerLink.click();
	}
	 
	public void clickLogin() {
		
		loginLink.click();
	}

}
