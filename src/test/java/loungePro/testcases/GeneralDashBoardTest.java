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
import loungePro.pages.SuperAdminDashboardPage;
import loungePro.pages.SuperAdminLocationPage;

/**
 * Author: Rajani Thite
 */
public class GeneralDashBoardTest extends TestBase {

	public GeneralDashBoardTest() {
		super();
	}

	@BeforeMethod(alwaysRun = true)
	public void setUp() {
		launchBrowser();
		logInPage = new LogInPage();
		// saDashPage = new SuperAdminDashboardPage();
		saDashPage = logInPage.checkIn(properties.getProperty("userID"), properties.getProperty("password"));
		generalDashBoardpPage = saDashPage.generalDashboardMenu();
		generalDashBoardpPage = new GeneralDashboardPage();
	}

	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		if (driver != null) {
			driver.close();
		}

	}

	@Test(priority = 1)
	public void verifyNumberOfCompanies() throws InterruptedException {
		System.out.println("-----Hello-----");
		System.out.println("Number Of Companies" + generalDashBoardpPage.getNumberOfCompanies());
	}

	@Test(priority = 2)
	public void verifyCompanyNames() throws InterruptedException {
		generalDashBoardpPage.getCompanies();

	}
}
