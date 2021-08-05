package platformrunner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.runner.RunWith;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;

import base.NewBaseClass;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import utils.BrowserstackUtility;

/**
 * @Author : Chetan Sonparote
 * @Date : 12 Jul 2021
 * @Description: Runner for new project structure. to be integrated after
 *               success
 */

@RunWith(Cucumber.class)
//@ExtendedCucumberOptions(jsonReport = "target/cucumber.json", overviewReport = true, outputFolder = "target")
@CucumberOptions(monochrome = true, strict = false, dryRun = false, features = { ".//src//test//java//platformfeatures/"

},

		glue = { "platformstepdefinition" },

		// tags = { "~@FeatureTest", "~@CreateAccountTest", "~@Smoke", "~@PFInvalidCC",
		// "@PFAccountAndSecurity" },

		tags = { "@OrderWithConvenienceStoreInValid" },

		plugin = { "pretty", "html:target/cucumber_html_report", "json:target/cucumber.json",
				"pretty:target/cucumber-pretty.txt", "usage:target/cucumber-usage.json",
				"junit:target/cucumber_html_report/junit_platform.xml", "rerun:rerun/failed_scenarios.txt",
		/* "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" */ })

public class Runner extends AbstractTestNGCucumberTests {

	NewBaseClass newBaseClass;
	BrowserstackUtility browserstackUtility;
	private static Logger log = LogManager.getLogger(Runner.class.getName());

	@BeforeTest
	@org.testng.annotations.Parameters(value = { "mode", "browser", "config", "environment" })
	public void setUpBrowser(@Optional("null") String mode, @Optional("null") String browser,
			@Optional("null") String config, @Optional("null") String environment) throws Exception {

		newBaseClass = new NewBaseClass();
		browserstackUtility = new BrowserstackUtility();
		log.info("mode:" + mode);
		log.info("browser:" + browser);
		log.info("config:" + config);
		log.info("environment:" + environment);

		newBaseClass.openBrowser(mode, browser, config, environment);
		/*
		 * if (mode.equalsIgnoreCase("local")) { ObjectHelper.driver =
		 * newBaseClass.openbrowser(browser); } else if
		 * (mode.equalsIgnoreCase("browserstack")) { ObjectHelper.driver =
		 * browserstackUtility.initializaBrowserstackDriver(config, environment); //
		 * openBrowserstack(config, environment);
		 * 
		 * }
		 */

		// newBaseClass.closeZkaiPopup();
	}

	@AfterTest
	public void closeBrowser() throws Exception {

		// ObjectHelper.driver.quit();

		// ObjectHelper.driver.quit();
		/*
		 * newBaseClass = new NewBaseClass(); if (mode.equalsIgnoreCase("local")) { //
		 * newBaseClass.closebrowser(); } else if
		 * (mode.equalsIgnoreCase("browserstack")) {
		 * 
		 * // BrowserstackUtility browserstackUtility = new BrowserstackUtility(); // //
		 * browserstackUtility.tearDown(); // newBaseClass.closeBrowserstack();
		 * 
		 * }
		 */

	}

}
