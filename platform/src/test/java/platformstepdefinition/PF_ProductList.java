package platformstepdefinition;

import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import base.NewBaseClass;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.junit.Cucumber;
import platform.pageobjects.Authentication.LoginPage;
import platform.pageobjects.MyPage.Membership;
import platform.pageobjects.MyPage.ProductList;
import utils.ObjectHelper;

@RunWith(Cucumber.class)
public class PF_ProductList extends NewBaseClass {

	public WebDriver driver = ObjectHelper.driver;

	@Given("^Login To PF Portal$")
	public void Login_To_PF_Portal() throws Throwable {
		LoginPage loginpage = new LoginPage(driver);
		loginpage.clickLoginButton();
		loginpage.loginToPlatform();
	}

	@And("^User clicks on Product list$")
	public void User_clicks_on_Product_list() throws Throwable {
		ProductList productListobj = new ProductList(driver);
		productListobj.CheckProductFilterFeature();
	}

	@And("^User clicks on apply for prime membership banner$")
	public void User_clicks_on_apply_for_prime_membership_banner_() throws Throwable {
	}

	@And("^Checks the link validation on member plan page$")
	public void Checks_the_link_validation_on_member_plan_page_() throws Throwable {
		Membership membershipobj = new Membership(driver);
		membershipobj.introduceMembershipPlan();

	}
}
