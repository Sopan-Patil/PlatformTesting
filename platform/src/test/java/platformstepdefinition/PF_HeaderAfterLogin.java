package platformstepdefinition;

import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import base.NewBaseClass;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.junit.Cucumber;
import platform.pageobjects.Authentication.LoginPage;
import platform.pageobjects.Header.HeaderAfterLogin;
import utils.ObjectHelper;

@RunWith(Cucumber.class)
public class PF_HeaderAfterLogin extends NewBaseClass {

	public WebDriver driver = ObjectHelper.driver;

	@When("^User logins$")
	public void User_logins() throws Throwable {
		LoginPage login = new LoginPage(driver);
		login.loginToPlatform();
	}

	@Then("^Validate that menus and SubMenus are Visible$")
	public void Validate_that_menus_and_SubMenus_are_Visible() throws Throwable {
		HeaderAfterLogin headerafterlogin = new HeaderAfterLogin(driver);
		headerafterlogin.checkHeaderMenuAndSubMenuLinksVisibilityAfterLogin();
	}

	@And("^Validate that menus and Submenus are working$")
	public void Validate_that_menus_and_Submenus_are_working() throws Throwable {
		HeaderAfterLogin headerafterlogin = new HeaderAfterLogin(driver);
		headerafterlogin.checkHeaderAndSubMenuLinksWorkingAfterLogin();
	}

}
