package testscripts;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.NewBaseClass;
import platform.pageobjects.LoginPage;

/**
 * Author : Chetan Sonparote Date of Creation : 24 Jun 2021 Description: test
 * script to verify login with testng
 */

public class LoginVerification extends NewBaseClass {
	public WebDriver driver;
	private static Logger log = LogManager.getLogger(LoginVerification.class.getName());

	@Test
	public void loginToPlatform() throws Exception {

		LoginPage loginPage = new LoginPage(driver);

		loginPage.loginToPlatform();

	}

	@AfterMethod
	@AfterTest
	public void tearDown() {
		driver.quit();
	}

	@BeforeTest

	// @org.testng.annotations.Parameters(value={"localBrowser", "config",
	// "environment"})
	/*
	 * public void initialize(@Optional("null") String
	 * localBrowser, @Optional("null") String config,
	 * 
	 * @Optional("null") String environment) throws Exception {
	 */
	public void initialize() throws Exception {

		// driver = getDriver(localBrowser, config, environment);

		// driver.get(getEnvironmentURL());
		driver = openbrowser();

		log.info("Navigated to topPage");
	}
}
