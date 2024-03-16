/**
 * 
 */
package loungePro.testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import loungePro.base.TestBase;
import loungePro.pages.CreateCompanyPage;
import loungePro.pages.LogInPage;
import loungePro.pages.RegistrationPage;
import loungePro.pages.SuperAdminDashboardPage;
import loungePro.utilities.Utility;

/**
 * Author: Rajani Thite
 */
public class CreateCompanyTest extends TestBase {

	public CreateCompanyTest() {
		super();
	}

	@BeforeMethod(alwaysRun = true)
	public void setUp() {
		launchBrowser();
		logInPage = new LogInPage();
		saDashPage = new SuperAdminDashboardPage();
		saDashPage = logInPage.checkIn(properties.getProperty("userID"), properties.getProperty("password"));
		saDashPage.companyTab();
		createCompanyPage = new CreateCompanyPage();

	}

	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		if (driver != null) {
			driver.close();
		}

	}

	@Test(priority = 1, enabled = false)
	public void verifyCompanyCreation() throws InterruptedException {
		Utility.waitUntilElementLocated(By.id("b4-Input_Name"));
		int oldCompanyCount = driver
				.findElements(By.xpath("//div[@class='margin-top-base']/table[@role='grid']/tbody/tr")).size();

		System.out.println("Old Company Count=" + oldCompanyCount);
		createCompanyPage.createCompany();
		Utility.waitUntilElementLocated(By.xpath("//div[@class='feedback-message-text']"));
		Assert.assertEquals(driver.findElement(By.xpath("//div[@class='feedback-message-text']")).getText(),
				"Company Created", "Failed!! validation message not matching");

		int newCompanyCount = driver
				.findElements(By.xpath("//div[@class='margin-top-base']/table[@role='grid']/tbody/tr")).size();
		System.out.println("New Company Count=" + newCompanyCount);
		Assert.assertEquals(oldCompanyCount + 1, newCompanyCount, "Failed!!! Company is not created");
	}

	@Test(priority = 4, enabled = false)
	public void verifyCreateCompanyURLOnClickOfBackIcon() throws InterruptedException {
		Utility.waitUntilElementLocated(By.id("b4-Input_Name"));
		createCompanyPage.clickOnBackIcon();
		Utility.waitUntilElementLocated(By.xpath("//span[text()='Roles']"));
		Assert.assertFalse(driver.getCurrentUrl().contains("CreateCompany"),
				"Failed!! User is not on Daily Log Page!!");
	}

	@Test(priority = 5, enabled = false)
	public void verifyCreateCompanyURL() throws InterruptedException {
		Utility.waitUntilElementLocated(By.id("b4-Input_Name"));
		Assert.assertTrue(driver.getCurrentUrl().contains("CreateCompany"),
				"Failed!! User is not on Create Company Page!!");
	}

	@Test(priority = 6, enabled = false)
	public void verifyClearButton() throws InterruptedException {
		Utility.waitUntilElementLocated(By.id("b4-Input_Name"));
		Assert.assertTrue(createCompanyPage.clearButtonClick(), "Clear button does not clear all the fields!!");
	}

	@Test(priority = 2, enabled = false)
	public void verifyValidationCompanyNameAndDisplayName() throws InterruptedException {

		Assert.assertTrue(createCompanyPage.validationOnCompanyAndDisplayName());

	}

	@Test(priority = 3, enabled = false)
	public void verifyEditCompany() throws InterruptedException {
		Utility.waitUntilElementLocated(By.id("b4-Input_Name"));
		int oldCompanyCount = driver
				.findElements(By.xpath("//div[@class='margin-top-base']/table[@role='grid']/tbody/tr")).size();

		System.out.println("Old Company Count=" + oldCompanyCount);
		//Utility.waitUntilElementLocated(By.id("b4-Input_Name"));
		createCompanyPage.editCompany();
		Utility.waitUntilElementLocated(By.xpath("//div[@class='feedback-message-text']"));
		Assert.assertEquals(driver.findElement(By.xpath("//div[@class='feedback-message-text']")).getText(),
				"Company Updated", "Failed!! validation message not matching");

		int newCompanyCount = driver
				.findElements(By.xpath("//div[@class='margin-top-base']/table[@role='grid']/tbody/tr")).size();
		System.out.println("New Company Count=" + newCompanyCount);

		Assert.assertEquals(oldCompanyCount, newCompanyCount, "Failed!!! Count count increases in editing");
	}
}
