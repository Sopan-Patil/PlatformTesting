package platformstepdefinition;

import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import base.NewBaseClass;
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

	@Given("^Navigate to URL (.+)$")
	public void navigate_to_URL_and_check_footer_links(String browser) throws Throwable {
		driver = openbrowser(browser);
	}

	@And("^Check footer links$")
	public void check_footer_links() throws Throwable {
		FooterPage footer = new FooterPage(driver);
		footer.clickFooterLinksBeforeLogin();
	}

	@Then("^Check footer links on Login Page$")
	public void check_footer_links_on_login_page() throws Throwable {
		FooterPage checklinks = new FooterPage(driver);
		checklinks.clickLoginFooterLink();
		checklinks.clickAccountServicesFooterLinks();
		driver.navigate().back();
	}

	@Then("^Check footer links on top page after login$")
	public void check_footer_links_after_login_() throws Throwable {
		LoginPage loginfunction = new LoginPage(driver);
		loginfunction.loginToPlatform();
		FooterPage checklinks = new FooterPage(driver);
		checklinks.clickFooterLinksAfterLogin();
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
