package platformstepdefinition;

import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
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
import utils.XLHandler;

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

		LoginPage loginToPlatform = new LoginPage(driver);

		loginToPlatform.navigateToHomePage();
	}

	@When("^User begins account creation$")
	public void user_begins_account_creation() throws Throwable {

		LoginPage loginPage = new LoginPage(driver);
		loginPage.clickLoginButton();
		loginPage.clickCreateNewAccountButton();
		replaceurl();

	}

	private static Logger log = LogManager.getLogger(PF_CreateAccount.class.getName());

	@Then("^Validate that new account is created$")
	public void validate_that_new_account_is_created() throws Throwable {
		log.info("inside validate_that_new_account_is_created()");
		CreateAccountStep5 createAccountStep5 = new CreateAccountStep5(driver);
		createAccountStep5.getCreatedAccountDetails();
		createAccountStep5.writeCredentialsToExcel();
		createAccountStep5.clickGotoTopLink();

		LoginPage loginPage = new LoginPage(driver);
		loginPage.loginWithNewUser();

		Assert.assertTrue(loginPage.logoutButton.isDisplayed());
		if (CommonFunctions.isElementVisible(loginPage.logoutButton)) {

			log.info("New User is logged in");
			loginPage.logoutButton.click();
		}

	}

	@And("^creates new credentials$")
	public void creates_new_credentials() throws Throwable {

		CreateAccountStep1 createAccountStep1 = new CreateAccountStep1(driver);
		createAccountStep1.generateNewCredentials();

		createAccountStep1.clickSendConfirmationButton();

	}

	@And("^enters valid details$")
	public void enters_valid_details() throws Throwable {
		CreateAccountStep3 createAccountStep3 = new CreateAccountStep3(driver);
		createAccountStep3.enterValidUserDetails();
		createAccountStep3.clickAgreeButton();

	}

	@And("^confirms details$")
	public void confirms_details() throws Throwable {

		CreateAccountStep4 createAccountStep4 = new CreateAccountStep4(driver);
		createAccountStep4.clickSignUpButton();
	}

	@And("^enters confirmation code$")
	public void enters_confirmation_code() throws Throwable {

		CreateAccountStep2 createAccountStep2 = new CreateAccountStep2(driver);

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

		CreateAccountStep2 createAccountStep2 = new CreateAccountStep2(driver);
		createAccountStep2.clickResendCodeLink();

		NewBaseClass newBaseClass = new NewBaseClass();
		newBaseClass.validateMessageFromExcel("ResendCodeMessage", "//div[@class='alert__title']");

	}

	@Then("^Validate that error is displayed for invalid code$")
	public void validate_that_error_is_displayed_for_invalid_code() throws Throwable {

		NewBaseClass newBaseClass = new NewBaseClass();
		newBaseClass.validateMessageFromExcel("InvalidCodeError", "//p[@class='alert__des']");

	}

	@And("^User enters invalid code$")
	public void user_enters_invalid_code() throws Throwable {
		// throw new PendingException();
		CreateAccountStep2 createAccountStep2 = new CreateAccountStep2(driver);
		// createAccountStep2.convertOTPToList();
		createAccountStep2.enterInvalidCode();
		createAccountStep2.clickNextButton();
	}



	@Then("^Validate error message is displayed$")
	public void validate_error_message_is_displayed() throws Throwable {
		// throw new PendingException();

		CreateAccountStep1 createAccountStep1 = new CreateAccountStep1(driver);
		ArrayList<String> value = new ArrayList<String>();
		value = XLHandler.readexcel("NewTestData.xlsx", "ValidationStrings", "Label", "InvalidEmailErrorMessage");
		log.info("value :" + value);
		String expectedString = value.get(0).trim();
		log.info("expectedString :" + expectedString);
		createAccountStep1.validateErrorMessage(createAccountStep1.errorMessageText, expectedString);
	}

	@And("^User enters invalid email$")
	public void user_enters_invalid_email() throws Throwable {

		CreateAccountStep1 createAccountStep1 = new CreateAccountStep1(driver);
		createAccountStep1.enterInvalidEmail();
		createAccountStep1.clickSendConfirmationButton();

	}

}

