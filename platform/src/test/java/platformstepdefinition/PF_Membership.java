package platformstepdefinition;

import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import base.NewBaseClass;
import cucumber.api.java.en.Given;
import cucumber.api.junit.Cucumber;
import platform.pageobjects.Authentication.LoginPage;
import platform.pageobjects.MyPage.Membership;

@RunWith(Cucumber.class)
public class PF_Membership extends NewBaseClass {

	public WebDriver driver;

	@Given("^Login To Platform and check membership plan (.+)$")
	public void navigate_to_url_(String browser) throws Throwable {
		driver = openbrowser(browser);
		LoginPage loginpage = new LoginPage(driver);
		loginpage.clickLoginButton();
		loginpage.loginToPlatform();
		Membership membershipobj = new Membership(driver);
		membershipobj.membershipPlan();

	}

}
