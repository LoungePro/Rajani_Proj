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
	}

	@Test(priority = 2, enabled = false)
	public void verifyPassenger() {
		saDashPage.passengerMenu();
	}

	@Test(priority = 1, enabled = false)
	public void verifyCorrectUserRole() {
		String actualUserRole=saDashPage.getUserRole();		
		Assert.assertEquals(actualUserRole, properties.getProperty("role"), "Correct User Role is not displayed");
	}
	
	@Test(priority = 1, enabled = false)
	public void verifyCorrectUserName() {
		String actualUserID=saDashPage.getUserName();	
		System.out.println("user=" + actualUserID);
		Assert.assertEquals(actualUserID, properties.getProperty("userID"), "Correct User Name not displayed");
	}
}