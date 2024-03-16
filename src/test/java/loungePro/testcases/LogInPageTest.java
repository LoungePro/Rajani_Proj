/**
 * 
 */
package loungePro.testcases;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import loungePro.base.TestBase;
import loungePro.pages.LogInPage;
import loungePro.utilities.Utility;

/**
 * Author: Rajani Thite 11/23/24
 */
public class LogInPageTest extends TestBase {

	public LogInPageTest() {
		super();
	}

	@BeforeMethod(alwaysRun = true)
	public void setUp() {
		launchBrowser();
		logInPage = new LogInPage();
		// WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
	}

	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		if (driver != null) {
			driver.close();
		}

	}

	@Test(priority = 5)
	public void verifyPageTitle() throws InterruptedException {

		String actualPageTitle = logInPage.pageTitle();
		System.out.println("Expected Page Title contains text 'Login'");
		System.out.println("Actual page Title is" + driver.getCurrentUrl());
		Assert.assertTrue(driver.getCurrentUrl().contains("Login"), "Failed!! URL is incorrect");

	}

	@Test(priority = 1)
	public void verifyCheckIn() throws InterruptedException {
		saDashPage = logInPage.checkIn(properties.getProperty("userID"), properties.getProperty("password"));
		Utility.waitUntilElementLocated(By.xpath("//div[@id='b3-$b1']/div/div/div"));
		Assert.assertTrue(driver.getCurrentUrl().contains("CompanyDashboard"), "Failed!! URL is incorrect");

	}

	@Test(priority = 2)
	public void verifyValidationMessageInvalidIdAndPassword() throws InterruptedException {

		String actualValidation = logInPage.checkInWithWrongUserIDAndPassword(properties.getProperty("invalidUserID"),
				properties.getProperty("invalidPassword"));
		System.out.println("Validation message when Invalid User ID and Password entered");
		System.out.println("Expected Validation message: Invalid Credentials");
		System.out.println("Actual Validation message: " + actualValidation);

		Assert.assertEquals("Invalid Credentials", actualValidation, null);
	}

	@Test(priority = 2)
	public void verifyValidationMessageNoPasswordEntered() throws InterruptedException {
		String actualValidation = logInPage.checkInWithNoPasswordEntered(properties.getProperty("invalidUserID"),
				properties.getProperty("invalidPassword"));
		System.out.println("Validation message when No Password entered");
		System.out.println("Expected validation message : Please enter password");
		System.out.println("Actual validation message: " + actualValidation);
		Assert.assertEquals("Please enter password", actualValidation,
				"Failed!! verifyValidationMessageNoPasswordEntered");

	}

	@Test(priority = 2)
	public void verifyValidationMessageWhenNoCredentialsEntered() throws InterruptedException {

		String actualValidation = logInPage.checkInWithNoCredentialsEntered(properties.getProperty("invalidUserID"),
				properties.getProperty("invalidPassword"));
		System.out.println("Validation message when no credentials entered");
		System.out.println("Actual validation message: " + actualValidation);
		System.out.println("Expected Validation Message: Please enter username ");
		Assert.assertEquals(actualValidation, "Please enter username",
				"Failed!! verifyValidationMessageWhenNoCredentialsEntered");

	}

	@Test(priority = 5)
	public void verifyParaText() {

		String expectedParagraphText = "Our Lounges are a diverse space away from the crowds, where you can find all you will need before your flight. Rest easy in the knowledge that all our lounges' offerings and facilities are included in the entry price.";

		Assert.assertEquals(expectedParagraphText, logInPage.getParagraphText(),
				"Para Text is not matching at Login Page");
	}

	@Test(priority = 5)
	public void verifyParaHeading() {
		String expectedParaHeading = "Be Our Guest";

		Assert.assertEquals(expectedParaHeading, logInPage.getParaHeading(), "Failed!! Para Heading is not expected");

	}
}
