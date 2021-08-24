package platformstepdefinition;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import base.NewBaseClass;
import cucumber.api.junit.Cucumber;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import platform.pageobjects.AccountServices.ResetPasswordStep1;
import platform.pageobjects.AccountServices.ResetPasswordStep3;
import platform.pageobjects.AccountServices.ResetPasswordStep4;
import platform.pageobjects.Authentication.ForgotPassword;
import platform.pageobjects.Authentication.LoginPage;
import utils.ObjectHelper;

/**
 * @Author : Chetan Sonparote
 * @Date :11 Aug 2021
 * @Description: Class for password operations
 */

@RunWith(Cucumber.class)
public class PF_Password extends NewBaseClass {

	public WebDriver driver = ObjectHelper.driver;
	private static Logger log = LogManager.getLogger(PF_Password.class.getName());

	@When("^User clicks on forgot password link$")
	public void user_clicks_on_forgot_password_link() throws Throwable {
		// throw new PendingException();
		LoginPage loginPage = new LoginPage(driver);
		loginPage.clickLoginButton();
		ForgotPassword forgotPassword = new ForgotPassword(driver);
		forgotPassword.clickForgotPasswordLink();

	}

	@Then("^Validate that forgot password page is visible$")
	public void validate_that_forgot_password_page_is_visible() throws Throwable {

		NewBaseClass newBaseClass = new NewBaseClass();
		newBaseClass.validateMessageFromExcel("ForgotPasswordPageMessage2", "//p[@class='ep-reset-pass__desc']");

	}

	@Then("^Validate that password change is complete$")
	public void validate_that_password_change_is_complete() throws Throwable {
		// validate password change message
		NewBaseClass newBaseClass = new NewBaseClass();
		newBaseClass.validateMessage("Reset password", "PasswordChangeComplete");

		// login with new password

		ResetPasswordStep4 resetPasswordStep4 = new ResetPasswordStep4(driver);
		resetPasswordStep4.clickGoToLoginPageButton();
		// LoginPage loginPage
		resetPasswordStep4.loginWithNewPassword();
		// write new password to excel if success
	}

	@And("^enters email id to reset password$")
	public void enters_email_id_to_reset_password() throws Throwable {
		// throw new PendingException();
		ResetPasswordStep1 resetPasswordStep1 = new ResetPasswordStep1(driver);
		resetPasswordStep1.enterEmail();
		resetPasswordStep1.clickSendConfirmationButton();
	}

	@And("^enters new password$")
	public void enters_new_password() throws Throwable {
		ResetPasswordStep3 resetPasswordStep3 = new ResetPasswordStep3(driver);
		resetPasswordStep3.enterNewValidPassword();
		resetPasswordStep3.enterNewValidPasswordForConfirmation();
		resetPasswordStep3.clickCompleteResetButton();
	}

	/**
	 * @Author : Chetan Sonparote
	 * @Date :12 Aug 2021
	 * @Description: Methods for invalid email id
	 */

	@Then("^Validate that error message is displayed for invalid email id$")
	public void validate_that_error_message_is_displayed_for_invalid_email_id() throws Throwable {
		// throw new PendingException();
		NewBaseClass newBaseClass = new NewBaseClass();
		newBaseClass.validateMessage("Reset password", "InvalidEmailError");
	}

	@And("^enters invalid email id$")
	public void enters_invalid_email_id() throws Throwable {
		// throw new PendingException();
		ResetPasswordStep1 resetPasswordStep1 = new ResetPasswordStep1(driver);
		resetPasswordStep1.enterInvalidEmail();
		resetPasswordStep1.clickSendConfirmationButton();
	}

	/**
	 * @Author : Chetan Sonparote
	 * @Date :12 Aug 2021
	 * @Description: Methods for checking faq link
	 */

	@Then("^Validate that FAQ link is open on reset password$")
	public void validate_that_faq_link_is_open_on_reset_password() throws Throwable {
		ResetPasswordStep1 resetPasswordStep1 = new ResetPasswordStep1(driver);
		// System.out.println(driver.getTitle());
		NewBaseClass newBaseClass = new NewBaseClass();
		newBaseClass.validateLink(resetPasswordStep1.faqLinkVerification);

	}

	@And("^click on FAQ link$")
	public void click_on_faq_link() throws Throwable {
//		throw new PendingException();
		ResetPasswordStep1 resetPasswordStep1 = new ResetPasswordStep1(driver);
		resetPasswordStep1.clickFaqLink();
	}

	/**
	 * @Author : Chetan Sonparote
	 * @Date :12 Aug 2021
	 * @Description: Methods for invalid password
	 */

	@Then("^Validate that error message is displayed for invalid password$")
	public void validate_that_error_message_is_displayed_for_invalid_password() throws Throwable {
		// throw new PendingException();
		NewBaseClass newBaseClass = new NewBaseClass();
		newBaseClass.validateMessage("Reset password", "InvalidPasswordError");
	}

	@And("^enters invalid password$")
	public void enters_invalid_password() throws Throwable {
		// throw new PendingException();
		ResetPasswordStep3 resetPasswordStep3 = new ResetPasswordStep3(driver);
		resetPasswordStep3.enterNewValidPassword();
		resetPasswordStep3.enterNewInvalidPasswordForConfirmation();
		resetPasswordStep3.clickCompleteResetButton();
	}

}
