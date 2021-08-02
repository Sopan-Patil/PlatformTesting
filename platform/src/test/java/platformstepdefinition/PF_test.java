package platformstepdefinition;

import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import base.NewBaseClass;
import cucumber.api.java.en.Then;
import cucumber.api.junit.Cucumber;
import platform.pageobjects.Footer.FooterPage;
import utils.ObjectHelper;

/**
 * @Author : Chetan Sonparote
 * @Date : 29 Jul 2021
 * @Description: test class
 */

@RunWith(Cucumber.class)
public class PF_test extends NewBaseClass {

	public WebDriver driver = ObjectHelper.driver;

	@Then("^run test$")
	public void run_test() throws Throwable {
		// throw new PendingException();
		FooterPage footerPage = new FooterPage(driver);
		footerPage.clickTermsOfUseLink();
	}

}
