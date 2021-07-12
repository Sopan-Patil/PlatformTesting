package utils;

import org.openqa.selenium.WebDriver;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class EmailAddressAndEIDGenerate{
	/**
	 * @Author : Sopan Patil
	 * @Date : 01 Jul 2021
	 * @Description: Added Generate Email addressa EID function
	 */
	static String generatedemail;
	static String generatedeid;
	public static String generateemailaddress(String emailaddress) {
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("ddMMyyyyHHmmss");
	LocalDateTime now = LocalDateTime.now();
	String datetime = dtf.format(now);
	String generatedemail = "sopan.patil+" + datetime + "@scispl.com";	
	return generatedemail;
	}
	public static String generateeid(String eid) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("ddMMyyyyHHmmss");
		LocalDateTime now = LocalDateTime.now();
		String datetime = dtf.format(now);
		String generatedemail = "sopan.patil+" + datetime + "@scispl.com";	
		String [] parts= generatedemail.split("@");		
		generatedeid=parts[0];		
		eid=generatedeid;
		return eid;		
		}
}