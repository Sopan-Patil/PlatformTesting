package platform.pageobjects.MyPage;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import platform.pageobjects.Authentication.LoginPage;
import utils.CommonFunctions;
import utils.ObjectHelper;
import utils.XLHandler;

/**
 * @Author : Sopan Patil
 * @Date : 22 Jul 2021
 * @Description:Class for entering invalid credit card details
 */

public class AccountAndSecurity {
	static String kanjiSurNameExcel, kanaNameExcel, kanaFirstNameExcel, kanaLastNameExcel, birthYear, birthMonth,
			birthDate, postalCode1Excel, postalCode2Excel, AddressCityExcel, AddressTownExcel, AddressStreetExcel,
			AddressApartmentExcel, phone1Excel, phone2Excel, phone3Excel;
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

	@FindBy(xpath = "//select[@id='birthdate.birthdate_year']")
	public WebElement birthYearDropdown;

	@FindBy(xpath = "//select[@id='birthdate.birthdate_month']")
	public WebElement birthMonthDropdown;

	@FindBy(xpath = "//select[@id='birthdate.birthdate_day']")
	public WebElement birthDateDropdown;

	@FindBy(xpath = "//input[@id='code1']")
	public WebElement postalCode1TextField;

	@FindBy(xpath = "//input[@id='code2']")
	public WebElement postalCode2TextField;

	@FindBy(xpath = "//label[@for='notice-by-mail']//span[@class='checkmark']")
	public WebElement receiveNotificationsByMailCheckBox;

	@FindBy(xpath = "//select[@id='address_prefecture']")
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

	@FindBy(xpath = "//a[@class='button button--default button--uplarge']")
	public WebElement closeButton;

	@FindBy(xpath = "//div[@class='js-mail-form d-none']")
	public WebElement check;

	@FindBy(xpath = "//div[@class='js-mail-form d-none']")
	public WebElement check1;

	@FindBy(xpath = "// div[@class='account-security']/ul/li[4]/p[2]")
	public WebElement updatedNameKanji;

	@FindBy(xpath = "//div[@class='account-security']/ul/li[5]/p[2]")
	public WebElement updatedNameKana;

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
		kanjiSurNameTextField.clear();
		kanjiSurNameTextField.sendKeys(shipmentdata[0]);
		kanjiSurNameExcel = shipmentdata[0].toString();
		log.info("entering Kanji Sur Name to 'kanji Sur Name' textbox");

		CommonFunctions.waitForVisiblity(kanaNameTextField, waitTime);
		kanaNameTextField.clear();
		kanaNameTextField.sendKeys(shipmentdata[1]);
		kanaNameExcel = shipmentdata[1].toString();
		log.info("entering Kanji Name to 'kanji  Name' textbox");

		CommonFunctions.waitForVisiblity(kanaFirstNameTextField, waitTime);
		kanaFirstNameTextField.clear();
		kanaFirstNameTextField.sendKeys(shipmentdata[2]);
		kanaFirstNameExcel = shipmentdata[2].toString();
		log.info("entering Kanji First Name to 'kanji First Name' textbox");

		CommonFunctions.waitForVisiblity(kanaLastNameTextField, waitTime);
		kanaLastNameTextField.clear();
		kanaLastNameTextField.sendKeys(shipmentdata[3]);
		kanaLastNameExcel = shipmentdata[3].toString();
		log.info("entering Kanji Last Name to 'kanji Last Name' textbox");

		CommonFunctions.scrolltoElement(postalCode1TextField);
		WebElement radioBtn1 = genderOption;
		((JavascriptExecutor) ObjectHelper.driver).executeScript("arguments[0].checked = true;", radioBtn1);
		// genderOption.click();

		Select BirthYear = new Select(birthYearDropdown);
		BirthYear.selectByIndex(2);
		birthYear = BirthYear.getFirstSelectedOption().getText();
		log.info("selecting 'Birth year ' Dropdown");

		Select BirthMonth = new Select(birthMonthDropdown);
		BirthMonth.selectByIndex(2);
		birthMonth = BirthMonth.getFirstSelectedOption().getText();
		log.info("selecting 'Birth month ' Dropdown");

		Select BirthDate = new Select(birthDateDropdown);
		BirthDate.selectByIndex(2);
		birthDate = BirthDate.getFirstSelectedOption().getText();
		log.info("selecting 'Birth date ' Dropdown");

		CommonFunctions.waitForVisiblity(postalCode1TextField, waitTime);
		postalCode1TextField.clear();
		postalCode1TextField.sendKeys(shipmentdata[4]);
		postalCode1Excel = shipmentdata[4].toString();
		log.info("entering Postal Code to 'Postal Code 1' textbox");

		CommonFunctions.waitForVisiblity(postalCode2TextField, waitTime);
		postalCode2TextField.clear();
		postalCode2TextField.sendKeys(shipmentdata[5]);
		postalCode2Excel = shipmentdata[5].toString();
		log.info("entering Postal Code to 'Postal Code 2' textbox");
		if (driver.findElement(By.xpath("//select[@id='address_prefecture']")).isDisplayed()) {
			System.out.println("Selected");
		} else {
			receiveNotificationsByMailCheckBox.click();
		}

		ReceiveNotificationsByMailInfo();

		if (CommonFunctions.waitForVisiblity(saveButton, waitTime)) {
			saveButton.click();
		}
		if (CommonFunctions.waitForVisiblity(closeButton, waitTime)) {
			closeButton.click();
		}
	}

	public void ReceiveNotificationsByMailInfo() throws Exception {
		String[] shipmentdata;

		shipmentdata = XLHandler.readexcel("UpdateAccountInformation", "NewTestData.xlsx");

		Select AddDropdown = new Select(AddressPrefectureDropdown);
		AddDropdown.selectByIndex(2);
		log.info("selecting 'Address prefecture' Dropdown");

		CommonFunctions.waitForVisiblity(AddressCityTextField, waitTime);
		AddressCityTextField.clear();
		AddressCityTextField.sendKeys(shipmentdata[6]);
		AddressCityExcel = shipmentdata[6].toString();
		log.info("entering Address City to 'Address City' textbox");

		CommonFunctions.scrolltoElement(phone1TextField);
		CommonFunctions.waitForVisiblity(AddressTownTextField, waitTime);
		AddressTownTextField.clear();
		AddressTownTextField.sendKeys(shipmentdata[7]);
		AddressTownExcel = shipmentdata[7].toString();
		log.info("entering Address Town to 'Address Town' textbox");

		CommonFunctions.waitForVisiblity(AddressStreetTextField, waitTime);
		AddressStreetTextField.clear();
		AddressStreetTextField.sendKeys(shipmentdata[8]);
		AddressStreetExcel = shipmentdata[8].toString();
		log.info("entering Address Street to 'Address Street' textbox");

		CommonFunctions.waitForVisiblity(AddressApartmentTextField, waitTime);
		AddressApartmentTextField.clear();
		AddressApartmentTextField.sendKeys(shipmentdata[9]);
		AddressApartmentExcel = shipmentdata[9].toString();
		log.info("entering Address Apartment to 'Address Apartment' textbox");

		CommonFunctions.waitForVisiblity(phone1TextField, waitTime);
		phone1TextField.clear();
		phone1TextField.sendKeys(shipmentdata[10]);
		phone1Excel = shipmentdata[10].toString();
		log.info("entering Phone to 'Phone 1' textbox");

		CommonFunctions.waitForVisiblity(phone2TextField, waitTime);
		phone2TextField.clear();
		phone2TextField.sendKeys(shipmentdata[11]);
		phone2Excel = shipmentdata[11].toString();
		log.info("entering Phone to 'Phone 2' textbox");

		CommonFunctions.waitForVisiblity(phone3TextField, waitTime);
		phone3TextField.clear();
		phone3TextField.sendKeys(shipmentdata[12]);
		phone3Excel = shipmentdata[12].toString();
		log.info("entering Phone to 'Phone 3' textbox");
	}

	public void Validate_Updated_Account_Information() throws Exception {
		String[] shipmentdata;
		shipmentdata = XLHandler.readexcel("UpdateAccountInformation", "NewTestData.xlsx");

		Assert.assertEquals(updatedNameKanji.getText(), kanjiSurNameExcel + " " + kanaNameExcel);
		Assert.assertEquals(updatedNameKana.getText(), kanaFirstNameExcel + " " + kanaLastNameExcel);

	}
}
