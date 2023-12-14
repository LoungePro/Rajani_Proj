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

	@FindBy(xpath = "//span[text()='Cancel']")
	@CacheLookup
	WebElement cancelButton;

	@FindBy(xpath = "//div[@id='b4-$b4']/div/div/div/span")
	@CacheLookup
	WebElement regCount;

	@FindBy(id = "b5-Input_Airline_DescribedBy")
	@CacheLookup
	WebElement airlineValidation;

	@FindBy(id = "b5-Input_Flight_DescribedBy")
	@CacheLookup
	WebElement flightValidation;

	@FindBy(id = "b5-Input_firstName_DescribedBy")
	@CacheLookup
	WebElement firstNameValidation;

	@FindBy(id = "b5-Input_LastName_DescribedBy")
	@CacheLookup
	WebElement lastNameValidation;

	@FindBy(id = "b5-Input_AccessType_DescribedBy")
	@CacheLookup
	WebElement accessTypeValidation;

	@FindBy(id = "b5-Input_Record_Locator2_DescribedBy")
	@CacheLookup
	WebElement recordLocatorValidation;

	@FindBy(id = "b5-Input_Seat_DescribedBy")
	@CacheLookup
	WebElement seatValidation;

	@FindBy(id = "b5-Input_Class_DescribedBy")
	@CacheLookup
	WebElement classValidation;

	public boolean passengerRegistration() throws InterruptedException {
		Utility.javaScriptExecute(registrion);

		boolean reg = false;
		System.out.println("registration Menu selected");
		int oldPReg = checkRegCount();
		Utility.javaScriptExecute(regManualEntry);
		System.out.println("Manual entry selected");
		Utility.selectDropdownByValue(airlineSelect, "2");
		Utility.sendData(flightID, "12");
		Utility.sendData(passFirstName, "Rajani");
		Utility.sendData(passLastName, "Thite");
		Utility.selectDropdownByValue(aceessType, "0");
		Utility.sendData(recordLocator, "ABC");
		Utility.sendData(seatID, "12A");
		Utility.sendData(flightClass, "EC");
		Utility.clickElement(submitForm);

		int newPReg = checkRegCount();

		System.out.println("oldPReg" + oldPReg + "newPReg" + newPReg);
		if ((oldPReg + 1) == newPReg) {
			reg = true;
		}
		return reg;
	}

	public int checkRegCount() throws InterruptedException {
		// Utility.javaScriptExecute(registrion);
		// System.out.println("registration Menu selected");
		Thread.sleep(10000);
		String textCount = Utility.getElementText(regCount);
		int count = Integer.parseInt(textCount);
		return count;
	}

	public boolean validationOnRequiredFields() {
		Utility.javaScriptExecute(registrion);
		System.out.println("registration Menu selected");
		Utility.javaScriptExecute(regManualEntry);
		System.out.println("Manual entry selected");
		Utility.javaScriptExecute(submitForm);
		boolean flag = false;

		if (airlineValidation.getText().equals("Cannot be blank")
				&& flightValidation.getText().equals("Cannot be blank")
				&& firstNameValidation.getText().equals("Cannot be blank")
				&& lastNameValidation.getText().equals("Cannot be blank")
				&& accessTypeValidation.getText().equals("Cannot be blank")
				&& recordLocatorValidation.getText().equals("Cannot be blank")
				&& seatValidation.getText().equals("Cannot be blank")
				&& classValidation.getText().equals("Cannot be blank")) {
			flag = true;
		}
		return flag;

	}

	public boolean validationOfFlightAndLastName() {
		Utility.javaScriptExecute(registrion);
		System.out.println("registration Menu selected");
		Utility.javaScriptExecute(regManualEntry);
		System.out.println("Manual entry selected");
		Utility.selectDropdownByValue(airlineSelect, "2");
		Utility.sendData(passFirstName, "Rajani");
		Utility.selectDropdownByValue(aceessType, "0");
		Utility.sendData(recordLocator, "ABC");
		Utility.sendData(seatID, "12A");
		Utility.sendData(flightClass, "EC");

		Utility.javaScriptExecute(submitForm);
		boolean flag = false;

		if (flightValidation.getText().equals("Cannot be blank")
				&& lastNameValidation.getText().equals("Cannot be blank")) {
			flag = true;
		}
		return flag;

	}

	public boolean cancelRegistration() throws InterruptedException {
		boolean flag = false;
		Utility.javaScriptExecute(registrion);
		System.out.println("registration Menu selected");
		int oldPassRegCount = checkRegCount();
		System.out.println("oldRegCount" + oldPassRegCount);
		Utility.javaScriptExecute(regManualEntry);
		System.out.println("Manual entry selected");
		Utility.selectDropdownByValue(airlineSelect, "2");
		Utility.sendData(flightID, "12");
		Utility.sendData(passFirstName, "Rajani");
		Utility.sendData(passLastName, "Thite");
		Utility.selectDropdownByValue(aceessType, "0");
		Utility.sendData(recordLocator, "ABC");
		Utility.sendData(seatID, "12A");
		Utility.sendData(flightClass, "EC");
		Utility.clickElement(cancelButton);

		int newPassRegCount = checkRegCount();
		System.out.println("newRegCount" + newPassRegCount);
		if (oldPassRegCount == newPassRegCount) {
			flag = true;
		}
		System.out.println("falg=" + flag);
		return flag;

	}

}
