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

/**
 * @Author : Chetan Sonparote
 * @Date : 11 Jul 2021
 * @Description:Class for entering credentials in reset password step 1
 */

public class ResetPasswordStep3 {

	List<String[]> testdata;
	public WebDriver driver;
	private static Logger log = LogManager.getLogger(LoginPage.class.getName());
	int waitTime = 3;

	public ResetPasswordStep3(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// input[@id='new-password']
	@FindBy(xpath = "")
	public WebElement passwordField;

	// input[@id='new-password-confirm']
	@FindBy(xpath = "")
	public WebElement passwordConfirmField;

	// a[@class='button button--default js-submit']
	@FindBy(xpath = "")
	public WebElement completeResetButton;

	public void clickCompleteResetButton() {

		if (CommonFunctions.waitForVisiblity(completeResetButton, waitTime)) {

			completeResetButton.click();
		}

	}

}
