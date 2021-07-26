package platform.pageobjects.MyPage;

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

	@FindBy(xpath = "//div[@class='ep-my-page__side-bar']//a[2]")
	public WebElement memberShipStatus;

	@FindBy(xpath = "//a[contains(@class,'button button--default button--xmedium')]")
	public WebElement changeCard;

	@FindBy(xpath = "//input[@id='cardno']")
	public WebElement creditCardTextField;

	@FindBy(xpath = "//input[@id='holdername']")
	public WebElement creditCardHolderNameTextField;

	public void clickAccountInformation() {
		if (CommonFunctions.waitForVisiblity(accountInformation, waitTime)) {
			accountInformation.click();

		}
	}

	public void ClickMmemberShipStatus() {
		if (CommonFunctions.waitForVisiblity(memberShipStatus, waitTime)) {
			memberShipStatus.click();
		}
	}

	public void clickChangeCardButton() {
		if (CommonFunctions.waitForVisiblity(changeCard, waitTime)) {
			changeCard.click();
		}

	}

}
