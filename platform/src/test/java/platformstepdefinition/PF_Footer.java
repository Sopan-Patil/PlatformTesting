package platformstepdefinition;

import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import base.NewBaseClass;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.junit.Cucumber;
import platform.pageobjects.Authentication.LoginPage;
import platform.pageobjects.Footer.FooterPage;
import utils.ObjectHelper;

@RunWith(Cucumber.class)
public class PF_Footer extends NewBaseClass {

	public WebDriver driver = ObjectHelper.driver;

	@Given("^Navigate to URL and check footer links (.+)$")
	public void navigate_to_URL_and_check_footer_links(String browser) throws Throwable {
		driver = openbrowser(browser);
		FooterPage footer = new FooterPage(driver);
		footer.clickFooterLinksBeforeLogin();
	}

	@And("^check footer links with after login (.+)$")
	public void check_footer_links_after_login(String browser) throws Throwable {
		LoginPage loginToPlatform = new LoginPage(driver);
		loginToPlatform.loginToPlatform();
		FooterPage footer = new FooterPage(driver);
		footer.clickFooterLinksAfterLogin();
		throw new PendingException();
	}

	@Then("^Close browser(.+)$")
	public void close_browser() throws Throwable {
		driver.quit();
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
