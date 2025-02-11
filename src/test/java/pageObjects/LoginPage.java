package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

	public LoginPage(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy(id="input-email")
	private WebElement myUsername;
	
	@FindBy(id="input-password")
	private WebElement myPassword;
	
	@FindBy(xpath="//*[@type='submit']")
	WebElement clickLogin;
	
	public void setEmail(String email) {
		
		myUsername.sendKeys(email);
	}
	
    public void setPassword(String pwd) {
		
		myPassword.sendKeys(pwd);
	}

    public void clickLoginButton() {
	
        clickLogin.click();;
}



}
