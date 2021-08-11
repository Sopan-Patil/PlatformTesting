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

public class ResetPasswordStep1 {

	List<String[]> testdata;
	public WebDriver driver;
	private static Logger log = LogManager.getLogger(LoginPage.class.getName());
	int waitTime = 3;

	public ResetPasswordStep1(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "// input[@id='userNameOrEmail']")
	public WebElement emailField;

	@FindBy(xpath = "// a[@class='button button--default js-submit']")
	public WebElement sendConfirmationButton;

	public void clickSendConfirmationButton() {

		if (CommonFunctions.waitForVisiblity(sendConfirmationButton, waitTime)) {

			sendConfirmationButton.click();
		}

	}

}
