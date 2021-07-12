package utils;
import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
 
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Store;
 
public class QTPRead2 {
 
    public static void main(String[] args) {
 
        QTPRead2 gmail = new QTPRead2();
        gmail.read();
 
    }
 
    public void read() {
 
        Properties props = new Properties();
 
        try {
            props.load(new FileInputStream(new File("C:\\Users\\Dell\\smtp.properties")));
            Session session = Session.getDefaultInstance(props, null);
 
            Store store = session.getStore("imaps");
            store.connect("smtp.gmail.com", "Sopan.patil@scispl.com", "Welcome2020!");
 
            Folder inbox = store.getFolder("inbox");
            inbox.open(Folder.READ_ONLY);
            int messageCount = inbox.getMessageCount();
 
            System.out.println("Total Messages:- " + messageCount);
 
            Message[] messages = inbox.getMessages();
            System.out.println("------------------------------");
 
            for (int i = 0; i < 10; i++) {
                System.out.println("Mail Subject:- " + messages[i].getSubject());
            }
 
            inbox.close(true);
            store.close();
 
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
 
}