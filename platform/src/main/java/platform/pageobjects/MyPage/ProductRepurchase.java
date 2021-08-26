package platform.pageobjects.MyPage;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import platform.pageobjects.Authentication.LoginPage;

/**
 * @Author : Sopan Patil
 * @Date : 26 Aug 2021
 * @Description:Class for re purchasing same product with free
 */

public class ProductRepurchase {

	List<String[]> testdata;
	public WebDriver driver;
	private static Logger log = LogManager.getLogger(LoginPage.class.getName());
	int waitTime = 5;

	public ProductRepurchase(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

}
