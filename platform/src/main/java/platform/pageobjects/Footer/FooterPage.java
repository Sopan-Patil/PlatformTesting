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

	@FindBy(xpath = "//ul[@class='footer-bt__menu d-md-flex d-none']//a[@class='footer-bt__text'][contains(text(),'åˆ©ç”¨ï¿½?ç´„')]")
	public WebElement termsOfUseLink;

	@FindBy(xpath = "//ul[@class='footer-bt__menu d-md-flex d-none']//a[@class='footer-bt__text'][contains(text(),'åˆ©ç”¨ï¿½?ç´„')]")
	public WebElement privacyPolicyLink;

	@FindBy(xpath = "//ul[@class='footer-bt__menu d-md-flex d-none']//a[@class='footer-bt__text'][contains(text(),'ç‰¹å®šå•†ï¿½?ï¿½?ï¿½å¼•æ³•')]")
	public WebElement specifiedCommodityTradingLawLink;

	@FindBy(xpath = "//ul[@class='footer-bt__menu d-md-flex d-none']//a[@class='footer-bt__text'][normalize-space()='Q&A']")
	public WebElement qnALink;

	@FindBy(xpath = "//a[@class='link'][contains(text(),'ï¿½?ï¿½é¨“ï¿½?ï¿½çª“ï¿½?ï¿½')]")
	public WebElement footerExaminationWindowLink;

	@FindBy(xpath = "//a[@class='sub-menu__text']//font//font[contains(text(),'è‹±æ¤œS-CBT')]")
	public WebElement footerScbtLink;

	@FindBy(xpath = "//a[contains(text(),'CASEC')]")
	public WebElement footerCasecLink;

	@FindBy(xpath = "//a[@class='link']//font//font[contains(text(),'Learning window')]")
	public WebElement footerLearningWindowLink;

	@FindBy(xpath = "//a[@class='sub-menu__text']//font//font[contains(text(),'Stagia Eiken')]")
	public WebElement footerStagiaEikenLink;

	@FindBy(xpath = "//a[@class='link']//font//font[contains(text(),'Information window')]")
	public WebElement informationWindowLink;

	@FindBy(xpath = "//a[@class='sub-menu__text js-pitaElement']//font//font[contains(text(),'Cram school pita')]")
	public WebElement cramSchoolPitaLink;

	@FindBy(xpath = "//a[@class='sub-menu__text']//font//font[contains(text(),'Stagia University Exam')]")
	public WebElement stagiaUniversityExamLink;

	@FindBy(xpath = "//a[@class='sub-menu__text']//font//font[contains(text(),'Education cost consultation support')]")
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

	@FindBy(xpath = "//a[contains(text(),'よくある質問・お問合せ')]")
	public WebElement accountQnA;

	@FindBy(xpath = "//a[contains(text(),'利用規約・個人情報の取扱')]")
	public WebElement accountTerms;

	@FindBy(xpath = "//a[contains(text(),'個人情報保護方針')]")
	public WebElement accountPrivacy;

	@FindBy(xpath = "//a[contains(text(),'特定商取引法に基づく表示')]")
	public WebElement accountTax;

	public void footerFunctions() throws Exception {

		CommonFunctions.scrolltoElement(termsOfUseLink);
		if (CommonFunctions.isElementClickable(termsOfUseLink)) {
			termsOfUseLink.click();
		}

		CommonFunctions.scrolltoElement(privacyPolicyLink);
		if (CommonFunctions.isElementClickable(privacyPolicyLink)) {
			privacyPolicyLink.click();
		}

		CommonFunctions.scrolltoElement(specifiedCommodityTradingLawLink);
		if (CommonFunctions.isElementClickable(specifiedCommodityTradingLawLink)) {
			specifiedCommodityTradingLawLink.click();
		}

		CommonFunctions.scrolltoElement(qnALink);
		if (CommonFunctions.isElementClickable(qnALink)) {
			qnALink.click();
		}

		CommonFunctions.scrolltoElement(footerExaminationWindowLink);
		if (CommonFunctions.isElementClickable(footerExaminationWindowLink)) {
			footerExaminationWindowLink.click();
		}

		CommonFunctions.scrolltoElement(footerScbtLink);
		if (CommonFunctions.isElementClickable(footerScbtLink)) {
			footerScbtLink.click();
		}

		CommonFunctions.scrolltoElement(footerCasecLink);
		if (CommonFunctions.isElementClickable(footerCasecLink)) {
			footerCasecLink.click();
		}

		CommonFunctions.scrolltoElement(footerLearningWindowLink);
		if (CommonFunctions.isElementClickable(footerLearningWindowLink)) {
			footerLearningWindowLink.click();
		}

		CommonFunctions.scrolltoElement(footerStagiaEikenLink);
		if (CommonFunctions.isElementClickable(footerStagiaEikenLink)) {
			footerStagiaEikenLink.click();
		}

		CommonFunctions.scrolltoElement(informationWindowLink);
		if (CommonFunctions.isElementClickable(informationWindowLink)) {
			informationWindowLink.click();
		}

		CommonFunctions.scrolltoElement(cramSchoolPitaLink);
		if (CommonFunctions.isElementClickable(cramSchoolPitaLink)) {
			cramSchoolPitaLink.click();
		}

		CommonFunctions.scrolltoElement(stagiaUniversityExamLink);
		if (CommonFunctions.isElementClickable(stagiaUniversityExamLink)) {
			stagiaUniversityExamLink.click();
		}

		CommonFunctions.scrolltoElement(educationCostConsulatationSupportLink);
		if (CommonFunctions.isElementClickable(educationCostConsulatationSupportLink)) {
			educationCostConsulatationSupportLink.click();
		}

	}

	public void afterLoginFooter() throws Exception {
		CommonFunctions.scrolltoElement(accountSecurity);
		if (CommonFunctions.isElementClickable(accountSecurity)) {
			accountSecurity.click();
		}

		CommonFunctions.scrolltoElement(memberStatus);
		if (CommonFunctions.isElementClickable(memberStatus)) {
			memberStatus.click();
		}

		CommonFunctions.scrolltoElement(servicesUsing);
		if (CommonFunctions.isElementClickable(servicesUsing)) {
			servicesUsing.click();
		}

		CommonFunctions.scrolltoElement(orderHistory);
		if (CommonFunctions.isElementClickable(orderHistory)) {
			orderHistory.click();
		}

		CommonFunctions.scrolltoElement(logout);
		if (CommonFunctions.isElementClickable(logout)) {
			logout.click();
		}

	}

	public void accountServicesOrderFooter() throws Exception {

		CommonFunctions.scrolltoElement(accountQnA);
		if (CommonFunctions.isElementClickable(accountQnA)) {
			accountQnA.click();
		}

		CommonFunctions.scrolltoElement(accountTerms);
		if (CommonFunctions.isElementClickable(accountTerms)) {
			accountTerms.click();
		}

		CommonFunctions.scrolltoElement(accountPrivacy);
		if (CommonFunctions.isElementClickable(accountPrivacy)) {
			accountPrivacy.click();
		}

		CommonFunctions.scrolltoElement(accountTax);
		if (CommonFunctions.isElementClickable(accountTax)) {
			accountTax.click();
		}

	}

	public void AccountFooter() throws Exception {

		CommonFunctions.scrolltoElement(withdraw);
		if (CommonFunctions.isElementClickable(withdraw)) {
			withdraw.click();
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
