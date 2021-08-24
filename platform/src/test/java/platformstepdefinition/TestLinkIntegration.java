package platformstepdefinition;

import testlink.api.java.client.TestLinkAPIClient;
import testlink.api.java.client.TestLinkAPIException;

public class TestLinkIntegration {

	public static String TESTER_KEY = "ba817e8e50766a1d96b650cabcff1c43"; // Replace your TestLink API Key here
	public static String TESTLINK_URL = "http://65.2.104.183/testlink/login.php"; // Replace your
																					// TestLink url
	public static final String TEST_PROJECT_NAME = "PlatformTestingQA"; // Provide Project Name form TestLink
	public static final String TEST_PLAN_NAME = "Platform Testing QA Test Plan"; // Provide Test Plan Name form TestLink
	public static final String TEST_CASE_NAME = "Login Feature Validate with validcredentials"; // Provide Test Case
																								// Name form TestLink
	public static final String BUILD_NAME = "Platform Testing QA Test Build"; // Provide Build Name form TestLink

	public static void updateTestLinkResults(String testCaseName, String exception, String Result)
			throws TestLinkAPIException {
		TestLinkAPIClient testlink = new TestLinkAPIClient(TESTER_KEY, TESTLINK_URL);

		testlink.reportTestCaseResult(TEST_PROJECT_NAME, TEST_PLAN_NAME, testCaseName, BUILD_NAME, exception, Result);

	}

}
