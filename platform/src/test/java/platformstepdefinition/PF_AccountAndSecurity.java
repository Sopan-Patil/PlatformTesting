package platformstepdefinition;

import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import base.NewBaseClass;
import cucumber.api.java.en.And;
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

	@And("^Update Account Information$")
	public void Update_Account_Information() throws Throwable {
		AccountAndSecurity updateaccountinfo = new AccountAndSecurity(driver);
		updateaccountinfo.UpdateAccountAndSecurityInformation();
	}

	@And("^Validate Updated Account Information$")
	public void Validate_Updated_Account_Information() throws Throwable {
		AccountAndSecurity updateaccountinfo = new AccountAndSecurity(driver);
		updateaccountinfo.Validate_Updated_Account_Information();

	}

	@And("^Update and Validate Invalid Account Information$")
	public void Validate_Invalid_Account_Information() throws Throwable {
		AccountAndSecurity updateaccountinfo = new AccountAndSecurity(driver);
		updateaccountinfo.UpdateAccountAndSecurityInavlidInformation();

	}

	@And("^Click on Cancel button$")
	public void Account_Information_Cancel_Button() throws Throwable {
		AccountAndSecurity CancelButton = new AccountAndSecurity(driver);
		CancelButton.Cancel_Button();

	}

	@And("^Validate Missing Values Of Account Information$")
	public void Validate_Missing_Values_Of_Account_Information() throws Throwable {
		AccountAndSecurity MissingValues = new AccountAndSecurity(driver);
		MissingValues.MissngValuesAccountAndSecurityInformation();
	}

}
