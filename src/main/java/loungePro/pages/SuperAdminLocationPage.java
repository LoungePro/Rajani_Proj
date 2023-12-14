/**
 * 
 */
package loungePro.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import loungePro.base.TestBase;

/**
 * Author: Rajani Thite
 */
public class SuperAdminLocationPage extends TestBase {
	public SuperAdminLocationPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@class='list list-group OSFillParent']/div/div[@class='margin-bottom-s']/span")
	@CacheLookup
	WebElement noOfCompanies;

	public static int getNoOfCompaniesFromSuperAdminLoc() {
		return driver
				.findElements(
						By.xpath("//div[@class='list list-group OSFillParent']/div/div[@class='margin-bottom-s']/span"))
				.size();
	}

	public void getCompaniesFromSuperAdminLoc() {
		int noCompanies = driver
				.findElements(
						By.xpath("//div[@class='list list-group OSFillParent']/div/div[@class='margin-bottom-s']/span"))
				.size();

		for (int j = 1; j <= noCompanies; j++)
			System.out.println(driver.findElement(
					By.xpath("(//div[@class='list list-group OSFillParent']/div/div[@class='margin-bottom-s']/span)"
							+ "[" + j + "]"))
					.getText());

	}
}
