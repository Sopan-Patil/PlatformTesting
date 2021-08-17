package platformstepdefinition;

import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import base.NewBaseClass;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.junit.Cucumber;
import platform.pageobjects.Authentication.LoginPage;
import platform.pageobjects.Withdrawal.Withdrawal;
import utils.ObjectHelper;

/**
 * @Author : Sahaj Balgunde
 * @Date of Creation : 23 July 2021
 * @Description: Additional Locator variables and Methods for Withdrawal.
 */
@RunWith(Cucumber.class)
public class PF_Withdrawal extends NewBaseClass {

	public WebDriver driver = ObjectHelper.driver;

	@Given("^Login To Platform Portal$")
	public void login_To_Platform_Portal() throws Throwable {
		LoginPage login = new LoginPage(driver);
		login.loginToPlatform();
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

	@Then("^Check Back button on Withdrawal Page$")
	public void check_Back_button_on_Withdrawal_Page() throws Throwable {
		Withdrawal withdraw = new Withdrawal(driver);
		withdraw.checkWithdrawPageButtons();

	}

}
