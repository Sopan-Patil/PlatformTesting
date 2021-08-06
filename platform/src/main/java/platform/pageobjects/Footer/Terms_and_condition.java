package platform.pageobjects.Footer;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonFunctions;

public class Terms_and_condition {

	List<String[]> testdata;
	public WebDriver driver;
	private static Logger log = LogManager.getLogger(Terms_and_condition.class.getName());

	public Terms_and_condition(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//h3[contains(text(),'「スタギア」利用規約')]")
	public WebElement Terms_and_conditiontitle;

	@FindBy(xpath = "//a[@class='ep-term-section__link d-inline'][normalize-space()='CASEC']")
	public WebElement CASECLink;

	@FindBy(xpath = "//a[@class='ep-term-section__link d-inline'][contains(text(),'塾ピタ')]")
	public WebElement JyukupitaLink;

	@FindBy(xpath = "//a[@class='ep-term-section__link d-inline'][contains(text(),'スタギア大学受験')]")
	public WebElement StudyGearUniverstiyLink;

	@FindBy(xpath = "//a[@class='ep-term-section__link d-inline'][contains(text(),'教育費相談サポート')]")
	public WebElement KyoikuhisoudanLink;

	@FindBy(xpath = "//a[normalize-space()='http://www.jiem.co.jp/privacy/index.html']")
	public WebElement JIEMLink;

	@FindBy(xpath = "//a[normalize-space()='https://support.evidus.com/']")
	public WebElement SupportLink;

	@FindBy(xpath = "//a[normalize-space()='https://www.facebook.com/policy.php']")
	public WebElement FacebookLink;

	@FindBy(xpath = "//a[contains(text(),'https://www.facebook.com/login.php?next=https%3A%2')]")
	public WebElement FacebookOptoutLink;

	@FindBy(xpath = "//a[normalize-space()='https://twitter.com/privacy?lang=jaTwitter']")
	public WebElement TwitterPrvivacyPolicy;

	@FindBy(xpath = "//body//div[@class='ep-term']//div[@class='ep-term-section']//div[@class='ep-term-section']//div[4]")
	public WebElement CustomizedAdLink;

	@FindBy(xpath = "//a[normalize-space()='https://optout.tr.line.me/']")
	public WebElement LinePrivacyPolicyLink;

	@FindBy(xpath = "//font[contains(text(),'https://terms.line.me/line_rules/?lang=jaLINE')]")
	public WebElement LineBehavioralAdvertisingLink;

	@FindBy(xpath = "//font[contains(text(),'https://www.amazon.co.jp/gp/help/customer/display.')]")
	public WebElement AmazonTargetAdTermsLink;

	@FindBy(xpath = "//font[contains(text(),'https://www.amazon.co.jp/adprefs')]")
	public WebElement ChangeDisplaySettingLink;

	@FindBy(xpath = "//font[contains(text(),'https://www.brainpad.co.jp/utility/privacy.html')]")
	public WebElement BrainPadLink;

	@FindBy(xpath = "//font[contains(text(),'https://www.ever-rise.co.jp/privacy')]")
	public WebElement Everrise;

	@FindBy(xpath = "//font[contains(text(),'https://optout.networkadvertising.org/?c=1#!%2F')]")
	public WebElement NetworkAdvertisingLink;

	@FindBy(xpath = "//font[contains(text(),'https://www.aboutads.info/choices/')]")
	public WebElement AboutadsLink;

	@FindBy(xpath = "//font[contains(text(),'http://www.ddai.info/optout')]")
	public WebElement DDAILink;

	public void clickFooterLinksBeforeLogin() throws Exception {

		CommonFunctions.scrolltoElement(CASECLink);
		if (CommonFunctions.isElementClickable(CASECLink)) {
			CASECLink.click();
			log.info("CASEC Link is working");
			driver.navigate().back();
		} else {
			log.error("CASEC Link is not working");
		}

		CommonFunctions.scrolltoElement(JyukupitaLink);
		if (CommonFunctions.isElementClickable(JyukupitaLink)) {
			JyukupitaLink.click();
			log.info("Jyukupita is working");
			driver.navigate().back();
		} else {
			log.error("Jyukupita is not working");
		}

		CommonFunctions.scrolltoElement(StudyGearUniverstiyLink);
		if (CommonFunctions.isElementClickable(StudyGearUniverstiyLink)) {
			StudyGearUniverstiyLink.click();
			log.info("Study Gear University Entry Exam Link is working");
			driver.navigate().back();
		} else {
			log.error("Study Gear University Entry Exam Link is not working");
		}

		CommonFunctions.scrolltoElement(KyoikuhisoudanLink);
		if (CommonFunctions.isElementClickable(KyoikuhisoudanLink)) {
			KyoikuhisoudanLink.click();
			log.info("Kyoikuhi Soudan Link is working");
			driver.navigate().back();
		} else {
			log.error("Kyoikuhi Soudan Link is not working");
		}

		CommonFunctions.scrolltoElement(JIEMLink);
		if (CommonFunctions.isElementClickable(JIEMLink)) {
			JIEMLink.click();
			log.info("JIEM Link is working");
			driver.navigate().back();
		} else {
			log.error("JIEM Link is not working");
		}

		CommonFunctions.scrolltoElement(SupportLink);
		if (CommonFunctions.isElementClickable(SupportLink)) {
			SupportLink.click();
			log.info("Support Link is working");
			driver.navigate().back();
		} else {
			log.error("Support Link is not working");
		}

		CommonFunctions.scrolltoElement(FacebookLink);
		if (CommonFunctions.isElementClickable(FacebookLink)) {
			FacebookLink.click();
			log.info("Facebook Link is working");
			driver.navigate().back();
		} else {
			log.error("Facebook Link is not working");
		}

		CommonFunctions.scrolltoElement(FacebookOptoutLink);
		if (CommonFunctions.isElementClickable(FacebookOptoutLink)) {
			FacebookOptoutLink.click();
			log.info("Facebook Output Link is working");
			driver.navigate().back();
		} else {
			log.error("Facebook Output Link is not working");
		}

		CommonFunctions.scrolltoElement(TwitterPrvivacyPolicy);
		if (CommonFunctions.isElementClickable(TwitterPrvivacyPolicy)) {
			TwitterPrvivacyPolicy.click();
			log.info("Twitter Privacy Policy Link is working");
			driver.navigate().back();
		} else {
			log.error("Twitter Prvivacy Policy Link is not working");
		}

		CommonFunctions.scrolltoElement(CustomizedAdLink);
		if (CommonFunctions.isElementClickable(CustomizedAdLink)) {
			CustomizedAdLink.click();
			log.info("Customized Ad Link is working");
			driver.navigate().back();
		} else {
			log.error("Customized Ad Link is not working");
		}

		CommonFunctions.scrolltoElement(LinePrivacyPolicyLink);
		if (CommonFunctions.isElementClickable(LinePrivacyPolicyLink)) {
			LinePrivacyPolicyLink.click();
			log.info("LINE Privacy Policy Link is working");
			driver.navigate().back();
		} else {
			log.error("LINE Privacy Policy Link is not working");
		}

		CommonFunctions.scrolltoElement(LineBehavioralAdvertisingLink);
		if (CommonFunctions.isElementClickable(LineBehavioralAdvertisingLink)) {
			LineBehavioralAdvertisingLink.click();
			log.info("LINE Behavioral Advertising Link is working");
			driver.navigate().back();
		} else {
			log.error("LINE Behavioral Advertising Link is not working");
		}

		CommonFunctions.scrolltoElement(AmazonTargetAdTermsLink);
		if (CommonFunctions.isElementClickable(AmazonTargetAdTermsLink)) {
			AmazonTargetAdTermsLink.click();
			log.info("Amazon Target Ad Terms Link is working");
			driver.navigate().back();
		} else {
			log.error("Amazon Target Ad Terms Link is not working");
		}

		CommonFunctions.scrolltoElement(ChangeDisplaySettingLink);
		if (CommonFunctions.isElementClickable(ChangeDisplaySettingLink)) {
			ChangeDisplaySettingLink.click();
			log.info("Change Display Setting Link is working");
			driver.navigate().back();
		} else {
			log.error("Change Display Setting Link is not working");
		}

		CommonFunctions.scrolltoElement(BrainPadLink);
		if (CommonFunctions.isElementClickable(BrainPadLink)) {
			BrainPadLink.click();
			log.info("Brain Pad Link is working");
			driver.navigate().back();
		} else {
			log.error("Brain Pad Link is not working");
		}

		CommonFunctions.scrolltoElement(Everrise);
		if (CommonFunctions.isElementClickable(Everrise)) {
			Everrise.click();
			log.info("Everrise Link is working");
			driver.navigate().back();
		} else {
			log.error("Everrise Link is not working");
		}

		CommonFunctions.scrolltoElement(NetworkAdvertisingLink);
		if (CommonFunctions.isElementClickable(NetworkAdvertisingLink)) {
			NetworkAdvertisingLink.click();
			log.info("Network Advertising Link is working");
			driver.navigate().back();
		} else {
			log.error("Network Advertising Link is not working");
		}

		CommonFunctions.scrolltoElement(AboutadsLink);
		if (CommonFunctions.isElementClickable(AboutadsLink)) {
			AboutadsLink.click();
			log.info("Aboutads Link is working");
			driver.navigate().back();
		} else {
			log.error("Aboutads Link is not working");
		}

		CommonFunctions.scrolltoElement(DDAILink);
		if (CommonFunctions.isElementClickable(DDAILink)) {
			DDAILink.click();
			log.info("DDAI LINE Privacy Policy Link is working");
			driver.navigate().back();
		} else {
			log.error("DDAI Link is not working");
		}

	}

}
