package controller;

import java.util.Date;
import java.util.Properties;
import java.util.UUID;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import model.DTO.MemberDTO;

public class PassMailAction {
	public void sendMail(MemberDTO dto) {
		
		String sender = "webmaster@ccc.com";
		String receiver = dto.getUserEmail();
		String subject = dto.getUserName() + "님 안녕하세요. 임시비밀번호를 보내드립니다.";
		String content = dto.getUserName() + "님 안녕하세요. 임시비밀번호를 보내드립니다.<br/>"+"임시비밀번호:"+dto.getUserPw()
				+"<br/>임시비밀번호로 로그인 후 비밀번호 변경을 꼭 부탁드립니다..<br/>" + "<a href='http://172.16.3.4:8080/CCC/main.ccc' >CCC홈페이지</a>"; 
		System.out.println(dto.getUserEmail());	
		String server = "imap.gmail.com";
		String port = "465";
		
		// smtp 설정 시작
		Properties properties = new Properties();
		properties.put("mail.smtp.host", server);
		properties.put("mail.smtp.port", port);
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.debug", "true");
		properties.put("mail.smtp.socketFactory.port", port);
		properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		properties.put("mail.smtp.socketFactory.fallback", false);
		// smtp 설정 끝
		
		Session s = Session.getDefaultInstance(properties, new Authenticator() {
@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("deep8888kr", "20170563a!");
			}			
		});
		
		
		SmsSend ss = new SmsSend();
		String textMassage = null;
		
		Message message = new MimeMessage(s);
		
		try {
			Address sender_address = new InternetAddress(sender);
			Address receiver_address = new InternetAddress(receiver);
			message.setHeader("content-type", "text/html; charset=UTF-8");
			message.setFrom(sender_address);
			message.setRecipient(Message.RecipientType.TO, receiver_address);
			message.setSubject(subject);
			message.setContent(content, "text/html; charset=UTF-8");
			message.setSentDate(new Date());
			Transport.send(message, message.getAllRecipients());
			
			textMassage = dto.getUserName() + "님 임시비밀번호를 발송하였습니다.";
			ss.smsSend(dto.getUserPh1(), textMassage);
			
			
			
		} catch (Exception e) {
			textMassage = dto.getUserName() + "님 임시비밀번호를 받지 못했을 경우에는 1588-1588로 문의 주세요.";
			ss.smsSend(dto.getUserPh1(), textMassage);
			
			e.printStackTrace();
		}
	}
}
