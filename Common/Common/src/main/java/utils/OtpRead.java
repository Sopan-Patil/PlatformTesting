package utils;

import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.gargoylesoftware.htmlunit.javascript.host.file.FileReader;


public class OtpRead {

	public static WebDriverWait main(String[] args) {
	
	    WebDriver driver;
	    String urlMailinator = "https://www.mailinator.com/"; 
	    WebDriverWait waitSec(WebDriver  int sec) {return new WebDriverWait(driver1, sec);}
	    String doubleOptInLink = null;
	    String getDoubleOptInLink() {return doubleOptInLink;}
	    public static void setDoubleOptInLink (String doubleOptInLink) {Mailinator.doubleOptInLink = doubleOptInLink;} 

	    public static void collectDoubleOptInLink(String userEmail, int expectedNumberOfDeliveredEmails) throws InterruptedException {
	        driver.get(urlMailinator);                  
	        WebElement fldInbox = waitSec(driver, 5).until(ExpectedConditions.elementToBeClickable(By.id("inboxfield")));
	        fldInbox.sendKeys(userEmail);
	        WebElement btnGo = driver.findElement(By.xpath("/html/body/section[1]/div/div[3]/div[2]/div[2]/div[1]/span/button"));
	        btnGo.click();
	        waitSec(driver, 600).until(ExpectedConditions.numberOfElementsToBe((By.xpath("//*[@id=\"inboxpane\"]/div/div/div/table/tbody/tr")), expectedNumberOfDeliveredEmails));
	        WebElement lastMailLink = driver.findElement(By.xpath("//*[@id=\"inboxpane\"]/div/div/div/table/tbody/tr"));
	        lastMailLink.click();
	        Thread.sleep(3000);
	        driver.switchTo().frame(driver.findElement(By.id("msg_body")));
	        setDoubleOptInLink(driver.findElement(By.xpath("//*[@id=\"intro\"]/tbody/tr/td/a")).getAttribute("href"));
	    }
	}


}
