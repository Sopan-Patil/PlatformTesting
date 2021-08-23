package platformstepdefinition;

import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import platform.pageobjects.localization.LocalizationData;
import utils.ObjectHelper;

/**
 * @Author : Chetan Sonparote
 * @Date : 17 Aug 2021
 * @Description: Hook method to capture failure screenshot and attach to report
 */

public class Hooks {
	@AfterStep
	public void addScreenshot(Scenario scenario) throws IOException {

		if (scenario.isFailed()) {
			final byte[] screenshot = ((TakesScreenshot) ObjectHelper.driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png", "image");
			// scenario.attach();
		}
	}

	/**
	 * @Author : Chetan Sonparote
	 * @Date : 23 Aug 2021
	 * @Description: Hook method to print log after localization check
	 */
	@After("@PF_Localization_WithLogin or @PF_Localization_FreeUser or @PF_Localization_NoLogin or @PF_Localization_PrimeUser or @PF_Localization")
	public void addData(Scenario scenario) throws IOException {

		scenario.log(LocalizationData.status.get(0));
		// String status = "Total strings validated = " +
		// LocalizationData.serialNumber.size() + "\n";

		scenario.log("Total strings validated = " + LocalizationData.serialNumber.size() + "\n");
		scenario.log("Total strings passed = " + LocalizationData.passCount + "\n");
		scenario.log("Total strings failed = " + LocalizationData.failCount + "\n");
		for (int i = 0; i < LocalizationData.url.size(); i++) {
			scenario.log("URL :" + LocalizationData.url.get(i).trim());
			scenario.log("Expected String :" + LocalizationData.expectedStrings.get(i).trim());
			scenario.log(LocalizationData.status.get(i + 1));
		}

	}

}
