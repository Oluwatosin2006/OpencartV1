package utilities;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
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


public class ExtentReportManager implements ITestListener{
	
	public ExtentSparkReporter spark;
	public ExtentReports extent;
	public ExtentTest test;
	
	String repName;
	
	public void onStart(ITestContext testContext) {
		
	    /*SimpleDateFormat df= new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
		Date dt=new Date();
		String currentDatetimestamp=df.format(dt);*/
		
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date()); // timestamp in one single step
		repName = "Test-Report-" + timeStamp + ".html";
		
		spark=new ExtentSparkReporter(".\\reports\\"+repName); //specific location
	
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
		
		String os = testContext.getCurrentXmlTest().getParameter("os");
		extent.setSystemInfo("Operating System", os);
		
		String browser = testContext.getCurrentXmlTest().getParameter("browser");
		extent.setSystemInfo("Browser", browser);
		
		List<String> includedGroups = testContext.getCurrentXmlTest().getIncludedGroups();
		if(!includedGroups.isEmpty()) {
			extent.setSystemInfo("Groups", includedGroups.toString());
		}
		
	}
	
	public  void onTestSuccess(ITestResult result) {
		
		test = extent.createTest(result.getTestClass().getName()); // creating test case class name entry in the report
		test.assignCategory(result.getMethod().getGroups()); // to display which category the groups belong to in report
		test.log(Status.PASS, result.getName()+ " got successful executed");

	}
	
    public  void onTestFailure(ITestResult result) {
		
		test = extent.createTest(result.getTestClass().getName()); // creating test case class name entry in the report
		test.assignCategory(result.getMethod().getGroups()); // to display which category the groups belong to in report
		
		test.log(Status.INFO, result.getName()+ " got failed");
		test.log(Status.INFO, result.getThrowable().getMessage());
		
		
		try {
			String imgPath = new BaseClass().captureScreenShot(result.getName()); //make webDriver static in the baseclass as common variable to be use across all object creation
			test.addScreenCaptureFromPath(imgPath);
		
		} catch(IOException e1) {
			e1.printStackTrace();
		}
		
	}
    
    public  void onTestSkipped(ITestResult result) {
		
		test = extent.createTest(result.getTestClass().getName()); // creating test case class name entry in the report
		test.assignCategory(result.getMethod().getGroups()); // to display which category the groups belong to in report
		test.log(Status.SKIP, result.getName()+ " got skipped");
		test.log(Status.INFO, result.getThrowable().getMessage());
		
		
	}
    
    
    public void onFinish(ITestContext testContext) {
    	
    	extent.flush();
    	
    	//Desktop.getDesktop().browse(new File(".\\reports\\"+repName).toURI());
    	
    	String pathOfExtentReport = System.getProperty("user.dir")+"\\reports\\"+repName;
    	
    	File extentReport = new File(pathOfExtentReport);
    	
    	try {
    		Desktop.getDesktop().browse(extentReport.toURI());
    	} catch(IOException  e) {
    		e.printStackTrace();
    	}
    
       /*try {
    	URL url = new URL("file:///"+System.getProperty("user.dir")+"\\reports\\"+repName); // location convert to url
    	
    	// Create the email message with the team member--- this will sent the report to the team emails whenever the report is generate
    	
    	ImageHtmlEmail email = new ImageHtmlEmail();
    	email.setDataSourceResolver(new DataSourceUrlResolver(url));
    	email.setHostName("smtp.googlemail.com"); // this can change depending on the email server--- this is for google.com
    	email.setSmtpPort(465);
    	email.setAuthenticator(new DefaultAuthenticator("bukadecladius2004@gmail.com", "password"));
    	email.setSSLOnConnect(true);
    	email.setFrom("bukadecladius2004@gmail.com"); // Sender
    	email.setSubject("Test Result");
    	email.setMsg("Please find Attached Report......");
    	email.addTo("oyinadelove55@gmail.com"); // Receiver --- use distribution list for multiple users
    	email.attach(url, "extent report", "please check report.....");
    	email.send(); // send the email
    	
    	
    } catch(Exception e)
    {
    	e.printStackTrace();
    }*/

}
    
}
