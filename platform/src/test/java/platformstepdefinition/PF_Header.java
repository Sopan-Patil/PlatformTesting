package platformstepdefinition;

import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import base.NewBaseClass;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.junit.Cucumber;
import platform.pageobjects.Header.Header;
import utils.ObjectHelper;

@RunWith(Cucumber.class)
public class PF_Header extends NewBaseClass {

	public WebDriver driver = ObjectHelper.driver;

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

}
