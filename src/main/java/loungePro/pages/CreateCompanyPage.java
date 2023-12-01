/**
 * 
 */
package loungePro.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import loungePro.base.TestBase;

/**
 * 
 */
public class CreateCompanyPage extends TestBase{
	
	@FindBy (id="b4-Input_Name")
	@CacheLookup
	WebElement companyName;
	
	@FindBy (id="b4-Input_DisplayName")
	@CacheLookup
	WebElement companyDisplayName1;
	
	@FindBy (xpath="//span[@class='btn-text'][text()='Create Company']")
	@CacheLookup
	WebElement buttonCreateCompany;
	
	
	public void createCompany() {
		companyName.sendKeys("TestCompany");
		companyDisplayName1.sendKeys("Test Company Display Name");
		buttonCreateCompany.click();
		
	
	}
	
	
	
	
	

}
