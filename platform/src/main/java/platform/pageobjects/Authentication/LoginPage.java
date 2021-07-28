package platform.pageobjects.Authentication;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonFunctions;
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

		// System.out.println("inside clickLoginButton()");
		if (CommonFunctions.waitForVisiblity(logInButton, waitTime)) {

			logInButton.click(); // changes done
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
			log.info("Login button is clicked");
		}

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

}