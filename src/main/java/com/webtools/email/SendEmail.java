package com.webtools.email;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import com.webtools.pojo.Courses;
import com.webtools.pojo.Student;

public class SendEmail {

	public void sendEmailToStudent(Courses c, String s) throws EmailException {
		Email email = new SimpleEmail();
		email.setHostName("smtp.googlemail.com");
		email.setSmtpPort(465);	
		email.setAuthenticator(new DefaultAuthenticator("tanmayee7@gmail.com", "rafacenakallurimalladi"));
		email.setSSLOnConnect(true);
		email.setFrom("no-reply@courseregistration.neu.edu");
		email.setSubject("Congrats you have successfully registered for "+c.getCourseName());
		email.setMsg("Hi there, \n You have successfully registered for "+c.getCourseName()+" for section "+c.getSection()+
				" on "+c.getTime()+". Good luck with your semester.\n Northeastern University Course Registration Portal.");
		email.addTo(s);
		email.send();
	}
}
