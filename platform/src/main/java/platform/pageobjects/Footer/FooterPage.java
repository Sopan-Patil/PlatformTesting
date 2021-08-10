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

/**
 * @Author : Chetan Sonparote
 * @Date of Creation : 26 June 2021
 * @Description: Additional Locator variables and Methods for footer.
 */

public class FooterPage {
	List<String[]> testdata;
	public WebDriver driver;
	private static Logger log = LogManager.getLogger(FooterPage.class.getName());

	public FooterPage(WebDriver driver) {
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

	public void clickFooterLinksBeforeLogin() throws Exception {

		CommonFunctions.scrolltoElement(termsOfUseLink);
		if (CommonFunctions.isElementClickable(termsOfUseLink)) {
			termsOfUseLink.click();
			CommonFunctions.waitForVisiblity(footerTermsforAssert, 5);
			String ActualTitle = driver.getTitle();
			String ExpectedTitle = "利用規約 - スタギア";
			Assert.assertEquals(ExpectedTitle, ActualTitle);
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
			String ActualTitle = driver.switchTo().window(tab.get(1)).getTitle();
			String ExpectedTitle = "プライバシーポリシー｜株式会社教育測定研究所（JIEM）";
			Assert.assertEquals(ExpectedTitle, ActualTitle);
			log.info("Privacy Policy Link is working");
			switchToPreviousTab();
		} else {
			log.error("Privacy Policy Link is not working");
		}

		CommonFunctions.scrolltoElement(specifiedCommodityTradingLawLink);
		if (CommonFunctions.isElementClickable(specifiedCommodityTradingLawLink)) {
			specifiedCommodityTradingLawLink.click();
			CommonFunctions.waitForVisiblity(footerTaxforAssert, 5);
			String ActualTitle = driver.getTitle();
			String ExpectedTitle = "特定商取引法 - スタギア";
			Assert.assertEquals(ExpectedTitle, ActualTitle);
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
			String ActualTitle = driver.switchTo().window(tab.get(1)).getTitle();
			String ExpectedTitle = "スタギアサポートセンター";
			Assert.assertEquals(ExpectedTitle, ActualTitle);
			log.info("Q and A Link working");
			switchToPreviousTab();
		} else {
			log.error("Q and A Link is not working");
		}

		CommonFunctions.scrolltoElement(footerExaminationWindowLink);
		if (CommonFunctions.isElementClickable(footerExaminationWindowLink)) {
			footerExaminationWindowLink.click();
			CommonFunctions.waitForVisiblity(footerExaminationWindowLinkforAssert, 5);
			String ActualTitle = driver.getTitle();
			String ExpectedTitle = "【スタギア 受験の窓口】各種検定・試験をお得に便利に申込み！";
			Assert.assertEquals(ExpectedTitle, ActualTitle);
			log.info("footer Examination Window Link is working");
			driver.navigate().back();
		} else {
			log.error("footer Examination Window Link Link is not working");
		}

		CommonFunctions.scrolltoElement(footerScbtLink);
		if (CommonFunctions.isElementClickable(footerScbtLink)) {
			footerScbtLink.click();
			ArrayList<String> tab = new ArrayList<>(driver.getWindowHandles());
			String ActualTitle = driver.switchTo().window(tab.get(1)).getTitle();
			CommonFunctions.waitForVisiblity(ScbtLinkforAssert, 5);
			String ExpectedTitle = "【スタギア】英検S-CBT｜平日受験がおトク！";
			Assert.assertEquals(ExpectedTitle, ActualTitle);
			log.info("footer Scbt Link is working");
			switchToPreviousTab();
		} else {
			log.error("footer Scbt Link is not working");
		}

		CommonFunctions.scrolltoElement(footerCasecLink);
		if (CommonFunctions.isElementClickable(footerCasecLink)) {
			footerCasecLink.click();
			ArrayList<String> tab = new ArrayList<>(driver.getWindowHandles());
			String ActualTitle = driver.switchTo().window(tab.get(1)).getTitle();
			String ExpectedTitle = "CASECとは？：Point1 すぐ測定 | CASEC（キャセック） - TOEICスコア・英検級の目安がすぐわかる英語テスト";
			Assert.assertEquals(ExpectedTitle, ActualTitle);
			log.info("footer Casec Link is working");
			switchToPreviousTab();
		} else {
			log.error("footer Casec Link is not working");
		}

		CommonFunctions.scrolltoElement(footerCommontestZKai);
		if (CommonFunctions.isElementClickable(footerCommontestZKai)) {
			footerCommontestZKai.click();
			String ActualTitle = driver.getTitle();
			String ExpectedTitle = "大学入学共通テストの到達度確認！『Z会×スタギア』在宅CBT";
			Assert.assertEquals(ExpectedTitle, ActualTitle);
			log.info("footer Casec Link is working");
			driver.navigate().back();
		} else {
			log.error("footer Casec Link is not working");
		}

		CommonFunctions.scrolltoElement(footerLearningWindowLink);
		if (CommonFunctions.isElementClickable(footerLearningWindowLink)) {
			footerLearningWindowLink.click();
			String ActualTitle = driver.getTitle();
			String ExpectedTitle = "【スタギア 学習の窓口】英検・漢検・数検の公式学習はスタギア";
			Assert.assertEquals(ExpectedTitle, ActualTitle);
			log.info("footer Learning Window Link is working");
			driver.navigate().back();
		} else {
			log.error("footer Learning Window Link is not working");
		}

		CommonFunctions.scrolltoElement(footerStagiaEikenLink);
		if (CommonFunctions.isElementClickable(footerStagiaEikenLink)) {
			footerStagiaEikenLink.click();
			String ActualTitle = driver.getTitle();
			String ExpectedTitle = "英検公式学習はスタギア | 準1級から5級の合格をサポート";
			Assert.assertEquals(ExpectedTitle, ActualTitle);
			log.info("footer Stagia Eiken Link is working");
			driver.navigate().back();
		} else {
			log.error("footer Stagia Eiken Link is not working");
		}

		CommonFunctions.scrolltoElement(footerStagiaKankenLink);
		if (CommonFunctions.isElementClickable(footerStagiaKankenLink)) {
			footerStagiaKankenLink.click();
			String ActualTitle = driver.getTitle();
			String ExpectedTitle = "漢検公式学習はスタギア | 検定合格から日常学習までサポート";
			Assert.assertEquals(ExpectedTitle, ActualTitle);
			log.info("footer Stagia Kanken Link is working");
			driver.navigate().back();
		} else {
			log.error("footer Stagia Kanken Link is not working");
		}

		CommonFunctions.scrolltoElement(informationWindowLink);
		if (CommonFunctions.isElementClickable(informationWindowLink)) {
			informationWindowLink.click();
			String ActualTitle = driver.getTitle();
			String ExpectedTitle = "【スタギア 情報の窓口】検定・入試・塾などの情報をいち早く";
			Assert.assertEquals(ExpectedTitle, ActualTitle);
			log.info("information Window Link is working");
			driver.navigate().back();

		} else {
			log.error("information Window Link is not working");
		}

		CommonFunctions.scrolltoElement(cramSchoolPitaLink);
		if (CommonFunctions.isElementClickable(cramSchoolPitaLink)) {
			cramSchoolPitaLink.click();
//			ArrayList<String> tab = new ArrayList<>(driver.getWindowHandles());
//			String ActualTitle = driver.switchTo().window(tab.get(1)).getTitle();
//			String ExpectedTitle = "【スタギア 受験の窓口】各種検定・試験をお得に便利に申込み！";
//			System.out.println(ActualTitle);
//			System.out.println(ExpectedTitle);
//			Assert.assertEquals(ExpectedTitle, ActualTitle);
			log.info("cram School Pita Link is working");
			switchToPreviousTab();
		} else {
			log.error("cram School Pita Link is not working");
		}

		CommonFunctions.scrolltoElement(stagiaUniversityExamLink);
		if (CommonFunctions.isElementClickable(stagiaUniversityExamLink)) {
			stagiaUniversityExamLink.click();
			ArrayList<String> tab = new ArrayList<>(driver.getWindowHandles());
			String ActualTitle = driver.switchTo().window(tab.get(1)).getTitle();
			String ExpectedTitle = "スタギア大学受験 | 偏差値や学費などの大学情報満載";
			Assert.assertEquals(ExpectedTitle, ActualTitle);
			log.info("stagia University Exam Link is working");
			switchToPreviousTab();
		} else {
			log.error("stagia University Exam Link is not working");
		}

		CommonFunctions.scrolltoElement(educationCostConsulatationSupportLink);
		if (CommonFunctions.isElementClickable(educationCostConsulatationSupportLink)) {
			educationCostConsulatationSupportLink.click();
			ArrayList<String> tab = new ArrayList<>(driver.getWindowHandles());
			String ActualTitle = driver.switchTo().window(tab.get(1)).getTitle();
			String ExpectedTitle = "教育費・教育資金 相談サポート";
			Assert.assertEquals(ExpectedTitle, ActualTitle);
			log.info("education CostConsulatation Support Link is working");
			switchToPreviousTab();
		} else {
			log.error("education CostConsulatation Support Link is not working");
		}

		CommonFunctions.scrolltoElement(footerLogin);
		if (CommonFunctions.isElementClickable(footerLogin)) {
			footerLogin.click();
			String ActualTitle = driver.getTitle();
			String ExpectedTitle = "ログイン - スタギア";
			// Assert.assertEquals(ExpectedTitle, ActualTitle);
			log.info("Footer Login Link is working");
			driver.navigate().back();

		} else {
			log.error("Footer Login Link is not working");
		}

		CommonFunctions.scrolltoElement(footerRegister);
		if (CommonFunctions.isElementClickable(footerRegister)) {
			footerRegister.click();
			String ActualTitle = driver.getTitle();
			String ExpectedTitle = "アカウント作成 - スタギア";
			// Assert.assertEquals(ExpectedTitle, ActualTitle);
			log.info("Footer Registration Link is working");
			driver.navigate().back();

		} else {
			log.error("Footer Registration Link is not working");
		}

	}

	public void clickFooterLinksAfterLogin() throws Exception {
		CommonFunctions.scrolltoElement(accountSecurity);
		if (CommonFunctions.isElementClickable(accountSecurity)) {
			accountSecurity.click();
			String ActualTitle = driver.getTitle();
			String ExpectedTitle = "アカウントとセキュリティ - スタギア";
			Assert.assertEquals(ExpectedTitle, ActualTitle);
			log.info("account Security Link is working");
			driver.navigate().back();
		} else {
			log.error("account Security Link is not working");
		}

		CommonFunctions.scrolltoElement(memberStatus);
		if (CommonFunctions.isElementClickable(memberStatus)) {
			memberStatus.click();
			String ActualTitle = driver.getTitle();
			String ExpectedTitle = "会員ステータス - スタギア";
			Assert.assertEquals(ExpectedTitle, ActualTitle);
			log.info("Membership Status Link is working");
			driver.navigate().back();
		} else {
			log.error("Membership Status Link is not working");
		}

		CommonFunctions.scrolltoElement(servicesUsing);
		if (CommonFunctions.isElementClickable(servicesUsing)) {
			servicesUsing.click();
			String ActualTitle = driver.getTitle();
			String ExpectedTitle = "ご利用中のサービス - スタギア";
			Assert.assertEquals(ExpectedTitle, ActualTitle);
			log.info("Services you are using Using Link is working");
			driver.navigate().back();
		} else {
			log.error("Services you are using Using Link is not working");
		}

		CommonFunctions.scrolltoElement(orderHistory);
		if (CommonFunctions.isElementClickable(orderHistory)) {
			orderHistory.click();
			String ActualTitle = driver.getTitle();
			String ExpectedTitle = "ご注文履歴 - スタギア";
			Assert.assertEquals(ExpectedTitle, ActualTitle);
			log.info("order History Link is working");
			driver.navigate().back();
		} else {
			log.error("order History Link is not working");
		}

		CommonFunctions.scrolltoElement(withdraw);
		if (CommonFunctions.isElementClickable(withdraw)) {
			withdraw.click();
			String ActualTitle = driver.getTitle();
			String ExpectedTitle = "退会確認 - スタギア";
			Assert.assertEquals(ExpectedTitle, ActualTitle);
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

	public void clickOrderFlowFooterLinks() throws Exception {

		CommonFunctions.scrolltoElement(footerAccountQnA);
		if (CommonFunctions.isElementClickable(footerAccountQnA)) {
			footerAccountQnA.click();
			CommonFunctions.waitForVisiblity(footerQandAforAssert, 5);
			ArrayList<String> tab = new ArrayList<>(driver.getWindowHandles());
			String ActualTitle = driver.switchTo().window(tab.get(1)).getTitle();
			String ExpectedTitle = "スタギアサポートセンター";
			Assert.assertEquals(ExpectedTitle, ActualTitle);
			log.info("QnA Link is working");
		} else {
			log.error("QnA Link is not working");
		}

		CommonFunctions.scrolltoElement(footerAccountTerms);
		if (CommonFunctions.isElementClickable(footerAccountTerms)) {
			footerAccountTerms.click();
			CommonFunctions.waitForVisiblity(footerTermsforAssert, 5);
			String ActualTitle = driver.getTitle();
			String ExpectedTitle = "利用規約 - スタギア";
			Assert.assertEquals(ExpectedTitle, ActualTitle);
			log.info("Terms of Use Link is working");
		} else {
			log.error("Terms of Use Link is not working");
		}

		CommonFunctions.scrolltoElement(footerAccountPrivacy);
		if (CommonFunctions.isElementClickable(footerAccountPrivacy)) {
			footerAccountPrivacy.click();
			CommonFunctions.waitForVisiblity(footerPrivacyforAssert, 5);
			ArrayList<String> tab = new ArrayList<>(driver.getWindowHandles());
			String ActualTitle = driver.switchTo().window(tab.get(1)).getTitle();
			String ExpectedTitle = "プライバシーポリシー｜株式会社教育測定研究所（JIEM）";
			Assert.assertEquals(ExpectedTitle, ActualTitle);
			log.info("Privacy Policy Link is working");
		} else {
			log.error("Privacy Policy Link is not working");
		}

		CommonFunctions.scrolltoElement(footerAccountTax);
		if (CommonFunctions.isElementClickable(footerAccountTax)) {
			footerAccountTax.click();
			CommonFunctions.waitForVisiblity(footerTaxforAssert, 5);
			String ActualTitle = driver.getTitle();
			String ExpectedTitle = "特定商取引法 - スタギア";
			Assert.assertEquals(ExpectedTitle, ActualTitle);
			log.info("Account Tax Link working");
		} else {
			log.error("Account Tax Link is not working");
		}

	}

	public void clickAccountServicesFooterLinks() throws Exception {

		CommonFunctions.scrolltoElement(footerAccountQnA);
		if (CommonFunctions.isElementClickable(footerAccountQnA)) {
			footerAccountQnA.click();
			CommonFunctions.waitForVisiblity(footerQandAforAssert, 5);
			ArrayList<String> tab = new ArrayList<>(driver.getWindowHandles());
			String ActualTitle = driver.switchTo().window(tab.get(1)).getTitle();
			String ExpectedTitle = "スタギアサポートセンター";
			Assert.assertEquals(ExpectedTitle, ActualTitle);
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
			String ActualTitle = driver.switchTo().window(tab.get(1)).getTitle();
			String ExpectedTitle = "利用規約 - スタギア";
			Assert.assertEquals(ExpectedTitle, ActualTitle);
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
			String ActualTitle = driver.switchTo().window(tab.get(1)).getTitle();
			String ExpectedTitle = "プライバシーポリシー｜株式会社教育測定研究所（JIEM）";
			Assert.assertEquals(ExpectedTitle, ActualTitle);
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
			String ActualTitle = driver.switchTo().window(tab.get(1)).getTitle();
			String ExpectedTitle = "特定商取引法 - スタギア";
			Assert.assertEquals(ExpectedTitle, ActualTitle);
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

	/*
	 * public void clickFooterScbtLink() {
	 * 
	 * CommonFunctions.scrolltoElement(footerScbtLink); if
	 * (CommonFunctions.isElementClickable(footerScbtLink)) {
	 * footerScbtLink.click(); }
	 * 
	 * }
	 */

}
