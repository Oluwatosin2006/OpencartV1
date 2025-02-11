 package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage{

	public MyAccountPage(WebDriver driver) {
		super(driver);

	}
	
	@FindBy(xpath="//h2[normalize-space()='My Account']")
	private WebElement myAccountIsDisplayed;
	
	@FindBy(xpath="//a[@class='list-group-item'][normalize-space()='Logout']")
	private WebElement clickLogout;
	
	public boolean accountDisplayed() {
		
		try
		{
		return myAccountIsDisplayed.isDisplayed();
		}
		catch(Exception e)
		{
			return false;
		}
	}
		
	public void clickLogoutButton() {
        
		clickLogout.click();
	}
	
	

}
