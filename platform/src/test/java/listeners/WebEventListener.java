package listeners;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

import base.NewBaseClass;

/**
 * @Author : Chetan Sonparote
 * @Date : 5 Jul 2021
 * @Description: Added WebEventListener from browserstack poc. Customization
 *               pending
 */

public class WebEventListener extends NewBaseClass implements WebDriverEventListener {

	public static Logger welog = LogManager.getLogger(WebEventListener.class.getName());

	@Override
	public void beforeNavigateTo(String url, WebDriver driver) {
		System.out.println("Before navigating to: '" + url + "'");
		welog.info("Before navigating to: '" + url + "'");
	}

	@Override
	public void afterNavigateTo(String url, WebDriver driver) {
		System.out.println("Navigated to:'" + url + "'");
		welog.info("Navigated to:'" + url + "'");
	}

	public void beforeChangeValueOf(WebElement element, WebDriver driver) {
		System.out.println("Value of the:" + element.toString() + " before any changes made");
		welog.info("Value of the:" + element.toString() + " before any changes made");
	}

	public void afterChangeValueOf(WebElement element, WebDriver driver) {
		System.out.println("Element value changed to: " + element.toString());
		welog.info("Element value changed to: " + element.toString());
	}

	@Override
	public void beforeClickOn(WebElement element, WebDriver driver) {
		System.out.println("Trying to click on: " + element.toString());
		welog.info("Trying to click on: " + element.toString());
	}

	@Override
	public void afterClickOn(WebElement element, WebDriver driver) {
		System.out.println("Clicked on: " + element.toString());
		welog.info("Clicked on: " + element.toString());
	}

	@Override
	public void beforeNavigateBack(WebDriver driver) {
		System.out.println("Navigating back to previous page");
		welog.info("Navigating back to previous page");
	}

	@Override
	public void afterNavigateBack(WebDriver driver) {
		System.out.println("Navigated back to previous page");
		welog.info("Navigated back to previous page");
	}

	@Override
	public void beforeNavigateForward(WebDriver driver) {
		System.out.println("Navigating forward to next page");
		welog.info("Navigating forward to next page");
	}

	@Override
	public void afterNavigateForward(WebDriver driver) {
		System.out.println("Navigated forward to next page");
		welog.info("Navigated forward to next page");
	}

	@Override
	public void onException(Throwable error, WebDriver driver) {
		System.out.println("Exception occured: " + error);
		welog.info("Exception occured: " + error);
		/*
		 * JavascriptExecutor jse = (JavascriptExecutor) driver;
		 * jse.executeScript("arguments[0].style.border='3px solid red'", element);
		 */
		/*
		 * try { File scrFile = ((TakesScreenshot)
		 * driver).getScreenshotAs(OutputType.FILE); FileUtils.copyFile(scrFile, new
		 * File((System.getProperty("user.dir") +
		 * prjprop.getProperty("SCREEN_SHOT_PATH")) + System.currentTimeMillis() +
		 * ".png")); System.out.println("Screenshot captured at location: " +
		 * System.getProperty("user.dir") + prjprop.getProperty("SCREEN_SHOT_PATH"));
		 * welog.info("Screenshot captured at location: " +
		 * System.getProperty("user.dir") + prjprop.getProperty("SCREEN_SHOT_PATH")); }
		 * catch (IOException e) { e.printStackTrace(); }
		 */
	}

	@Override
	public void beforeFindBy(By by, WebElement element, WebDriver driver) {
		System.out.println("Trying to find Element By : " + by.toString());
		welog.info("Trying to find Element By : " + by.toString());
	}

	@Override
	public void afterFindBy(By by, WebElement element, WebDriver driver) {
		System.out.println("Found Element By : " + by.toString());
		welog.info("Found Element By : " + by.toString());
	}

	/*
	 * non overridden methods of WebListener class
	 */
	@Override
	public void beforeScript(String script, WebDriver driver) {
	}

	@Override
	public void afterScript(String script, WebDriver driver) {
	}

	@Override
	public void beforeAlertAccept(WebDriver driver) {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterAlertAccept(WebDriver driver) {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterAlertDismiss(WebDriver driver) {
		// TODO Auto-generated method stub

	}

	@Override
	public void beforeAlertDismiss(WebDriver driver) {
		// TODO Auto-generated method stub

	}

	@Override
	public void beforeNavigateRefresh(WebDriver driver) {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterNavigateRefresh(WebDriver driver) {
		// TODO Auto-generated method stub

	}

	@Override
	public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
		// TODO Auto-generated method stub

	}

	@Override
	public void beforeSwitchToWindow(String windowName, WebDriver driver) {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterSwitchToWindow(String windowName, WebDriver driver) {
		// TODO Auto-generated method stub

	}

	/*
	 * @Override public <X> void beforeGetScreenshotAs(OutputType<X> target) { //
	 * TODO Auto-generated method stub
	 * 
	 * }
	 * 
	 * @Override public <X> void afterGetScreenshotAs(OutputType<X> target, X
	 * screenshot) { // TODO Auto-generated method stub
	 * 
	 * }
	 * 
	 * @Override public void beforeGetText(WebElement element, WebDriver driver) {
	 * // TODO Auto-generated method stub
	 * 
	 * }
	 * 
	 * @Override public void afterGetText(WebElement element, WebDriver driver,
	 * String text) { // TODO Auto-generated method stub
	 * 
	 * }
	 */

}
