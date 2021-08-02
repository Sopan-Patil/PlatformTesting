package platform.pageobjects.Footer;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import platform.pageobjects.Authentication.LoginPage;
import utils.CommonFunctions;

/**
 * @Author : Chetan Sonparote
 * @Date of Creation : 26 Jun 2021
 * @Description: Additional Locator variables and Methods for footer.
 */

public class FooterPage {
	List<String[]> testdata;
	public WebDriver driver;
	private static Logger log = LogManager.getLogger(LoginPage.class.getName());

	public FooterPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/**
	 * @Author : Chetan Sonparote
	 * @Date : 29 Jul 2021
	 * @Description: Removed contains. text() from xpath
	 */
	// @FindBy(xpath = "//ul[@class='footer-bt__menu d-md-flex
	// d-none']//a[@class='footer-bt__text'][contains(text(),'利用�?約')]")
	// a[@href='/term']
	@FindBy(xpath = "//a[@href='/term']")
	public WebElement termsOfUseLink;

	// @FindBy(xpath = "//ul[@class='footer-bt__menu d-md-flex
	// d-none']//a[@class='footer-bt__text'][contains(text(),'利用�?約')]")

	@FindBy(xpath = "//a[@href='https://www.jiem.co.jp/privacy/']")
	public WebElement privacyPolicyLink;

	// @FindBy(xpath = "//ul[@class='footer-bt__menu d-md-flex
	// d-none']//a[@class='footer-bt__text'][contains(text(),'特定商�?�?�引法')]")

	@FindBy(xpath = "//a[@href='/transaction-method']")
	public WebElement specifiedCommodityTradingLawLink;

	// @FindBy(xpath = "//ul[@class='footer-bt__menu d-md-flex
	// d-none']//a[@class='footer-bt__text'][normalize-space()='Q&A']")

	@FindBy(xpath = "//a[@href='https://support.evidus.com/']")
	public WebElement qnALink;

	// @FindBy(xpath = "//a[@class='link'][contains(text(),'�?�験�?�窓�?�')]")

	@FindBy(xpath = "//a[@href='/testing']")
	public WebElement footerExaminationWindowLink;

	// @FindBy(xpath =
	// "//a[@class='sub-menu__text']//font//font[contains(text(),'英検S-CBT')]")
	// a[@class='sub-menu__text' and
	// @href='https://studygear.evidus.com/campaign/cp_scbt202109/']
	@FindBy(xpath = "//a[@class='sub-menu__text' and @href='https://studygear.evidus.com/campaign/cp_scbt202109/']")
	public WebElement footerScbtLink;

	// @FindBy(xpath = "//a[contains(text(),'CASEC')]")
	// a[@class='sub-menu__text'][normalize-space()='CASEC']
	@FindBy(xpath = "//a[@class='sub-menu__text'][normalize-space()='CASEC']")
	public WebElement footerCasecLink;

	// @FindBy(xpath = "//a[@class='link']//font//font[contains(text(),'Learning
	// window')]")
	// a[@href='/learning']
	@FindBy(xpath = "//a[@href='/learning']")
	public WebElement footerLearningWindowLink;

	// @FindBy(xpath =
	// "//a[@class='sub-menu__text']//font//font[contains(text(),'Stagia Eiken')]")
	// a[@href='/studygear-eiken']
	@FindBy(xpath = "//a[@href='/studygear-eiken']")
	public WebElement footerStagiaEikenLink;

	// @FindBy(xpath = "//a[@class='link']//font//font[contains(text(),'Information
	// window')]")
	// a[@href='/media']
	@FindBy(xpath = "//a[@href='/media']")
	public WebElement informationWindowLink;

	// @FindBy(xpath = "//a[@class='sub-menu__text
	// js-pitaElement']//font//font[contains(text(),'Cram school pita')]")
	@FindBy(xpath = "//a[@class='sub-menu__text' and @href='https://stg.jyuku-pita.evidus.com/']")
	public WebElement cramSchoolPitaLink;

	// @FindBy(xpath =
	// "//a[@class='sub-menu__text']//font//font[contains(text(),'Stagia University
	// Exam')]")
	@FindBy(xpath = "//a[@class='sub-menu__text' and @href='https://juken.ei-navi.jp/']")
	public WebElement stagiaUniversityExamLink;

	// @FindBy(xpath =
	// "//a[@class='sub-menu__text']//font//font[contains(text(),'Education cost
	// consultation support')]")
	@FindBy(xpath = "//a[@class='sub-menu__text' and @href='https://consult.evidus.com/']")
	public WebElement educationCostConsulatationSupportLink;

//	@FindBy(xpath = "//a[@class='sub-menu__text']//font//font[contains(text(),'sign up')]")
	@FindBy(xpath = "//a[@class='sub-menu__text' and @href='/register']")
	public WebElement signUpLink;

	public void clickSignUpLinkLink() {
		signUpLink.click();
	}

	public void clickInformationWindowLink() {
		informationWindowLink.click();
	}

	public void clickFooterStagiaEikenLink() {

		footerStagiaEikenLink.click();

	}

	public void clickFooterLearningWindowLink() {

		footerLearningWindowLink.click();

	}

	public void clickFooterCasecLink() {

		footerCasecLink.click();

	}

	public void clickFooterScbtLink() {

		CommonFunctions.scrolltoElement(footerScbtLink);
		if (CommonFunctions.isElementClickable(footerScbtLink)) {
			footerScbtLink.click();
		}

	}

	public void clickFooterExaminationWindowLink() {

		footerExaminationWindowLink.click();

	}

	public void clickQnALinkLink() {

		qnALink.click();

	}

	public void clickSpecifiedCommodityTradingLawLink() {

		specifiedCommodityTradingLawLink.click();

	}

	public void clickPrivacyPolicyLink() {

		privacyPolicyLink.click();

	}

	public void clickTermsOfUseLink() {

		CommonFunctions.scrolltoElement(termsOfUseLink);
		if (CommonFunctions.isElementClickable(termsOfUseLink)) {
			// termsOfUseLink.click();
			log.info("termsOfUseLink is clicked");
		} else
			log.error("termsOfUseLink is not working");

	}

	public void clickEducationCostConsulatationSupportLink() {
		educationCostConsulatationSupportLink.click();
	}

	public void clickStagiaUniversityExamLink() {
		stagiaUniversityExamLink.click();
	}

	public void clickCramSchoolPitaLink() {
		cramSchoolPitaLink.click();
	}
}
