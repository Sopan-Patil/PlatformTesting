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
 * @Description: Added Signup function
 */

public class SignUp {
	List<String[]> testdata;
	public WebDriver driver;
	private static Logger log = LogManager.getLogger(SignUp.class.getName());
	int waitTime = 1;

	public SignUp(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@class='link link--smaller']")
	public WebElement SignUpLink;

	@FindBy(xpath = "//input[@id='email']")
	public WebElement Emailtextfield;

	@FindBy(xpath = "//input[@id='entryIdentifier']")
	public WebElement EIDtextfield;

	@FindBy(xpath = "//button[@type='submit']")
	public WebElement SubmitButton;

	public void SignUpToPlatform(String emailaddress, String eid) throws Exception {

		if (CommonFunctions.waitForVisiblity(SignUpLink, waitTime)) {
			SignUpLink.click();
		}

		/**
		 * @Author : Chetan Sonparote
		 * @Date : 14 Jul 2021
		 * @Description: commented methods for test
		 */
		if (CommonFunctions.waitForVisiblity(Emailtextfield, waitTime)) {
			Emailtextfield.click();
			EmailAddressAndEIDGenerate EmailAddressAndEIDGenerate = new EmailAddressAndEIDGenerate();
			// EmailAddressAndEIDGenerate.generateemailaddress(emailaddress);
		}
		if (CommonFunctions.waitForVisiblity(EIDtextfield, waitTime)) {
			EIDtextfield.click();
			EmailAddressAndEIDGenerate EmailAddressAndEIDGenerate = new EmailAddressAndEIDGenerate();
			// EmailAddressAndEIDGenerate.generateeid(eid);
		}
		if (CommonFunctions.waitForVisiblity(SubmitButton, waitTime)) {
			CommonFunctions.clickUsingJavaExecutor(SubmitButton);
		}

	}

}