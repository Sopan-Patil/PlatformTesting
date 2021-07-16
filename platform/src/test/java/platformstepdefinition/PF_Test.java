package platformstepdefinition;

import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import base.NewBaseClass;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.junit.Cucumber;
import platform.pageobjects.Authentication.LoginPage;
import utils.ObjectHelper;

/**
 * @Author : Chetan Sonparote 
 * @Date : 25 Jun 2021 
 * @Description:
 * Modified method to accept browser parameter from feature file
 */

/**
 * @Author : Chetan Sonparote
 * @Date : 12 Jul 2021
 * @Description: Test step def for feature. TO be removed later
 */
@RunWith(Cucumber.class)
public class PF_Test extends NewBaseClass {

	public WebDriver driver = ObjectHelper.driver;

	String emailid = "";

	@Given("^User is on home page$")
	public void user_is_on_home_page() throws Throwable {
		// throw new PendingException();
		// driver = openbrowser(browser);
	}

	@Then("^Login$")
	public void login() throws Throwable {
		// throw new PendingException();
		LoginPage loginPage = new LoginPage(driver);
		// loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.clickLoginButton();
		// SignUp SignUp = new SignUp(driver);
		// SignUp.SignUpToPlatform(emailaddress, eid);
	}
}
