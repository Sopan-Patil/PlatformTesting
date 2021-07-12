package platformstepdefinition;

import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import base.NewBaseClass;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.junit.Cucumber;
import platform.pageobjects.Footer.FooterPage;

/**
 * @Author : Chetan Sonparote
 * @Date : 2 Jul 2021
 * @Description: Step def for footer feature
 */
@RunWith(Cucumber.class)
public class PF_Footer extends NewBaseClass {

	public WebDriver driver;

	@Given("^Browser is open$")
	public void browser_is_open() throws Throwable {
		// throw new PendingException();
		checkBrowserOpen();
	}

	@Then("^Validate footer links$")
	public void validate_footer_links() throws Throwable {
		// throw new PendingException();
		FooterPage footerPage = new FooterPage(driver);

		footerPage.clickFooterScbtLink();
	}

}
