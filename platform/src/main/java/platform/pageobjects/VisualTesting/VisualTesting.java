package platform.pageobjects.VisualTesting;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.percy.selenium.Percy;

public class VisualTesting {
	private static WebDriver driver;
	private static Percy percy;

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.setHeadless(true);
		driver = new ChromeDriver(options);
		percy = new Percy(driver);

		driver.get("https://example.com");
		percy.snapshot("Java example");
	}

}
