package platform.pageobjects.Footer;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonFunctions;

/**
 * @Author : Chetan Sonparote, Sahaj Balgunde
 * @Date of Creation : 20 July 2021
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

	@FindBy(xpath = "//ul[@class='footer-bt__menu d-md-flex d-none']//a[@class='footer-bt__text'][contains(text(),'利用規約')]")
	public WebElement termsOfUseLink;

	@FindBy(xpath = "//ul[@class='footer-bt__menu d-md-flex d-none']//a[@class='footer-bt__text'][contains(text(),'プライバシーポリシー')]")
	public WebElement privacyPolicyLink;

	@FindBy(xpath = "//ul[@class='footer-bt__menu d-md-flex d-none']//a[@class='footer-bt__text'][contains(text(),'特定商品取引法')]")
	public WebElement specifiedCommodityTradingLawLink;

	@FindBy(xpath = "//ul[@class='footer-bt__menu d-md-flex d-none']//a[@class='footer-bt__text'][normalize-space()='Q&A']")
	public WebElement qnALink;

	@FindBy(xpath = "////a[@class='link'][contains(text(),'受験の窓口')]")
	public WebElement footerExaminationWindowLink;

	@FindBy(xpath = "//a[@class='sub-menu__text'][contains(text(),'英検S-CBT')]")
	public WebElement footerScbtLink;

	@FindBy(xpath = "//a[contains(text(),'CASEC')]")
	public WebElement footerCasecLink;

	@FindBy(xpath = "//div[@id='footer']//li[1]//ul[1]//li[3]//a[1]")
	public WebElement footerCommontest;

	@FindBy(xpath = "//a[@class='link'][contains(text(),'学習の窓口')]")
	public WebElement footerLearningWindowLink;

	@FindBy(xpath = "//a[@class='sub-menu__text'][contains(text(),'スタギア英検')]")
	public WebElement footerStagiaEikenLink;

	@FindBy(xpath = "//a[@class='link'][contains(text(),'情報の窓口')]")
	public WebElement informationWindowLink;

	@FindBy(xpath = "//a[@class='sub-menu__text'][contains(text(),'塾ピタ')]")
	public WebElement cramSchoolPitaLink;

	@FindBy(xpath = "//a[@class='sub-menu__text'][contains(text(),'スタギア大学受験')]")
	public WebElement stagiaUniversityExamLink;

	@FindBy(xpath = "//a[@class='sub-menu__text'][contains(text(),'教育費相談サポート')]")
	public WebElement educationCostConsulatationSupportLink;

	@FindBy(xpath = "//a[@class='sub-menu__text'][contains(text(),'アカウントとセキュリティ')]")
	public WebElement accountSecurity;

	@FindBy(xpath = "//a[@class='sub-menu__text'][contains(text(),'会員ステータス')]")
	public WebElement memberStatus;

	@FindBy(xpath = "//a[@class='sub-menu__text'][contains(text(),'ご利用中のサービス')]")
	public WebElement servicesUsing;

	@FindBy(xpath = "//a[@class='sub-menu__text'][contains(text(),'ご注文履歴')]")
	public WebElement orderHistory;

	@FindBy(xpath = "//a[contains(text(),'退会')]")
	public WebElement withdraw;

	@FindBy(xpath = "//a[contains(text(),'ログアウト')]")
	public WebElement logout;

	@FindBy(xpath = "//a[contains(text(),'ã‚ˆã��ã�‚ã‚‹è³ªå•�ãƒ»ã�Šå•�å�ˆã�›')]")
	public WebElement accountQnA;

	@FindBy(xpath = "//a[contains(text(),'åˆ©ç”¨è¦�ç´„ãƒ»å€‹äººæƒ…å ±ã�®å�–æ‰±')]")
	public WebElement accountTerms;

	@FindBy(xpath = "//a[contains(text(),'å€‹äººæƒ…å ±ä¿�è­·æ–¹é‡�')]")
	public WebElement accountPrivacy;

	@FindBy(xpath = "//a[contains(text(),'ç‰¹å®šå•†å�–å¼•æ³•ã�«åŸºã�¥ã��è¡¨ç¤º')]")
	public WebElement accountTax;

	public void switchToPreviousTab() {
		ArrayList<String> tab = new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(tab.get(0));
		// driver.close();
	}

	public void footerFunctions() throws Exception {

		CommonFunctions.scrolltoElement(termsOfUseLink);
		if (CommonFunctions.isElementClickable(termsOfUseLink)) {
			termsOfUseLink.click();
			log.info("Terms of Use Link is working");
			Thread.sleep(500);
			driver.navigate().back();
		} else {
			log.error("Terms of Use Link is not working");
		}

		CommonFunctions.scrolltoElement(privacyPolicyLink);
		if (CommonFunctions.isElementClickable(privacyPolicyLink)) {
			privacyPolicyLink.click();
			Thread.sleep(500);
			log.info("Privacy Policy Link is working");
			switchToPreviousTab();
		} else {
			log.error("Privacy Policy Link is not working");
		}

		CommonFunctions.scrolltoElement(specifiedCommodityTradingLawLink);
		if (CommonFunctions.isElementClickable(specifiedCommodityTradingLawLink)) {
			specifiedCommodityTradingLawLink.click();
			log.info("Specified Commodity Trading Law Link is working");
			Thread.sleep(500);
			driver.navigate().back();
		} else {
			log.error("Specified Commodity Trading Law Link is not working");
		}

		CommonFunctions.scrolltoElement(qnALink);
		if (CommonFunctions.isElementClickable(qnALink)) {
			qnALink.click();
			log.info("Q and A Link working");
			Thread.sleep(500);
			switchToPreviousTab();
		} else {
			log.error("Q and A Link is not working");
		}

		CommonFunctions.scrolltoElement(footerExaminationWindowLink);
		if (CommonFunctions.isElementClickable(footerExaminationWindowLink)) {
			footerExaminationWindowLink.click();
			log.info("footer Examination Window Link is working");
			Thread.sleep(500);
			driver.navigate().back();
		} else {
			log.error("footer Examination Window Link Link is not working");
		}

		CommonFunctions.scrolltoElement(footerScbtLink);
		if (CommonFunctions.isElementClickable(footerScbtLink)) {
			footerScbtLink.click();
			log.info("footer Scbt Link is working");
			Thread.sleep(500);
			switchToPreviousTab();
		} else {
			log.error("footer Scbt Link is not working");
		}

		CommonFunctions.scrolltoElement(footerCasecLink);
		if (CommonFunctions.isElementClickable(footerCasecLink)) {
			footerCasecLink.click();
			log.info("footer Casec Link is working");
			Thread.sleep(500);
			switchToPreviousTab();
		} else {
			log.error("footer Casec Link is not working");
		}

		CommonFunctions.scrolltoElement(footerLearningWindowLink);
		if (CommonFunctions.isElementClickable(footerLearningWindowLink)) {
			footerLearningWindowLink.click();
			log.info("footer Learning Window Link is working");
			Thread.sleep(500);
			driver.navigate().back();
		} else {
			log.error("footer Learning Window Link is not working");
		}

		CommonFunctions.scrolltoElement(footerStagiaEikenLink);
		if (CommonFunctions.isElementClickable(footerStagiaEikenLink)) {
			footerStagiaEikenLink.click();
			log.info("footer Stagia Eiken Link is working");
			Thread.sleep(500);
			driver.navigate().back();
		} else {
			log.error("footer Stagia Eiken Link is not working");
		}

		CommonFunctions.scrolltoElement(informationWindowLink);
		if (CommonFunctions.isElementClickable(informationWindowLink)) {
			informationWindowLink.click();
			log.info("information Window Link is working");
			Thread.sleep(500);
			driver.navigate().back();

		} else {
			log.error("information Window Link is not working");
		}

		CommonFunctions.scrolltoElement(cramSchoolPitaLink);
		if (CommonFunctions.isElementClickable(cramSchoolPitaLink)) {
			cramSchoolPitaLink.click();
			log.info("cram School Pita Link is working");
			Thread.sleep(500);
			switchToPreviousTab();
		} else {
			log.error("cram School Pita Link is not working");
		}

		CommonFunctions.scrolltoElement(stagiaUniversityExamLink);
		if (CommonFunctions.isElementClickable(stagiaUniversityExamLink)) {
			stagiaUniversityExamLink.click();
			log.info("stagia University Exam Link is working");
			Thread.sleep(500);
			switchToPreviousTab();
		} else {
			log.error("stagia University Exam Link is not working");
		}

		CommonFunctions.scrolltoElement(educationCostConsulatationSupportLink);
		if (CommonFunctions.isElementClickable(educationCostConsulatationSupportLink)) {
			educationCostConsulatationSupportLink.click();
			log.info("education CostConsulatation Support Link is working");
			Thread.sleep(500);
			switchToPreviousTab();
		} else {
			log.error("education CostConsulatation Support Link is not working");
		}

	}

	public void afterLoginFooter() throws Exception {
		CommonFunctions.scrolltoElement(accountSecurity);
		if (CommonFunctions.isElementClickable(accountSecurity)) {
			accountSecurity.click();
			log.info("account Security Link is working");
			Thread.sleep(500);
			driver.navigate().back();
		} else {
			log.error("account Security Link is not working");
		}

		CommonFunctions.scrolltoElement(memberStatus);
		if (CommonFunctions.isElementClickable(memberStatus)) {
			memberStatus.click();
			log.info("Membership Status Link is working");
			Thread.sleep(500);
			driver.navigate().back();
		} else {
			log.error("Membership Status Link is not working");
		}

		CommonFunctions.scrolltoElement(servicesUsing);
		if (CommonFunctions.isElementClickable(servicesUsing)) {
			servicesUsing.click();
			log.info("Services you are using Using Link is working");
			Thread.sleep(500);
			driver.navigate().back();
		} else {
			log.error("Services you are using Using Link is not working");
		}

		CommonFunctions.scrolltoElement(orderHistory);
		if (CommonFunctions.isElementClickable(orderHistory)) {
			orderHistory.click();
			log.info("order History Link is working");
			Thread.sleep(500);
			driver.navigate().back();
		} else {
			log.error("order History Link is not working");
		}

		CommonFunctions.scrolltoElement(logout);
		if (CommonFunctions.isElementClickable(logout)) {
			logout.click();
			log.info("Logout Link is working");
			Thread.sleep(500);
			driver.navigate().back();
		} else {
			log.error("Logout Link is not working");
		}

	}

	public void accountServicesOrderFooter() throws Exception {

		CommonFunctions.scrolltoElement(accountQnA);
		if (CommonFunctions.isElementClickable(accountQnA)) {
			accountQnA.click();
			log.info("QnA Link is working");
			Thread.sleep(500);
		} else {
			log.error("QnA Link is not working");
		}

		CommonFunctions.scrolltoElement(accountTerms);
		if (CommonFunctions.isElementClickable(accountTerms)) {
			accountTerms.click();
			log.info("Terms of Use Link is working");
			Thread.sleep(500);
		} else {
			log.error("Terms of Use Link is not working");
		}

		CommonFunctions.scrolltoElement(accountPrivacy);
		if (CommonFunctions.isElementClickable(accountPrivacy)) {
			accountPrivacy.click();
			log.info("Privacy Policy Link is working");
			Thread.sleep(500);
		} else {
			log.error("Privacy Policy Link is not working");
		}

		CommonFunctions.scrolltoElement(accountTax);
		if (CommonFunctions.isElementClickable(accountTax)) {
			accountTax.click();
			log.info("Account Tax Link working");
			Thread.sleep(500);
		} else {
			log.error("Account Tax Link is not working");
		}

	}

	public void AccountFooter() throws Exception {

		CommonFunctions.scrolltoElement(withdraw);
		if (CommonFunctions.isElementClickable(withdraw)) {
			withdraw.click();
			log.info("Withdraw Link working");
			Thread.sleep(500);
		} else {
			log.error("Withdraw Link is not working");
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
