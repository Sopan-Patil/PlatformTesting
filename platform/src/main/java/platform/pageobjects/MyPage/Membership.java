package platform.pageobjects.MyPage;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

	@FindBy(xpath = "//button[@class='button button--default button--xmedium button--member-plan aos-init aos-animate']")
	public WebElement applyPrime;

	@FindBy(xpath = "//a[@class='box-link__link box-link__link-blue']")
	public WebElement primeBenefit1;

	@FindBy(xpath = "//a[@class='box-link__link box-link__link-orange']")
	public WebElement primeBenefit2;

	@FindBy(xpath = "//a[@class='box-link__link box-link__link-mint']")
	public WebElement primeBenefit3;

	@FindBy(xpath = "//a[contains(text(),'8月実施分')]")
	public WebElement augustMembership;

	@FindBy(xpath = "//a[contains(text(),'9月実施分')]")
	public WebElement septemberMembership;

	@FindBy(xpath = "//a[contains(text(),'詳しくはこちら')]")
	public WebElement clickhereformoredetails;

	@FindBy(xpath = "//div[@class='teaser-head teaser-head--ft']//form")
	public WebElement applyforPrime2;

	@FindBy(xpath = "//button[@class='button button--default button--xmedium button--member-plan button--member-plan-last aos-init aos-animate']")
	public WebElement applyforPrime3;

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

		CommonFunctions.scrolltoElement(augustMembership);
		if (CommonFunctions.isElementClickable(augustMembership)) {
			augustMembership.click();
			log.info("clicked on august membership button member plan page");
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
			if (CommonFunctions.isElementClickable(applyforPrime3)) {
				applyforPrime2.click();
				log.info("clicked on apply prime button on member plan page");
				driver.navigate().back();
			}

		}

	}
}
