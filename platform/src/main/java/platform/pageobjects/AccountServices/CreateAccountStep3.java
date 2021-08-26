package platform.pageobjects.AccountServices;

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

	@FindBy(xpath = "//input[@id='password']")
	public WebElement passwordField;

	@FindBy(xpath = "//input[@id='first-name-kanji']")
	public WebElement firstNameKanjiField;

	@FindBy(xpath = "//input[@id='last-name-kanji']")
	public WebElement lastNameKanjiField;

	@FindBy(xpath = "//input[@id='first-name-kana']")
	public WebElement firstNameKanaField;

	@FindBy(xpath = "//input[@id='last-name-kana']")
	public WebElement lastNameKanaField;

	@FindBy(xpath = "//label[@for='male'] ")
	public WebElement maleRadioButton;

	@FindBy(xpath = "//label[@for='female']")
	public WebElement femaleRadioButton;

	@FindBy(xpath = "//select[@id='birthday.year']")
	public WebElement yearDropdown;

	@FindBy(xpath = "//select[@id='birthday.month']")
	public WebElement monthDropdown;

	@FindBy(xpath = "//select[@id='birthday.day']")
	public WebElement dayDropdown;

	@FindBy(xpath = "//input[@id='code1']")
	public WebElement firstPostalCodeField;

	@FindBy(xpath = "//input[@id='code2']")
	public WebElement secondPostalCodeField;

	@FindBy(xpath = "//label[@for='self']")
	public WebElement selfRadioButton;

	@FindBy(xpath = "//label[@for='protector']")
	public WebElement parentRadioButton;

	@FindBy(xpath = "//label[@for='school']")
	public WebElement schoolRadioButton;

	@FindBy(xpath = "//label[@for='other']")
	public WebElement otherRadioButton;

	@FindBy(xpath = "//label[@for='receive-email']//span[@class='checkmark']")
	public WebElement emailCheckbox;

	@FindBy(xpath = "//label[@for='notice-by-mail']//span[@class='checkmark']")
	public WebElement mailCheckbox;

	@FindBy(xpath = "//button[@class='button button--form js-postcode-fill']")
	public WebElement postalButton;

	@FindBy(xpath = "//select[@id='province']")
	public WebElement addressDropdown;

	@FindBy(xpath = "//input[@id='city']")
	public WebElement cityField;

	@FindBy(xpath = "//input[@id='town']")
	public WebElement townField;

	@FindBy(xpath = "//input[@id='street']")
	public WebElement streetField;

	@FindBy(xpath = "//input[@id='apartment']")
	public WebElement apartmentField;

	@FindBy(xpath = "//input[@id='phone1']")
	public WebElement phone1Field;

	@FindBy(xpath = "//input[@id='phone2']")
	public WebElement phone2Field;

	@FindBy(xpath = "//input[@id='phone3']")
	public WebElement phone3Field;

	@FindBy(xpath = "//button[@id=\"js-btn-submit-basic\"]")
	public WebElement agreeButton;

	public static String password;

	public void enterValidUserDetails() throws InterruptedException {
		password = "pfqa_123";

		if (CommonFunctions.waitForVisiblity(passwordField, waitTime)) {
			passwordField.sendKeys(password);
			log.info("Password :" + password);
		}

		firstNameKanjiField.sendKeys("名前");
		lastNameKanjiField.sendKeys("名字");

		firstNameKanaField.sendKeys("ヤスイ");
		lastNameKanaField.sendKeys("アズマ");

		femaleRadioButton.click();

		Select yearSelect = new Select(yearDropdown);
		yearSelect.selectByValue("2000");

		Select monthSelect = new Select(monthDropdown);
		monthSelect.selectByVisibleText("9");

		Select daySelect = new Select(dayDropdown);
		daySelect.selectByVisibleText("3");

		firstPostalCodeField.sendKeys("530");
		secondPostalCodeField.sendKeys("0045");

		parentRadioButton.click();

		Select adressSelect = new Select(addressDropdown);
		adressSelect.selectByVisibleText("大阪府");

		cityField.sendKeys("大阪市北区");
		townField.sendKeys("天神西町");
		streetField.sendKeys("犬上郡多賀町");
		apartmentField.sendKeys("犬上郡多賀町");

		phone1Field.sendKeys("081");
		phone2Field.sendKeys("1111");
		phone3Field.sendKeys("2222");

	}

	public void clickAgreeButton() {
		agreeButton.click();
	}

}
