package listeners;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
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

public class Listeners extends ExtentReporter implements ITestListener/* , EventListener */ {

	public ExtentTest test;
	public ExtentReports extent = ExtentReporter.getReportObject();
	ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();
	// BrowserstackUtility browserstackUtility;
//	private ExtentSparkReporter spark;
//	// private ExtentReports extent;
//	Map<String, ExtentTest> feature = new HashMap<String, ExtentTest>();
//	ExtentTest scenario;
//	ExtentTest step;

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub

		test = extent.createTest(result.getMethod().getMethodName());
		extentTest.set(test);
		// browserstackUtility = new BrowserstackUtility();

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		extentTest.get().log(Status.PASS, "Test Passed");
		// browserstackUtility.setTestResult("PASS");
		Assert.assertTrue(true);

	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub

		extentTest.get().fail(result.getThrowable());
		// browserstackUtility.setTestResult("FAIL");
		Assert.fail();
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

	}

	private String takeScreenshot(String testMethodName, WebDriver driver) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		// browserstackUtility.setTestResult("SKIPPED");

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
//	public void setEventPublisher(EventPublisher publisher) {
//// TODO Auto-generated method stub
//		/*
//		 * :: is method reference , so this::collecTag means collectTags method in
//		 * 'this' instance. Here we says runStarted method accepts or listens to
//		 * TestRunStarted event type
//		 */
//		publisher.registerHandlerFor(TestRunStarted.class, this::runStarted);
//		publisher.registerHandlerFor(TestRunFinished.class, this::runFinished);
//		publisher.registerHandlerFor(TestSourceRead.class, this::featureRead);
//		publisher.registerHandlerFor(TestCaseStarted.class, this::ScenarioStarted);
//		publisher.registerHandlerFor(TestStepStarted.class, this::stepStarted);
//		publisher.registerHandlerFor(TestStepFinished.class, this::stepFinished);
//	};
//
//	/*
//	 * Here we set argument type as TestRunStarted if you set anything else then the
//	 * corresponding register shows error as it doesn't have a listner method that
//	 * accepts the type specified in TestRunStarted.class
//	 */
//// Here we create the reporter
//	private void runStarted(TestRunStarted event) {
//		spark = new ExtentSparkReporter(".reports/ExtentHtml.html");
//		extent = new ExtentReports();
//		spark.config().setTheme(Theme.DARK);
//// Create extent report instance with spark reporter
//		extent.attachReporter(spark);
//	};
//
//// TestRunFinished event is triggered when all feature file executions are
//// completed
//	private void runFinished(TestRunFinished event) {
//		extent.flush();
//	};
//
//// This event is triggered when feature file is read
//// here we create the feature node
//	private void featureRead(TestSourceRead event) {
//		String featureSource = event.toString();
//		String featureName = featureSource.split(".*/")[1];
//		if (feature.get(featureSource) == null) {
//			feature.putIfAbsent(featureSource, extent.createTest(featureName));
//		}
//	};
//
//// This event is triggered when Test Case is started
//// here we create the scenario node
//	private void ScenarioStarted(TestCaseStarted event) {
//		String featureName = event.getTestCase().getUri().toString();
//		scenario = feature.get(featureName).createNode(event.getTestCase().getName());
//	};
//
//// step started event
//// here we creates the test node
//	private void stepStarted(TestStepStarted event) {
//		String stepName = " ";
//		String keyword = "Triggered the hook :";
//// We checks whether the event is from a hook or step
//		if (event.getTestCase() instanceof PickleStepTestStep) {
//// TestStepStarted event implements PickleStepTestStep interface
//// WHich have additional methods to interact with the event object
//// So we have to cast TestCase object to get those methods
//			PickleStepTestStep steps = (PickleStepTestStep) event.getTestCase();
//			stepName = steps.getStepText();
//			keyword = steps.getStepText().getClass().getName();
//		} else {
//// Same with HoojTestStep
//			HookTestStep hoo = (HookTestStep) event.getTestCase();
//			stepName = hoo.getHookType().name();
//		}
//		step = scenario.createNode(Given.class, keyword + " " + stepName);
//	};
//
//// This is triggered when TestStep is finished
//	private void stepFinished(TestStepFinished event) {
//		if (event.getTestCase().getName().toString() == "PASSED") {
//			step.log(Status.PASS, "This passed");
//		} else if (event.getTestCase().getName().toString() == "SKIPPED") {
//			step.log(Status.SKIP, "This step was skipped ");
//		} else {
//			step.log(Status.FAIL, "This failed");
//		}
//
//	};
}
