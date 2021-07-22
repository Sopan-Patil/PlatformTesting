package platform.pageobjects.MyPage;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import platform.pageobjects.Authentication.LoginPage;
import utils.CommonFunctions;

/**
 * @Author : Sopan Patil
 * @Date : 22 Jul 2021
 * @Description:Class for entering invalid credit card details
 */

public class InvalidCC {

	List<String[]> testdata;
	public WebDriver driver;
	private static Logger log = LogManager.getLogger(LoginPage.class.getName());
	int waitTime = 5;

	public InvalidCC(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@class='link js-not-link']")
	public WebElement accountInformation;

	@FindBy(xpath = "//a[@class='active']")
	public WebElement memberShipStatus;

	@FindBy(xpath = "//span[contains(text(),'カードを変更')]")
	public WebElement changeCard;

	public void clickAccountInformation() {
		if (CommonFunctions.waitForVisiblity(accountInformation, waitTime)) {

			// Creating object of an Actions class
			Actions action = new Actions(driver);

			// Performing the mouse hover action on the target element.
			action.moveToElement(accountInformation).perform();
			accountInformation.click();
		}
	}

	public void clickChangeCardButton() {
		if (CommonFunctions.waitForVisiblity(changeCard, waitTime)) {
			changeCard.click();
		}

	}

}
