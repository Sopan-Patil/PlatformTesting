package platform.pageobjects.Header;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.NewBaseClass;
import utils.CommonFunctions;

public class HeaderAfterLogin extends NewBaseClass {

	List<String[]> testdata;
	public WebDriver driver;
	private static Logger log = LogManager.getLogger(Header.class.getName());
	int waitTime = 5;

	public HeaderAfterLogin(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@class='logo']")
	public WebElement logo;

	@FindBy(xpath = "//a[@href='/mypage-account-security']")
	public WebElement accountAndSecurityLink;

	@FindBy(xpath = "//a[@class='button button--blue1 button--xsmall font-weight-normal']")
	public WebElement membershipButton;

	@FindBy(xpath = "//div[@class='submenu']//ul[1]//li[1]//a[1]")
	public WebElement accountAndSecuritySubmenuLink;

	@FindBy(xpath = "//div[@class='submenu']//ul[1]//li[2]//a[1]")
	public WebElement membershipSubMenuLink;

	@FindBy(xpath = "//div[@class='submenu']//ul[1]//li[3]//a[1]")
	public WebElement servicesYouAreUsingSubMenuLink;

	@FindBy(xpath = "//div[@class='submenu']//ul[1]//li[4]//a[1]")
	public WebElement orderHistorySubMenuLink;

	public void switchToPreviousTab() {
		ArrayList<String> tab = new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(tab.get(1));
		driver.close();
		driver.switchTo().window(tab.get(0));
	}

	public void clickSubMenu(WebElement x, WebElement y) throws Exception {

		Actions actions = new Actions(driver);
		CommonFunctions.waitForVisiblity(x, waitTime);
		actions.moveToElement(x).perform();
		log.info("Opened Submenu");
		CommonFunctions.isElementVisible(y);
		CommonFunctions.waitForVisiblity(y, waitTime);
		y.click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	public void checkHeaderMenuAndSubMenuLinksVisibilityAfterLogin() throws Exception {

		Actions actions = new Actions(driver);

		actions.moveToElement(accountAndSecurityLink).perform();
		CommonFunctions.isElementVisible(accountAndSecurityLink);
		log.info("Menu : Account Security Link is visible");

		actions.moveToElement(membershipButton).perform();
		CommonFunctions.isElementVisible(membershipButton);
		log.info("Menu : Membership Button Link is visible");

		actions.moveToElement(accountAndSecuritySubmenuLink).perform();
		CommonFunctions.isElementVisible(accountAndSecuritySubmenuLink);
		log.info("SubMenu : AccountAndSecurity Link is visible");

		actions.moveToElement(membershipSubMenuLink).perform();
		CommonFunctions.isElementVisible(membershipSubMenuLink);
		log.info("SubMenu : Membership Status Button Link is visible");

		actions.moveToElement(servicesYouAreUsingSubMenuLink).perform();
		CommonFunctions.isElementVisible(servicesYouAreUsingSubMenuLink);
		log.info("SubMenu : Services You Are Using Link is visible");

		actions.moveToElement(orderHistorySubMenuLink).perform();
		CommonFunctions.isElementVisible(orderHistorySubMenuLink);
		log.info("Sub Menu : Order History Link is visible");

	}

	public void checkHeaderAndSubMenuLinksWorkingAfterLogin() throws Exception {

		CommonFunctions.isElementVisible(accountAndSecurityLink);
		CommonFunctions.waitForVisiblity(accountAndSecurityLink, waitTime);
		accountAndSecurityLink.click();
		log.info("Clicked on Account And Security page");
		driver.navigate().back();

		CommonFunctions.isElementVisible(membershipButton);
		CommonFunctions.waitForVisiblity(membershipButton, waitTime);
		membershipButton.click();
		log.info("Clicked on Learning Window page");
		driver.navigate().back();

		clickSubMenu(accountAndSecurityLink, accountAndSecuritySubmenuLink);
		log.info("Submenu : Account and Security Link is visible");
		driver.navigate().back();
		log.info("Back on Previous Page");

		clickSubMenu(accountAndSecurityLink, membershipSubMenuLink);
		log.info("Submenu : Membership Status Link is visible");
		driver.navigate().back();
		log.info("Back on Previous Page");

		clickSubMenu(accountAndSecurityLink, servicesYouAreUsingSubMenuLink);
		log.info("Submenu : Services you are using is visible");
		driver.navigate().back();
		log.info("Back on Previous Page");

		clickSubMenu(accountAndSecurityLink, orderHistorySubMenuLink);
		log.info("Opened Submenu");
		driver.navigate().back();
		log.info("Back on Previous Page");

	}

}
