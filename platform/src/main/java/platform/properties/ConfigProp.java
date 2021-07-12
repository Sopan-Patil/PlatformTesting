package platform.properties;

/**
 * Author : Chetan Sonparote Date of Modification : 25 Jun 2021 Description:
 * Added envrionment variables and run mode. Move it to properties file later
 */

public class ConfigProp {

	public static String browser = "chrome";

	// Environment wise URL below
	public static String stageURL = "https://tempmailo.com/";
	public static String devURL = "https://dev.studygear.evidus.net/";
	public static String prdURL = "https://prd-studygear.evidus.net/";
	public static String mailinatorURL = "https://www.mailinator.com/v4/public/inboxes.jsp?to=sopan";

	public static String platformEnvironmentURL = stageURL;
	public static String mailinatorEnvironmentURL = mailinatorURL;

	public static String user = "sgepuser";
	public static String password = "9tg6gxxCEaL3";
	public static String newtestDataFile = "newtestdata.xlsx";
	public static String testReporttitle = "Platform Testing";
	public static String testDataFile = "NewTestData.xlsx";
	public static String testtitle = "Platform Testing";
	public static String dburl = "";
	public static boolean sendreportinemail = true;

}
