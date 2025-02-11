package testBase;


import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;

public class BaseClass {
	
	public static WebDriver driver;
	public Logger logger;
	public Properties pro;
	
	

	@BeforeClass(groups= {"Sanity", "Smoke", "Regression", "Master", "DataDriven"})
	@Parameters({"os", "browser"})
	public void setup(String os, String br) throws IOException, URISyntaxException   {
		
		//Loading config.properties file
		
		FileReader file1 =new FileReader(".\\resources\\config.properties");
		pro=new Properties();
		pro.load(file1);
		logger=LogManager.getLogger(this.getClass());
		
		if(pro.getProperty("execution_env").equalsIgnoreCase("remote")) {
			
			DesiredCapabilities cap= new DesiredCapabilities();
			
			//operating system set up
			
			if(os.equalsIgnoreCase("windows")) {
				
				cap.setPlatform(Platform.WIN10);
			}
			else if(os.equalsIgnoreCase("linux")) {
				
				cap.setPlatform(Platform.LINUX);
			}
			else if(os.equalsIgnoreCase("mac")) {
				
				cap.setPlatform(Platform.MAC);
			}
			else {
				System.out.println("No matching os");
				return;
			}
			
			//browser setup
			
			switch(br.toLowerCase())
			{
			case "chrome":cap.setBrowserName("chrome"); break;
			case "edge":cap.setBrowserName("MicrosoftEdge"); break;
			case "firefox":cap.setBrowserName("firefox"); break;
			default: System.out.println("No matching browser"); return;
			}
			
			String hubURL="http://localhost:4444/wd/hub";
			
			driver= new RemoteWebDriver(new URI(hubURL).toURL(), cap);
			//driver= new RemoteWebDriver(new URL(hubURL), cap); //this is used before java 20
		
		}

		
		
		if(pro.getProperty("execution_env").equalsIgnoreCase("local"))
		{

			switch(br.toLowerCase()) {
			
			case "chrome" : driver=new ChromeDriver(); break;
			case "firefox" : driver=new FirefoxDriver(); break;
			case  "edge" : driver=new EdgeDriver(); break;
			default: System.out.println("Invalid browser"); return;
		
			}
		
		}
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(pro.getProperty("appURL"));
		driver.manage().window().maximize();
		
		
     }
	
	
	@AfterClass(groups= {"Sanity", "Smoke", "Regression", "Master", "DataDriven"})
	public void tearDown() {
		
		driver.quit();
	      
	}
	
	public String randomString() {
		
		String generatedstring=RandomStringUtils.randomAlphabetic(5);
		return generatedstring;
		
	}
	
	public String randomNumber() {
		
		String generatednumber=RandomStringUtils.randomAlphanumeric(10);
		return generatednumber;
		
	}
	
	public String randomAlphaNumeric() {
		
		String generatedstring=RandomStringUtils.randomAlphabetic(3);
        String generatednumber=RandomStringUtils.randomAlphanumeric(3);
		return (generatedstring+"@"+generatednumber);
		
   }
	
	/* public static String captureScreenshot(String fileName){
     	
     	TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
     	File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
     	File destFile = new File("./Screenshots/"+ fileName);
     	try {
     		FileUtils.copyFile(sourceFile, destFile);
     	} catch (IOException e) {
     		e.printStackTrace();
     	}
     	System.out.println("Screenshot saved Successfully");
     	return destFile.getAbsolutePath();
     	
     	 
     }*/
     
    
     public String captureScreenShot(String tname) throws IOException {
		
		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		
		String targetFilePath=System.getProperty("user.dir")+ "\\screenshots\\" +tname + "_" +timeStamp + ".png";
		File targetFile = new File(targetFilePath);
		
		sourceFile.renameTo(targetFile);
		
		return targetFilePath;
		
		
	}
	
	
	
	}
	
	


