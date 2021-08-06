package base;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;

import platform.properties.ConfigProp;
import utils.BrowserstackUtility;
import utils.ObjectHelper;
import utils.WebHandler;

/**
 * @Author : Chetan Sonparote 
 * @Date   : 24 Jun 2021 
 * @Description: Added public driver and removed static refrences
 */
/**
 * @Author : Chetan Sonparote 
 * @Date  : 25 Jun 2021 
 * @Description: Added string on openbrowser for single and cross browser test
 */

/**
 * @Author : Chetan Sonparote
 * @Date : 28 Jun 2021
 * @Description: Added setUpObjectHelper(), navigateToUrl(),
 *               createExtentReport() by breaking up openBrowser() for
 *               browserstack
 */
public class NewBaseClass {

	public WebDriver driver;
	// public static LoginPage lp;

	public static String greencolorRGB = "rgb(179, 198, 53)";
	private static Logger log = LogManager.getLogger(NewBaseClass.class.getName());

	// private static Logger log = LogManager.getLogger(Runner.class.getName());

	/*
	 * @BeforeTest
	 * 
	 * @org.testng.annotations.Parameters(value = { "mode", "browser", "config",
	 * "environment" }) public void setUpBrowser(@Optional("null") String
	 * mode, @Optional("null") String browser,
	 * 
	 * @Optional("null") String config, @Optional("null") String environment) throws
	 * Exception {
	 * 
	 * // newBaseClass = new NewBaseClass(); log.info("mode:" + mode);
	 * log.info("browser:" + browser); log.info("config:" + config);
	 * log.info("environment:" + environment);
	 * 
	 * openBrowser(mode, browser, config, environment);
	 * 
	 * closeZkaiPopup(); }
	 * 
	 * @AfterTest public void closeBrowser() throws Exception {
	 * 
	 * ObjectHelper.driver.quit();
	 * 
	 * }
	 */

	private void setUpObjectHelper() {
		String testDataFileName = ConfigProp.testDataFile;
		ObjectHelper.enviURL = ConfigProp.stageURL;

		ObjectHelper.sendreportinemail = ConfigProp.sendreportinemail;

		ObjectHelper.dburl = ConfigProp.dburl;

		String dirName = "Test At " + LocalDateTime.now().toString().replace(":", ".");
		WebHandler.setupOutputFolder(dirName);

		ObjectHelper.testtitle = ConfigProp.testtitle;
		ObjectHelper.reportfilepath = "//ExtentReport//UPP_Status_Report.html";
	}

	private void navigateToUrl() {
		ObjectHelper.driver.navigate().to(ObjectHelper.enviURL);// API

		replaceurl();

		// closeZkaiPopup();

	}

	/**
	 * @Author : rahul shinde
	 * @Date : 19 Jul 2021
	 * @Description: handle zkai popup
	 */

	// @FindBy(xpath = "//div[@class='modal-content']")
	// public WebElement zkai_popup;

	// @FindBy(xpath = "//button[@aria-label='Close']")
	// public WebElement zkai_popupCloseButton;

	/**
	 * @Author : rahul shinde
	 * @Date : 19 Jul 2021
	 * @Description: handle zkai popup
	 */

	// WebElement zkai_popup;
	// WebElement zkai_popupCloseButton;

	public void closeZkaiPopup() {
		/*
		 * if (CommonFunctions.waitForVisiblity(zkai_popup, 3)) {
		 * zkai_popupCloseButton.click(); log.info("Close Zkai pop up"); }
		 */

		// List<WebElement> zkai_popup =
		// driver.findElements(By.xpath("//div[@class='modal-content']"));
		// List<WebElement> zkai_popupCloseButton =
		// driver.findElements(By.xpath("//button[@aria-label='Close']"));

		By zkai_popup = By.xpath("//div[@class='modal-content']");

		By zkai_popupCloseButton = By.xpath("//button[@aria-label='Close']");
		// System.out.println("inside closeZkaiPopup()");
		// if (CommonFunctions.isElementVisible(zkai_popup)) {
		// zkai_popupCloseButton.click();
		// }

		// Alert alert = driver.switchTo().alert();
		// alert.dismiss();

		// if
		// (CommonFunctions.waitForClickable(ObjectHelper.driver.findElement(zkai_popupCloseButton),
		// 1)) {
		if (ObjectHelper.driver.findElement(zkai_popupCloseButton).isDisplayed()) {
			if (ObjectHelper.driver.findElements(zkai_popupCloseButton).size() > 0) {
				ObjectHelper.driver.findElement(zkai_popupCloseButton).click();
			}
		}
	}

	// public void closeZkaiPopup() {
	/*
	 * if (CommonFunctions.waitForVisiblity(zkai_popup, 3)) {
	 * zkai_popupCloseButton.click(); log.info("Close Zkai pop up"); }
	 */

	// List<WebElement> zkai_popup =
	// driver.findElements(By.xpath("//div[@class='modal-content']"));
	// List<WebElement> zkai_popupCloseButton =
	// driver.findElements(By.xpath("//button[@aria-label='Close']"));

	// By zkai_popupCloseButton = By.xpath("//button[@aria-label='Close']");
	// System.out.println("inside closeZkaiPopup()");
	// if (CommonFunctions.isElementVisible(zkai_popup)) {
	// zkai_popupCloseButton.click();
	// }

	// Alert alert = driver.switchTo().alert();
	// alert.dismiss();

	// if
	// (CommonFunctions.waitForClickable(ObjectHelper.driver.findElement(zkai_popupCloseButton),
	// 1)) {
//		if (ObjectHelper.driver.findElement(zkai_popupCloseButton).isDisplayed()) {
//			if (ObjectHelper.driver.findElements(zkai_popupCloseButton).size() > 0) {
//				ObjectHelper.driver.findElement(zkai_popupCloseButton).click();
//			}
//		}
//
//	}

	/**
	 * @Author : Chetan Sonparote
	 * @Date : 12 Jul 2021
	 * @Description: Added method runAppleScript()
	 */
	public void runAppleScript() {

		System.out.println("inside runAppleScript()");
		Runtime runtime = Runtime.getRuntime();

		// an applescript command that is multiple lines long.
		// just create a java string, and remember the newline characters.
		String applescriptCommand =

				"tell application \\\"System Events\\\"\n" + "delay 10\n" + "keystroke \\\"sgepuser\\\"\n"
						+ "keystroke tab\n" + "keystroke \\\"9tg6gxxCEaL3\\\"\n" + "delay 10\n" + "keystroke return\n"
						+ "end tell\n" +

						"end tell";

		String[] args = { "osascript", "-e", applescriptCommand };

		// ScriptEngineManager
		try {
			Process process = runtime.exec(args);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void createExtentReport() {
		WebHandler.createextentreport("Platform Testing", ObjectHelper.testtitle, ObjectHelper.enviURL);
	}

	BrowserstackUtility browserstackUtility;

	public WebDriver openBrowserstack(String config, String environment) throws Exception {
		browserstackUtility = new BrowserstackUtility();

//		log.error("inside openopenBrowserstackBrowser:");
//
//		// log.error("mode:" + mode);
//		// log.error("browser:" + browser);
//		log.error("config:" + config);
//		log.error("environment:" + environment);

		ObjectHelper.driver = browserstackUtility.initializaBrowserstackDriver(config, environment);
		// setObjectHelper();
		setUpObjectHelper();

		// WebHandler.openBrowser();

		// createExtentReport();
		navigateToUrl();
		return ObjectHelper.driver;
	}

	public WebDriver openbrowser(String browser) throws Exception {

		if (browser == null) {
			ObjectHelper.browsertype = ConfigProp.browser;
		} else {
			ObjectHelper.browsertype = browser;
		}

		setUpObjectHelper();

		WebHandler.openBrowser();

		// createExtentReport();

		navigateToUrl();

		return ObjectHelper.driver;

	}

	/**
	 * @throws Exception
	 * @Author : Chetan Sonparote
	 * @Date : 13 Jul 2021
	 * @Description: Added method openBrowser() for browserstack
	 */

	public /* WebDriver */void openBrowser(String mode, String browser, String config, String environment)
			throws Exception {

//		log.error("inside openBrowser:");
//
//		log.error("mode:" + mode);
//		log.error("browser:" + browser);
//		log.error("config:" + config);
//		log.error("environment:" + environment);
		if (mode.equalsIgnoreCase("local")) {
			ObjectHelper.driver = openbrowser(browser);
		} else if (mode.equalsIgnoreCase("browserstack")) {
			ObjectHelper.driver = openBrowserstack(config, environment);

		}

		// return ObjectHelper.driver;
	}

	public WebDriver openbrowser1(String browser) throws Exception {

		if (browser == null) {
			ObjectHelper.browsertype = ConfigProp.browser;
		} else {
			ObjectHelper.browsertype = browser;
		}

		WebHandler.openBrowser();

		// createExtentReport();

		navigateToUrl();

		return ObjectHelper.driver;

	}

	public void replaceurl() {
		System.out.println("Old" + ObjectHelper.driver.getCurrentUrl());
		String newURL = ObjectHelper.driver.getCurrentUrl().replace("https://", "https://sgepuser:9tg6gxxCEaL3@");
		System.out.println(newURL);
		ObjectHelper.driver.get(newURL);
		ObjectHelper.driver.manage().window().maximize();
	}

	/**
	 * 
	 * @Author : Sopan Patil
	 * @Date : 27 Jul 2021
	 * @Description: Added method for replacing authentication popup on chnage card
	 */

	public void replaceurlChangeCard() {
		System.out.println("Old" + ObjectHelper.driver.getCurrentUrl());
		String newURL = ObjectHelper.driver.getCurrentUrl().replaceFirst("https://", "https://sgepuser:9tg6gxxCEaL3@");
		((JavascriptExecutor) ObjectHelper.driver).executeScript("window.open()");
		ArrayList<String> tabs = new ArrayList<String>(ObjectHelper.driver.getWindowHandles());
		ObjectHelper.driver.switchTo().window(tabs.get(0));
		ObjectHelper.driver.close();
		ObjectHelper.driver.switchTo().window(tabs.get(1));
		System.out.println(newURL);
		ObjectHelper.driver.get(newURL);

	}

	public void closebrowser() {
		WebHandler.closebrowser();

	}

	/**
	 * @Author : Chetan Sonparote
	 * @Date : 7 Jul 2021
	 * @Description: Added close browser method for browserstack
	 */
	/*
	 * public void checkBrowserOpen() {
	 * 
	 * 
	 * boolean open = false;
	 * 
	 * if (ObjectHelper.driver.getTitle() != null) { open = true; } else if
	 * (ObjectHelper.driver.getTitle().isEmpty()) { open = false; }
	 * 
	 * return open;
	 * 
	 * try { ObjectHelper.driver.getTitle();
	 * log.info("Browser Window is still exist"); } catch (Exception e) {
	 * log.error("Brower window is closed"); } }
	 */

	/**
	 * @Author : Chetan Sonparote
	 * @Date : 7 Jul 2021
	 * @Description: Added close browser method for browserstack
	 */
	public void closeBrowserstack() {
		try {
			browserstackUtility = new BrowserstackUtility();
			browserstackUtility.tearDown();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void setTestResult(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
			ObjectHelper.test.fail(result.getTestName());
			ObjectHelper.test.fail(result.getThrowable());
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			ObjectHelper.test.pass(result.getTestName());
		} else if (result.getStatus() == ITestResult.SKIP) {
			ObjectHelper.test.skip("Test Case :" + result.getTestName() + "has been skipped");
		}
	}

	public void navigatetoURL(String url) {
		ObjectHelper.driver.navigate().to(url);
	}

	public String GetUrl() {
		String url = ObjectHelper.driver.getCurrentUrl();
		return url;
	}

	public void refreshbrowser() {
		// TODO Auto-generated method stub
		WebHandler.refreshbrowser();
	}

}
