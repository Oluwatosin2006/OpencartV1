package utilities;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.List;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import testBase.BaseClass;
     
     

    public class Reporting implements ITestListener{
    	
    	public ExtentReports extent;
    	public ExtentSparkReporter spark;
    	public ExtentTest test;
    	ITestResult result;
    	ITestContext testContext;
    	
    	
      
    public void extentreport() throws IOException {
    	    
    	    extent = new ExtentReports();
    	    File file = new File("reports.html");
            spark = new ExtentSparkReporter(file);
            extent.attachReporter(spark);
            
            spark.config().setDocumentTitle("opencart Automation Report"); // title of report
    		spark.config().setReportName("opencart Function Testing"); // name of the report
    		spark.config().setTheme(Theme.DARK);
    		
    		extent = new ExtentReports();
    		extent.attachReporter(spark);
    		extent.setSystemInfo("Application", "opencart");
    		extent.setSystemInfo("Module", "Admin");
    		extent.setSystemInfo("Sub Module", "Customers");
    		extent.setSystemInfo("User Name", System.getProperty("user.name"));
    		extent.setSystemInfo("Environment", "QA");
    		
    		List<String> includedGroups = testContext.getCurrentXmlTest().getIncludedGroups();
    		if(!includedGroups.isEmpty()) {
    			extent.setSystemInfo("Groups", includedGroups.toString());
    		}
    		
    		test = extent.createTest(result.getTestClass().getName());
    		test.assignCategory(result.getMethod().getGroups()); // to display groups in report
    		test.log(Status.PASS, result.getName()+ " got successful executed");
    		test = extent.createTest(result.getTestClass().getName());
    		test.assignCategory(result.getMethod().getGroups());
    		test.log(Status.SKIP, result.getName()+ " got skipped");
    		test.log(Status.INFO, result.getThrowable().getMessage());
    		
    		
    		test = extent.createTest(result.getTestClass().getName());
    		test.assignCategory(result.getMethod().getGroups());
    		
    		test.log(Status.FAIL, result.getName()+ " got failed");
    		test.log(Status.INFO, result.getThrowable().getMessage());
    		
    		try {
    			String imgPath = new BaseClass().captureScreenShot(result.getName());
    			test.addScreenCaptureFromPath(imgPath);
    		
    		} catch(IOException e1) {
    			e1.printStackTrace();
    		}
    		
    		extent.flush();
  	      
        	
  	      
    	    Desktop.getDesktop().browse(new File("reports.html").toURI());
    		
    	}
    	
    
    }
    	
    	


