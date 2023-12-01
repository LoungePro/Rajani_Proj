/**
 * 
 */
package loungePro.utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import loungePro.base.TestBase;

/**
 * 
 */
public class Utility extends TestBase {

	public static int IMPLICIT_WAIT = 50;

	public static void captureScreenShot() {
		TakesScreenshot takeScreenShot = (TakesScreenshot) driver;
		File ssfile = takeScreenShot.getScreenshotAs(OutputType.FILE);
		// File destinationFile = new File("");
		String screenShotDir = System.getProperty("user.dir");
		try {
			FileUtils.copyFile(ssfile, new File(screenShotDir + "/ScreenShotDir/" + "ss" + System.currentTimeMillis()+".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	public static void sendData(WebElement element, String data) {
		element.sendKeys(data);
	}

	public static void selectDropdownByIndex(WebElement element, int index) {
		select = new Select(element);
		select.selectByIndex(index);
	}

	public static void selectDropdownByValue(WebElement element, String i) {
		select = new Select(element);
		select.selectByValue(i);
	}

	public static void selectDropdownByVisibleText(WebElement element, String text) {
		select = new Select(element);
		select.selectByVisibleText(text);
	}

	public static void actionMouseHover(WebElement element) {
		actions = new Actions(driver);
		actions.moveToElement(element).perform();

	}

	public static void actionDoubleClick(WebElement element) {
		actions = new Actions(driver);
		actions.doubleClick(element).perform();
	}

	public static void actionDragAndDrop(WebElement source, WebElement destination) {
		actions = new Actions(driver);
		actions.dragAndDrop(source, destination).build().perform();
	}
	public static void actionSendKeys(WebElement element, Keys key) {
		actions = new Actions(driver);
		actions.sendKeys(key).perform();
	}
	
	public static void clickElement(WebElement element) {
		element.click();
	}
	
	public static String getElementText(WebElement element) {
		String text=element.getText();
		return text;
	}
	public static void javaScriptExecute(WebElement element) {
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", element);
	}
	
	public static void takeElementScreenShot(WebElement element) {
		File file=element.getScreenshotAs(OutputType.FILE);
		String elementScreenShotDir = System.getProperty("user.dir");
		try {
			FileUtils.copyFile(file, new File(elementScreenShotDir + "/ScreenShotDir/" + "ss" + System.currentTimeMillis()+ ".jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
	

}
