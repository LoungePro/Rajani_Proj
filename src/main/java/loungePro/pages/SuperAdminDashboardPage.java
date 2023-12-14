/**
 * 
 */
package loungePro.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import loungePro.base.TestBase;
import loungePro.utilities.Utility;

/**
 * Author: Rajani Thite 11/24/23
 */
public class SuperAdminDashboardPage extends TestBase {

	public SuperAdminDashboardPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[text()='Company']")
	@CacheLookup
	WebElement company;

	@FindBy(xpath = "//span[text()='Roles']")
	@CacheLookup
	WebElement roles;

	@FindBy(xpath = "//span[text()='Users']")
	@CacheLookup
	WebElement users;

	@FindBy(xpath = "//span[text()='Permissions']")
	@CacheLookup
	WebElement permissions;

	@FindBy(xpath = "//span[text()='Locations']")
	@CacheLookup
	WebElement locations;

	@FindBy(xpath = "//span[text()='View & Manage Location']")
	@CacheLookup
	WebElement viewAndManageLocation;

	@FindBy(xpath = "//span[text()='Logout']")
	@CacheLookup
	WebElement logOut;

	@FindBy(xpath = "//span[text()='Reports']")
	@CacheLookup
	WebElement reports;

	@FindBy(xpath = "//span[text()='Passenger Breakdown']")
	@CacheLookup
	WebElement passenger_Breakdown;

	@FindBy(xpath = "//span[text()='Passenger']")
	@CacheLookup
	WebElement passenger;

	@FindBy(xpath = "//div[@id='b3-b1-$b1']/following::div[1]/span[2]")
	@CacheLookup
	WebElement userRole;

	@FindBy(xpath = "//div[@id='b3-b1-$b1']/following::div[1]/span[1]")
	@CacheLookup
	WebElement userName;
	
	@FindBy (xpath= "//span[text()='General DashBoard']")
	@CacheLookup
	WebElement generalDashBoard;
	
	

	public void logOutUser() {
		// Utility.clickElement(logOut);
		// actions=new Actions(driver);
		// actions.click(logOut).perform();
		Utility.javaScriptExecute(logOut);
		Utility.captureScreenShot();

	}

	public PassengerBreakdownPage reportsMenu() {
		System.out.println("-------In Report Menu-------");
		Utility.clickElement(reports);
		Utility.clickElement(passenger_Breakdown);
		return new PassengerBreakdownPage();
	}
	
	public GeneralDashboardPage generalDashboardMenu() {
		System.out.println("-------In General Dashboard Menu-------");
		Utility.clickElement(generalDashBoard);
		System.out.println("General Dashboard clicked");
		return new GeneralDashboardPage();
	}
	public SuperAdminLocationPage locationsTab() {
		System.out.println("-------In General Dashboard Menu-------");
		Utility.clickElement(locations);
		System.out.println("Locations from Superadmin dashboard clicked");
		return new SuperAdminLocationPage();
	}
	//locations

	public RegistrationPage passengerMenu() {
		Utility.clickElement(passenger);
		return new RegistrationPage();

	}
	
	public CreateCompanyPage companyTab() {
		Utility.clickElement(company);
		return new CreateCompanyPage();

	}

	public String getUserRole() {
		// WebElement x =
		// driver.findElement(By.xpath("//span[@class='poppins-semibold-18']"));
		return userRole.getText();

	}

	public String getUserName() {
		WebElement x = driver.findElement(By.xpath("//span[@class='poppins-semibold-18']"));
		return userName.getText();

	}

	public String checkTabCompany() {
		return company.getText();
	}

	public String checkTabRoles() {
		return roles.getText();
	}

	public String checkTabUsers() {
		return users.getText();
	}

	public String checkTabPermissions() {
		return permissions.getText();
	}

	public String checkTabLocations() {
		return locations.getText();
	}

	public String checkTabViewAndManageLocation() {
		return viewAndManageLocation.getText();
	}

}
