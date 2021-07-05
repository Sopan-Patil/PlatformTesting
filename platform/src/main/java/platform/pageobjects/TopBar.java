package platform.pageobjects;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

/**
 * @Author : Chetan Sonparote
 * @Date : 26 Jun 2021
 * @Description: Locator variables and Methods for top bar
 */

public class TopBar {

	List<String[]> testdata;
	public WebDriver driver;
	private static Logger log = LogManager.getLogger(LoginPage.class.getName());

	public TopBar(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@href='/testing']")
	public WebElement examinationWindowLink;

	@FindBy(xpath = "//a[@href='/learning']")
	public WebElement learningWindowLink;

	@FindBy(xpath = "//a[@href='/media']")
	public WebElement informationWindowLink;

	@FindBy(xpath = "//a[@href='/product-list']")
	public WebElement productListLink;

	@FindBy(xpath = "//a[@href='/testing']")
	public WebElement testTopLink;

	@FindBy(xpath = "//a[@href='https://studygear.evidus.com/campaign/cp_scbt202108/']")
	public WebElement scbtLink;

	@FindBy(xpath = "//a[@href='https://casec.evidus.com/about/']")
	public WebElement casecLink;

	@FindBy(xpath = "//a[@href='/learning']")
	public WebElement learningTopLink;

	@FindBy(xpath = "//a[@href='/studygear-eiken']")
	public WebElement stagiaEikenLink;

	@FindBy(xpath = "//a[@href='/media']")
	public WebElement mediaTopLink;

	@FindBy(xpath = "//a[@href='https://dev.jyuku-pita.evidus.com/']")
	public WebElement cramSchoolPitaLink;

	@FindBy(xpath = "//a[@href='https://juken.ei-navi.jp/']")
	public WebElement stagiaUniversityExamLink;

	@FindBy(xpath = "//a[@href='https://consult.evidus.com/']")
	public WebElement educationCostConsulatationSupportLink;

	@FindBy(xpath = "//a[@href='/register']")
	public WebElement signUpLink;

	public void clickSignUpLinkLink() {

		signUpLink.click();

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

	public void clickMediaTopLink() {
		mediaTopLink.click();
	}

	public void clickStagiaEikenLink() {
		stagiaEikenLink.click();
	}

	public void clickLearningTopLink() {
		learningTopLink.click();
	}

	public void clickCASECLink() {
		casecLink.click();
	}

	public void clickSCBTLink() {
		scbtLink.click();
	}

	public void clickTestTopLink() {
		testTopLink.click();
	}

	public void clickExaminationWindowLink() {
		examinationWindowLink.click();
		Assert.assertTrue(driver.getCurrentUrl().contains("/testing"));
		// driver.getCurrentUrl().
	}

	public void clickLearningWindowLink() {
		learningWindowLink.click();
	}

	public void clickInformationWindowLink() {
		informationWindowLink.click();
	}

	public void clickProductListLink() {
		productListLink.click();
	}

}
