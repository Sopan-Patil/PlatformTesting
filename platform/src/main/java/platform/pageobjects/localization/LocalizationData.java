package platform.pageobjects.localization;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import base.NewBaseClass;
import utils.CommonFunctions;
import utils.ExcelUtil;
import utils.ObjectHelper;
import utils.XLHandler;

/**
 * @Author : Chetan Sonparote
 * @Date : 9 Aug 2021
 * @Description: Class to read and compare localization data
 */

public class LocalizationData {
	List<String[]> testdata;
	public WebDriver driver;
	private static Logger log = LogManager.getLogger(LocalizationData.class.getName());

	public LocalizationData(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// read from excel

	/**
	 * @Author : Chetan Sonparote
	 * @Date : 10 Aug 2021
	 * @Description: method to read and validate localization data
	 */

	public static ArrayList<String> serialNumber;
	public static ArrayList<String> categories;
	public static ArrayList<String> locators;
	public static ArrayList<String> url;
	public static ArrayList<String> expectedStrings;

	public void readLocalizationData(String sheet)
			throws EncryptedDocumentException, InvalidFormatException, IOException {

		serialNumber = new ArrayList<String>();
		serialNumber = XLHandler.readexcel("LocalizationTestData.xlsx", sheet, "SrNo");

		categories = new ArrayList<String>();
		categories = XLHandler.readexcel("LocalizationTestData.xlsx", sheet, "Categories");

		locators = new ArrayList<String>();
		locators = ExcelUtil.readexcel("LocalizationTestData.xlsx", sheet, "Locator");
		// log.info("locators :" + locators);

		url = new ArrayList<String>();
		url = XLHandler.readexcel("LocalizationTestData.xlsx", sheet, "Screen URL");
		// log.info("url :" + url);

		expectedStrings = new ArrayList<String>();
		expectedStrings = XLHandler.readexcel("LocalizationTestData.xlsx", sheet, "Expected String");
		// log.info("expectedStrings :" + expectedStrings);

	}
	// navigate to link
	// compare string

	NewBaseClass newBaseClass;
	public static ArrayList<String> status;
	public static int passCount;
	public static int failCount;

	public void validateLocalizationData() {

		SoftAssert softAssert = new SoftAssert();
		newBaseClass = new NewBaseClass();
		status = new ArrayList<String>();
		passCount = 0;
		failCount = 0;
		status.add(0, " Detailed Status is as follows :");
		for (int i = 0; i < url.size(); i++) {

			ObjectHelper.driver.navigate().to(url.get(i));// API

			CommonFunctions.scrollToPageBottom();

			driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

			WebElement element = ObjectHelper.driver.findElement(By.xpath(locators.get(i)));
			CommonFunctions.scrolltoElement(element);

			if (CommonFunctions.waitForVisiblity(element, 1)) {

				String actual = element.getText().trim();

				String expected = expectedStrings.get(i).trim();
				// log.info("serialNumber at " + i + " :" + serialNumber.get(i));
				String testStatus = null;
				if (expected.equals(actual)) {
					passCount += 1;
					testStatus = "Status: PASS"; // add count here
				} else {

					failCount += 1;
					testStatus = "Status: FAIL";
				}
				status.add(i + 1, testStatus);
				// log.info("status :" + status);
				softAssert.assertEquals(actual, expected, "Validation failed at #" + serialNumber.get(i) + " ");

			}

		}

		softAssert.assertAll("Total strings validated = " + serialNumber.size() + "\n");

	}
}
