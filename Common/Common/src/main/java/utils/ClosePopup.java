package utils;

import java.io.FileInputStream;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.BodyPart;
import javax.mail.Flags;
import javax.mail.Flags.Flag;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.search.FlagTerm;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ClosePopup {
	int waitTime = 5;
	/**
	 * @Author : Sopan Patil
	 * @Date : 06 Aug 2021
	 * @Description: Close Zakai Popup
	 */
	private static Logger log = LogManager.getLogger(ClosePopup.class.getName());
	@FindBy(xpath = "//div[@class='modal-content']")
	public WebElement zkaiPopup;
	
//	@FindBy(xpath = "//button[@aria-label='Close']")
//	public WebElement zkaiPopupCloseButton;
//	
	
	
	public void closeZkaiPopup() {
		
		if (ObjectHelper.driver.findElement(By.xpath("//div[@class='modal-content']")).isDisplayed()) {	
			log.info("Zakai Popup Detected");	
			By zkai_popupCloseButton = By.xpath("//button[@aria-label='Close']");
			if (ObjectHelper.driver.findElement((By) zkai_popupCloseButton).isDisplayed()) {
				if (ObjectHelper.driver.findElements((By) zkai_popupCloseButton).size() > 0) {
					ObjectHelper.driver.findElement((By) zkai_popupCloseButton).click();
					log.info("Zakai Popup Closed");	
				}
		}
	}else {
		log.info("Zakai Popup not Deletected");	
	}
		
}


}
