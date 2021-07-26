package platform.pageobjects.MyPage;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import platform.pageobjects.Authentication.LoginPage;
import utils.CommonFunctions;

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

	@FindBy(xpath = "//input[@id='holdername']")
	public WebElement creditCardHolderNameTextField;

	@FindBy(xpath = "//input[@id='securitycode']")
	public WebElement securitycodeTextbox;

	@FindBy(xpath = "//span[@id='select2-expire-month-container']")
	public WebElement ExpirationMonthDropdown;

	@FindBy(xpath = "//ul[@id='select2-expire-month-results']")
	public WebElement listAllMonthValue;

	@FindBy(xpath = "//span[@id='select2-expire-year-container']")
	public WebElement ExpirationYearDropdown;

	@FindBy(xpath = "//ul[@id='select2-expire-year-results']']")
	public WebElement listAllYearValue;

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

	public void orderWithInValidCreditcard() throws Exception {

		CommonFunctions.waitForVisiblity(creditCardNumerTextbox, waitTime);
		creditCardNumerTextbox.sendKeys("1111111111111111");
		log.info("Step 2 tab :- provide card no to 'credit card number' textbox");

		CommonFunctions.waitForVisiblity(creditCardHolderNameTextField, waitTime);
		creditCardHolderNameTextField.sendKeys("rahul");
		log.info("Step 2 tab :- provide card holder name to 'card name' textbox");

		CommonFunctions.isElementVisible(ExpirationYearDropdown);

		CommonFunctions.waitForVisiblity(ExpirationYearDropdown, waitTime);
		ExpirationYearDropdown.click();
		log.info("Step 2 tab :- click on 'Expiration year' Dropdown");

		CommonFunctions.isElementVisible(listAllYearValue);

		List<WebElement> Yearlistings = driver.findElements(By.xpath("//ul[@id='select2-expire-year-results']/li"));
		int YearitemSize = Yearlistings.size();
		String expectedYearValue = "2025";
		for (int i = 0; i < YearitemSize; i++) {
			String yearoptionsValue = Yearlistings.get(i).getText();
			System.out.println(yearoptionsValue);
			// match the content here in the if loop
			if (Yearlistings.get(i).getText().equals(expectedYearValue)) {
				// perform action
				Yearlistings.get(i).click();
				break;

			}
		}
		Thread.sleep(2000);
		CommonFunctions.waitForVisiblity(securitycodeTextbox, waitTime);
		CommonFunctions.waitForClickable(securitycodeTextbox, waitTime);

		CommonFunctions.waitForVisiblity(securitycodeTextbox, waitTime);
		securitycodeTextbox.sendKeys("123");
		log.info("Step 2 tab :- provide security code to 'securitycode' textbox");

		CommonFunctions.waitForVisiblity(ExpirationMonthDropdown, waitTime);
		ExpirationMonthDropdown.click();
		log.info("Step 2 tab :- click on 'Expiration Month'Dropdown");

		CommonFunctions.isElementVisible(listAllMonthValue);

		List<WebElement> listings = driver.findElements(By.xpath("//ul[@id='select2-expire-month-results']/li"));
		int itemSize = listings.size();
		String expectedMonthValue = "7月";
		for (int i = 0; i < itemSize; i++) {
			String optionsValue = listings.get(i).getText();
			System.out.println(optionsValue);
			// match the content here in the if loop
			if (listings.get(i).getText().equals(expectedMonthValue)) {
				// perform action
				listings.get(i).click();
				break;
			}
		}

		// step2ProceedButton.click();
		log.info("click to 'save' button");

		CommonFunctions.isElementVisible(invalidCreditCardTextHandler);
		String invalidCreditCardText = invalidCreditCardTextHandler.getText();
		String expectedInvalidCreditCardText = "ご利用いただけないクレジットカードです。";
		CommonFunctions.assertString(invalidCreditCardText, expectedInvalidCreditCardText);
		log.info("The invalid credit card message match with our expected message");

	}

	public void orderWithBlankValidCreditcardDetails() throws Exception {

		String expectedInvalidCreditCardText = "11入力してください";
		CommonFunctions.isElementVisible(blankCardNoTextHandler);
		String blankCardNoTextHandlerString = blankCardNoTextHandler.getText();
		CommonFunctions.assertString(blankCardNoTextHandlerString, expectedInvalidCreditCardText);
		log.info("The card no message match with our expected message");

		CommonFunctions.isElementVisible(blankMonthYearCardTextHandler);
		String blankMonthYearCardTextHandlerString = blankMonthYearCardTextHandler.getText();
		CommonFunctions.assertString(blankMonthYearCardTextHandlerString, expectedInvalidCreditCardText);
		log.info("The month and year message match with our expected message");

		CommonFunctions.isElementVisible(blankCardNameTextHandler);
		String blankCardNameTextHandlerString = blankCardNameTextHandler.getText();
		CommonFunctions.assertString(blankCardNameTextHandlerString, expectedInvalidCreditCardText);
		log.info("The card name message match with our expected message");

		CommonFunctions.isElementVisible(BlankSecurityCodeTextHandler);
		String BlankSecurityCodeTextHandlerString = BlankSecurityCodeTextHandler.getText();
		CommonFunctions.assertString(BlankSecurityCodeTextHandlerString, expectedInvalidCreditCardText);
		log.info("The security code message match with our expected message");

	}

}
