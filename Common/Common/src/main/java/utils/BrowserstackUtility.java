package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import org.apache.hc.client5.http.classic.methods.HttpPut;
import org.apache.hc.client5.http.entity.UrlEncodedFormEntity;
import org.apache.hc.client5.http.impl.classic.HttpClientBuilder;
import org.apache.hc.core5.http.NameValuePair;
import org.apache.hc.core5.http.message.BasicNameValuePair;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.SessionId;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Test;

import com.browserstack.local.Local;

/**
 * @Author : Chetan Sonparote
 * @Date : 27 Jun 2021
 * @Description: Browserstack utility
 */

public class BrowserstackUtility {
	public WebDriver driver;
	private Local l;
	public Properties properties;
	private static Logger log = LogManager.getLogger(BrowserstackUtility.class.getName());

	public void loadPropertiesFile() throws IOException {
		properties = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\resources\\data.properties");
		properties.load(fis);
	}

	
	public WebDriver initializaBrowserstackDriver(@Optional("local.conf.json") String config_file,
			@Optional("chrome") String environment) throws Exception {
		loadPropertiesFile();

		/**
		 * @Author : Chetan Sonparote
		 * @Date :26 Jul 2021
		 * @Description: Browserstack jenkins parameters stored in this var
		 */

		String username = System.getenv("BROWSERSTACK_USERNAME");
		String accessKey = System.getenv("BROWSERSTACK_ACCESS_KEY");
		String buildName = System.getenv("BROWSERSTACK_BUILD_NAME");
		String browserstackLocal = System.getenv("BROWSERSTACK_LOCAL");
		String browserstackLocalIdentifier = System.getenv("BROWSERSTACK_LOCAL_IDENTIFIER");

		JSONParser parser = new JSONParser();
		JSONObject config = (JSONObject) parser.parse(new FileReader(System.getProperty("user.dir") + File.separator
				+ "resources" + File.separator + "browserstackConfig" + File.separator + config_file));
		JSONObject envs = (JSONObject) config.get("environments");

		DesiredCapabilities capabilities = new DesiredCapabilities();

		// DO not delete. commented for test

		Map<String, String> envCapabilities = (Map<String, String>) envs.get(environment);
		Iterator it = envCapabilities.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry pair = (Map.Entry) it.next();
			capabilities.setCapability(pair.getKey().toString(), pair.getValue().toString());
		}

		Map<String, String> commonCapabilities = (Map<String, String>) config.get("capabilities");
		it = commonCapabilities.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry pair = (Map.Entry) it.next();
			if (capabilities.getCapability(pair.getKey().toString()) == null) {
				capabilities.setCapability(pair.getKey().toString(), pair.getValue().toString());
			}
		}

		/**
		 * @Author : Chetan Sonparote
		 * @Date : 23 Jul 2021
		 * @Description: Added user name and password from env properties for jenkins
		 */

		
		if (username == null) {
			username = properties.getProperty("BROWSERSTACK_USERNAME");
		}

		
		if (accessKey == null) {
			accessKey = properties.getProperty("BROWSERSTACK_ACCESS_KEY");
		}

	

	
	  if (buildName == null) { buildName = (String) config.get("build"); }
	 


		String app = System.getenv("BROWSERSTACK_APP_ID");
		if (app != null && !app.isEmpty()) {
			capabilities.setCapability("app", app);
		}

		if (capabilities.getCapability("browserstack.local") != null
				&& capabilities.getCapability("browserstack.local") == "true") {
			l = new Local();
			Map<String, String> options = new HashMap<String, String>();
			options.put("key", accessKey);
			l.start(options);
		}

		capabilities.setCapability("acceptSslCerts", "true");
		capabilities.setCapability("browserstack.idleTimeout", "30");
		
		capabilities.setCapability("build", buildName); 
		  capabilities.setCapability("browserstack.local", browserstackLocal);
		  capabilities.setCapability("browserstack.localIdentifier", browserstackLocalIdentifier);

		

		driver = new RemoteWebDriver(
				// new URL("https://" + username + ":" + accessKey + "@" + config.get("server")
				// + "/wd/hub"),
				new URL("https://" + username + ":" + accessKey + "@hub-cloud.browserstack.com/wd/hub"), capabilities);

		SessionId session = ((RemoteWebDriver) driver).getSessionId();

		mark(session, username, accessKey);

		return driver;

	}

	public static String browserName;

	public void tearDown() throws Exception {
		driver.quit();
		if (l != null)
			l.stop();
	}

	// Method to mark test as pass / fail on BrowserStack

	public void mark(SessionId session, String username, String accessKey)
			throws URISyntaxException, UnsupportedEncodingException, IOException {
		URI uri = new URI("https://" + username + ":" + accessKey + "@api.browserstack.com/automate/sessions/" + session
				+ ".json");
		HttpPut putRequest = new HttpPut(uri);

		// System.out.println("getResult():"+getResult());

		ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
		nameValuePairs.add((new BasicNameValuePair("status", "completed")));
		// nameValuePairs.add((new BasicNameValuePair("status", result)));
		// nameValuePairs.add((new BasicNameValuePair("reason", "")));
		putRequest.setEntity(new UrlEncodedFormEntity(nameValuePairs));

		HttpClientBuilder.create().build().execute(putRequest);
	}

	/**
	 * @Author : Chetan Sonparote
	 * @Date : 2 Jul 2021
	 * @Description: Added method to get test result
	 */

	/*
	 * public String result;
	 * 
	 * 
	 * public void setResult(String result) { this.result = result; }
	 * 
	 * public ITestResult resultStatus;
	 * 
	 * public ITestResult getResultStatus() { return resultStatus; }
	 * 
	 * public void setResultStatus(ITestResult resultStatus) { this.resultStatus =
	 * resultStatus; }
	 * 
	 * String getResult() { String result = null; //resultStatus =
	 * getResultStatus(); resultStatus = getResultStatus();
	 * 
	 * if(resultStatus.getStatus() == ITestResult.SUCCESS) {
	 * 
	 * //Do something here System.out.println("passed **********"); result = "PASS";
	 * }
	 * 
	 * else if(resultStatus.getStatus() == ITestResult.FAILURE) { //Do something
	 * here System.out.println("Failed ***********"); result = "FAIL"; }
	 * 
	 * else if(resultStatus.getStatus() == ITestResult.SKIP ){
	 * 
	 * System.out.println("Skiped***********"); result = "SKIPPED"; } return result;
	 * }
	 */

	/*
	 * public void setJenkinsBuildName() { String build_name =
	 * System.getenv("BROWSERSTACK_BUILD_NAME"); //BROWSERSTACK_BUILD_NAME is the
	 * sample environment variable. Ensure the value of this variable is set every
	 * time before a build is run. You can do that by adding a pre-build step
	 * DesiredCapabilities caps = new DesiredCapabilities();
	 * caps.setCapability("build_name", build_name); // CI/CD job or build name }
	 */

}
