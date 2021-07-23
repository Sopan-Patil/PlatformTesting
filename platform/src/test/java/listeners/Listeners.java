package listeners;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import reporting.ExtentReporter;
import utils.BrowserstackUtility;
import utils.ObjectHelper;
import utils.Screenshots;

/**
 * @Author : Chetan Sonparote
 * @Date : 24 Jun 2021
 * @Description: Listener class with thread local for parallel execution
 */

public class Listeners extends ExtentReporter implements ITestListener {

	public ExtentTest test;
	ExtentReports extent = ExtentReporter.getReportObject();
	ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();
	BrowserstackUtility browserstackUtility;

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub

		test = extent.createTest(result.getMethod().getMethodName());
		extentTest.set(test);
		browserstackUtility = new BrowserstackUtility();

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		extentTest.get().log(Status.PASS, "Test Passed");
		// browserstackUtility.setResultStatus(result);
		// browserstackUtility.setResult("PASS");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub

		extentTest.get().fail(result.getThrowable());

		// result.getTestName().

		WebDriver driver = null;

		String testMethodName = result.getMethod().getMethodName();

		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver")
					.get(result.getInstance());
		} catch (Exception e) {

		}
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("ddMMyyyyHHmmss");
		LocalDateTime now = LocalDateTime.now();

		String fileName = dtf.format(now);
		extentTest.get().addScreenCaptureFromPath(Screenshots.takeScreenshot(fileName, ObjectHelper.driver),
				result.getMethod().getMethodName());
		// browserstackUtility.setResult("FAIL");

	}

	private String takeScreenshot(String testMethodName, WebDriver driver) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		// browserstackUtility.setResult("SKIPPED");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	// public void onTestFailedWithTimeout(ITestResult result) { // TODO
	// Auto-generated method stub

	// }

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub

		extent.flush();

	}

}
