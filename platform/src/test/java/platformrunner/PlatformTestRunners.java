package platformrunner;

import org.junit.runner.RunWith;

import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@RunWith(ExtendedCucumber.class)
@ExtendedCucumberOptions(jsonReport = "target/cucumber.json", overviewReport = true, outputFolder = "target")

@CucumberOptions(monochrome = true, strict = false, dryRun = false, features = {

		".//src//test//java//platformfeatures/PF_Order.feature"


		".//src//test//java//platformfeatures/" }, glue = { "platformstepdefinition" }, tags = { "~@FooterTest",
				"@FunctionalTest", "~@BrowserstackTest", "~@FunctionalLoginTest", "@PF_InvalidCC" }, plugin = {
						"pretty", "html:target/cucumber_html_report", "json:target/cucumber.json",
						"pretty:target/cucumber-pretty.txt", "usage:target/cucumber-usage.json",
						"junit:target/cucumber_html_report/junit_platform.xml", "rerun:rerun/failed_scenarios.txt",

		/* "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:", */ })

public class PlatformTestRunners extends AbstractTestNGCucumberTests {
}