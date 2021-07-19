package platform.pageobjects.AccountServices;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import platform.pageobjects.Authentication.LoginPage;
import utils.CommonFunctions;
import utils.OTPNumberReader;

/**
 * @Author : Chetan Sonparote
 * @Date : 19 Jul 2021
 * @Description:Class for entering confirmation code
 */
public class CreateAccountStep2 {

	List<String[]> testdata;
	public WebDriver driver;
	private static Logger log = LogManager.getLogger(LoginPage.class.getName());
	int waitTime = 5;

	public CreateAccountStep2(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// input[@id='code1']

	// input[@id='code2']
	// input[@id='code3']
	// input[@id='code4']
	// input[@id='code5']
	// input[@id='code6']

	// font[contains(text(),'next')]
	// a[@role='button']
	@FindBy(xpath = "//*[contains(text(),'next') or @role='button']")
	public WebElement nextButton;

	public void clickNextButton() {

		// System.out.println("inside clickLoginButton()");
		if (CommonFunctions.waitForVisiblity(nextButton, waitTime)) {

			nextButton.click(); // changes done
		}

	}

	int codeDigit;
	List<Integer> OTPNumber;

	public void convertOTPToList() {
		String otp = OTPNumberReader.getOTPNumberValue();
		OTPNumber = new ArrayList<Integer>();
		Scanner scanner = new Scanner(otp);

		while (scanner.hasNextInt()) {
			OTPNumber.add(scanner.nextInt());
		}

	}

	public void addConfirmationCode() {
		convertOTPToList();
		WebElement codeField;

		for (int i = 0; i < OTPNumber.size(); i++) {

			codeDigit = i + 1;
			codeField = findLocatorForCodeDigit(codeDigit);
			codeField.click();
			codeField.sendKeys(OTPNumber.get(i).toString());

		}
	}

	public WebElement findLocatorForCodeDigit(int digit) {

		return driver.findElement(By.xpath("//input[@id='code" + digit + "']"));
	}

}
