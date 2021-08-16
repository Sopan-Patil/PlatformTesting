package platform.pageobjects.Authentication;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonFunctions;

public class ForgotPassword {
	List<String[]> testdata;
	public WebDriver driver;
	private static Logger log = LogManager.getLogger(ForgotPassword.class.getName());

	public ForgotPassword(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@href='login']")
	public WebElement logInButton;

	// @FindBy(xpath = "//a[contains(text(),'パスワードをお忘れの方')]")
	/**
	 * @Author : Chetan Sonparote
	 * @Date :11 Aug 2021
	 * @Description: Added alternate xpath
	 */

	@FindBy(xpath = "//a[@href='/accounts/modify/password-reset']")
	public WebElement forgotPasswordLink;

	@FindBy(xpath = "//input[@id='userNameOrEmail']")
	public WebElement emailtextfield;

	@FindBy(xpath = "//span[contains(text(),'メール送信')]")
	public WebElement SendemailButton;

	/**
	 * @Author : Chetan Sonparote
	 * @Date :11 Aug 2021
	 * @Description: Method to click forgot password link only
	 */
	public void clickForgotPasswordLink() {
		if (CommonFunctions.waitForVisiblity(forgotPasswordLink, 3)) {

			forgotPasswordLink.click();
		}

	}

	public void ForgotPassword() throws Exception {

		logInButton.click();
		log.info("Login button is clicked");
		forgotPasswordLink.click();
		emailtextfield.sendKeys("sopan5@mailinator.com");
		CommonFunctions.clickUsingJavaExecutor(SendemailButton);

	}

}