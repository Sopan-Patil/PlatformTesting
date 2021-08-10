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
import utils.XLHandler;

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
	String freeuser, primeuser;

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

	public void clickMemberShipStatus() throws Exception {
		if (CommonFunctions.waitForVisiblity(membershipStatus, waitTime)) {
			shipmentdata = XLHandler.readexcel("MembershipStatus", "NewTestData.xlsx");
			membershipStatus.click();
			if (freeMemberTitle.isDisplayed()) {
				freeuser = shipmentdata[0].toString();
				primeuser = shipmentdata[1].toString();
				if (freeMemberTitle.getText().contentEquals(freeuser)) {
					log.info("free user is now in membership status page");
				} else if (primeMemberTitle.getText().contentEquals(primeuser)) {
					log.info("prime user is now in membership status page");
				}

			}

		}
	}

}
