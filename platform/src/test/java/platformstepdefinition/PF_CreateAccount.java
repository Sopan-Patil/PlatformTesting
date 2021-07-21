package platformstepdefinition;

import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import base.NewBaseClass;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.junit.Cucumber;
import platform.pageobjects.AccountServices.CreateAccountStep1;
import platform.pageobjects.AccountServices.CreateAccountStep2;
import platform.pageobjects.AccountServices.CreateAccountStep3;
import platform.pageobjects.Authentication.LoginPage;
import utils.ObjectHelper;

/**
 * @Author : Chetan Sonparote
 * @Date : 14 Jul 2021
 * @Description: step def for create account class
 */
@RunWith(Cucumber.class)
public class PF_CreateAccount extends NewBaseClass {

	public WebDriver driver = ObjectHelper.driver;

	@When("^User begins account creation$")
	public void user_begins_account_creation() throws Throwable {
		System.out.println("inside user_begins_account_creation()");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.clickLoginButton();
		loginPage.clickCreateNewAccountButton();
		replaceurl();

	}

	@Then("^Validate that new account is created$")
	public void validate_that_new_account_is_created() throws Throwable {
		throw new PendingException();
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
		throw new PendingException();
	}

	@And("^enters confirmation code$")
	public void enters_confirmation_code() throws Throwable {

		CreateAccountStep2 createAccountStep2 = new CreateAccountStep2(driver);
		// createAccountStep2.convertOTPToList();
		createAccountStep2.addConfirmationCode();
		createAccountStep2.clickNextButton();

		// System.out.println("OTP :" + OTPNumberReader.getOTPNumberValue());
		// throw new PendingException();
	}

}
