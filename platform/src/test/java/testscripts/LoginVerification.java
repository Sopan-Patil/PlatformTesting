package testscripts;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Test;

import base.NewBaseClass;
import platform.pageobjects.LoginPage;

/**
 * @Author : Chetan Sonparote
 * @Date : 24 Jun 2021
 * @Description: test script to verify login with testng. Only for testing
 *               purposes as a sample
 */

public class LoginVerification extends NewBaseClass {
	public WebDriver driver;
	private static Logger log = LogManager.getLogger(LoginVerification.class.getName());
	// timestamp
	private static final SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
	Timestamp timestamp = new Timestamp(System.currentTimeMillis());

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
	@org.testng.annotations.Parameters(value = { "localBrowser" })
	public void initialize(@Optional("null") String localBrowser) throws Exception {

		// driver = getDriver(localBrowser, config, environment);

		// driver.get(getEnvironmentURL());

		System.out.println("timestamp manual log");

		System.out.println(sdf1.format(timestamp));

		driver = openbrowser(localBrowser);
		log.info(sdf1.format(timestamp) + " log with timestamp");
		log.info("Navigated to topPage");
		log.trace("Trace Message!");
		log.debug("Debug Message!");
		log.info("Info Message!");
		log.warn("Warn Message!");
		log.error("Error Message!");
		log.fatal("Fatal Message!");
	}
}
