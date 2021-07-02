package platformrunner;

import org.junit.runner.RunWith;

import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@RunWith(ExtendedCucumber.class)
@ExtendedCucumberOptions(jsonReport = "target/cucumber.json", overviewReport = true, outputFolder = "target")

@CucumberOptions(monochrome = true, strict = false, dryRun = false, features = {
		".//src//test//java//platformfeatures/PFQA_123_1.feature"

}, glue = { "platformstepdefinition" }, tags = { "@FunctionalTest", "~@BrowserstackTest" }, plugin = { "pretty",
		"html:target/cucumber_html_report", "json:target/cucumber.json", "pretty:target/cucumber-pretty.txt",
		"usage:target/cucumber-usage.json", "junit:target/cucumber_html_report/junit_platform.xml" })
public class PlatformTestRunners extends AbstractTestNGCucumberTests {
}