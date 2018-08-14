package rrr;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Properties;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) throws MessagingException {
        Properties properties = new Properties();
        properties.put("mail.transport.protocol", "smtps");
        properties.put("mail.smtps.host", "mail.pflb.ru");
        properties.put("mail.imap.host", "mail.pflb.ru");
        properties.put("mail.smtps.auth", "true");
        properties.put("mail.smtp.sendpartial", "true");
        properties.put("mail.smtps.port", "587");
        properties.put("mail.imap.port", "993");
        properties.put("mail.user", "r.yavnikov@pflb.ru");
        properties.put("mail.password", "12Qwaszx");

        Session session = Session.getDefaultInstance(properties);
        MimeMessage message = new MimeMessage(session);

//устанавливаем тему письма
        message.setSubject("тестовое письмо!");

//добавляем текст письма
        message.setText("Asta la vista, baby!");

//указываем получателя
        message.addRecipient(Message.RecipientType.TO, new InternetAddress("reset1301@gmail.com"));

//указываем дату отправления
        message.setSentDate(new Date());
        //авторизуемся на сервере:
        Transport transport = session.getTransport();
        transport.connect("smtp.gmail.com", 465, "reset1301@gmail.com","12Qwertyu" );
        transport.sendMessage(message, message.getRecipients(Message.RecipientType.TO));
    }
}
