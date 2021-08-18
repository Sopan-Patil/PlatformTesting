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

import base.NewBaseClass;
import platform.pageobjects.Authentication.LoginPage;
import utils.CommonFunctions;
import utils.XLHandler;

/**
 * @Author : Chetan Sonparote
 * @Date of Creation : 26 June 2021
 * @Description: Additional Locator variables and Methods for footer.
 */

public class FooterPage_PT90_106 {
	List<String[]> testdata;
	public WebDriver driver;
	private static Logger log = LogManager.getLogger(FooterPage_PT90_106.class.getName());

	String[] shipmentdata;
	int waitTime = 5;

	public FooterPage_PT90_106(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@class='footer-bt']//a[@href = '/term']")
	public WebElement termsOfUseLink;

	@FindBy(xpath = "//div[@class='footer-bt']//a[@href = 'https://www.jiem.co.jp/privacy/']")
	public WebElement privacyPolicyLink;

	@FindBy(xpath = "//div[@class='footer-bt']//a[@href = '/transaction-method']")
	public WebElement specifiedCommodityTradingLawLink;

	@FindBy(xpath = "//div[@class='footer-bt']//a[@href = 'https://support.evidus.com/']")
	public WebElement qnALink;

	@FindBy(xpath = "//ul[@class='footer__link']//a[@href='/testing']")
	public WebElement footerExaminationWindowLink;

	@FindBy(xpath = "//li[@class='sub-menu__item']//a[@href='https://studygear.evidus.com/campaign/cp_scbt202109/']")
	public WebElement footerScbtLink;

	@FindBy(xpath = "//li[@class='sub-menu__item']//a[@href='https://casec.evidus.com/about/']")
	public WebElement footerCasecLink;

	@FindBy(xpath = "//li[@class='sub-menu__item']//a[@href='/testing/achievement-test_pf']")
	public WebElement footerCommontestZKai;

	@FindBy(xpath = "//ul[@class='footer__link']//a[@href='/learning']")
	public WebElement footerLearningWindowLink;

	@FindBy(xpath = "//li[@class='sub-menu__item']//a[@href='/studygear-eiken']")
	public WebElement footerStagiaEikenLink;

	@FindBy(xpath = "//li[@class='sub-menu__item']//a[@href='/studygear-kanken']")
	public WebElement footerStagiaKankenLink;

	@FindBy(xpath = "//ul[@class='footer__link']//a[@href='/media']")
	public WebElement informationWindowLink;

	@FindBy(xpath = "//li[@class='sub-menu__item']//a[@href='https://stg.jyuku-pita.evidus.com/']")
	public WebElement cramSchoolPitaLink;

	@FindBy(xpath = "//li[@class='sub-menu__item']//a[@href='https://juken.ei-navi.jp/']")
	public WebElement stagiaUniversityExamLink;

	@FindBy(xpath = "//li[@class='sub-menu__item']//a[@href='https://consult.evidus.com/']")
	public WebElement educationCostConsulatationSupportLink;

	@FindBy(xpath = "//li[@class='sub-menu__item']//a[@href='/mypage-account-security']")
	public WebElement accountSecurity;

	@FindBy(xpath = "//li[@class='sub-menu__item']//a[@href='/mypage-member-status']")
	public WebElement memberStatus;

	@FindBy(xpath = "//li[@class='sub-menu__item']//a[@href='/mypage-member-service']")
	public WebElement servicesUsing;

	@FindBy(xpath = "//li[@class='sub-menu__item']//a[@href='/order-history']")
	public WebElement orderHistory;

	@FindBy(xpath = "//a[@href='/withdraw-confirm']")
	public WebElement withdraw;

	@FindBy(xpath = "//li[@class='sub-menu__item']//a[@href='/logout']")
	public WebElement logout;

	@FindBy(xpath = "//li[@class='sub-menu__item']//a[@href='/login']")
	public WebElement footerLogin;

	@FindBy(xpath = "//li[@class='sub-menu__item']//a[@href='/register']")
	public WebElement footerRegister;

	@FindBy(xpath = "//a[@href='https://support.evidus.com/']")
	public WebElement footerAccountQnA;

	@FindBy(xpath = "//a[@href ='https://stg.studygear.evidus.net/term']")
	public WebElement footerAccountTerms;

	@FindBy(xpath = "//a[@href='https://www.jiem.co.jp/privacy/']")
	public WebElement footerAccountPrivacy;

	@FindBy(xpath = "//a[@href ='https://stg.studygear.evidus.net/transaction-method']")
	public WebElement footerAccountTax;

	@FindBy(xpath = "//a[@href ='/term']")
	public WebElement footerOrderTerms;

	@FindBy(xpath = "//a[@href ='/transaction-method']")
	public WebElement footerOrderTax;

	@FindBy(xpath = "//h3[@class ='text-center ep-term__title ep-term__title--big mb-0' ]")
	public WebElement footerTermsforVisibility;

	@FindBy(xpath = "//div[@id ='mainimgArea']")
	public WebElement footerPrivacyforVisibility;

	@FindBy(xpath = "//h3[@class = 'text-center ep-term__title ep-term__title--big mb-0']")
	public WebElement footerTaxforVisibility;

	@FindBy(xpath = "//input[@id='query']")
	public WebElement footerQandAforVisibility;

	@FindBy(xpath = "//img[@class='mv__campaign']")
	public WebElement footerExaminationWindowLinkforVisibility;

	@FindBy(xpath = "//div[@class='title']")
	public WebElement ScbtLinkforVisibility;

	@FindBy(xpath = "//a[@href='/product-list']")
	public WebElement productListLink;

	@FindBy(xpath = "//form[@action = '/product-bill-generate']/button[@class = 'button button--default button--xmedium']")
	public WebElement selectKanjiProductFromProductList;

	@FindBy(xpath = "//button[@role='button']")
	public WebElement step2ProceedButton;

	@FindBy(xpath = "//a[@id='finalizeButton']")
	public WebElement step3ProceedButton;

	@FindBy(xpath = "//input[@id='email']")
	public WebElement emailtextfield;

	/**
	 * @Author : Sahaj Balgunde
	 * @Date of Creation : 20 July 2021
	 * @Description: Additional Locator variables and Methods for footer.
	 */

	public void switchToPreviousTab() {
		ArrayList<String> tab = new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(tab.get(1));
		driver.close();
		driver.switchTo().window(tab.get(0));
		// driver.close();
	}

	// Testcase no: PT-090 to PT-095, PT-102 to PT-105
	public void clickFooterLinksBeforeLogin() throws Exception {

		shipmentdata = XLHandler.readexcel("FooterAssert", "NewTestData.xlsx");
		CommonFunctions.scrolltoElement(termsOfUseLink);
		if (CommonFunctions.isElementClickable(termsOfUseLink)) {
			termsOfUseLink.click();
			CommonFunctions.waitForVisiblity(footerTermsforVisibility, 5);
			String ExpectedTitle = shipmentdata[0].toString();
			try {
				Assert.assertEquals(ExpectedTitle, driver.getTitle());
			} catch (Exception e) {
				log.error("Can't validate Assert");
			}
			log.info("Terms of Use Link is working");
			driver.navigate().back();
		} else {
			log.error("Terms of Use Link is not working");
		}

		CommonFunctions.scrolltoElement(privacyPolicyLink);
		if (CommonFunctions.isElementClickable(privacyPolicyLink)) {
			privacyPolicyLink.click();
			CommonFunctions.waitForVisiblity(footerPrivacyforVisibility, 5);
			ArrayList<String> tab = new ArrayList<>(driver.getWindowHandles());
			String ExpectedTitle = shipmentdata[1].toString();
			Assert.assertEquals(ExpectedTitle, driver.switchTo().window(tab.get(1)).getTitle());
			log.info("Privacy Policy Link is working");
			switchToPreviousTab();
		} else {
			log.error("Privacy Policy Link is not working");
		}

		CommonFunctions.scrolltoElement(specifiedCommodityTradingLawLink);
		if (CommonFunctions.isElementClickable(specifiedCommodityTradingLawLink)) {
			specifiedCommodityTradingLawLink.click();
			CommonFunctions.waitForVisiblity(footerTaxforVisibility, 5);
			String ExpectedTitle = shipmentdata[2].toString();
			try {
				Assert.assertEquals(ExpectedTitle, driver.getTitle());
			} catch (Exception e) {
				log.error("Can't validate Assert");
			}
			log.info("Specified Commodity Trading Law Link is working");
			driver.navigate().back();
		} else {
			log.error("Specified Commodity Trading Law Link is not working");
		}

		CommonFunctions.scrolltoElement(qnALink);
		if (CommonFunctions.isElementClickable(qnALink)) {
			qnALink.click();
			CommonFunctions.waitForVisiblity(footerQandAforVisibility, 5);
			ArrayList<String> tab = new ArrayList<>(driver.getWindowHandles());
			String ExpectedTitle = shipmentdata[3].toString();
			Assert.assertEquals(ExpectedTitle, driver.switchTo().window(tab.get(1)).getTitle());
			log.info("Q and A Link working");
			switchToPreviousTab();
		} else {
			log.error("Q and A Link is not working");
		}

		CommonFunctions.scrolltoElement(footerExaminationWindowLink);
		if (CommonFunctions.isElementClickable(footerExaminationWindowLink)) {
			footerExaminationWindowLink.click();
			CommonFunctions.waitForVisiblity(footerExaminationWindowLinkforVisibility, 5);
			String ExpectedTitle = shipmentdata[4].toString();
			try {
				Assert.assertEquals(ExpectedTitle, driver.getTitle());
			} catch (Exception e) {
				log.error("Can't validate Assert");
			}
			log.info("footer Examination Window Link is working");
			driver.navigate().back();
		} else {
			log.error("footer Examination Window Link Link is not working");
		}

		CommonFunctions.scrolltoElement(footerScbtLink);
		if (CommonFunctions.isElementClickable(footerScbtLink)) {
			footerScbtLink.click();
			ArrayList<String> tab = new ArrayList<>(driver.getWindowHandles());
			CommonFunctions.waitForVisiblity(ScbtLinkforVisibility, 5);
			String ExpectedTitle = shipmentdata[5].toString();
			Assert.assertEquals(ExpectedTitle, driver.switchTo().window(tab.get(1)).getTitle());
			log.info("footer Scbt Link is working");
			switchToPreviousTab();
		} else {
			log.error("footer Scbt Link is not working");
		}

		CommonFunctions.scrolltoElement(footerCasecLink);
		if (CommonFunctions.isElementClickable(footerCasecLink)) {
			footerCasecLink.click();
			ArrayList<String> tab = new ArrayList<>(driver.getWindowHandles());
			String ExpectedTitle = shipmentdata[6].toString();
			Assert.assertEquals(ExpectedTitle, driver.switchTo().window(tab.get(1)).getTitle());
			log.info("footer Casec Link is working");
			switchToPreviousTab();
		} else {
			log.error("footer Casec Link is not working");
		}

		CommonFunctions.scrolltoElement(footerCommontestZKai);
		if (CommonFunctions.isElementClickable(footerCommontestZKai)) {
			footerCommontestZKai.click();
			String ExpectedTitle = shipmentdata[7].toString();
			try {
				Assert.assertEquals(ExpectedTitle, driver.getTitle());
			} catch (Exception e) {
				log.error("Can't validate Assert");
			}
			log.info("footer Z-Kai Link is working");
			driver.navigate().back();
		} else {
			log.error("footer Z-Kai Link is not working");
		}

		CommonFunctions.scrolltoElement(footerLearningWindowLink);
		if (CommonFunctions.isElementClickable(footerLearningWindowLink)) {
			footerLearningWindowLink.click();
			String ExpectedTitle = shipmentdata[8].toString();
			try {
				Assert.assertEquals(ExpectedTitle, driver.getTitle());
			} catch (Exception e) {
				log.error("Can't validate Assert");
			}
			log.info("footer Learning Window Link is working");
			driver.navigate().back();
		} else {
			log.error("footer Learning Window Link is not working");
		}

		CommonFunctions.scrolltoElement(footerStagiaEikenLink);
		if (CommonFunctions.isElementClickable(footerStagiaEikenLink)) {
			footerStagiaEikenLink.click();
			String ExpectedTitle = shipmentdata[9].toString();
			try {
				Assert.assertEquals(ExpectedTitle, driver.getTitle());
			} catch (Exception e) {
				log.error("Can't validate Assert");
			}
			log.info("footer Stagia Eiken Link is working");
			driver.navigate().back();
		} else {
			log.error("footer Stagia Eiken Link is not working");
		}

		CommonFunctions.scrolltoElement(footerStagiaKankenLink);
		if (CommonFunctions.isElementClickable(footerStagiaKankenLink)) {
			footerStagiaKankenLink.click();
			String ExpectedTitle = shipmentdata[10].toString();
			try {
				Assert.assertEquals(ExpectedTitle, driver.getTitle());
			} catch (Exception e) {
				log.error("Can't validate Assert");
			}
			log.info("footer Stagia Kanken Link is working");
			driver.navigate().back();
		} else {
			log.error("footer Stagia Kanken Link is not working");
		}

		CommonFunctions.scrolltoElement(informationWindowLink);
		if (CommonFunctions.isElementClickable(informationWindowLink)) {
			informationWindowLink.click();
			String ExpectedTitle = shipmentdata[11].toString();
			Assert.assertEquals(ExpectedTitle, driver.getTitle());
			log.info("information Window Link is working");
			driver.navigate().back();

		} else {
			log.error("information Window Link is not working");
		}

		CommonFunctions.scrolltoElement(cramSchoolPitaLink);
		if (CommonFunctions.isElementClickable(cramSchoolPitaLink)) {
			cramSchoolPitaLink.click();
//			ArrayList<String> tab = new ArrayList<>(driver.getWindowHandles());
//			String ExpectedTitle = "【スタギア 受験の窓口】各種検定・試験をお得に便利に申込み！";
//			System.out.println(ActualTitle);
//			System.out.println(ExpectedTitle);
//			Assert.assertEquals(ExpectedTitle, driver.switchTo().window(tab.get(1)).getTitle());
			log.info("cram School Pita Link is working");
			switchToPreviousTab();
		} else {
			log.error("cram School Pita Link is not working");
		}

		CommonFunctions.scrolltoElement(stagiaUniversityExamLink);
		if (CommonFunctions.isElementClickable(stagiaUniversityExamLink)) {
			stagiaUniversityExamLink.click();
			ArrayList<String> tab = new ArrayList<>(driver.getWindowHandles());
			String ExpectedTitle = shipmentdata[13].toString();
			Assert.assertEquals(ExpectedTitle, driver.switchTo().window(tab.get(1)).getTitle());
			log.info("stagia University Exam Link is working");
			switchToPreviousTab();
		} else {
			log.error("stagia University Exam Link is not working");
		}

		CommonFunctions.scrolltoElement(educationCostConsulatationSupportLink);
		if (CommonFunctions.isElementClickable(educationCostConsulatationSupportLink)) {
			educationCostConsulatationSupportLink.click();
			ArrayList<String> tab = new ArrayList<>(driver.getWindowHandles());
			String ExpectedTitle = shipmentdata[14].toString();
			Assert.assertEquals(ExpectedTitle, driver.switchTo().window(tab.get(1)).getTitle());
			log.info("education CostConsulatation Support Link is working");
			switchToPreviousTab();
		} else {
			log.error("education CostConsulatation Support Link is not working");
		}

		CommonFunctions.scrolltoElement(footerLogin);
		if (CommonFunctions.isElementClickable(footerLogin)) {
			footerLogin.click();
			String ExpectedTitle = shipmentdata[15].toString();
			try {
				Assert.assertEquals(ExpectedTitle, driver.getTitle());
			} catch (Exception e) {
				log.error("Can't validate Assert");
			}
			log.info("Footer Login Link is working");
			driver.navigate().back();

		} else {
			log.error("Footer Login Link is not working");
		}

		CommonFunctions.scrolltoElement(footerRegister);
		if (CommonFunctions.isElementClickable(footerRegister)) {
			footerRegister.click();
			NewBaseClass auth = new NewBaseClass();
			auth.replaceurl();
			String ExpectedTitle = shipmentdata[16].toString();
			try {
				Assert.assertEquals(ExpectedTitle, driver.getTitle());
			} catch (Exception e) {
				log.error("Can't validate Assert");
			}
			log.info("Footer Registration Link is working");
			driver.navigate().back();
			driver.navigate().back();

		} else {
			log.error("Footer Registration Link is not working");
		}

	}

	// Testcase no: PT-096 to PT-101
	public void clickFooterLinksAfterLogin() throws Exception {

		shipmentdata = XLHandler.readexcel("FooterAssert", "NewTestData.xlsx");

		CommonFunctions.scrolltoElement(accountSecurity);
		if (CommonFunctions.isElementClickable(accountSecurity)) {
			accountSecurity.click();
			String ExpectedTitle = shipmentdata[17].toString();
			try {
				Assert.assertEquals(ExpectedTitle, driver.getTitle());
			} catch (Exception e) {
				log.error("Can't validate Assert");
			}
			log.info("account Security Link is working");
			driver.navigate().back();
		} else {
			log.error("account Security Link is not working");
		}

		CommonFunctions.scrolltoElement(memberStatus);
		if (CommonFunctions.isElementClickable(memberStatus)) {
			memberStatus.click();
			String ExpectedTitle = shipmentdata[18].toString();
			try {
				Assert.assertEquals(ExpectedTitle, driver.getTitle());
			} catch (Exception e) {
				log.error("Can't validate Assert");
			}
			log.info("Membership Status Link is working");
			driver.navigate().back();
		} else {
			log.error("Membership Status Link is not working");
		}

		CommonFunctions.scrolltoElement(servicesUsing);
		if (CommonFunctions.isElementClickable(servicesUsing)) {
			servicesUsing.click();
			String ExpectedTitle = shipmentdata[19].toString();
			try {
				Assert.assertEquals(ExpectedTitle, driver.getTitle());
			} catch (Exception e) {
				log.error("Can't validate Assert");
			}
			log.info("Services you are using Using Link is working");
			driver.navigate().back();
		} else {
			log.error("Services you are using Using Link is not working");
		}

		CommonFunctions.scrolltoElement(orderHistory);
		if (CommonFunctions.isElementClickable(orderHistory)) {
			orderHistory.click();
			String ExpectedTitle = shipmentdata[20].toString();
			try {
				Assert.assertEquals(ExpectedTitle, driver.getTitle());
			} catch (Exception e) {
				log.error("Can't validate Assert");
			}
			log.info("order History Link is working");
			driver.navigate().back();
		} else {
			log.error("order History Link is not working");
		}

		CommonFunctions.scrolltoElement(withdraw);
		if (CommonFunctions.isElementClickable(withdraw)) {
			withdraw.click();
			String ExpectedTitle = shipmentdata[21].toString();
			try {
				Assert.assertEquals(ExpectedTitle, driver.getTitle());
			} catch (Exception e) {
				log.error("Can't validate Assert");
			}
			log.info("Withdrawal Link is working");
			driver.navigate().back();
		} else {
			log.error("Withdrawal Link is not working");
		}

		CommonFunctions.scrolltoElement(logout);
		if (CommonFunctions.isElementClickable(logout)) {
			logout.click();
			log.info("Logout Link is working");
			driver.navigate().back();
		} else {
			log.error("Logout Link is not working");
		}

	}

	// Testcase no: PT-102 to PT-105
	public void clickOrderFlowFooterLinks() throws Exception {

		shipmentdata = XLHandler.readexcel("FooterAssert", "NewTestData.xlsx");

		CommonFunctions.scrolltoElement(footerAccountQnA);
		if (CommonFunctions.isElementClickable(footerAccountQnA)) {
			footerAccountQnA.click();
			CommonFunctions.waitForVisiblity(footerQandAforVisibility, 5);
			ArrayList<String> tab = new ArrayList<>(driver.getWindowHandles());
			String ExpectedTitle = shipmentdata[26].toString();
			Assert.assertEquals(ExpectedTitle, driver.switchTo().window(tab.get(1)).getTitle());
			log.info("QnA Link is working");
			switchToPreviousTab();
		} else {
			log.error("QnA Link is not working");
		}

		CommonFunctions.scrolltoElement(footerAccountTerms);
		if (CommonFunctions.isElementClickable(footerAccountTerms)) {
			footerAccountTerms.click();
			CommonFunctions.waitForVisiblity(footerTermsforVisibility, 5);
			String ExpectedTitle = shipmentdata[27].toString();
			Assert.assertEquals(ExpectedTitle, driver.getTitle());
			log.info("Terms of Use Link is working");
			driver.navigate().back();
		} else {
			log.error("Terms of Use Link is not working");
		}

		CommonFunctions.scrolltoElement(footerAccountPrivacy);
		if (CommonFunctions.isElementClickable(footerAccountPrivacy)) {
			footerAccountPrivacy.click();
			CommonFunctions.waitForVisiblity(footerPrivacyforVisibility, 5);
			ArrayList<String> tab = new ArrayList<>(driver.getWindowHandles());
			String ExpectedTitle = shipmentdata[28].toString();
			Assert.assertEquals(ExpectedTitle, driver.switchTo().window(tab.get(1)).getTitle());
			log.info("Privacy Policy Link is working");
			switchToPreviousTab();
		} else {
			log.error("Privacy Policy Link is not working");
		}

		CommonFunctions.scrolltoElement(footerAccountTax);
		if (CommonFunctions.isElementClickable(footerAccountTax)) {
			footerAccountTax.click();
			CommonFunctions.waitForVisiblity(footerTaxforVisibility, 5);
			String ExpectedTitle = shipmentdata[29].toString();
			Assert.assertEquals(ExpectedTitle, driver.getTitle());
			log.info("Account Tax Link working");
			driver.navigate().back();
		} else {
			log.error("Account Tax Link is not working");
		}

	}

	// Testcase no: PT-102 to PT-105
	public void clickAccountServicesFooterLinks() throws Exception {

		shipmentdata = XLHandler.readexcel("FooterAssert", "NewTestData.xlsx");

		CommonFunctions.scrolltoElement(footerAccountQnA);
		if (CommonFunctions.isElementClickable(footerAccountQnA)) {
			footerAccountQnA.click();
			CommonFunctions.waitForVisiblity(footerQandAforVisibility, 5);
			ArrayList<String> tab = new ArrayList<>(driver.getWindowHandles());
			String ExpectedTitle = shipmentdata[26].toString();
			Assert.assertEquals(ExpectedTitle, driver.switchTo().window(tab.get(1)).getTitle());
			log.info("QnA Link is working");
			switchToPreviousTab();
		} else {
			log.error("QnA Link is not working");
		}

		CommonFunctions.scrolltoElement(footerAccountTerms);
		if (CommonFunctions.isElementClickable(footerAccountTerms)) {
			footerAccountTerms.click();
			CommonFunctions.waitForVisiblity(footerTermsforVisibility, 5);
			ArrayList<String> tab = new ArrayList<>(driver.getWindowHandles());
			String ExpectedTitle = shipmentdata[27].toString();
			Assert.assertEquals(ExpectedTitle, driver.switchTo().window(tab.get(1)).getTitle());
			log.info("Terms of Use Link is working");
			switchToPreviousTab();
		} else {
			log.error("Terms of Use Link is not working");
		}

		CommonFunctions.scrolltoElement(footerAccountPrivacy);
		if (CommonFunctions.isElementClickable(footerAccountPrivacy)) {
			footerAccountPrivacy.click();
			CommonFunctions.waitForVisiblity(footerPrivacyforVisibility, 5);
			ArrayList<String> tab = new ArrayList<>(driver.getWindowHandles());
			String ExpectedTitle = shipmentdata[28].toString();
			Assert.assertEquals(ExpectedTitle, driver.switchTo().window(tab.get(1)).getTitle());
			log.info("Privacy Policy Link is working");
			switchToPreviousTab();
		} else {
			log.error("Privacy Policy Link is not working");
		}

		CommonFunctions.scrolltoElement(footerAccountTax);
		if (CommonFunctions.isElementClickable(footerAccountTax)) {
			footerAccountTax.click();
			CommonFunctions.waitForVisiblity(footerTaxforVisibility, 5);
			ArrayList<String> tab = new ArrayList<>(driver.getWindowHandles());
			String ExpectedTitle = shipmentdata[29].toString();
			Assert.assertEquals(ExpectedTitle, driver.switchTo().window(tab.get(1)).getTitle());
			log.info("Account Tax Link working");
			switchToPreviousTab();
		} else {
			log.error("Account Tax Link is not working");
		}

	}

	public void clickWithdrawalFooterLink() throws Exception {

		CommonFunctions.scrolltoElement(withdraw);
		if (CommonFunctions.isElementClickable(withdraw)) {
			withdraw.click();
			log.info("Withdraw Link working");
		} else {
			log.error("Withdraw Link is not working");
		}
	}

	public void clickLoginFooterLink() throws Exception {

		CommonFunctions.scrolltoElement(footerLogin);
		if (CommonFunctions.isElementClickable(footerLogin)) {
			footerLogin.click();
			log.info("Footer Login Link working");
		} else {
			log.error("Footer Login Link is not working");
		}
	}

	public void clickRegistrationFooterLink() throws Exception {

		CommonFunctions.scrolltoElement(footerRegister);
		if (CommonFunctions.isElementClickable(footerRegister)) {
			footerRegister.click();
			log.info("Footer Registration Link working");
		} else {
			log.error("Footer Registration Link is not working");
		}
	}

	public void clickTermsofuseForLinksValidation() throws Exception {

		CommonFunctions.scrolltoElement(termsOfUseLink);
		if (CommonFunctions.isElementClickable(termsOfUseLink)) {
			termsOfUseLink.click();
			log.info("Terms of User Footer Link working");
		} else {
			log.error("Terms of User Footer Link working");
		}

	}

	// Testcase no: PT-102 to PT-105
	public void gotoOrderStepOneForFooterValidation() throws Exception {

		CommonFunctions.waitForVisiblity(productListLink, waitTime);
		productListLink.click();
		log.info("Click on product list page");

		CommonFunctions.waitForVisiblity(selectKanjiProductFromProductList, waitTime);
		selectKanjiProductFromProductList.click();
		log.info("Click on buy button from product list page,select 1st product");

		shipmentdata = XLHandler.readexcel("FooterAssert", "NewTestData.xlsx");

		CommonFunctions.scrolltoElement(footerAccountQnA);
		if (CommonFunctions.isElementClickable(footerAccountQnA)) {
			footerAccountQnA.click();
			CommonFunctions.waitForVisiblity(footerQandAforVisibility, 5);
			ArrayList<String> tab = new ArrayList<>(driver.getWindowHandles());
			String ExpectedTitle = shipmentdata[26].toString();
			Assert.assertEquals(ExpectedTitle, driver.switchTo().window(tab.get(1)).getTitle());
			log.info("QnA Link is working");
			switchToPreviousTab();
		} else {
			log.error("QnA Link is not working");
		}

		CommonFunctions.scrolltoElement(footerOrderTerms);
		if (CommonFunctions.isElementClickable(footerOrderTerms)) {
			footerOrderTerms.click();
			CommonFunctions.waitForVisiblity(footerOrderTerms, 5);
			String ExpectedTitle = shipmentdata[27].toString();
			Assert.assertEquals(ExpectedTitle, driver.getTitle());
			log.info("Order Footer Terms of Use Link is working");
			driver.navigate().back();
		} else {
			log.error("Order Footer Terms of Use Link is not working");
		}

		CommonFunctions.scrolltoElement(footerAccountPrivacy);
		if (CommonFunctions.isElementClickable(footerAccountPrivacy)) {
			footerAccountPrivacy.click();
			CommonFunctions.waitForVisiblity(footerPrivacyforVisibility, 5);
			ArrayList<String> tab = new ArrayList<>(driver.getWindowHandles());
			String ExpectedTitle = shipmentdata[28].toString();
			Assert.assertEquals(ExpectedTitle, driver.switchTo().window(tab.get(1)).getTitle());
			log.info("Privacy Policy Link is working");
			switchToPreviousTab();
		} else {
			log.error("Privacy Policy Link is not working");
		}

		CommonFunctions.scrolltoElement(footerOrderTax);
		if (CommonFunctions.isElementClickable(footerOrderTax)) {
			footerOrderTax.click();
			CommonFunctions.waitForVisiblity(footerOrderTax, 5);
			String ExpectedTitle = shipmentdata[29].toString();
			Assert.assertEquals(ExpectedTitle, driver.getTitle());
			log.info("Order Footer Tax Link working");
			driver.navigate().back();
		} else {
			log.error("Account Tax Link is not working");
		}

	}

	// Testcase no: PT-102 to PT-105
	public void gotoOrderStepTwoForFooterValidation() throws Exception {
		CommonFunctions.waitForVisiblity(productListLink, waitTime);
		productListLink.click();
		log.info("Click on product list page");

		CommonFunctions.waitForVisiblity(selectKanjiProductFromProductList, waitTime);
		selectKanjiProductFromProductList.click();
		log.info("Click on buy button from product list page,select 1st product");

		CommonFunctions.isElementVisible(step2ProceedButton);
		CommonFunctions.waitForVisiblity(step2ProceedButton, waitTime);
		step2ProceedButton.click();

		NewBaseClass orderflowauth = new NewBaseClass();
		orderflowauth.replaceurl();

		log.info("go to relogin page");
		LoginPage loginObj = new LoginPage(driver);
		loginObj.loginToPlatform();

	}

	// Testcase no: PT-102 to PT-105
	public void gotoOrderStepThreeForFooterValidation() throws Exception {

		CommonFunctions.isElementVisible(step3ProceedButton);
		CommonFunctions.waitForVisiblity(step3ProceedButton, waitTime);
		step3ProceedButton.click();

	}

}
