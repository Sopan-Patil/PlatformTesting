package platformstepdefinition;

import org.openqa.selenium.WebDriver;

import base.NewBaseClass;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks extends NewBaseClass {

	/**
	 * @Author : Chetan Sonparote
	 * @Date : 13 Jul 2021
	 * @Description: Hooks for opening and closing browser
	 */
	// NewBaseClass baseClass;// = new NewBaseClass();
	// openbrowser here with param from testng

	public WebDriver driver;

	@Before
	@org.testng.annotations.Parameters(value = { "mode", "browser", "config", "environment" })
	public void setUp(String mode, String browser, String config, String environment) throws Exception {

		System.out.println("inside before hook");
		// driver = new FirefoxDriver();
		// baseClass = new NewBaseClass();
		driver = openBrowser(mode, browser, config, environment);
	}

	// close driver
	@After
	@org.testng.annotations.Parameters(value = { "mode" })
	public void cleanUp(String mode) {
		// driver.close();
		if (mode.equalsIgnoreCase("local")) {
			closebrowser();
		} else if (mode.equalsIgnoreCase("browserstack")) {
			closeBrowserstack();
		}

	}

}
