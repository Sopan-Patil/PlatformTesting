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

	static ArrayList<String> serialNumber;
	static ArrayList<String> locators;
	static ArrayList<String> url;
	static ArrayList<String> expectedStrings;

	public void readLocalizationData(String sheet)
			throws EncryptedDocumentException, InvalidFormatException, IOException {

		serialNumber = new ArrayList<String>();
		serialNumber = XLHandler.readexcel("LocalizationTestData.xlsx", sheet, "SrNo");

		locators = new ArrayList<String>();
		locators = XLHandler.readexcel("LocalizationTestData.xlsx", sheet, "Locator");
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

	public void validateLocalizationData() {

		SoftAssert softAssert = new SoftAssert();
		newBaseClass = new NewBaseClass();

		for (int i = 0; i < url.size(); i++) {
			// log.info("serialNumber at " + i + " :" + serialNumber.get(i));
			// log.info("url at " + i + " :" + url.get(i));
			// log.info("locators at " + i + " :" + locators.get(i));
			// log.info("expectedStrings at " + i + " :" + expectedStrings.get(i));
			ObjectHelper.driver.navigate().to(url.get(i));// API
			// newBaseClass.replaceurl();
			// CommonFunctions.waitForVisiblity(null, i)
			CommonFunctions.scrollToPageBottom();

			driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

			WebElement element = ObjectHelper.driver.findElement(By.xpath(locators.get(i)));
			CommonFunctions.scrolltoElement(element);

			if (CommonFunctions.waitForVisiblity(element, 1)) {

				String actual = element.getText().trim();
				// log.info("actual :" + actual);
				String expected = expectedStrings.get(i).trim();
				// log.info("expected :" + expected);
//				softAssert.assertEquals(actual, expected, "Validation failed at #" + serialNumber.get(i) + " and url "
//						+ url.get(i) + "for locator " + locators.get(i) + " ");

				softAssert.assertEquals(actual, expected, "Validation failed at #" + serialNumber.get(i) + " ");

//				if (actual == expected) {
//					softAssert.assertEquals(actual, expected, "Validation Passed at # " + serialNumber.get(i)
//							+ " and url " + url.get(i) + "for locator " + locators.get(i) + " ");
//				} else {
//					softAssert.assertEquals(actual, expected, "Validation failed at # " + serialNumber.get(i)
//							+ " and url " + url.get(i) + "for locator " + locators.get(i) + " ");
//				}
				// System.out.println("softAssert.toString() :" + softAssert.toString());

				// softAssert.toString();

			}

		}
		// log.info("Total strings validated = " + serialNumber.size());
		// softAssert.assertTrue(true, "Total strings validated = " +
		// serialNumber.size());
		// softAssert.assertTrue(true, "Total strings validated = " +
		// serialNumber.size());

		softAssert.assertAll("Total strings validated = " + serialNumber.size() + "\n" + " Total strings FAILED = "
				+ serialNumber.size() + "\n");

	}
}
