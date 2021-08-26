package platformstepdefinition;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import base.NewBaseClass;
import cucumber.api.junit.Cucumber;
import io.cucumber.java.en.Then;
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

	private static final Logger log = LogManager.getLogger(PF_test.class.getName());

	@Then("^run test$")
	public void run_test() throws Throwable {
		// throw new PendingException();
		FooterPage footerPage = new FooterPage(driver);
		footerPage.clickTermsOfUseLink();
		log.info("log message as info");
		log.debug("log message as debug");

		log.error("log message as error");
		log.fatal("log message as fatal");
		log.trace("log message as trace");
		log.warn("log message as warn");
		// Assert.assertTrue(false);
	}

}
