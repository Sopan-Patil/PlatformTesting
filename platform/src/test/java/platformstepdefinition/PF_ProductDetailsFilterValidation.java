package platformstepdefinition;

import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import base.NewBaseClass;
import cucumber.api.java.en.Then;
import cucumber.api.junit.Cucumber;
import platform.pageobjects.MyPage.ProductDetailsFilterValidation;
import utils.ObjectHelper;

/**
 * @Author : Sopan patil
 * @Date : 09 Aug 2021
 * @Description: step def for membership status
 */
@RunWith(Cucumber.class)
public class PF_ProductDetailsFilterValidation extends NewBaseClass {

	public WebDriver driver = ObjectHelper.driver;

	@Then("^Click on Product List$")
	public void Click_on_Product_List() throws Throwable {
		ProductDetailsFilterValidation ProductDetailsFilterValidation = new ProductDetailsFilterValidation(driver);
		ProductDetailsFilterValidation.CheckProductFilterFeture();

	}

	@Then("^Begin CASEC Product Filter$")
	public void Begin_CASEC_Product_Filter() throws Throwable {
		ProductDetailsFilterValidation ProductDetailsFilterValidation = new ProductDetailsFilterValidation(driver);
		ProductDetailsFilterValidation.CheckProductFilterFeture();

	}

}
