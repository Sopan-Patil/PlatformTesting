package platform.pageobjects.Order;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

	@FindBy(xpath = "/html/body/div/div[3]/div[1]/div[1]/div[4]/form/button")
	public WebElement productlistToBuyButton;

	// @FindBy(xpath = "//button[@type='submit'] //span[@class='button__text']")
	@FindBy(xpath = "//button[@role='button']")
	public WebElement step1ProceedButton;

	@FindBy(xpath = "//input[@id='email']")
	public WebElement emailtextfield;

	@FindBy(xpath = "//*[@id=\"finalizeButton\"]/span/span")
	public WebElement step2ProceedButton;

	@FindBy(xpath = "//a[@id='finalizeButton']")
	public WebElement step3ConfirmOrderButton;

	@FindBy(xpath = "//h3[contains(text(),'ご購入ありがとうございます。')]")
	public WebElement step4ThankYouForYourPurchaseLabel;

	@FindBy(xpath = "//label[contains(text(),'クレジットカード情報を登録する')]")
	public WebElement registerYouCreditCardRadioButton_1;

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

	// not used
	@FindBy(xpath = "//button[@type='submit']")
	public WebElement SubmitButton;
	// not used

	public void orderWithExitingValidCreditcard() throws Exception {

		CommonFunctions.waitForVisiblity(productListLink, waitTime);
		productListLink.click();
		log.info("Click on product list page");

		CommonFunctions.waitForVisiblity(productlistToBuyButton, waitTime);
		productlistToBuyButton.click();
		log.info("Click on buy button from product list page,select 1st product");

		CommonFunctions.isElementVisible(productlistToBuyButton);
		CommonFunctions.waitForVisiblity(productlistToBuyButton, waitTime);
		step1ProceedButton.click();
		log.info("Step 1 tab :- click to 'To payment method selection' button");

		Thread.sleep(2000);
		NewBaseClass base = new NewBaseClass();
		base.replaceurl();

		log.info("go to relogin page");
		LoginPage loginObj = new LoginPage(driver);
		loginObj.loginToPlatformForPayment();

		CommonFunctions.isElementVisible(step2ProceedButton);
		CommonFunctions.waitForVisiblity(step2ProceedButton, waitTime);
		step2ProceedButton.click();
		log.info("Step 2 tab :- click to 'Confirmation of order details' button");

		CommonFunctions.isElementVisible(step3ConfirmOrderButton);
		CommonFunctions.waitForVisiblity(step3ConfirmOrderButton, waitTime);
		step3ConfirmOrderButton.click();
		log.info("Step 3 tab :- click to 'Confirm the order' button");

		CommonFunctions.isElementVisible(step4ThankYouForYourPurchaseLabel);
		log.info("Step 4 tab :- order complete");

		/*
		 * if (CommonFunctions.waitForVisiblity(SubmitButton, waitTime)) {
		 * CommonFunctions.clickUsingJavaExecutor(SubmitButton); }
		 */

	}

	public void orderWithValidCreditcard() throws Exception {

		CommonFunctions.waitForVisiblity(productListLink, waitTime);
		productListLink.click();
		log.info("Click on product list page");

		// log.trace("Trace Message!");
		// log.debug("Debug Message!");
		// log.info("Info Message!");
		// log.warn("Warn Message!");
		// log.error("Error Message!");
		// log.fatal("Fatal Message!");

		CommonFunctions.waitForVisiblity(productlistToBuyButton, waitTime);
		productlistToBuyButton.click();
		log.info("Click on buy button from product list page,select 1st product");

		CommonFunctions.isElementVisible(productlistToBuyButton);
		CommonFunctions.waitForVisiblity(productlistToBuyButton, waitTime);
		step1ProceedButton.click();
		log.info("Step 1 tab :- click to 'To payment method selection' button");

		Thread.sleep(2000);
		NewBaseClass base = new NewBaseClass();
		base.replaceurl();

		log.info("go to relogin page");
		LoginPage loginObj = new LoginPage(driver);
		loginObj.loginToPlatformForPayment();

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

		CommonFunctions.isElementVisible(step3ConfirmOrderButton);
		CommonFunctions.waitForVisiblity(step3ConfirmOrderButton, waitTime);
		step3ConfirmOrderButton.click();
		log.info("Step 3 tab :- click to 'Confirm the order' button");

		CommonFunctions.isElementVisible(step4ThankYouForYourPurchaseLabel);
		log.info("Step 4 tab :- order complete");

		/*
		 * if (CommonFunctions.waitForVisiblity(SubmitButton, waitTime)) {
		 * CommonFunctions.clickUsingJavaExecutor(SubmitButton); }
		 */

	}

	public void orderWithInValidCreditcard() throws Exception {

		CommonFunctions.waitForVisiblity(productListLink, waitTime);
		productListLink.click();
		log.info("Click on product list page");

		CommonFunctions.waitForVisiblity(productlistToBuyButton, waitTime);
		productlistToBuyButton.click();
		log.info("Click on buy button from product list page,select 1st product");

		CommonFunctions.isElementVisible(productlistToBuyButton);
		CommonFunctions.waitForVisiblity(productlistToBuyButton, waitTime);
		step1ProceedButton.click();
		log.info("Step 1 tab :- click to 'To payment method selection' button");

		Thread.sleep(2000);
		NewBaseClass base = new NewBaseClass();
		base.replaceurl();

		log.info("go to relogin page");
		LoginPage loginObj = new LoginPage(driver);
		loginObj.loginToPlatformForPayment();

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

//		String expectedInValidCreditCardErrorMessage = "ご利用いただけないクレジットカードです。";
//		CommonFunctions.assertString(invalidCreditCardTextHandler, expectedInValidCreditCardErrorMessage);
//
//		if (invalidCreditCardTextHandler.getText().equals("ご利用いただけないクレジットカードです。")) {
//			log.info("It display valid error message for invalid credit card");
//		}
//
//		else {
//
//			log.error("The error message invalid credit card is not display");
//		}

		try {
			if (invalidCreditCardTextHandler.getText().equals("11ご利用いただけないクレジットカードです。")) {
				log.info("1It display valid error message for invalid credit card");
			}

		} catch (Exception e) {
			log.error("3The error message invalid credit card is not display");
		}

	}

	public void orderWithBlankValidCreditcardDetails() throws Exception {

		CommonFunctions.waitForVisiblity(productListLink, waitTime);
		productListLink.click();
		log.info("Click on product list page");

		CommonFunctions.waitForVisiblity(productlistToBuyButton, waitTime);
		productlistToBuyButton.click();
		log.info("Click on buy button from product list page,select 1st product");

		CommonFunctions.isElementVisible(productlistToBuyButton);
		CommonFunctions.waitForVisiblity(productlistToBuyButton, waitTime);
		step1ProceedButton.click();
		log.info("Step 1 tab :- click to 'To payment method selection' button");

		Thread.sleep(2000);
		NewBaseClass base = new NewBaseClass();
		base.replaceurl();

		log.info("go to relogin page");
		LoginPage loginObj = new LoginPage(driver);
		loginObj.loginToPlatformForPayment();

		CommonFunctions.isElementVisible(step2ProceedButton);

		CommonFunctions.waitForVisiblity(registerYouCreditCardRadioButton, waitTime);
		registerYouCreditCardRadioButton.click();
		log.info("Step 2 tab :- click to 'Register your credit card information' radio button");

		CommonFunctions.isElementVisible(step2ProceedButton);
		CommonFunctions.waitForVisiblity(step2ProceedButton, waitTime);
		step2ProceedButton.click();
		log.info("Step 2 tab :- click to 'Confirmation of order details' button");

		CommonFunctions.isElementVisible(invalidCreditCardTextHandler);

		String expectedInValidCreditCardErrorMessage = "ご利用いただけないクレジットカードです。";
		CommonFunctions.assertString(invalidCreditCardTextHandler, expectedInValidCreditCardErrorMessage);

		if (invalidCreditCardTextHandler.getText().equals("ご利用いただけないクレジットカードです。")) {
			log.info("It display valid error message for invalid credit card");
		}

		else {

			log.error("The error message invalid credit card is not display");
		}

	}
}
