package platformstepdefinition;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import base.NewBaseClass;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.junit.Cucumber;
import platform.pageobjects.LoginPage;

/**
 * @Author : Chetan Sonparote
 * @Date : 7 Jul 2021
 * @Description: Step def for local browser operations
 */
@RunWith(Cucumber.class)
public class PFQA_Local extends NewBaseClass {

	public WebDriver driver;
	private static Logger log = LogManager.getLogger(PFQA_Local.class.getName());

	/*
	 * @Given("^Navigate to URL on local (.+) $") public void
	 * navigate_to_url_on_local(String browser) throws Throwable { // throw new
	 * PendingException(); driver = openbrowser(browser); }
	 */

	/*
	 * @Given("^Navigate to URL on local (.+) $") public void
	 * navigate_to_url_on_local(String browser) throws Throwable { // driver =
	 * openbrowser(browser); throw new PendingException();
	 * 
	 * }
	 */

	/*
	 * @Given("^Navigate to URL on local chrome$") public void
	 * navigate_to_URL_on_local_chrome(String browser) throws Throwable { // Write
	 * code here that turns the phrase above into concrete actions driver =
	 * openbrowser(browser); throw new PendingException(); }
	 */

	/*
	 * @Given("^Navigate to url on local (.+) $") public void
	 * navigate_to_url_on_local(String browser) throws Throwable { driver =
	 * openbrowser(browser); throw new PendingException(); }
	 */

	/*
	 * @Then("^Validate if browser is open$") public void
	 * validate_if_browser_is_open() throws Throwable { // throw new
	 * PendingException(); checkBrowserOpen(); }
	 * 
	 * @Given("^Local browser is open$") public void local_browser_is_open() throws
	 * Throwable { // throw new PendingException(); checkBrowserOpen(); }
	 * 
	 * @Then("^Close local browser$") public void close_local_browser() throws
	 * Throwable {
	 * 
	 * closebrowser(); }
	 */
	/*
	 * @Then("^Run test script$") public void run_test_script() throws Throwable {
	 * // throw new PendingException(); LoginPage loginPage = new LoginPage(driver);
	 * 
	 * loginPage.loginToPlatform(); }
	 */

	/*
	 * @And("^Close local browser$") public void close_local_browser() throws
	 * Throwable { // throw new PendingException();
	 * 
	 * closebrowser(); }
	 */

	@Given("^Navigate to url on local (.+) $")
	public void navigate_to_url_on_local(String browser) throws Throwable {
		driver = openbrowser(browser);
		throw new PendingException();
	}

	@Then("^Run test script$")
	public void run_test_script() throws Throwable {
		LoginPage loginPage = new LoginPage(driver);

		loginPage.loginToPlatform();
		throw new PendingException();
	}

	@And("^Close local browser$")
	public void close_local_browser() throws Throwable {
		closebrowser();
		throw new PendingException();
	}

}
