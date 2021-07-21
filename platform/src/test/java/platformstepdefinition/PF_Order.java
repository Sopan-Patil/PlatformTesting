package platformstepdefinition;

import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import base.NewBaseClass;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.junit.Cucumber;
import platform.pageobjects.Authentication.LoginPage;
import platform.pageobjects.Order.Order;

@RunWith(Cucumber.class)
public class PF_Order extends NewBaseClass {

	public WebDriver driver;

	String emailid = "";

	@Given("^Navigate to URL and login (.+)$")
	public void navigate_to_url_(String browser) throws Throwable {
		driver = openbrowser(browser);
		LoginPage loginToPlatform = new LoginPage(driver);
		loginToPlatform.loginToPlatform();
		Order orderobj = new Order(driver);
		orderobj.orderWithValidConvenienceStore();
	}

	@And("^Close browsers$")
	public void close_browsers() throws Throwable { // //
		// closebrowser();
	}

	@Given("^Navigate to URL with (.+) and (.+) login$")
	public void navigate_to_url_with_browserstack_and_login(String config, String environment) throws Throwable {
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
