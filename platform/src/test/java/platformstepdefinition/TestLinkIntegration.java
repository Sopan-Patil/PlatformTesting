package platformstepdefinition;

import testlink.api.java.client.TestLinkAPIClient;
import testlink.api.java.client.TestLinkAPIException;

public class TestLinkIntegration {
	public static String TESTER_KEY = "bfc253036d528263bf17c152b0f72bd9"; // Replace your TestLink API Key here
	public static String TESTLINK_URL = "http://65.2.104.183/lib/api/xmlrpc/v1/xmlrpc.php"; // Replace your
																							// TestLink url
	public static final String TEST_PROJECT_NAME = "Platform Testing QA"; // Provide Project Name form TestLink
	public static final String TEST_PLAN_NAME = "Platform Testing Test Plan"; // Provide Test Plan Name form TestLink
	public static final String BUILD_NAME = "Platform Testing Test Build"; // Provide Build Name form TestLink

	public static void updateTestLinkResults(String testCaseName, String exception, String Result)
			throws TestLinkAPIException {
		TestLinkAPIClient testlink = new TestLinkAPIClient(TESTER_KEY, TESTLINK_URL);

		testlink.reportTestCaseResult(TEST_PROJECT_NAME, TEST_PLAN_NAME, testCaseName, BUILD_NAME, exception, Result);

	}

}
