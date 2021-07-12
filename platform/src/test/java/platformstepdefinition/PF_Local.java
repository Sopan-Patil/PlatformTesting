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
 * @Description: Step def for local browser operations
 */
@RunWith(Cucumber.class)
public class PF_Local extends NewBaseClass {

	public WebDriver driver;
	private static Logger log = LogManager.getLogger(PF_Local.class.getName());

	@Given("^Navigate to URL on local (.+) $")
	public void navigate_to_url_on_local(String browser) throws Throwable {
		// throw new PendingException();
		driver = openbrowser(browser);
	}

	@Then("^Validate if browser is open$")
	public void validate_if_browser_is_open() throws Throwable {
		// throw new PendingException();
		checkBrowserOpen();
	}

	@Given("^Local browser is open$")
	public void local_browser_is_open() throws Throwable {
		// throw new PendingException();
		checkBrowserOpen();
	}

	@Then("^Close local browser$")
	public void close_local_browser() throws Throwable {

		closebrowser();
	}

}
