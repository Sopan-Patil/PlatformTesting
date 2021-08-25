package base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;


public class TestBase {
	
	public WebDriver driver;
	
	public static String url = "https://stg.studygear.evidus.net";
	
	@BeforeTest
	public void openBrowser() {

		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();

		driver.manage().deleteAllCookies();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	//	driver.manage().window().maximize();
		
		String url1 = url.replace("https://", "https://sgepuser:9tg6gxxCEaL3@");
		driver.get(url1);	

	}
	
	@AfterTest
	public void closeBrowser() {

		driver.quit();
	}
	
	
	public String getOSBrowserDetails() {
		Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
		String BrowserName = cap.getBrowserName().toLowerCase();
		String os = System.getProperty("os.name").toLowerCase();
		String BrowserVersion = cap.getVersion().toString();
		System.out.println("OS = " + os + ", Browser = " + BrowserName + ", BrowserVersion=" + BrowserVersion + "");
		String OSBrowserDetails = "Test Execution Successfully Passed in OS = " + os + ", Browser = " + BrowserName
				+ ", BrowserVersion=" + BrowserVersion + "";
		return OSBrowserDetails;

	}

}
