package platform.pageobjects.localization;

import java.io.IOException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * @Author : Chetan Sonparote
 * @Date : 9 Aug 2021
 * @Description: Class to read and compare localization data
 */

public class LocalizationData {
	List<String[]> testdata;
	public WebDriver driver;
	private static Logger log = LogManager.getLogger(LocalizationData.class.getName());

	public LocalizationData(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// read from excel

	public void readLocalizationData(/* String file, String sheet */)
			throws EncryptedDocumentException, InvalidFormatException, IOException {

		// ArrayList<String> localizationData = new ArrayList<>(null);
		// String[] localizationData;
		// localizationData = XLHandler.readexcel("NoLogin",
		// "LocalizationTestData.xlsx");
//		for (int i = 0; i < localizationData.length; i++) {
//			log.info("localizationData at " + i + " : " + localizationData[i]);
//		}
		// log.info("localizationData:" + localizationData);

	}
	// navigate to link
	// compare string
}
