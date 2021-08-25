package platformstepdefinition;

import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import platform.pageobjects.Authentication.LoginPage;
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

	@Before
	public void setup() throws Exception {

		LoginPage loginToPlatform = new LoginPage(ObjectHelper.driver);
		loginToPlatform.navigateToHomePage();
		loginToPlatform.logoutFromPlatform();

	}

}
