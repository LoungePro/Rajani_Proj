/**
 * 
 */
package loungePro.pages;

import java.sql.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import loungePro.base.TestBase;
import loungePro.utilities.Utility;

/**
 * Author: Rajani Thite
 */
public class CreateCompanyPage extends TestBase {

	public CreateCompanyPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "b4-Input_Name")
	@CacheLookup
	WebElement companyName;

	@FindBy(id = "b4-Input_DisplayName")
	@CacheLookup
	WebElement companyDisplayName1;

	@FindBy(xpath = "//span[@class='btn-text'][text()='Create Company']")
	@CacheLookup
	WebElement buttonCreateCompany;

	@FindBy(xpath = "//span[@class='btn-text'][text()='Update Company']")
	@CacheLookup
	WebElement buttonUpdateCompany;

	@FindBy(xpath="//div[@id='b4-$b1']/div[@id='b4-b1-SVG']")
	@CacheLookup
	WebElement backIcon;

	@FindBy(xpath = "//div[@class='margin-top-base']/table[@role='grid']/tbody/tr")
	@CacheLookup
	WebElement numbaerOfCompanies;

	@FindBy(xpath = "//div[@class='margin-top-base']/table[@role='grid']/tbody/tr[1]/td[4]/div/a[2]\r\n")
	@CacheLookup
	WebElement firstCompanyToEdit;

	@FindBy(id = "b4-Input_Name_DescribedBy")
	@CacheLookup
	WebElement companyNameValidation;

	@FindBy(id = "b4-Input_DisplayName_DescribedBy")
	@CacheLookup
	WebElement displayNameValidation;

	@FindBy(id = "b4-Input_RemitTo")
	@CacheLookup
	WebElement remitToName;

	@FindBy(id = "b4-Input_BankName")
	@CacheLookup
	WebElement remitToBankName;

	@FindBy(id = "b4-Input_ABA")
	@CacheLookup
	WebElement remitToABA;

	@FindBy(id = "b4-Input_Swift")
	@CacheLookup
	WebElement remitToSwift;

	@FindBy(id = "b4-Input_AccountName")
	@CacheLookup
	WebElement remitToAccountName;

	@FindBy(id = "b4-Input_AccountNumber")
	@CacheLookup
	WebElement remitToAccountNumber;

	@FindBy(id = "b4-Input_SalesTax")
	@CacheLookup
	WebElement remitToSalesTax;

	@FindBy(xpath = "//span[@class='btn-text'][text()='Clear']")
	@CacheLookup
	WebElement clearButton;

	public void createCompany() throws InterruptedException {
		String companyNameGiven = "Automation Demo" + Math.random();

		Utility.sendData(companyName, companyNameGiven);
		Utility.waitUntilElementLocated(By.id("b4-Input_DisplayName"));
		Utility.sendData(companyDisplayName1, "ACN");
		System.out.println("company display name added");

		Utility.waitUntilElementLocated(By.xpath("//span[@class='btn-text'][text()='Create Company']"));
		buttonCreateCompany.click();
		System.out.println(driver.findElement(By.xpath("//div[@class='feedback-message-text']")).getText());

	}

	public void clickOnBackIcon() throws InterruptedException {
		Utility.waitUntilElementIsClickable(By.xpath("//div[@id='b4-$b1']/div[@id='b4-b1-SVG']"));
		Utility.clickElement(backIcon);
	}

	public void editCompany() throws InterruptedException {
		Utility.waitUntilElementLocated(By.xpath("//div[@class='margin-top-base']/table[@role='grid']/tbody/tr[1]"));
		
		Utility.clickElement(firstCompanyToEdit);
		Utility.waitUntilElementLocated(By.id("b4-Input_Name"));
		String editedName = Utility.getElementText(companyName) + "AutoEdited";
		Utility.sendData(companyName, editedName);

		String editedDisplayName = Utility.getElementText(companyDisplayName1) + "AutoEdited";
		Utility.sendData(companyDisplayName1, editedName);
		Utility.waitUntilElementLocated(By.xpath(
				"//span[@class='btn-text'][text()='Update Company']"));
		buttonUpdateCompany.click();
		
		System.out.println(driver.findElement(By.xpath("//div[@class='feedback-message-text']")).getText());
		
	}

	public boolean clearButtonClick() throws InterruptedException {
		String companyNameGiven = "Automation Company Name" + Math.random();
		Utility.waitUntilElementLocated(By.id("b4-Input_DisplayName"));
		Utility.sendData(companyDisplayName1, "ACN");
		Utility.sendData(remitToName, "Remit Name");
		Utility.sendData(remitToBankName, "AXIS");
		Utility.sendData(remitToABA, "ABA");
		Utility.sendData(remitToSwift, "Swift");
		Utility.sendData(remitToAccountName, "Acc Name");
		Utility.sendData(remitToAccountNumber, "1234567890");
		Utility.sendData(remitToSalesTax, "90");
		Utility.waitUntilElementLocated(By.xpath("//span[@class='btn-text'][text()='Clear']"));
		clearButton.click();
		boolean flag = false;

		if (companyDisplayName1.getText().equals("") || companyDisplayName1.getText().equals(null)) {
			if (remitToName.getText().equals("") || remitToName.getText().equals(null)) {
				if (remitToBankName.getText().equals("") || remitToBankName.getText().equals(null)) {
					if (remitToABA.getText().equals("") || remitToABA.getText().equals(null)) {
						if (remitToSwift.getText().equals("") || remitToSwift.getText().equals(null)) {
							if (remitToAccountName.getText().equals("") || remitToAccountName.getText().equals(null)) {
								if (remitToAccountNumber.getText().equals("")
										|| remitToAccountNumber.getText().equals(null)) {
									if (remitToSalesTax.getText().equals("")
											|| remitToSalesTax.getText().equals(null)) {
										flag = true;

									}
								}
							}
						}
					}

				}
			} else
				flag = false;
		}
		return flag;

	}

	public boolean validationOnCompanyAndDisplayName() throws InterruptedException {

		Utility.waitUntilElementLocated(By.xpath("//div[@class='margin-top-base']/table[@role='grid']/tbody/tr"));
		int oldCompanyCount = driver
				.findElements(By.xpath("//div[@class='margin-top-base']/table[@role='grid']/tbody/tr")).size();

		System.out.println("Old Company Count=" + oldCompanyCount);
		buttonCreateCompany.click();
		Utility.waitUntilElementLocated(By.xpath("//div[@class='margin-top-base']/table[@role='grid']/tbody/tr"));
		int newCompanyCount = driver
				.findElements(By.xpath("//div[@class='margin-top-base']/table[@role='grid']/tbody/tr")).size();
		System.out.println("New Company Count=" + newCompanyCount);

		if (Utility.getElementText(companyNameValidation).contentEquals("Cannot be blank")
				&& Utility.getElementText(displayNameValidation).contentEquals("Cannot be blank")
				&& oldCompanyCount == newCompanyCount) {
			return true;
		} else {
			return false;
		}

	}

}
