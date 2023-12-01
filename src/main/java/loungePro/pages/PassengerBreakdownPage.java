/**
 * 
 */
package loungePro.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import loungePro.base.TestBase;
import loungePro.utilities.Utility;

/**
 * 
 */
public class PassengerBreakdownPage extends TestBase {
	public PassengerBreakdownPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	
	
	@FindBy (xpath="//div[@id='b4-b15-Menu']/div")
	@CacheLookup
	WebElement passBreakdownExport;
	
	
	
	public void clickExport() throws InterruptedException {
		Utility.javaScriptExecute(passBreakdownExport);
		Utility.actionSendKeys(passBreakdownExport, Keys.TAB);
		Thread.sleep(3000);
		Utility.actionSendKeys(passBreakdownExport, Keys.ENTER);
		Thread.sleep(10000);
	}
}
