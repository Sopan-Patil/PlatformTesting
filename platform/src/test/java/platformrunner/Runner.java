package platformrunner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.runner.RunWith;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

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

		// tags = { "@PF_test" },


	//	tags = { "@PFAccountAndSecurity, @PFAccountAndSecurityCancel" },


		plugin = { "pretty", "html:target/cucumber_html_report", "json:target/cucumber.json",
				"pretty:target/cucumber-pretty.txt", "usage:target/cucumber-usage.json",
				"junit:target/cucumber_html_report/junit_platform.xml", "rerun:rerun/failed_scenarios.txt",
		/* "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" */ })

public class Runner extends AbstractTestNGCucumberTests {

	NewBaseClass newBaseClass;

	private static Logger log = LogManager.getLogger(Runner.class.getName());

	@BeforeMethod(alwaysRun = true)
	@org.testng.annotations.Parameters(value = { "mode", "browser", "config", "environment" })
	public void setUpBrowser(@org.testng.annotations.Optional("null") String mode,
			@org.testng.annotations.Optional("null") String browser,
			@org.testng.annotations.Optional("null") String config,
			@org.testng.annotations.Optional("null") String environment) throws Exception {
//	public void setUpBrowser(String mode, String browser, String config, String environment) throws Exception {

		newBaseClass = new NewBaseClass();
//
//		log.error("mode:" + mode);
//		log.error("browser:" + browser);
//		log.error("config:" + config);
//		log.error("environment:" + environment);

		newBaseClass.openBrowser(mode, browser, config, environment);

	}

	@AfterMethod(alwaysRun = true)
	public void closeBrowser() throws Exception {

		ObjectHelper.driver.quit();

	}

}
