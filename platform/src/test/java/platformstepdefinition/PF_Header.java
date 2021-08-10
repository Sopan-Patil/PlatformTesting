package platformstepdefinition;

import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import base.NewBaseClass;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.junit.Cucumber;
import platform.pageobjects.Header.Header;
import utils.ObjectHelper;

@RunWith(Cucumber.class)
public class PF_Header extends NewBaseClass {

	public WebDriver driver = ObjectHelper.driver;

	@Given("^Open and Navigate to URL on (.+)$")
	public void navigate_to_url_(String browser) throws Throwable {
		driver = openbrowser(browser);
	}

	@When("^User hovers on header Links$")
	public void User_hovers_on_header_Links() throws Throwable {
		Header headerobj = new Header(driver);
		headerobj.checkHeaderMenuLinksVisibility();
	}

	@Then("^Validate that links are visible$")
	public void Validate_that_links_are_visible() throws Throwable {
		Header headerobj = new Header(driver);
		headerobj.checkSubMenuLinkVisibility();
	}

	@And("^Validate that menus are working$")
	public void Validate_that_menus_are_working() throws Throwable {
		Header headerobj = new Header(driver);
		headerobj.checkHeaderLinksWorking();
	}

	@And("^Validate that sub menus are working$")
	public void Validate_that_sub_menus_are_working() throws Throwable {
		Header headerobj = new Header(driver);
		headerobj.checkSubMenuLinkWorking();
	}

	@And("^Close the browsers$")
	public void close_browsers() throws Throwable {
		closebrowser();
	}

}
