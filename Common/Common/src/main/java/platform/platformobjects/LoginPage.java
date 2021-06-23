package platform.platformobjects;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonFunctions;

public class LoginPage {
	static List<String[]> testdata;
	WebDriver driver;
	@FindBy(xpath = "//input[@id='email']")
	public static WebElement emailtextfield;

	@FindBy(xpath = "//input[@id='password']")
	public static WebElement passwordTextField;

	@FindBy(xpath = "//span[contains(text(),'ログイン')]")
	public static WebElement logInButton;

	@FindBy(xpath = "//button[@type='submit']")
	public static WebElement SubmitButton;	

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public static void Platform_LogIn() throws Exception {
		LoginPage.logInButton.click();
		LoginPage.emailtextfield.click();
		LoginPage.emailtextfield.sendKeys("Sopan181");
		LoginPage.passwordTextField.sendKeys("Test-123");
		CommonFunctions.clickUsingJavaExecutor(LoginPage.SubmitButton);

	}
}