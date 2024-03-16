/**
 * 
 */
package loungePro.pages;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.google.errorprone.annotations.CanIgnoreReturnValue;

import loungePro.base.TestBase;
import loungePro.utilities.Utility;

/**
 * Author: Rajani Thite 2-1-24
 */
public class DailyManagerLogPage extends TestBase {

	public DailyManagerLogPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@id='b4-b13-PaginationRecords']/span[5]")
	@CacheLookup
	static WebElement noOfItems;

	@FindBy(id = "b4-Input_DateFrom")
	@CacheLookup
	WebElement fromDate;

	@FindBy(id = "b4-Input_DateTo")
	@CacheLookup
	WebElement toDate;

	@FindBy(xpath = "//table[@role='grid']/tbody/tr[1]/td[3]/div/span")
	@CacheLookup
	WebElement locations;

	Date date = new Date();
	SimpleDateFormat formatter = new SimpleDateFormat("MM-dd-yy");
	String str = formatter.format(date);

	public static int getNoOfItems() throws NumberFormatException {
		// System.out.println(noOfItems.getText());
		return Integer.parseInt(noOfItems.getText());
	}

	public String getFromDate() {
		// return fromDate.getAttribute("value");
		System.out.println(fromDate.getAttribute("value"));
		return fromDate.getAttribute("value");
	}

	public String getToDate() {
		// return fromDate.getAttribute("value");
		System.out.println(toDate.getAttribute("value"));
		return fromDate.getAttribute("value");
	}

	public List<String> getAlreadyExistLocations() {
		List<String> list = new ArrayList<String>();
		try {
			for (int row = 1; row <= getNoOfItems(); row++) {
				list.add(driver.findElement(By.xpath("//table[@role='grid']/tbody/tr[" + row + "]/td[3]/div/span"))
						.getText());

			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(list);

		return list;
	}
	
	
	
	
	

}
