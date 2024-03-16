/**
 * 
 */
package loungePro.pages;

import java.time.Duration;

import org.apache.commons.math3.analysis.function.Exp;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import loungePro.base.TestBase;
import loungePro.utilities.Utility;

//Control +Shift + O to delete unnecessary imports

/**
 * Author Rajani Thite
 */
public class LogInPage extends TestBase {

	public LogInPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@id='b2-Input_Username']")
	@CacheLookup
	WebElement userName;

	@FindBy(xpath = "//input[@id='b2-Input_Password']")
	@CacheLookup
	WebElement userPassword;

	@FindBy(xpath = "//button[text()='Login']")
	@CacheLookup
	WebElement logInButton;

	@FindBy(css = ".para-text")
	@CacheLookup
	WebElement paraText;

	@FindBy(css = ".heading-text")
	@CacheLookup
	WebElement paraHeading;

	public String pageTitle() {
		return driver.getTitle();

	}

	public SuperAdminDashboardPage checkIn(String uName, String pass) {
		userName.sendKeys(uName);
		System.out.println("username entered");
		userPassword.sendKeys(pass);
		Utility.clickElement(logInButton);
		return new SuperAdminDashboardPage();
	}

	public String checkInWithWrongUserIDAndPassword(String uName, String pass) throws InterruptedException {
		Utility.waitUntilElementLocated(By.xpath("//input[@id='b2-Input_Username']"));
		userName.sendKeys(uName);
		userPassword.sendKeys(pass);
		Utility.clickElement(logInButton);
		Utility.waitUntilElementLocated(By.xpath("//div[@class='feedback-message-text']"));
		return driver.findElement(By.xpath("//div[@class='feedback-message-text']")).getText();
	}

	public String checkInWithNoPasswordEntered(String uName, String pass) throws InterruptedException {

		Utility.waitUntilElementLocated(By.xpath("//input[@id='b2-Input_Username']"));
		userName.sendKeys(uName);
		Utility.clickElement(logInButton);
		Utility.waitUntilElementLocated(By.xpath("//div[@class='feedback-message-text']"));
		return driver.findElement(By.xpath("//div[@class='feedback-message-text']")).getText();
	}

	public String checkInWithNoCredentialsEntered(String uName, String pass) throws InterruptedException {
		Utility.waitUntilElementLocated(By.xpath("//button[text()='Login']"));
		Utility.clickElement(logInButton);
		Utility.waitUntilElementLocated(By.xpath("//div[@class='feedback-message-text']"));
		return driver.findElement(By.xpath("//div[@class='feedback-message-text']")).getText();
	}

	public String getParagraphText() {
		return paraText.getText();
	}

	public String getParaHeading() {
		return paraHeading.getText();
	}

}
