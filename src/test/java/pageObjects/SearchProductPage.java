package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class SearchProductPage extends BasePage{
	
	
	public SearchProductPage(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy(how = How.XPATH, using = "//input[@placeholder='Search']")
	@CacheLookup
	private WebElement txt_Search;
	
	@FindBy(how = How.XPATH, using = "//button[@class='btn btn-default btn-lg']")//i[@class='fa fa-search']
	@CacheLookup
	private WebElement clickSearchButton;
	
	@FindBy(how = How.XPATH, using = "//*[@class='product-thumb']//img")
	@CacheLookup
	private WebElement clickIphoneImage;
	

	@FindBy( how = How.XPATH, using = "//a[normalize-space()='Search']")
	@CacheLookup
	private WebElement breadcrumSearch;
	

	
	
    public void searchField(String phone) {
    	
    	JavascriptExecutor js = (JavascriptExecutor)driver;   
		js.executeScript("arguments[0].setAttribute('value', 'phone')", txt_Search);
		
		//txt_Search.sendKeys(phone);
	}
	
    public void searchButton() {
		
		clickSearchButton.click();
	}
    
    public void iphoneImage() {
		
		clickIphoneImage.click();
	}
    
    public boolean vilidateSearchBreadcrum() {
	
	    return breadcrumSearch.isDisplayed();
    }

  //a[normalize-space()='Search']
    
    //Success: You have added iPhone to your shopping cart!
  //div[@class='alert alert-success alert-dismissible']
  //*[text()='shopping cart']
    //Products marked with *** are not available in the desired quantity or not in stock
  //div[@class='alert alert-danger alert-dismissible']
  //*[@class='pull-right']//a

}
