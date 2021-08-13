package platform.pageobjects.MyPage;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonFunctions;
import utils.XLHandler;

public class Membership {

	List<String[]> testdata;
	public WebDriver driver;
	private static Logger log = LogManager.getLogger(Membership.class.getName());
	int waitTime = 5;
	String[] shipmentdata;
	String freeuser;

	public Membership(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@class='link js-not-link']")
	public WebElement accountInformation;

	@FindBy(xpath = "//div[@class='header__control']//li[2]//a[1]")
	public WebElement membershipStatus;

	@FindBy(xpath = "//div[@class='link-learn__content']")
	public WebElement membershipButton;

	@FindBy(xpath = "//button[@type='submit']")
	public WebElement applyPrime;

	@FindBy(xpath = "//a[@class='box-link__link box-link__link-blue']")
	public WebElement primeBenefit1Link;

	@FindBy(xpath = "//a[@class='box-link__link box-link__link-orange']")
	public WebElement primeBenefit2Link;

	@FindBy(xpath = "//a[@class='box-link__link box-link__link-mint']")
	public WebElement primeBenefit3Link;

	@FindBy(xpath = "//div[@class='ep-order__title']")
	public WebElement orderDetails;

	public void becomePrimeMember() throws Exception {
		shipmentdata = XLHandler.readexcel("MemberPlanAssert", "NewTestData.xlsx");
		CommonFunctions.scrolltoElement(applyPrime);
		if (CommonFunctions.isElementClickable(applyPrime)) {
			applyPrime.click();
			log.info("clicked on apply prime button on member plan page");
			driver.navigate().back();
		}

		CommonFunctions.scrolltoElement(primeBenefit1Link);
		if (CommonFunctions.isElementClickable(primeBenefit1Link)) {
			primeBenefit1Link.click();
			log.info("Clicked on prime benefit 1 link on member plan page");
		}

		CommonFunctions.scrolltoElement(primeBenefit2Link);
		if (CommonFunctions.isElementClickable(primeBenefit2Link)) {
			primeBenefit2Link.click();
			log.info("Clicked on prime benefit 2 link on member plan page");
		}

		CommonFunctions.scrolltoElement(primeBenefit3Link);
		if (CommonFunctions.isElementClickable(primeBenefit3Link)) {
			primeBenefit3Link.click();
			log.info("Clicked on prime benefit 3 link on member plan page ");

			CommonFunctions.scrolltoElement(membershipButton);
			if (CommonFunctions.isElementClickable(membershipButton)) {
				membershipButton.click();
				log.info("Clicked on membership button on member status page");

			}
		}

	}

	public void applyPrimeMembership() throws Exception {
		Actions actions = new Actions(driver);
		actions.moveToElement(accountInformation).perform();
		log.info("Opened Submenu");
		membershipStatus.click();
		log.info("Opened membership status page");

		CommonFunctions.scrolltoElement(membershipButton);
		CommonFunctions.isElementVisible(membershipButton);
		membershipButton.click();
		log.info("clicked on membership button on member status page");

	}

	public void introduceMembershipPlan() throws Exception {
		shipmentdata = XLHandler.readexcel("MemberPlanAssert", "NewTestData.xlsx");
		CommonFunctions.scrolltoElement(applyPrime);
		CommonFunctions.isElementVisible(applyPrime);
		applyPrime.click();
		CommonFunctions.waitForVisiblity(orderDetails, 7);
		String actualString = orderDetails.getText();
		String expectedString = shipmentdata[0].toString();
		Assert.assertEquals(actualString, expectedString);
		log.info("clicked on membership button on member plan page");
		driver.navigate().back();

		CommonFunctions.scrolltoElement(primeBenefit1Link);
		CommonFunctions.isElementVisible(primeBenefit1Link);
		primeBenefit1Link.click();
		log.info("clicked on prime benefit 1");

		CommonFunctions.scrolltoElement(primeBenefit2Link);
		CommonFunctions.waitForVisiblity(primeBenefit2Link, waitTime);
		primeBenefit2Link.click();
		log.info("clicked on prime benefit 2");

		CommonFunctions.scrolltoElement(primeBenefit3Link);
		CommonFunctions.waitForVisiblity(primeBenefit3Link, waitTime);
		primeBenefit3Link.click();
		log.info("clicked on prime benefit 3");

	}

}
