package platformstepdefinition;

import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import base.NewBaseClass;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.junit.Cucumber;
import platform.pageobjects.Authentication.LoginPage;
import platform.pageobjects.Footer.FooterPage;
import platform.pageobjects.Withdrawal.Withdrawal;

/**
 * @Author : Sahaj Balgunde
 * @Date of Creation : 23 July 2021
 * @Description: Additional Locator variables and Methods for Withdrawal.
 */
@RunWith(Cucumber.class)
public class PF_Withdrawal extends NewBaseClass {

	public WebDriver driver;

	@Given("^User is on Withdrawal Page$")
	public void user_is_on_withdrawal(String browser) throws Throwable {
		driver = openbrowser(browser);
		LoginPage loginToPlatform = new LoginPage(driver);
		loginToPlatform.loginToPlatform();
		FooterPage footerobj = new FooterPage(driver);
		footerobj.AccountFooter();
	}

	@When("^User clicks on accept checkbox with 退会する button$")
	public void User_clicks_on_accept_checkbox(String browser) throws Throwable {

		Withdrawal accwithdraw = new Withdrawal(driver);
		accwithdraw.withdrawAccount();
	}

	@Then("^Account gets deleted$")
	public void Account_gets_deleted(String browser) throws Throwable {

		System.out.println("Account has been deleted.");

	}

}
