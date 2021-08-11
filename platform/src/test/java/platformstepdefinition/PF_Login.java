package platformstepdefinition;

import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import base.NewBaseClass;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.junit.Cucumber;
import platform.pageobjects.Authentication.LoginPage;
import utils.ObjectHelper;

/**
 * @Author : Chetan Sonparote 
 * @Date : 25 Jun 2021 
 * @Description:
 * Modified method to accept browser parameter from feature file
 */

/**
 * @Author : Chetan Sonparote
 * @Date : 28 Jun 2021
 * @Description: Added method for browserstack
 */
@RunWith(Cucumber.class)
public class PF_Login extends NewBaseClass {

	public WebDriver driver = ObjectHelper.driver;

	// String emailid = "";

	@Given("^Navigate to URL on (.+)$")
	public void navigate_to_url_(String browser) throws Throwable {
		driver = openbrowser(browser);

	}

	/**
	 * @Author : Sopan Patil
	 * @Date : 01 Jul 2021
	 * @Description: Added Login stetps
	 */
	@Then("^Login To Platform$")
	public void Login_to_Platform() throws Throwable {

		LoginPage loginToPlatform = new LoginPage(driver);

		loginToPlatform.loginToPlatform();

		// driver.close();

		// TopBar topBar = new TopBar(driver);
		// topBar.clickSignUpLinkLink();

	}

	/**
	 * @Author : rahul shinde
	 * @Date : 02 Aug 2021
	 * @Description: Logout
	 */

	@And("^logout$")
	public void logout() throws Throwable {

		LoginPage loginToPlatform = new LoginPage(driver);

		loginToPlatform.logoutFromPlatform();

	}

	@Then("^Navigate to home page$")
	public void navigate_to_home_page() throws Throwable {

		LoginPage loginToPlatform = new LoginPage(driver);

		loginToPlatform.navigateToHomePage();
	}
	/*
	 * @And("^Close browser$") public void close_browser() throws Throwable { // //
	 * closebrowser(); }
	 */

	/*
	 * @Given("^Navigate to URL with (.+) and (.+) PFQA_123_1$") public void
	 * navigate_to_url_with_and_pfqa1231(String config, String environment) throws
	 * Throwable { // throw new PendingException(); driver =
	 * openBrowserstack(config, environment); // driver
	 * 
	 * }
	 */

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
