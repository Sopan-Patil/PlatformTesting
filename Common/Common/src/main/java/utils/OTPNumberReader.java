package utils;

import java.io.FileInputStream;
import java.util.Properties;
import javax.mail.Address;
import javax.mail.BodyPart;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Store;

public class OTPNumberReader {
	/**
	 * @Author : Sopan Patil
	 * @Date : 13 Jul 2021
	 * @Description: OTP Reader Function
	 */
	public static String OTPNumberValue() {
		String OTPNumber = null;
		Properties props = new Properties();
		props.setProperty("mail.store.protocol", "imaps");

		try {
			Properties properties = new Properties();
			FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\resources\\data.properties");
			properties.load(fis);
			String host = properties.getProperty("host");
			String username = properties.getProperty("username");
			String password = properties.getProperty("password");
			String mailStoreType = properties.getProperty("mailStoreType");
			properties.put("mail.imap.host", host);
			properties.put("mail.imap.port", "993");
			properties.put("mail.imap.starttls.enable", "true");
			properties.put("mail.imap.ssl.trust", host);
			Session emailSession = Session.getDefaultInstance(properties);
			Store store = emailSession.getStore("imaps");
			store.connect(host, username, password);
			Folder inbox = store.getFolder("INBOX");

			inbox.open(Folder.READ_ONLY);

			Message msg = inbox.getMessage(inbox.getMessageCount());
			Address[] in = msg.getFrom();

			for (Address address : in) {

			}

			Multipart mp = (Multipart) msg.getContent();
			BodyPart bp = mp.getBodyPart(0);

			String ob = bp.getContent().toString();
			String sample = ob.toString();
			char[] chars = sample.toCharArray();
			StringBuilder sb = new StringBuilder();
			for (char c : chars) {
				if (Character.isDigit(c)) {
					sb.append(c);
				}
			}

			OTPNumber = sb.substring(0, 6);

		} catch (Exception mex) {
			mex.printStackTrace();
		}
		return OTPNumber;
	}

}