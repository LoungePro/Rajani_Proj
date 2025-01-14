/**
 * 
 */
package loungePro.testcases;

import static org.testng.Assert.assertTrue;

import java.awt.AWTException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import loungePro.base.TestBase;
import loungePro.pages.LogInPage;
import loungePro.pages.RegistrationPage;
import loungePro.pages.SuperAdminDashboardPage;

/**
 * Author: Rajani Thite 11/27/23
 */

public class RegistrationTest extends TestBase {
	public static int newRegCount;

	public static int oldRegCount;

	public RegistrationTest() {
		super();
	}

	@BeforeMethod(alwaysRun = true)
	public void setUp() {
		launchBrowser();
		logInPage = new LogInPage();
		saDashPage = new SuperAdminDashboardPage();
		saDashPage = logInPage.checkIn(properties.getProperty("userID"), properties.getProperty("password"));
		registrationPage = new RegistrationPage();

	}

	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		if (driver != null) {
			driver.close();
		}

	}

	@Test(priority = 1, groups = { "Regression" })
	public void verifyValidationOnReqdFields() throws InterruptedException, AWTException {

		Assert.assertEquals(registrationPage.validationOnRequiredFields(), true);

	}

	@Test(priority = 1, enabled = false)
	public void verifyOldRegCount() {
		try {
			oldRegCount = registrationPage.checkRegCount();
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
	}

	@Test(priority = 2, groups = { "Regression" })
	public void verifyValidationOfFlightAndLastName() throws InterruptedException {

		Assert.assertEquals(registrationPage.validationOfFlightAndLastName(), true);

	}

	@Test(priority = 2, groups = { "Regression" }, enabled = false)
	public void verifyCancelButton() throws InterruptedException {
Thread.sleep(3000);
		Assert.assertTrue(registrationPage.cancelRegistration());

	}

	@Test(priority = 2, enabled = false)
	public void verifyNewRegCount() {

		try {
			newRegCount = registrationPage.checkRegCount();
		} catch (InterruptedException e) {

			e.printStackTrace();
		}

		System.out.println("Old Registration Count=" + oldRegCount);
		System.out.println("New Registration Count=" + newRegCount);
		Assert.assertEquals(newRegCount, oldRegCount + 1);
	}

	@Test(priority = 2, groups = { "Smoke" }, enabled = false)
	public void verifyManualRegistrionOfPassenger() throws AWTException, InterruptedException {
		
			Assert.assertTrue(registrationPage.passengerRegistration());
		
		}
	}


