package platform.pageobjects.Header;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.NewBaseClass;
import utils.CommonFunctions;

/**
 * @Author : Amogh Nanal
 * @Date : 22 Jul 2021
 * @Description: Header Links and their Visibility
 */

public class Header extends NewBaseClass {

	List<String[]> testdata;
	public WebDriver driver;
	private static Logger log = LogManager.getLogger(Header.class.getName());
	int waitTime = 1;

	public Header(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Xpaths for the elements

	@FindBy(xpath = "//a[@class='logo']")
	public WebElement logo;

	@FindBy(xpath = "//a[@href='/testing']")
	public WebElement examinationWindowLink;

	@FindBy(xpath = "//a[@href='/learning']")
	public WebElement learningWindowLink;

	@FindBy(xpath = "//a[@href='/media']")
	public WebElement informationWindowLink;

	@FindBy(xpath = "//a[@href='/product-list']")
	public WebElement productListLink;

	@FindBy(xpath = "//a[@class='link link--smaller']")
	public WebElement signUpLink;

	@FindBy(xpath = "//a[@class='button button--default button--medium button--header']")
	public WebElement loginLink1;

	@FindBy(xpath = "//a[@class='button button--white3 button--medium button--header']")
	public WebElement loginLink;

	// Xpaths for the Textboxes and Buttons

	@FindBy(xpath = "//input[@id='email']")
	public WebElement emailTextBox;

	@FindBy(xpath = "//input[@id='entryIdentifier']")
	public WebElement EIDTextbox;

	@FindBy(xpath = "//button[@type='submit']")
	public WebElement sendConfirmationEmailButton;

	@FindBy(xpath = "//span[contains(text(),'ログイン')]")
	public WebElement loginButton;

	// Xpaths for the Sub Menus

	@FindBy(xpath = "//ul[@class='submenu__list submenu__list--img']//li[1]//a[1]")
	public WebElement testTopLink;

	@FindBy(xpath = "//ul[@class='submenu__list submenu__list--img']//li[2]//a[1]")
	public WebElement eikenSCBTLink;

	@FindBy(xpath = "//ul[@class='submenu__list submenu__list--img']//li[3]//a[1]")
	public WebElement casecLink;

	@FindBy(xpath = "//ul[@class='submenu__list submenu__list--img']//li[4]//a[1]")
	public WebElement commonTestMeasureCBTLink;

	@FindBy(xpath = "//li[2]//ul[@class='submenu__list submenu__list--img']//li[1]//a[1]")
	public WebElement learningTopLink;

	@FindBy(xpath = "//li[2]//ul[@class='submenu__list submenu__list--img']//li[2]//a[1]")
	public WebElement stagiaKankenLink;

	@FindBy(xpath = "//li[2]//ul[@class='submenu__list submenu__list--img']//li[3]//a[1]")
	public WebElement stagiaEikenLink;

	@FindBy(xpath = "//ul[@class='submenu__list']//li[1]//a[1]")
	public WebElement mediaTopLink;

	@FindBy(xpath = "//ul[@class='submenu__list']//li[2]//a[1]")
	public WebElement cramSchoolPitaLink;

	@FindBy(xpath = "//ul[@class='submenu__list']//li[3]//a[1]")
	public WebElement stagiaUniversityExamLink;

	@FindBy(xpath = "//ul[@class='submenu__list']//li[4]//a[1]")
	public WebElement educationCostConsultationSupportLink;

	// Method : switches the current tab to the first tab
	public void switchToPreviousTab() {
		ArrayList<String> tab = new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(tab.get(0));
	}

	// Method : Checks the Header menu and SubMenu Links
	public void checkHeaderMenuLinksVisibility() throws Exception {

		Actions actions = new Actions(driver);

		actions.moveToElement(examinationWindowLink).perform();
		CommonFunctions.isElementVisible(examinationWindowLink);
		log.info("Menu : Examnination Window Link is visible");

		actions.moveToElement(learningWindowLink).perform();
		CommonFunctions.isElementVisible(learningWindowLink);
		log.info("Menu : Learning Window Link is visible");

		actions.moveToElement(informationWindowLink).perform();
		CommonFunctions.isElementVisible(informationWindowLink);
		log.info("Menu : Information Window Link is visible");

		actions.moveToElement(productListLink).perform();
		CommonFunctions.isElementVisible(productListLink);
		log.info("Menu : Product List link is visible");

		actions.moveToElement(signUpLink).perform();
		CommonFunctions.isElementVisible(signUpLink);
		log.info("Sign Up Link is visible");

		actions.moveToElement(loginLink).perform();
		CommonFunctions.isElementVisible(loginLink);
		log.info("Login Link is visible");
	}

	public void checkSubMenuLinkVisibility() throws Exception {

		Actions actions = new Actions(driver);
		actions.moveToElement(examinationWindowLink).perform();
		log.info("Opened Submenu");
		CommonFunctions.isElementVisible(testTopLink);
		log.info("Submenu : TestTop Link  is visible");

		actions.moveToElement(examinationWindowLink).perform();
		log.info("Opened Submenu");
		CommonFunctions.isElementVisible(eikenSCBTLink);
		log.info("Submenu : Eiken S-CBT Link is visible");

		actions.moveToElement(examinationWindowLink).perform();
		log.info("Opened Submenu");
		CommonFunctions.isElementVisible(casecLink);
		log.info("Submenu : CASEC Link is visible");

		actions.moveToElement(examinationWindowLink).perform();
		log.info("Opened Submenu");
		CommonFunctions.isElementVisible(commonTestMeasureCBTLink);
		log.info("Submenu : Common Test Measure CBT Link is visible");

		actions.moveToElement(learningWindowLink).perform();
		log.info("Opened Submenu");
		CommonFunctions.isElementVisible(learningTopLink);
		log.info("Submenu : Learning Top Link is visible");

		actions.moveToElement(learningWindowLink).perform();
		log.info("Opened Submenu");
		CommonFunctions.isElementVisible(stagiaEikenLink);
		log.info("Submenu : Stagia Eiken Link is visible");

		actions.moveToElement(learningWindowLink).perform();
		log.info("Opened Submenu");
		CommonFunctions.isElementVisible(stagiaKankenLink);
		log.info("Submenu : Stagia KanKen Link is visible");

		actions.moveToElement(informationWindowLink).perform();
		log.info("Opened Submenu");
		CommonFunctions.isElementVisible(mediaTopLink);
		log.info("Submenu : Media Top Link is visible");

		actions.moveToElement(informationWindowLink).perform();
		log.info("Opened Submenu");
		CommonFunctions.isElementVisible(cramSchoolPitaLink);
		log.info("Submenu : Cram School Pita Link link is visible");

		actions.moveToElement(informationWindowLink).perform();
		log.info("Opened Submenu");
		CommonFunctions.isElementVisible(stagiaUniversityExamLink);
		log.info("Submenu : Stagia University Exam Link is visible");

		actions.moveToElement(informationWindowLink).perform();
		log.info("Opened Submenu");
		CommonFunctions.isElementVisible(educationCostConsultationSupportLink);
		log.info("Submenu : Education Cost Consultation Support Link is visible");

	}

	// Method : Checks the Header menu links are working by clicking on them
	public void checkHeaderLinksWorking() throws Exception {

		CommonFunctions.isElementVisible(examinationWindowLink);
		CommonFunctions.waitForVisiblity(examinationWindowLink, waitTime);
		examinationWindowLink.click();
		log.info("Clicked on Examination Window page");

		CommonFunctions.isElementVisible(learningWindowLink);
		CommonFunctions.waitForVisiblity(learningWindowLink, waitTime);
		learningWindowLink.click();
		log.info("Clicked on Learning Window page");

		CommonFunctions.isElementVisible(informationWindowLink);
		CommonFunctions.waitForVisiblity(informationWindowLink, waitTime);
		informationWindowLink.click();
		log.info("Clicked on Information Window page");

		CommonFunctions.isElementVisible(productListLink);
		CommonFunctions.waitForVisiblity(productListLink, waitTime);
		productListLink.click();
		log.info("Clicked on Product List page");

		CommonFunctions.isElementVisible(signUpLink);
		CommonFunctions.waitForVisiblity(signUpLink, waitTime);
		signUpLink.click();
		log.info("Clicked on SignUp page");
		CommonFunctions.isElementVisible(emailTextBox);
		log.info("Email Textbox is visible");
		CommonFunctions.isElementVisible(EIDTextbox);
		log.info("EID Textbox is visible");
		CommonFunctions.isElementVisible(sendConfirmationEmailButton);
		log.info("Send confirmation Button is visible");

		driver.navigate().back();
		log.info("Back on Previous Page");

		CommonFunctions.isElementVisible(logo);
		CommonFunctions.waitForVisiblity(logo, waitTime);
		logo.click();
		log.info("Back on Home Page");

		CommonFunctions.isElementVisible(loginLink);
		CommonFunctions.waitForVisiblity(loginLink, waitTime);
		loginLink.click();
		log.info("Clicked on Login Page");
		CommonFunctions.isElementVisible(emailTextBox);
		log.info("Email Textbox is visible");
		CommonFunctions.isElementVisible(EIDTextbox);
		log.info("EID Textbox is visible");
		CommonFunctions.isElementVisible(loginButton);
		log.info("Login Button is visible");

		driver.navigate().back();
		log.info("Back on Previous Page");

	}

	// Method : Checks the Header SubMenu links are working by clicking on them
	public void checkSubMenuLinkWorking() throws Exception {

		Actions actions = new Actions(driver);

		CommonFunctions.waitandClear(examinationWindowLink, waitTime);
		actions.moveToElement(examinationWindowLink).perform();
		log.info("Opened Submenu");
		CommonFunctions.isElementVisible(testTopLink);
		CommonFunctions.waitForVisiblity(testTopLink, waitTime);
		testTopLink.click();
		log.info("Opened Test Top submenu");
		driver.navigate().back();
		log.info("Back on Previous Page");

		CommonFunctions.waitForVisiblity(eikenSCBTLink, waitTime);
		actions.moveToElement(examinationWindowLink).perform();
		log.info("Opened Submenu");
		CommonFunctions.isElementVisible(eikenSCBTLink);
		CommonFunctions.waitForVisiblity(eikenSCBTLink, waitTime);
		eikenSCBTLink.click();
		log.info("Opened Eiken S-CBT submenu");
		CommonFunctions.waitandClear(eikenSCBTLink, waitTime);
		switchToPreviousTab();
		log.info("Back on Previous Page");

		CommonFunctions.waitForVisiblity(casecLink, waitTime);
		actions.moveToElement(examinationWindowLink).perform();
		log.info("Opened Submenu");
		CommonFunctions.isElementVisible(casecLink);
		CommonFunctions.waitForVisiblity(casecLink, waitTime);
		casecLink.click();
		log.info("Opened CASEC submenu");
		CommonFunctions.waitandClear(casecLink, waitTime);
		switchToPreviousTab();
		log.info("Back on Previous Page");

		CommonFunctions.waitForVisiblity(commonTestMeasureCBTLink, waitTime);
		actions.moveToElement(examinationWindowLink).perform();
		log.info("Opened Submenu");
		CommonFunctions.isElementVisible(commonTestMeasureCBTLink);
		CommonFunctions.waitForVisiblity(commonTestMeasureCBTLink, waitTime);
		commonTestMeasureCBTLink.click();
		log.info("Opened Common Test Measure CBT submenu");
		CommonFunctions.waitForVisiblity(commonTestMeasureCBTLink, waitTime);
		driver.navigate().back();
		log.info("Back on Previous Page");

		CommonFunctions.waitForVisiblity(learningTopLink, waitTime);
		actions.moveToElement(learningWindowLink).perform();
		log.info("Opened Submenu");
		CommonFunctions.isElementVisible(learningTopLink);
		CommonFunctions.waitForVisiblity(learningTopLink, waitTime);
		learningTopLink.click();
		log.info("Opened Learning Top submenu");
		CommonFunctions.waitForVisiblity(learningTopLink, waitTime);
		driver.navigate().back();
		log.info("Back on Previous Page");

		CommonFunctions.waitForVisiblity(stagiaEikenLink, waitTime);
		actions.moveToElement(learningWindowLink).perform();
		log.info("Opened Submenu");
		CommonFunctions.isElementVisible(stagiaEikenLink);
		CommonFunctions.waitForVisiblity(stagiaEikenLink, waitTime);
		stagiaEikenLink.click();
		log.info("Opened Stagia Eiken submenu");
		CommonFunctions.waitForVisiblity(stagiaEikenLink, waitTime);
		driver.navigate().back();
		log.info("Back on Previous Page");

		CommonFunctions.waitForVisiblity(stagiaKankenLink, waitTime);
		actions.moveToElement(learningWindowLink).perform();
		log.info("Opened Submenu");
		CommonFunctions.isElementVisible(stagiaKankenLink);
		CommonFunctions.waitForVisiblity(stagiaKankenLink, waitTime);
		stagiaKankenLink.click();
		log.info("Opened Stagia Kanken submenu");
		CommonFunctions.waitForVisiblity(stagiaKankenLink, waitTime);
		driver.navigate().back();
		log.info("Back on Previous Page");

		CommonFunctions.waitForVisiblity(mediaTopLink, waitTime);
		actions.moveToElement(informationWindowLink).perform();
		log.info("Opened Submenu");
		CommonFunctions.isElementVisible(mediaTopLink);
		CommonFunctions.waitForVisiblity(mediaTopLink, waitTime);
		mediaTopLink.click();
		log.info("Opened Media Top submenu");
		CommonFunctions.waitForVisiblity(mediaTopLink, waitTime);
		driver.navigate().back();
		log.info("Back on Previous Page");

		CommonFunctions.waitForVisiblity(cramSchoolPitaLink, waitTime);
		actions.moveToElement(informationWindowLink).perform();
		log.info("Opened Submenu");
		CommonFunctions.isElementVisible(cramSchoolPitaLink);
		CommonFunctions.waitForVisiblity(cramSchoolPitaLink, waitTime);
		cramSchoolPitaLink.click();
		log.info("Opened Cram School Pita submenu");
		CommonFunctions.waitForVisiblity(cramSchoolPitaLink, waitTime);
		switchToPreviousTab();
		log.info("Back on Previous Page");

		CommonFunctions.waitForVisiblity(stagiaUniversityExamLink, waitTime);
		actions.moveToElement(informationWindowLink).perform();
		log.info("Opened Submenu");
		CommonFunctions.isElementVisible(stagiaUniversityExamLink);
		CommonFunctions.waitForVisiblity(stagiaUniversityExamLink, waitTime);
		stagiaUniversityExamLink.click();
		log.info("Opened Stagia University submenu");
		CommonFunctions.waitForVisiblity(stagiaUniversityExamLink, waitTime);
		switchToPreviousTab();
		log.info("Back on Previous Page");

		CommonFunctions.waitForVisiblity(educationCostConsultationSupportLink, waitTime);
		actions.moveToElement(informationWindowLink).perform();
		log.info("Opened Submenu");
		CommonFunctions.isElementVisible(educationCostConsultationSupportLink);
		CommonFunctions.waitForVisiblity(educationCostConsultationSupportLink, waitTime);
		educationCostConsultationSupportLink.click();
		log.info("Opened Education Cost Consultation Support Link submenu");
		CommonFunctions.waitForVisiblity(educationCostConsultationSupportLink, waitTime);
		switchToPreviousTab();
		log.info("Back on Previous Page");
	}

}
