package platform.pageobjects.Footer;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonFunctions;

public class TermsConditionsFooter {

	List<String[]> testdata;
	public WebDriver driver;
	private static Logger log = LogManager.getLogger(TermsConditionsFooter.class.getName());

	public TermsConditionsFooter(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[contains(text(),'https://hiiragi.evidus.com/petz1/group/dfs/dantai/')]")
	public WebElement casecTerms;

	@FindBy(xpath = "//a[normalize-space()='https://jyuku-pita.evidus.com/terms.html']")
	public WebElement jyukuPitaTerms;

	@FindBy(xpath = "//a[normalize-space()='https://juken.ei-navi.jp/term-of-use']")
	public WebElement jyukenTerms;

	@FindBy(xpath = "//a[normalize-space()='https://consult.evidus.com/terms/']")
	public WebElement consultTerms;

	@FindBy(xpath = "//a[contains(text(),'https://www.eiken.or.jp/s-cbt/documents/s-cbt_2021')]")
	public WebElement kiyakyuTerms;

	@FindBy(xpath = "//a[normalize-space()='https://www.ei-navi.jp/policy/site_policy.html']")
	public WebElement einaviPolicy;

	@FindBy(xpath = "//a[normalize-space()='https://www.facebook.com/policy.php']")
	public WebElement fbLink;

	@FindBy(xpath = "//a[contains(text(),'https://www.facebook.com/login.php?next=https%3A%2')]")
	public WebElement fbPrivacy;

	@FindBy(xpath = "//a[normalize-space()='https://twitter.com/privacy?lang=jaTwitter']")
	public WebElement twitterPrivacy;

	@FindBy(xpath = "//a[contains(text(),'https://help.twitter.com/ja/safety-and-security/pr')]")
	public WebElement twitterAdsPrivacy;

	@FindBy(xpath = "//a[normalize-space()='https://terms.line.me/line_rules/?lang=jaLINE']")
	public WebElement linePrivacy;

	@FindBy(xpath = "//a[normalize-space()='https://optout.tr.line.me/']")
	public WebElement lineOptout;

	@FindBy(xpath = "//a[contains(text(),'https://www.amazon.co.jp/gp/help/customer/display.')]")
	public WebElement amazonTarget;

	@FindBy(xpath = "//a[normalize-space()='https://www.amazon.co.jp/adprefs']")
	public WebElement amazonAds;

	@FindBy(xpath = "//a[normalize-space()='https://www.brainpad.co.jp/utility/privacy.html']")
	public WebElement brainpadTerms;

	@FindBy(xpath = "//a[normalize-space()='https://www.ever-rise.co.jp/privacy']")
	public WebElement everrisePrivacy;

	@FindBy(xpath = "//a[normalize-space()='https://optout.networkadvertising.org/?c=1#!%2F']")
	public WebElement networkAdvertisingAds;

	@FindBy(xpath = "//a[normalize-space()='https://www.aboutads.info/choices/']")
	public WebElement aboutAds;

	@FindBy(xpath = "//a[normalize-space()='http://www.ddai.info/optout']")
	public WebElement ddaiOptout;

	public void termsFunctions() throws Exception {

		CommonFunctions.scrolltoElement(fbLink);
		if (CommonFunctions.isElementClickable(fbLink)) {
			fbLink.click();
			log.info("FB link from Terms&Conditions is Clicked and Redirected");
		}

		CommonFunctions.scrolltoElement(fbPrivacy);
		if (CommonFunctions.isElementClickable(fbPrivacy)) {
			fbPrivacy.click();
		}

		CommonFunctions.scrolltoElement(twitterPrivacy);
		if (CommonFunctions.isElementClickable(twitterPrivacy)) {
			twitterPrivacy.click();
		}

		CommonFunctions.scrolltoElement(lineOptout);
		if (CommonFunctions.isElementClickable(lineOptout)) {
			lineOptout.click();
		}

		CommonFunctions.scrolltoElement(linePrivacy);
		if (CommonFunctions.isElementClickable(linePrivacy)) {
			linePrivacy.click();
		}

		CommonFunctions.scrolltoElement(amazonTarget);
		if (CommonFunctions.isElementClickable(amazonTarget)) {
			amazonTarget.click();
		}

		CommonFunctions.scrolltoElement(amazonAds);
		if (CommonFunctions.isElementClickable(amazonAds)) {
			amazonAds.click();
		}

		CommonFunctions.scrolltoElement(brainpadTerms);
		if (CommonFunctions.isElementClickable(brainpadTerms)) {
			brainpadTerms.click();
		}

		CommonFunctions.scrolltoElement(everrisePrivacy);
		if (CommonFunctions.isElementClickable(everrisePrivacy)) {
			everrisePrivacy.click();
		}

		CommonFunctions.scrolltoElement(networkAdvertisingAds);
		if (CommonFunctions.isElementClickable(networkAdvertisingAds)) {
			networkAdvertisingAds.click();
		}

		CommonFunctions.scrolltoElement(aboutAds);
		if (CommonFunctions.isElementClickable(aboutAds)) {
			aboutAds.click();
		}

		CommonFunctions.scrolltoElement(ddaiOptout);
		if (CommonFunctions.isElementClickable(ddaiOptout)) {
			ddaiOptout.click();
		}

	}

	public void termsLinks() throws Exception {

		CommonFunctions.scrolltoElement(casecTerms);
		if (CommonFunctions.isElementClickable(casecTerms)) {
			casecTerms.click();
			log.info("FB link from Terms&Conditions is Clicked and Redirected");
		}

		CommonFunctions.scrolltoElement(jyukuPitaTerms);
		if (CommonFunctions.isElementClickable(jyukuPitaTerms)) {
			jyukuPitaTerms.click();
		}

		CommonFunctions.scrolltoElement(jyukenTerms);
		if (CommonFunctions.isElementClickable(jyukenTerms)) {
			jyukenTerms.click();
		}

		CommonFunctions.scrolltoElement(consultTerms);
		if (CommonFunctions.isElementClickable(consultTerms)) {
			consultTerms.click();
		}

		CommonFunctions.scrolltoElement(kiyakyuTerms);
		if (CommonFunctions.isElementClickable(kiyakyuTerms)) {
			kiyakyuTerms.click();
		}

		CommonFunctions.scrolltoElement(einaviPolicy);
		if (CommonFunctions.isElementClickable(einaviPolicy)) {
			einaviPolicy.click();
		}

	}

}