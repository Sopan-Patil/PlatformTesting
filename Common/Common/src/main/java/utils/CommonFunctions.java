package utils;


import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
public class CommonFunctions {
	
	private static Logger log = LogManager.getLogger(CommonFunctions.class.getName());

	public static void waitandClick(By locator, int waitTime) throws Exception {
		WebElement element;

		WebDriverWait wait = new WebDriverWait(ObjectHelper.driver, waitTime);

		scrolltoElement(wait.until(ExpectedConditions.visibilityOfElementLocated(locator)));

		element = wait.until(ExpectedConditions.elementToBeClickable(locator));
		clickUsingJavaExecutor(element);

	}

	public static void waitandClear(By locator, int waitTime) throws Exception {
		WebElement element;

		WebDriverWait wait = new WebDriverWait(ObjectHelper.driver, waitTime);

		scrolltoElement(wait.until(ExpectedConditions.visibilityOfElementLocated(locator)));

		element = wait.until(ExpectedConditions.elementToBeClickable(locator));
		clearUsingJavaExecutor(element);

	}

	public static boolean waitForVisiblity(By locator, int waitTime) {
		@SuppressWarnings("unused")
		WebElement element;
		boolean result = false;
		try {
			ObjectHelper.driver.switchTo().activeElement();

			WebDriverWait wait = new WebDriverWait(ObjectHelper.driver, waitTime);

			scrolltoElement(wait.until(ExpectedConditions.visibilityOfElementLocated(locator)));

			element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
			result = true;
		} catch (Exception e) {

		}
		return result;
	}

	public static void waitandClick(WebElement element, int waitTime) throws Exception {
		ObjectHelper.driver.switchTo().activeElement();
		scrolltoElement(element);

		WebDriverWait wait = new WebDriverWait(ObjectHelper.driver, waitTime);
		element = wait.until(ExpectedConditions.elementToBeClickable(element));
		clickUsingJavaExecutor(element);
	}

	public static void waitandClear(WebElement element, int waitTime) throws Exception {
		WebDriverWait wait = new WebDriverWait(ObjectHelper.driver, waitTime);
		element = wait.until(ExpectedConditions.elementToBeClickable(element));
		clearUsingJavaExecutor(element);
	}

	public static boolean waitForVisiblity(WebElement element, int waitTime) {
		boolean result = false;
		try {
			ObjectHelper.driver.switchTo().activeElement();
			scrolltoElement(element);

			WebDriverWait wait = new WebDriverWait(ObjectHelper.driver, waitTime);
			// element = wait.until(ExpectedConditions.elementToBeClickable(element));
			element = wait.until(ExpectedConditions.visibilityOf(element));
			result = true;
		} catch (Exception e) {
			result = false;
		}
		return result;
	}
	
	public static boolean waitForVisiblity1(WebElement element, int waitTime) {
		boolean result = false;
		try {
			ObjectHelper.driver.switchTo().activeElement();
			scrolltoElement(element);

			WebDriverWait wait = new WebDriverWait(ObjectHelper.driver, waitTime);
			// element = wait.until(ExpectedConditions.elementToBeClickable(element));
			element = wait.until(ExpectedConditions.visibilityOf(element));
			result = true;
		} catch (Exception e) {
			result = false;
			throw e;
		}
		return result;
	}
	
	
	
	
	/**
	 * @Author : rahul shinde
	 * @Date : 19 Jul 2021
	 * @Description: add waitForClickable and assert
	 */
	
	public static boolean waitForClickable(WebElement element, int waitTime) {
		boolean result = false;
		try {
			ObjectHelper.driver.switchTo().activeElement();

			scrolltoElement(element);

			WebDriverWait wait = new WebDriverWait(ObjectHelper.driver, waitTime);
			element = wait.until(ExpectedConditions.elementToBeClickable(element));
			//element = wait.until(ExpectedConditions.visibilityOf(element));
			result = true;
		} catch (Exception e) {
			result = false;
		}
		return result;
	}
	
	
	public static boolean assertString(String actualText, String expectedText) {
		boolean result = false;
		try {
			log.info("Try to match text " + actualText + " with " +expectedText );
			assertTrue(actualText.equals(expectedText));			
			assertFalse(actualText == expectedText);
			assertEquals(actualText, expectedText);
			result = true;
		} catch (Exception e) {
			result = false;
		}
		return result;
	}
	
	/**
	 * @return 
	 * @Author : rahul shinde
	 * @Date : 26 Jul 2021
	 * @Description: compare 2 strings
	 */
	public static  void stringContains(String actualText, String expectedText) {
		
		try {
			if(actualText.contains(expectedText))	
			{
				log.info("string match");
			}
			else
			{
				throw  new Exception("string not match");
				
			}
		
		} catch (Exception e) {
			e.getMessage();
			
		}
		
	}


   
	public static void clickUsingJavaExecutor(String xpath) {
		WebElement element = ObjectHelper.driver.findElement(By.xpath(xpath));

		scrolltoElement(element);

		JavascriptExecutor js = (JavascriptExecutor) ObjectHelper.driver;
		js.executeScript("arguments[0].click();", element);
	}

	public static void clickUsingJavaExecutor(WebElement element) {
		scrolltoElement(element);

		JavascriptExecutor js = (JavascriptExecutor) ObjectHelper.driver;
		js.executeScript("arguments[0].click();", element);
	}

	public static void clearUsingJavaExecutor(String xpath) {
		WebElement element = ObjectHelper.driver.findElement(By.xpath(xpath));
		scrolltoElement(element);
		JavascriptExecutor js = (JavascriptExecutor) ObjectHelper.driver;
		js.executeScript("arguments[0].value=''", element);
	}

	public static void clearUsingJavaExecutor(WebElement element) throws Exception {
		scrolltoElement(element);
		JavascriptExecutor js = (JavascriptExecutor) ObjectHelper.driver;
		js.executeScript("arguments[0].value=''", element);
	}

	public static void scrolltoElement(WebElement element) {
		try {
			((JavascriptExecutor) ObjectHelper.driver).executeScript("arguments[0].scrollIntoView(false);", element);
			Thread.sleep(500);
		} catch (Exception e) {
		}
	}

	public static void main(String[] args) {
		try {
			ObjectHelper.sessionid = "ASP.NET_SessionId=lhya4minphp5g1akh0q0a1zc";

			ArrayList<String> availabledatelist = new ArrayList<>();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	public static boolean isElementClickable(WebElement webe) {

		try {
			WebDriverWait wait = new WebDriverWait(ObjectHelper.driver, 5);
			wait.until(ExpectedConditions.elementToBeClickable(webe));
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	
	public static boolean isElementVisible(WebElement webe) {

		try {
			WebDriverWait wait = new WebDriverWait(ObjectHelper.driver, 5);
			wait.until(ExpectedConditions.visibilityOf(webe));
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	public static void createFolder(String string) {
		// TODO Auto-generated method stub
		
	}
	

}
