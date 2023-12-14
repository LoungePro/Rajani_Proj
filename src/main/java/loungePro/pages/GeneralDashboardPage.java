/**
 * 
 */
package loungePro.pages;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import loungePro.base.TestBase;
import loungePro.utilities.Utility;

/**
 * Author Rajani Thite 12/04/23
 */
public class GeneralDashboardPage extends TestBase {
	public GeneralDashboardPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@id='b4-b2-b1-SelectedValues']/span")
	@CacheLookup
	WebElement chooseALocation;

	@FindBy(xpath = "//div[@class='padding-base']/div[@class='list list-group OSFillParent']/div")
	@CacheLookup
	Set<WebElement> noOfCompanies;

	@FindBy(xpath = "//span[text()='General DashBoard']")
	@CacheLookup
	WebElement generalDashBoard;

	public int getNumberOfCompanies() throws InterruptedException {

		return driver
				.findElements(By.xpath("//div[@class='padding-base']/div[@class='list list-group OSFillParent']/div"))
				.size();

	}

	public void getCompanies() throws InterruptedException {
		HashSet<String> companyName=new HashSet<String>();
		int noOfCompany = driver
				.findElements(By.xpath("//div[@class='padding-base']/div[@class='list list-group OSFillParent']/div"))
				.size();	
		System.out.println("No of Company"+noOfCompany);
		Thread.sleep(5000);
		driver.findElement(By.id("b4-b2-b1-SelectedValuesWrapper")).click();
		//driver.findElement(By.xpath("//span[text()='Choose a Location']")).click();
	for(int i=1;i<=noOfCompany;i++) {
		Thread.sleep(4000);
	//driver.findElements(By.xpath("(//div[@class='padding-base']/div[@class='list list-group OSFillParent']/div/span)["+i+"]"));
		String cName=driver.findElement(By.xpath("(//div[@class='padding-base']/div[@class='list list-group OSFillParent']/div/span)["+i+"]")).getText();
		companyName.add(cName);
				
	}
	for (String string : companyName) {
		System.out.println(string);
	}
	System.out.println(companyName);
	}
}
