package platform.pageobjects.AccountServices;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import platform.pageobjects.Authentication.LoginPage;
import utils.CommonFunctions;

/**
 * @Author : Chetan Sonparote
 * @Date : 21 Jul 2021
 * @Description:Class for confirming details on step 5
 */

public class CreateAccountStep5 {

	List<String[]> testdata;
	public WebDriver driver;
	private static Logger log = LogManager.getLogger(LoginPage.class.getName());
	int waitTime = 5;

	public CreateAccountStep5(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[@class='button__text' or contains(text(),'Start using the service')]")
	public WebElement startServiceButton;

	@FindBy(xpath = "//*[contains(text(),'スタギアトップへ') or contains(text(),'To the staggered top')]")
	public WebElement gotoTopLink;

	public void clickStartServiceButton() {

		if (CommonFunctions.waitForVisiblity(startServiceButton, waitTime)) {

			startServiceButton.click();
		}

	}

	public void clickGotoTopLink() {

		if (CommonFunctions.waitForVisiblity(gotoTopLink, waitTime)) {

			gotoTopLink.click();
		}

	}
}
