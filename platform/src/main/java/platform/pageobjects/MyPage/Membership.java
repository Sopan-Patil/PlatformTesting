package platform.pageobjects.MyPage;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonFunctions;

public class Membership {

	List<String[]> testdata;
	public WebDriver driver;
	private static Logger log = LogManager.getLogger(Membership.class.getName());
	int waitTime = 5;

	public Membership(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "/html/body/div/div[4]/div[1]/form/button")
	public WebElement applyPrime;

	@FindBy(xpath = "/html/body/div/div[4]/div[2]/ul/li[1]/a")
	public WebElement primeBenefit1;

	@FindBy(xpath = "/html/body/div/div[4]/div[2]/ul/li[2]/a")
	public WebElement primeBenefit2;

	@FindBy(xpath = " /html/body/div/div[4]/div[2]/ul/li[3]/a")
	public WebElement primeBenefit3;

	@FindBy(xpath = "")
	public WebElement clickhereformoredetails;

	@FindBy(xpath = "//div[@class='teaser-head teaser-head--ft']//form")
	public WebElement applyforPrime2;

	@FindBy(xpath = "//button[@class='button button--default button--xmedium button--member-plan button--member-plan-last aos-init aos-animate']")
	public WebElement applyforPrime3;

	@FindBy(xpath = "/html/body/div/div[1]/div[1]/div/div[2]/div/div/a")
	public WebElement accountInformation;

	@FindBy(xpath = "/html/body/div/div[1]/div[1]/div/div[2]/div/div/div/ul/li[2]/a")
	public WebElement membershipStatus;

	@FindBy(xpath = "//div[@class='link-learn__content']")
	public WebElement membershipButton;

	public void membershipFunctions() throws Exception {

		CommonFunctions.scrolltoElement(applyPrime);
		if (CommonFunctions.isElementClickable(applyPrime)) {
			applyPrime.click();
			log.info("clicked on apply prime button on member plan page");
			driver.navigate().back();
		}

		CommonFunctions.scrolltoElement(primeBenefit1);
		if (CommonFunctions.isElementClickable(primeBenefit1)) {
			primeBenefit1.click();
			log.info("clicked on prime benefit 1 on member plan page");
		}

		CommonFunctions.scrolltoElement(primeBenefit2);
		if (CommonFunctions.isElementClickable(primeBenefit2)) {
			primeBenefit2.click();
			log.info("clicked on prime benefit 2 on member plan page");
		}

		CommonFunctions.scrolltoElement(primeBenefit3);
		if (CommonFunctions.isElementClickable(primeBenefit3)) {
			primeBenefit3.click();
			log.info("clicked on prime benefit 3 on member plan page ");

		}

		CommonFunctions.scrolltoElement(septemberMembership);
		if (CommonFunctions.isElementClickable(septemberMembership)) {
			septemberMembership.click();
			log.info("clicked on september membership button member plan page");

			CommonFunctions.scrolltoElement(clickhereformoredetails);
			if (CommonFunctions.isElementClickable(clickhereformoredetails)) {
				clickhereformoredetails.click();
				log.info("clicked on clickhereformoredetails button member plan page");
			}

			CommonFunctions.scrolltoElement(applyforPrime2);
			if (CommonFunctions.isElementClickable(applyforPrime2)) {
				applyforPrime2.click();
				log.info("clicked on apply prime button on member plan page");
				driver.navigate().back();
			}

			CommonFunctions.scrolltoElement(applyforPrime2);
			if (CommonFunctions.isElementClickable(applyforPrime)) {
				applyforPrime2.click();
				log.info("clicked on apply prime button on member plan page");
				driver.navigate().back();
			}

			CommonFunctions.scrolltoElement(membershipButton);
			if (CommonFunctions.isElementClickable(membershipButton)) {
				membershipButton.click();
				log.info("clicked on membership button on member status page");

			}
		}

	}

	public void membershipPlan() throws Exception {
		Actions actions = new Actions(driver);
		actions.moveToElement(accountInformation).perform();
		log.info("Opened Submenu");
		Thread.sleep(100);
		membershipStatus.click();
		log.info("Opened membership status page");
		Thread.sleep(200);
		// driver.navigate().back();

		CommonFunctions.scrolltoElement(membershipButton);
		CommonFunctions.isElementVisible(membershipButton);
		membershipButton.click();
		log.info("clicked on membership button on member status page");

		CommonFunctions.scrolltoElement(applyPrime);
		CommonFunctions.isElementVisible(applyPrime);
		applyPrime.click();
		log.info("clicked on membership button on member plan page");
		driver.navigate().back();

		CommonFunctions.scrolltoElement(primeBenefit1);
		CommonFunctions.isElementVisible(primeBenefit1);
		primeBenefit1.click();
		log.info("clicked on prime benefit 1 ");
		Thread.sleep(200);

		CommonFunctions.scrolltoElement(primeBenefit2);
		CommonFunctions.waitForVisiblity(primeBenefit2, waitTime);
		primeBenefit2.click();
		log.info("clicked on prime benefit 2 ");

		CommonFunctions.scrolltoElement(primeBenefit3);
		CommonFunctions.waitForVisiblity(primeBenefit3, waitTime);
		primeBenefit3.click();
		log.info("clicked on prime benefit 3");

	}

}
