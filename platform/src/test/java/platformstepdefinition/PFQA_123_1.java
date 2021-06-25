package platformstepdefinition;

import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import base.NewBaseClass;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.junit.Cucumber;
import platform.pageobjects.LoginPage;

/**
 * Author : Chetan Sonparote Date of Modification : 25 Jun 2021 Description:
 * Modified method to accept browser parameter from feature file
 */
@RunWith(Cucumber.class)
public class PFQA_123_1 extends NewBaseClass {

	public WebDriver driver;

	String emailid = "";

	@Given("^Navigate to URL on (.+) PFQA_123_1$")
	public void navigate_to_url_on_pfqa1231(String browser) throws Throwable {

		// @Given("^Navigate to URL PFQA_123_1$")
		// public void Navigate_to_URL_Platform() throws Throwable {

		driver = openbrowser(browser);

	}

	@Then("^Login for PFQA_123_1$")
	public void Login_for_Platform() throws Throwable {

		LoginPage loginPage = new LoginPage(driver);
		loginPage.loginToPlatform();

	}
}
