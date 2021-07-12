package platformstepdefinition;

import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import base.NewBaseClass;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.junit.Cucumber;
import platform.pageobjects.Authentication.SignIn;

@RunWith(Cucumber.class)
public class PF_SignIn extends NewBaseClass {
	/**
	 * @Author : Sopan Patil
	 * @Date : 12 Jul 2021
	 * @Description: Added SignIn stetps
	 */
	public WebDriver driver;

	String emailid = "";

	@Given("^Navigate to URL on (.+) Platform$")
	public void navigate_to_url_on_PFQA_SignIn(String browser) throws Throwable {
		driver = openbrowser(browser);

	}

	@Then("^SignIn for Platform$")
	public void SignIn_for_Platform(String emailaddress, String eid) throws Throwable {

		SignIn SignIn = new SignIn(driver);
		SignIn.SignInToPlatform(emailaddress, eid);
	}

	@And("^Close browser$")
	public void close_browser() throws Throwable { //
		// throw new PendingException();
		closebrowser();
	}

	@Given("^Navigate to URL with (.+) and (.+) PFQA_123_1$")
	public void navigate_to_url_with_and_pfqa1231(String config, String environment) throws Throwable {
		// throw new PendingException();
		driver = openBrowserstack(config, environment);
		// driver

	}

	/*
	 * @AfterTest public void tearDown() { driver.quit(); }
	 */
	/*
	 * @Given("^Navigate to URL with (.+) PFQA_123_1$") public void
	 * navigate_to_url_with_pfqa1231(String config) throws Throwable { // throw new
	 * PendingException(); String environment = null; driver =
	 * openBrowserstack(config, environment); }
	 */

}
