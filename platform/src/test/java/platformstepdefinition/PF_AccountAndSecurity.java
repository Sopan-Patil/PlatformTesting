package platformstepdefinition;

import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import base.NewBaseClass;
import cucumber.api.java.en.Then;
import cucumber.api.junit.Cucumber;
import platform.pageobjects.MyPage.AccountAndSecurity;
import utils.ObjectHelper;

/**
 * @Author : Sopan patil
 * @Date : 22 Jul 2021
 * @Description: step def for invalid credit card
 */
@RunWith(Cucumber.class)
public class PF_AccountAndSecurity extends NewBaseClass {

	public WebDriver driver = ObjectHelper.driver;

	@Then("^Click on Account and Security$")
	public void Click_on_Account_and_Security() throws Throwable {
		AccountAndSecurity AccountAndSecurity = new AccountAndSecurity(driver);
		AccountAndSecurity.clickAccountInformation();
	}

	@Then("^Click on Change button$")
	public void Click_on_Change_Button() throws Throwable {
		AccountAndSecurity changeButton = new AccountAndSecurity(driver);
		changeButton.clickChangeButton();
	}
}
