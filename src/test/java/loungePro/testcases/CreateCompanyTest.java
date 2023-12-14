/**
 * 
 */
package loungePro.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import loungePro.base.TestBase;
import loungePro.pages.CreateCompanyPage;
import loungePro.pages.LogInPage;
import loungePro.pages.RegistrationPage;
import loungePro.pages.SuperAdminDashboardPage;

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
		createCompanyPage=new CreateCompanyPage();

	}

	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		if (driver != null) {
			driver.close();
		}

	}
	
	@Test(priority=1)
	public void verifyCompanyCreation() throws InterruptedException {
		createCompanyPage.createCompany();
		
	}

}
