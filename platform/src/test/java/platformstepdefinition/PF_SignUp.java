package platformstepdefinition;

import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import base.NewBaseClass;
import cucumber.api.junit.Cucumber;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import platform.pageobjects.Authentication.SignUp;

@RunWith(Cucumber.class)
public class PF_SignUp extends NewBaseClass {
	/**
	 * @Author : Sopan Patil
	 * @Date : 12 Jul 2021
	 * @Description: Added SignUp stetps
	 */
	public WebDriver driver;

	String emailid = "";

	@Given("^Navigate to URL on (.+) Platform$")
	public void navigate_to_url_on_PFQA_SignIn(String browser) throws Throwable {
		driver = openbrowser(browser);

	}

	@Then("^SignUp for Platform$")
	public void SignUp_for_Platform(String emailaddress, String eid) throws Throwable {

		SignUp SignUp = new SignUp(driver);
		SignUp.SignUpToPlatform(emailaddress, eid);
	}

	@And("^Close browser$")
	public void close_browser() throws Throwable { //
		// throw new PendingException();
		// closebrowser();
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
