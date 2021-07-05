package platform.pageobjects;

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
	int waitTime = 1;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@id='email']")
	public WebElement emailtextfield;

	@FindBy(xpath = "//input[@id='password']")
	public WebElement passwordTextField;

	@FindBy(xpath = "//span[contains(text(),'ログイン')]")
	public WebElement logInButton;

	@FindBy(xpath = "//button[@type='submit']")
	public WebElement SubmitButton;

	public void loginToPlatform() throws Exception {
		String[] shipmentdata;

		shipmentdata = XLHandler.readexcel("User", "NewTestData.xlsx");
		// System.out.println(shipmentdata[0]);
		// System.out.println(shipmentdata[1]);

		if (CommonFunctions.isElementClickable(logInButton)) {

			logInButton.click();

		}

		log.info("Login button is clicked");
		log.info("Navigated to topPage");
		log.trace("Trace Message!");
		log.debug("Debug Message!");
		log.info("Info Message!");
		log.warn("Warn Message!");
		log.error("Error Message!");
		log.fatal("Fatal Message!");

		if (CommonFunctions.waitForVisiblity(emailtextfield, waitTime)) {
			emailtextfield.click();
			emailtextfield.sendKeys(shipmentdata[0]);
		}

		if (CommonFunctions.waitForVisiblity(passwordTextField, waitTime)) {
			passwordTextField.sendKeys(shipmentdata[1]);
		}
		if (CommonFunctions.waitForVisiblity(SubmitButton, waitTime)) {
			CommonFunctions.clickUsingJavaExecutor(SubmitButton);
		}

	}

}