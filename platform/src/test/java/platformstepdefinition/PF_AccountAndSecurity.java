package platformstepdefinition;

import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import base.NewBaseClass;
import cucumber.api.junit.Cucumber;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import platform.pageobjects.MyPage.AccountAndSecurity;
import utils.ObjectHelper;

/**
 * @Author : Sopan patil
 * @Date : 22 Jul 2021
 * @Description: step def for Account and Security
 */
@RunWith(Cucumber.class)
public class PF_AccountAndSecurity extends NewBaseClass {

	public WebDriver driver = ObjectHelper.driver;

	@When("^Click on Account and Security$")
	public void Click_on_Account_and_Security() throws Throwable {
		AccountAndSecurity AccountAndSecurity = new AccountAndSecurity(driver);
		AccountAndSecurity.clickingAccountInformation();
	}

	@Then("^Click on Change button$")
	public void Click_on_Change_Button() throws Throwable {
		AccountAndSecurity changeButton = new AccountAndSecurity(driver);
		changeButton.clickingChangeButton();
	}

	@And("^Update Account Information$")
	public void Update_Account_Information() throws Throwable {
		AccountAndSecurity updateaccountinfo = new AccountAndSecurity(driver);
		updateaccountinfo.UpdatingAccountAndSecurityInformation();
	}

	@Then("^Validate Updated Account Information$")
	public void Validate_Updated_Account_Information() throws Throwable {
		AccountAndSecurity updateaccountinfo = new AccountAndSecurity(driver);
		updateaccountinfo.ValidatingUpdatedAccountInformation();

	}

	@And("^Update and Validate Invalid Account Information$")
	public void Validate_Invalid_Account_Information() throws Throwable {
		AccountAndSecurity updateaccountinfo = new AccountAndSecurity(driver);
		updateaccountinfo.UpdatingAccountAndSecurityInavlidInformation();

	}

	@Then("^Click on Cancel button$")
	public void Account_Information_Cancel_Button() throws Throwable {
		AccountAndSecurity CancelButton = new AccountAndSecurity(driver);
		CancelButton.ClickingCancelButton();
	}

	@And("^Validate Missing Values Of Account Information$")
	public void Validate_Missing_Values_Of_Account_Information() throws Throwable {
		AccountAndSecurity MissingValues = new AccountAndSecurity(driver);
		MissingValues.checkMissngValuesErrorOnAccountAndSecurityInformation();
	}

}
