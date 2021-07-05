package platformstepdefinition;

import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import base.NewBaseClass;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.junit.Cucumber;
import platform.pageobjects.FooterPage;

/**
 * @Author : Chetan Sonparote
 * @Date : 2 Jul 2021
 * @Description: Step def for footer feature
 */
@RunWith(Cucumber.class)
public class PFQA_Footer extends NewBaseClass {

	public WebDriver driver;

	@Given("^Navigate to URL on (.+) for footer link verification$")
	public void navigate_to_url_on_for_footer_link_verification(String browser) throws Throwable {
		driver = openbrowser(browser);
	}

	@Then("^Validate footer links$")
	public void validate_footer_links() throws Throwable {
		// throw new PendingException();
		FooterPage footerPage = new FooterPage(driver);

		footerPage.clickFooterScbtLink();
	}

	/*
	 * @And("^Close browser$") public void close_browser() throws Throwable { // //
	 * throw new PendingException(); closebrowser(); }
	 */

}
