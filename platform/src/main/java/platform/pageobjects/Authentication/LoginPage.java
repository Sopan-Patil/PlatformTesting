package platform.pageobjects.Authentication;

import java.io.IOException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.NewBaseClass;
import utils.CommonFunctions;
import utils.ObjectHelper;
import utils.XLHandler;

/**
 * @Author : Chetan Sonparote
 * @Date : 28 Jun 2021
 * @Description: Added wait for locators
 */

/**
 * @Author : Sopan Patil
 * @Date : 01 Jul 2021
 * @Description: Added Login function
 */

public class LoginPage {
	List<String[]> testdata;
	public WebDriver driver;
	private static Logger log = LogManager.getLogger(LoginPage.class.getName());
	int waitTime = 5;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@id='email']")
	public WebElement emailtextfield;

	@FindBy(xpath = "//input[@id='password']")
	public WebElement passwordTextField;

	@FindBy(xpath = "//a[@class='button button--white3 button--medium button--header']")
	public WebElement logInButton;

	@FindBy(xpath = "//button[@type='submit']")
	public WebElement SubmitButton;

	@FindBy(xpath = "//a[@href='/logout']")
	public WebElement logoutButton;

	/**
	 * 
	 * @Author : rahul shinde
	 * @Date : 19 Jul 2021
	 * @Description: handle zkai popup
	 */

	@FindBy(xpath = "//div[@class='modal-content']")
	public WebElement zkai_popup;

	@FindBy(xpath = "//button[@aria-label='Close']")
	public WebElement zkai_popupCloseButton;

	/**
	 * @Author : Chetan Sonparote
	 * @Date : 19 Jul 2021
	 * @Description: Added new method for create new account button
	 */

	// @FindBy(xpath = "//font[contains(text(),'Create a new account')] or
	// //span[contains(text(),'新規アカウント作成')]")
	@FindBy(xpath = "//*[contains(text(),'Create a new account') or contains(text(),'新規アカウント作成')]")
	public WebElement createNewAccountButton;

	public void clickCreateNewAccountButton() {

		// System.out.println("inside clickLoginButton()");
		if (CommonFunctions.waitForVisiblity(createNewAccountButton, waitTime)) {

			createNewAccountButton.click(); // changes done
		}

	}

	/**
	 * @Author : Chetan Sonparote
	 * @Date : 14 Jul 2021
	 * @Description: Added new method for click login
	 */

	public void clickLoginButton() {

		if (CommonFunctions.waitForVisiblity(logInButton, waitTime)) {
			logInButton.click();
		}

	}

	public void loginToPlatform() throws Exception {

//		/**
//		 * @Author : rahul shinde
//		 * @Date : 19 Jul 2021
//		 * @Description: handle zkai popup
//		 */
//
//		if (CommonFunctions.waitForVisiblity(zkai_popup, waitTime)) {
//			zkai_popupCloseButton.click();
//			log.info("Close Zkai pop up");
//		}

		String[] shipmentdata;

		shipmentdata = XLHandler.readexcel("User", "NewTestData.xlsx");

		System.out.println(shipmentdata[0]);
		System.out.println(shipmentdata[1]);

		// CommonFunctions.wa
		if (CommonFunctions.waitForVisiblity(logInButton, waitTime)) {
			logInButton.click();

		}

		log.info("Login button is clicked");
		// System.out.println("inside loginToPlatform()");

		log.info("Login button is clicked");

		if (CommonFunctions.waitForVisiblity(emailtextfield, waitTime)) {
			emailtextfield.click();
			emailtextfield.sendKeys(shipmentdata[0]);

		}

		if (CommonFunctions.waitForVisiblity(passwordTextField, waitTime)) {

			// passwordTextField.sendKeys("Test-123");
			passwordTextField.click();

			passwordTextField.sendKeys(shipmentdata[1]);
			System.out.println(passwordTextField.getText());
		}
		if (CommonFunctions.waitForVisiblity(SubmitButton, waitTime)) {
			CommonFunctions.clickUsingJavaExecutor(SubmitButton);
		}

	}

	/**
	 * @Author : Rahul Shinde
	 * @Date : 13 Jul 2021
	 * @Description: used in order flow re login
	 * 
	 */
	public void loginToPlatformForPayment() throws Exception {

		CommonFunctions.isElementVisible(emailtextfield);
		String[] shipmentdata;

		shipmentdata = XLHandler.readexcel("User", "NewTestData.xlsx");

		System.out.println(shipmentdata[0]);
		System.out.println(shipmentdata[1]);

		log.info("Re Login button is clicked");

		if (CommonFunctions.waitForVisiblity(emailtextfield, waitTime)) {
			emailtextfield.click();
			emailtextfield.sendKeys(shipmentdata[0]);

		}

		if (CommonFunctions.waitForVisiblity(passwordTextField, waitTime)) {

			// passwordTextField.sendKeys("Test-123");
			passwordTextField.click();

			passwordTextField.sendKeys(shipmentdata[1]);
			System.out.println(passwordTextField.getText());
		}

		if (CommonFunctions.waitForVisiblity(SubmitButton, waitTime)) {

			SubmitButton.click();

		}
		/*
		 * if (CommonFunctions.waitForVisiblity(SubmitButton, waitTime)) {
		 * CommonFunctions.clickUsingJavaExecutor(SubmitButton); }
		 */

	}

	/**
	 * @Author : Rahul Shinde
	 * @Date : 02 aug 2021
	 * @Description: used for logout
	 * 
	 */
	public void logoutFromPlatform() throws Exception {

		NewBaseClass baseObj = new NewBaseClass();
		ObjectHelper.driver.navigate().to(ObjectHelper.enviURL);// API

		baseObj.replaceurl();

		CommonFunctions.waitForVisiblity(logoutButton, waitTime);
		logoutButton.click();
		log.info("The user logout successfully");

	}

	public void navigateToHomePage() throws Exception {

		NewBaseClass baseObj = new NewBaseClass();
		ObjectHelper.driver.navigate().to(ObjectHelper.enviURL);// API

		baseObj.replaceurl();
		log.info("The home page is open");

	}

	/**
	 * @throws IOException
	 * @throws InvalidFormatException
	 * @throws EncryptedDocumentException
	 * @Author : Chetan Sonparote
	 * @Date : 5 Aug 2021
	 * @Description: Added new method for login with new user
	 */

	public void loginWithNewUser() throws EncryptedDocumentException, InvalidFormatException, IOException {
		String[] newuser = null;

		newuser = XLHandler.readexcel("NewUser", "NewTestData.xlsx");

		log.info("New User Email : " + newuser[0]);
		log.info("New User password : " + newuser[1]);
		// System.out.println(newuser[0]);
		// System.out.println(newuser[1]);

		if (CommonFunctions.waitForVisiblity(logInButton, waitTime)) {
			logInButton.click();
			log.info("Login button is clicked");

		}

		// System.out.println("inside loginToPlatform()");

		// log.info("Login button is clicked");

		if (CommonFunctions.waitForVisiblity(emailtextfield, waitTime)) {
			emailtextfield.click();
			emailtextfield.sendKeys(newuser[0]);

		}

		if (CommonFunctions.waitForVisiblity(passwordTextField, waitTime)) {

			// passwordTextField.sendKeys("Test-123");
			passwordTextField.click();

			passwordTextField.sendKeys(newuser[1]);
			// System.out.println(passwordTextField.getText());
		}
		if (CommonFunctions.waitForVisiblity(SubmitButton, waitTime)) {
			CommonFunctions.clickUsingJavaExecutor(SubmitButton);
		}

	}

}