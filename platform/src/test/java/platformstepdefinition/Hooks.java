package platformstepdefinition;

import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import listeners.Listeners;
import platform.pageobjects.Authentication.LoginPage;
import testlink.api.java.client.TestLinkAPIException;
import testlink.api.java.client.TestLinkAPIResults;
import utils.ObjectHelper;

/**
 * @Author : Chetan Sonparote
 * @Date : 17 Aug 2021
 * @Description: Hook method to capture failure screenshot and attach to report
 */

public class Hooks {
	@AfterStep
	public void addScreenshot(Scenario scenario) throws IOException {

		System.out.println("inside addScreenshot()");
		// validate if scenario has failed
		if (scenario.isFailed()) {
			final byte[] screenshot = ((TakesScreenshot) ObjectHelper.driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png", "image");
		}

	}

	// @AfterMethod
	public void testLinkStatusUpdate(Scenario scenario) throws TestLinkAPIException {
		String notes = null;
		String result = null;
		if (scenario.isFailed()) {
			result = TestLinkAPIResults.TEST_FAILED;
		}
		String status = scenario.getStatus().toString();
		System.out.println("Status: " + status);
		if (status == "PASSED") {
			result = TestLinkAPIResults.TEST_PASSED;
		}
		notes = Listeners.testLinkResult;
		System.out.println("notes: " + notes);
		TestLinkIntegration.updateTestLinkResults("Login Test Case Title", Listeners.testLinkResult, result);
	}

	@Before
	public void setup(Scenario scenario) throws Exception {
		Listeners.scenarioName = scenario.getName();
		System.out.println("scenario name:" + scenario.getName());
		LoginPage loginToPlatform = new LoginPage(ObjectHelper.driver);
		loginToPlatform.navigateToHomePage();
		loginToPlatform.logoutFromPlatform();

	}

}
