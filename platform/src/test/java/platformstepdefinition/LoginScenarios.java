package platformstepdefinition;

import org.apache.xerces.util.URI.MalformedURIException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import testlink.api.java.client.TestLinkAPIResults;
import utils.ExcelUtil;

public class LoginScenarios {
	public static WebDriver driver;
	public static String URL = "https://stg.studygear.evidus.net";

	@Before
	public void openbrowser() throws MalformedURIException {
		System.setProperty("webdriver.chrome.driver",
				"D:/Sopan/Project/Automation/PlatformTesting/platform/Drivers/chromedriver91.exe");
		WebDriver driver = new ChromeDriver();
		driver.get(URL);
		System.out.println("Selenium Webdriver Script in Chrome browser | Software Testing Material");

	}

	@Test
	public void TestJenkinsTestLink() throws Exception {

		try {
			driver.get(URL);
			ExcelUtil excel = new ExcelUtil();
			excel.setExcelFile("NewTestData.xlsx", "User");

			String userNameSTR = excel.getCellData("UserName", 1);
			String passwordSTR = excel.getCellData("Password", 1);
			driver.findElement(By.xpath("//a[@class='button button--white3 button--medium button--header']")).click();
			driver.findElement(By.xpath("//input[@id='email']")).sendKeys(userNameSTR);
			driver.findElement(By.xpath("//input[@id='password']")).sendKeys("asasas");
			driver.findElement(By.xpath("//button[@type='submit']")).click();
			System.out.println("Test Case Passed Updating Status in TestLink");
			TestLinkIntegration.updateTestLinkResults("User Logged", null, TestLinkAPIResults.TEST_PASSED);
		} catch (Exception e) {

			System.out.println("Test Case Failed Updating Status in TestLink");
			TestLinkIntegration.updateTestLinkResults("User Logged", null, TestLinkAPIResults.TEST_FAILED);
		}
	}

	@After
	public void closebrowser() {
		driver.quit();
	}
}
