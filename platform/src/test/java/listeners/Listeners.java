package listeners;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import reporting.ExtentReporter;
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
	// BrowserstackUtility browserstackUtility;

	static String testName;

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub

		testName = result.getMethod().getMethodName();
		// testName =
		// com.aventstack.extentreports.gherkin.model.Scenario.getGherkinName();

		test = extent.createTest(testName);
		extentTest.set(test);
		// browserstackUtility = new BrowserstackUtility();

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		extentTest.get().log(Status.PASS, "Test Passed");
		// browserstackUtility.setResultStatus(result);
		// browserstackUtility.setResult("PASS");
		// Assert.assertTrue(true, "Test Passed");

	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub

		extentTest.get().fail(result.getThrowable());

		// result.getTestContext().

		// ExtentReporter.addScreenshot();
		// Assert.assertTrue(true, "Test Fail");

		// WebDriver driver = null;

		// String testMethodName = result.getMethod().getMethodName();

//		try {
//			driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver")
//					.get(result.getInstance());
//		} catch (Exception e) {
//
//		}
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("ddMMyyyyHHmmss");
		LocalDateTime now = LocalDateTime.now();

		String fileName = dtf.format(now);

		// do not delete - commented for test

		extentTest.get().addScreenCaptureFromPath(Screenshots.takeScreenshot(fileName, ObjectHelper.driver),
				result.getMethod().getMethodName());

//		try {
//			extentTest.get().addScreenCaptureFromPath(getScreenShotPath(testMethodName, driver),
//					result.getMethod().getMethodName());
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		// Reporter.log("<br> <img src=.\\screenshots\\Untitled.png /> <br>");
		// Reporter.getCurrentTestResult();
		// Assert.assertTrue(false);
		// Assert.assertTrue(false);
		// Status status;
		// Scenario scenario = new Scenario();
		// final byte[] screenshot = ((TakesScreenshot)
		// ObjectHelper.driver).getScreenshotAs(OutputType.BYTES);
		// scenario.attach(screenshot, "image/png", "image");

	}

//	private String takeScreenshot(String testMethodName, WebDriver driver) {
//		// TODO Auto-generated method stub
//		return null;
//	}

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

//	@Override
//	public Collection<String> getSourceTagNames() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public io.cucumber.core.backend.Status getStatus() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public boolean isFailed() {
//		// TODO Auto-generated method stub
//		return false;
//	}
//
//	@Override
//	public void attach(byte[] data, String mediaType, String name) {
//		// TODO Auto-generated method stub
//
//	}
//
//	@Override
//	public void attach(String data, String mediaType, String name) {
//		// TODO Auto-generated method stub
//
//	}
//
//	@Override
//	public void log(String text) {
//		// TODO Auto-generated method stub
//
//	}
//
//	@Override
//	public String getName() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public String getId() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public URI getUri() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public Integer getLine() {
//		// TODO Auto-generated method stub
//		return null;
//	}

}
