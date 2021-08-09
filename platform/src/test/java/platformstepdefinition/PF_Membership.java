package platformstepdefinition;

import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import base.NewBaseClass;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.junit.Cucumber;
import platform.pageobjects.Authentication.LoginPage;
import platform.pageobjects.MyPage.Membership;
import utils.ObjectHelper;

@RunWith(Cucumber.class)
public class PF_Membership extends NewBaseClass {

	public WebDriver driver = ObjectHelper.driver;

	@Given("^Navigate to URL(.+)$")
	public void navigate_to_url_(String browser) throws Throwable {
		driver = openbrowser(browser);

	}

	@Then("^Login To PF Portal$")
	public void login_to_PF_Portal() throws Throwable {
		LoginPage loginpage = new LoginPage(driver);
		loginpage.clickLoginButton();
		loginpage.loginToPlatform();

	}

	@Then("^Click on Membership Status and Click on apply for prime membership banner$")
	public void Click_on_Membership_Status_and_Click_on_apply_for_prime_membership_banner_() throws Throwable {
		Membership membershipobj = new Membership(driver);
		membershipobj.membershipPlan();
	}

	@Then("^Check the link validation on member plan page$")
	public void Check_the_link_validation_on_member_plan_page_() throws Throwable {
		Membership membershipobj = new Membership(driver);
		membershipobj.membershipPlanPage();

	}

}
