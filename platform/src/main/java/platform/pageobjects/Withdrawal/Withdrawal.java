package platform.pageobjects.Withdrawal;

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
 * @Author : Sahaj Balgunde
 * @Date of Creation : 12 Jul 2021
 * @Description: Additional Locator variables and Methods for withdrawal page.
 */

public class Withdrawal {
	List<String[]> testdata;
	public WebDriver driver;
	private static Logger log = LogManager.getLogger(LoginPage.class.getName());
	int waitTime = 30;

	public Withdrawal(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//span[@class='checkmark']")
	public WebElement withdrawalCheck;

	@FindBy(xpath = "//a[@class='button button--gray button--medium button--coupon-back']//span[contains(text(),'戻る')]")
	public WebElement back;

	@FindBy(xpath = "//button[@role='button']")
	public WebElement withdrawAccount;

	@FindBy(xpath = "//h1[contains(@class,'')]//a[contains(@class,'logo')]")
	public WebElement topButton;

	@FindBy(xpath = "//div[@id='footer']//li[4]//ul[1]//li[5]//a[1]")
	public WebElement footerWithdrawalLink;

	public void gotoWithdrawalPage() throws Exception {

		CommonFunctions.scrolltoElement(footerWithdrawalLink);
		if (CommonFunctions.isElementClickable(footerWithdrawalLink)) {
			footerWithdrawalLink.click();
			driver.navigate().back();
		} else {
			log.error("Withdrawal Link is not working");
		}
	}

	public void executeWithdrawalFunction() throws Exception {

		CommonFunctions.scrolltoElement(withdrawalCheck);
		if (CommonFunctions.isElementClickable(withdrawalCheck)) {
			withdrawalCheck.click();
			System.out.println("Withdrawal Checked");

			if (CommonFunctions.isElementClickable(withdrawAccount)) {
				withdrawAccount.click();
				System.out.println("Account Deleted");
			}
		}
	}

	public void withdrawButtons() throws Exception {

		CommonFunctions.waitForVisiblity(back, 3);
		back.click();
		log.info("Check the back Button");

		CommonFunctions.waitForVisiblity(topButton, 3);
		topButton.click();
		log.info("Check the Top Button");

	}
}
