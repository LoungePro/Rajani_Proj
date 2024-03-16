/**
 * 
 */
package loungePro.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import loungePro.base.TestBase;
import loungePro.utilities.Utility;

/**
 * Author: Rajani Thite 11/24/23
 */
public class SuperAdminDashboardPage extends TestBase {

	public SuperAdminDashboardPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@id='b4-$b10']")
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
	
	@FindBy (xpath= "//span[text()='General Dashboard']")
	@CacheLookup
	WebElement generalDashboard;
	
	@FindBy (xpath="//span[text()='Download QR']")
	@CacheLookup
	WebElement downloadQR;
	
	@FindBy(xpath="//span[text()='Daily Log']")
	@CacheLookup
	WebElement dailyLog;
	
	@FindBy(xpath="(//div/span[text()='Daily Manager Log Entries'])[1]")
	@CacheLookup
	WebElement dailyManagerLogEntriesMenu;
	
	

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
		Utility.clickElement(generalDashboard);
		System.out.println("General Dashboard clicked");
		return new GeneralDashboardPage();
	}
	
	public DailyLogPage dailyLogPageMenu() throws InterruptedException {
		System.out.println("---Daily Log Menu-----");
		
		Utility.waitUntilElementLocated(By.xpath("//div[@id='b2-l1-39_6-b2-Content']/div[2]"));
		Utility.waitUntilElementIsClickable(By.xpath("//span[text()='Daily Log']"));
		Thread.sleep(15000);
		Utility.clickElement(dailyLog);
		System.out.println("Daily Log clicked");
		return new DailyLogPage();
	}
	
	public DailyManagerLogPage dailyManagerLogEntryMenu() throws InterruptedException {
		/*
		 * System.out.println("---Daily Log Menu-----"); Thread.sleep(6000);
		 * Utility.clickElement(dailyManagerLogEntriesMenu);
		 * System.out.println("Daily Log clicked"); return new DailyManagerLogPage();
		 */
		
	Utility.waitUntilElementLocated(By.xpath("//div[@id='b4-b4-MainContent']/div[1]/span[1]"));
		
		
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(25));
		try {
			wait1.until(ExpectedConditions
					.elementToBeClickable(dailyManagerLogEntriesMenu));
		} catch (Exception e1) {
			System.out.println("Oh");
		}

		Thread.sleep(5000);
		dailyManagerLogEntriesMenu.click();
		System.out.println("Daily Manager log clicked");
		return new DailyManagerLogPage();
	}
	public SuperAdminLocationPage locationsTab() {
		System.out.println("-------In General Dashboard Menu-------");
		Utility.clickElement(locations);
		System.out.println("Locations from Superadmin dashboard clicked");
		return new SuperAdminLocationPage();
	}
	//locations

	public RegistrationPage passengerMenu() {
		System.out.println("at passenger menu");
		Utility.waitUntilElementLocated(By.xpath("//span[text()='Passenger']"));
		//driver.findElement(By.xpath("//span[text()='Passenger']")).click();
		Utility.javaScriptExecute(passenger);
		System.out.println("Passenger Menu selected");
		
		
		return new RegistrationPage();

	}
	
	public CreateCompanyPage companyTab() {
		Utility.waitUntilElementIsClickable(By.xpath("//div[@id='b4-$b10']"));
		//Utility.waitUntilElementLocated(By.xpath("//span[text()='Company']"));
		Utility.javaScriptExecute(company);
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
	
	public String checkTabDownloadQR() {
		return downloadQR.getText();
	}
	
	

}
