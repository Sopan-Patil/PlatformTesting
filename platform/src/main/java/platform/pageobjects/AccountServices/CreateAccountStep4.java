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
 * @Date : 21 Jul 2021
 * @Description:Class for confirming details on step 4
 */

public class CreateAccountStep4 {

	List<String[]> testdata;
	public WebDriver driver;
	private static Logger log = LogManager.getLogger(LoginPage.class.getName());
	int waitTime = 5;

	public CreateAccountStep4(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@id='js-btn-submit']")
	public WebElement signUpButton;

	@FindBy(xpath = "//a[@class='button button--white1 button--register-step-4']")
	public WebElement returnButton;

	public void clickSignUpButton() {

		if (CommonFunctions.waitForVisiblity(signUpButton, waitTime)) {

			signUpButton.click();
		}

	}

	public void clickReturnButton() {

		if (CommonFunctions.waitForVisiblity(returnButton, waitTime)) {

			returnButton.click();
		}

	}

}
