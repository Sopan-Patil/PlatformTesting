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

	@FindBy(xpath = "//div[@class='footer-bt']//li[1]//a[1]")
	public WebElement termsOfUseLink;

	@FindBy(xpath = "//div[@class='footer-bt']//li[2]//a[1]")
	public WebElement privacyPolicyLink;

	@FindBy(xpath = "//div[@class='footer-bt']//li[3]//a[1]")
	public WebElement specifiedCommodityTradingLawLink;

	@FindBy(xpath = "//div[@class='footer-bt']//li[4]//a[1]")
	public WebElement qnALink;

	@FindBy(xpath = "//ul[@class='footer__link']/li[1]/a[1]")
	public WebElement footerExaminationWindowLink;

	@FindBy(xpath = "//div[@id='footer']//li[1]//ul[1]//li[1]//a[1]")
	public WebElement footerScbtLink;

	@FindBy(xpath = "//div[@id='footer']//li[1]//ul[1]//li[2]//a[1]")
	public WebElement footerCasecLink;

	@FindBy(xpath = "//div[@id='footer']//li[1]//ul[1]//li[3]//a[1]")
	public WebElement footerCommontestZKai;

	@FindBy(xpath = "//ul[@class='footer__link']/li[2]/a[1]")
	public WebElement footerLearningWindowLink;

	@FindBy(xpath = "//div[@id='footer']//li[2]//ul[1]//li[1]//a[1]")
	public WebElement footerStagiaEikenLink;

	@FindBy(xpath = "//div[@id='footer']//li[2]//ul[1]//li[2]//a[1]")
	public WebElement footerStagiaKankenLink;

	@FindBy(xpath = "//ul[@class='footer__link']/li[3]/a[1]")
	public WebElement informationWindowLink;

	@FindBy(xpath = "//div[@id='footer']//li[3]//ul[1]//li[1]//a[1]")
	public WebElement cramSchoolPitaLink;

	@FindBy(xpath = "//div[@id='footer']//li[3]//ul[1]//li[2]//a[1]")
	public WebElement stagiaUniversityExamLink;

	@FindBy(xpath = "//div[@id='footer']//li[3]//ul[1]//li[3]//a[1]")
	public WebElement educationCostConsulatationSupportLink;

	@FindBy(xpath = "//div[@id='footer']//li[4]//ul[1]//li[1]//a[1]")
	public WebElement accountSecurity;

	@FindBy(xpath = "//div[@id='footer']//li[4]//ul[1]//li[2]//a[1]")
	public WebElement memberStatus;

	@FindBy(xpath = "//div[@id='footer']//li[4]//ul[1]//li[3]//a[1]")
	public WebElement servicesUsing;

	@FindBy(xpath = "//div[@id='footer']//li[4]//ul[1]//li[4]//a[1]")
	public WebElement orderHistory;

	@FindBy(xpath = "//div[@id='footer']//li[4]//ul[1]//li[5]//a[1]")
	public WebElement withdraw;

	@FindBy(xpath = "//div[@id='footer']//li[4]//ul[1]//li[6]//a[1]")
	public WebElement logout;

	@FindBy(xpath = "//div[@id='footer']//li[4]//ul[1]//li[1]//a[1]")
	public WebElement footerLogin;

	@FindBy(xpath = "//div[@id='footer']//li[4]//ul[1]//li[2]//a[1]")
	public WebElement footerRegister;

	@FindBy(xpath = "//div[@class='ep-auth__footer']/ul[1]/li[1]//a[1]")
	public WebElement footerAccountQnA;

	@FindBy(xpath = "//div[@class='ep-auth__footer']/ul[1]/li[2]//a[1]")
	public WebElement footerAccountTerms;

	@FindBy(xpath = "//div[@class='ep-auth__footer']/ul[1]/li[3]//a[1]")
	public WebElement footerAccountPrivacy;

	@FindBy(xpath = "//div[@class='ep-auth__footer']/ul[1]/li[4]//a[1]")
	public WebElement footerAccountTax;

	@FindBy(xpath = "//h3[contains(text(),'「スタギア」利用規約')]")
	public WebElement footerTermsforAssert;

	@FindBy(xpath = "//img[@alt='個人情報保護方針']")
	public WebElement footerPrivacyforAssert;

	@FindBy(xpath = "//h3[contains(text(),'「特定商取引に関する法律」に基づく表示')]")
	public WebElement footerTaxforAssert;

	@FindBy(xpath = "//img[@alt='スタギアサポートセンター ヘルプセンターのホームページ']")
	public WebElement footerQandAforAssert;

	@FindBy(xpath = "//img[@alt='英検S-CBTを平日に受験しよう！']")
	public WebElement footerExaminationWindowLinkforAssert;

	@FindBy(xpath = "//div[@class='title']")
	public WebElement ScbtLinkforAssert;

	@FindBy(xpath = "//a[@href='/product-list']")
	public WebElement productListLink;

	@FindBy(xpath = "//div[@class='ep-product-list']/div[3]/div[2]/div[2]/div[4]/form[1]/button[1]")
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
			CommonFunctions.waitForVisiblity(footerTermsforAssert, 5);
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
			CommonFunctions.waitForVisiblity(footerPrivacyforAssert, 5);
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
			CommonFunctions.waitForVisiblity(footerTaxforAssert, 5);
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
			CommonFunctions.waitForVisiblity(footerQandAforAssert, 5);
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
			CommonFunctions.waitForVisiblity(footerExaminationWindowLinkforAssert, 5);
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
			CommonFunctions.waitForVisiblity(ScbtLinkforAssert, 5);
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
			CommonFunctions.waitForVisiblity(footerQandAforAssert, 5);
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
			CommonFunctions.waitForVisiblity(footerTermsforAssert, 5);
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
			CommonFunctions.waitForVisiblity(footerPrivacyforAssert, 5);
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
			CommonFunctions.waitForVisiblity(footerTaxforAssert, 5);
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
			CommonFunctions.waitForVisiblity(footerQandAforAssert, 5);
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
			CommonFunctions.waitForVisiblity(footerTermsforAssert, 5);
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
			CommonFunctions.waitForVisiblity(footerPrivacyforAssert, 5);
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
			CommonFunctions.waitForVisiblity(footerTaxforAssert, 5);
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
		loginObj.loginToPlatformForPayment();

	}

	// Testcase no: PT-102 to PT-105
	public void gotoOrderStepThreeForFooterValidation() throws Exception {

		CommonFunctions.isElementVisible(step3ProceedButton);
		CommonFunctions.waitForVisiblity(step3ProceedButton, waitTime);
		step3ProceedButton.click();

	}

}
