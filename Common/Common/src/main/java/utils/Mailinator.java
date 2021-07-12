package utils;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @Author : Sopan Patil
 * @Date : 01 Jul 2021
 * @Description: Added Login function
 */

public class Mailinator {
	List<String[]> testdata;
	public WebDriver driver;
	private static Logger log = LogManager.getLogger(Mailinator.class.getName());
	int waitTime = 1;

	public Mailinator(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@id='addOverlay']")
	public WebElement EmailTextField;

	@FindBy(xpath = "//button[normalize-space()='GO']")
	public WebElement GoButton;

	@FindBy(xpath = "//td[normalize-space()='do-not-reply@stg.evidus.net']")
	public WebElement EmailBodyOpen;

	@FindBy(xpath = "//*[contains(@title, 'HTML Email Message Body')]")
	public WebElement EmailBodyRead;

	public void loginToMailinator() throws Exception {
		String[] shipmentdata;

		shipmentdata = XLHandler.readexcel("User", "NewTestData.xlsx");

		System.out.println(shipmentdata[0]);

		String emailBox = "https://www.mailinator.com/v4/public/inboxes.jsp?to=sopan";

		driver.navigate().to(emailBox);

		if (CommonFunctions.waitForVisiblity(EmailBodyOpen, waitTime)) {
			EmailBodyOpen.click();
		}

		System.out.println(EmailBodyRead.isDisplayed());
		System.out.println(EmailBodyRead.isEnabled());
		System.out.println(EmailBodyRead.getText());
		System.out.println(EmailBodyRead.getTagName());
		System.out.println(EmailBodyRead.equals(EmailBodyRead));
		System.out.println(EmailBodyRead.getAttribute(emailBox));
		System.out.println(EmailBodyRead.getCssValue(emailBox));
		System.out.println(EmailBodyRead.getSize());
		Rectangle iframe = EmailBodyRead.getRect();

		System.out.println(iframe);
		// System.out.println(EmailBodyOpen.findElements(By.xpath("//*[@id=\"html_msg_body\"]")));
		// EmailBodyRead =
		// EmailBodyOpen.findElement(By.xpath("//*[@id=\"html_msg_body\"]"));
		// System.out.println(EmailBodyRead.getText());

	}

}