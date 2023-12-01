/**
 * 
 */
package loungePro.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;
import loungePro.pages.LogInPage;
import loungePro.pages.PassengerBreakdownPage;
import loungePro.pages.RegistrationPage;
import loungePro.pages.SuperAdminDashboardPage;
import loungePro.utilities.Utility;

/**
 * Author: Rajani Thite
 */
public class TestBase {
	public static WebDriver driver;
	public static Properties properties;
	public static FileInputStream fis;
	public static Select select;
	public LogInPage logInPage;
	public SuperAdminDashboardPage saDashPage;
	public static Actions actions;
	public static ChromeOptions options;
	public static PassengerBreakdownPage passBreakPage;
	public static RegistrationPage registrationPage;

	public TestBase() {
		properties = new Properties();
		try {
			fis = new FileInputStream(
					System.getProperty("user.dir") + "\\src\\main\\java\\loungePro\\config\\config.properties");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			properties.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void launchBrowser() {
		Map<String, Object> prefsMap = new HashMap<String, Object>();
		prefsMap.put("profile.default_content_settings.popups", 0);
		String fileDownloaded = System.getProperty("user.dir");
		prefsMap.put("download.default_directory", fileDownloaded + "/files" + System.currentTimeMillis());

		options = new ChromeOptions();
		options.setExperimentalOption("prefs", prefsMap);
		options.addArguments("--test-type");
		options.addArguments("--disable-extensions");
		String browserName = properties.getProperty("browser");
		if (browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();

		} else if (browserName.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else {
			System.out.println("Enter correct browser");
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Utility.IMPLICIT_WAIT));

		driver.get(properties.getProperty("url"));

	}

}
