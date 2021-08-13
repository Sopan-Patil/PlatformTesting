package platform.pageobjects.Order;

import java.util.List;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.NewBaseClass;
import platform.pageobjects.Authentication.LoginPage;
import utils.CommonFunctions;

/**
 * @Author : Rahul Shinde
 * @Date : 12 Jul 2021
 * @Description: test order flow
 */

public class Order {
	List<String[]> testdata;
	public WebDriver driver;
	private static Logger log = LogManager.getLogger(Order.class.getName());
	int waitTime = 1;

	public Order(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@href='/product-list']")
	public WebElement productListLink;

	@FindBy(xpath = "//body[1]/div[1]/div[3]/div[1]/div[1]/div[4]/form[1]/button[1]/span[1]")
	public WebElement selectCasec1ProductFromProductList;

	@FindBy(xpath = "/html/body/div/div[3]/div[2]/div[2]/div[4]/form/button")
	public WebElement selectKanjiProductFromProductList;

	// @FindBy(xpath = "//button[@type='submit'] //span[@class='button__text']")
	@FindBy(xpath = "//button[@role='button']")
	public WebElement step1ProceedButton;

	@FindBy(xpath = "//input[@id='email']")
	public WebElement emailtextfield;

	@FindBy(xpath = "//*[@id=\"finalizeButton\"]/span/span")
	public WebElement step2ProceedButton;

	@FindBy(xpath = "//a[@id='finalizeButton']//span")
	public WebElement step3ConfirmOrderButton;

	@FindBy(xpath = "//div[@class='box-head']//h3")
	public WebElement step4ThankYouForYourPurchaseLabel;

	@FindBy(xpath = "//label[@for='register']")
	public WebElement registerYouCreditCardRadioButton;

	@FindBy(xpath = "//input[@id='cardno']")
	public WebElement creditCardNumerTextbox;

	@FindBy(xpath = "//input[@id='holdername']")
	public WebElement creditCardHolderNameTextbox;

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

	// xpaths for convenience Store
	@FindBy(xpath = "//label[@for='atm-payment']")
	public WebElement convenienceStorePaymentRadioButton;

	@FindBy(xpath = "//div[@id='convenience']//div[1]")
	public WebElement lawsonRadioButton;

	@FindBy(xpath = "//div[@id='convenience']//div[2]")
	public WebElement familyMartRadioButton;

	@FindBy(xpath = "//div[@id='convenience']//div[3]")
	public WebElement ministopRadioButton;

	@FindBy(xpath = "//div[@id='convenience']//div[4]")
	public WebElement seikoMartRadioButton;

	@FindBy(xpath = "//input[@id='userName']")
	public WebElement kanjiNameTextbox;

	@FindBy(xpath = "//input[@id='userFurigana']")
	public WebElement kanaNameTextbox;

	@FindBy(xpath = "//input[@id='userPhone']")
	public WebElement phonenoTextbox;

	@FindBy(xpath = "//input[@id='userEmail']")
	public WebElement emailaddressTextbox;

	// con store thank you page xpath

	@FindBy(xpath = "//div[@class='box-store-payment__content']//div[1]//div[2]")
	public WebElement customerNumberLabel;

	@FindBy(xpath = "//div[@class='box-store-payment__content']//div[2]//div[2]")
	public WebElement convenienceStoreLabel;

	@FindBy(xpath = "//div[@class='box-store-payment__content']//div[3]//div[2]")
	public WebElement authorizationNumberLabel;

	@FindBy(xpath = "//div[@class='box-store-payment__content']//div[4]//div[2]")
	public WebElement paymentDeadlineLabel;

	@FindBy(xpath = "//div[@class='box-body__item']//strong")
	public WebElement orderNumberLabel;

	@FindBy(xpath = "//a[@href='/order-history']//span[2]")
	public WebElement checkOrderHistoryLink;

	@FindBy(xpath = "//span[@class='button__text']")
	public WebElement topPageButton;

	// order history page xpath

	@FindBy(xpath = "//div[@class='box-order-history']//div[1]//div[2]//div[2]//div[2]//div[2]//div[1]")
	public WebElement orderHistoryPaymentDeadlineLabel;

	@FindBy(xpath = "//div[@class='box-order-history']//div[1]//div[2]//div[2]//div[3]//a[1]//span[1]")
	public WebElement orderHistoryBuyAgainButton;

	@FindBy(xpath = "//div[@class='box-order-history']/div[1]/div[1]//div[2]//p")
	public WebElement orderHistoryOrderNumberLabel;

	@FindBy(xpath = "//div[@class='box-order-history']//div[1]//div[2]//div[2]//div[2]//div[2]//button[1]//span[1]")
	public WebElement orderHistoryPaymentStatusLabel;

	@FindBy(xpath = "//div[@class='box-order-history']//div[1]//h4[1]")
	public WebElement orderHistoryProductNameLabel;

	@FindBy(xpath = "//div[@class='box-order-history']//div[1]//div[2]//div[1]//div[2]//div[1]//p[2]")
	public WebElement orderHistoryPriceLabel;

	@FindBy(xpath = "//div[@class='box-order-history']/div[1]/div[1]//div[1]")
	public WebElement orderHistoryOrderDateLabel;

	// credit card thank you page

	@FindBy(xpath = "//div[@class='box-head']//h3")
	public WebElement thankYouForYourApplicationCreditCardLabel;

	@FindBy(xpath = "//div[@class='box-body__item mb-3']//strong//span")
	public WebElement orderNumberCreditCardLabel;

	@FindBy(xpath = "//a[@class='button button--default button--uplarge']//span")
	public WebElement StartNowButton;

	@FindBy(xpath = "//a[@href='https://support.evidus.com/']")
	public WebElement FAQLink;

	@FindBy(xpath = "//div[@class='logo']")
	public WebElement FAQPageLogo;

	@FindBy(xpath = "//a[@href='/term']")
	public WebElement termsOfUseLink;

	@FindBy(xpath = "//div[@class='header']//h1")
	public WebElement STAGIATermsofServiceLabel;

	@FindBy(xpath = "//a[@href='https://www.jiem.co.jp/privacy/']")
	public WebElement privacyPolicyLink;

	@FindBy(xpath = "//h2[@class='firstChild']//img[@alt='privacy policy']")
	public WebElement privacyPolicyLinkPageLabel;

	@FindBy(xpath = "//a[@href='/transaction-method']")
	public WebElement commercialTransactionsLawLink;

	@FindBy(xpath = "//div[@class='header']//h1")
	public WebElement commercialTransactionsPageLabel;

	@FindBy(xpath = "//p[@class='copy-right']")
	public WebElement copyRightLabel;

	// service you are using
	@FindBy(xpath = "//div[@class='ep-my-page__side-bar']//a[3]")
	public WebElement sideMenuServiceYouAreUsingPage;

	@FindBy(xpath = "//span[contains(@class,'button button--default button--medium')]//span[1]")
	public WebElement learnButtonForKankenProduct;

	// not used
	@FindBy(xpath = "//button[@type='submit']")
	public WebElement SubmitButton;
	// not used

	// product list
	public void select1stCasecProduct() throws Exception {

		CommonFunctions.waitForVisiblity(productListLink, waitTime);
		productListLink.click();
		log.info("Click on product list page");

		CommonFunctions.waitForVisiblity(selectCasec1ProductFromProductList, waitTime);
		selectCasec1ProductFromProductList.click();
		log.info("Click on buy button from product list page,select 1st product-CASEC １");

	}

	public void select1stKanjiProduct() throws Exception {

		CommonFunctions.waitForVisiblity(productListLink, waitTime);
		productListLink.click();
		log.info("Click on product list page");

		CommonFunctions.waitForVisiblity(selectKanjiProductFromProductList, waitTime);
		selectKanjiProductFromProductList.click();
		log.info("Click on buy button from product list page,select 1st product");

	}

	// Order flow step 1
	public void methodForOrderFlowStep1() throws Exception {

		CommonFunctions.isElementVisible(step1ProceedButton);
		CommonFunctions.waitForVisiblity(step1ProceedButton, waitTime);
		step1ProceedButton.click();
		log.info("Step 1 tab :- click to 'To payment method selection' button");

	}

	// re login between step 1 to step 2
	public void methodForReloginForOrderFlow() throws Exception {

		NewBaseClass base = new NewBaseClass();
		base.replaceurl();

		CommonFunctions.waitForVisiblity(emailtextfield, waitTime);
		log.info("go to relogin page");
		LoginPage loginObj = new LoginPage(driver);
		loginObj.loginToPlatformForPayment();

	}

	// Order flow step 2
	public void methodForOrderFlowStep2() throws Exception {

		CommonFunctions.isElementVisible(step2ProceedButton);
		CommonFunctions.waitForVisiblity(step2ProceedButton, waitTime);
		step2ProceedButton.click();
		log.info("Step 2 tab :- click to 'Confirmation of order details' button");

	}

	// Order flow step 3
	public void methodForOrderFlowStep3() throws Exception {

		// CommonFunctions.isElementVisible(step3ConfirmOrderButton);
		CommonFunctions.scrolltoElement(step3ConfirmOrderButton);
		CommonFunctions.waitForVisiblity(step3ConfirmOrderButton, waitTime);
		step3ConfirmOrderButton.click();
		log.info("Step 3 tab :- click to 'Confirm the order' button");

	}

	// payment with valid credit card
	public void methodForStep2PaymentWithValidCreditCard() throws Exception {
		CommonFunctions.isElementVisible(step2ProceedButton);

		CommonFunctions.waitForVisiblity(registerYouCreditCardRadioButton, waitTime);
		registerYouCreditCardRadioButton.click();
		log.info("Step 2 tab :- click to 'Register your credit card information' radio button");

		CommonFunctions.waitForVisiblity(creditCardNumerTextbox, waitTime);
		creditCardNumerTextbox.sendKeys("4111111111111111");
		log.info("Step 2 tab :- provide card no to 'credit card number' textbox");

		CommonFunctions.waitForVisiblity(creditCardHolderNameTextbox, waitTime);
		creditCardHolderNameTextbox.sendKeys("rahul");
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

		CommonFunctions.isElementVisible(step2ProceedButton);
		CommonFunctions.waitForVisiblity(step2ProceedButton, waitTime);
		step2ProceedButton.click();
		log.info("Step 2 tab :- click to 'Confirmation of order details' button");
	}

	// payment with in valid credit card
	public void methodForStep2PaymentWithInValidCreditCard() throws Exception {
		CommonFunctions.isElementVisible(step2ProceedButton);
		CommonFunctions.waitForVisiblity(registerYouCreditCardRadioButton, waitTime);
		registerYouCreditCardRadioButton.click();
		log.info("Step 2 tab :- click to 'Register your credit card information' radio button");

		CommonFunctions.waitForVisiblity(creditCardNumerTextbox, waitTime);
		creditCardNumerTextbox.sendKeys("1111111111111111");
		log.info("Step 2 tab :- provide card no to 'credit card number' textbox");

		CommonFunctions.waitForVisiblity(creditCardHolderNameTextbox, waitTime);
		creditCardHolderNameTextbox.sendKeys("rahul");
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

		CommonFunctions.isElementVisible(step2ProceedButton);
		CommonFunctions.waitForVisiblity(step2ProceedButton, waitTime);
		step2ProceedButton.click();
		log.info("Step 2 tab :- click to 'Confirmation of order details' button");

		CommonFunctions.isElementVisible(invalidCreditCardTextHandler);
		String invalidCreditCardText = invalidCreditCardTextHandler.getText();
		String expectedInvalidCreditCardText = "ご利用いただけないクレジットカードです。";
		CommonFunctions.assertString(invalidCreditCardText, expectedInvalidCreditCardText);
		log.info("The invalid credit card message match with our expected message");
	}

	// payment with in blank credit card
	public void methodForStep2PaymentWithBlankCreditCard() throws Exception {
		CommonFunctions.isElementVisible(step2ProceedButton);

		CommonFunctions.waitForVisiblity(registerYouCreditCardRadioButton, waitTime);
		registerYouCreditCardRadioButton.click();
		log.info("Step 2 tab :- click to 'Register your credit card information' radio button");

		CommonFunctions.isElementVisible(step2ProceedButton);
		CommonFunctions.waitForVisiblity(step2ProceedButton, waitTime);
		step2ProceedButton.click();
		log.info("Step 2 tab :- click to 'Confirmation of order details' button");

		String expectedInvalidCreditCardText = "入力してください";
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

	// payment with valid con store
	public void methodForStep2PaymentWithConStore() throws Exception {
		CommonFunctions.isElementVisible(step2ProceedButton);

		CommonFunctions.waitForVisiblity(convenienceStorePaymentRadioButton, waitTime);
		convenienceStorePaymentRadioButton.click();
		log.info("Step 2 tab :- click to 'convenience Store Payment' radio button");

		CommonFunctions.waitForVisiblity(lawsonRadioButton, waitTime);
		lawsonRadioButton.click();
		log.info("Step 2 tab :- click to 'lawson' radio button");

		CommonFunctions.waitForVisiblity(kanjiNameTextbox, waitTime);
		kanjiNameTextbox.clear();
		kanjiNameTextbox.sendKeys("柏木佳　奈子");
		log.info("Step 2 tab :- provide name 'kanji Name' textbox");

		CommonFunctions.waitForVisiblity(kanaNameTextbox, waitTime);
		kanaNameTextbox.clear();
		kanaNameTextbox.sendKeys("カシワギ　カナコ");
		log.info("Step 2 tab :- provide name 'kana Name' textbox");

		CommonFunctions.waitForVisiblity(phonenoTextbox, waitTime);
		phonenoTextbox.clear();
		phonenoTextbox.sendKeys("9890324119");
		log.info("Step 2 tab :- provide phone no 'phone no' textbox");

		CommonFunctions.waitForVisiblity(emailaddressTextbox, waitTime);
		emailaddressTextbox.clear();
		emailaddressTextbox.sendKeys("rahul.shinde+82@scispl.com");
		log.info("Step 2 tab :- provide email to 'email address' textbox");

		CommonFunctions.isElementVisible(step2ProceedButton);
		CommonFunctions.waitForVisiblity(step2ProceedButton, waitTime);
		step2ProceedButton.click();
		log.info("Step 2 tab :- click to 'Confirmation of order details' button");
	}

	public String[] methodForConStoreThankYouPage() throws Exception {

		// thank you page
		CommonFunctions.waitForVisiblity(step4ThankYouForYourPurchaseLabel, waitTime);
		String thankYouForYourApplicationLabelSTR = step4ThankYouForYourPurchaseLabel.getText();
		log.info("Step 4 tab :- thank You For Your Application text visible:- " + thankYouForYourApplicationLabelSTR);

		CommonFunctions.waitForVisiblity(customerNumberLabel, waitTime);
		String customerNumberLabelSTR = customerNumberLabel.getText();
		log.info("Step 4 tab :- Customer Number text visible:- " + customerNumberLabelSTR);

		CommonFunctions.waitForVisiblity(convenienceStoreLabel, waitTime);
		String convenienceStoreLabelSTR = convenienceStoreLabel.getText();
		log.info("Step 4 tab :- convenience store text visible:- " + convenienceStoreLabelSTR);

		CommonFunctions.waitForVisiblity(authorizationNumberLabel, waitTime);
		String authorizationNumberLabelSTR = authorizationNumberLabel.getText();
		log.info("Step 4 tab :- Authorization number text visible:- " + authorizationNumberLabelSTR);

		CommonFunctions.waitForVisiblity(paymentDeadlineLabel, waitTime);
		String paymentDeadlineLabelSTR = paymentDeadlineLabel.getText();
		log.info("Step 4 tab :- Payment deadline text visible:- " + paymentDeadlineLabelSTR);

		String removeJapword1 = paymentDeadlineLabelSTR.substring(0, 10);
		String removeJapword2 = removeJapword1.replaceAll("年", "/");
		String paymentDeadlineCompareSTR = removeJapword2.replaceAll("月", "/");
		log.info("Step 4 tab :- Payment deadline text capture for compare with order history page:- "
				+ paymentDeadlineCompareSTR);

		CommonFunctions.waitForVisiblity(orderNumberLabel, waitTime);
		String orderNumberLabelSTR = orderNumberLabel.getText();
		log.info("Step 4 tab :- Order number text visible:- " + orderNumberLabelSTR);

		// open top page on next tab
		Actions newTab = new Actions(driver);
		newTab.keyDown(Keys.CONTROL).keyDown(Keys.SHIFT).click(topPageButton).keyUp(Keys.CONTROL).keyUp(Keys.SHIFT)
				.build().perform();
		log.info("Step 4 tab :- click on top page button and it open in new browser tab");
		Thread.sleep(2000);

		// handle windows change
		String base1 = driver.getWindowHandle();
		Set<String> set = driver.getWindowHandles();

		set.remove(base1);
		assert set.size() == 1;
		driver.switchTo().window((String) set.toArray()[0]);
		log.info("Step 4 tab :- switched to top page");
		Thread.sleep(1000);
		CommonFunctions.waitForVisiblity(productListLink, waitTime);
		log.info("Product list page visible on top page");
		// close the window and switch back to the base tab
		driver.close();
		driver.switchTo().window(base1);
		log.info("Step 4 tab :- switched to thank you page again");

		// define string array
		String[] ret_Array = { paymentDeadlineCompareSTR, orderNumberLabelSTR };
		// return string array
		return ret_Array;

//		String[] result = new String[2];
//		result[0] = paymentDeadlineCompareSTR;
//		result[1] = orderNumberLabelSTR;
//		return result;

	}

	public void methodForConStoreOrderHistoryPage(String thankYouPagePaymentDeadlineSTR,
			String thankYouPageorderNumberLabelSTR) throws Exception {

		String expectedThankYouPagePaymentDeadlineSTR = thankYouPagePaymentDeadlineSTR;
		String expectedThankYouPageorderNumberLabelSTR = thankYouPageorderNumberLabelSTR;

		log.info("Store Payment Deadline from methodForConStoreThankYouPage:- "
				+ expectedThankYouPagePaymentDeadlineSTR);
		log.info("Store Order Number from methodForConStoreThankYouPage:- " + expectedThankYouPageorderNumberLabelSTR);

		CommonFunctions.waitForVisiblity(checkOrderHistoryLink, waitTime);
		checkOrderHistoryLink.click();

		CommonFunctions.waitForVisiblity(orderHistoryPaymentDeadlineLabel, waitTime);
		String orderHistoryPaymentDeadlineLabelForTrim = orderHistoryPaymentDeadlineLabel.getText();
		String orderHistoryPaymentDeadlineLabelSTR = orderHistoryPaymentDeadlineLabelForTrim.substring(5, 15);
		log.info("Order history page:- actual Payment deadline date " + orderHistoryPaymentDeadlineLabelSTR);
		CommonFunctions.assertString(expectedThankYouPagePaymentDeadlineSTR, orderHistoryPaymentDeadlineLabelSTR);

		CommonFunctions.waitForVisiblity(orderHistoryBuyAgainButton, waitTime);
		String orderHistoryBuyAgainButtonSTR = orderHistoryBuyAgainButton.getText();
		String expectedBuyAgainButton = "再度購入";
		log.info("Order history page:- buy again button visible " + orderHistoryBuyAgainButtonSTR);
		CommonFunctions.assertString(expectedBuyAgainButton, orderHistoryBuyAgainButtonSTR);

		CommonFunctions.waitForVisiblity(orderHistoryOrderNumberLabel, waitTime);
		String orderHistoryOrderNumberLabeltrim = orderHistoryOrderNumberLabel.getText();
		String orderHistoryOrderNumberLabelSTR = orderHistoryOrderNumberLabeltrim.substring(6, 31);
		log.info("Order history page:- order number is " + orderHistoryOrderNumberLabelSTR);
		CommonFunctions.assertString(expectedThankYouPageorderNumberLabelSTR, orderHistoryOrderNumberLabelSTR);

		CommonFunctions.waitForVisiblity(orderHistoryPaymentStatusLabel, waitTime);
		String orderHistoryPaymentStatusLabelSTR = orderHistoryPaymentStatusLabel.getText();
		String expectedStatusPaymentUnconfirmed = "支払い未確認";
		log.info("Order history page:- payment status is Payment unconfirmed " + orderHistoryPaymentStatusLabelSTR);
		CommonFunctions.assertString(expectedStatusPaymentUnconfirmed, orderHistoryPaymentStatusLabelSTR);

		CommonFunctions.waitForVisiblity(orderHistoryProductNameLabel, waitTime);
		String orderHistoryProductNameLabelSTR = orderHistoryProductNameLabel.getText();
		log.info("Order history page:- product name is " + orderHistoryProductNameLabelSTR);

		CommonFunctions.waitForVisiblity(orderHistoryPriceLabel, waitTime);
		String orderHistoryPriceLabelSTR = orderHistoryPriceLabel.getText();
		log.info("Order history page:- product price is " + orderHistoryPriceLabelSTR);

		CommonFunctions.waitForVisiblity(orderHistoryOrderDateLabel, waitTime);
		String orderHistoryOrderDateLabelSTR = orderHistoryOrderDateLabel.getText();
		log.info("Order history page:- order date is " + orderHistoryOrderDateLabelSTR);
	}

	// String stringToCompare = null;

	public String[] methodForCreditCardThankYouPage() throws Exception {

		// thank you page
		CommonFunctions.waitForVisiblity(thankYouForYourApplicationCreditCardLabel, waitTime);
		// stringToCompare = thankYouForYourApplicationCreditCardLabel.getText();
		String ThankYouForYourApplicationLabelSTR = thankYouForYourApplicationCreditCardLabel.getText();
		String expectedThankYouForYourApplicationLabelSTR = "ご購入ありがとうございます。";
		log.info("Step 4 tab :- thank You For Your Application text visible:- " + ThankYouForYourApplicationLabelSTR);
		CommonFunctions.assertString(ThankYouForYourApplicationLabelSTR, expectedThankYouForYourApplicationLabelSTR);

		CommonFunctions.waitForVisiblity(orderNumberCreditCardLabel, waitTime);
		String orderNumberCreditCardLabelSTR = orderNumberCreditCardLabel.getText();
		log.info("Step 4 tab :- Order number text visible:- " + orderNumberCreditCardLabelSTR);

		CommonFunctions.waitForVisiblity(checkOrderHistoryLink, waitTime);
		log.info("Step 4 tab :- order history link visible");

		CommonFunctions.waitForVisiblity(StartNowButton, waitTime);
		String startNowButtonSTR = StartNowButton.getText();
		String expectedstartNowButtonSTR = "今すぐはじめる";
		log.info("Step 4 tab :- start now button visible:- " + startNowButtonSTR);
		CommonFunctions.assertString(expectedstartNowButtonSTR, startNowButtonSTR);

		CommonFunctions.waitForVisiblity(FAQLink, waitTime);
		log.info("Step 4 tab :- Frequently Asked Questions / Inquiries link visible");

		CommonFunctions.waitForVisiblity(termsOfUseLink, waitTime);
		log.info("Step 4 tab :- Terms of use ・ Handling of personal information link visible");

		CommonFunctions.waitForVisiblity(privacyPolicyLink, waitTime);
		log.info("Step 4 tab :- privacy policy link visible");

		CommonFunctions.waitForVisiblity(commercialTransactionsLawLink, waitTime);
		log.info("Step 4 tab :- Display based on the Specified Commercial Transactions Law link visible");

		// open footer menu on next tab
		Actions newTab = new Actions(driver);
		newTab.keyDown(Keys.CONTROL).keyDown(Keys.SHIFT).click(FAQLink).keyUp(Keys.CONTROL).keyUp(Keys.SHIFT).build()
				.perform();
		log.info("Step 4 tab :- click on FAQ and it open in new browser tab");
		Thread.sleep(2000);
		newTab.keyDown(Keys.CONTROL).keyDown(Keys.SHIFT).click(termsOfUseLink).keyUp(Keys.CONTROL).keyUp(Keys.SHIFT)
				.build().perform();
		log.info("Step 4 tab :- click on terms Of Use Link and it open in new browser tab");
		Thread.sleep(2000);
		newTab.keyDown(Keys.CONTROL).keyDown(Keys.SHIFT).click(privacyPolicyLink).keyUp(Keys.CONTROL).keyUp(Keys.SHIFT)
				.build().perform();
		log.info("Step 4 tab :- click on privery policy Link and it open in new browser tab");
		Thread.sleep(2000);
		newTab.keyDown(Keys.CONTROL).keyDown(Keys.SHIFT).click(commercialTransactionsLawLink).keyUp(Keys.CONTROL)
				.keyUp(Keys.SHIFT).build().perform();
		log.info("Step 4 tab :- click on commercial transaction law Link and it open in new browser tab");

		// handle windows change
		String base1 = driver.getWindowHandle();
		Set<String> set = driver.getWindowHandles();

		set.remove(base1);
		assert set.size() == 4;
		driver.switchTo().window((String) set.toArray()[0]);
		log.info("Step 4 tab :- switched to commercial Transactions page");
		Thread.sleep(1000);
		CommonFunctions.waitForVisiblity(commercialTransactionsPageLabel, waitTime);
		log.info("commercial Transactions text visible on commercial Transactions page");
		// close the window and switch back to the base tab
		driver.close();

		driver.switchTo().window((String) set.toArray()[1]);
		log.info("Step 4 tab :- switched to privacy Policy page");
		Thread.sleep(1000);
		CommonFunctions.waitForVisiblity(privacyPolicyLinkPageLabel, waitTime);
		log.info("privacy Policy text visible on privacy Policy Page");
		// close the window and switch back to the base tab
		driver.close();

		driver.switchTo().window((String) set.toArray()[2]);
		log.info("Step 4 tab :- switched to Terms of Service page");
		Thread.sleep(1000);
		CommonFunctions.waitForVisiblity(STAGIATermsofServiceLabel, waitTime);
		log.info("STAGIA Terms of Service visible on FAQ page");
		// close the window and switch back to the base tab
		driver.close();

		driver.switchTo().window((String) set.toArray()[3]);
		log.info("Step 4 tab :- switched to FAQ page");
		Thread.sleep(1000);
		CommonFunctions.waitForVisiblity(FAQPageLogo, waitTime);
		log.info("FAQ logo visible on FAQ page");
		// close the window and switch back to the base tab
		driver.close();

		driver.switchTo().window(base1);
		log.info("Step 4 tab :- switched to thank you page again");

		// define string array
		String[] ret_Array = { orderNumberCreditCardLabelSTR };
		// return string array
		return ret_Array;
	}

	public void methodForCreditCardOrderHistoryPage(String orderNumberLabelSTR) throws Exception {

		String expectedOrderNumberLabelSTR = orderNumberLabelSTR;

		log.info("Store Order Number from methodForCreditCardThankYouPage:- " + expectedOrderNumberLabelSTR);

		CommonFunctions.waitForVisiblity(checkOrderHistoryLink, waitTime);
		checkOrderHistoryLink.click();

		CommonFunctions.waitForVisiblity(orderHistoryBuyAgainButton, waitTime);
		String orderHistoryBuyAgainButtonSTR = orderHistoryBuyAgainButton.getText();
		String expectedBuyAgainButton = "再度購入";
		log.info("Order history page:- buy again button visible " + orderHistoryBuyAgainButtonSTR);
		CommonFunctions.assertString(expectedBuyAgainButton, orderHistoryBuyAgainButtonSTR);

		CommonFunctions.waitForVisiblity(orderHistoryOrderNumberLabel, waitTime);
		String orderHistoryOrderNumberLabelforTrim = orderHistoryOrderNumberLabel.getText();
		String orderHistoryOrderNumberLabelSTR = orderHistoryOrderNumberLabelforTrim.substring(6, 31);
		log.info("Order history page:- order number is " + orderHistoryOrderNumberLabelSTR);
		CommonFunctions.assertString(expectedOrderNumberLabelSTR, orderHistoryOrderNumberLabelSTR);

		CommonFunctions.waitForVisiblity(orderHistoryPaymentStatusLabel, waitTime);
		String orderHistoryPaymentStatusLabelSTR = orderHistoryPaymentStatusLabel.getText();
		String expectedStatusPaymentconfirmed = "支払い確認済み";
		log.info("Order history page:- payment status is Payment confirmed " + expectedStatusPaymentconfirmed);
		CommonFunctions.assertString(expectedStatusPaymentconfirmed, orderHistoryPaymentStatusLabelSTR);

		CommonFunctions.waitForVisiblity(orderHistoryProductNameLabel, waitTime);
		String orderHistoryProductNameLabelSTR = orderHistoryProductNameLabel.getText();
		log.info("Order history page:- product name is " + orderHistoryProductNameLabelSTR);

		CommonFunctions.waitForVisiblity(orderHistoryPriceLabel, waitTime);
		String orderHistoryPriceLabelSTR = orderHistoryPriceLabel.getText();
		log.info("Order history page:- product price is " + orderHistoryPriceLabelSTR);

		CommonFunctions.waitForVisiblity(orderHistoryOrderDateLabel, waitTime);
		String orderHistoryOrderDateLabelforTrim = orderHistoryOrderDateLabel.getText();
		log.info("Order history page:- order date is " + orderHistoryOrderDateLabelforTrim);
		String orderHistoryOrderDateLabelSTR = orderHistoryOrderDateLabelforTrim.substring(5, 15);
		String currentDate = java.time.LocalDate.now().toString();
		CommonFunctions.assertString(currentDate, orderHistoryOrderDateLabelSTR);
	}

	public void verifyLearnButtonFromServiceYouAreUsingPage() throws Exception {

		CommonFunctions.waitForVisiblity(sideMenuServiceYouAreUsingPage, waitTime);
		sideMenuServiceYouAreUsingPage.click();

		CommonFunctions.waitForVisiblity(learnButtonForKankenProduct, waitTime);
		String learnButtonLabelForKankenProductSTR = learnButtonForKankenProduct.getText();
		String expectedLearnButtonLabelForKankenProductSTR = "漢検にログインして利用開始";
		log.info("Service you are using:- learn button text " + learnButtonLabelForKankenProductSTR);
		CommonFunctions.assertString(expectedLearnButtonLabelForKankenProductSTR, learnButtonLabelForKankenProductSTR);

	}

}
