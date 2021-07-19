package platform.pageobjects.AccountServices;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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

}
