package platformstepdefinition;

import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import base.NewBaseClass;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.junit.Cucumber;
import platform.pageobjects.Authentication.LoginPage;

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

	public WebDriver driver;

	String emailid = "";

	@Given("^User is on home page$")
	public void user_is_on_home_page() throws Throwable {
		// throw new PendingException();
		// driver = openbrowser(browser);
	}

	@Then("^Login $")
	public void login() throws Throwable {
		// throw new PendingException();
		LoginPage loginToPlatform = new LoginPage(driver);
		loginToPlatform.loginToPlatform();
	}
}
