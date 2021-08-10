package platformstepdefinition;

import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import base.NewBaseClass;
import cucumber.api.java.en.Then;
import cucumber.api.junit.Cucumber;
import platform.pageobjects.MyPage.MembershipStatus;
import utils.ObjectHelper;

/**
 * @Author : Sopan patil
 * @Date : 09 Aug 2021
 * @Description: step def for membership status
 */
@RunWith(Cucumber.class)
public class PF_MembershipStatus extends NewBaseClass {

	public WebDriver driver = ObjectHelper.driver;

	@Then("^Click on Membership Status$")
	public void Click_on_Membership_Status() throws Throwable {
		MembershipStatus MemberShipStatus = new MembershipStatus(driver);
		MemberShipStatus.MemberShipStatus();

	}

	@Then("^Click on End Membership$")
	public void Click_on_End_Membership() throws Throwable {
		MembershipStatus EndButton = new MembershipStatus(driver);
		EndButton.EndMembershipStatus();

	}

}
