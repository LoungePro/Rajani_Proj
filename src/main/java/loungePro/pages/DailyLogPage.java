/**
 * 
 */
package loungePro.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.google.errorprone.annotations.CanIgnoreReturnValue;

import loungePro.base.TestBase;
import loungePro.utilities.ExcelUtility;
import loungePro.utilities.Utility;

/**
 * Author: Rajani Thite
 */
public class DailyLogPage extends TestBase {

	public DailyLogPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[text()='Daily Log']")
	@CacheLookup
	WebElement loungeWaitlist;

	@FindBy(xpath = "//div[text()='Daily Manager Log']")
	@CacheLookup
	WebElement dailyManagerLogText;

	@FindBy(id = "b4-LocationDropdown")
	@CacheLookup
	WebElement locationDropdown;

	@FindBy(id = "b4-Author")
	@CacheLookup
	WebElement yourName;

	@FindBy(id = "b4-Morning-input")
	@CacheLookup
	WebElement morningSelect;

	@FindBy(id = "b4-Evening-input")
	@CacheLookup
	WebElement eveningSelect;

	@FindBy(id = "b4-TextArea_msg_description")
	@CacheLookup
	WebElement tellUsAboutShift;

	@FindBy(id = "b4-TextArea_msg_successes")
	@CacheLookup
	WebElement textArea_msg_successes;

	@FindBy(id = "b4-TextArea_msg_attendance")
	@CacheLookup
	WebElement textArea_msg_attendance;

	@FindBy(id = "b4-TextArea_msg_maintenance")
	@CacheLookup
	WebElement textArea_msg_maintenance;

	@FindBy(id = "b4-TextArea_msg_complaints")
	@CacheLookup
	WebElement textArea_msg_complaints;

	@FindBy(id = "b4-TextArea_msg_other")
	@CacheLookup
	WebElement textArea_msg_other;

	@FindBy(xpath = "//span[text()='Submit']")
	@CacheLookup
	WebElement submitButton;

	@FindBy(xpath = "//span[text()='Clear']")
	@CacheLookup
	WebElement clearButton;

	@FindBy(xpath = "//span[text()='Done']")
	@CacheLookup
	WebElement DoneButton;

	@FindBy(xpath = "//div[@class='feedback-message-text']")
	@CacheLookup
	WebElement feedbackUserExists;

	@Test(dataProvider = "dailyLogData")
	public void submitDailyLogForm(String Location, String Your_Name) {

		Utility.selectDropdownByValue(driver.findElement(By.id("b4-LocationDropdown")), Location);
		Utility.sendData(driver.findElement(By.id("b4-Author")), Your_Name);
	}

	public void submitDailyLogForm() {

		Utility.selectDropdownByVisibleText(locationDropdown, "MCO AS4");
		Utility.sendData(yourName, "AutomationManagerTwo");
		Utility.clickElement(morningSelect);
		Utility.sendData(tellUsAboutShift, "Shift was good, no any issues");
		Utility.sendData(textArea_msg_successes, "Passengers were happy!!");
		Utility.sendData(textArea_msg_attendance, "Attendance is good");
		Utility.sendData(textArea_msg_maintenance, "No Maintenance Issue");
		Utility.sendData(textArea_msg_complaints, "No complaints at all!!");
		Utility.sendData(textArea_msg_other, "No emergeny or other issues"); // Utility.actionMoveToElement(submitButton);
		Utility.actionKeyDownTillENd();
		Utility.javaScriptExecute(submitButton);
		Utility.javaScriptExecute(DoneButton);
	}

	public void CancelDailyLogForm() {
		Utility.waitUntilElementLocated(By.id("b4-LocationDropdown"));
		Utility.selectDropdownByValue(locationDropdown, "3");
		Utility.sendData(yourName, "AutomationkkkMasnager12");
		Utility.clickElement(morningSelect);
		Utility.sendData(tellUsAboutShift, "Shift was good, no any issues");
		Utility.sendData(textArea_msg_successes, "Passengers were happy!!");
		Utility.sendData(textArea_msg_attendance, "Attendance is good");
		Utility.sendData(textArea_msg_maintenance, "No Maintenance Issue");
		Utility.sendData(textArea_msg_complaints, "No complaints at all!!");
		Utility.sendData(textArea_msg_other, "No emergeny or other issues");
		// Utility.actionMoveToElement(submitButton);
		Utility.actionKeyDownTillENd();
		Utility.javaScriptExecute(clearButton);

	}

	public boolean defaultValuesOnDailyManagerLog() {
		String defaultTest = Utility.getSelectedValueInDropdown(locationDropdown).getText();
		if (defaultTest.contentEquals("Select")) {
			if (yourName.getText().equals(null) || yourName.getText().equals("")) {
				if (tellUsAboutShift.getText().equals(null) || tellUsAboutShift.getText().equals("")) {
					if (textArea_msg_successes.getText().equals(null) || textArea_msg_successes.getText().equals("")) {
						if (textArea_msg_attendance.getText().equals(null)
								|| textArea_msg_attendance.getText().equals("")) {
							if (textArea_msg_maintenance.getText().equals(null)
									|| textArea_msg_maintenance.getText().equals("")) {
								if (textArea_msg_complaints.getText().equals(null)
										|| textArea_msg_complaints.getText().equals("")) {
									if (textArea_msg_other.getText().equals(null)
											|| textArea_msg_other.getText().equals("")) {
										return true;
									}
								}
							}
						}
					}
				}
			}
		}

		return false;
	}

	public String dailyLogEntryExists() throws InterruptedException {
		Utility.waitUntilElementLocated(By.id("b4-LocationDropdown"));
		Utility.selectDropdownByValue(locationDropdown, "6");
		Utility.sendData(yourName, "AutomationManagerTwo");
		Utility.clickElement(morningSelect);
		Utility.sendData(tellUsAboutShift, "Shift was good, no any issues");
		Utility.sendData(textArea_msg_successes, "Passengers were happy!!");
		Utility.sendData(textArea_msg_attendance, "Attendance is good");
		Utility.sendData(textArea_msg_maintenance, "No Maintenance Issue");
		Utility.sendData(textArea_msg_complaints, "No complaints at all!!");
		Utility.sendData(textArea_msg_other, "No emergeny or other issues");
		// Utility.actionMoveToElement(submitButton);
		Utility.actionKeyDownTillENd();
		Utility.javaScriptExecute(submitButton);
		Thread.sleep(1000);
		System.out.println(driver.findElement(By.xpath("//div[@class='feedback-message-text']")).getText());
		return driver.findElement(By.xpath("//div[@class='feedback-message-text']")).getText();
	}

	public String getLocationName(int val) {
		// System.out.println(driver.findElement(By.xpath("//select[@id='b4-LocationDropdown']/option[@value='"+val+"']")).getText());
		return driver.findElement(By.xpath("//select[@id='b4-LocationDropdown']/option[@value='" + val + "']"))
				.getText();
	}
}
