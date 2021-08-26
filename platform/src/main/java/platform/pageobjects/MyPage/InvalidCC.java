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
	public WebElement changeCardButton;

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

	@FindBy(xpath = "//div[@class='order-failed']/div[2]/h2/span")
	public WebElement creditCardRegistrationFailedError;

	@FindBy(xpath = "//a[@id='finalizeButton']")
	public WebElement saveButton;

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
		if (CommonFunctions.waitForVisiblity(changeCardButton, waitTime)) {
			changeCardButton.click();
		}

	}

	public void InValidCreditcard() throws Exception {
		String[] shipmentdata;

		shipmentdata = XLHandler.readexcel("CCPayment", "NewTestData.xlsx");

		CommonFunctions.waitForVisiblity(creditCardTextField, waitTime);
		creditCardTextField.sendKeys(shipmentdata[0]);
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
		log.info("entering security code to 'securitycode' textbox");

		if (CommonFunctions.waitForVisiblity(saveButton, waitTime)) {
			saveButton.click();
		}
		CommonFunctions.waitForVisiblity(creditCardRegistrationFailedError, waitTime);
		String invalidCreditCarderror = creditCardRegistrationFailedError.getText();
		CommonFunctions.assertString(invalidCreditCarderror, shipmentdata[5]);
		log.info("The invalid credit card is failed message match with expected message");

	}

}
