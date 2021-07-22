package platformstepdefinition;

import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import base.NewBaseClass;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.junit.Cucumber;
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

	@Given("^Login To Platform Portal (.+)$")
	public void Login_To_Platform_Portal(String browser) throws Throwable {
		driver = openbrowser(browser);
		LoginPage loginPage = new LoginPage(driver);
		loginPage.clickLoginButton();
		loginPage.loginToPlatform();
	}

	@And("^Click on Membership Status$")
	public void Click_on_Membership_Status() throws Throwable {
		InvalidCC InvalidCC = new InvalidCC(driver);
		InvalidCC.clickAccountInformation();
	}
}
