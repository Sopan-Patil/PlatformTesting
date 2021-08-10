package platform.pageobjects.MyPage;

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
 * @Author : Sopan Patil
 * @Date : 09 Aug 2021
 * @Description:Class for
 */
public class MembershipStatus {
	List<String[]> testdata;
	public WebDriver driver;
	private static Logger log = LogManager.getLogger(LoginPage.class.getName());
	int waitTime = 5;
	String[] shipmentdata;

	public MembershipStatus(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@class='link js-not-link']")
	public WebElement accountInformation;

	@FindBy(xpath = "//div[@class='ep-my-page__side-bar']/a[2]")
	public WebElement membershipStatus;

	@FindBy(xpath = "//p[@class='ep-box-member__title']")
	public WebElement freeMemberTitle;

	@FindBy(xpath = "//p[@class='ep-box-member__title']")
	public WebElement primeMemberTitle;

	public void clickAccountInformation() {
		if (CommonFunctions.waitForVisiblity(accountInformation, waitTime)) {
			accountInformation.click();
		}
	}

	public void clickMemberShipStatus() {
		if (CommonFunctions.waitForVisiblity(membershipStatus, waitTime)) {
			membershipStatus.click();
			if (freeMemberTitle.isDisplayed()) {
				log.info("free user now in membership staus page");
			} else if (primeMemberTitle.isDisplayed()) {
				log.info("prime user now in membership staus page");
			}

		}
	}

}
