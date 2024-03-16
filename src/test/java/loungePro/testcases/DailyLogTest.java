/**
 * 
 */
package loungePro.testcases;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import loungePro.base.TestBase;
import loungePro.pages.DailyLogPage;
import loungePro.pages.DailyManagerLogPage;
import loungePro.pages.LogInPage;
import loungePro.pages.SuperAdminDashboardPage;
import loungePro.utilities.ExcelUtility;
import loungePro.utilities.Utility;

/**
 * Author: Rajani Thite 1/30/23
 */
public class DailyLogTest extends TestBase {

	List<String> existingLocations;
	List<String> list;
	List<WebElement> listOfElements;

	public DailyLogTest() {
		super();
	}

	@BeforeMethod(alwaysRun = true)
	public void setUp() throws InterruptedException {
		launchBrowser();
		logInPage = new LogInPage();
		saDashPage = logInPage.checkIn(properties.getProperty("userID"), properties.getProperty("password"));
		dailyLogPage = saDashPage.dailyLogPageMenu();
		dailyLogPage = new DailyLogPage();
		dailyManagerLogPage = new DailyManagerLogPage();

	}

	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		if (driver != null) {
			driver.close();
		}

	}

	@Test(priority = 0)
	public void setExistingLocationsAnsShift() throws InterruptedException {
		/*
		 * Utility.waitUntilElementLocated(By.xpath("//span[text()='Daily Manager Log']"
		 * )); Utility.waitUntilElementIsClickable(By.
		 * xpath("//span[text()='Daily Manager Log']")); Thread.sleep(15000);
		 * driver.findElement(By.xpath("//span[text()='Daily Manager Log']")).click();
		 */
		System.out.println("In the setExistingLocationsAnsShift");

		driver.navigate().to("https://gtmsl-tst.outsystemsenterprise.com/LoungePro/DailyManagerLog");

		listOfElements = driver.findElements(By.xpath("//table/tbody"));
		System.out.println("size=" + listOfElements.size());

		if (listOfElements.size() != 0) {
			list = new ArrayList<String>();
			Utility.waitUntilElementIsClickable(By.xpath("//div[@id='b4-b15-PaginationRecords']/span[5]"));
			for (int row = 1; row <= (Integer.parseInt(
					driver.findElement(By.xpath("//div[@id='b4-b15-PaginationRecords']/span[5]")).getText())); row++) {
				String locationAndShift = driver
						.findElement(By.xpath("//table[@role='grid']/tbody/tr[" + row + "]/td[3]/div/span")).getText()
						+ driver.findElement(By.xpath("//table[@role='grid']/tbody/tr[" + row + "]/td[4]/div/span"))
								.getText();
				list.add(locationAndShift);

			}
			System.out.println(list);
		} else {
			System.out.println("Daily log table is empty");
		}

	}

	@Test(priority = 2, dataProvider = "DailyLog", dataProviderClass = ExcelUtility.class)
	public void verifyDailylogByManager(String Sr, String locationValue, String yourName, String shift,
			String aboutShift, String anySuccess, String attendanceIssue, String maintenanceIssue, String complaints,
			String emergencyIssue) throws InterruptedException {

		System.out.println("in function" + listOfElements.size());

		if (listOfElements.size() != 0) {
			list = new ArrayList<String>();
			driver.navigate().to("https://gtmsl-tst.outsystemsenterprise.com/LoungePro/DailyManagerLog");
			Utility.waitUntilElementLocated(By.xpath("//div[@id='b4-b13-PaginationRecords']/span[5]"));
			for (int row = 1; row <= (Integer.parseInt(
					driver.findElement(By.xpath("//div[@id='b4-b13-PaginationRecords']/span[5]")).getText())); row++) {
				String locationAndShift = driver
						.findElement(By.xpath("//table[@role='grid']/tbody/tr[" + row + "]/td[3]/div/span")).getText()
						+ driver.findElement(By.xpath("//table[@role='grid']/tbody/tr[" + row + "]/td[4]/div/span"))
								.getText();
				list.add(locationAndShift);
			}

			if (list.contains(locationValue + shift)) {
				System.out.println("Location entry already exists");
				System.out.println("checking while adding" + locationValue + shift);
			} else {
				driver.navigate().to("https://gtmsl-tst.outsystemsenterprise.com/LoungePro/DailyLog");

				Utility.selectDropdownByVisibleText(driver.findElement(By.id("b4-LocationDropdown")), locationValue);
				Utility.sendData(driver.findElement(By.id("b4-Author")), yourName);
				if (shift.contains("AM"))
					Utility.clickElement(driver.findElement(By.id("b4-Morning-input")));
				else
					Utility.clickElement(driver.findElement(By.id("b4-Evening-input")));

				Utility.sendData(driver.findElement(By.id("b4-TextArea_msg_description")), aboutShift);
				Utility.sendData(driver.findElement(By.id("b4-TextArea_msg_successes")), anySuccess);
				Utility.sendData(driver.findElement(By.id("b4-TextArea_msg_attendance")), attendanceIssue);
				Utility.sendData(driver.findElement(By.id("b4-TextArea_msg_maintenance")), maintenanceIssue);
				Utility.sendData(driver.findElement(By.id("b4-TextArea_msg_complaints")), complaints);
				Utility.sendData(driver.findElement(By.id("b4-TextArea_msg_other")), emergencyIssue);
				Utility.actionKeyDownTillENd();
				Utility.waitUntilElementLocated(By.xpath("//span[text()='Submit']"));

				Utility.javaScriptExecute(driver.findElement(By.xpath("//span[text()='Submit']")));
				Utility.waitUntilElementLocated(By.xpath("//span[text()='Done']"));

				Utility.javaScriptExecute(driver.findElement(By.xpath("//span[text()='Done']")));

			}
			System.out.println(list);
		} else

		{

			System.out.println("Table is empty no rows!!!!");

			Utility.selectDropdownByVisibleText(driver.findElement(By.id("b4-LocationDropdown")), locationValue);
			Utility.sendData(driver.findElement(By.id("b4-Author")), yourName);
			if (shift.contains("AM"))
				Utility.clickElement(driver.findElement(By.id("b4-Morning-input")));
			else
				Utility.clickElement(driver.findElement(By.id("b4-Evening-input")));

			Utility.sendData(driver.findElement(By.id("b4-TextArea_msg_description")), aboutShift);
			Utility.sendData(driver.findElement(By.id("b4-TextArea_msg_successes")), anySuccess);
			Utility.sendData(driver.findElement(By.id("b4-TextArea_msg_attendance")), attendanceIssue);
			Utility.sendData(driver.findElement(By.id("b4-TextArea_msg_maintenance")), maintenanceIssue);
			Utility.sendData(driver.findElement(By.id("b4-TextArea_msg_complaints")), complaints);
			Utility.sendData(driver.findElement(By.id("b4-TextArea_msg_other")), emergencyIssue);
			Utility.actionKeyDownTillENd();
			Utility.waitUntilElementLocated(By.xpath("//span[text()='Submit']"));

			Utility.javaScriptExecute(driver.findElement(By.xpath("//span[text()='Submit']")));
			Utility.waitUntilElementLocated(By.xpath("//span[text()='Done']"));
			Utility.javaScriptExecute(driver.findElement(By.xpath("//span[text()='Done']")));
		}

	}

	@Test(priority = 3, enabled = false)
	public void verifyDailyLogPageURL() throws InterruptedException {

		Assert.assertTrue(driver.getCurrentUrl().contains("DailyLog"), "Failed!! User is not on Daily Log Page!!");
	}

//	@Test(priority = 4, enabled=false)
//	public void verifyLocationNameOnValue() throws InterruptedException {
//		System.out.println(dailyLogPage.getLocationName(3 + 1));
//	}
	/*
	 * @Test(priority = 2)
	 * 
	 * public void verifyDailyLogForm() throws InterruptedException {
	 * Thread.sleep(6000); dailyLogPage.submitDailyLogForm(); }
	 * 
	 * @Test(priority = 3, enabled = false) public void verifyDailyLogForm(String x,
	 * String y) throws InterruptedException { Thread.sleep(6000);
	 * dailyLogPage.submitDailyLogForm(x, y); }
	 */

	@Test(priority = 5)

	public void verifyLogEntryAlreadyExists() throws InterruptedException {

		String validationMessageText = dailyLogPage.dailyLogEntryExists();
		String actualValidationMessage = "Oops! Daily log entry already exist, Try again later.";
		Assert.assertEquals(validationMessageText, "Oops! Daily log entry already exist, Try again later",
				"Failed! It is taking duplicate log entries for same location");

	}

	@Test(priority = 6)

	public void verifClearButton() throws InterruptedException {

		dailyLogPage.CancelDailyLogForm();
		Assert.assertTrue(dailyLogPage.defaultValuesOnDailyManagerLog(), "Failed, default values are not matching");

	}

	@Test(priority = 7)

	public void verifyDefaultValues() throws InterruptedException {

		dailyLogPage.CancelDailyLogForm();
		Assert.assertTrue(dailyLogPage.defaultValuesOnDailyManagerLog(), "Failed, default values are not matching");

	}
}
