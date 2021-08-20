package platformstepdefinition;

import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import base.NewBaseClass;
import cucumber.api.junit.Cucumber;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import platform.pageobjects.Authentication.LoginPage;
import platform.pageobjects.Withdrawal.Withdrawal;
import platform.pageobjects.Withdrawal.Withdrawal_PT_111;
import utils.ObjectHelper;

/**
 * @Author : Sahaj Balgunde
 * @Date of Creation : 23 July 2021
 * @Description: Additional Locator variables and Methods for Withdrawal.
 */
@RunWith(Cucumber.class)
public class PF_Withdrawal_PT_111 extends NewBaseClass {

	public WebDriver driver = ObjectHelper.driver;

	@Given("^Login To Platform Portal$")
	public void login_To_platform_portal() throws Throwable {
		LoginPage login = new LoginPage(driver);
		login.loginWithNewUser();
	}

	@Then("^Click Withdrawal link on Footer$")
	public void Click_Withdrawal_link_on_Footer() throws Throwable {
		Withdrawal withdraw = new Withdrawal(driver);
		withdraw.gotoWithdrawalPage();
	}

	@Then("^Check Top button on Withdrawal Page$")
	public void check_Back_button_on_Withdrawal_Page() throws Throwable {
		Withdrawal_PT_111 withdrawal = new Withdrawal_PT_111(driver);
		withdrawal.checkWithdrawtopPageButtons();

	}

}
