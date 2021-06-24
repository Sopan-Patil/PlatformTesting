package testscripts;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
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
}
