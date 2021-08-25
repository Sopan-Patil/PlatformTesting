package platform.pageobjects.Authentication;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.NewBaseClass;
import testlink.api.java.client.TestLinkAPIResults;
import utils.CommonFunctions;
import utils.ExcelUtil;
import utils.ObjectHelper;
import utils.TestLinkIntegration;

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

	@FindBy(xpath = "//p[@class='alert__des']")
	public WebElement invalidDataErrorText;

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
		String notes = null;
		String result = null;
		try {
			ExcelUtil excel = new ExcelUtil();
			excel.setExcelFile("NewTestData.xlsx", "User");

			String userNameSTR = excel.getCellData("UserName", 1);
			String passwordSTR = excel.getCellData("Password", 1);

			if (CommonFunctions.waitForVisiblity(logInButton, waitTime)) {
				logInButton.click();

			}

			log.info("Login button is clicked");

			// System.out.println("inside loginToPlatform()");

			log.info("Login button is clicked");

			if (CommonFunctions.waitForVisiblity(emailtextfield, waitTime)) {
				emailtextfield.click();
				emailtextfield.sendKeys(userNameSTR);

			}

			if (CommonFunctions.waitForVisiblity(passwordTextField, waitTime)) {

				// passwordTextField.sendKeys("Test-123");
				passwordTextField.click();

				passwordTextField.sendKeys(passwordSTR);
				System.out.println(passwordTextField.getText());
			}
			if (CommonFunctions.waitForVisiblity(SubmitButton, waitTime)) {
				CommonFunctions.clickUsingJavaExecutor(SubmitButton);
			}
		} catch (Exception e) {

			result = TestLinkAPIResults.TEST_FAILED;
			notes = e.getMessage();
			e.printStackTrace();

		} catch (AssertionError e) {

			String message = e.getMessage();
			System.out.println(message);
			result = TestLinkAPIResults.TEST_FAILED;
			notes = e.getMessage();
			e.printStackTrace();

		} finally {

			System.out.println("Updating TestCase Execution Status in TestLink");
			TestLinkIntegration.updateTestLinkResults("Login Test Case Title", notes, result);

		}

	}

	/**
	 * @Author : Rahul Shinde
	 * @Date : 16 aug 2021
	 * @Description: removed unwanted login payment login
	 * 
	 */

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

		if (CommonFunctions.waitForVisiblity(logoutButton, waitTime)) {
			logoutButton.click();
			log.info("The user logout successfully");
		}

	}

	public void navigateToHomePage() throws Exception {

		NewBaseClass baseObj = new NewBaseClass();
		ObjectHelper.driver.navigate().to(ObjectHelper.enviURL);// API

		baseObj.replaceurl();
		log.info("The home page is open");

	}

	/**
	 * @throws Exception
	 * @Author : Chetan Sonparote
	 * @Date : 5 Aug 2021
	 * 
	 * @Description: Added new method for invlaid login
	 */

	public void setInvalidUserData(String invalid) throws Exception {

		ExcelUtil excel = new ExcelUtil();
		excel.setExcelFile("NewTestData.xlsx", "NewUser");

		CommonFunctions.isElementVisible(emailtextfield);

		String user = null;
		String password = null;

		if (invalid == "user") {
			user = "inval@abd";
			password = excel.getCellData("Password", 1);
		} else if (invalid == "password") {
			user = excel.getCellData("Email", 1);
			password = "fail";
		} else if (invalid == "both") {
			user = "inval@abd";
			password = "fail";
		}

		log.info("Re Login button is clicked");

		if (CommonFunctions.waitForVisiblity(emailtextfield, waitTime)) {
			emailtextfield.click();
			emailtextfield.sendKeys(user);
		}

		if (CommonFunctions.waitForVisiblity(passwordTextField, waitTime)) {

			// passwordTextField.sendKeys("Test-123");
			passwordTextField.click();

			passwordTextField.sendKeys(password);
			// System.out.println(passwordTextField.getText());
		}

		if (CommonFunctions.waitForVisiblity(SubmitButton, waitTime)) {
			CommonFunctions.clickUsingJavaExecutor(SubmitButton);
		}
	}

	public void loginWithNewUser() throws Exception {

		ExcelUtil excelUtil = new ExcelUtil();
		excelUtil.setExcelFile("NewTestData.xlsx", "NewUser");
		String email = excelUtil.getCellData("Email", 1);
		String password = excelUtil.getCellData("Password", 1);

		log.info("New User Email : " + email);
		log.info("New User password : " + password);

		if (CommonFunctions.waitForVisiblity(logInButton, waitTime)) {
			logInButton.click();
			log.info("Login button is clicked");

		}

		if (CommonFunctions.waitForVisiblity(emailtextfield, waitTime)) {
			emailtextfield.click();
			emailtextfield.sendKeys(email);

		}

		if (CommonFunctions.waitForVisiblity(passwordTextField, waitTime)) {

			// passwordTextField.sendKeys("Test-123");
			passwordTextField.click();

			passwordTextField.sendKeys(password);
			// System.out.println(passwordTextField.getText());
		}

		if (CommonFunctions.waitForVisiblity(SubmitButton, waitTime)) {
			CommonFunctions.clickUsingJavaExecutor(SubmitButton);
		}

		if (CommonFunctions.waitForVisiblity(SubmitButton, waitTime)) {
			CommonFunctions.clickUsingJavaExecutor(SubmitButton);
		}

	}

}