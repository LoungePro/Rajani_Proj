/**
 * 
 */
package loungePro.pages;

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

	public void createCompany() throws InterruptedException {
		
		

		Utility.sendData(companyName, "TestCompany");
		Thread.sleep(2000);
		Utility.sendData(companyDisplayName1, "Test Company Display Name");
		System.out.println("company display name added");
		Thread.sleep(4000);
		buttonCreateCompany.click();
		//Utility.clickElement(buttonCreateCompany);
		System.out.println("Company created");

	}

}
