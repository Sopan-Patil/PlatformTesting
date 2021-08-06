package platformstepdefinition;

import org.openqa.selenium.WebDriver;

import base.NewBaseClass;
import cucumber.api.java.en.Given;
import utils.ObjectHelper;

public class PF_Terms_and_condition extends NewBaseClass {
	public WebDriver driver = ObjectHelper.driver;

	@Given("^Open Browser (.+)$")
	public void navigate_to_URL_and_check_footer_links(String browser) throws Throwable {
		driver = openbrowser(browser);
	}
}
