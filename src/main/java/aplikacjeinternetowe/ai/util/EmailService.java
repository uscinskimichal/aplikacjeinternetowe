package aplikacjeinternetowe.ai.util;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class EmailService {

    public void sendEmail(String receiverName, String userPassword, String receiverEmail) {

        final String username = "aplikacje.internetowe.wat.2019@gmail.com";
        final String password = "Ai.wat2019!";

        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true"); //TLS

        Session session = Session.getInstance(prop,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {

            Message message = new MimeMessage(session);
            //message.setFrom(new InternetAddress(username));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse("uscinskimichal@gmail.com , p.golawska@gmail.com" )
            );
            message.setSubject("Przypomnienie hasła.");
            message.setText("Cześć, " + receiverName
                    + "\n\n Twoje hasło to : " + userPassword
            + "\n\n Prosimy o niezwłoczną zmianę hasła po zalogowaniu się. \n\n\n Zespół ConsultMed.");

            Transport.send(message);

            System.out.println("Done");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

}