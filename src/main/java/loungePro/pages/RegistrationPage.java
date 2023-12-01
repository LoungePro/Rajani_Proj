/**
 * 
 */
package loungePro.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import loungePro.base.TestBase;
import loungePro.utilities.Utility;

/**
 * Author: Rajani Thite
 */
public class RegistrationPage extends TestBase {
	public RegistrationPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[text()='Registration']")
	@CacheLookup
	WebElement registrion;

	@FindBy(xpath = "//span[text()='Manual Entry']")
	@CacheLookup
	WebElement regManualEntry;

	@FindBy(id = "b5-Input_Airline")
	@CacheLookup
	WebElement airlineSelect;

	@FindBy(id = "b5-Input_Flight")
	@CacheLookup
	WebElement flightID;

	@FindBy(id = "b5-Input_firstName")
	@CacheLookup
	WebElement passFirstName;

	@FindBy(id = "b5-Input_LastName")
	@CacheLookup
	WebElement passLastName;

	@FindBy(id = "b5-Input_AccessType")
	@CacheLookup
	WebElement aceessType;

	@FindBy(id = "b5-Input_Record_Locator2")
	@CacheLookup
	WebElement recordLocator;

	@FindBy(id = "b5-Input_Seat")
	@CacheLookup
	WebElement seatID;

	@FindBy(id = "b5-Input_Class")
	@CacheLookup
	WebElement flightClass;

	@FindBy(xpath = "//span[text()='Submit']")
	@CacheLookup
	WebElement submitForm;

	@FindBy(xpath = "//div[@id='b4-$b4']/div/div/div/span")
	@CacheLookup
	WebElement regCount;

	public void passengerRegistration() {
		Utility.javaScriptExecute(registrion);
		System.out.println("registration Menu selected");
		Utility.javaScriptExecute(regManualEntry);
		System.out.println("Manual entry selected");
		Utility.selectDropdownByValue(airlineSelect, "2");
		Utility.sendData(flightID, "12");
		Utility.sendData(passFirstName, "Rajani");
		Utility.sendData(passLastName, "Thite");
		Utility.selectDropdownByValue(aceessType, "1");
		Utility.sendData(recordLocator, "ABC");
		Utility.sendData(seatID, "12A");
		Utility.sendData(flightClass, "EC");
		Utility.clickElement(submitForm);
		String actualMessage = driver.findElement(By.id("feedbackMessageContainer")).getText();
	}

	public int checkRegCount() throws InterruptedException {
		Utility.javaScriptExecute(registrion);
		//System.out.println("registration Menu selected");
		Thread.sleep(10000);
		String textCount = Utility.getElementText(regCount);
		int count = Integer.parseInt(textCount);
		return count;
	}

}
