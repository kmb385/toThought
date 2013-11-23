package org.tothought.web.email;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.tothought.data.entities.Comment;
import org.tothought.web.email.abstracts.AbstractMailMessage;
import org.tothought.web.email.interfaces.MailMessage;


public class CommentMessage extends AbstractMailMessage implements MailMessage<Comment> {

	private static final String MESSAGE_SUBJECT = "A new comment has been made on the toThought Blog";
	StringBuilder body = new StringBuilder(MESSAGE_SUBJECT);

	@Override
	public Message getMessage(Session session) {
		Message message = new MimeMessage(session);
		try {
			message.setFrom(new InternetAddress("kmb385@gmail.com"));
			message.addRecipients(Message.RecipientType.TO, InternetAddress.parse("kmb385@gmail.com"));
			message.setSubject(MESSAGE_SUBJECT);
			message.setText(body.toString());
		} catch (AddressException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		return message;
	}

	@Override
	public void setBody(Comment comment) {
		body.append("\n");
		body.append("Regarding post: ").append(comment.getPost().getTitle());
		body.append("\n");
		body.append(comment.getAuthor()).append(" commented: ").append("\n");
		body.append(comment.getBody());
	}

}
