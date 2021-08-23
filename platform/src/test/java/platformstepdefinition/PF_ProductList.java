package platformstepdefinition;

import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import base.NewBaseClass;
import cucumber.api.junit.Cucumber;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import platform.pageobjects.Authentication.LoginPage;
import platform.pageobjects.MyPage.ProductList;
import utils.ObjectHelper;

@RunWith(Cucumber.class)
public class PF_ProductList extends NewBaseClass {

	public WebDriver driver = ObjectHelper.driver;

	@When("^Login To PF Portal$")
	public void Login_To_PF_Portal() throws Throwable {
		LoginPage loginpage = new LoginPage(driver);
		loginpage.clickLoginButton();
		loginpage.loginToPlatform();
	}

	@And("^User clicks on Product list$")
	public void User_clicks_on_Product_list_() throws Throwable {
		ProductList productListobj = new ProductList(driver);
		productListobj.clickProductList();
	}

	@Then("^Validate various buttons$")
	public void Validate_narrow_down_button() throws Throwable {
		ProductList productListobj = new ProductList(driver);
		productListobj.checkButtonsOnProductListPage();
	}

}
