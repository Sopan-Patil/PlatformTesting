package platform.pageobjects.Order;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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

	// not used
	@FindBy(xpath = "//button[@type='submit']")
	public WebElement SubmitButton;
	// not used

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

}