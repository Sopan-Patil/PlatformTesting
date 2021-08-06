package platformstepdefinition;

import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import base.NewBaseClass;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.junit.Cucumber;
import platform.pageobjects.Header.Header;
import utils.ObjectHelper;

@RunWith(Cucumber.class)
public class PF_Header extends NewBaseClass {

	public WebDriver driver = ObjectHelper.driver;

	@Given("^Navigate to URL and open Header (.+)$")
	public void navigate_to_url_(String browser) throws Throwable {
		driver = openbrowser(browser);
		Header headerobj = new Header(driver);
		headerobj.checkHeaderAndSubMenuLinkVisibility();
		headerobj.checkHeaderLinksWorking();
		headerobj.checkSubMenuLinkWorking();
	}

	@And("^Close the browsers$")
	public void close_browsers() throws Throwable { // //
		closebrowser();
	}
}
