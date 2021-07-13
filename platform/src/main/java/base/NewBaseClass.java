package base;

import java.io.IOException;
import java.time.LocalDateTime;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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

		// check safari and run applescript

		// else

		/*
		 * if (BrowserstackUtility.browserName.equalsIgnoreCase("safari")) {
		 * 
		 * runAppleScript(); } else { replaceurl(); }
		 */
		replaceurl();
	}

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

		ObjectHelper.driver = browserstackUtility.initializaBrowserstackDriver(config, environment);
		// setObjectHelper();
		setUpObjectHelper();

		// WebHandler.openBrowser();

		createExtentReport();
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

	public WebDriver openBrowser(String mode, String browser, String config, String environment) throws Exception {

		if (mode.equalsIgnoreCase("local")) {
			ObjectHelper.driver = openbrowser(browser);
		} else if (mode.equalsIgnoreCase("browserstack")) {
			ObjectHelper.driver = openBrowserstack(config, environment);

		}

		return ObjectHelper.driver;
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

	public void replaceurlMailinator() {
		System.out.println("Old" + ObjectHelper.driver.getCurrentUrl());
		String newURL = ObjectHelper.driver.getCurrentUrl().replace("https://", "https://sgepuser:9tg6gxxCEaL3@");
		System.out.println(newURL);
		ObjectHelper.driver.get(newURL);
		ObjectHelper.driver.manage().window().maximize();
	}

	public void closebrowser() {
		WebHandler.closebrowser();

	}

	/**
	 * @Author : Chetan Sonparote
	 * @Date : 7 Jul 2021
	 * @Description: Added close browser method for browserstack
	 */
	public void checkBrowserOpen() {

		/*
		 * boolean open = false;
		 * 
		 * if (ObjectHelper.driver.getTitle() != null) { open = true; } else if
		 * (ObjectHelper.driver.getTitle().isEmpty()) { open = false; }
		 * 
		 * return open;
		 */
		try {
			ObjectHelper.driver.getTitle();
			log.info("Browser Window is still exist");
		} catch (Exception e) {
			log.error("Brower window is closed");
		}
	}

	/**
	 * @Author : Chetan Sonparote
	 * @Date : 7 Jul 2021
	 * @Description: Added close browser method for browserstack
	 */
	public void closeBrowserstack() {
		try {
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
