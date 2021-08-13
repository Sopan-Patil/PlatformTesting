package platform.pageobjects.Footer;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonFunctions;
import utils.XLHandler;

/**
 * @Author : Sanae Komatsu
 * @Date of Creation : 2 Aug 2021
 * @Description: Locator variables for Terms of Use Footer.
 */

public class TermsConditionsFooter {

	List<String[]> testdata;
	public WebDriver driver;
	private static Logger log = LogManager.getLogger(TermsConditionsFooter.class.getName());
	String[] shipmentdata;

	public TermsConditionsFooter(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void switchToPreviousTab() {
		ArrayList<String> tab = new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(tab.get(1));
		driver.close();
		driver.switchTo().window(tab.get(0));
		// driver.close();
	}

	@FindBy(xpath = "//div[@class='container container--small']//div[3]//div[1]//a[1]")
	public WebElement casecTermsLink;

	@FindBy(xpath = "//div[@class='container container--small']//div[3]//div[1]//a[2]")
	public WebElement jyukuPitaTermsLink;

	@FindBy(xpath = "//div[@class='container container--small']//div[3]//div[1]//a[3]")
	public WebElement jyukenTermsLink;

	@FindBy(xpath = "//div[@class='container container--small']//div[3]//div[1]//a[4]")
	public WebElement consultTermsLink;

	@FindBy(xpath = "//div[@class='container container--small']//div[3]//div[1]//a[5]")
	public WebElement EikenTermsPDFLink;

	@FindBy(xpath = "//div[@class='container container--small']//div[3]//div[1]//a[6]")
	public WebElement EikenTermsLink;

	@FindBy(xpath = "//a[normalize-space()='http://www.jiem.co.jp/privacy/index.html']")
	public WebElement JIEMTermsLink;

	@FindBy(xpath = "//div[@class='container container--small']//div[13]//div[2]//a[1]")
	public WebElement SupportTermsLink;

	@FindBy(xpath = "//a[normalize-space()='https://www.ei-navi.jp/policy/site_policy.html']")
	public WebElement einaviPolicyLink;

	@FindBy(xpath = "//div[@class='ep-term__content']//div[15]//div[1]/a[1]")
	public WebElement fbLPolicyLink;

	@FindBy(xpath = "//div[@class='ep-term__content']//div[15]//div[2]/a[1]")
	public WebElement FacebookOptoutLink;

	@FindBy(xpath = "//div[@class='ep-term__content']//div[15]//div[3]/a[1]")
	public WebElement TwitterPrvivacyPolicy;

	@FindBy(xpath = "//div[@class='ep-term__content']//div[15]//div[4]/a[1]")
	public WebElement CustomizedAdLink;

	@FindBy(xpath = "//div[@class='ep-term__content']//div[15]//div[5]/a[1]")
	public WebElement LinePrivacyPolicyLink;

	@FindBy(xpath = "//div[@class='ep-term__content']//div[15]//div[6]/a[1]")
	public WebElement LineBehavioralAdvertisingLink;

	@FindBy(xpath = "//div[@class='ep-term__content']//div[15]//div[7]/a[1]")
	public WebElement AmazonTargetAdTermsLink;

	@FindBy(xpath = "//div[@class='ep-term__content']//div[15]//div[8]/a[1]")
	public WebElement ChangeDisplaySettingLink;

	@FindBy(xpath = "//div[@class='ep-term__content']//div[15]//div[9]/a[1]")
	public WebElement BrainPadLink;

	@FindBy(xpath = "//div[@class='ep-term__content']//div[15]//div[10]/a[1]")
	public WebElement Everrise;

	@FindBy(xpath = "//div[@class='ep-term__content']//div[15]//div[11]/a[1]")
	public WebElement NetworkAdvertisingLink;

	@FindBy(xpath = "//div[@class='ep-term__content']//div[15]//div[12]/a[1]")
	public WebElement AboutadsLink;

	@FindBy(xpath = "//div[@class='ep-term__content']//div[15]//div[13]/a[1]")
	public WebElement DDAILink;

	@FindBy(xpath = "//img[@alt='Facebook']")
	public WebElement FacebookImageforValidation;

	@FindBy(xpath = "//h1[@class='main-view__title ng-scope']")
	public WebElement NAIOptouttextforWait;

	/**
	 * @Author : Sahaj Balgunde
	 * @Date of Creation : 10 Aug 2021
	 * @Description: Additional Locator variables and Methods for footer.
	 */

	// Testcase no: PT-122
	public void ClickLinksinTermsandConditions() throws Exception {

		shipmentdata = XLHandler.readexcel("FooterTermsAssert", "NewTestData.xlsx");

		CommonFunctions.scrolltoElement(casecTermsLink);
		if (CommonFunctions.isElementClickable(casecTermsLink)) {
			casecTermsLink.click();
			ArrayList<String> tab = new ArrayList<>(driver.getWindowHandles());
			String ExpectedTitle = shipmentdata[0].toString();
			Assert.assertEquals(ExpectedTitle, driver.switchTo().window(tab.get(1)).getTitle());
			log.info("CASEC Link is working");
			switchToPreviousTab();
		} else {
			log.error("CASEC Link is not working");
		}

		CommonFunctions.scrolltoElement(jyukuPitaTermsLink);
		if (CommonFunctions.isElementClickable(jyukuPitaTermsLink)) {
			jyukuPitaTermsLink.click();
			ArrayList<String> tab = new ArrayList<>(driver.getWindowHandles());
			String ExpectedTitle = shipmentdata[1].toString();
			Assert.assertEquals(ExpectedTitle, driver.switchTo().window(tab.get(1)).getTitle());
			log.info("Jyukupita is working");
			switchToPreviousTab();
		} else {
			log.error("Jyukupita is not working");
		}

		CommonFunctions.scrolltoElement(jyukenTermsLink);
		if (CommonFunctions.isElementClickable(jyukenTermsLink)) {
			jyukenTermsLink.click();
			ArrayList<String> tab = new ArrayList<>(driver.getWindowHandles());
			String ExpectedTitle = shipmentdata[2].toString();
			Assert.assertEquals(ExpectedTitle, driver.switchTo().window(tab.get(1)).getTitle());
			log.info("Study Gear University Entry Exam Link is working");
			switchToPreviousTab();
		} else {
			log.error("Study Gear University Entry Exam Link is not working");
		}

		CommonFunctions.scrolltoElement(consultTermsLink);
		if (CommonFunctions.isElementClickable(consultTermsLink)) {
			consultTermsLink.click();
			ArrayList<String> tab = new ArrayList<>(driver.getWindowHandles());
			String ExpectedTitle = shipmentdata[3].toString();
			Assert.assertEquals(ExpectedTitle, driver.switchTo().window(tab.get(1)).getTitle());
			log.info("University Consult Link is working");
			switchToPreviousTab();
		} else {
			log.error("University Consult Link is not working");
		}

		CommonFunctions.scrolltoElement(EikenTermsLink);
		if (CommonFunctions.isElementClickable(EikenTermsLink)) {
			EikenTermsLink.click();
			ArrayList<String> tab = new ArrayList<>(driver.getWindowHandles());
			String ExpectedTitle = shipmentdata[4].toString();
			Assert.assertEquals(ExpectedTitle, driver.switchTo().window(tab.get(1)).getTitle());
			log.info("EiNavi Terms Link is working");
			switchToPreviousTab();
		} else {
			log.error("EiNavi Terms Link is not working");
		}

		CommonFunctions.scrolltoElement(JIEMTermsLink);
		if (CommonFunctions.isElementClickable(JIEMTermsLink)) {
			JIEMTermsLink.click();
			ArrayList<String> tab = new ArrayList<>(driver.getWindowHandles());
			String ExpectedTitle = shipmentdata[5].toString();
			Assert.assertEquals(ExpectedTitle, driver.switchTo().window(tab.get(1)).getTitle());
			log.info("JIEM Link is working");
			switchToPreviousTab();
		} else {
			log.error("JIEM Link is not working");
		}

		CommonFunctions.scrolltoElement(SupportTermsLink);
		if (CommonFunctions.isElementClickable(SupportTermsLink)) {
			SupportTermsLink.click();
			ArrayList<String> tab = new ArrayList<>(driver.getWindowHandles());
			String ExpectedTitle = shipmentdata[6].toString();
			Assert.assertEquals(ExpectedTitle, driver.switchTo().window(tab.get(1)).getTitle());
			log.info("Support Link is working");
			switchToPreviousTab();
		} else {
			log.error("Support Link is not working");
		}

		CommonFunctions.scrolltoElement(fbLPolicyLink);
		if (CommonFunctions.isElementClickable(fbLPolicyLink)) {
			fbLPolicyLink.click();
			ArrayList<String> tab = new ArrayList<>(driver.getWindowHandles());
			String ExpectedTitle = shipmentdata[7].toString();
			Assert.assertEquals(ExpectedTitle, driver.switchTo().window(tab.get(1)).getTitle());
			log.info("Facebook Link is working");
			switchToPreviousTab();
		} else {
			log.error("Facebook Link is not working");
		}

		CommonFunctions.scrolltoElement(FacebookOptoutLink);
		if (CommonFunctions.isElementClickable(FacebookOptoutLink)) {
			FacebookOptoutLink.click();
			ArrayList<String> tab = new ArrayList<>(driver.getWindowHandles());
			if (CommonFunctions.waitForVisiblity(FacebookImageforValidation, 5)) {
				log.info("Facebook Page is Opened");
			}

			log.info("Facebook Output Link is working");
			switchToPreviousTab();
		} else {
			log.error("Facebook Output Link is not working");
		}

		CommonFunctions.scrolltoElement(TwitterPrvivacyPolicy);
		if (CommonFunctions.isElementClickable(TwitterPrvivacyPolicy)) {
			TwitterPrvivacyPolicy.click();
			ArrayList<String> tab = new ArrayList<>(driver.getWindowHandles());
			String ExpectedTitle = shipmentdata[9].toString();
			Assert.assertEquals(ExpectedTitle, driver.switchTo().window(tab.get(1)).getTitle());
			log.info("Twitter Privacy Policy Link is working");
			switchToPreviousTab();
		} else {
			log.error("Twitter Prvivacy Policy Link is not working");
		}

		CommonFunctions.scrolltoElement(CustomizedAdLink);
		if (CommonFunctions.isElementClickable(CustomizedAdLink)) {
			CustomizedAdLink.click();
			ArrayList<String> tab = new ArrayList<>(driver.getWindowHandles());
			String ExpectedTitle = shipmentdata[10].toString();
			Assert.assertEquals(ExpectedTitle, driver.switchTo().window(tab.get(1)).getTitle());
			log.info("Customized Ad Link is working");
			switchToPreviousTab();
		} else {
			log.error("Customized Ad Link is not working");
		}

		CommonFunctions.scrolltoElement(LinePrivacyPolicyLink);
		if (CommonFunctions.isElementClickable(LinePrivacyPolicyLink)) {
			LinePrivacyPolicyLink.click();
			ArrayList<String> tab = new ArrayList<>(driver.getWindowHandles());
			String ExpectedTitle = shipmentdata[11].toString();
			Assert.assertEquals(ExpectedTitle, driver.switchTo().window(tab.get(1)).getTitle());
			log.info("LINE Privacy Policy Link is working");
			switchToPreviousTab();
		} else {
			log.error("LINE Privacy Policy Link is not working");
		}

		CommonFunctions.scrolltoElement(LineBehavioralAdvertisingLink);
		if (CommonFunctions.isElementClickable(LineBehavioralAdvertisingLink)) {
			LineBehavioralAdvertisingLink.click();
			ArrayList<String> tab = new ArrayList<>(driver.getWindowHandles());
			String ExpectedTitle = shipmentdata[12].toString();
			Assert.assertEquals(ExpectedTitle, driver.switchTo().window(tab.get(1)).getTitle());
			log.info("LINE Behavioral Advertising Link is working");
			switchToPreviousTab();
		} else {
			log.error("LINE Behavioral Advertising Link is not working");
		}

		CommonFunctions.scrolltoElement(AmazonTargetAdTermsLink);
		if (CommonFunctions.isElementClickable(AmazonTargetAdTermsLink)) {
			AmazonTargetAdTermsLink.click();
			ArrayList<String> tab = new ArrayList<>(driver.getWindowHandles());
			String ExpectedTitle = shipmentdata[13].toString();
			Assert.assertEquals(ExpectedTitle, driver.switchTo().window(tab.get(1)).getTitle());
			log.info("Amazon Target Ad Terms Link is working");
			switchToPreviousTab();
		} else {
			log.error("Amazon Target Ad Terms Link is not working");
		}

		CommonFunctions.scrolltoElement(ChangeDisplaySettingLink);
		if (CommonFunctions.isElementClickable(ChangeDisplaySettingLink)) {
			ChangeDisplaySettingLink.click();
			ArrayList<String> tab = new ArrayList<>(driver.getWindowHandles());
			String ExpectedTitle = shipmentdata[14].toString();
			Assert.assertEquals(ExpectedTitle, driver.switchTo().window(tab.get(1)).getTitle());
			log.info("Change Display Setting Link is working");
			switchToPreviousTab();
		} else {
			log.error("Change Display Setting Link is not working");
		}

		CommonFunctions.scrolltoElement(BrainPadLink);
		if (CommonFunctions.isElementClickable(BrainPadLink)) {
			BrainPadLink.click();
			ArrayList<String> tab = new ArrayList<>(driver.getWindowHandles());
			String ExpectedTitle = shipmentdata[15].toString();
			Assert.assertEquals(ExpectedTitle, driver.switchTo().window(tab.get(1)).getTitle());
			log.info("Brain Pad Link is working");
			switchToPreviousTab();
		} else {
			log.error("Brain Pad Link is not working");
		}

		CommonFunctions.scrolltoElement(Everrise);
		if (CommonFunctions.isElementClickable(Everrise)) {
			Everrise.click();
			ArrayList<String> tab = new ArrayList<>(driver.getWindowHandles());
			String ExpectedTitle = shipmentdata[16].toString();
			Assert.assertEquals(ExpectedTitle, driver.switchTo().window(tab.get(1)).getTitle());
			log.info("Everrise Link is working");
			switchToPreviousTab();
		} else {
			log.error("Everrise Link is not working");
		}

		CommonFunctions.scrolltoElement(NetworkAdvertisingLink);
		if (CommonFunctions.isElementClickable(NetworkAdvertisingLink)) {
			NetworkAdvertisingLink.click();
			CommonFunctions.waitForVisiblity(NAIOptouttextforWait, 5);
			ArrayList<String> tab = new ArrayList<>(driver.getWindowHandles());
			String ExpectedTitle = shipmentdata[17].toString();
			Assert.assertEquals(ExpectedTitle, driver.switchTo().window(tab.get(1)).getTitle());
			log.info("Network Advertising Link is working");
			switchToPreviousTab();
		} else {
			log.error("Network Advertising Link is not working");
		}

		CommonFunctions.scrolltoElement(AboutadsLink);
		if (CommonFunctions.isElementClickable(AboutadsLink)) {
			AboutadsLink.click();
			ArrayList<String> tab = new ArrayList<>(driver.getWindowHandles());
			String ExpectedTitle = shipmentdata[18].toString();
			Assert.assertEquals(ExpectedTitle, driver.switchTo().window(tab.get(1)).getTitle());
			log.info("Aboutads Link is working");
			switchToPreviousTab();
		} else {
			log.error("Aboutads Link is not working");
		}

		CommonFunctions.scrolltoElement(DDAILink);
		if (CommonFunctions.isElementClickable(DDAILink)) {
			DDAILink.click();
			ArrayList<String> tab = new ArrayList<>(driver.getWindowHandles());
			String ExpectedTitle = shipmentdata[19].toString();
			Assert.assertEquals(ExpectedTitle, driver.switchTo().window(tab.get(1)).getTitle());
			log.info("DDAI LINE Privacy Policy Link is working");
			switchToPreviousTab();
		} else {
			log.error("DDAI Link is not working");
		}
		driver.navigate().back();
	}

}