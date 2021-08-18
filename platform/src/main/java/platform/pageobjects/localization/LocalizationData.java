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

		// log.info("inside validateLocalizationData()");
		// log.info("url :" + url);
		// log.info("locators :" + locators);
		// log.info("url :" + url);
		// log.info("expectedStrings :" + expectedStrings);
		SoftAssert softAssert = new SoftAssert();
		newBaseClass = new NewBaseClass();
		for (int i = 0; i < url.size(); i++) {
			log.info("serialNumber at " + i + " :" + serialNumber.get(i));
			log.info("url at " + i + " :" + url.get(i));
			log.info("locators at " + i + " :" + locators.get(i));
			log.info("expectedStrings at " + i + " :" + expectedStrings.get(i));
			ObjectHelper.driver.navigate().to(url.get(i));// API
			// newBaseClass.replaceurl();
			// CommonFunctions.waitForVisiblity(null, i)
			CommonFunctions.scrollToPageBottom();
//			try {
//				Thread.sleep(3000);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}

			driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

			WebElement element = ObjectHelper.driver.findElement(By.xpath(locators.get(i)));
			CommonFunctions.scrolltoElement(element);
//			if (!element.isDisplayed()) {
//				CommonFunctions.scrolltoElement(element);
//			}
			// CommonFunctions.scrolltoElement(element);
			if (CommonFunctions.waitForVisiblity(element, 3)) {

				// if (element.isDisplayed()) {
				// if
				// (CommonFunctions.waitForVisiblity(ObjectHelper.driver.findElement(By.xpath(locators.get(i))),
				// 3)) {
				// if
				// (CommonFunctions.isElementVisible(ObjectHelper.driver.findElement(By.xpath(locators.get(i)))))
				// {

				String actual = element.getText();
				log.info("actual  :" + actual);
				String expected = expectedStrings.get(i);
				// log.info("expected :" + expected);
				softAssert.assertEquals(actual, expected);
				// log.error(softAssert.assertEquals(actual, expected));
				// if (softAssert.toString() != null) {
				// log.error("error in url at " + i + " :" + url.get(i));
				// }
				// log.info(softAssert.toString());

			}

			// ObjectHelper.driver.findElement(By.xpath(locators.get(i))).getText();

		}
		softAssert.assertAll();
	}
}
