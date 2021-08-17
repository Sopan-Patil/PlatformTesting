package platformstepdefinition;

import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import base.NewBaseClass;


import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

import cucumber.api.junit.Cucumber;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import platform.pageobjects.Authentication.LoginPage;
import platform.pageobjects.MyPage.InvalidCC;
import utils.ObjectHelper;

/**
 * @Author : Sopan patil
 * @Date : 22 Jul 2021
 * @Description: step def for invalid credit card
 */
@RunWith(Cucumber.class)
public class PF_InvalidCC extends NewBaseClass {

	public WebDriver driver = ObjectHelper.driver;

	/**
	 * @Author : rahul shinde
	 * @Date : 16 aug 2021
	 * @Description: remove duplicate login step def
	 */

	@Then("^Click on Membership Status link$")
	public void Click_on_Membership_Status_link() throws Throwable {
		InvalidCC InvalidCC = new InvalidCC(driver);
		InvalidCC.clickAccountInformation();
		InvalidCC.ClickMmemberShipStatus();
	}

	@Then("^Click on Change Card$")
	public void Click_on_Change_Card() throws Throwable {
		InvalidCC InvalidCC = new InvalidCC(driver);
		InvalidCC.clickChangeCardButton();
		replaceurlChangeCard();
		LoginPage loginPage = new LoginPage(driver);
		loginPage.clickLoginButton();
		loginPage.loginToPlatform();
	}

	@And("^Enters invalid credit card details$")
	public void Enters_credit_card_details() throws Throwable {
		InvalidCC InvalidCC = new InvalidCC(driver);
		InvalidCC.InValidCreditcard();

	}
}
