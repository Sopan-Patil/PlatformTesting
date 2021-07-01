package utils;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.aventstack.extentreports.util.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;
public class OtpRead {
    public static void main(String[] args) {

    public static String getAccessTokenThroughBrowser() {
			String token = ObjectHelper.driver.findElement(By.xpath("//pre[contains(text(),'{\"access_token\"')]")).getText();

			JSONObject jsonobject = new JSONObject(token);

			token = jsonobject.getString("access_token");

			System.out.println(("+++++++++++++ getAccessToken is: " + token);
	}
   
}
}

