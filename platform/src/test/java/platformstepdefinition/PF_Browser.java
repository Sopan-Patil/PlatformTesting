package platformstepdefinition;

import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import base.NewBaseClass;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.junit.Cucumber;

/**
 * @Author : Chetan Sonparote
 * @Date : 12 Jul 2021
 * @Description: Test step def for browser operations.
 */
@RunWith(Cucumber.class)
public class PF_Browser extends NewBaseClass {

	public WebDriver driver;

	@Given("^Browser is open$")
	public void browser_is_open() throws Throwable {
		checkBrowserOpen();
		throw new PendingException();

	}

	@When("^User opens (.+) on (.+) with (.+) and (.+)$")
	@org.testng.annotations.Parameters(value = { "mode", "browser", "config", "environment" })
	public void user_opens_on_with_and(String browser, String mode, String config, String environment)
			throws Throwable {
		driver = openBrowser(mode, browser, config, environment);
		throw new PendingException();
	}

	@Then("^Validate browser is open$")
	public void validate_browser_is_open() throws Throwable {
		checkBrowserOpen();
		throw new PendingException();
	}

	/*
	 * @Then("^Close the browser$") public void close_the_browser() throws Throwable
	 * { throw new PendingException(); }
	 */

	@Then("^Close the browser for (.+)$")
	public void close_the_browser_for(String mode) throws Throwable {
		throw new PendingException();
	}

}
