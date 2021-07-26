package utils;

import java.io.FileInputStream;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.BodyPart;
import javax.mail.Flags;
import javax.mail.Flags.Flag;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.search.FlagTerm;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DeleteMails {
	/**
	 * @Author : Sopan Patil
	 * @Date : 14 Jul 2021
	 * @Description: Delete Mail from Inbox/Trash
	 */
	private static Logger log = LogManager.getLogger(DeleteMails.class.getName());

	public void deletemail(String emailsubject) {
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
			Folder inbox = store.getFolder("Inbox");
			inbox.open(Folder.READ_WRITE);
			Folder[] f = store.getDefaultFolder().list();
			Message[] arrayMessages = inbox.getMessages();
			arrayMessages = inbox.getMessages();
			Folder folderBin = store.getFolder("[Gmail]/Trash");
			for (Message m : arrayMessages) {
				String subject = m.getSubject();
				if (subject.contains(emailsubject)) {
					Address[] in = m.getFrom();
					for (Address address : in) {
					}
					Multipart mp = (Multipart) m.getContent();
					BodyPart bp = mp.getBodyPart(0);
					System.out.println("CONTENT:" + bp.getContent());
					String ob = bp.getContent().toString();
					String sample = ob.toString();
					log.info(subject);
					log.info(bp.getContent());
					//System.out.println(arrayMessages);
					m.getFolder().copyMessages(new Message[] { m }, folderBin);
				}
			}
			inbox.close(false);
			store.close();
		} catch (NoSuchProviderException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}