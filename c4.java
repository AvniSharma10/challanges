import java.util.Scanner;
import javax.mail.*;
import javax.mail.internet.*;

public class EmailSenderWithInput {
    
    public static void main(String[] args) {
        // Sender's credentials
        // Create a Scanner object to take user input
        Scanner scanner = new Scanner(System.in);
         System.out.print("Enter usename: ");
        String username = Scanner.nextLine();
         System.out.print("Enter password: ");
        String password = Scanner.nextLine();
        
        // Recipient's email address
         System.out.print("Enter Recipient email: ");
        String toAddress = scanner.nextLine();
        
        // SMTP server details
        String smtpHost = "smtp.gmail.com";
        String smtpPort = "587";
        
        
        
        try {
            // Set up properties for the email session
            Properties props = new Properties();
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.host", smtpHost);
            props.put("mail.smtp.port", smtpPort);
            
            // Create the email session with authentication
            Session session = Session.getInstance(props,
                    new javax.mail.Authenticator() {
                        protected PasswordAuthentication getPasswordAuthentication() {
                            return new PasswordAuthentication(username, password);
                        }
                    });
            
            
            System.out.print("Enter email subject: ");
            String subject = scanner.nextLine();
            System.out.print("Enter email body: ");
            String body = scanner.nextLine();
            
            // Create a new email message
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(toAddress));
            message.setSubject(subject);
            message.setText(body);
            
            // Send the email message
            Transport.send(message);
            
            System.out.println("Email sent successfully.");
        } catch (MessagingException e) {
            System.err.println("Error sending email: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
