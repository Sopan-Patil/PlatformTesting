package platformstepdefinition;

import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import base.NewBaseClass;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.junit.Cucumber;
import platform.pageobjects.Authentication.LoginPage;

@RunWith(Cucumber.class)
public class PF_CreateAccount extends NewBaseClass {

	public WebDriver driver;

	@When("^User begins account creation$")
	public void user_begins_account_creation() throws Throwable {
		LoginPage loginToPlatform = new LoginPage(driver);
		loginToPlatform.clickLoginButton();
		throw new PendingException();
	}

	@Then("^Validate that new account is created$")
	public void validate_that_new_account_is_created() throws Throwable {
		throw new PendingException();
	}

	@And("^creates new credentials$")
	public void creates_new_credentials() throws Throwable {
		throw new PendingException();
	}

	@And("^enters valid details$")
	public void enters_valid_details() throws Throwable {
		throw new PendingException();
	}

	@And("^confirms details$")
	public void confirms_details() throws Throwable {
		throw new PendingException();
	}

}
