package platformstepdefinition;

import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import base.NewBaseClass;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.junit.Cucumber;
import platform.pageobjects.AccountServices.CreateAccountStep1;
import platform.pageobjects.AccountServices.CreateAccountStep2;
import platform.pageobjects.AccountServices.CreateAccountStep3;
import platform.pageobjects.AccountServices.CreateAccountStep4;
import platform.pageobjects.AccountServices.CreateAccountStep5;
import platform.pageobjects.Authentication.LoginPage;
import utils.CommonFunctions;
import utils.ObjectHelper;

/**
 * @Author : Chetan Sonparote
 * @Date : 14 Jul 2021
 * @Description: step def for create account class
 */
@RunWith(Cucumber.class)
public class PF_CreateAccount extends NewBaseClass {

	public WebDriver driver = ObjectHelper.driver;

	@Given("^User is on home page$")
	public void user_is_on_home_page() throws Throwable {
		// throw new PendingException();
		LoginPage loginToPlatform = new LoginPage(driver);

		loginToPlatform.navigateToHomePage();
	}

	@When("^User begins account creation$")
	public void user_begins_account_creation() throws Throwable {
		// System.out.println("inside user_begins_account_creation()");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.clickLoginButton();
		loginPage.clickCreateNewAccountButton();
		replaceurl();

	}

	@Then("^Validate that new account is created$")
	public void validate_that_new_account_is_created() throws Throwable {
		CreateAccountStep5 createAccountStep5 = new CreateAccountStep5(driver);
		createAccountStep5.getCreatedAccountDetails();
		createAccountStep5.clickGotoTopLink();
		// throw new PendingException();
	}

	@And("^creates new credentials$")
	public void creates_new_credentials() throws Throwable {

		CreateAccountStep1 createAccountStep1 = new CreateAccountStep1(driver);
		createAccountStep1.generateNewCredentials();

		createAccountStep1.clickSendConfirmationButton();

		// throw new PendingException();
	}

	@And("^enters valid details$")
	public void enters_valid_details() throws Throwable {
		CreateAccountStep3 createAccountStep3 = new CreateAccountStep3(driver);
		createAccountStep3.enterValidUserDetails();
		createAccountStep3.clickAgreeButton();

		// throw new PendingException();
	}

	@And("^confirms details$")
	public void confirms_details() throws Throwable {
		// throw new PendingException();
		CreateAccountStep4 createAccountStep4 = new CreateAccountStep4(driver);
		createAccountStep4.clickSignUpButton();
	}

	@And("^enters confirmation code$")
	public void enters_confirmation_code() throws Throwable {

		CreateAccountStep2 createAccountStep2 = new CreateAccountStep2(driver);
		// createAccountStep2.convertOTPToList();
		createAccountStep2.addConfirmationCode();
		createAccountStep2.clickNextButton();

	}

	/**
	 * @Author : Chetan Sonparote
	 * @Date : 6 Aug 2021
	 * @Description: step def for resend code functionality
	 */

	@Then("^Validate that new code is accepted$")
	public void validate_that_new_code_is_accepted() throws Throwable {
		// throw new PendingException();
		CreateAccountStep3 createAccountStep3 = new CreateAccountStep3(driver);
		Assert.assertTrue(CommonFunctions.isElementVisible(createAccountStep3.passwordField));

	}

	@And("^User clicks resend confirmation code$")
	public void user_clicks_resend_confirmation_code() throws Throwable {
		// throw new PendingException();
		CreateAccountStep2 createAccountStep2 = new CreateAccountStep2(driver);
		createAccountStep2.clickResendCodeLink();
		NewBaseClass.validateError(null, "確認コードを再送しました、宛先メールをご確認ください。");

	}

	@Then("^Validate that error is displayed for invalid code$")
	public void validate_that_error_is_displayed_for_invalid_code() throws Throwable {
		// throw new PendingException();
		NewBaseClass.validateError(null, "6桁の確認コードを入力してください。");

	}

	@And("^User enters invalid code$")
	public void user_enters_invalid_code() throws Throwable {
		// throw new PendingException();
		CreateAccountStep2 createAccountStep2 = new CreateAccountStep2(driver);
		// createAccountStep2.convertOTPToList();
		createAccountStep2.enterInvalidCode();
		createAccountStep2.clickNextButton();
	}

}
