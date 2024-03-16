/**
 * 
 */
package loungePro.testcases;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import loungePro.base.TestBase;
import loungePro.pages.DailyLogPage;
import loungePro.pages.DailyManagerLogPage;
import loungePro.pages.LogInPage;
import loungePro.pages.SuperAdminDashboardPage;
import loungePro.utilities.ExcelUtility;
import loungePro.utilities.Utility;

/**
 * Author: Rajani Thite 2/1/24
 * 
 * @param <ITestContext>
 */
public class DailyManagerLogTest extends TestBase {
	int item;
	List<String> existingLocations;

	public DailyManagerLogTest() {

		super();

		// item = dailyManagerLogPage.getNoOfItems();

	}

	@BeforeMethod(alwaysRun = true)
	public void setUp() throws InterruptedException {
		launchBrowser();
		logInPage = new LogInPage();
		saDashPage = logInPage.checkIn(properties.getProperty("userID"), properties.getProperty("password"));
		// dailyLogPage = saDashPage.dailyLogPageMenu();
		dailyManagerLogPage = saDashPage.dailyManagerLogEntryMenu();
		dailyManagerLogPage = new DailyManagerLogPage();
		dailyLogPage = new DailyLogPage();

	}

	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		if (driver != null) {
			driver.close();
		}

	}

	/*
	 * @Test(priority = 2, dataProvider = "DailyLog", dataProviderClass =
	 * ExcelUtility.class, dependsOnMethods = "verifyNumberOfItems")
	 * 
	 * public void verifyEyeIconForAddedManagerLogEntries(String sr, String
	 * locationValue, String yourName, String shift, String aboutShift, String
	 * anySuccess, String attendanceIssue, String maintenanceIssue, String
	 * complaints, String emergencyIssue) throws InterruptedException { int row =
	 * Integer.parseInt(sr); int excelRow = row - (item + 1); int absRow =
	 * Math.abs(excelRow);
	 * 
	 * driver.findElement(By.xpath("(//table[@role='grid']/tbody/tr[" + absRow +
	 * "]/td/div[1])[" + 5 + "]")).click(); Thread.sleep(3000); for(int i=1;i<=)
	 * if(absRow==1) { String
	 * author=driver.findElement(By.id("b4-Input_PLastName")).getAttribute("value");
	 * Assert.assertEquals(null, author,"Author name not matching"); }
	 * 
	 * }
	 */

	@Test(priority = 1, enabled = false)
	public void verifyDailyManagerLogEntryPageURL() throws InterruptedException {
		Thread.sleep(3000);
		System.out.println(driver.getCurrentUrl());
		Assert.assertTrue(driver.getCurrentUrl().contains("DailyManagerLog"),
				"Failed!! User is not on Daily Log Page!!");
	}

	@Test(priority = 1)
	public void verifyNumberOfItems() {
		System.out.println("Number of Items in the Daily Manager Log ");
		System.out.println(dailyManagerLogPage.getNoOfItems());
		item = dailyManagerLogPage.getNoOfItems();

	}

	@Test(priority = 6, enabled = false)
	public void verifyDefaultFromDate() {

		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String expectedDate = formatter.format(date);
		System.out.println("todays dare=" + expectedDate);
		Assert.assertEquals(expectedDate, dailyManagerLogPage.getFromDate(),
				"By Default From Date Is Not Current Date");

	}

	@Test(priority = 7, enabled = false)
	public void verifyDefaultToDate() {

		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String expectedDate = formatter.format(date);
		System.out.println("todays dare=" + expectedDate);
		Assert.assertEquals(expectedDate, dailyManagerLogPage.getToDate(), "By default To Date Is Not Current Date");

	}

	/*
	 * @Test(priority = 7, ITestContext ctx) public List<String>
	 * verifyExistingLocations() { ctx.setAttribute(existingLocations,
	 * dailyManagerLogPage.getAlreadyExistLocations()); //return
	 * dailyManagerLogPage.getAlreadyExistLocations();
	 * 
	 * }
	 */

	@Test(priority = 2, dataProvider = "DailyLog", dataProviderClass = ExcelUtility.class, dependsOnMethods = "verifyNumberOfItems", enabled = false)

	public void verifyNewlyAddedManagerLogEntriesOld(String sr, String locationValue, String yourName, String shift,
			String aboutShift, String anySuccess, String attendanceIssue, String maintenanceIssue, String complaints,
			String emergencyIssue) {

		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
		String expectedDate = formatter.format(date);
		int row = Integer.parseInt(sr);
		int excelRow = row - (item + 1);
		int absRow = Math.abs(excelRow);

		for (int j = 1; j <= 5; j++) {
			System.out.println("item=" + item + "j=" + j);
			if (j == 1) {

				String actualString = driver
						.findElement(By.xpath("(//table[@role='grid']/tbody/tr[" + absRow + "]/td/div[1])[" + j + "]"))
						.getText();
				// System.out.println(actualString + " " + expectedDate);
				Assert.assertEquals(actualString, expectedDate, "Date is not matched");

			}
			if (j == 2) {
				String actualString = driver
						.findElement(By.xpath("(//table[@role='grid']/tbody/tr[" + absRow + "]/td/div[1])[" + j + "]"))
						.getText();

				// System.out.println(actualString + " " + yourName);
				Assert.assertEquals(actualString.trim(), yourName, "Name is not matching matched");
			}

			if (j == 3) {
				String actualString = driver
						.findElement(By.xpath("(//table[@role='grid']/tbody/tr[" + absRow + "]/td/div[1])[" + j + "]"))
						.getText(); // Integer.parseInt(actualString);
				// System.out.println(actualString + " " + locationValue);
				Assert.assertEquals(actualString, locationValue, "Locations are not matched");
			}

			if (j == 4) {
				String actualString = driver
						.findElement(By.xpath("(//table[@role='grid']/tbody/tr[" + absRow + "]/td/div[1])[" + j + "]"))
						.getText();

				Assert.assertEquals(actualString, shift, "Shift is not matched");
			}

		}

	}

	@Test(priority = 2, dataProvider = "DailyLog", dataProviderClass = ExcelUtility.class, dependsOnMethods = "verifyNumberOfItems")
	// @Test(priority = 2, dataProvider = "DailyLog", dataProviderClass =
	// ExcelUtility.class)
	public void verifyNewlyAddedManagerLogEntries(String sr, String locationValue, String yourName, String shift,
			String aboutShift, String anySuccess, String attendanceIssue, String maintenanceIssue, String complaints,
			String emergencyIssue) throws InterruptedException {

		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
		String expectedDate = formatter.format(date);
		int row = Integer.parseInt(sr);
		int excelRow = row - (item + 1);
		int absRow = Math.abs(excelRow);
		// int absRow=4;

		for (int j = 1; j <= 5; j++) {
			System.out.println("item=" + item + "j=" + j);
			if (j == 1) {

				String actualString = driver
						.findElement(By.xpath("(//table[@role='grid']/tbody/tr[" + absRow + "]/td/div[1])[" + j + "]"))
						.getText();
				// System.out.println(actualString + " " + expectedDate);
				Assert.assertEquals(actualString, expectedDate, "Date is not matched");

			}
			if (j == 2) {
				String actualString = driver
						.findElement(By.xpath("(//table[@role='grid']/tbody/tr[" + absRow + "]/td/div[1])[" + j + "]"))
						.getText();

				// System.out.println(actualString + " " + yourName);
				Assert.assertEquals(actualString.trim(), yourName, "Name is not matching matched");
			}

			if (j == 3) {
				String actualString = driver
						.findElement(By.xpath("(//table[@role='grid']/tbody/tr[" + absRow + "]/td/div[1])[" + j + "]"))
						.getText(); // Integer.parseInt(actualString);
				// System.out.println(actualString + " " + locationValue);
				Assert.assertEquals(actualString, locationValue, "Locations are not matched");
			}

			if (j == 4) {
				String actualString = driver
						.findElement(By.xpath("(//table[@role='grid']/tbody/tr[" + absRow + "]/td/div[1])[" + j + "]"))
						.getText();

				Assert.assertEquals(actualString, shift, "Shift is not matched");
			}

			if (j == 5) {
				Thread.sleep(5000);
				driver.findElement(By.xpath("(//table[@role='grid']/tbody/tr[" + absRow + "]/td/div[1])[" + j + "]"))
						.click();
				Thread.sleep(10000);
				Set<String> windowHandles = driver.getWindowHandles();
				System.out.println(windowHandles);
				for (String windowHandle : windowHandles) {
					// Switch to the desired window
					driver.switchTo().window(windowHandle);

					String ActualName = driver.findElement(By.xpath("//div[@id='b4-b2-Column1']/div/div/span/input"))
							.getAttribute("value").trim();
					Assert.assertEquals(yourName.trim(), ActualName, "Author Name is not matching");

					Assert.assertEquals(anySuccess, driver.findElement(By.id("b4-TextArea_msg_successes")).getText(),
							"Success msg text not matching");

					Assert.assertEquals(attendanceIssue,
							driver.findElement(By.id("b4-TextArea_msg_attendance")).getText(),
							"Attendance text not matching");
					Utility.actionKeyDownTillENd();
					Assert.assertEquals(maintenanceIssue,
							driver.findElement(By.id("b4-TextArea_msg_maintenance")).getText(),
							"Maintenance text not matching");

				}
			}
		}
	}
}
/*
 * System.out.println("Expected:" + aboutShift); System.out .println("Actual:" +
 * driver.findElement(By.id("b4-TextArea_msg_description")).getText().trim());
 * 
 * 
 * Assert.assertEquals(aboutShift.trim(),
 * driver.findElement(By.id("b4-TextArea_msg_description")).getText().trim(),
 * "About shift description not matching");
 * 
 * 
 * 
 * Assert.assertEquals(shift,
 * driver.findElement(By.xpath("//input[@id='b4-Input_PLastName2']")).
 * getAttribute("value"), "Author Name is not matching");
 * 
 * 
 * Assert.assertEquals(complaints,
 * driver.findElement(By.id("b4-TextArea_msg_complaints")).getText(),
 * "Complaints text not matching"); Assert.assertEquals(emergencyIssue,
 * driver.findElement(By.id("b4-b4-msg_other")).getText(),
 * "Any Other emergencies not matching");
 * 
 */
