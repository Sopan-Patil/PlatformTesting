package platform.pageobjects.VisualTesting;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.percy.selenium.Percy;

public class VisualTesting {
	private static WebDriver driver;
	private static Percy percy;

	public static void main(String[] args) {
		VisualTesting visualTesting = new VisualTesting();
		visualTesting.testVisualData();
	}

	@Test
	public void testVisualData() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.setHeadless(true);
		driver = new ChromeDriver(options);
		percy = new Percy(driver);

		driver.get("https://a1.marugotoweb.jp/en/");
		percy.snapshot("Java example");
	}

}
