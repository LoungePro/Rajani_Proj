/**
 * 
 */
package loungePro.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import loungePro.base.TestBase;
import loungePro.pages.LogInPage;

/**
 * Author: Rajani Thite 11/23/24
 */
public class LogInPageTest extends TestBase {

	public LogInPageTest() {
		super();
	}

	@BeforeMethod(alwaysRun=true)
	public void setUp() {
		launchBrowser();
		logInPage = new LogInPage();
	}

	@AfterMethod(alwaysRun=true)
	public void tearDown() {
		if (driver != null) {
			driver.close();
		}

	}

	@Test(priority = 1)
	public void verifyPageTitle() throws InterruptedException {

		String actualPageTitle = logInPage.pageTitle();
		// Thread.sleep(3000);
		Assert.assertTrue(driver.getCurrentUrl().contains("Login"), "Failed!! URL is incorrect");

	}

	@Test(priority = 5)
	public void verifyCheckIn() throws InterruptedException {
		saDashPage = logInPage.checkIn(properties.getProperty("userID"), properties.getProperty("password"));
		Thread.sleep(3000);
		Assert.assertTrue(driver.getCurrentUrl().contains("SuperAdminDashboard"), "Failed!! URL is incorrect");

	}

	@Test(priority = 4 , enabled=false)
	public void verifyParaText() {

		String expectedParagraphText = "Our Lounges are a diverse space away from the crowds, where you can find all you will need before your flight. Rest easy in the knowledge that all our lounges' offerings and facilities are included in the entry price.";

		Assert.assertEquals(expectedParagraphText, logInPage.getParagraphText(),
				"Para Text is not matching at Login Page");
	}

	@Test(priority = 3)
	public void verifyParaHeading() {
		String expectedParaHeading = "Be Our Guest";

		Assert.assertEquals(expectedParaHeading, logInPage.getParaHeading(), "Failed!! Para Heading is not expected");

	}
}
