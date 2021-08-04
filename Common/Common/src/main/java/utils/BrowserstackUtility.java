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

	String username = null;
	String accessKey = null;
	

	public void loadPropertiesFile() throws IOException {
		properties = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\resources\\data.properties");
		properties.load(fis);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public WebDriver initializaBrowserstackDriver(
			 String config_file,
			String environment) throws Exception {
		

		/**
		 * @Author : Chetan Sonparote
		 * @Date :26 Jul 2021
		 * @Description: Browserstack jenkins parameters stored in this var
		 */
		

		JSONParser parser = new JSONParser();
		JSONObject config = (JSONObject) parser.parse(new FileReader(System.getProperty("user.dir") + File.separator
				+ "resources" + File.separator + "browserstackConfig" + File.separator + config_file));
		JSONObject envs = (JSONObject) config.get("environments");

		DesiredCapabilities capabilities = new DesiredCapabilities();

		// DO not delete. commented for test

		@SuppressWarnings("unchecked")
		Map<String, String> envCapabilities = (Map<String, String>) envs.get(environment);
		Iterator<?> it = envCapabilities.entrySet().iterator();
		while (it.hasNext()) {
			@SuppressWarnings("rawtypes")
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

		

		getUserCredentials();

		String build = System.getenv("BROWSERSTACK_BUILD_NAME");
		  if (build == null || build == "test") { build = (String)
		  config.get("build"); }
		 
//		  String buildName = (String)
//				  config.get("name");
//
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
		//capabilities for selenium action class
		capabilities.setCapability("browserstack.selenium_version", "3.141.59");
		capabilities.setCapability("browserstack.use_w3c", "true");
		
		
	
		capabilities.setCapability("build", build); 




		driver = new RemoteWebDriver(		
				new URL("https://" + username + ":" + accessKey + "@hub-cloud.browserstack.com/wd/hub"), capabilities);

	

		return driver;

	}

	// public static String browserName;

	public void tearDown() throws Exception {

		//this.driver = driver;
		//mark();
		ObjectHelper.driver.quit();
		if (l != null)
			l.stop();
		//mark();
	}

	// Method to mark test as pass / fail on BrowserStack

	public void mark()
			throws URISyntaxException, UnsupportedEncodingException, IOException {
		getUserCredentials();
		SessionId session = ((RemoteWebDriver) driver).getSessionId();

		URI uri = new URI("https://" + username + ":" + accessKey + "@api.browserstack.com/automate/sessions/" + session
				+ ".json");
		HttpPut putRequest = new HttpPut(uri);

		// System.out.println("getResult():"+getResult());

		ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
		nameValuePairs.add((new BasicNameValuePair("status", "")));// get test status from assertion status here
		// nameValuePairs.add((new BasicNameValuePair("status", result)));
		nameValuePairs.add((new BasicNameValuePair("reason", "")));// get failure reason here
		putRequest.setEntity(new UrlEncodedFormEntity(nameValuePairs));

		HttpClientBuilder.create().build().execute(putRequest);
	}

	/**
	 * @throws IOException
	 * @Author : Chetan Sonparote
	 * @Date : 28 Jul 2021
	 * @Description: Getting user credentials
	 */
	void getUserCredentials() throws IOException {
		loadPropertiesFile();
		username = System.getenv("BROWSERSTACK_USERNAME");
		
		if (username == null) {
			username = properties.getProperty("BROWSERSTACK_USERNAME");
		}

		accessKey = System.getenv("BROWSERSTACK_ACCESS_KEY");
		if (accessKey == null) {
			accessKey = properties.getProperty("BROWSERSTACK_ACCESS_KEY");
		}

	}

	

}
