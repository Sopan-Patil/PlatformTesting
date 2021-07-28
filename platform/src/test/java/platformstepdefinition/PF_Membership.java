package platformstepdefinition;

import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import base.NewBaseClass;
import cucumber.api.java.en.Given;
import cucumber.api.junit.Cucumber;
import platform.pageobjects.MyPage.Membership;

public class PF_Membership {

	@RunWith(Cucumber.class)
	public class PF_Login extends NewBaseClass {

		public WebDriver driver;

		@Given("^Login To Platform Portal (.+)$")
		public void navigate_to_url_(String browser) throws Throwable {
			driver = openbrowser(browser);
			Membership membershipobj = new Membership(driver);
			membershipobj.membershipFunctions();
		}

	}
}