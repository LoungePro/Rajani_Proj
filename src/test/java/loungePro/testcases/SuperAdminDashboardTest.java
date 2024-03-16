/**
 * 
 */
package loungePro.testcases;

import org.apache.hc.core5.util.Asserts;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import loungePro.base.TestBase;
import loungePro.pages.GeneralDashboardPage;
import loungePro.pages.LogInPage;
import loungePro.pages.SuperAdminDashboardPage;

/**
 * Author: Rajani Thite
 */
public class SuperAdminDashboardTest extends TestBase {
	public SuperAdminDashboardTest() {
		super();
	}

	@BeforeMethod(alwaysRun = true)
	public void setUp() {
		launchBrowser();
		logInPage = new LogInPage();
		saDashPage = new SuperAdminDashboardPage();
		saDashPage = logInPage.checkIn(properties.getProperty("userID"), properties.getProperty("password"));
		
		
	}

	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		if (driver != null) {
			driver.close();
		}

	}

	@Test(priority = 6)
	public void verifyLogOutUser() throws InterruptedException {
		saDashPage.logOutUser();
		Thread.sleep(3000);
		System.out.println("logged out");
		Assert.assertTrue(driver.getCurrentUrl().contains("Login"), "Failed!! User has not logged Out!!");
	}
	
//	@Test(priority = 6)
//	public void verifySuperADminPAgeURL() throws InterruptedException {
//		
//		Assert.assertTrue(driver.getCurrentUrl().contains("SuperAdminDashboard"), "Failed!! User has not logged Out!!");
//	}
//	

	@Test(priority = 2)
	public void verifyPassenger() {
		saDashPage.passengerMenu();
	}

	@Test(priority = 1)
	public void verifyCorrectUserRole() {
		String actualUserRole = saDashPage.getUserRole();
		Assert.assertEquals(actualUserRole, properties.getProperty("role"), "Correct User Role is not displayed");
	}

	@Test(priority = 1)
	public void verifyCorrectUserName() {
		String actualUserID = saDashPage.getUserName();
		System.out.println("user=" + actualUserID);
		Assert.assertEquals(actualUserID, properties.getProperty("userID"), "Correct User Name not displayed");
	}

	@Test(priority = 1, groups = { "Smoke" })
	public void verifyCompanyTab() {

		Assert.assertEquals(saDashPage.checkTabCompany(), "Company");

	}

	@Test(priority = 1, groups = { "Smoke" })
	public void verifyRolesTab() {

		Assert.assertEquals(saDashPage.checkTabRoles(), "Roles");

	}

	@Test(priority = 1, groups = { "Smoke" })
	public void verifyUsersTab() {

		Assert.assertEquals(saDashPage.checkTabUsers(), "Users");

	}

	@Test(priority = 1, groups = { "Smoke" })
	public void verifyPermissionsTab() {

		Assert.assertEquals(saDashPage.checkTabPermissions(), "Permissions");

	}

	@Test(priority = 1, groups = { "Smoke" })
	public void verifyLocationsTab() {

		Assert.assertEquals(saDashPage.checkTabLocations(), "Locations");

	}

	@Test(priority = 1, groups = { "Smoke" })
	public void verifyManagerLogTab() {

		Assert.assertEquals(saDashPage.checkTabViewAndManageLocation(), "View & Manage Location");

	}
	
	@Test(priority = 1, groups = { "Smoke" })
	public void verifyDownQR() {

		Assert.assertEquals(saDashPage.checkTabDownloadQR(), "Download QR");

	}

}