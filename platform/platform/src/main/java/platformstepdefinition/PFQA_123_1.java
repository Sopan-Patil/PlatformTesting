package platformstepdefinition;

import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import platform.platformobjects.LoginPage;

public class PFQA_123_1 {
	// private static final String WebElement = null;
	WebDriver driver;
	NewBaseClass bc = new NewBaseClass();
	String emailid = "";

	@Given("^Navigate to URL PFQA_123_1$")
	public void Navigate_to_URL_Platform() throws Throwable {
		bc.openbrowser();
	}

	@Then("^Login for PFQA_123_1$")
	public void Login_for_Platform() throws Throwable {
		LoginPage.Platform_LogIn();
	}
}
