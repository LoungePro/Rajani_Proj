/**
 * 
 */
package loungePro.config;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import loungePro.base.TestBase;

/**
 * Author Rajani Thite 11/27/23
 */
public class ExtentReporterNG {
	public static ExtentSparkReporter exSparkReport;
	public static ExtentReports extent;
	
	public static ExtentReports getReportObject() {
		String exReports= System.getProperty("user.dir")+"//reports//report.html";		
		exSparkReport=new ExtentSparkReporter(exReports);
		exSparkReport.config().setReportName("Lounge Pro Automation Report");
		exSparkReport.config().setDocumentTitle("L P Automation Report");
		extent=new ExtentReports();
		extent.attachReporter(exSparkReport);
		extent.setSystemInfo("Tester", "Rajani Thite");
		return extent;
	}

}
