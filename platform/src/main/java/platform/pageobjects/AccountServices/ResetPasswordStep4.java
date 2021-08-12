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
import utils.ExcelUtil;

/**
 * @Author : Chetan Sonparote
 * @Date : 11 Jul 2021
 * @Description:Class for entering credentials in reset password step 1
 */

public class ResetPasswordStep4 {

	List<String[]> testdata;
	public WebDriver driver;
	private static Logger log = LogManager.getLogger(LoginPage.class.getName());
	int waitTime = 3;

	public ResetPasswordStep4(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// span[contains(text(),'ログインページへ')]
	@FindBy(xpath = "//a[@class='button button--default']")
	public WebElement goToLoginPageButton;

	public void clickGoToLoginPageButton() {

		if (CommonFunctions.waitForVisiblity(goToLoginPageButton, waitTime)) {

			goToLoginPageButton.click();
		}

	}

	public void loginWithNewPassword() throws Exception {
		// resetPasswordStep1.
		LoginPage loginPage = new LoginPage(driver);

		if (CommonFunctions.isElementVisible(loginPage.emailtextfield)) {
			loginPage.emailtextfield.click();
			loginPage.emailtextfield.sendKeys(ResetPasswordStep1.userName);
		}

		if (CommonFunctions.isElementVisible(loginPage.passwordTextField)) {
			loginPage.passwordTextField.click();
			loginPage.passwordTextField.sendKeys(ResetPasswordStep3.newValidPassword);
		}

		if (CommonFunctions.isElementVisible(loginPage.SubmitButton)) {
			loginPage.SubmitButton.click();
			// loginPage.passwordTextField.sendKeys(resetPasswordStep3.newValidPassword);
		}

		if (CommonFunctions.waitForVisiblity(loginPage.logoutButton, 1)) {

			ExcelUtil excel = new ExcelUtil();
			excel.setExcelFile("NewTestData.xlsx", "NewUser");

			excel.setCellData(ResetPasswordStep3.newValidPassword, 1, 1);

			loginPage.logoutFromPlatform();
			// loginPage.passwordTextField.sendKeys(resetPasswordStep3.newValidPassword);
		}

	}

}
