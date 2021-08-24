package platformstepdefinition;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import platform.pageobjects.Authentication.LoginPage;
import utils.ObjectHelper;

/**
 * @Author : Chetan Sonparote
 * @Date : 17 Aug 2021
 * @Description: Hook method to capture failure screenshot and attach to report
 */

public class Hooks {

	private static Logger log = LogManager.getLogger(Hooks.class.getName());

	@AfterStep
	public void addScreenshot(Scenario scenario) throws IOException {

		System.out.println("inside addScreenshot()");
		// validate if scenario has failed
		if (scenario.isFailed()) {
			final byte[] screenshot = ((TakesScreenshot) ObjectHelper.driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png", "image");
		}

	}

	/**
	 * @Author : rahul shinde
	 * @Date : 20 Aug 2021
	 * @Description: Hook method to perform create account before
	 *               OrderPrimeWithValidCreditCard test case start
	 */

	@Before(value = "@OrderPrimeWithValidCreditCard")
	public void beforeScenario() throws Throwable {
		log.info("Follow create account steps before actual test case OrderPrimeWithValidCreditCard");
		PF_CreateAccount createACC = new PF_CreateAccount();

		// Given User is on home page
		createACC.user_is_on_home_page();
		// When User begins account creation
		createACC.user_begins_account_creation();
		// And creates new credentials
		createACC.creates_new_credentials();
		// And enters confirmation code
		createACC.enters_confirmation_code();
		// And enters valid details
		createACC.enters_valid_details();
		// And confirms details
		createACC.confirms_details();
		// Then Validate that new account is created
		createACC.validate_that_new_account_is_created();
	}

	@Before
	public void setup() throws Exception {

		LoginPage loginToPlatform = new LoginPage(ObjectHelper.driver);
		loginToPlatform.navigateToHomePage();
		loginToPlatform.logoutFromPlatform();

	}

}
