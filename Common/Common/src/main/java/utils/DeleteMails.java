package utils;

import java.util.Properties;

import javax.mail.Flags;
import javax.mail.Flags.Flag;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.search.FlagTerm;

public class DeleteMails {
	/**
	 * @Author : Sopan Patil
	 * @Date : 14 Jul 2021
	 * @Description: Delete Mail from Inbox/Trash
	 */

	public static void check(String host, String storeType, String user, String password) {
		try {

			Properties properties = new Properties();
			properties.put("mail.imap.host", host);
			properties.put("mail.imap.port", "993");
			properties.put("mail.imap.starttls.enable", "true");
			properties.put("mail.imap.ssl.trust", host);
			Session emailSession = Session.getDefaultInstance(properties);
			Store store = emailSession.getStore("imaps");
			store.connect(host, user, password);
			Folder inbox = store.getFolder("Inbox");
			inbox.open(Folder.READ_WRITE);
			Folder[] f = store.getDefaultFolder().list();
			Message[] arrayMessages = inbox.getMessages();
			arrayMessages = inbox.getMessages();
			for (int i = 0; i < arrayMessages.length; i++) {
				Message message = arrayMessages[i];
				String subject = message.getSubject();
				if (subject.contains("EiD確認コードのご案内")) {
					message.setFlag(Flags.Flag.DELETED, true);
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