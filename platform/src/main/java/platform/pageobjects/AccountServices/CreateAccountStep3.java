package platform.pageobjects.AccountServices;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import platform.pageobjects.Authentication.LoginPage;

/**
 * @Author : Chetan Sonparote
 * @Date : 19 Jul 2021
 * @Description:Class for entering user details in step 3
 */
public class CreateAccountStep3 {

	List<String[]> testdata;
	public WebDriver driver;
	private static Logger log = LogManager.getLogger(LoginPage.class.getName());
	int waitTime = 5;

	public CreateAccountStep3(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// input[@id='password']
	// input[@id='password']
	@FindBy(xpath = "//input[@id='password']")
	public WebElement passwordField;

	// input[@id='first-name-kanji']

	@FindBy(xpath = "//input[@id='first-name-kanji']")
	public WebElement firstNameKanjiField;

	// input[@id='last-name-kanji']

	@FindBy(xpath = "//input[@id='last-name-kanji']")
	public WebElement lastNameKanjiField;

	// input[@id='first-name-kana']

	@FindBy(xpath = "//input[@id='first-name-kana']")
	public WebElement firstNameKanaField;

	// input[@id='last-name-kana']

	@FindBy(xpath = "//input[@id='last-name-kana']")
	public WebElement lastNameKanaField;

	// label[@for='male']
	// label[contains(text(),'男性')]
	@FindBy(xpath = "//label[@for='male' or contains(text(),'男性')]")
	public WebElement maleRadioButton;
	// label[@for='female']
	// label[contains(text(),'女性')]
	@FindBy(xpath = "//label[@for='female' or contains(text(),'女性')]")
	public WebElement femaleRadioButton;

	// span[@id='select2-birthdayyear-container']//font//font[contains(text(),'2006
	// (Heisei 18)')]

	// span[@id='select2-birthdayyear-container']
	@FindBy(xpath = "//span[@id='select2-birthdayyear-container']")
	public WebElement yearDropdown;

	// span[@id='select2-birthdaymonth-container']//font//font[contains(text(),'-')]

	@FindBy(xpath = "//span[@id='select2-birthdaymonth-container']")
	public WebElement monthDropdown;

	@FindBy(xpath = "//span[@id='select2-birthdayday-container']")
	public WebElement dayDropdown;

	// input[@id='code1']
	@FindBy(xpath = "//input[@id='code1']")
	public WebElement firstPostalCodeField;

	@FindBy(xpath = "//input[@id='code2']")
	public WebElement secondPostalCodeField;

	// label[@for='self']
	// label[contains(text(),'本人')]
	@FindBy(xpath = "//label[@for='self' or contains(text(),'本人')]")
	public WebElement selfRadioButton;

	// label[contains(text(),'保護者')]
	// label[@for='protector']
	@FindBy(xpath = "//label[@for='protector' or contains(text(),'保護者')]")
	public WebElement parentRadioButton;

	// label[@for='school']
	// label[contains(text(),'学校・塾関係者')]
	@FindBy(xpath = "//label[@for='school' or contains(text(),'学校・塾関係者')]")
	public WebElement schoolRadioButton;

	// label[contains(text(),'その他')]
	// label[@for='other']
	@FindBy(xpath = "//label[@for='other' or contains(text(),'その他')]")
	public WebElement otherRadioButton;

	// label[@for='receive-email']//span[@class='checkmark']
	// label[@for='receive-email']//span[@class='checkmark']

	@FindBy(xpath = "//label[@for='receive-email']//span[@class='checkmark']")
	public WebElement emailCheckbox;

	// label[@for='notice-by-mail']//span[@class='checkmark']
	@FindBy(xpath = "//label[@for='notice-by-mail']//span[@class='checkmark']")
	public WebElement mailCheckbox;

	// font[contains(text(),'Get address from zip code')]
	// span[contains(text(),'郵便番号から住所取得')]
	@FindBy(xpath = "//*[contains(text(),'Get address from zip code') or contains(text(),'郵便番号から住所取得')")
	public WebElement postalButton;

	// span[@id='select2-province-container']
	@FindBy(xpath = "//span[@id='select2-province-container']")
	public WebElement addressDropdown;

	// input[@id='city']
	@FindBy(xpath = "//input[@id='city']")
	public WebElement cityField;

	// input[@id='town']
	// input[@id='town']
	@FindBy(xpath = "//input[@id='town']")
	public WebElement townField;

	// input[@id='street']
	@FindBy(xpath = "//input[@id='street']")
	public WebElement streetField;

	// input[@id='apartment']
	@FindBy(xpath = "//input[@id='apartment']")
	public WebElement apartmentField;

	// input[@id='phone1']
	@FindBy(xpath = "//input[@id='phone1']")
	public WebElement phone1Field;

	// input[@id='phone2']
	@FindBy(xpath = "//input[@id='phone2']")
	public WebElement phone2Field;

	// input[@id='phone3']
	@FindBy(xpath = "//input[@id='phone3']")
	public WebElement phone3Field;

	// font[contains(text(),'Agree to the terms below and go to the confirmatio')]
	// span[contains(text(),'下の規約に同意して、確認画面へ')]
	@FindBy(xpath = "//*[contains(text(),'Agree to the terms below and go to the confirmatio') or contains(text(),'下の規約に同意して、確認画面へ')]")
	public WebElement agreeButton;

	public void enterValidUserDetails() {
		passwordField.sendKeys("pfqa_123");

		firstNameKanjiField.sendKeys("名前");
		lastNameKanjiField.sendKeys("名字");

		firstNameKanaField.sendKeys("ヤスイ");
		lastNameKanaField.sendKeys("アズマ");

		femaleRadioButton.click();

		// Select yearSelect = new Select(yearDropdown);
		// yearSelect.selectByIndex(10);
		// selectValueFromUnorderedList(yearDropdown, "2000");
		// yearDropdown.
		int year = 2000;
		WebElement yearDropDownTest = driver
				.findElement(By.xpath("//span[@id='select2-birthdayyear-container']//font//font[contains(text(),'"
						+ year + " (Heisei 18)')]"));
		yearDropDownTest.click();
		// Select monthSelect = new Select(monthDropdown);
		// monthSelect.selectByVisibleText("1");
		// selectValueFromUnorderedList(monthDropdown, "1");

		// Select daySelect = new Select(dayDropdown);
		// daySelect.selectByVisibleText("1");
		// selectValueFromUnorderedList(dayDropdown, "1");

		firstPostalCodeField.sendKeys("530");
		secondPostalCodeField.sendKeys("0045");

		parentRadioButton.click();

		// Select adressSelect = new Select(addressDropdown);
		// adressSelect.selectByVisibleText("Osaka");
		// selectValueFromUnorderedList(addressDropdown, "Osaka");

		cityField.sendKeys("大阪市北区");
		townField.sendKeys("天神西町");
		streetField.sendKeys("犬上郡多賀町");
		apartmentField.sendKeys("犬上郡多賀町");

		phone1Field.sendKeys("081");
		phone2Field.sendKeys("1111");
		phone3Field.sendKeys("2222");

	}

	// WebElement ul = driver.findElement(By.className("chzn-results"));
	// selectValueFromUnorderedList(ul, "Game");
	/**
	 * @Author : Chetan Sonparote
	 * @Date : 20 Jul 2021
	 * @Description:method for selecting elemnet from dropdown
	 */
	public void selectValueFromUnorderedList(WebElement unorderedList, final String value) {
		List<WebElement> options = unorderedList.findElements(By.tagName("li"));

		for (WebElement option : options) {
			// if (value.contains(option.getText())) {
			if (option.getText().contains(value)) {
				option.click();
				break;
			}
		}
	}
}
