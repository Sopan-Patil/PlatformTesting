package platformstepdefinition;

import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import base.NewBaseClass;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.junit.Cucumber;
import platform.pageobjects.Authentication.ForgotPassword;
import platform.pageobjects.Authentication.LoginPage;
import utils.ObjectHelper;
import utils.XLHandler;

/**
 * @Author : Chetan Sonparote
 * @Date :11 Aug 2021
 * @Description: Class for password operations
 */

@RunWith(Cucumber.class)
public class PF_Password extends NewBaseClass {

	public WebDriver driver = ObjectHelper.driver;
	private static Logger log = LogManager.getLogger(PF_Password.class.getName());

	@When("^User clicks on forgot password link$")
	public void user_clicks_on_forgot_password_link() throws Throwable {
		// throw new PendingException();
		LoginPage loginPage = new LoginPage(driver);
		loginPage.clickLoginButton();
		ForgotPassword forgotPassword = new ForgotPassword(driver);
		forgotPassword.clickForgotPasswordLink();

	}

	@Then("^Validate that forgot password page is visible$")
	public void validate_that_forgot_password_page_is_visible() throws Throwable {
		// throw new PendingException();

		// String actualString
		ArrayList<String> value = new ArrayList<String>();
		value = XLHandler.readexcel("NewTestData.xlsx", "ValidationStrings", "Label", "ForgotPasswordPageMessage2");
		log.info("value :" + value);
		String expectedString = value.get(0).trim();
		log.info("expectedString :" + expectedString);
		String actualString = ObjectHelper.driver.findElement(By.xpath("//p[@class='ep-reset-pass__desc']")).getText()
				.trim();
		log.info("actualString :" + actualString);
		Assert.assertTrue(actualString.contains(expectedString));

	}

	@Then("^Validate that password change is complete$")
	public void validate_that_password_change_is_complete() throws Throwable {
		// throw new PendingException();
	}

	@And("^enters email id to reset password$")
	public void enters_email_id_to_reset_password() throws Throwable {
		// throw new PendingException();
	}

//	    @And("^enters confirmation code$")
//	    public void enters_confirmation_code() throws Throwable {
//	        throw new PendingException();
//	    }

	@And("^enters new password$")
	public void enters_new_password() throws Throwable {
		// throw new PendingException();
	}

}
