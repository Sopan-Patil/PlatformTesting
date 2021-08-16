package platformstepdefinition;

import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import base.NewBaseClass;
import cucumber.api.java.en.Then;
import cucumber.api.junit.Cucumber;
import platform.pageobjects.Authentication.LoginPage;
import platform.pageobjects.Withdrawal.Withdrawal;

/**
 * @Author : Sahaj Balgunde
 * @Date of Creation : 23 July 2021
 * @Description: Additional Locator variables and Methods for Withdrawal.
 */
@RunWith(Cucumber.class)
public class PF_Withdrawal extends NewBaseClass {

	public WebDriver driver;

	@Then("^Login To Platform Portal$")
	public void Login_to_Platform() throws Throwable {
		LoginPage platformLogin = new LoginPage(driver);
		platformLogin.loginToPlatform();
	}

	@Then("^Click Withdrawal link on Footer$")
	public void Click_Withdrawal_link_on_Footer() throws Throwable {
		Withdrawal withdraw = new Withdrawal(driver);
		withdraw.gotoWithdrawalPage();
	}

	@Then("^Withdraw Account$")
	public void Withdraw_Account() throws Throwable {

		Withdrawal withdraw = new Withdrawal(driver);
		withdraw.executeWithdrawalFunction();

	}

}
