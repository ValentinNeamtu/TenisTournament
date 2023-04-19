package Model.Persistence;



//import javax.mail.*;
//import javax.mail.internet.InternetAddress;
// javax.mail.internet.MimeMessage;
import java.util.Properties;


public class SendEmail {
    public static void SendEmailToConfirmRequest(String text){

            /*
            // SMTP server properties
            String smtpHost = "smtp.yahoo.com";
            String smtpPort = "587";
            String username = "vali.vali108@yahoo.com";
            String password = "Valentin_2001";

            // Recipient email address
            String toAddress = "vali.vali108@yahoo.com";

            // Email content
            String subject = "Test Email";
            String body = "we did it";

            // Set SMTP server properties
            Properties props = new Properties();
            props.put("mail.smtp.host", smtpHost);
            props.put("mail.smtp.port", smtpPort);
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.enable", "true");

            // Create a new session with an authenticator
            Authenticator auth = new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(username, password);
                }
            };
            Session session = Session.getInstance(props, auth);

            try {
                // Create a new message
                Message message = new MimeMessage(session);

                // Set the sender and recipient addresses
                Address fromAddress = new InternetAddress(username);
                Address toAddressObj = new InternetAddress(toAddress);
                message.setFrom(fromAddress);
                message.setRecipient(Message.RecipientType.TO, toAddressObj);

                // Set the subject and body of the email
                message.setSubject(subject);
                message.setText(body);

                // Send the message
                Transport.send(message);

                System.out.println("Email sent successfully!");
            } catch (MessagingException ex) {
                System.out.println("Failed to send email.");
                ex.printStackTrace();
            }

        */
    }
}

