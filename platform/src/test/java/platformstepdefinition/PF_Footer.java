package platformstepdefinition;

import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import base.NewBaseClass;
import cucumber.api.junit.Cucumber;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import platform.pageobjects.Authentication.LoginPage;
import platform.pageobjects.Footer.FooterPage_PT90_106;
import platform.pageobjects.Footer.TermsConditionsFooter;
import utils.ObjectHelper;

@RunWith(Cucumber.class)
public class PF_Footer extends NewBaseClass {

	public WebDriver driver = ObjectHelper.driver;

	@Then("^Check footer links on Top Page$")
	public void check_footer_link_on_top_page() throws Throwable {
		FooterPage_PT90_106 footer = new FooterPage_PT90_106(driver);
		footer.clickFooterLinksBeforeLogin();
	}

	@Then("^Check footer links on Login Page$")
	public void check_footer_links_on_login_page() throws Throwable {
		FooterPage_PT90_106 checklinks = new FooterPage_PT90_106(driver);
		checklinks.clickLoginFooterLink();
		checklinks.clickAccountServicesFooterLinks();
		driver.navigate().back();
	}

	@Given("Login to Platform Portal")
	public void login_to_platform_portal() throws Throwable {
		LoginPage login = new LoginPage(driver);
		login.clickLoginButton();
		login.loginToPlatform();
	}

	@Then("^Check footer links on top page after login$")
	public void check_footer_links_after_login_() throws Throwable {
		FooterPage_PT90_106 checklinks = new FooterPage_PT90_106(driver);
		checklinks.clickFooterLinksAfterLogin();
	}

	@Then("^Check Footer Links on First Order Screen$")
	public void check_footer_links_on_first_order_screen_() throws Throwable {
		FooterPage_PT90_106 orderflowone = new FooterPage_PT90_106(driver);
		orderflowone.gotoOrderStepOneForFooterValidation();
		driver.navigate().back();
	}

	@Then("^Check Footer Links on Second Order Screen$")
	public void check_footer_links_on_second_order_screen_() throws Throwable {
		FooterPage_PT90_106 orderflowtwo = new FooterPage_PT90_106(driver);
		orderflowtwo.gotoOrderStepTwoForFooterValidation();
		orderflowtwo.clickOrderFlowFooterLinks();

	}

	@Then("^Check Footer Links on Third Order Screen$")
	public void check_footer_links_on_third_order_screen_() throws Throwable {
		FooterPage_PT90_106 orderflowthree = new FooterPage_PT90_106(driver);
		orderflowthree.gotoOrderStepThreeForFooterValidation();
		orderflowthree.clickOrderFlowFooterLinks();

	}

	@Then("^Check links in Terms of Use Page$")
	public void check_links_on_terms_of_use_page() throws Throwable {
		FooterPage_PT90_106 terms = new FooterPage_PT90_106(driver);
		terms.clickTermsofuseForLinksValidation();
		TermsConditionsFooter checklinks = new TermsConditionsFooter(driver);
		checklinks.ClickLinksinTermsandConditions();
	}

}
