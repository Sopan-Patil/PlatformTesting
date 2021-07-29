package platform.pageobjects.AccountServices;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import platform.pageobjects.Authentication.LoginPage;
import utils.CommonFunctions;
import utils.CredentialsGenerator;

/**
 * @Author : Chetan Sonparote
 * @Date : 19 Jul 2021
 * @Description:Class for entering credentials in step 1
 */

public class CreateAccountStep1 {

	List<String[]> testdata;
	public WebDriver driver;
	private static Logger log = LogManager.getLogger(LoginPage.class.getName());
	int waitTime = 5;

	public CreateAccountStep1(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@id='email']")
	public WebElement emailField;

	@FindBy(xpath = "//input[@id='entryIdentifier']")
	public WebElement eidField;

	@FindBy(xpath = "//*[@class='button__text' or contains(text(),'Send confirmation email')]")
	public WebElement sendConfirmationButton;

	public void clickSendConfirmationButton() {

		if (CommonFunctions.waitForVisiblity(sendConfirmationButton, waitTime)) {

			sendConfirmationButton.click();
		}

	}

	public static String email;
	public static String eid;

	public void generateNewCredentials() {
		if (CommonFunctions.waitForVisiblity(emailField, waitTime)) {
			emailField.click();
			email = CredentialsGenerator.generateEmailAddress();
			emailField.sendKeys(email);
			log.info("Generated email:" + email);
		}
		if (CommonFunctions.waitForVisiblity(eidField, waitTime)) {
			eidField.click();
			eid = CredentialsGenerator.generateEid();
			eidField.sendKeys(eid);
			log.info("Generated eid:" + eid);

		}
	}

}
