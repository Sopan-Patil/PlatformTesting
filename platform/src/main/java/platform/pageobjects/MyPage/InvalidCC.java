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

public class InvalidCC {

	List<String[]> testdata;
	public WebDriver driver;
	private static Logger log = LogManager.getLogger(LoginPage.class.getName());
	int waitTime = 5;

	public InvalidCC(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@class='link js-not-link']")
	public WebElement accountInformation;

	@FindBy(xpath = "//div[@class='ep-my-page__side-bar']//a[2]")
	public WebElement memberShipStatus;

	@FindBy(xpath = "//a[contains(@class,'button button--default button--xmedium')]")
	public WebElement changeCard;

	@FindBy(xpath = "//input[@id='cardno']")
	public WebElement creditCardTextField;

	@FindBy(xpath = "//select[@id='expire-month']")
	public WebElement ExpiryMonthDropdown;

	@FindBy(xpath = "//select[@id='expire-year']")
	public WebElement ExpiryYearDropdown;

	@FindBy(xpath = "//input[@id='holdername']")
	public WebElement creditCardHolderNameTextField;

	@FindBy(xpath = "//input[@id='securitycode']")
	public WebElement securitycodeTextbox;

	@FindBy(xpath = "//ul[@class='list']")
	public WebElement invalidCreditCardTextHandler;

	@FindBy(xpath = "//span[@id='cardnoleb_id']")
	public WebElement blankCardNoTextHandler;

	@FindBy(xpath = "//span[@id='monthleb_id']")
	public WebElement blankMonthYearCardTextHandler;

	@FindBy(xpath = "//span[@id='cardNameLabel_id']")
	public WebElement blankCardNameTextHandler;

	@FindBy(xpath = "//span[@id='securitycodeLeb_id']")
	public WebElement BlankSecurityCodeTextHandler;

	@FindBy(xpath = "//input[@id='cardno']")
	public WebElement creditCardNumerTextbox;

	public void clickAccountInformation() {
		if (CommonFunctions.waitForVisiblity(accountInformation, waitTime)) {
			accountInformation.click();

		}
	}

	public void ClickMmemberShipStatus() {
		if (CommonFunctions.waitForVisiblity(memberShipStatus, waitTime)) {
			memberShipStatus.click();
		}
	}

	public void clickChangeCardButton() {
		if (CommonFunctions.waitForVisiblity(changeCard, waitTime)) {
			changeCard.click();
		}

	}

	public void InValidCreditcard() throws Exception {
		String[] shipmentdata;

		shipmentdata = XLHandler.readexcel("CCPayment", "NewTestData.xlsx");

		System.out.println(shipmentdata[0]);
		System.out.println(shipmentdata[1]);
		System.out.println(shipmentdata[2]);
		System.out.println(shipmentdata[3]);
		System.out.println(shipmentdata[4]);

		CommonFunctions.waitForVisiblity(creditCardNumerTextbox, waitTime);
		creditCardNumerTextbox.sendKeys(shipmentdata[0]);
		log.info("entering invalid credit card no to 'credit card number' textbox");

		CommonFunctions.isElementVisible(ExpiryMonthDropdown);

		CommonFunctions.waitForVisiblity(ExpiryMonthDropdown, waitTime);

		Select ExpiryMonth = new Select(ExpiryMonthDropdown);
		ExpiryMonth.selectByVisibleText(shipmentdata[1]);
		log.info("clicking on 'Expiration year' Dropdown");

		CommonFunctions.waitForVisiblity(ExpiryYearDropdown, waitTime);
		Select ExpiryYear = new Select(ExpiryYearDropdown);
		ExpiryYear.selectByVisibleText(shipmentdata[2]);
		log.info("clicking on 'Expiration year' Dropdown");

		CommonFunctions.waitForVisiblity(creditCardHolderNameTextField, waitTime);
		creditCardHolderNameTextField.sendKeys(shipmentdata[3]);
		log.info("entering crdit card holder name to 'card name' textbox");

		CommonFunctions.waitForVisiblity(securitycodeTextbox, waitTime);
		CommonFunctions.waitForClickable(securitycodeTextbox, waitTime);

		CommonFunctions.waitForVisiblity(securitycodeTextbox, waitTime);
		securitycodeTextbox.sendKeys(shipmentdata[4]);
		log.info("Step 2 tab :- provide security code to 'securitycode' textbox");

		CommonFunctions.isElementVisible(invalidCreditCardTextHandler);
		String invalidCreditCardText = invalidCreditCardTextHandler.getText();
		String expectedInvalidCreditCardText = "ご利用いただけないクレジットカードです。";
		CommonFunctions.assertString(invalidCreditCardText, expectedInvalidCreditCardText);
		log.info("The invalid credit card message match with our expected message");

	}

}
