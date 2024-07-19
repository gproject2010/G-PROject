package mail;

import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailSendBean {

	private String smtpHost;
	private String from;
	private String personal;
	private String to;
	private String subject;
	private String body;

	public String getSmtpHost() {return smtpHost;}
	public void setSmtpHost(String smtpHost) {this.smtpHost = smtpHost;}

	public String getFrom() {return from;}
	public void setFrom(String from) {this.from = from;}

	public String getPersonal() {return personal;}
	public void setPersonal(String personal) {this.personal = personal;}

	public String getTo() {return to;}
	public void setTo(String to) {this.to = to;}

	public String getSubject() {return subject;}
	public void setSubject(String subject) {this.subject = subject;}

	public String getBody() {return body;}
	public void setBody(String body) {this.body = body;}


	public boolean send() {
		try{


			Properties props = System.getProperties();
			props.put("mail.smtp.host", this.smtpHost);
			props.put("mail.host", this.smtpHost);
			props.put("mail.smtp.port", "587");

			props.put("mail.smtp.connectiontimeout", "60000");
			props.put("mail.smtp.timeout", "60000");

			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.starttls.enable", "true");
			//props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
			 //props.setProperty("mail.smtp.socketFactory.fallback", "false");
			 //props.setProperty("mail.smtp.socketFactory.port", "465");

			Session session = Session.getInstance(props, new Authenticator(){
				@Override
				protected PasswordAuthentication getPasswordAuthentication(){
					return new PasswordAuthentication("smtpuser", "sf4fpnt6");
					//return new PasswordAuthentication("xysyr908", "sf4fpnt6");
				}
			});

			MimeMessage message = new MimeMessage(session);
			InternetAddress from = new InternetAddress(this.from, this.personal, "iso-2022-jp");
			message.setFrom(from);

			InternetAddress[] to = {new InternetAddress(this.to)};
			message.setRecipients(Message.RecipientType.TO, to);

			message.setSubject(this.subject, "iso-2022-jp");

			message.setSentDate(new Date());

			message.setText(this.body+" " , "iso-2022-jp");

			Transport.send(message);

			return false;
		}
		catch(Exception e){
			e.printStackTrace();
			return true;
		}
	}
}
