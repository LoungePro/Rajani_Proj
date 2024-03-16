/**
 * 
 */
package loungePro.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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

	@FindBy(xpath = "//div[@id='$b5']/div/div[1]/div/div/div[2]/div/button")
	@CacheLookup
	WebElement regManualEntry;

	@FindBy(id = "b5-Input_Airline2")
	@CacheLookup
	WebElement airlineSelect;

	@FindBy(xpath = "//span/input[@id='b5-Input_Flight2']")
	@CacheLookup
	WebElement flightID;

	@FindBy(id = "b5-Input_firstName2")
	@CacheLookup
	WebElement passFirstName;

	@FindBy(id = "b5-Input_LastName2")
	@CacheLookup
	WebElement passLastName;

	@FindBy(id = "b5-Input_code_city_from2")
	@CacheLookup
	WebElement fromFlight;

	@FindBy(id = "b5-Input_code_city_to2")
	@CacheLookup
	WebElement toFlight;

	@FindBy(id = "b5-Input_AccessType3")
	@CacheLookup
	WebElement aceessType;

	@FindBy(id = "b5-Input_Record_Locator3")
	@CacheLookup
	WebElement recordLocator;

	@FindBy(xpath = "//div[@id='b5-b41-Column1']/div/span/input")
	@CacheLookup
	WebElement seatID;

	@FindBy(id = "b5-Input_Class2")
	@CacheLookup
	WebElement flightClass;

	@FindBy(xpath = "//form[@id='b5-FormDesktop']/div[2]/button[2]")
	@CacheLookup
	WebElement submitForm;

	@FindBy(xpath = "//span[text()='Cancel']")
	@CacheLookup
	WebElement cancelButton;

	@FindBy(xpath = "//div[@id='b4-$b5']/div/div/div/span")
	@CacheLookup
	WebElement regCount;

	@FindBy(id = "b5-Input_Airline2_DescribedBy")
	@CacheLookup
	WebElement airlineValidation;

	/*
	 * @FindBy(id = "b5-Input_Flight_DescribedBy")
	 * 
	 * @CacheLookup WebElement flightValidation;
	 */

	@FindBy(id = "b5-Input_Flight2_DescribedBy")
	@CacheLookup
	WebElement flightValidation;

	@FindBy(id = "b5-Input_firstName2_DescribedBy")
	@CacheLookup
	WebElement firstNameValidation;

	@FindBy(id = "b5-Input_LastName2_DescribedBy")
	@CacheLookup
	WebElement lastNameValidation;

	@FindBy(id = "b5-Input_AccessType3_DescribedBy")
	@CacheLookup
	WebElement accessTypeValidation;

	@FindBy(id = "b5-Input_Record_Locator3_DescribedBy")
	@CacheLookup
	WebElement recordLocatorValidation;

	@FindBy(id = "b5-Input_Seat2_DescribedBy")
	@CacheLookup
	WebElement seatValidation;

	@FindBy(id = "b5-Input_Class2_DescribedBy")
	@CacheLookup
	WebElement classValidation;
	
	@FindBy(id = "b5-Input_AccessType4")
	@CacheLookup
	WebElement accessSubtype;
	
	@FindBy(xpath = "//span[text()='Passenger']")
	@CacheLookup
	WebElement passengerManu;
	
	

	public boolean passengerRegistration() throws InterruptedException  {
		
		System.out.println("at passengerRegistration page");
	
		Utility.waitUntilElementLocated(By.xpath("//span[text()='Passenger']"));
		Utility.waitUntilElementIsClickable(By.xpath("//span[text()='Passenger']"));
		Thread.sleep(9000);
		driver.findElement(By.xpath("//span[text()='Passenger']")).click();
		System.out.println("Passenger clicked at passengerRegistration");
		
		Utility.waitUntilElementLocated(By.xpath("//span[text()='Registration']"));
		Utility.waitUntilElementIsClickable(By.xpath("//span[text()='Registration']"));
		Thread.sleep(3000);
		Utility.clickElement(registrion);
		boolean reg = false;
		System.out.println("registration Menu selected");
		
		int oldPReg = checkRegCount();
		System.out.println("Registrations by day=" + oldPReg);
		System.out.println("items=" + driver.findElement(By.xpath("//div[@id='b4-b5-Column1']/div/span")).getText());

		Utility.waitUntilElementLocated(By.xpath("//div[@id='$b5']/div/div[1]/div/div/div[2]/div/button"));
		Utility.waitUntilElementIsClickable(By.xpath("//div[@id='$b5']/div/div[1]/div/div/div[2]/div/button"));
Thread.sleep(4000)	;
Utility.clickElement(regManualEntry);
		//driver.findElement(By.xpath("//div[@id='$b5']/div/div[1]/div/div/div[2]/div/button")).click();
		System.out.println("Manual entry selected");

		System.out.println("Manual entry selected");
		Utility.selectDropdownByValue(airlineSelect, "2");

		driver.findElement(By.xpath("//span/input[@id='b5-Input_Flight2']")).sendKeys("Flight");
		// Utility.sendData(flightID, "Flight");
		Utility.sendData(passFirstName, "Automation User");
		Utility.sendData(passLastName, "One");

		Utility.sendData(fromFlight, "AB");
		Utility.sendData(toFlight, "CD");
		
		Utility.selectDropdownByValue(aceessType, "0");
		Utility.selectDropdownByValue(accessSubtype, "0");
		Utility.sendData(recordLocator, "ABC");
		
		Utility.sendData(seatID, "12A");
		Utility.sendData(flightClass, "EC");
		Utility.actionKeyDownTillENd();
		Utility.clickElement(submitForm);

		

		int newPReg = checkRegCount();

		System.out.println("oldPReg" + oldPReg + "newPReg" + newPReg);
		if ((oldPReg + 1) == newPReg) {
			reg = true;
		}
		return reg;
	}

	public int checkRegCount() throws InterruptedException {
		Thread.sleep(3000);
Utility.waitUntilElementLocated(By.xpath("//div[@id='b4-$b5']/div/div/div/span"));
		String textCount = Utility.getElementText(regCount);
		int count = Integer.parseInt(textCount);

		return count;
	}

	public boolean validationOnRequiredFields() throws InterruptedException, AWTException {
		System.out.println("at passengerRegistration page");
		
		Utility.waitUntilElementLocated(By.xpath("//span[text()='Passenger']"));
		Utility.waitUntilElementIsClickable(By.xpath("//span[text()='Passenger']"));
		Thread.sleep(20000);
		driver.findElement(By.xpath("//span[text()='Passenger']")).click();
		System.out.println("Passenger clicked at passengerRegistration");
		
		Utility.waitUntilElementLocated(By.xpath("//span[text()='Registration']"));
		Utility.waitUntilElementIsClickable(By.xpath("//span[text()='Registration']"));
		//Thread.sleep(3000);
		Utility.clickElement(registrion);
		
		System.out.println("registration Menu selected");
		System.out.println("items=" + driver.findElement(By.xpath("//div[@id='b4-b5-Column1']/div/span")).getText());

		Utility.waitUntilElementLocated(By.xpath("//div[@id='$b5']/div/div[1]/div/div/div[2]/div/button"));
		Utility.waitUntilElementIsClickable(By.xpath("//div[@id='$b5']/div/div[1]/div/div/div[2]/div/button"));

		Utility.clickElement(regManualEntry);

		//Thread.sleep(5000);
		driver.findElement(By.xpath("//div[@id='$b5']/div/div[1]/div/div/div[2]/div/button")).click();
		System.out.println("Manual entry selected");
		Utility.actionKeyDownTillENd();
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

	public boolean validationOfFlightAndLastName() throws InterruptedException {
		Thread.sleep(4000);
		Utility.javaScriptExecute(registrion);
		System.out.println("registration Menu selected");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));

		try {
			wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath("//div[@id='$b5']/div/div[1]/div/div/div[2]/div/button")));
		} catch (Exception e1) {
			System.out.println("Oh");
		}

		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[@id='$b5']/div/div[1]/div/div/div[2]/div/button")).click();
		System.out.println("Manual entry selected");
		Utility.actionKeyDownTillENd();

		Utility.selectDropdownByValue(airlineSelect, "2");
		Utility.sendData(passFirstName, "Automation User");
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
	
		Utility.waitUntilElementLocated(By.xpath("//span[text()='Passenger']"));
		Utility.actionMoveToElement(passengerManu);
		Thread.sleep(10000);
		Utility.waitUntilElementIsClickable(By.xpath("//span[text()='Passenger']"));
	
		driver.findElement(By.xpath("//span[text()='Passenger']")).click();
		System.out.println("Passenger clicked at passengerRegistration");
		Utility.waitUntilElementLocated(By.xpath("//span[text()='Registration']"));
		Utility.javaScriptExecute(registrion);
		System.out.println("registration Menu selected");
		Thread.sleep(4000);
		Utility.waitUntilElementLocated(By.xpath("//div[@id='$b5']/div/div[1]/div/div/div[2]/div/button"));
		Utility.waitUntilElementIsClickable(By.xpath("//div[@id='$b5']/div/div[1]/div/div/div[2]/div/button"));
		int oldPassRegCount = checkRegCount();
		System.out.println("oldRegCount" + oldPassRegCount);
Thread.sleep(4000);
		driver.findElement(By.xpath("//div[@id='$b5']/div/div[1]/div/div/div[2]/div/button")).click();
		System.out.println("Manual entry selected");

		System.out.println("Manual entry selected");
		Utility.selectDropdownByValue(airlineSelect, "2");
		Utility.sendData(flightID, "12");
		Utility.sendData(passFirstName, "Automation User");
		Utility.sendData(passLastName, "One");
		
		Utility.selectDropdownByValue(aceessType, "0");
		Utility.sendData(recordLocator, "ABC");
		Utility.sendData(seatID, "12A");
		Utility.sendData(flightClass, "EC");
		Utility.clickElement(cancelButton);
		//Utility.actionKeyDownTillENd();
		int newPassRegCount = checkRegCount();
		System.out.println("newRegCount" + newPassRegCount);
		if (oldPassRegCount == newPassRegCount) {
			flag = true;
		}
		System.out.println("falg=" + flag);
		return flag;

	}

}
