package utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @Author : Chetan Sonparote
 * @Date : 19 Jul 2021
 * @Description: Class to generate Email addressa EID function
 */
public class CredentialsGenerator {
	
	static String generatedEmail;
	static String generatedEid;
	static String datetime;
	
	public static String generateEmailAddress() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("ddMMyyyyHHmmss");
		LocalDateTime now = LocalDateTime.now();
		datetime = dtf.format(now);
		 generatedEmail = "TestPF1221+" + datetime + "@gmail.com";
		return generatedEmail;
	}
	
	public static String generateEid() {
	
		generatedEid = "TestPF1221_" + datetime;
		return generatedEid;
	}

}
