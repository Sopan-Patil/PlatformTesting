package platformstepdefinition;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import base.NewBaseClass;
import cucumber.api.junit.Cucumber;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import platform.pageobjects.localization.LocalizationData;
import utils.ObjectHelper;

/**
 * @Author : Chetan Sonparote
 * @Date : 29 Jul 2021
 * @Description: test class
 */

@RunWith(Cucumber.class)
public class PF_Localization extends NewBaseClass {

	public WebDriver driver = ObjectHelper.driver;
	private static Logger log = LogManager.getLogger(PF_Localization.class.getName());

	@When("^Read localization data from sheet$")
	public void read_localization_data_from_sheet(List<String> userState) throws Throwable {

		String sheetName = userState.get(0);

		log.info("sheetName :" + sheetName);
		LocalizationData localizationData = new LocalizationData(driver);
		localizationData.readLocalizationData(sheetName);

	}

	@Then("^Validate that localization is correct$")
	public void validate_that_localization_is_correct() throws Throwable {
		// throw new PendingException();
		LocalizationData localizationData = new LocalizationData(driver);
		localizationData.validateLocalizationData();
	}

}
