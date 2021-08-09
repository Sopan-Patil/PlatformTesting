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

public class Membership {

	List<String[]> testdata;
	public WebDriver driver;
	private static Logger log = LogManager.getLogger(Membership.class.getName());
	int waitTime = 5;

	public Membership(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@class='link js-not-link']")
	public WebElement accountInformation;

	@FindBy(xpath = "//a[@class='submenu__link'][contains(text(),'会員ステータス')]")
	public WebElement membershipStatus;

	@FindBy(xpath = "//div[@class='link-learn__content']")
	public WebElement membershipButton;

	@FindBy(xpath = "//button[@type='submit']")
	public WebElement applyPrime;

	@FindBy(xpath = "//a[@class='box-link__link box-link__link-blue']")
	public WebElement primeBenefit1;

	@FindBy(xpath = "//a[@class='box-link__link box-link__link-orange']")
	public WebElement primeBenefit2;

	@FindBy(xpath = "//a[@class='box-link__link box-link__link-mint']")
	public WebElement primeBenefit3;

	@FindBy(xpath = "//div[@class='ep-order__title']")
	public WebElement orderDetails;

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
			log.info("Clicked on prime benefit 1 on member plan page");
		}

		CommonFunctions.scrolltoElement(primeBenefit2);
		if (CommonFunctions.isElementClickable(primeBenefit2)) {
			primeBenefit2.click();
			log.info("Clicked on prime benefit 2 on member plan page");
		}

		CommonFunctions.scrolltoElement(primeBenefit3);
		if (CommonFunctions.isElementClickable(primeBenefit3)) {
			primeBenefit3.click();
			log.info("Clicked on prime benefit 3 on member plan page ");

			CommonFunctions.scrolltoElement(membershipButton);
			if (CommonFunctions.isElementClickable(membershipButton)) {
				membershipButton.click();
				log.info("Clicked on membership button on member status page");

			}
		}

	}

	public void membershipPlan() throws Exception {
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

	public void membershipPlanPage() throws Exception {
		CommonFunctions.scrolltoElement(applyPrime);
		CommonFunctions.isElementVisible(applyPrime);
		applyPrime.click();
		CommonFunctions.waitForVisiblity(orderDetails, 7);
		String actualString = orderDetails.getText();
		String expectedString = "ご注文内容";
		System.out.println(actualString);
		System.out.println(expectedString);
		Assert.assertEquals(actualString, expectedString);
		log.info("clicked on membership button on member plan page");
		driver.navigate().back();

		CommonFunctions.scrolltoElement(primeBenefit1);
		CommonFunctions.isElementVisible(primeBenefit1);
		primeBenefit1.click();
		log.info("clicked on prime benefit 1 ");

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
