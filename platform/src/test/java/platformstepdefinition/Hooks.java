package platformstepdefinition;

import org.openqa.selenium.WebDriver;

import base.NewBaseClass;

public class Hooks extends NewBaseClass {

	/**
	 * @Author : Chetan Sonparote
	 * @Date : 13 Jul 2021
	 * @Description: Hooks for opening and closing browser
	 */
	// NewBaseClass baseClass;// = new NewBaseClass();
	// openbrowser here with param from testng

	public WebDriver driver;

//	@Before

	public void setUp() throws Exception {
		// setUpBrowser(null, null, null, null);
	}

	// close driver
//	@After

	public void cleanUp() {
		// driver.close();
		// closeBrowser(null);

	}

}
