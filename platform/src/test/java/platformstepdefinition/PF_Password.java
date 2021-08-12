package platformstepdefinition;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import base.NewBaseClass;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.junit.Cucumber;
import platform.pageobjects.AccountServices.ResetPasswordStep1;
import platform.pageobjects.AccountServices.ResetPasswordStep3;
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
		// throw new PendingException();
	}

	@And("^enters email id to reset password$")
	public void enters_email_id_to_reset_password() throws Throwable {
		// throw new PendingException();
		ResetPasswordStep1 resetPasswordStep1 = new ResetPasswordStep1(driver);
		resetPasswordStep1.enterEmail();
		resetPasswordStep1.clickSendConfirmationButton();
	}

//	    @And("^enters confirmation code$")
//	    public void enters_confirmation_code() throws Throwable {
//	        throw new PendingException();
//	    }

	@And("^enters new password$")
	public void enters_new_password() throws Throwable {
		ResetPasswordStep3 resetPasswordStep3 = new ResetPasswordStep3(driver);
		resetPasswordStep3.enterNewValidPassword();
		resetPasswordStep3.enterNewValidPasswordForConfirmation();
		resetPasswordStep3.clickCompleteResetButton();
	}

}
