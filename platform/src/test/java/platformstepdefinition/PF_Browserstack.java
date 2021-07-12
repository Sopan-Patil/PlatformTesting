package platformstepdefinition;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import base.NewBaseClass;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.junit.Cucumber;

/**
 * @Author : Chetan Sonparote
 * @Date : 7 Jul 2021
 * @Description: Step def for browserstack browser operations
 */
@RunWith(Cucumber.class)
public class PF_Browserstack extends NewBaseClass {

	public WebDriver driver;
	private static Logger log = LogManager.getLogger(PF_Browserstack.class.getName());

	@Given("^Navigate to URL with (.+) and (.+) on browserstack$")
	public void navigate_to_url_with_and_on_browserstack(String config, String environment) throws Throwable {
		driver = openBrowserstack(config, environment);
	}

	@Then("^Validate if browserstack browser is open$")
	public void validate_if_browserstack_browser_is_open() throws Throwable {

		checkBrowserOpen();
	}

	@Given("^Browserstack browser is open$")
	public void browserstack_browser_is_open() throws Throwable {
		// throw new PendingException();
		checkBrowserOpen();
	}

	@Then("^Close browserstack browser$")
	public void close_browserstack_browser() throws Throwable {
		// Sthrow new PendingException();

		closeBrowserstack();
	}

}
