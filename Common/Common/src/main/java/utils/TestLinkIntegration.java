package utils;

import testlink.api.java.client.TestLinkAPIClient;
import testlink.api.java.client.TestLinkAPIException;

public class TestLinkIntegration {
	public static String TESTER_KEY = "b23453325a8d8ca9159c1b40ad3b6855"; // Replace your TestLink API Key here
	public static String TESTLINK_URL = "http://65.2.104.183/testlink/lib/api/xmlrpc/v1/xmlrpc.php"; // Replace your TestLink url
	public static final String TEST_PROJECT_NAME = "PlatformTestingQA"; // Provide Project Name form TestLink
	public static final String TEST_PLAN_NAME = "Platform Testing Test Plan"; // Provide Test Plan Name form TestLink
	public static final String BUILD_NAME = "Platform Testing Build1"; // Provide Build Name form TestLink

	public static void updateTestLinkResults(String testCaseName, String exception, String Result)
			throws TestLinkAPIException {
		TestLinkAPIClient testlink = new TestLinkAPIClient(TESTER_KEY, TESTLINK_URL);

		//testlink.reportTestCaseResult(TEST_PROJECT_NAME, TEST_PLAN_NAME, testCaseName, BUILD_NAME, exception, Result);
		testlink.reportTestCaseResult(4, 423, 1, exception, Result)	;

	}

}
