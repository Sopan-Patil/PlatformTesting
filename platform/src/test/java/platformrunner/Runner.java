package platformrunner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.runner.RunWith;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import base.NewBaseClass;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import utils.ObjectHelper;

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

		tags = { "@PF_test" },

		// tags = { "@Smoke" },

		plugin = { "pretty", "html:target/cucumber_html_report", "json:target/cucumber.json",
				"pretty:target/cucumber-pretty.txt", "usage:target/cucumber-usage.json",
				"junit:target/cucumber_html_report/junit_platform.xml", "rerun:rerun/failed_scenarios.txt",
		/* "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" */ })

public class Runner extends AbstractTestNGCucumberTests {

	NewBaseClass newBaseClass;

	private static Logger log = LogManager.getLogger(Runner.class.getName());

	@BeforeTest
	@org.testng.annotations.Parameters(value = { "mode", "browser", "config", "environment" })
	public void setUpBrowser(@org.testng.annotations.Optional("null") String mode,
			@org.testng.annotations.Optional("null") String browser,
			@org.testng.annotations.Optional("null") String config,
			@org.testng.annotations.Optional("null") String environment) throws Exception {
		// public void setUpBrowser(String mode, String browser, String config, String
		// environment) throws Exception {

		newBaseClass = new NewBaseClass();

		log.info("mode:" + mode);
		log.info("browser:" + browser);
		log.info("config:" + config);
		log.info("environment:" + environment);

		newBaseClass.openBrowser(mode, browser, config, environment);

	}

	@AfterTest
	public void closeBrowser() throws Exception {

		ObjectHelper.driver.quit();

	}

}
