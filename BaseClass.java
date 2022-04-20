package util;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class BaseClass {
//  @Test
//  public void f() {
//  }
	public static ExtentHtmlReporter reportlocation;
	public static ExtentReports extents;
	public ExtentTest reportLogger;
	public String currentFunction;
	public String browsername;
  
	@BeforeSuite
  public void beforeSuite() {
	    String css = ".r-img {width: 2%;}";
	    reportlocation =new ExtentHtmlReporter("C:\\D_Drive\\WorkSpace\\UIAutomationTest-Old\\Reports\\ExtentReport.html");
	    reportlocation.config().setCSS(css);
	    reportlocation.config().setTheme(Theme.DARK);
	    reportlocation.config().setDocumentTitle("Execution Report- "+java.util.Calendar.getInstance().getTime());
	    reportlocation.config().setReportName("BBM-Review Tool Test Execution Results "+java.util.Calendar.getInstance().getTime());
	    reportlocation.config().setJS("$('.brand-logo').text('BGSW');");
	    
	    
		extents = new ExtentReports();
		extents.setSystemInfo("OS", System.getProperty("os.name"));
		extents.setSystemInfo("Java", System.getProperty("java.specification.version"));
		extents.setSystemInfo("User",  System.getProperty("user.name"));
		extents.setSystemInfo("Time",  java.util.Calendar.getInstance().getTime().toString());
		extents.attachReporter(reportlocation);


  }
	

  @AfterSuite
  public void afterSuite() {
	  extents.flush();
	  
	 // System.out.println("this is after suit");
	
  }

}

