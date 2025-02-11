package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AddToCartPage extends BasePage{
	
	
	public AddToCartPage(WebDriver driver) {
		super(driver);
		
	}
	
	
	@FindBy(how = How.ID, using = "input-quantity")
	@CacheLookup
	private WebElement quantityField;
	
	@FindBy(how = How.XPATH, using = "//*[@id='button-cart']")
	@CacheLookup
	private WebElement addtocartButton;
	
	@FindBy(how = How.XPATH, using = "//*[text()='shopping cart']")
	@CacheLookup
	private WebElement clickShoppingCart;
	
	
	
	public void txt_Quantity(String quant) {
		
		quantityField.clear();
		JavascriptExecutor js = (JavascriptExecutor)driver;   
		js.executeScript("arguments[0].setAttribute('value', 'quant')", quantityField);
		
    
	}
	
    public void clickAddtocartButton() {
		
        addtocartButton.click();
	}
    
    public void shoppingCart() {
		
    	clickShoppingCart.click();
	}
    
   
    
    
    //Success: You have added iPhone to your shopping cart!
  //*[text()='shopping cart']
    //Products marked with *** are not available in the desired quantity or not in stock!
  //*[@class='pull-right']//a
  //div[@class='alert alert-success alert-dismissible']

}
