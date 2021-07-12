package platform.pageobjects.Authentication;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonFunctions;
import utils.EmailAddressAndEIDGenerate;

/**
 * @Author : Sopan Patil
 * @Date : 12 Jul 2021
 * @Description: Added SignIn function
 */

public class SignIn {
	List<String[]> testdata;
	public WebDriver driver;
	private static Logger log = LogManager.getLogger(SignIn.class.getName());
	int waitTime = 1;

	public SignIn(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@class='link link--smaller']")
	public WebElement SignInLink;

	@FindBy(xpath = "//input[@id='email']")
	public WebElement Emailtextfield;

	@FindBy(xpath = "//input[@id='entryIdentifier']")
	public WebElement EIDtextfield;

	@FindBy(xpath = "//button[@type='submit']")
	public WebElement SubmitButton;

	public void SignInToPlatform(String emailaddress, String eid) throws Exception {

		if (CommonFunctions.waitForVisiblity(SignInLink, waitTime)) {
			SignInLink.click();
		}

		if (CommonFunctions.waitForVisiblity(Emailtextfield, waitTime)) {
			Emailtextfield.click();
			EmailAddressAndEIDGenerate EmailAddressAndEIDGenerate = new EmailAddressAndEIDGenerate();
			EmailAddressAndEIDGenerate.generateemailaddress(emailaddress);
		}
		if (CommonFunctions.waitForVisiblity(EIDtextfield, waitTime)) {
			EIDtextfield.click();
			EmailAddressAndEIDGenerate EmailAddressAndEIDGenerate = new EmailAddressAndEIDGenerate();
			EmailAddressAndEIDGenerate.generateeid(eid);
		}
		if (CommonFunctions.waitForVisiblity(SubmitButton, waitTime)) {
			CommonFunctions.clickUsingJavaExecutor(SubmitButton);
		}

	}

}