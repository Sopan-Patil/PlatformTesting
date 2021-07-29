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

	@FindBy(xpath = "//ul[@class='footer-bt__menu d-md-flex d-none']//a[@class='footer-bt__text'][contains(text(),'利用�?約')]")
	public WebElement privacyPolicyLink;

	@FindBy(xpath = "//ul[@class='footer-bt__menu d-md-flex d-none']//a[@class='footer-bt__text'][contains(text(),'特定商�?�?�引法')]")
	public WebElement specifiedCommodityTradingLawLink;

	@FindBy(xpath = "//ul[@class='footer-bt__menu d-md-flex d-none']//a[@class='footer-bt__text'][normalize-space()='Q&A']")
	public WebElement qnALink;

	@FindBy(xpath = "//a[@class='link'][contains(text(),'�?�験�?�窓�?�')]")
	public WebElement footerExaminationWindowLink;

	@FindBy(xpath = "//a[@class='sub-menu__text']//font//font[contains(text(),'英検S-CBT')]")
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

	@FindBy(xpath = "//a[@class='sub-menu__text']//font//font[contains(text(),'sign up')]")
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

		termsOfUseLink.click();

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
