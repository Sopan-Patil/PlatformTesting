package platform.pageobjects.MyPage;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import platform.pageobjects.Authentication.LoginPage;
import utils.CommonFunctions;
import utils.XLHandler;

/**
 * @Author : Sopan Patil
 * @Date : 22 Jul 2021
 * @Description:Class for entering invalid credit card details
 */

public class AccountAndSecurity {

	List<String[]> testdata;
	public WebDriver driver;
	private static Logger log = LogManager.getLogger(LoginPage.class.getName());
	int waitTime = 5;

	public AccountAndSecurity(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@class='link js-not-link']")
	public WebElement accountInformation;

	@FindBy(xpath = "//a[contains(@class,'button button--default button--base')]")
	public WebElement changeButton;

	@FindBy(xpath = "//input[@id='family_name']")
	public WebElement kanjiSurNameTextField;

	@FindBy(xpath = "//input[@id='given_name']")
	public WebElement kanaNameTextField;

	@FindBy(xpath = "//input[@id='first-name-kana']")
	public WebElement kanaFirstNameTextField;

	@FindBy(xpath = "//input[@id='last-name-kana']")
	public WebElement kanaLastNameTextField;

	@FindBy(xpath = "//input[@id='female']")
	public WebElement genderOption;

	@FindBy(xpath = "//select[@id='birthday.year']")
	public WebElement birthYearDropdown;

	@FindBy(xpath = "//select[@id='birthday.month']")
	public WebElement birthMonthDropdown;

	@FindBy(xpath = "//select[@id='birthday.day']")
	public WebElement birthDateDropdown;

	@FindBy(xpath = "//input[@id='code1']")
	public WebElement postalCode1TextField;

	@FindBy(xpath = "//input[@id='code2']")
	public WebElement postalCode2TextField;

	@FindBy(xpath = "//input[@id='notice-by-mail']")
	public WebElement receiveNotificationsByMailCheckBox;

	@FindBy(xpath = "//span[@id='select2-address_prefecture-container']")
	public WebElement AddressPrefectureDropdown;

	@FindBy(xpath = "//input[@id='city']")
	public WebElement AddressCityTextField;

	@FindBy(xpath = "//input[@id='town']")
	public WebElement AddressTownTextField;

	@FindBy(xpath = "//input[@id='street']")
	public WebElement AddressStreetTextField;

	@FindBy(xpath = "//input[@id='apartment']")
	public WebElement AddressApartmentTextField;

	@FindBy(xpath = "//input[@id='phone1']")
	public WebElement phone1TextField;

	@FindBy(xpath = "//input[@id='phone2']")
	public WebElement phone2TextField;

	@FindBy(xpath = "//input[@id='phone3']")
	public WebElement phone3TextField;

	@FindBy(xpath = "//button[@role='button']")
	public WebElement saveButton;

	public void clickAccountInformation() {
		if (CommonFunctions.waitForVisiblity(accountInformation, waitTime)) {
			accountInformation.click();

		}
	}

	public void clickChangeButton() {
		CommonFunctions.scrolltoElement(changeButton);
		if (CommonFunctions.waitForVisiblity(changeButton, waitTime)) {
			changeButton.click();
		}

	}

	public void UpdateAccountAndSecurityInformation() throws Exception {
		String[] shipmentdata;

		shipmentdata = XLHandler.readexcel("UpdateAccountInformation", "NewTestData.xlsx");

		CommonFunctions.isElementVisible(kanjiSurNameTextField);

		CommonFunctions.waitForVisiblity(kanjiSurNameTextField, waitTime);
		kanjiSurNameTextField.sendKeys(shipmentdata[0]);
		log.info("entering Kanji Sur Name to 'kanji Sur Name' textbox");

		CommonFunctions.waitForVisiblity(kanaNameTextField, waitTime);
		kanaNameTextField.sendKeys(shipmentdata[1]);
		log.info("entering Kanji Name to 'kanji  Name' textbox");

		CommonFunctions.waitForVisiblity(kanaFirstNameTextField, waitTime);
		kanaFirstNameTextField.sendKeys(shipmentdata[2]);
		log.info("entering Kanji First Name to 'kanji First Name' textbox");

		CommonFunctions.waitForVisiblity(kanaLastNameTextField, waitTime);
		kanaLastNameTextField.sendKeys(shipmentdata[3]);
		log.info("entering Kanji Last Name to 'kanji Last Name' textbox");

		CommonFunctions.scrolltoElement(postalCode1TextField);
//		JavascriptExecutor js = (JavascriptExecutor) ObjectHelper.driver;
//		js.executeScript("arguments[0].scrollIntoView();", genderOption);
		genderOption.click();

		Select BirthYear = new Select(birthYearDropdown);
		BirthYear.selectByValue(shipmentdata[4]);
		log.info("selecting 'Birth year ' Dropdown");

//		Select BirthYear = new Select(birthYearDropdown);
//		BirthYear.selectByVisibleText(shipmentdata[4]);
//		log.info("selecting 'Birth year ' Dropdown");

		Select BirthMonth = new Select(birthMonthDropdown);
		BirthMonth.selectByVisibleText(shipmentdata[5]);
		log.info("selecting 'Birth month ' Dropdown");

		Select BirthDate = new Select(birthDateDropdown);
		BirthDate.selectByVisibleText(shipmentdata[6]);
		log.info("selecting 'Birth date ' Dropdown");

		CommonFunctions.waitForVisiblity(postalCode1TextField, waitTime);
		postalCode1TextField.sendKeys(shipmentdata[7]);
		log.info("entering Postal Code to 'Postal Code 1' textbox");

		CommonFunctions.waitForVisiblity(postalCode2TextField, waitTime);
		postalCode2TextField.sendKeys(shipmentdata[8]);
		log.info("entering Postal Code to 'Postal Code 2' textbox");

		receiveNotificationsByMailCheckBox.click();

		Select AddDropdown = new Select(AddressPrefectureDropdown);
		AddDropdown.selectByVisibleText(shipmentdata[9]);
		log.info("selecting 'Address prefecture' Dropdown");

		CommonFunctions.waitForVisiblity(AddressCityTextField, waitTime);
		AddressCityTextField.sendKeys(shipmentdata[10]);
		log.info("entering Address City to 'Address City' textbox");

		CommonFunctions.waitForVisiblity(AddressTownTextField, waitTime);
		AddressTownTextField.sendKeys(shipmentdata[11]);
		log.info("entering Address Town to 'Address Town' textbox");

		CommonFunctions.waitForVisiblity(AddressTownTextField, waitTime);
		AddressTownTextField.sendKeys(shipmentdata[12]);
		log.info("entering Address Town to 'Address Town' textbox");

		CommonFunctions.waitForVisiblity(AddressStreetTextField, waitTime);
		AddressStreetTextField.sendKeys(shipmentdata[13]);
		log.info("entering Address Street to 'Address Street' textbox");

		CommonFunctions.waitForVisiblity(AddressApartmentTextField, waitTime);
		AddressApartmentTextField.sendKeys(shipmentdata[14]);
		log.info("entering Address Apartment to 'Address Apartment' textbox");

		CommonFunctions.waitForVisiblity(phone1TextField, waitTime);
		phone1TextField.sendKeys(shipmentdata[15]);
		log.info("entering Phone to 'Phone 1' textbox");

		CommonFunctions.waitForVisiblity(phone2TextField, waitTime);
		phone2TextField.sendKeys(shipmentdata[16]);
		log.info("entering Phone to 'Phone 2' textbox");

		CommonFunctions.waitForVisiblity(phone3TextField, waitTime);
		phone3TextField.sendKeys(shipmentdata[17]);
		log.info("entering Phone to 'Phone 3' textbox");

		if (CommonFunctions.waitForVisiblity(saveButton, waitTime)) {
			saveButton.click();
		}
	}

}
