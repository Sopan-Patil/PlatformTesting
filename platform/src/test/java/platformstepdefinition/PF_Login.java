package platformstepdefinition;

import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import base.NewBaseClass;
import cucumber.api.junit.Cucumber;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import platform.pageobjects.Authentication.LoginPage;
import utils.ObjectHelper;

/**
 * @Author : Chetan Sonparote 
 * @Date : 25 Jun 2021 
 * @Description:
 * Modified method to accept browser parameter from feature file
 */

/**
 * @Author : Chetan Sonparote
 * @Date : 28 Jun 2021
 * @Description: Added method for browserstack
 */
@RunWith(Cucumber.class)
public class PF_Login extends NewBaseClass {

	public WebDriver driver = ObjectHelper.driver;

	// String emailid = "";

	@Given("^Navigate to URL on (.+)$")
	public void navigate_to_url_(String browser) throws Throwable {
		driver = openbrowser(browser);

	}

	/**
	 * @Author : Sopan Patil
	 * @Date : 01 Jul 2021
	 * @Description: Added Login stetps
	 */
	@Then("^Login To Platform$")
	public void Login_to_Platform() throws Throwable {

		LoginPage loginToPlatform = new LoginPage(driver);

		loginToPlatform.loginToPlatform();

		// driver.close();

		// TopBar topBar = new TopBar(driver);
		// topBar.clickSignUpLinkLink();

	}

	@And("^Login To Platform with newly created user$")
	public void login_to_platform_with_newly_created_user() throws Throwable {
		LoginPage loginToPlatform = new LoginPage(driver);

		loginToPlatform.loginWithNewUser();
	}

	@And("^Login To Platform with Prime user$")
	public void login_to_platform_with_Prime_user() throws Throwable {
		LoginPage loginToPlatform = new LoginPage(driver);

		loginToPlatform.loginWithPrimeUser();
	}

	/**
	 * @Author : rahul shinde
	 * @Date : 02 Aug 2021
	 * @Description: Logout
	 */

	@And("^logout$")
	public void logout() throws Throwable {

		LoginPage loginToPlatform = new LoginPage(driver);

		loginToPlatform.logoutFromPlatform();

	}

	@Then("^Navigate to home page$")
	public void navigate_to_home_page() throws Throwable {

		LoginPage loginToPlatform = new LoginPage(driver);

		loginToPlatform.navigateToHomePage();
	}

	/**
	 * @Author : Chetan Sonparote
	 * @Date : 5 Aug 2021
	 * @Description: Added method for validating login
	 */

	@When("^User clicks login button$")
	public void user_clicks_login_button() throws Throwable {
		// throw new PendingException();
		LoginPage loginPage = new LoginPage(driver);
		loginPage.clickLoginButton();
	}

	@Then("^Validate that error is displayed for invalid user name$")
	public void validate_that_error_is_displayed_for_invalid_user_name() throws Throwable {

		NewBaseClass newBaseClass = new NewBaseClass();

		newBaseClass.validateMessageFromExcel("InvalidUserNameError", "//p[@class='alert__des']");

	}

	@And("^User enters invalid user name and valid password$")
	public void user_enters_invalid_user_name_and_valid_password() throws Throwable {
		// throw new PendingException();
		LoginPage loginPage = new LoginPage(driver);
		loginPage.setInvalidUserData("user");

	}

	@Then("^Validate that error is displayed for invalid password$")
	public void validate_that_error_is_displayed_for_invalid_password() throws Throwable {

		NewBaseClass newBaseClass = new NewBaseClass();

		newBaseClass.validateMessageFromExcel("InvalidPasswordError", "//p[@class='alert__des']");

	}

	@And("^User enters valid user name and invalid password$")
	public void user_enters_valid_user_name_and_invalid_password() throws Throwable {
		// throw new PendingException();
		LoginPage loginPage = new LoginPage(driver);
		loginPage.setInvalidUserData("password");
	}

	@Then("^Validate that error is displayed for invalid details$")
	public void validate_that_error_is_displayed_for_invalid_details() throws Throwable {

		NewBaseClass newBaseClass = new NewBaseClass();

		newBaseClass.validateMessageFromExcel("InvalidDetailsError", "//p[@class='alert__des']");

	}

	@And("^User enters invalid details$")
	public void user_enters_invalid_details() throws Throwable {

		LoginPage loginPage = new LoginPage(driver);
		loginPage.setInvalidUserData("both");
	}
}
