package platformstepdefinition;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import base.TestBase;
import testlink.api.java.client.TestLinkAPIResults;

public class LoginScenarios extends TestBase {

	String TC_Name = "Validate new login feature"; // Provide Test case Name form
	String notes = null;
	String result = null;

	@Test
	public void ValidateNewLoginFeature() throws Exception {

		try {

			driver.findElement(By.xpath("//span[contains(text(),'ログイン')]")).click();
			driver.findElement(By.xpath("//input[@id='email']")).sendKeys("Sopan181");
			driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Test-123");
			driver.findElement(By.xpath("//button[@type='submit']")).click();

			result = TestLinkAPIResults.TEST_PASSED;
			notes = getOSBrowserDetails();

		} catch (Exception e) {

			result = TestLinkAPIResults.TEST_FAILED;
			notes = e.getMessage();
			e.printStackTrace();

		} catch (AssertionError e) {

			String message = e.getMessage();
			System.out.println(message);
			result = TestLinkAPIResults.TEST_FAILED;
			notes = e.getMessage();
			e.printStackTrace();

		} finally {

			System.out.println("Updating TestCase Execution Status in TestLink");
			TestLinkIntegration.updateTestLinkResults(TC_Name, notes, result);

		}

	}

}
