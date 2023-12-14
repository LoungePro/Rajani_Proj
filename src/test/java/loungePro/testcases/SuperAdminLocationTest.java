/**
 * 
 */
package loungePro.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import loungePro.base.TestBase;
import loungePro.pages.GeneralDashboardPage;
import loungePro.pages.LogInPage;
import loungePro.pages.SuperAdminLocationPage;

/**
 * Author: Rajani Thite
 */
public class SuperAdminLocationTest extends TestBase {

	public SuperAdminLocationTest() {
		super();
	}

	
	@BeforeMethod(alwaysRun = true)
	public void setUp() {
		launchBrowser();
		logInPage = new LogInPage();
		// saDashPage = new SuperAdminDashboardPage();
		saDashPage = logInPage.checkIn(properties.getProperty("userID"), properties.getProperty("password"));
		superAdminLocationPage=saDashPage.locationsTab();
		superAdminLocationPage = new SuperAdminLocationPage();
		generalDashBoardpPage = new GeneralDashboardPage();
	}

	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		if (driver != null) {
			driver.close();
		}
}
	
	@Test(priority=1)
		public void verifyNoOfCompaniesFromSuperAdminLocations() throws InterruptedException {
		System.out.println("No Of Companies="+ superAdminLocationPage.getNoOfCompaniesFromSuperAdminLoc());
		
		System.out.println("on general dashboird=" +generalDashBoardpPage.getNumberOfCompanies());
		//Assert.assertEquals(generalDashBoardpPage.getNumberOfCompanies(), superAdminLocationPage.getNoOfCompaniesFromSuperAdminLoc());
		
	}
	@Test(priority=1)
	public void verifyCompaniesFromSuperAdminLocations() {
		superAdminLocationPage.getCompaniesFromSuperAdminLoc();
		
	}
	
}
