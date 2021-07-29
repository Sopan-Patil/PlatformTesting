package platformrunner;

import org.junit.runner.RunWith;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;

import base.NewBaseClass;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import utils.ObjectHelper;

/**
 * @Author : Chetan Sonparote
 * @Date : 12 Jul 2021
 * @Description: Runner for new projct structure. to be integrated after success
 */

@RunWith(Cucumber.class)
//@ExtendedCucumberOptions(jsonReport = "target/cucumber.json", overviewReport = true, outputFolder = "target")
@CucumberOptions(monochrome = true, strict = false, dryRun = false, features = { ".//src//test//java//platformfeatures/"

},

		glue = { "platformstepdefinition" },

		tags = { "~@FeatureTest", "~@CreateAccountTest", "~@Smoke", "~@PFInvalidCC", "@PFAccountAndSecurity" },

		plugin = { "pretty", "html:target/cucumber_html_report", "json:target/cucumber.json",
				"pretty:target/cucumber-pretty.txt", "usage:target/cucumber-usage.json",
				"junit:target/cucumber_html_report/junit_platform.xml", "rerun:rerun/failed_scenarios.txt", })

public class Runner extends AbstractTestNGCucumberTests {

	NewBaseClass newBaseClass;

	@BeforeTest
	@org.testng.annotations.Parameters(value = { "mode", "browser", "config", "environment" })
	public void setUpBrowser(@Optional("null") String mode, @Optional("null") String browser,
			@Optional("null") String config, @Optional("null") String environment) throws Exception {
		newBaseClass = new NewBaseClass();

		newBaseClass.openBrowser(mode, browser, config, environment);

		newBaseClass.closeZkaiPopup();
	}

	@AfterTest
	@org.testng.annotations.Parameters(value = { "mode" })
	public void closeBrowser(String mode) throws Exception {

		ObjectHelper.driver.quit();
		/*
		 * newBaseClass = new NewBaseClass(); if (mode.equalsIgnoreCase("local")) {
		 * //newBaseClass.closebrowser(); } else if
		 * (mode.equalsIgnoreCase("browserstack")) {
		 * 
		 * BrowserstackUtility browserstackUtility = new BrowserstackUtility(); //
		 * browserstackUtility.tearDown(); // newBaseClass.closeBrowserstack();
		 * 
		 * }
		 */
	}

}