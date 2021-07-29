package platformstepdefinition;

import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import base.NewBaseClass;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.junit.Cucumber;
import platform.pageobjects.Authentication.LoginPage;
import platform.pageobjects.Order.Order;
import utils.ObjectHelper;

@RunWith(Cucumber.class)
public class PF_Order extends NewBaseClass {

	public WebDriver driver = ObjectHelper.driver;

	String emailid = "";

	@Given("^Login To Platform Portal$")
	public void Login_To_Platform_Portal() throws Throwable {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.clickLoginButton();
		loginPage.loginToPlatform();
	}

	@And("^Perform order valid credit card flow$")
	public void Order_Credit_Card_Valid() throws Throwable {
		Order orderCreditCardValidObj = new Order(driver);
		orderCreditCardValidObj.orderWithValidConvenienceStore();
	}

}
