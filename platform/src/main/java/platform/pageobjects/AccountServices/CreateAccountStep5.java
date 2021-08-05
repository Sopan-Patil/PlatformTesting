package platform.pageobjects.AccountServices;

import java.io.IOException;
import java.util.ArrayList;
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
 * @Author : Chetan Sonparote
 * @Date : 21 Jul 2021
 * @Description:Class for confirming details on step 5
 */

public class CreateAccountStep5 {

	List<String[]> testdata;
	public WebDriver driver;
	private static Logger log = LogManager.getLogger(LoginPage.class.getName());
	int waitTime = 5;

	public CreateAccountStep5(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@class='button button--default button--uplarge button--complete']")
	public WebElement startServiceButton;

	@FindBy(xpath = "//div[@class='link-step-5']")
	public WebElement gotoTopLink;

	public void clickStartServiceButton() {

		if (CommonFunctions.waitForVisiblity(startServiceButton, waitTime)) {

			startServiceButton.click();
		}

	}

	public void clickGotoTopLink() {

		if (CommonFunctions.waitForVisiblity(gotoTopLink, waitTime)) {

			gotoTopLink.click();
		}

	}

	/**
	 * @Author : Chetan Sonparote
	 * @Date : 29 Jul 2021
	 * @Description:Method to get new account details
	 */
	public void getCreatedAccountDetails() {

		log.info("Created email:" + CreateAccountStep1.email);
		log.info("Created eid:" + CreateAccountStep1.eid);
		log.info("Created password:" + CreateAccountStep3.password);

	}

	/**
	 * @throws IOException
	 * @Author : Chetan Sonparote
	 * @Date :5 Aug 2021
	 * @Description:Method to write new account details in excel
	 */
	public void writeCredentialsToExcel() throws IOException {

		ArrayList<String> newLoginData = new ArrayList<>();

		newLoginData.add(0, CreateAccountStep1.email);
		newLoginData.add(1, CreateAccountStep3.password);
		newLoginData.add(2, CreateAccountStep1.eid);
		// = { CreateAccountStep1.email, CreateAccountStep3.password,
		// CreateAccountStep1.eid };
		// XLHandler.writeToExcel("NewUser", "NewTestData.xlsx", 0,
		// CreateAccountStep1.email);
		// XLHandler.writeToExcel("NewUser", "NewTestData.xlsx", 1,
		// CreateAccountStep3.password);
		// XLHandler.writeToExcel("NewUser", "NewTestData.xlsx", 2,
		// CreateAccountStep1.eid);

		XLHandler.writeToExcel("NewUser", "NewTestData.xlsx", newLoginData);
	}

}
