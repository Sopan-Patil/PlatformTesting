package utils;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @Author : Sopan Patil
 * @Date : 12 Jul 2021
 * @Description: Added Login function
 */

public class TestMail {
	List<String[]> testdata;
	public WebDriver driver;
	private static Logger log = LogManager.getLogger(TestMail.class.getName());
	int waitTime = 1;

	public TestMail(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@class='title']")
	public WebElement GoButton;

	// @FindBy(xpath = "//font[contains(text(),'Please enter the code below.')]")
	// *[@id="fullmessage"]

	@FindBy(xpath = "//*[@id=\"fullmessage\"]")
	public WebElement EmailBodyRead;

	public void OTPReadYOPMail() throws Exception {
		String[] shipmentdata;

		shipmentdata = XLHandler.readexcel("User", "NewTestData.xlsx");

		System.out.println(shipmentdata[0]);

//		List<WebElement> list = driver.findElements(By.xpath("//div[@class='wmright']"));
//		java.util.Iterator<WebElement> iterator = list.iterator();
//
//		List<String> values = new ArrayList<String>();
//		while (iterator.hasNext()) {
//			WebElement element = iterator.next();
//			values.add(element.getText());
//		}
		GoButton.click();
		ObjectHelper.driver.switchTo().frame("fullmessage");

		String iframe = ObjectHelper.driver.getPageSource();
		System.out.println("iframe>>>>>" + iframe);

		List<WebElement> allElements = driver.findElements(By.xpath("//*[@id=\"fullmessage\"]"));

		for (WebElement element : allElements) {
			System.out.println(element.getText());
		}
		String myText = driver.findElement(By.xpath("//*[@id=\"webmail\"]")).getText();
		System.out.println("Total Log Count :  " + myText);

		System.out.println(EmailBodyRead.getText());
		System.out.println(EmailBodyRead.getTagName());
		System.out.println(EmailBodyRead.equals(EmailBodyRead));
		System.out.println(EmailBodyRead.getSize());

	}

}