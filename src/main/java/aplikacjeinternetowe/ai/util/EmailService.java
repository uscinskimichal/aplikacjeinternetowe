package aplikacjeinternetowe.ai.util;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

public class EmailService {

    public void sendEmail(String receiverEmail, String topic, String messageContent) {
        // receiverEmail is not used in order to prevent sending spam to random users

        final String username = "aplikacje.internetowe.wat.2019@gmail.com";
        final String password = "Ai.wat2019!";

        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true");

        Session session = Session.getInstance(prop,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username, "ConsultMed"));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse("uscinskimichal@gmail.com , p.golawska@gmail.com")
            );
            message.setSubject(topic);
            message.setText(messageContent);

            Transport.send(message);


        } catch (MessagingException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

}