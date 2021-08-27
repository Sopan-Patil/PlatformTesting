package platform.pageobjects.Withdrawal_PT_111;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonFunctions;

/**
 * @Author : Sahaj Balgunde
 * @Date of Creation : 12 Jul 2021
 * @Description: Additional Locator variables and Methods for withdrawal page.
 */

public class Withdrawal_PT_111 {
	List<String[]> testdata;
	public WebDriver driver;
	private static Logger log = LogManager.getLogger(Withdrawal_PT_111.class.getName());
	int waitTime = 30;

	public Withdrawal_PT_111(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//h1[contains(@class,'')]//a[contains(@class,'logo')]")
	public WebElement topButton;

	@FindBy(xpath = "//a[@href = '/withdraw-confirm']")
	public WebElement footerWithdrawalLink;

	public void gotoWithdrawalPage() throws Exception {

		CommonFunctions.isElementVisible(footerWithdrawalLink);
		if (CommonFunctions.waitForVisiblity(footerWithdrawalLink, waitTime)) {
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			footerWithdrawalLink.click();
			log.info("Opened Withdrawal Link");
		} else {
			log.error("Withdrawal Link is not working");
		}
	}

	public void checkWithdrawtopPageButtons() throws Exception {

		if (CommonFunctions.waitForVisiblity(topButton, 3)) {
			topButton.click();
			log.info("Top button is clickable");
		} else {
			log.error("Top button is clickable");
		}

	}
}
