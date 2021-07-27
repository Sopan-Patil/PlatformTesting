package platform.pageobjects.Footer;

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

	public void footerFunctions() throws Exception {

		CommonFunctions.scrolltoElement(termsOfUseLink);
		if (CommonFunctions.isElementClickable(termsOfUseLink)) {
			termsOfUseLink.click();
			System.out.println("Terms of Use Link is working");
			driver.navigate().back();
		}

		CommonFunctions.scrolltoElement(privacyPolicyLink);
		if (CommonFunctions.isElementClickable(privacyPolicyLink)) {
			privacyPolicyLink.click();
			System.out.println("Privacy Policy Link is working");
		}

		CommonFunctions.scrolltoElement(specifiedCommodityTradingLawLink);
		if (CommonFunctions.isElementClickable(specifiedCommodityTradingLawLink)) {
			specifiedCommodityTradingLawLink.click();
			System.out.println("specifiedCommodityTradingLawLink is working");
			driver.navigate().back();
		}

		CommonFunctions.scrolltoElement(qnALink);
		if (CommonFunctions.isElementClickable(qnALink)) {
			qnALink.click();
			System.out.println("Q and A Link working");
		}

		CommonFunctions.scrolltoElement(footerExaminationWindowLink);
		if (CommonFunctions.isElementClickable(footerExaminationWindowLink)) {
			footerExaminationWindowLink.click();
			System.out.println("footerExaminationWindowLink is working");
			driver.navigate().back();
		}

		CommonFunctions.scrolltoElement(footerScbtLink);
		if (CommonFunctions.isElementClickable(footerScbtLink)) {
			footerScbtLink.click();
			System.out.println("footerScbtLink is working");
			driver.navigate().back();
		}

		CommonFunctions.scrolltoElement(footerCasecLink);
		if (CommonFunctions.isElementClickable(footerCasecLink)) {
			footerCasecLink.click();
			System.out.println("footerCasecLink is working");
			driver.navigate().back();
		}

		CommonFunctions.scrolltoElement(footerLearningWindowLink);
		if (CommonFunctions.isElementClickable(footerLearningWindowLink)) {
			footerLearningWindowLink.click();
			System.out.println("footerLearningWindowLink is working");
			driver.navigate().back();
		}

		CommonFunctions.scrolltoElement(footerStagiaEikenLink);
		if (CommonFunctions.isElementClickable(footerStagiaEikenLink)) {
			footerStagiaEikenLink.click();
			System.out.println("footerStagiaEikenLink is working");
			driver.navigate().back();
		}

		CommonFunctions.scrolltoElement(informationWindowLink);
		if (CommonFunctions.isElementClickable(informationWindowLink)) {
			informationWindowLink.click();
			System.out.println("informationWindowLink is working");
			driver.navigate().back();

		}

		CommonFunctions.scrolltoElement(cramSchoolPitaLink);
		if (CommonFunctions.isElementClickable(cramSchoolPitaLink)) {
			cramSchoolPitaLink.click();
			System.out.println("cramSchoolPitaLink is working");
		}

		CommonFunctions.scrolltoElement(stagiaUniversityExamLink);
		if (CommonFunctions.isElementClickable(stagiaUniversityExamLink)) {
			stagiaUniversityExamLink.click();
			System.out.println("stagiaUniversityExamLink is working");
		}

		CommonFunctions.scrolltoElement(educationCostConsulatationSupportLink);
		if (CommonFunctions.isElementClickable(educationCostConsulatationSupportLink)) {
			educationCostConsulatationSupportLink.click();
			System.out.println("educationCostConsulatationSupportLink is working");
		}

	}

	public void afterLoginFooter() throws Exception {
		CommonFunctions.scrolltoElement(accountSecurity);
		if (CommonFunctions.isElementClickable(accountSecurity)) {
			accountSecurity.click();
			System.out.println("accountSecurity Link is working");
			driver.navigate().back();
		}

		CommonFunctions.scrolltoElement(memberStatus);
		if (CommonFunctions.isElementClickable(memberStatus)) {
			memberStatus.click();
			System.out.println("memberStatus Link is working");
			driver.navigate().back();
		}

		CommonFunctions.scrolltoElement(servicesUsing);
		if (CommonFunctions.isElementClickable(servicesUsing)) {
			servicesUsing.click();
			System.out.println("servicesUsing Link is working");
			driver.navigate().back();
		}

		CommonFunctions.scrolltoElement(orderHistory);
		if (CommonFunctions.isElementClickable(orderHistory)) {
			orderHistory.click();
			System.out.println("orderHistory Link is working");
			driver.navigate().back();
		}

		CommonFunctions.scrolltoElement(logout);
		if (CommonFunctions.isElementClickable(logout)) {
			logout.click();
			System.out.println("logout Link is working");
			driver.navigate().back();
		}

	}

	public void accountServicesOrderFooter() throws Exception {

		CommonFunctions.scrolltoElement(accountQnA);
		if (CommonFunctions.isElementClickable(accountQnA)) {
			accountQnA.click();
			System.out.println("QnA Link is working");
		}

		CommonFunctions.scrolltoElement(accountTerms);
		if (CommonFunctions.isElementClickable(accountTerms)) {
			accountTerms.click();
			System.out.println("Terms of Use Link is working");
		}

		CommonFunctions.scrolltoElement(accountPrivacy);
		if (CommonFunctions.isElementClickable(accountPrivacy)) {
			accountPrivacy.click();
			System.out.println("Privacy Policy Link is working");
		}

		CommonFunctions.scrolltoElement(accountTax);
		if (CommonFunctions.isElementClickable(accountTax)) {
			accountTax.click();
			System.out.println("Terms of Use Link working");
		}

	}

	public void AccountFooter() throws Exception {

		CommonFunctions.scrolltoElement(withdraw);
		if (CommonFunctions.isElementClickable(withdraw)) {
			withdraw.click();
			System.out.println("Terms of Use Link working");
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
