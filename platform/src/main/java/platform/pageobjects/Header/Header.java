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

	@Override
	public void closeZkaiPopup() {
		if (CommonFunctions.waitForVisiblity(zkai_popup, waitTime)) {
			zkai_popupCloseButton.click();
			log.info("Close Zkai pop up");
		}
	}

	public Header(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@class='modal-content']")
	public WebElement zkai_popup;

	@FindBy(xpath = "//button[@aria-label='Close']")
	public WebElement zkai_popupCloseButton;

	// Xpaths for the elements

	@FindBy(xpath = "//a[@class='logo logo-white']")
	public WebElement stagiaLogo;

	@FindBy(xpath = "//a[@class='menu__link js-not-link'][contains(text(),'受験の窓口')]")
	public WebElement examinationWindowLink;

	@FindBy(xpath = "//a[@class='menu__link js-not-link'][contains(text(),'学習の窓口')]")
	public WebElement learningWindowLink;

	@FindBy(xpath = "//a[@class='menu__link js-not-link'][contains(text(),'情報の窓口')]")
	public WebElement informationWindowLink;

	@FindBy(xpath = "//a[@href='/product-list']")
	public WebElement productListLink;

	@FindBy(xpath = "//a[@class='link link--smaller']")
	public WebElement singUpLink;

	@FindBy(xpath = "//a[@class='button button--default button--medium button--header']")
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

	@FindBy(xpath = "/html/body/div/div[1]/div[1]/div/div[1]/ul/li[1]/div/ul/li[1]/a/span")
	public WebElement testTopLink;

	@FindBy(xpath = "/html/body/div/div[1]/div[1]/div/div[1]/ul/li[1]/div/ul/li[2]/a/span")
	public WebElement eikenSCBTLink;

	@FindBy(xpath = "/html/body/div/div[1]/div[1]/div/div[1]/ul/li[1]/div/ul/li[3]/a/span")
	public WebElement casecLink;

	@FindBy(xpath = "/html/body/div/div[1]/div[1]/div/div[1]/ul/li[1]/div/ul/li[4]/a/span")
	public WebElement commonTestMeasureCBTLink;

	@FindBy(xpath = "/html/body/div/div[1]/div[1]/div/div[1]/ul/li[2]/div/ul/li[1]/a/span")
	public WebElement learningTopLink;

	@FindBy(xpath = "/html/body/div/div[1]/div[1]/div/div[1]/ul/li[2]/div/ul/li[2]/a/span")
	public WebElement stagiaEikenLink;

	@FindBy(xpath = "/html/body/div/div[1]/div[1]/div/div[1]/ul/li[3]/div/ul/li[1]/a/span")
	public WebElement mediaTopLink;

	@FindBy(xpath = "/html/body/div/div[1]/div[1]/div/div[1]/ul/li[3]/div/ul/li[2]/a/span")
	public WebElement cramSchoolPitaLink;

	@FindBy(xpath = "/html/body/div/div[1]/div[1]/div/div[1]/ul/li[3]/div/ul/li[3]/a/span")
	public WebElement stagiaUniversityExamLink;

	@FindBy(xpath = "/html/body/div/div[1]/div[1]/div/div[1]/ul/li[3]/div/ul/li[4]/a/span")
	public WebElement educationCostConsultationSupportLink;

	public void switchToPreviousTabAndClose() {
		ArrayList<String> tab = new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(tab.get(0));
	}

	public void headerAndSubMenuLinksVisibilityChecking() throws Exception {

		Actions actions = new Actions(driver);

		if (CommonFunctions.waitForVisiblity(zkai_popup, waitTime)) {
			zkai_popupCloseButton.click();
			log.info("Close Zkai pop up");
		}

		Thread.sleep(5000);

		CommonFunctions.isElementVisible(examinationWindowLink);
		log.info("Menu : Examnination Window Link is visible");

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

		CommonFunctions.isElementVisible(learningWindowLink);
		log.info("Menu : Learning Window Link is visible");

		actions.moveToElement(learningWindowLink).perform();
		log.info("Opened Submenu");
		CommonFunctions.isElementVisible(learningTopLink);
		log.info("Submenu : Learning Top Link is visible");

		actions.moveToElement(learningWindowLink).perform();
		log.info("Opened Submenu");
		CommonFunctions.isElementVisible(stagiaEikenLink);
		log.info("Submenu : Stagia Eiken Link is visible");

		CommonFunctions.isElementVisible(informationWindowLink);
		log.info("Menu : Information Window Link is visible");

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

		CommonFunctions.isElementVisible(productListLink);
		log.info("Menu : Product List link is visible");

		CommonFunctions.isElementVisible(singUpLink);
		log.info("Sign Up Link is visible");

		CommonFunctions.isElementVisible(loginLink);
		log.info("Login Link is visible");
	}

	public void headerLinksChecking() throws Exception {

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

		CommonFunctions.isElementVisible(singUpLink);
		CommonFunctions.waitForVisiblity(singUpLink, waitTime);
		singUpLink.click();
		log.info("Clicked on SignUp page");
		CommonFunctions.isElementVisible(emailTextBox);
		log.info("Email Textbox is visible");
		CommonFunctions.isElementVisible(EIDTextbox);
		log.info("EID Textbox is visible");
		CommonFunctions.isElementVisible(sendConfirmationEmailButton);
		log.info("Send confirmation Button is visible");

		driver.navigate().back();
		log.info("Back on Previous Page");

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

		CommonFunctions.waitForVisiblity(examinationWindowLink, waitTime);
		examinationWindowLink.click();
	}

	public void subMenuLinkChecking() throws Exception {

		Thread.sleep(5000);
		Actions actions = new Actions(driver);

		actions.moveToElement(examinationWindowLink).perform();
		log.info("Opened Submenu");
		Thread.sleep(100);
		testTopLink.click();
		log.info("Opened Test Top submenu");
		Thread.sleep(200);
		driver.navigate().back();
		log.info("Back on Previous Page");

		actions.moveToElement(examinationWindowLink).perform();
		log.info("Opened Submenu");
		Thread.sleep(100);
		eikenSCBTLink.click();
		log.info("Opened Eiken S-CBT submenu");
		Thread.sleep(5000);
		switchToPreviousTabAndClose();
		log.info("Back on Previous Page");

		Thread.sleep(200);
		actions.moveToElement(examinationWindowLink).perform();
		log.info("Opened Submenu");
		Thread.sleep(100);
		casecLink.click();
		log.info("Opened CASEC submenu");
		Thread.sleep(5000);
		switchToPreviousTabAndClose();
		log.info("Back on Previous Page");

		Thread.sleep(200);
		actions.moveToElement(examinationWindowLink).perform();
		log.info("Opened Submenu");
		Thread.sleep(100);
		commonTestMeasureCBTLink.click();
		log.info("Opened Common Test Measure CBT submenu");
		Thread.sleep(5000);
		driver.navigate().back();
		log.info("Back on Previous Page");

		Thread.sleep(200);
		actions.moveToElement(learningWindowLink).perform();
		log.info("Opened Submenu");
		Thread.sleep(100);
		learningTopLink.click();
		log.info("Opened Learning Top submenu");
		Thread.sleep(5000);
		driver.navigate().back();
		log.info("Back on Previous Page");

		Thread.sleep(200);
		actions.moveToElement(learningWindowLink).perform();
		log.info("Opened Submenu");
		Thread.sleep(100);
		stagiaEikenLink.click();
		log.info("Opened Stagia Eiken submenu");
		Thread.sleep(5000);
		driver.navigate().back();
		log.info("Back on Previous Page");

		Thread.sleep(200);
		actions.moveToElement(informationWindowLink).perform();
		log.info("Opened Submenu");
		Thread.sleep(100);
		mediaTopLink.click();
		log.info("Opened Media Top submenu");
		Thread.sleep(5000);
		driver.navigate().back();
		log.info("Back on Previous Page");

		Thread.sleep(200);
		actions.moveToElement(informationWindowLink).perform();
		log.info("Opened Submenu");
		Thread.sleep(100);
		cramSchoolPitaLink.click();
		log.info("Opened Cram School Pita submenu");
		Thread.sleep(5000);
		switchToPreviousTabAndClose();
		log.info("Back on Previous Page");

		Thread.sleep(200);
		actions.moveToElement(informationWindowLink).perform();
		log.info("Opened Submenu");
		Thread.sleep(100);
		stagiaUniversityExamLink.click();
		log.info("Opened Stagia University submenu");
		Thread.sleep(5000);
		switchToPreviousTabAndClose();
		log.info("Back on Previous Page");

		Thread.sleep(200);
		actions.moveToElement(informationWindowLink).perform();
		log.info("Opened Submenu");
		Thread.sleep(100);
		educationCostConsultationSupportLink.click();
		log.info("Opened Education Cost Consultation Support Link submenu");
		Thread.sleep(5000);
		switchToPreviousTabAndClose();
		log.info("Back on Previous Page");

	}

}
