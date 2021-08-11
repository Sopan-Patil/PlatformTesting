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

	@FindBy(xpath = "//a[@class='button button--default button--register-step-2 js-submit']")
	public WebElement nextButton;

	public void clickNextButton() {

		if (CommonFunctions.waitForVisiblity(nextButton, waitTime)) {

			nextButton.click();
		}

	}

	int codeDigit;
	List<Integer> OTPNumber;

	public void convertOTPToList() {

		OTPNumberReader OTPNumberReader = new OTPNumberReader();
		@SuppressWarnings("static-access")
		String otp = OTPNumberReader.OTPNumberValue();
		// System.out.println("otp:" + otp);
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
