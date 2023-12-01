/**
 * 
 */
package loungePro.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import loungePro.base.TestBase;
import loungePro.pages.LogInPage;
import loungePro.pages.PassengerBreakdownPage;
import loungePro.pages.SuperAdminDashboardPage;

/**
 * Author Rajani Thite
 */
public class PassengerBreakdownTest extends TestBase {
	public PassengerBreakdownTest() {
		super();
	}

@BeforeMethod(alwaysRun=true)
public void setUp() {
	launchBrowser();
	logInPage = new LogInPage();
	saDashPage=new SuperAdminDashboardPage();
	saDashPage=logInPage.checkIn(properties.getProperty("userID"), properties.getProperty("password"));
	passBreakPage=saDashPage.reportsMenu();
	passBreakPage=new PassengerBreakdownPage();
	
}

	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		if (driver != null) {
			driver.close();
		}

	}
	
	@Test(priority=1)
	public void verifypassBreakDownFile() throws InterruptedException {
		
		passBreakPage.clickExport();
	

}
}
