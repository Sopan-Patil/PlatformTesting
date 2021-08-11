package platformrunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/java/platformfeatures/PF_AccountAndSecurity.feature", glue = {
		"platformstepdefinition" }, plugin = {
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" }, monochrome = true, publish = true

)
public class Runner2 extends AbstractTestNGCucumberTests {

}