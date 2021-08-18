package platform.pageobjects.Order;

import java.math.BigDecimal;
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
import utils.ExcelUtil;

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
	ExcelUtil excel = new ExcelUtil();

	public Order(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@href='/product-list']")
	public WebElement productListLink;

	@FindBy(xpath = "//p[@class=\"ep-card-product__title\"]//span")
	public WebElement productListProductName;

	@FindBy(xpath = "//div[@class=\"ep-card-product__price\"]//span")
	public WebElement productListProductPrice;

	@FindBy(xpath = "//span[@class='teaser-head__text-member'][1]")
	public WebElement topPageMemberPlanLink;

	@FindBy(xpath = "//button[@type='submit']//span[@class='button__text']")
	public WebElement applyForPrimeMembershipButton;

	@FindBy(xpath = "//body[1]/div[1]/div[3]/div[1]/div[1]/div[4]/form[1]/button[1]/span[1]")
	public WebElement selectCasec1ProductFromProductList;

	@FindBy(xpath = "/html/body/div/div[3]/div[2]/div[2]/div[4]/form/button")
	public WebElement selectKanjiProductFromProductList;

	@FindBy(xpath = "//a[@class='button button--gray button--xxmedium ep-order__btn ep-order__btn--back']//span")
	public WebElement orderFlowBackPageButton;

	// @FindBy(xpath = "//button[@type='submit'] //span[@class='button__text']")
	@FindBy(xpath = "//button[@role='button']//span")
	public WebElement step1ProceedButton;

	@FindBy(xpath = "//div[@class='ep-order__title']")
	public WebElement step1OrderDetailsLabel;

	@FindBy(xpath = "//span[@class='step-order__icon mr-1 icon-step1']")
	public WebElement step2SelectPaymentMethodLabel;

	@FindBy(xpath = "//h2[@class=\"ep-order__title\"]")
	public WebElement step3SelectPaymentMethodLabel;

	@FindBy(xpath = "//input[@id='email']")
	public WebElement emailtextfield;

	@FindBy(xpath = "//*[@id=\"finalizeButton\"]/span/span")
	public WebElement step2ProceedButton;

	@FindBy(xpath = "//a[@id='finalizeButton']//span")
	public WebElement step3ConfirmOrderButton;

	@FindBy(xpath = "//button[@class='button button--blue1 button--xsmall']")
	public WebElement primeMembershipBenefitsLabel;

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

	@FindBy(xpath = "//span[@id='userEmailleb_id']")
	public WebElement invalidConStoreEmailTextHandler;

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

	// con store blank xpath
	@FindBy(xpath = "//span[@id='userNameleb_id']")
	public WebElement blankKanjiNameTextHandler;

	@FindBy(xpath = "//span[@id='userFuriganaleb_id']")
	public WebElement blankKanaNameTextHandler;

	@FindBy(xpath = "//span[@id='userPhoneleb_id']")
	public WebElement blankPhonenoTextHandler;

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

	@FindBy(xpath = "//div[@class='box-head']//h3")
	public WebElement thankYouForYourApplicationPrimeLabel;

	@FindBy(xpath = "//div[@class='box-body__item mb-3']//strong//span")
	public WebElement orderNumberCreditCardLabel;

	@FindBy(xpath = "//div[@class='box-body__item']//strong")
	public WebElement orderNumberPrimeLabel;

	@FindBy(xpath = "//a[@class='button button--default button--uplarge']//span")
	public WebElement StartNowButton;

	@FindBy(xpath = "//a[@class='button button--default button--uplarge']//span")
	public WebElement thankYouPageTopPageButton;

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

	@FindBy(xpath = "//div[@class='ep-my-page__side-bar']//a[2]")
	public WebElement sideMembershipStatusPage;

	@FindBy(xpath = "//span[contains(@class,'button button--default button--medium')]//span[1]")
	public WebElement learnButtonForKankenProduct;

	// xpath for prime m
	@FindBy(xpath = "//p[@class='ep-box-member__title']")
	public WebElement membershipPagePrimeLabel;

	@FindBy(xpath = "//div[@class='ep-member-info ep-member-info--amount']//div[@class='ep-member-info__content justify-content-between']//span[2]")
	public WebElement membershipPagePrimePriceLabel;

	@FindBy(xpath = "//span[@class='ep-member-info__payment']")
	public WebElement membershipPagePrimeCreditCardLabel;

	@FindBy(xpath = "//a[@href='mypage-management-payment-method']//span")
	public WebElement membershipPageChangeCardButton;

	@FindBy(xpath = "//a[contains(@class,'button button--gray button--xmedium')]//span")
	public WebElement membershipPageEndMembershipButton;

	@FindBy(xpath = "//a[@class='button button--blue1 button--xsmall font-weight-normal']//span")
	public WebElement primeButtonOnHeaderPage;

	// --------------ordstep 1

	@FindBy(xpath = "//div[@class='box-order-confirm']/div[2]/div[2]/div[2]/div[1]/p[2]/span")
	public WebElement step1ProductPriceExcludingTaxLabel;

	@FindBy(xpath = "//div[@class='box-order-confirm']/div[2]/div[2]/div[2]/div[2]/p[2]/span")
	public WebElement step1ProductSubtotalLabel;

	@FindBy(xpath = "//div[@class='box-order-confirm']/div[2]/div[2]/div[2]/div[3]/p[2]/span")
	public WebElement step1ProductConsumptionTaxTenPerLabel;

	@FindBy(xpath = "//div[@class='box-order-confirm']/div[2]/div[2]/div[2]/div[4]/p[2]/span")
	public WebElement step1ProductBilledAmountLabel;

	@FindBy(xpath = "//div[@class='box-order-confirm']/div[2]/div[2]/div[2]/div[3]/p[1]")
	public WebElement step1ProductTAX10Per;

	// --------------step 2 円

	@FindBy(xpath = "//*[@id=\"form\"]/div[2]/div/div[2]/div[1]/p[2]")
	public WebElement step2ProductPriceExcludingTaxLabelWithSymbol;

	@FindBy(xpath = "//*[@id=\"form\"]/div[2]/div/div[2]/div[2]/p[2]")
	public WebElement step2ProductSubtotalLabelWithSymbol;

	@FindBy(xpath = "//*[@id=\"form\"]/div[2]/div/div[2]/div[3]/p[2]")
	public WebElement step2ProductConsumptionTaxTenPerLabelWithSymbol;

	@FindBy(xpath = "//*[@id=\"form\"]/div[2]/div/div[2]/div[4]/p[2]")
	public WebElement step2ProductBilledAmountLabelWithSymbol;

	@FindBy(xpath = "//div[@class='box-order-confirm']/div[2]/div[3]//p[1]")
	public WebElement step2And3ProductNameLabelProductTAX10Per;

	// --------------step 3 円

	@FindBy(xpath = "//div[@class='box-order-confirm']/div[2]/div[1]/p[2]")
	public WebElement step3ProductPriceExcludingTaxLabelWithSymbol;

	@FindBy(xpath = "//div[@class='box-order-confirm']/div[2]/div[2]/p[2]")
	public WebElement step3ProductSubtotalLabelWithSymbol;

	@FindBy(xpath = "//div[@class='box-order-confirm']/div[2]/div[3]/p[2]")
	public WebElement step3ProductConsumptionTaxTenPerLabelWithSymbol;

	@FindBy(xpath = "//div[@class='box-order-confirm']/div[2]/div[4]/p[2]")
	public WebElement step3ProductBilledAmountLabelWithSymbol;

	@FindBy(xpath = "//div[@class='box-order-confirm__des']//p[2]")
	public WebElement step2And3ProductNameLabel;

	@FindBy(xpath = "//div[@class='box-order-confirm__title']//span")
	public WebElement step1ProductNameLabel;

	// not used
	@FindBy(xpath = "//button[@type='submit']")
	public WebElement SubmitButton;
	// not used

	// product list
	public String[] select1stCasecProduct() throws Exception {

		CommonFunctions.waitForVisiblity(productListLink, waitTime);
		productListLink.click();
		log.info("Click on product list page");

		CommonFunctions.isElementVisible(productListProductName);
		String productListProductNameTxtWithMultiLine = productListProductName.getText().trim();

		String productListProductNameTxt = productListProductNameTxtWithMultiLine.replaceAll("\n", "");
		log.info("The product name from product list page " + productListProductNameTxt);

		CommonFunctions.isElementVisible(productListProductPrice);
		String productListProductPriceTxtWithSymbol = productListProductPrice.getText().trim();
		String productListProductPriceTxt = productListProductPriceTxtWithSymbol.replaceAll(",", "");
		log.info("The product price from product list page " + productListProductPriceTxt);

		CommonFunctions.waitForVisiblity(selectCasec1ProductFromProductList, waitTime);
		selectCasec1ProductFromProductList.click();
		log.info("Click on buy button from product list page,select 1st product-CASEC １");

		// define string array
		String[] ret_Array = { productListProductNameTxt, productListProductPriceTxt };
		// return string array
		return ret_Array;
	}

	public void openProductListPage() throws Exception {

		CommonFunctions.waitForVisiblity(productListLink, waitTime);
		productListLink.click();
		log.info("Click on product list page");

	}

	public void openMemberPlanPageFromTopPage() throws Exception {

		CommonFunctions.waitForVisiblity(topPageMemberPlanLink, waitTime);
		topPageMemberPlanLink.click();
		log.info("Click on top Page Member Plan Link");

	}

	public void clickApplyForPrimeMembershipButton() throws Exception {
		CommonFunctions.scrolltoElement(applyForPrimeMembershipButton);
		CommonFunctions.waitForVisiblity(applyForPrimeMembershipButton, waitTime);
		applyForPrimeMembershipButton.click();
		log.info("Click Apply For Prime Membership Button");

	}

	public void clickOnOrderFlowBackButton() throws Exception {
		CommonFunctions.scrolltoElement(orderFlowBackPageButton);
		CommonFunctions.waitForVisiblity(orderFlowBackPageButton, waitTime);
		orderFlowBackPageButton.click();
		log.info("Click On Order Flow Back Button");

	}

	public void proceedWith1stCasecProduct() throws Exception {

		CommonFunctions.waitForVisiblity(selectCasec1ProductFromProductList, waitTime);
		selectCasec1ProductFromProductList.click();
		log.info("Click on buy button from product list page,select 1st product-CASEC １");

	}

	public void verifyOrderFlowStep1PageLoadedSuccessfully() throws Exception {

		CommonFunctions.waitForVisiblity(step1OrderDetailsLabel, waitTime);
		log.info("step 1 Page Loaded Successfully");

	}

	public void verifyOrderFlowStep2PageLoadedSuccessfully() throws Exception {

		CommonFunctions.waitForVisiblity(step2SelectPaymentMethodLabel, waitTime);
		log.info("step 2 Page Loaded Successfully");

	}

	public void verifyOrderFlowStep3PageLoadedSuccessfully() throws Exception {

		CommonFunctions.waitForVisiblity(step3SelectPaymentMethodLabel, waitTime);
		log.info("step 3 Page Loaded Successfully");

	}

	public void verifyOrderFlowStep4ThankYouPageLoadedSuccessfully() throws Exception {
		CommonFunctions.scrolltoElement(copyRightLabel);
		CommonFunctions.waitForVisiblity(copyRightLabel, waitTime);
		log.info("step 3 thank you Page Loaded Successfully");

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
	public void compareProductDataOnOrderStep1(String productNameFromProductListPage,
			String productPriceFromProductListPage) throws Exception {

		String productNameFromProductListPageSTR = productNameFromProductListPage;
		String productPriceFromProductListPageSTR = productPriceFromProductListPage;

		CommonFunctions.waitForVisiblity(step1ProductNameLabel, waitTime);
		String step1And2And3ProductNameLabelString = step1ProductNameLabel.getText().trim();
		CommonFunctions.assertString(step1And2And3ProductNameLabelString, productNameFromProductListPageSTR);
		log.info("Order Step 1 product name match with product name from product list page");

		CommonFunctions.waitForVisiblity(step1ProductPriceExcludingTaxLabel, waitTime);
		String step1ProductPriceExcludingTaxLabelString = step1ProductPriceExcludingTaxLabel.getText().trim();
		int step1ProductPriceExcludingTaxLabelSTR = CommonFunctions
				.stringToInt(step1ProductPriceExcludingTaxLabelString);
		log.info("Order Step 1 Price (excluding tax):- " + step1ProductPriceExcludingTaxLabelSTR);

		CommonFunctions.waitForVisiblity(step1ProductSubtotalLabel, waitTime);
		String step1ProductSubtotalLabelString = step1ProductSubtotalLabel.getText().trim();
		int step1ProductSubtotalLabelSTR = CommonFunctions.stringToInt(step1ProductSubtotalLabelString);
		log.info("Order Step 1 Price Subtotal:- " + step1ProductSubtotalLabelSTR);

		// check Price (excluding tax) and subtotal is same or not
		CommonFunctions.assertInt(step1ProductPriceExcludingTaxLabelSTR, step1ProductSubtotalLabelSTR);
		log.info("Price (excluding tax) and subtotal have same amount");

		// expected Consumption tax 10% from subtotal
		CommonFunctions.waitForVisiblity(step1ProductTAX10Per, waitTime);
		String step1ProductTAX10PerSymbolSTR = step1ProductTAX10Per.getText().trim();
		String step1ProductTAX10PerForDecimalSTR = step1ProductTAX10PerSymbolSTR.substring(3, 5);
		String step1ProductTAX10PerDecimalSTR = "0." + step1ProductTAX10PerForDecimalSTR;
		log.info("step 1 product tax:- " + step1ProductTAX10PerDecimalSTR);

		Float tenPerTaxFloatValue = CommonFunctions.stringToFloat(step1ProductTAX10PerDecimalSTR);
		Float calculatedTenPerValue = step1ProductSubtotalLabelSTR * tenPerTaxFloatValue;
		Float calculatedTenPerRoundedValue = (float) Math.round(calculatedTenPerValue);
		int calculatedTenPerIntValue = CommonFunctions.floatToInt(calculatedTenPerRoundedValue);
		log.info("Order Step 1 Price rounded value:- " + calculatedTenPerIntValue);

		// calculate Consumption tax 10% from subtotal
		CommonFunctions.waitForVisiblity(step1ProductConsumptionTaxTenPerLabel, waitTime);
		String step1ProductConsumptionTaxTenPerLabelSTR = step1ProductConsumptionTaxTenPerLabel.getText().trim();
		Float ExpectedTenPerTaxFloatValue = CommonFunctions.stringToFloat(step1ProductConsumptionTaxTenPerLabelSTR);
		int ExpectedTenPerTaxIntValue = CommonFunctions.floatToInt(ExpectedTenPerTaxFloatValue);
		log.info("Order Step 1 Price Consumption tax 10%:- " + ExpectedTenPerTaxIntValue);

		// check expected and actual Consumption tax 10%
		CommonFunctions.assertInt(calculatedTenPerIntValue, ExpectedTenPerTaxIntValue);
		log.info("expected and actual Consumption tax 10% values is matched");

		// addition of subtotal + Consumption tax 10%
		int expectedBilledAmountIntValue = CommonFunctions.additionOfInt(ExpectedTenPerTaxIntValue,
				step1ProductSubtotalLabelSTR);
		log.info("addition of subtotal + Consumption tax 10% is " + expectedBilledAmountIntValue);

		CommonFunctions.waitForVisiblity(step1ProductBilledAmountLabel, waitTime);
		String step1ProductBilledAmountLabelString = step1ProductBilledAmountLabel.getText().trim();
		int step1ProductBilledAmountLabelSTR = CommonFunctions.stringToInt(step1ProductBilledAmountLabelString);
		log.info("Order Step 1 Billed amount:- " + step1ProductBilledAmountLabelSTR);

		// check expected Billed Amount and actual billed amount
		CommonFunctions.assertInt(expectedBilledAmountIntValue, step1ProductBilledAmountLabelSTR);
		log.info("expected Billed Amount and actual billed amount is matched ");

		int productPriceFromProductListPageInt = CommonFunctions.stringToInt(productPriceFromProductListPageSTR);

		// check expected Billed Amount and amount came from product list
		CommonFunctions.assertInt(productPriceFromProductListPageInt, step1ProductBilledAmountLabelSTR);
		log.info("expected Billed Amount and amount came from product list is matched ");

		CommonFunctions.waitForVisiblity(step1ProceedButton, waitTime);
		step1ProceedButton.click();
		log.info("Step 1 tab :- click to 'To payment method selection' button");

	}

	// Order flow step 1 for prime
	public void comparePrimeDataOnOrderStep1(String primeName, String primePrice) throws Exception {

		String productNameSTR = primeName;
		String productPriceSTR = primePrice;

		CommonFunctions.waitForVisiblity(step1ProductNameLabel, waitTime);
		String step1And2And3ProductNameLabelString = step1ProductNameLabel.getText().trim();
		CommonFunctions.assertString(step1And2And3ProductNameLabelString, productNameSTR);
		log.info("Order Step 1 product name match with product name from product list page");

		CommonFunctions.waitForVisiblity(step1ProductPriceExcludingTaxLabel, waitTime);
		String step1ProductPriceExcludingTaxLabelString = step1ProductPriceExcludingTaxLabel.getText().trim();
		int step1ProductPriceExcludingTaxLabelSTR = CommonFunctions
				.stringToInt(step1ProductPriceExcludingTaxLabelString);
		log.info("Order Step 1 Price (excluding tax):- " + step1ProductPriceExcludingTaxLabelSTR);

		CommonFunctions.waitForVisiblity(step1ProductSubtotalLabel, waitTime);
		String step1ProductSubtotalLabelString = step1ProductSubtotalLabel.getText().trim();
		int step1ProductSubtotalLabelSTR = CommonFunctions.stringToInt(step1ProductSubtotalLabelString);
		log.info("Order Step 1 Price Subtotal:- " + step1ProductSubtotalLabelSTR);

		// check Price (excluding tax) and subtotal is same or not
		CommonFunctions.assertInt(step1ProductPriceExcludingTaxLabelSTR, step1ProductSubtotalLabelSTR);
		log.info("Price (excluding tax) and subtotal have same amount");

		// expected Consumption tax 10% from subtotal
		CommonFunctions.waitForVisiblity(step1ProductTAX10Per, waitTime);
		String step1ProductTAX10PerSymbolSTR = step1ProductTAX10Per.getText().trim();
		String step1ProductTAX10PerForDecimalSTR = step1ProductTAX10PerSymbolSTR.substring(3, 5);
		String step1ProductTAX10PerDecimalSTR = "0." + step1ProductTAX10PerForDecimalSTR;
		log.info("step 1 product tax:- " + step1ProductTAX10PerDecimalSTR);

		Float tenPerTaxFloatValue = CommonFunctions.stringToFloat(step1ProductTAX10PerDecimalSTR);
		Float calculatedTenPerValue = step1ProductSubtotalLabelSTR * tenPerTaxFloatValue;
		float calculatedTenPerRoundedValue = BigDecimal.valueOf(calculatedTenPerValue)
				.setScale(0, BigDecimal.ROUND_HALF_DOWN).floatValue();
		int calculatedTenPerIntValue = CommonFunctions.floatToInt(calculatedTenPerRoundedValue);
		log.info("Order Step 1 Price rounded value:- " + calculatedTenPerIntValue);

		// calculate Consumption tax 10% from subtotal
		CommonFunctions.waitForVisiblity(step1ProductConsumptionTaxTenPerLabel, waitTime);
		String step1ProductConsumptionTaxTenPerLabelSTR = step1ProductConsumptionTaxTenPerLabel.getText().trim();
		Float ExpectedTenPerTaxFloatValue = CommonFunctions.stringToFloat(step1ProductConsumptionTaxTenPerLabelSTR);
		int ExpectedTenPerTaxIntValue = CommonFunctions.floatToInt(ExpectedTenPerTaxFloatValue);
		log.info("Order Step 1 Price Consumption tax 10%:- " + ExpectedTenPerTaxIntValue);

		// check expected and actual Consumption tax 10%
		CommonFunctions.assertInt(calculatedTenPerIntValue, ExpectedTenPerTaxIntValue);
		log.info("expected and actual Consumption tax 10% values is matched");

		// addition of subtotal + Consumption tax 10%
		int expectedBilledAmountIntValue = CommonFunctions.additionOfInt(ExpectedTenPerTaxIntValue,
				step1ProductSubtotalLabelSTR);
		log.info("addition of subtotal + Consumption tax 10% is " + expectedBilledAmountIntValue);

		CommonFunctions.waitForVisiblity(step1ProductBilledAmountLabel, waitTime);
		String step1ProductBilledAmountLabelString = step1ProductBilledAmountLabel.getText().trim();
		int step1ProductBilledAmountLabelSTR = CommonFunctions.stringToInt(step1ProductBilledAmountLabelString);
		log.info("Order Step 1 Billed amount:- " + step1ProductBilledAmountLabelSTR);

		// check expected Billed Amount and actual billed amount
		CommonFunctions.assertInt(expectedBilledAmountIntValue, step1ProductBilledAmountLabelSTR);
		log.info("expected Billed Amount and actual billed amount is matched ");

		int productPriceFromProductListPageInt = CommonFunctions.stringToInt(productPriceSTR);

		// check expected Billed Amount and amount came from product list
		CommonFunctions.assertInt(productPriceFromProductListPageInt, step1ProductBilledAmountLabelSTR);
		log.info("expected Billed Amount and amount came from product list is matched ");

		CommonFunctions.waitForVisiblity(step1ProceedButton, waitTime);
		step1ProceedButton.click();
		log.info("Step 1 tab :- click to 'To payment method selection' button");

	}

	// re login between step 1 to step 2
	public void verifyReloginBetweenStep1ToStep2WithExitingUser() throws Exception {

		NewBaseClass base = new NewBaseClass();
		base.replaceurl();

		CommonFunctions.waitForVisiblity(emailtextfield, waitTime);
		log.info("go to relogin page");
		LoginPage loginObj = new LoginPage(driver);
		loginObj.loginToPlatform();

	}

	// re login between step 1 to step 2
	public void verifyReloginBetweenStep1ToStep2WithNewlyCreatedUser() throws Exception {

		NewBaseClass base = new NewBaseClass();
		base.replaceurl();

		CommonFunctions.waitForVisiblity(emailtextfield, waitTime);
		log.info("go to relogin page");
		LoginPage loginObj = new LoginPage(driver);
		loginObj.loginWithNewUser();

	}

	// Order flow step 2
	public void compareProductDataOnOrderStep2(String productNameFromProductListPage,
			String productPriceFromProductListPage) throws Exception {

		String productNameFromProductListPageSTR = productNameFromProductListPage;
		String productPriceFromProductListPageSTR = productPriceFromProductListPage;

		CommonFunctions.waitForVisiblity(step2And3ProductNameLabel, waitTime);
		String step1And2And3ProductNameLabelString = step2And3ProductNameLabel.getText().trim();
		CommonFunctions.assertString(step1And2And3ProductNameLabelString, productNameFromProductListPageSTR);
		log.info("Order Step 2 product name match with product name from product list page");

		CommonFunctions.waitForVisiblity(step2ProductPriceExcludingTaxLabelWithSymbol, waitTime);
		String step2ProductPriceExcludingTaxLabelWithSymbolSTR = step2ProductPriceExcludingTaxLabelWithSymbol.getText()
				.trim();
		String step2ProductPriceExcludingTaxLabelWithSymbol = step2ProductPriceExcludingTaxLabelWithSymbolSTR
				.replaceAll("円", "");
		int step2ProductPriceExcludingTaxLabelSTR = CommonFunctions
				.stringToInt(step2ProductPriceExcludingTaxLabelWithSymbol);
		log.info("Order Step 2 Price (excluding tax):- " + step2ProductPriceExcludingTaxLabelSTR);

		CommonFunctions.waitForVisiblity(step2ProductSubtotalLabelWithSymbol, waitTime);
		String step2ProductSubtotalLabelWithSymbolStringSTR = step2ProductSubtotalLabelWithSymbol.getText().trim();
		String step2ProductSubtotalLabelWithSymbolString = step2ProductSubtotalLabelWithSymbolStringSTR.replaceAll("円",
				"");
		int step2ProductSubtotalLabelSTR = CommonFunctions.stringToInt(step2ProductSubtotalLabelWithSymbolString);
		log.info("Order Step 2 Price Subtotal:- " + step2ProductSubtotalLabelSTR);

		// check Price (excluding tax) and subtotal is same or not
		CommonFunctions.assertInt(step2ProductPriceExcludingTaxLabelSTR, step2ProductSubtotalLabelSTR);
		log.info("Price (excluding tax) and subtotal have same amount");

		// expected Consumption tax 10% from subtotal
		CommonFunctions.waitForVisiblity(step2And3ProductNameLabelProductTAX10Per, waitTime);
		String step2ProductTAX10PerSymbolSTR = step2And3ProductNameLabelProductTAX10Per.getText().trim();
		String step2ProductTAX10PerForDecimalSTR = step2ProductTAX10PerSymbolSTR.substring(3, 5);
		String step2ProductTAX10PerDecimalSTR = "0." + step2ProductTAX10PerForDecimalSTR;
		log.info("step 2 product tax:- " + step2ProductTAX10PerDecimalSTR);

		Float tenPerTaxFloatValue = CommonFunctions.stringToFloat(step2ProductTAX10PerDecimalSTR);
		Float calculatedTenPerValue = step2ProductSubtotalLabelSTR * tenPerTaxFloatValue;
		Float calculatedTenPerRoundedValue = (float) Math.round(calculatedTenPerValue);
		int calculatedTenPerIntValue = CommonFunctions.floatToInt(calculatedTenPerRoundedValue);
		log.info("Order Step 2 Price rounded value:- " + calculatedTenPerIntValue);

		// calculate Consumption tax 10% from subtotal
		CommonFunctions.waitForVisiblity(step2ProductConsumptionTaxTenPerLabelWithSymbol, waitTime);
		String step2ProductConsumptionTaxTenPerLabelWithSymbolSTR = step2ProductConsumptionTaxTenPerLabelWithSymbol
				.getText().trim();
		String step2ProductConsumptionTaxTenPerLabelWithSymbolString = step2ProductConsumptionTaxTenPerLabelWithSymbolSTR
				.replaceAll("円", "");
		Float ExpectedTenPerTaxFloatValue = CommonFunctions
				.stringToFloat(step2ProductConsumptionTaxTenPerLabelWithSymbolString);
		int ExpectedTenPerTaxIntValue = CommonFunctions.floatToInt(ExpectedTenPerTaxFloatValue);
		log.info("Order Step 2 Price Consumption tax 10%:- " + ExpectedTenPerTaxIntValue);

		// check expected and actual Consumption tax 10%
		CommonFunctions.assertInt(calculatedTenPerIntValue, ExpectedTenPerTaxIntValue);
		log.info("expected and actual Consumption tax 10% values is matched");

		// addition of subtotal + Consumption tax 10%
		int expectedBilledAmountIntValue = CommonFunctions.additionOfInt(ExpectedTenPerTaxIntValue,
				step2ProductSubtotalLabelSTR);
		log.info("addition of subtotal + Consumption tax 10% is " + expectedBilledAmountIntValue);

		CommonFunctions.waitForVisiblity(step2ProductBilledAmountLabelWithSymbol, waitTime);
		String step2ProductBilledAmountLabelTrimSTR = step2ProductBilledAmountLabelWithSymbol.getText().trim();
		String step2ProductBilledAmountLabelString = step2ProductBilledAmountLabelTrimSTR.replaceAll("円", "");
		int step2ProductBilledAmountLabelSTR = CommonFunctions.stringToInt(step2ProductBilledAmountLabelString);
		log.info("Order Step 2 Billed amount:- " + step2ProductBilledAmountLabelSTR);

		////////////// check with assert
		// check expected Billed Amount and actual billed amount
		CommonFunctions.assertInt(expectedBilledAmountIntValue, step2ProductBilledAmountLabelSTR);
		log.info("expected Billed Amount and actual billed amount is matched ");

		int productPriceFromProductListPageInt = CommonFunctions.stringToInt(productPriceFromProductListPageSTR);

		// check expected Billed Amount and amount came from product list
		CommonFunctions.assertInt(productPriceFromProductListPageInt, step2ProductBilledAmountLabelSTR);
		log.info("expected Billed Amount and amount came from product list is matched ");

		CommonFunctions.waitForVisiblity(step2ProceedButton, waitTime);
		step2ProceedButton.click();
		log.info("Step 2 tab :- click to 'Confirmation of order details' button");

	}

	// Order flow step 2 for prime
	public void comparePrimeDataOnOrderStep2(String primeName, String primePrice) throws Exception {

		String productNameSTR = primeName;
		String productPriceSTR = primePrice;

		CommonFunctions.waitForVisiblity(step2And3ProductNameLabel, waitTime);
		String step1And2And3ProductNameLabelString = step2And3ProductNameLabel.getText().trim();
		CommonFunctions.assertString(step1And2And3ProductNameLabelString, productNameSTR);
		log.info("Order Step 2 product name match with product name from product list page");

		CommonFunctions.waitForVisiblity(step2ProductPriceExcludingTaxLabelWithSymbol, waitTime);
		String step2ProductPriceExcludingTaxLabelWithSymbolSTR = step2ProductPriceExcludingTaxLabelWithSymbol.getText()
				.trim();
		String step2ProductPriceExcludingTaxLabelWithSymbol = step2ProductPriceExcludingTaxLabelWithSymbolSTR
				.replaceAll("円", "");
		int step2ProductPriceExcludingTaxLabelSTR = CommonFunctions
				.stringToInt(step2ProductPriceExcludingTaxLabelWithSymbol);
		log.info("Order Step 2 Price (excluding tax):- " + step2ProductPriceExcludingTaxLabelSTR);

		CommonFunctions.waitForVisiblity(step2ProductSubtotalLabelWithSymbol, waitTime);
		String step2ProductSubtotalLabelWithSymbolStringSTR = step2ProductSubtotalLabelWithSymbol.getText().trim();
		String step2ProductSubtotalLabelWithSymbolString = step2ProductSubtotalLabelWithSymbolStringSTR.replaceAll("円",
				"");
		int step2ProductSubtotalLabelSTR = CommonFunctions.stringToInt(step2ProductSubtotalLabelWithSymbolString);
		log.info("Order Step 2 Price Subtotal:- " + step2ProductSubtotalLabelSTR);

		// check Price (excluding tax) and subtotal is same or not
		CommonFunctions.assertInt(step2ProductPriceExcludingTaxLabelSTR, step2ProductSubtotalLabelSTR);
		log.info("Price (excluding tax) and subtotal have same amount");

		// expected Consumption tax 10% from subtotal
		CommonFunctions.waitForVisiblity(step2And3ProductNameLabelProductTAX10Per, waitTime);
		String step2ProductTAX10PerSymbolSTR = step2And3ProductNameLabelProductTAX10Per.getText().trim();
		String step2ProductTAX10PerForDecimalSTR = step2ProductTAX10PerSymbolSTR.substring(3, 5);
		String step2ProductTAX10PerDecimalSTR = "0." + step2ProductTAX10PerForDecimalSTR;
		log.info("step 2 product tax:- " + step2ProductTAX10PerDecimalSTR);

		Float tenPerTaxFloatValue = CommonFunctions.stringToFloat(step2ProductTAX10PerDecimalSTR);
		Float calculatedTenPerValue = step2ProductSubtotalLabelSTR * tenPerTaxFloatValue;
		float calculatedTenPerRoundedValue = BigDecimal.valueOf(calculatedTenPerValue)
				.setScale(0, BigDecimal.ROUND_HALF_DOWN).floatValue();
		int calculatedTenPerIntValue = CommonFunctions.floatToInt(calculatedTenPerRoundedValue);
		log.info("Order Step 2 Price rounded value:- " + calculatedTenPerIntValue);

		// calculate Consumption tax 10% from subtotal
		CommonFunctions.waitForVisiblity(step2ProductConsumptionTaxTenPerLabelWithSymbol, waitTime);
		String step2ProductConsumptionTaxTenPerLabelWithSymbolSTR = step2ProductConsumptionTaxTenPerLabelWithSymbol
				.getText().trim();
		String step2ProductConsumptionTaxTenPerLabelWithSymbolString = step2ProductConsumptionTaxTenPerLabelWithSymbolSTR
				.replaceAll("円", "");
		Float ExpectedTenPerTaxFloatValue = CommonFunctions
				.stringToFloat(step2ProductConsumptionTaxTenPerLabelWithSymbolString);
		int ExpectedTenPerTaxIntValue = CommonFunctions.floatToInt(ExpectedTenPerTaxFloatValue);
		log.info("Order Step 2 Price Consumption tax 10%:- " + ExpectedTenPerTaxIntValue);

		// check expected and actual Consumption tax 10%
		CommonFunctions.assertInt(calculatedTenPerIntValue, ExpectedTenPerTaxIntValue);
		log.info("expected and actual Consumption tax 10% values is matched");

		// addition of subtotal + Consumption tax 10%
		int expectedBilledAmountIntValue = CommonFunctions.additionOfInt(ExpectedTenPerTaxIntValue,
				step2ProductSubtotalLabelSTR);
		log.info("addition of subtotal + Consumption tax 10% is " + expectedBilledAmountIntValue);

		CommonFunctions.waitForVisiblity(step2ProductBilledAmountLabelWithSymbol, waitTime);
		String step2ProductBilledAmountLabelTrimSTR = step2ProductBilledAmountLabelWithSymbol.getText().trim();
		String step2ProductBilledAmountLabelString = step2ProductBilledAmountLabelTrimSTR.replaceAll("円", "");
		int step2ProductBilledAmountLabelSTR = CommonFunctions.stringToInt(step2ProductBilledAmountLabelString);
		log.info("Order Step 2 Billed amount:- " + step2ProductBilledAmountLabelSTR);

		////////////// check with assert
		// check expected Billed Amount and actual billed amount
		CommonFunctions.assertInt(expectedBilledAmountIntValue, step2ProductBilledAmountLabelSTR);
		log.info("expected Billed Amount and actual billed amount is matched ");

		int productPriceFromProductListPageInt = CommonFunctions.stringToInt(productPriceSTR);

		// check expected Billed Amount and amount came from product list
		CommonFunctions.assertInt(productPriceFromProductListPageInt, step2ProductBilledAmountLabelSTR);
		log.info("expected Billed Amount and amount came from product list is matched ");

		CommonFunctions.waitForVisiblity(registerYouCreditCardRadioButton, waitTime);
		registerYouCreditCardRadioButton.click();
		log.info("Step 2 tab :- click to 'Register your credit card information' radio button");

		// payment with valid credit card
		paymentWithValidCreditCardFromOrderPage();

		CommonFunctions.scrolltoElement(step2ProceedButton);
		CommonFunctions.isElementVisible(step2ProceedButton);
		CommonFunctions.waitForVisiblity(step2ProceedButton, waitTime);
		step2ProceedButton.click();
		log.info("Step 2 tab :- click to 'Confirmation of order details' button");

	}

	// method for valid credit card
	public void paymentWithValidCreditCardFromOrderPage() throws Exception {

		ExcelUtil excel = new ExcelUtil();
		excel.setExcelFile("NewTestData.xlsx", "CreditCardTestData");

		String ValidCreditCardNumerSTR = excel.getCellData("ValidCreditCardNumer", 1);
		String ExpirationMonthSTR = excel.getCellData("ExpirationMonth", 1);
		String ExpirationYearSTR = excel.getCellData("ExpirationYear", 1);
		String CreditCardHolderNameSTR = excel.getCellData("CreditCardHolderName", 1);
		String SecurityCodeSTR = excel.getCellData("SecurityCode", 1);

		CommonFunctions.waitForVisiblity(creditCardNumerTextbox, waitTime);

		creditCardNumerTextbox.sendKeys(ValidCreditCardNumerSTR);
		log.info("Step 2 tab :- provide card no to 'credit card number' textbox");

		CommonFunctions.waitForVisiblity(creditCardHolderNameTextbox, waitTime);
		creditCardHolderNameTextbox.sendKeys(CreditCardHolderNameSTR);
		log.info("Step 2 tab :- provide card holder name to 'card name' textbox");

		CommonFunctions.isElementVisible(ExpirationYearDropdown);

		CommonFunctions.waitForVisiblity(ExpirationYearDropdown, waitTime);
		ExpirationYearDropdown.click();
		log.info("Step 2 tab :- click on 'Expiration year' Dropdown");

		CommonFunctions.isElementVisible(listAllYearValue);

		List<WebElement> Yearlistings = driver.findElements(By.xpath("//ul[@id='select2-expire-year-results']/li"));
		int YearitemSize = Yearlistings.size();
		// String expectedYearValue = "2025";
		for (int i = 0; i < YearitemSize; i++) {
			// String yearoptionsValue = Yearlistings.get(i).getText();
			// match the content here in the if loop
			if (Yearlistings.get(i).getText().equals(ExpirationYearSTR)) {
				// perform action
				Yearlistings.get(i).click();
				break;

			}
		}

		CommonFunctions.scrolltoElement(securitycodeTextbox);
		CommonFunctions.waitForVisiblity(securitycodeTextbox, waitTime);
		CommonFunctions.waitForClickable(securitycodeTextbox, waitTime);

		securitycodeTextbox.sendKeys(SecurityCodeSTR);
		log.info("Step 2 tab :- provide security code to 'securitycode' textbox");

		CommonFunctions.waitForVisiblity(ExpirationMonthDropdown, waitTime);
		ExpirationMonthDropdown.click();
		log.info("Step 2 tab :- click on 'Expiration Month'Dropdown");

		CommonFunctions.isElementVisible(listAllMonthValue);

		List<WebElement> listings = driver.findElements(By.xpath("//ul[@id='select2-expire-month-results']/li"));
		int itemSize = listings.size();
		// String expectedMonthValue = "7月";
		for (int i = 0; i < itemSize; i++) {
			// String optionsValue = listings.get(i).getText();
			// match the content here in the if loop
			if (listings.get(i).getText().equals(ExpirationMonthSTR)) {
				// perform action
				listings.get(i).click();
				break;
			}
		}
		log.info("Step 2 tab :- provided valid credit card data");

	}

	// method for invalid credit card
	public void paymentWithInValidCreditCardFromOrderPage() throws Exception {

		ExcelUtil excel = new ExcelUtil();
		excel.setExcelFile("NewTestData.xlsx", "CreditCardTestData");

		String InValidCreditCardNumerSTR = excel.getCellData("InValidCreditCardNumer", 1);
		String ExpirationMonthSTR = excel.getCellData("ExpirationMonth", 1);
		String ExpirationYearSTR = excel.getCellData("ExpirationYear", 1);
		String CreditCardHolderNameSTR = excel.getCellData("CreditCardHolderName", 1);
		String SecurityCodeSTR = excel.getCellData("SecurityCode", 1);

		CommonFunctions.waitForVisiblity(creditCardNumerTextbox, waitTime);

		creditCardNumerTextbox.sendKeys(InValidCreditCardNumerSTR);
		log.info("Step 2 tab :- provide invalid card no to 'credit card number' textbox");

		CommonFunctions.waitForVisiblity(creditCardHolderNameTextbox, waitTime);
		creditCardHolderNameTextbox.sendKeys(CreditCardHolderNameSTR);
		log.info("Step 2 tab :- provide card holder name to 'card name' textbox");

		CommonFunctions.isElementVisible(ExpirationYearDropdown);

		CommonFunctions.waitForVisiblity(ExpirationYearDropdown, waitTime);
		ExpirationYearDropdown.click();
		log.info("Step 2 tab :- click on 'Expiration year' Dropdown");

		CommonFunctions.isElementVisible(listAllYearValue);

		List<WebElement> Yearlistings = driver.findElements(By.xpath("//ul[@id='select2-expire-year-results']/li"));
		int YearitemSize = Yearlistings.size();
		// String expectedYearValue = "2025";
		for (int i = 0; i < YearitemSize; i++) {
			// String yearoptionsValue = Yearlistings.get(i).getText();

			// match the content here in the if loop
			if (Yearlistings.get(i).getText().equals(ExpirationYearSTR)) {
				// perform action
				Yearlistings.get(i).click();
				break;

			}
		}

		CommonFunctions.scrolltoElement(securitycodeTextbox);
		CommonFunctions.waitForVisiblity(securitycodeTextbox, waitTime);
		CommonFunctions.waitForClickable(securitycodeTextbox, waitTime);

		securitycodeTextbox.sendKeys(SecurityCodeSTR);
		log.info("Step 2 tab :- provide security code to 'securitycode' textbox");

		CommonFunctions.waitForVisiblity(ExpirationMonthDropdown, waitTime);
		ExpirationMonthDropdown.click();
		log.info("Step 2 tab :- click on 'Expiration Month'Dropdown");

		CommonFunctions.isElementVisible(listAllMonthValue);

		List<WebElement> listings = driver.findElements(By.xpath("//ul[@id='select2-expire-month-results']/li"));
		int itemSize = listings.size();
		// String expectedMonthValue = "7月";
		for (int i = 0; i < itemSize; i++) {
			// String optionsValue = listings.get(i).getText();
			// match the content here in the if loop
			if (listings.get(i).getText().equals(ExpirationMonthSTR)) {
				// perform action
				listings.get(i).click();
				break;
			}
		}
		log.info("Step 2 tab :- provided invalid credit card data");

	}

	// Order flow step 3
	public void compareProductDataOnOrderStep3(String productNameFromProductListPage,
			String productPriceFromProductListPage) throws Exception {

		String productNameFromProductListPageSTR = productNameFromProductListPage;
		String productPriceFromProductListPageSTR = productPriceFromProductListPage;

		CommonFunctions.waitForVisiblity(step2And3ProductNameLabel, waitTime);
		String step1And2And3ProductNameLabelString = step2And3ProductNameLabel.getText().trim();
		CommonFunctions.assertString(step1And2And3ProductNameLabelString, productNameFromProductListPageSTR);
		log.info("Order Step 3 product name match with product name from product list page");

		CommonFunctions.waitForVisiblity(step3ProductPriceExcludingTaxLabelWithSymbol, waitTime);
		String step3ProductPriceExcludingTaxLabelWithSymbolSTR = step3ProductPriceExcludingTaxLabelWithSymbol.getText()
				.trim();
		String step3ProductPriceExcludingTaxLabel = step3ProductPriceExcludingTaxLabelWithSymbolSTR.replaceAll("円", "");
		int step3ProductPriceExcludingTaxLabelSTR = CommonFunctions.stringToInt(step3ProductPriceExcludingTaxLabel);
		log.info("Order Step 3 Price (excluding tax):- " + step3ProductPriceExcludingTaxLabelSTR);

		CommonFunctions.waitForVisiblity(step3ProductSubtotalLabelWithSymbol, waitTime);
		String step3ProductSubtotalLabelWithSymbolStringSTR = step3ProductSubtotalLabelWithSymbol.getText().trim();
		String step3ProductSubtotalLabelWithSymbolString = step3ProductSubtotalLabelWithSymbolStringSTR.replaceAll("円",
				"");
		int step3ProductSubtotalLabelSTR = CommonFunctions.stringToInt(step3ProductSubtotalLabelWithSymbolString);
		log.info("Order Step 3 Price Subtotal:- " + step3ProductSubtotalLabelSTR);

		// check Price (excluding tax) and subtotal is same or not
		CommonFunctions.assertInt(step3ProductPriceExcludingTaxLabelSTR, step3ProductSubtotalLabelSTR);
		log.info("Price (excluding tax) and subtotal have same amount");

		// expected Consumption tax 10% from subtotal

		CommonFunctions.waitForVisiblity(step2And3ProductNameLabelProductTAX10Per, waitTime);
		String step3ProductTAX10PerSymbolSTR = step2And3ProductNameLabelProductTAX10Per.getText().trim();
		String step3ProductTAX10PerForDecimalSTR = step3ProductTAX10PerSymbolSTR.substring(3, 5);
		String step3ProductTAX10PerDecimalSTR = "0." + step3ProductTAX10PerForDecimalSTR;
		log.info("step 3 product tax:- " + step3ProductTAX10PerDecimalSTR);
		Float tenPerTaxFloatValue = CommonFunctions.stringToFloat(step3ProductTAX10PerDecimalSTR);
		Float calculatedTenPerValue = step3ProductPriceExcludingTaxLabelSTR * tenPerTaxFloatValue;
		Float calculatedTenPerRoundedValue = (float) Math.round(calculatedTenPerValue);
		int calculatedTenPerIntValue = CommonFunctions.floatToInt(calculatedTenPerRoundedValue);
		log.info("Order Step 3 Price rounded value:- " + calculatedTenPerIntValue);

		// calculate Consumption tax 10% from subtotal
		CommonFunctions.waitForVisiblity(step3ProductConsumptionTaxTenPerLabelWithSymbol, waitTime);
		String step3ProductConsumptionTaxTenPerLabelWithSymbolSTR = step3ProductConsumptionTaxTenPerLabelWithSymbol
				.getText().trim();
		String step3ProductConsumptionTaxTenPerLabelString = step3ProductConsumptionTaxTenPerLabelWithSymbolSTR
				.replaceAll("円", "");
		Float ExpectedTenPerTaxFloatValue = CommonFunctions.stringToFloat(step3ProductConsumptionTaxTenPerLabelString);
		int ExpectedTenPerTaxIntValue = CommonFunctions.floatToInt(ExpectedTenPerTaxFloatValue);
		log.info("Order Step 3 Price Consumption tax 10%:- " + ExpectedTenPerTaxIntValue);

		// check expected and actual Consumption tax 10%
		CommonFunctions.assertInt(calculatedTenPerIntValue, ExpectedTenPerTaxIntValue);
		log.info("expected and actual Consumption tax 10% values is matched");

		// addition of subtotal + Consumption tax 10%
		int expectedBilledAmountIntValue = CommonFunctions.additionOfInt(ExpectedTenPerTaxIntValue,
				step3ProductSubtotalLabelSTR);
		log.info("addition of subtotal + Consumption tax 10% is " + expectedBilledAmountIntValue);

		CommonFunctions.waitForVisiblity(step3ProductBilledAmountLabelWithSymbol, waitTime);
		String step3ProductBilledAmountLabelTrimSTR = step3ProductBilledAmountLabelWithSymbol.getText().trim();
		String step3ProductBilledAmountLabelString = step3ProductBilledAmountLabelTrimSTR.replaceAll("円", "");
		int step3ProductBilledAmountLabelSTR = CommonFunctions.stringToInt(step3ProductBilledAmountLabelString);
		log.info("Order Step 3 Billed amount:- " + step3ProductBilledAmountLabelSTR);

		////////////// check with assert
		// check expected Billed Amount and actual billed amount
		CommonFunctions.assertInt(expectedBilledAmountIntValue, step3ProductBilledAmountLabelSTR);
		log.info("expected Billed Amount and actual billed amount is matched ");

		int productPriceFromProductListPageInt = CommonFunctions.stringToInt(productPriceFromProductListPageSTR);

		// check expected Billed Amount and amount came from product list
		CommonFunctions.assertInt(productPriceFromProductListPageInt, step3ProductBilledAmountLabelSTR);
		log.info("expected Billed Amount and amount came from product list is matched ");

		CommonFunctions.scrolltoElement(step3ConfirmOrderButton);
		CommonFunctions.waitForVisiblity(step3ConfirmOrderButton, waitTime);
		step3ConfirmOrderButton.click();
		log.info("Step 3 tab :- click to 'Confirm the order' button");

	}

	// Order flow step 3 for prime
	public void comparePrimeDataOnOrderStep3(String primeName, String primePrice) throws Exception {

		String productNameSTR = primeName;
		String productPriceSTR = primePrice;

		CommonFunctions.waitForVisiblity(step2And3ProductNameLabel, waitTime);
		String step1And2And3ProductNameLabelString = step2And3ProductNameLabel.getText().trim();
		CommonFunctions.assertString(step1And2And3ProductNameLabelString, productNameSTR);
		log.info("Order Step 3 product name match with product name from product list page");

		CommonFunctions.waitForVisiblity(step3ProductPriceExcludingTaxLabelWithSymbol, waitTime);
		String step3ProductPriceExcludingTaxLabelWithSymbolSTR = step3ProductPriceExcludingTaxLabelWithSymbol.getText()
				.trim();
		String step3ProductPriceExcludingTaxLabel = step3ProductPriceExcludingTaxLabelWithSymbolSTR.replaceAll("円", "");
		int step3ProductPriceExcludingTaxLabelSTR = CommonFunctions.stringToInt(step3ProductPriceExcludingTaxLabel);
		log.info("Order Step 3 Price (excluding tax):- " + step3ProductPriceExcludingTaxLabelSTR);

		CommonFunctions.waitForVisiblity(step3ProductSubtotalLabelWithSymbol, waitTime);
		String step3ProductSubtotalLabelWithSymbolStringSTR = step3ProductSubtotalLabelWithSymbol.getText().trim();
		String step3ProductSubtotalLabelWithSymbolString = step3ProductSubtotalLabelWithSymbolStringSTR.replaceAll("円",
				"");
		int step3ProductSubtotalLabelSTR = CommonFunctions.stringToInt(step3ProductSubtotalLabelWithSymbolString);
		log.info("Order Step 3 Price Subtotal:- " + step3ProductSubtotalLabelSTR);

		// check Price (excluding tax) and subtotal is same or not
		CommonFunctions.assertInt(step3ProductPriceExcludingTaxLabelSTR, step3ProductSubtotalLabelSTR);
		log.info("Price (excluding tax) and subtotal have same amount");

		// expected Consumption tax 10% from subtotal

		CommonFunctions.waitForVisiblity(step2And3ProductNameLabelProductTAX10Per, waitTime);
		String step3ProductTAX10PerSymbolSTR = step2And3ProductNameLabelProductTAX10Per.getText().trim();
		String step3ProductTAX10PerForDecimalSTR = step3ProductTAX10PerSymbolSTR.substring(3, 5);
		String step3ProductTAX10PerDecimalSTR = "0." + step3ProductTAX10PerForDecimalSTR;
		log.info("step 3 product tax:- " + step3ProductTAX10PerDecimalSTR);

		Float tenPerTaxFloatValue = CommonFunctions.stringToFloat(step3ProductTAX10PerDecimalSTR);
		Float calculatedTenPerValue = step3ProductSubtotalLabelSTR * tenPerTaxFloatValue;
		float calculatedTenPerRoundedValue = BigDecimal.valueOf(calculatedTenPerValue)
				.setScale(0, BigDecimal.ROUND_HALF_DOWN).floatValue();
		int calculatedTenPerIntValue = CommonFunctions.floatToInt(calculatedTenPerRoundedValue);
		log.info("Order Step 3 Price rounded value:- " + calculatedTenPerIntValue);

		// calculate Consumption tax 10% from subtotal
		CommonFunctions.waitForVisiblity(step3ProductConsumptionTaxTenPerLabelWithSymbol, waitTime);
		String step3ProductConsumptionTaxTenPerLabelWithSymbolSTR = step3ProductConsumptionTaxTenPerLabelWithSymbol
				.getText().trim();
		String step3ProductConsumptionTaxTenPerLabelString = step3ProductConsumptionTaxTenPerLabelWithSymbolSTR
				.replaceAll("円", "");
		Float ExpectedTenPerTaxFloatValue = CommonFunctions.stringToFloat(step3ProductConsumptionTaxTenPerLabelString);
		int ExpectedTenPerTaxIntValue = CommonFunctions.floatToInt(ExpectedTenPerTaxFloatValue);
		log.info("Order Step 3 Price Consumption tax 10%:- " + ExpectedTenPerTaxIntValue);

		// check expected and actual Consumption tax 10%
		CommonFunctions.assertInt(calculatedTenPerIntValue, ExpectedTenPerTaxIntValue);
		log.info("expected and actual Consumption tax 10% values is matched");

		// addition of subtotal + Consumption tax 10%
		int expectedBilledAmountIntValue = CommonFunctions.additionOfInt(ExpectedTenPerTaxIntValue,
				step3ProductSubtotalLabelSTR);
		log.info("addition of subtotal + Consumption tax 10% is " + expectedBilledAmountIntValue);

		CommonFunctions.waitForVisiblity(step3ProductBilledAmountLabelWithSymbol, waitTime);
		String step3ProductBilledAmountLabelTrimSTR = step3ProductBilledAmountLabelWithSymbol.getText().trim();
		String step3ProductBilledAmountLabelString = step3ProductBilledAmountLabelTrimSTR.replaceAll("円", "");
		int step3ProductBilledAmountLabelSTR = CommonFunctions.stringToInt(step3ProductBilledAmountLabelString);
		log.info("Order Step 3 Billed amount:- " + step3ProductBilledAmountLabelSTR);

		////////////// check with assert
		// check expected Billed Amount and actual billed amount
		CommonFunctions.assertInt(expectedBilledAmountIntValue, step3ProductBilledAmountLabelSTR);
		log.info("expected Billed Amount and actual billed amount is matched ");

		int productPriceFromProductListPageInt = CommonFunctions.stringToInt(productPriceSTR);

		// check expected Billed Amount and amount came from product list
		CommonFunctions.assertInt(productPriceFromProductListPageInt, step3ProductBilledAmountLabelSTR);
		log.info("expected Billed Amount and amount came from product list is matched ");

		CommonFunctions.scrolltoElement(step3ConfirmOrderButton);
		CommonFunctions.waitForVisiblity(step3ConfirmOrderButton, waitTime);
		step3ConfirmOrderButton.click();
		log.info("Step 3 tab :- click to 'Confirm the order' button");

	}

	// payment with valid credit card
	public void verifyPaymentWithValidCreditCardFromStep2() throws Exception {
		CommonFunctions.isElementVisible(step2ProceedButton);

		CommonFunctions.waitForVisiblity(registerYouCreditCardRadioButton, waitTime);
		registerYouCreditCardRadioButton.click();
		log.info("Step 2 tab :- click to 'Register your credit card information' radio button");

		// payment with valid credit card
		paymentWithValidCreditCardFromOrderPage();

		CommonFunctions.scrolltoElement(step2ProceedButton);
		CommonFunctions.waitForVisiblity(step2ProceedButton, waitTime);
		step2ProceedButton.click();
		log.info("Step 2 tab :- click to 'Confirmation of order details' button");
	}

	// payment with in valid credit card
	public void verifyPaymentWithInValidCreditCardFromStep2() throws Exception {

		ExcelUtil excel = new ExcelUtil();
		excel.setExcelFile("NewTestData.xlsx", "Order");

		CommonFunctions.isElementVisible(step2ProceedButton);
		CommonFunctions.waitForVisiblity(registerYouCreditCardRadioButton, waitTime);
		registerYouCreditCardRadioButton.click();
		log.info("Step 2 tab :- click to 'Register your credit card information' radio button");

		// payment with invalid credit card
		paymentWithInValidCreditCardFromOrderPage();

		CommonFunctions.scrolltoElement(step2ProceedButton);
		CommonFunctions.waitForVisiblity(step2ProceedButton, waitTime);
		step2ProceedButton.click();
		log.info("Step 2 tab :- click to 'Confirmation of order details' button");

		CommonFunctions.isElementVisible(invalidCreditCardTextHandler);
		String invalidCreditCardText = invalidCreditCardTextHandler.getText().trim();
		String expectedInvalidCreditCardText = excel.getCellData("expectedInvalidCreditCardText", 1);
		CommonFunctions.assertString(invalidCreditCardText, expectedInvalidCreditCardText);
		log.info("The invalid credit card message match with our expected message");
	}

	// payment with in blank credit card
	public void verifyPaymentWithBlankCreditCardFromStep2() throws Exception {
		ExcelUtil excel = new ExcelUtil();
		excel.setExcelFile("NewTestData.xlsx", "Order");

		CommonFunctions.isElementVisible(step2ProceedButton);

		CommonFunctions.waitForVisiblity(registerYouCreditCardRadioButton, waitTime);
		registerYouCreditCardRadioButton.click();
		log.info("Step 2 tab :- click to 'Register your credit card information' radio button");

		CommonFunctions.isElementVisible(step2ProceedButton);
		CommonFunctions.waitForVisiblity(step2ProceedButton, waitTime);
		step2ProceedButton.click();
		log.info("Step 2 tab :- click to 'Confirmation of order details' button");

		String expectedBlankCreditCardText = excel.getCellData("expectedBlankCreditCardText", 1);
		CommonFunctions.isElementVisible(blankCardNoTextHandler);
		String blankCardNoTextHandlerString = blankCardNoTextHandler.getText().trim();
		CommonFunctions.assertString(blankCardNoTextHandlerString, expectedBlankCreditCardText);
		log.info("The card no message match with our expected message");

		CommonFunctions.isElementVisible(blankMonthYearCardTextHandler);
		String blankMonthYearCardTextHandlerString = blankMonthYearCardTextHandler.getText().trim();
		CommonFunctions.assertString(blankMonthYearCardTextHandlerString, expectedBlankCreditCardText);
		log.info("The month and year message match with our expected message");

		CommonFunctions.isElementVisible(blankCardNameTextHandler);
		String blankCardNameTextHandlerString = blankCardNameTextHandler.getText().trim();
		CommonFunctions.assertString(blankCardNameTextHandlerString, expectedBlankCreditCardText);
		log.info("The card name message match with our expected message");

		CommonFunctions.isElementVisible(BlankSecurityCodeTextHandler);
		String BlankSecurityCodeTextHandlerString = BlankSecurityCodeTextHandler.getText().trim();
		CommonFunctions.assertString(BlankSecurityCodeTextHandlerString, expectedBlankCreditCardText);
		log.info("The security code message match with our expected message");
	}

	// payment with valid con store
	public void verifyPaymentWithValidConStoreFromStep2() throws Exception {
		ExcelUtil excel = new ExcelUtil();
		excel.setExcelFile("NewTestData.xlsx", "Order");
		String validConStoreKanjiNameSTR = excel.getCellData("validConStoreKanjiName", 1);
		String validConStoreKanaNameSTR = excel.getCellData("validConStoreKanaName", 1);
		String validConStorePhonenoSTR = excel.getCellData("validConStorePhoneno", 1);
		String validConStoreEmailAddressSTR = excel.getCellData("validConStoreEmailAddress", 1);

		CommonFunctions.isElementVisible(step2ProceedButton);

		CommonFunctions.waitForVisiblity(convenienceStorePaymentRadioButton, waitTime);
		convenienceStorePaymentRadioButton.click();
		log.info("Step 2 tab :- click to 'convenience Store Payment' radio button");

		CommonFunctions.waitForVisiblity(lawsonRadioButton, waitTime);
		lawsonRadioButton.click();
		log.info("Step 2 tab :- click to 'lawson' radio button");

		CommonFunctions.waitForVisiblity(kanjiNameTextbox, waitTime);
		kanjiNameTextbox.clear();
		kanjiNameTextbox.sendKeys(validConStoreKanjiNameSTR);
		log.info("Step 2 tab :- provide name 'kanji Name' textbox");

		CommonFunctions.waitForVisiblity(kanaNameTextbox, waitTime);
		kanaNameTextbox.clear();
		kanaNameTextbox.sendKeys(validConStoreKanaNameSTR);
		log.info("Step 2 tab :- provide name 'kana Name' textbox");

		CommonFunctions.waitForVisiblity(phonenoTextbox, waitTime);
		phonenoTextbox.clear();
		phonenoTextbox.sendKeys(validConStorePhonenoSTR);
		log.info("Step 2 tab :- provide phone no 'phone no' textbox");

		CommonFunctions.waitForVisiblity(emailaddressTextbox, waitTime);
		emailaddressTextbox.clear();
		emailaddressTextbox.sendKeys(validConStoreEmailAddressSTR);
		log.info("Step 2 tab :- provide email to 'email address' textbox");

		CommonFunctions.isElementVisible(step2ProceedButton);
		CommonFunctions.waitForVisiblity(step2ProceedButton, waitTime);
		step2ProceedButton.click();
		log.info("Step 2 tab :- click to 'Confirmation of order details' button");
	}

	// payment with invalid con store
	public void verifyPaymentWithInValidConStoreFromStep2() throws Exception {

		ExcelUtil excel = new ExcelUtil();
		excel.setExcelFile("NewTestData.xlsx", "Order");
		String validConStoreKanjiNameSTR = excel.getCellData("validConStoreKanjiName", 1);
		String validConStoreKanaNameSTR = excel.getCellData("validConStoreKanaName", 1);
		String validConStorePhonenoSTR = excel.getCellData("validConStorePhoneno", 1);
		String InValidConStoreEmailAddressSTR = excel.getCellData("InValidConStoreEmailAddress", 1);
		String expectedinvalidEmailConStoreText = excel.getCellData("expectedinvalidEmailConStoreText", 1);

		CommonFunctions.isElementVisible(step2ProceedButton);

		CommonFunctions.waitForVisiblity(convenienceStorePaymentRadioButton, waitTime);
		convenienceStorePaymentRadioButton.click();
		log.info("Step 2 tab :- click to 'convenience Store Payment' radio button");

		CommonFunctions.waitForVisiblity(lawsonRadioButton, waitTime);
		lawsonRadioButton.click();
		log.info("Step 2 tab :- click to 'lawson' radio button");

		CommonFunctions.waitForVisiblity(kanjiNameTextbox, waitTime);
		kanjiNameTextbox.clear();
		kanjiNameTextbox.sendKeys(validConStoreKanjiNameSTR);
		log.info("Step 2 tab :- provide name 'kanji Name' textbox");

		CommonFunctions.waitForVisiblity(kanaNameTextbox, waitTime);
		kanaNameTextbox.clear();
		kanaNameTextbox.sendKeys(validConStoreKanaNameSTR);
		log.info("Step 2 tab :- provide name 'kana Name' textbox");

		CommonFunctions.waitForVisiblity(phonenoTextbox, waitTime);
		phonenoTextbox.clear();
		phonenoTextbox.sendKeys(validConStorePhonenoSTR);
		log.info("Step 2 tab :- provide phone no 'phone no' textbox");

		CommonFunctions.waitForVisiblity(emailaddressTextbox, waitTime);
		emailaddressTextbox.clear();
		emailaddressTextbox.sendKeys(InValidConStoreEmailAddressSTR);
		log.info("Step 2 tab :- provide email to 'email address' textbox");

		CommonFunctions.isElementVisible(step2ProceedButton);
		CommonFunctions.waitForVisiblity(step2ProceedButton, waitTime);
		step2ProceedButton.click();
		log.info("Step 2 tab :- click to 'Confirmation of order details' button");

		CommonFunctions.waitForVisiblity(invalidConStoreEmailTextHandler, waitTime);
		String invalidEmailConStoreText = invalidConStoreEmailTextHandler.getText().trim();
		CommonFunctions.assertString(invalidEmailConStoreText, expectedinvalidEmailConStoreText);
		log.info("The invalid email address of con store message match with our expected message");
	}

	// payment with blank con store
	public void verifyPaymentWithBlankConStoreFromStep2() throws Exception {

		ExcelUtil excel = new ExcelUtil();
		excel.setExcelFile("NewTestData.xlsx", "Order");
		String expectedBlankConStoreText = excel.getCellData("expectedBlankConStoreText", 1);
		String expectedKanaConStoreText = excel.getCellData("expectedKanaConStoreText", 1);
		String expectedTelePhoneConStoreText = excel.getCellData("expectedTelePhoneConStoreText", 1);

		CommonFunctions.waitForVisiblity(step2ProceedButton, waitTime);

		CommonFunctions.waitForVisiblity(convenienceStorePaymentRadioButton, waitTime);
		convenienceStorePaymentRadioButton.click();
		log.info("Step 2 tab :- click to 'convenience Store Payment' radio button");

		CommonFunctions.waitForVisiblity(lawsonRadioButton, waitTime);
		lawsonRadioButton.click();
		log.info("Step 2 tab :- click to 'lawson' radio button");

		CommonFunctions.waitForVisiblity(kanjiNameTextbox, waitTime);
		kanjiNameTextbox.clear();
		log.info("Step 2 tab :- clear 'kanji Name' textbox value");

		CommonFunctions.waitForVisiblity(kanaNameTextbox, waitTime);
		kanaNameTextbox.clear();
		log.info("Step 2 tab :- clear 'kana Name' textbox value");

		CommonFunctions.waitForVisiblity(phonenoTextbox, waitTime);
		phonenoTextbox.clear();
		log.info("Step 2 tab :- clear phone no 'phone no' textbox value");

		CommonFunctions.waitForVisiblity(emailaddressTextbox, waitTime);
		emailaddressTextbox.clear();
		log.info("Step 2 tab :- clear 'email address' textbox value");

		CommonFunctions.isElementVisible(step2ProceedButton);
		CommonFunctions.waitForVisiblity(step2ProceedButton, waitTime);
		step2ProceedButton.click();
		log.info("Step 2 tab :- click to 'Confirmation of order details' button");

		CommonFunctions.waitForVisiblity(blankKanjiNameTextHandler, waitTime);
		String blankKanjiNameTextHandlerString = blankKanjiNameTextHandler.getText().trim();
		CommonFunctions.assertString(expectedBlankConStoreText, blankKanjiNameTextHandlerString);
		log.info("The blank Kanji Name message match with our expected message");

		CommonFunctions.waitForVisiblity(blankKanaNameTextHandler, waitTime);
		String blankKanaNameTextHandlerString = blankKanaNameTextHandler.getText().trim();
		CommonFunctions.assertString(expectedKanaConStoreText, blankKanaNameTextHandlerString);
		log.info("The blank Kana Name message match with our expected message");

		CommonFunctions.waitForVisiblity(blankPhonenoTextHandler, waitTime);
		String blankPhonenoTextHandlerString = blankPhonenoTextHandler.getText().trim();
		CommonFunctions.assertString(expectedTelePhoneConStoreText, blankPhonenoTextHandlerString);
		log.info("The blank telephone number Name message match with our expected message");
	}

	public String[] verifyConStoreThankYouPage() throws Exception {

		// thank you page
		CommonFunctions.waitForVisiblity(step4ThankYouForYourPurchaseLabel, waitTime);
		String thankYouForYourApplicationLabelSTR = step4ThankYouForYourPurchaseLabel.getText().trim();
		log.info("Step 4 tab :- thank You For Your Application text visible:- " + thankYouForYourApplicationLabelSTR);

		CommonFunctions.waitForVisiblity(customerNumberLabel, waitTime);
		String customerNumberLabelSTR = customerNumberLabel.getText().trim();
		log.info("Step 4 tab :- Customer Number text visible:- " + customerNumberLabelSTR);

		CommonFunctions.waitForVisiblity(convenienceStoreLabel, waitTime);
		String convenienceStoreLabelSTR = convenienceStoreLabel.getText().trim();
		log.info("Step 4 tab :- convenience store text visible:- " + convenienceStoreLabelSTR);

		CommonFunctions.waitForVisiblity(authorizationNumberLabel, waitTime);
		String authorizationNumberLabelSTR = authorizationNumberLabel.getText().trim();
		log.info("Step 4 tab :- Authorization number text visible:- " + authorizationNumberLabelSTR);

		CommonFunctions.waitForVisiblity(paymentDeadlineLabel, waitTime);
		String paymentDeadlineLabelSTR = paymentDeadlineLabel.getText().trim();
		log.info("Step 4 tab :- Payment deadline text visible:- " + paymentDeadlineLabelSTR);

		String removeJapword1 = paymentDeadlineLabelSTR.substring(0, 10);
		String removeJapword2 = removeJapword1.replaceAll("年", "/");
		String paymentDeadlineCompareSTR = removeJapword2.replaceAll("月", "/");
		log.info("Step 4 tab :- Payment deadline text capture for compare with order history page:- "
				+ paymentDeadlineCompareSTR);

		CommonFunctions.waitForVisiblity(orderNumberLabel, waitTime);
		String orderNumberLabelSTR = orderNumberLabel.getText().trim();
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

	public void verifyConStoreThankYouPageDataOnOrderHistoryPage(String thankYouPagePaymentDeadlineSTR,
			String thankYouPageorderNumberLabelSTR) throws Exception {

		String expectedThankYouPagePaymentDeadlineSTR = thankYouPagePaymentDeadlineSTR;
		String expectedThankYouPageorderNumberLabelSTR = thankYouPageorderNumberLabelSTR;

		ExcelUtil excel = new ExcelUtil();
		excel.setExcelFile("NewTestData.xlsx", "Order");
		String expectedBuyAgainButton = excel.getCellData("OrderHistoryPageExpectedBuyAgainButton", 1);
		String expectedStatusPaymentUnconfirmed = excel.getCellData("OrderHistoryPageExpectedStatusPaymentUnconfirmed",
				1);

		log.info("Store Payment Deadline from ConStoreThankYouPage:- " + expectedThankYouPagePaymentDeadlineSTR);
		log.info("Store Order Number from ConStoreThankYouPage:- " + expectedThankYouPageorderNumberLabelSTR);

		CommonFunctions.waitForVisiblity(checkOrderHistoryLink, waitTime);
		checkOrderHistoryLink.click();

		CommonFunctions.waitForVisiblity(orderHistoryPaymentDeadlineLabel, waitTime);
		String orderHistoryPaymentDeadlineLabelForTrim = orderHistoryPaymentDeadlineLabel.getText();
		String orderHistoryPaymentDeadlineLabelSTR = orderHistoryPaymentDeadlineLabelForTrim.substring(5, 15);
		log.info("Order history page:- actual Payment deadline date " + orderHistoryPaymentDeadlineLabelSTR);
		CommonFunctions.assertString(expectedThankYouPagePaymentDeadlineSTR, orderHistoryPaymentDeadlineLabelSTR);

		CommonFunctions.waitForVisiblity(orderHistoryBuyAgainButton, waitTime);
		String orderHistoryBuyAgainButtonSTR = orderHistoryBuyAgainButton.getText();
		log.info("Order history page:- buy again button visible " + orderHistoryBuyAgainButtonSTR);
		CommonFunctions.assertString(expectedBuyAgainButton, orderHistoryBuyAgainButtonSTR);

		CommonFunctions.waitForVisiblity(orderHistoryOrderNumberLabel, waitTime);
		String orderHistoryOrderNumberLabeltrim = orderHistoryOrderNumberLabel.getText();
		String orderHistoryOrderNumberLabelSTR = orderHistoryOrderNumberLabeltrim.substring(7, 31);
		log.info("Order history page:- order number is " + orderHistoryOrderNumberLabelSTR);
		CommonFunctions.assertString(expectedThankYouPageorderNumberLabelSTR, orderHistoryOrderNumberLabelSTR);

		CommonFunctions.waitForVisiblity(orderHistoryPaymentStatusLabel, waitTime);
		String orderHistoryPaymentStatusLabelSTR = orderHistoryPaymentStatusLabel.getText();
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

	public String[] verifyCreditCardThankYouPage() throws Exception {

		ExcelUtil excel = new ExcelUtil();
		excel.setExcelFile("NewTestData.xlsx", "Order");
		String expectedThankYouForYourApplicationLabelSTR = excel
				.getCellData("ThankYouPageThankYouForYourApplicationLabel", 1);
		String expectedstartNowButtonSTR = excel.getCellData("startNowButtonSTRStartNowButton", 1);

		// thank you page
		CommonFunctions.waitForVisiblity(thankYouForYourApplicationCreditCardLabel, waitTime);

		String ThankYouForYourApplicationLabelSTR = thankYouForYourApplicationCreditCardLabel.getText();

		log.info("Step 4 tab :- thank You For Your Application text visible:- " + ThankYouForYourApplicationLabelSTR);
		CommonFunctions.assertString(ThankYouForYourApplicationLabelSTR, expectedThankYouForYourApplicationLabelSTR);

		CommonFunctions.waitForVisiblity(orderNumberCreditCardLabel, waitTime);
		String orderNumberCreditCardLabelSTR = orderNumberCreditCardLabel.getText();
		log.info("Step 4 tab :- Order number text visible:- " + orderNumberCreditCardLabelSTR);

		CommonFunctions.waitForVisiblity(checkOrderHistoryLink, waitTime);
		log.info("Step 4 tab :- order history link visible");

		CommonFunctions.waitForVisiblity(StartNowButton, waitTime);
		String startNowButtonSTR = StartNowButton.getText();

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

	public String[] verifyPrimeThankYouPage() throws Exception {
		ExcelUtil excel = new ExcelUtil();
		excel.setExcelFile("NewTestData.xlsx", "Order");
		String expectedThankYouForPrimeLabelSTR = excel.getCellData("ThankYouPageThankYouForPrimeLabel", 1);
		String expectedTopPageButtonSTR = excel.getCellData("ThankYouPageTopPageButton", 1);

		// thank you page
		CommonFunctions.waitForVisiblity(thankYouForYourApplicationPrimeLabel, waitTime);
		// stringToCompare = thankYouForYourApplicationCreditCardLabel.getText();
		String ThankYouForYourApplicationLabelForTrim = thankYouForYourApplicationPrimeLabel.getText().trim();
		String ThankYouForYourApplicationLabelSTR = ThankYouForYourApplicationLabelForTrim.substring(0, 11);
		log.info("Step 4 tab :- thank You For Your Application text visible:- " + ThankYouForYourApplicationLabelSTR);
		CommonFunctions.assertString(ThankYouForYourApplicationLabelSTR, expectedThankYouForPrimeLabelSTR);

		CommonFunctions.waitForVisiblity(orderNumberPrimeLabel, waitTime);
		String orderNumberPrimeLabelSTR = orderNumberPrimeLabel.getText();
		log.info("Step 4 tab :- Order number text visible:- " + orderNumberPrimeLabelSTR);

		CommonFunctions.waitForVisiblity(checkOrderHistoryLink, waitTime);
		log.info("Step 4 tab :- order history link visible");

		CommonFunctions.waitForVisiblity(thankYouPageTopPageButton, waitTime);
		String thankYouPageTopPageButtonSTR = thankYouPageTopPageButton.getText();
		log.info("Step 4 tab :- start now button visible:- " + thankYouPageTopPageButtonSTR);
		CommonFunctions.assertString(expectedTopPageButtonSTR, thankYouPageTopPageButtonSTR);

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
		String[] ret_Array = { orderNumberPrimeLabelSTR };
		// return string array
		return ret_Array;
	}

	public void verifyCreditCardThankYouPageDataOnOrderHistoryPage(String orderNumberLabelSTR) throws Exception {

		String expectedOrderNumberLabelSTR = orderNumberLabelSTR;

		ExcelUtil excel = new ExcelUtil();
		excel.setExcelFile("NewTestData.xlsx", "Order");
		String expectedBuyAgainButton = excel.getCellData("OrderHistoryPageExpectedBuyAgainButton", 1);
		String expectedStatusPaymentconfirmed = excel.getCellData("OrderHistoryPageStatusPaymentconfirmed", 1);

		log.info("Store Order Number from CreditCardThankYouPage:- " + expectedOrderNumberLabelSTR);

		CommonFunctions.waitForVisiblity(checkOrderHistoryLink, waitTime);
		checkOrderHistoryLink.click();

		CommonFunctions.waitForVisiblity(orderHistoryBuyAgainButton, waitTime);
		String orderHistoryBuyAgainButtonSTR = orderHistoryBuyAgainButton.getText();
		log.info("Order history page:- buy again button visible " + orderHistoryBuyAgainButtonSTR);
		CommonFunctions.assertString(expectedBuyAgainButton, orderHistoryBuyAgainButtonSTR);

		CommonFunctions.waitForVisiblity(orderHistoryOrderNumberLabel, waitTime);
		String orderHistoryOrderNumberLabelforTrim = orderHistoryOrderNumberLabel.getText().trim();
		String orderHistoryOrderNumberLabelSTR = orderHistoryOrderNumberLabelforTrim.substring(7, 31);
		log.info("Order history page:- order number is " + orderHistoryOrderNumberLabelSTR);
		CommonFunctions.assertString(expectedOrderNumberLabelSTR, orderHistoryOrderNumberLabelSTR);

		CommonFunctions.waitForVisiblity(orderHistoryPaymentStatusLabel, waitTime);
		String orderHistoryPaymentStatusLabelSTR = orderHistoryPaymentStatusLabel.getText();
		log.info("Order history page:- payment status is Payment confirmed " + expectedStatusPaymentconfirmed);
		CommonFunctions.assertString(expectedStatusPaymentconfirmed, orderHistoryPaymentStatusLabelSTR);

		CommonFunctions.waitForVisiblity(orderHistoryProductNameLabel, waitTime);
		String orderHistoryProductNameLabelSTR = orderHistoryProductNameLabel.getText();
		log.info("Order history page:- product name is " + orderHistoryProductNameLabelSTR);

		CommonFunctions.waitForVisiblity(orderHistoryPriceLabel, waitTime);
		String orderHistoryPriceLabelSTR = orderHistoryPriceLabel.getText().trim();
		log.info("Order history page:- product price is " + orderHistoryPriceLabelSTR);

		CommonFunctions.waitForVisiblity(orderHistoryOrderDateLabel, waitTime);
		String orderHistoryOrderDateLabelforTrim = orderHistoryOrderDateLabel.getText();
		log.info("Order history page:- order date is " + orderHistoryOrderDateLabelforTrim);
		String orderHistoryOrderDateLabelSTR = orderHistoryOrderDateLabelforTrim.substring(5, 15);
		String currentDate = java.time.LocalDate.now().toString();
		CommonFunctions.assertString(currentDate, orderHistoryOrderDateLabelSTR);
	}

	public void verifyPrimePlanThankYouPageDataOnOrderHistoryPage(String orderNumberLabelSTR) throws Exception {

		String expectedOrderNumberLabelSTR = orderNumberLabelSTR;

		excel.setExcelFile("NewTestData.xlsx", "Order");
		String expectedPrimeLabel = excel.getCellData("PrimeLabel", 1);
		String expectedStatusPaymentconfirmed = excel.getCellData("OrderHistoryPageStatusPaymentconfirmed", 1);
		String expectedPrimePrice = excel.getCellData("PrimePrice", 1);
		String expectedPrimeLabelOnHeaderPage = excel.getCellData("PrimeButtonOnHeaderPage", 1);

		log.info("Store Order Number from CreditCardThankYouPage:- " + expectedOrderNumberLabelSTR);

		CommonFunctions.waitForVisiblity(checkOrderHistoryLink, waitTime);
		checkOrderHistoryLink.click();

		CommonFunctions.waitForVisiblity(orderHistoryOrderNumberLabel, waitTime);
		String orderHistoryOrderNumberLabelforTrim = orderHistoryOrderNumberLabel.getText();
		String orderHistoryOrderNumberLabelSTR = orderHistoryOrderNumberLabelforTrim.substring(7, 31);
		log.info("Order history page:- order number is " + orderHistoryOrderNumberLabelSTR);
		CommonFunctions.assertString(expectedOrderNumberLabelSTR, orderHistoryOrderNumberLabelSTR);

		CommonFunctions.waitForVisiblity(orderHistoryPaymentStatusLabel, waitTime);
		String orderHistoryPaymentStatusLabelSTR = orderHistoryPaymentStatusLabel.getText();
		log.info("Order history page:- payment status is Payment confirmed " + expectedStatusPaymentconfirmed);
		CommonFunctions.assertString(expectedStatusPaymentconfirmed, orderHistoryPaymentStatusLabelSTR);

		CommonFunctions.waitForVisiblity(orderHistoryProductNameLabel, waitTime);
		String orderHistoryProductNameLabelSTR = orderHistoryProductNameLabel.getText().trim();
		log.info("Order history page:- displayed " + orderHistoryProductNameLabelSTR);
		CommonFunctions.assertString(expectedPrimeLabel, orderHistoryProductNameLabelSTR);

		CommonFunctions.waitForVisiblity(orderHistoryPriceLabel, waitTime);
		String orderHistoryPriceLabelForTrim = orderHistoryPriceLabel.getText();
		String orderHistoryPriceLabelSTR = orderHistoryPriceLabelForTrim.substring(0, 3);
		log.info("Order history page:- price for prime " + orderHistoryPriceLabelSTR);
		CommonFunctions.assertString(expectedPrimePrice, orderHistoryPriceLabelSTR);

		CommonFunctions.waitForVisiblity(orderHistoryOrderDateLabel, waitTime);
		String orderHistoryOrderDateLabelforTrim = orderHistoryOrderDateLabel.getText();
		log.info("Order history page:- order date is " + orderHistoryOrderDateLabelforTrim);
		String orderHistoryOrderDateLabelSTR = orderHistoryOrderDateLabelforTrim.substring(5, 15);
		String currentDate = java.time.LocalDate.now().toString();
		CommonFunctions.assertString(currentDate, orderHistoryOrderDateLabelSTR);

		CommonFunctions.waitForVisiblity(primeButtonOnHeaderPage, waitTime);
		String primeButtonOnHeaderPageSTR = primeButtonOnHeaderPage.getText().trim();
		log.info("Prime Label On Header Page:- displayed " + primeButtonOnHeaderPageSTR);
		CommonFunctions.assertString(expectedPrimeLabelOnHeaderPage, primeButtonOnHeaderPageSTR);

	}

	public void verifyMembershipStatusPageForPrime() throws Exception {

		excel.setExcelFile("NewTestData.xlsx", "Order");
		String expectedMembershipPagePrimeCreditCardLabelSTR = excel.getCellData("MembershipPagePrimeCreditCardLabel",
				1);
		String expectedPrimePrice = excel.getCellData("PrimePrice", 1);
		String expectedMembershipPagePrimeLabelSTR = excel.getCellData("PrimeButtonOnHeaderPage", 1);

		CommonFunctions.waitForVisiblity(sideMembershipStatusPage, waitTime);
		sideMembershipStatusPage.click();
		log.info("Open Membership Status Page page");

		CommonFunctions.waitForVisiblity(membershipPagePrimeLabel, waitTime);
		String membershipPagePrimeLabelSTR = membershipPagePrimeLabel.getText().trim();
		log.info("Membership page:- prime label displayed " + membershipPagePrimeLabelSTR);
		CommonFunctions.assertString(expectedMembershipPagePrimeLabelSTR, membershipPagePrimeLabelSTR);

		CommonFunctions.waitForVisiblity(membershipPagePrimePriceLabel, waitTime);
		String membershipPagePrimePriceLabelForTrim = membershipPagePrimePriceLabel.getText();

		String membershipPagePrimePriceLabelSTR = membershipPagePrimePriceLabelForTrim.substring(0, 3);
		log.info("Membership page:- prime price displayed " + membershipPagePrimePriceLabelSTR);
		CommonFunctions.assertString(expectedPrimePrice, membershipPagePrimePriceLabelSTR);

		CommonFunctions.waitForVisiblity(membershipPagePrimeCreditCardLabel, waitTime);
		String membershipPagePrimeCreditCardLabelSTR = membershipPagePrimeCreditCardLabel.getText().trim();
		log.info("Membership page:- displayed " + membershipPagePrimeCreditCardLabelSTR);
		CommonFunctions.assertString(expectedMembershipPagePrimeCreditCardLabelSTR,
				membershipPagePrimeCreditCardLabelSTR);

		CommonFunctions.waitForVisiblity(membershipPageChangeCardButton, waitTime);
		log.info("Membership page:- change card button displayed");

		CommonFunctions.waitForVisiblity(membershipPageEndMembershipButton, waitTime);
		log.info("Membership page:- end membership button displayed");

	}

	public void verifyServiceYouAreUsingPageForPrime() throws Exception {

//		CommonFunctions.waitForVisiblity(sideMenuServiceYouAreUsingPage, waitTime);
//		sideMenuServiceYouAreUsingPage.click();
//		log.info("Open Service you are using page");
		driver.navigate().to("https://stg.studygear.evidus.net/mypage-member-service");

		CommonFunctions.waitForVisiblity(primeMembershipBenefitsLabel, waitTime);
		int actualPrimeMembershipBenefitsCount = driver
				.findElements(By.xpath("//button[@class='button button--blue1 button--xsmall']")).size();
		int expectedprimeMembershipBenefitsCount = 3;
		CommonFunctions.assertInt(actualPrimeMembershipBenefitsCount, expectedprimeMembershipBenefitsCount);
		log.info("It display 3 basic plan products which is free for prime plan");

	}

	public void verifyLearnButtonFromServiceYouAreUsingPage() throws Exception {

		excel.setExcelFile("NewTestData.xlsx", "Order");
		String expectedLearnButtonLabelForKankenProductSTR = excel.getCellData("LearnButtonLabelForKankenProduct", 1);

		CommonFunctions.waitForVisiblity(sideMenuServiceYouAreUsingPage, waitTime);
		sideMenuServiceYouAreUsingPage.click();

		CommonFunctions.waitForVisiblity(learnButtonForKankenProduct, waitTime);
		String learnButtonLabelForKankenProductSTR = learnButtonForKankenProduct.getText();
		log.info("Service you are using:- learn button text " + learnButtonLabelForKankenProductSTR);
		CommonFunctions.assertString(expectedLearnButtonLabelForKankenProductSTR, learnButtonLabelForKankenProductSTR);

	}

}
