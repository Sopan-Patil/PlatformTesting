package utils;

import java.util.Properties;

import javax.mail.Address;
import javax.mail.BodyPart;
import javax.mail.Folder;
import javax.mail.Multipart;
import javax.mail.Service;
import javax.mail.Session;

import org.apache.hc.core5.http.Message;
import org.bouncycastle.util.Store;

public class otp6 {

    public static void main(String[] args) {

        Properties props = new Properties();
        props.setProperty("mail.store.protocol", "imaps");

        try {
            Session session = Session.getInstance(props, null);
            Store store = (Store) session.getStore();
            ((Service) store).connect("imap.gmail.com", "scopsnotify@gmail.com", "scispl@sgfm20");

            Folder inbox = ((javax.mail.Store) store).getFolder("INBOX");

            inbox.open(Folder.READ_ONLY);

            javax.mail.Message msg = inbox.getMessage(inbox.getMessageCount());
            Address[] in = msg.getFrom();

            for (Address address : in) {
                System.out.println("FROM:" + address.toString());
            }

            Multipart mp = (Multipart) msg.getContent();
            BodyPart bp = mp.getBodyPart(0);

            System.out.println("SENT DATE:" + msg.getSentDate());
            System.out.println("SUBJECT:" + msg.getSubject());
            System.out.println("CONTENT:" + bp.getContent());

        } catch (Exception mex) {
            mex.printStackTrace();
        }
    }
}