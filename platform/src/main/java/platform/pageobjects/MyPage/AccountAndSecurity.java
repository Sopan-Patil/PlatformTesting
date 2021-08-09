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
			AddressApartmentExcel, phone1Excel, phone2Excel, phone3Excel, gender, addprefecture;
	List<String[]> testdata;
	public WebDriver driver;
	private static Logger log = LogManager.getLogger(LoginPage.class.getName());
	int waitTime = 5;
	String[] shipmentdata;

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

	@FindBy(xpath = "//span[@id='given_name-error']")
	public WebElement kanjiSurNameTextFieldError;

	@FindBy(xpath = "//input[@id='given_name']")
	public WebElement kanaNameTextField;

	@FindBy(xpath = "//span[@id='family_name-error']")
	public WebElement kanaNameTextFieldError;

	@FindBy(xpath = "//input[@id='first-name-kana']")
	public WebElement kanaFirstNameTextField;

	@FindBy(xpath = "//span[@id='first-name-kana-error']")
	public WebElement kanaFirstNameTextFieldError;

	@FindBy(xpath = "//input[@id='last-name-kana']")
	public WebElement kanaLastNameTextField;

	@FindBy(xpath = "//span[@id='last-name-kana-error']")
	public WebElement kanaLastNameTextFieldError;

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

	@FindBy(xpath = "//span[@id='zip_code-error']")
	public WebElement postalCode1TextFieldError;

	@FindBy(xpath = "//input[@id='code2']")
	public WebElement postalCode2TextField;

	@FindBy(xpath = "//span[@id='zip_code-error']")
	public WebElement postalCode2TextFieldError;

	@FindBy(xpath = "//label[@for='notice-by-mail']//span[@class='checkmark']")
	public WebElement receiveNotificationsByMailCheckBox;

	@FindBy(xpath = "//select[@id='address_prefecture']")
	public WebElement AddressPrefectureDropdown;

	@FindBy(xpath = "//input[@id='city']")
	public WebElement AddressCityTextField;

	@FindBy(xpath = "//span[@id='city-error']")
	public WebElement AddressCityTextFieldError;

	@FindBy(xpath = "//input[@id='town']")
	public WebElement AddressTownTextField;

	@FindBy(xpath = "//span[@id='town-error']")
	public WebElement AddressTownTextFieldError;

	@FindBy(xpath = "//input[@id='street']")
	public WebElement AddressStreetTextField;

	@FindBy(xpath = "//span[@id='street-error']")
	public WebElement AddressStreetTextFieldError;

	@FindBy(xpath = "//input[@id='apartment']")
	public WebElement AddressApartmentTextField;

	@FindBy(xpath = "//span[@id='apartment-error']")
	public WebElement AddressApartmentTextFieldError;

	@FindBy(xpath = "//input[@id='phone1']")
	public WebElement phone1TextField;

	@FindBy(xpath = "//span[@id='phone_number-error']")
	public WebElement phone1TextFieldError;

	@FindBy(xpath = "//input[@id='phone2']")
	public WebElement phone2TextField;

	@FindBy(xpath = "//span[@id='phone_number-error']")
	public WebElement phone2TextFieldError;

	@FindBy(xpath = "//input[@id='phone3']")
	public WebElement phone3TextField;

	@FindBy(xpath = "//span[@id='phone_number-error']")
	public WebElement phone3TextFieldError;

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

	@FindBy(xpath = "//div[@class='account-security']/ul/li[6]/p[2]")
	public WebElement updatedGender;

	@FindBy(xpath = "//div[@class='account-security']/ul/li[7]/p[2]")
	public WebElement updatedDOB;

	@FindBy(xpath = "//div[@class='account-security']/ul/li[8]/p[2]")
	public WebElement updatedPostalCode;

	@FindBy(xpath = "//div[@class='account-security']/ul/li[11]/p[2]")
	public WebElement updatedAddress;

	@FindBy(xpath = "//div[@class='account-security']/ul/li[12]/p[2]")
	public WebElement updatedPhone;

	@FindBy(xpath = "//a[@class='button button--gray button--xxmedium ep-order__btn ep-order__btn--back']")
	public WebElement cancelButton;

	@FindBy(xpath = "//form[@id='formEditProfile']/div/div/p[1]")
	public WebElement kanjiFirstLastErrorMissingUI;

	@FindBy(xpath = "//form[@id='formEditProfile']/div/div/p[2]")
	public WebElement kanjiFullNameErrorMissingUI;

	@FindBy(xpath = "//form[@id='formEditProfile']/div/div/p[3]")
	public WebElement kanaNameErrorMissingUI;

	@FindBy(xpath = "//form[@id='formEditProfile']/div/div/p[4]")
	public WebElement kanaMeiNameErrorMissingUI;

	@FindBy(xpath = "//form[@id='formEditProfile']/div/div/p[5]")
	public WebElement zipCodeErrorMissingUI;

	@FindBy(xpath = "//form[@id='formEditProfile']/div/div/p[6]")
	public WebElement addCityErrorMissingUI;

	@FindBy(xpath = "//form[@id='formEditProfile']/div/div/p[7]")
	public WebElement addressTownErrorMissingUI;

	@FindBy(xpath = "//form[@id='formEditProfile']/div/div/p[8]")
	public WebElement addressStreetErrorMissingUI;

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
		gender = radioBtn1.getText();

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

	public void UpdateAccountAndSecurityInavlidInformation() throws Exception {

		shipmentdata = XLHandler.readexcel("UpdateAccountInformation", "NewTestData.xlsx");

		CommonFunctions.isElementVisible(kanjiSurNameTextField);

		CommonFunctions.waitForVisiblity(kanjiSurNameTextField, waitTime);
		kanjiSurNameTextField.clear();
		kanjiSurNameTextField.sendKeys(shipmentdata[13]);
		log.info("entering Invalid Kanji Sur Name to 'kanji Sur Name' textbox");

		CommonFunctions.waitForVisiblity(kanaNameTextField, waitTime);
		kanaNameTextField.clear();
		kanaNameTextField.sendKeys(shipmentdata[14]);
		log.info("entering Invalid Kanji Name to 'kanji  Name' textbox");

		CommonFunctions.waitForVisiblity(kanaFirstNameTextField, waitTime);
		kanaFirstNameTextField.clear();
		kanaFirstNameTextField.sendKeys(shipmentdata[15]);
		kanaFirstNameExcel = shipmentdata[2].toString();
		log.info("entering Invalid Kanji First Name to 'kanji First Name' textbox");

		CommonFunctions.waitForVisiblity(kanaLastNameTextField, waitTime);
		kanaLastNameTextField.clear();
		kanaLastNameTextField.sendKeys(shipmentdata[16]);
		log.info("entering Invalid Kanji Last Name to 'kanji Last Name' textbox");
		CommonFunctions.waitForVisiblity(postalCode1TextField, waitTime);
		postalCode1TextField.clear();
		postalCode1TextField.sendKeys(shipmentdata[17]);
		log.info("entering Invalid Postal Code to 'Postal Code 1' textbox");

		CommonFunctions.waitForVisiblity(postalCode2TextField, waitTime);
		postalCode2TextField.clear();
		postalCode2TextField.sendKeys(shipmentdata[18]);
		log.info("entering Invalid Postal Code to 'Postal Code 2' textbox");
		if (driver.findElement(By.xpath("//select[@id='address_prefecture']")).isDisplayed()) {
		} else {
			receiveNotificationsByMailCheckBox.click();
		}
		ReceiveNotificationsByMailInfoInavlidData();

	}

	public void ReceiveNotificationsByMailInfo() throws Exception {

		shipmentdata = XLHandler.readexcel("UpdateAccountInformation", "NewTestData.xlsx");

		Select AddDropdown = new Select(AddressPrefectureDropdown);
		AddDropdown.selectByIndex(0);
		addprefecture = AddDropdown.getFirstSelectedOption().getText();
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

	public void ReceiveNotificationsByMailInfoInavlidData() throws Exception {

		shipmentdata = XLHandler.readexcel("UpdateAccountInformation", "NewTestData.xlsx");

		CommonFunctions.waitForVisiblity(AddressCityTextField, waitTime);
		AddressCityTextField.clear();
		AddressCityTextField.sendKeys(shipmentdata[19]);
		log.info("entering Invalid Address City to 'Address City' textbox");

		CommonFunctions.scrolltoElement(phone1TextField);
		CommonFunctions.waitForVisiblity(AddressTownTextField, waitTime);
		AddressTownTextField.clear();
		AddressTownTextField.sendKeys(shipmentdata[20]);
		log.info("entering Invalid Address Town to 'Address Town' textbox");

		CommonFunctions.waitForVisiblity(AddressStreetTextField, waitTime);
		AddressStreetTextField.clear();
		AddressStreetTextField.sendKeys(shipmentdata[21]);
		log.info("entering Invalid Address Street to 'Address Street' textbox");

		CommonFunctions.waitForVisiblity(AddressApartmentTextField, waitTime);
		AddressApartmentTextField.clear();
		AddressApartmentTextField.sendKeys(shipmentdata[22]);
		log.info("entering Invalid Address Apartment to 'Address Apartment' textbox");

		CommonFunctions.waitForVisiblity(phone1TextField, waitTime);
		phone1TextField.clear();
		phone1TextField.sendKeys(shipmentdata[23]);
		log.info("entering Invalid Phone to 'Phone 1' textbox");

		CommonFunctions.waitForVisiblity(phone2TextField, waitTime);
		phone2TextField.clear();
		phone2TextField.sendKeys(shipmentdata[24]);
		log.info("entering Invalid Phone to 'Phone 2' textbox");

		CommonFunctions.waitForVisiblity(phone3TextField, waitTime);
		phone3TextField.clear();
		phone3TextField.sendKeys(shipmentdata[25]);
		log.info("entering Invalid Phone to 'Phone 3' textbox");
		Validate_Updated_Invalid_Account_Information();
	}

	public void Validate_Updated_Account_Information() throws Exception {

		shipmentdata = XLHandler.readexcel("UpdateAccountInformation", "NewTestData.xlsx");
		Assert.assertEquals(updatedNameKanji.getText(), kanjiSurNameExcel + " " + kanaNameExcel);
		Assert.assertEquals(updatedNameKana.getText(), kanaFirstNameExcel + " " + kanaLastNameExcel);
		String[] birthYear1 = birthYear.split("\\s+");
		String birthYearactual = birthYear1[0];
		Assert.assertEquals(updatedDOB.getText(), birthYearactual + "年" + birthMonth + "月" + birthDate + "日");
		Assert.assertEquals(updatedPostalCode.getText(), postalCode1Excel + postalCode2Excel);
		Assert.assertEquals(updatedAddress.getText(), addprefecture + " " + AddressCityExcel + " " + AddressTownExcel
				+ " " + AddressStreetExcel + " " + AddressApartmentExcel);
		Assert.assertEquals(updatedPhone.getText(), phone1Excel + "-" + phone2Excel + "-" + phone3Excel);
	}

	public void Validate_Updated_Invalid_Account_Information() throws Exception {

		shipmentdata = XLHandler.readexcel("UpdateAccountInformation", "NewTestData.xlsx");

		String kanaNameTextFieldExcelError = shipmentdata[26].toString();
		Assert.assertEquals(kanaNameTextFieldExcelError, kanaNameTextFieldError.getText());

		String kanjiSurNameTextFieldExcelError = shipmentdata[27].toString();
		Assert.assertEquals(kanjiSurNameTextFieldExcelError, kanjiSurNameTextFieldError.getText());

		String kanaFirstNameTextFieldExcelError = shipmentdata[28].toString();
		Assert.assertEquals(kanaFirstNameTextFieldExcelError, kanaFirstNameTextFieldError.getText());

		String kanaLastNameTextFieldExcelError = shipmentdata[29].toString();
		Assert.assertEquals(kanaLastNameTextFieldExcelError, kanaLastNameTextFieldError.getText());

		String postalCode1TextFieldExcelError = shipmentdata[30].toString();
		Assert.assertEquals(postalCode1TextFieldExcelError, postalCode1TextFieldError.getText());

		String postalCode2TextFieldExcelError = shipmentdata[30].toString();
		Assert.assertEquals(postalCode2TextFieldExcelError, postalCode2TextFieldError.getText());

		String AddressCityTextFieldExcekError = shipmentdata[32].toString();
		Assert.assertEquals(AddressCityTextFieldExcekError, AddressCityTextFieldError.getText());

		String AddressTownTextFieldExcelError = shipmentdata[33].toString();
		Assert.assertEquals(AddressTownTextFieldExcelError, AddressTownTextFieldError.getText());

		String AddressStreetTextFieldExcelError = shipmentdata[34].toString();
		Assert.assertEquals(AddressStreetTextFieldExcelError, AddressStreetTextFieldError.getText());

		String AddressApartmentTextFieldExcelError = shipmentdata[35].toString();
		String AddressApartmentTextFieldUI = AddressApartmentTextFieldError.getText();
		Assert.assertEquals(AddressApartmentTextFieldExcelError, AddressApartmentTextFieldUI);

		String phone1TextFieldExcelError = shipmentdata[36].toString();
		Assert.assertEquals(phone1TextFieldExcelError, phone1TextFieldError.getText());

	}

	public void Cancel_Button() throws Exception {
		CommonFunctions.waitForVisiblity(cancelButton, waitTime);
		UpdateAccountAndSecurityInavlidInformation();

		cancelButton.click();
		Validate_Updated_Account_Information();
	}

	public void MissngValuesAccountAndSecurityInformation() throws Exception {
		CommonFunctions.isElementVisible(kanjiSurNameTextField);
		CommonFunctions.waitForVisiblity(kanjiSurNameTextField, waitTime);
		kanjiSurNameTextField.clear();

		CommonFunctions.waitForVisiblity(kanaNameTextField, waitTime);
		kanaNameTextField.clear();

		CommonFunctions.waitForVisiblity(kanaFirstNameTextField, waitTime);
		kanaFirstNameTextField.clear();

		CommonFunctions.waitForVisiblity(kanaLastNameTextField, waitTime);
		kanaLastNameTextField.clear();

		CommonFunctions.scrolltoElement(postalCode1TextField);
		WebElement radioBtn1 = genderOption;
		((JavascriptExecutor) ObjectHelper.driver).executeScript("arguments[0].checked = true;", radioBtn1);
		gender = radioBtn1.getText();

		CommonFunctions.waitForVisiblity(postalCode1TextField, waitTime);
		postalCode1TextField.clear();

		CommonFunctions.waitForVisiblity(postalCode2TextField, waitTime);
		postalCode2TextField.clear();
		if (driver.findElement(By.xpath("//select[@id='address_prefecture']")).isDisplayed()) {
		} else {
			receiveNotificationsByMailCheckBox.click();
		}
		Select AddDropdown = new Select(AddressPrefectureDropdown);
		AddDropdown.selectByIndex(0);
		addprefecture = AddDropdown.getFirstSelectedOption().getText();

		CommonFunctions.waitForVisiblity(AddressCityTextField, waitTime);
		AddressCityTextField.clear();

		CommonFunctions.scrolltoElement(phone1TextField);
		CommonFunctions.waitForVisiblity(AddressTownTextField, waitTime);
		AddressTownTextField.clear();

		CommonFunctions.waitForVisiblity(AddressStreetTextField, waitTime);
		AddressStreetTextField.clear();

		CommonFunctions.waitForVisiblity(AddressApartmentTextField, waitTime);
		AddressApartmentTextField.clear();

		CommonFunctions.waitForVisiblity(phone1TextField, waitTime);
		phone1TextField.clear();

		CommonFunctions.waitForVisiblity(phone2TextField, waitTime);
		phone2TextField.clear();

		CommonFunctions.waitForVisiblity(phone3TextField, waitTime);
		phone3TextField.clear();
		if (CommonFunctions.waitForVisiblity(saveButton, waitTime)) {
			saveButton.click();
		}

		JavascriptExecutor jse = (JavascriptExecutor) driver;

		jse.executeScript("scroll(0, -250);");
		shipmentdata = XLHandler.readexcel("UpdateAccountInformation", "NewTestData.xlsx");

		String kanjiFirstLastExcelErrorMissing = shipmentdata[37].toString();
		Assert.assertEquals(kanjiFirstLastExcelErrorMissing, kanaNameTextFieldError.getText());

		String kanjiFullNameExcelErrorMissing = shipmentdata[38].toString();
		Assert.assertEquals(kanjiFullNameExcelErrorMissing, kanjiFullNameErrorMissingUI.getText());

		String kanaNameExcelErrorMissing = shipmentdata[39].toString();
		Assert.assertEquals(kanaNameExcelErrorMissing, kanaNameErrorMissingUI.getText());

		String kanaMeiNameExcelErrorMissing = shipmentdata[40].toString();
		Assert.assertEquals(kanaMeiNameExcelErrorMissing, kanaMeiNameErrorMissingUI.getText());

		String zipCodeExcelErrorMissing = shipmentdata[41].toString();
		Assert.assertEquals(zipCodeExcelErrorMissing, zipCodeErrorMissingUI.getText());

		String addCityExcelErrorMissing = shipmentdata[42].toString();
		Assert.assertEquals(addCityExcelErrorMissing, addCityErrorMissingUI.getText());

		String addressTownExcelErrorMissing = shipmentdata[43].toString();
		Assert.assertEquals(addressTownExcelErrorMissing, addressTownErrorMissingUI.getText());

		String addressStreetExcelErrorMissing1 = shipmentdata[44].toString();
		Assert.assertEquals(addressStreetExcelErrorMissing1, addressStreetErrorMissingUI.getText());
	}
}
