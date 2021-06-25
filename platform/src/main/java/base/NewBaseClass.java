package base;

import java.time.LocalDateTime;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;

import platform.properties.ConfigProp;
import utils.ObjectHelper;
import utils.WebHandler;

/**
 * Author : Chetan Sonparote Date of Modification : 24 Jun 2021 Description:
 * Added public driver and removed static refrences
 */
/**
 * Author : Chetan Sonparote Date of Modification : 25 Jun 2021 Description:
 * Added string on openbrowser for single and cross browser test
 */
public class NewBaseClass {

	public WebDriver driver;
	// public static LoginPage lp;

	public static String greencolorRGB = "rgb(179, 198, 53)";

	public /* void */ WebDriver openbrowser(/* String browser */) throws Exception {

		String testDataFileName = ConfigProp.testDataFile;
		ObjectHelper.enviURL = ConfigProp.platformenvironmentURL;

		ObjectHelper.sendreportinemail = ConfigProp.sendreportinemail;

		/*
		 * if (browser == null) { ObjectHelper.browsertype = ConfigProp.browser; } else
		 * { ObjectHelper.browsertype = browser;// ConfigProp.browser; }
		 */
		ObjectHelper.browsertype = ConfigProp.browser;

		ObjectHelper.dburl = ConfigProp.dburl;

		String dirName = "Test At " + LocalDateTime.now().toString().replace(":", ".");
		WebHandler.setupOutputFolder(dirName);

		ObjectHelper.testtitle = ConfigProp.testtitle;
		ObjectHelper.reportfilepath = "//ExtentReport//UPP_Status_Report.html";

		WebHandler.openBrowser();
		WebHandler.createextentreport("Platform Testing", ObjectHelper.testtitle, ObjectHelper.enviURL);

		ObjectHelper.driver.navigate().to(ObjectHelper.enviURL);// API
		replaceurl();

		// lp = new LoginPage(ObjectHelper.driver);
		return ObjectHelper.driver;

	}

	public void replaceurl() {
		System.out.println("Old" + ObjectHelper.driver.getCurrentUrl());
		String newURL = ObjectHelper.driver.getCurrentUrl().replace("https://", "https://sgepuser:9tg6gxxCEaL3@");
		System.out.println(newURL);
		ObjectHelper.driver.get(newURL);
		// ObjectHelper.driver.manage().window().maximize();
	}

	public void closebrowser() {
		WebHandler.closebrowser();
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
