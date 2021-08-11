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
	public WebElement membershipStatusLink;

	@FindBy(xpath = "//p[@class='ep-box-member__title']")
	public WebElement memberTitle;

//	@FindBy(xpath = "//p[@class='ep-box-member__title']")
//	public WebElement freeMemberTitle;

	@FindBy(xpath = "//a[@class='button button--blue1 button--xsmall font-weight-normal']/span")
	public WebElement freeMemberTitle;

//	@FindBy(xpath = "//p[@class='ep-box-member__title']")
//	public WebElement primeMemberTitle;

	@FindBy(xpath = "//a[@class='button button--blue1 button--xsmall font-weight-normal']/span")
	public WebElement primeMemberTitle;

	@FindBy(xpath = "//div[@class='ep-box-member__cancel']/a/span")
	public WebElement endMembershipButton;

	@FindBy(xpath = "//button[@class='button button--default button--uplarge ep-order__btn ep-order__btn--back']")
	public WebElement suspendQualificationButton;

	@FindBy(xpath = "//p[@class='ep-box-member__title']")
	public WebElement freeMembershipPlanTitle;

	@FindBy(xpath = "//div[@class='balloon__content']/span")
	public WebElement freeMembershipPlanButton;

	@FindBy(xpath = "//div[@class='link-learn__content']")
	public WebElement freeMembershipPlanDetails;

	@FindBy(xpath = "//p[@class='ep-box-member__title']")
	public WebElement primeMembershipPlanTitle;

	@FindBy(xpath = "//div[@class='ep-box-member__info']/div")
	public WebElement primeMembershipPlanPaymentDetails;

	@FindBy(xpath = "//div[@class='ep-box-member__info']/div[2]")
	public WebElement primeMembershipPlanPaymentMethod;

	@FindBy(xpath = "//a[contains(@class,'button button--default button--xmedium')]")
	public WebElement primeMemberChangeCardButton;

	public void clickAccountInformation() {
		if (CommonFunctions.waitForVisiblity(accountInformation, waitTime)) {
			accountInformation.click();
		}
	}

	public void MemberShipStatus() throws Exception {
		clickAccountInformation();
		if (CommonFunctions.waitForVisiblity(membershipStatusLink, waitTime)) {
			membershipStatusLink.click();
			shipmentdata = XLHandler.readexcel("MembershipStatus", "NewTestData.xlsx");
			freeuser = shipmentdata[0].toString();
			primeuser = shipmentdata[1].toString();
			if (memberTitle.isDisplayed()) {
				if (freeMemberTitle.getText().contentEquals(freeuser)) {
					log.info("free user is now in membership status page");
				} else if (primeMemberTitle.getText().contentEquals(primeuser)) {
					log.info("prime user is now in membership status page");
				}
			}
		}
	}

	public void CancellingPrimeMembership() throws Exception {
		shipmentdata = XLHandler.readexcel("MembershipStatus", "NewTestData.xlsx");
		freeuser = shipmentdata[0].toString();
		primeuser = shipmentdata[1].toString();
		clickAccountInformation();
		if (CommonFunctions.waitForVisiblity(membershipStatusLink, waitTime)) {
			membershipStatusLink.click();
			if (primeMemberTitle.isDisplayed() && (primeMemberTitle.getText().contentEquals(primeuser))) {
				clickEndMemberShipButton();
				clickSuspendQualificationButton();
				log.info("prime user is now cancelling Prime membership");
				clickAccountInformation();
				membershipStatusLink.click();
				if (freeMemberTitle.isDisplayed() && (freeMemberTitle.getText().contentEquals(freeuser))) {
					log.info("user is now free member");
				}
			} else {
				log.info("user is not Prime member");

			}
		}
	}

	public void CheckFreeAndPrimeMembershipPlanDetails() throws Exception {
		shipmentdata = XLHandler.readexcel("MembershipStatus", "NewTestData.xlsx");
		freeuser = shipmentdata[0].toString();
		primeuser = shipmentdata[1].toString();
		clickAccountInformation();
		if (CommonFunctions.waitForVisiblity(membershipStatusLink, waitTime)) {
			membershipStatusLink.click();
			if (freeMembershipPlanTitle.isDisplayed()
					&& (freeMembershipPlanDetails.isDisplayed() && (freeMembershipPlanButton.isDisplayed()))) {

				log.info("Logged user is Free User");

			} else if (primeMembershipPlanTitle.isDisplayed() && (primeMembershipPlanPaymentDetails.isDisplayed()
					&& (primeMembershipPlanPaymentMethod.isDisplayed() && primeMemberChangeCardButton.isDisplayed()))) {
				log.info("user is not Prime member");

			}
		}
	}

	public void clickEndMemberShipButton() {
		CommonFunctions.scrolltoElement(endMembershipButton);
		if (CommonFunctions.waitForVisiblity(endMembershipButton, waitTime)) {
			endMembershipButton.click();
		}

	}

	public void clickSuspendQualificationButton() {
		CommonFunctions.scrolltoElement(suspendQualificationButton);
		if (CommonFunctions.waitForVisiblity(suspendQualificationButton, waitTime)) {
			suspendQualificationButton.click();
		}

	}

}
