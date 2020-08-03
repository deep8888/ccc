package controller.member;

import java.io.UnsupportedEncodingException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import controller.MailAction;
import model.DAO.MemberDAO;
import model.DTO.MemberDTO;

public class MemberOkAction {
	public void execute(HttpServletRequest request) {
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e1) {
					e1.printStackTrace();
		}
		String userEmail = request.getParameter("userEmail");
		String userPw = request.getParameter("userPw");
		String userName = request.getParameter("userName");
		String userAddr = request.getParameter("userAddr");
		String userPh1 = request.getParameter("userPh1");
		
		MemberDTO dto = new MemberDTO();
		dto.setUserEmail(userEmail);
		dto.setUserName(userName);
		dto.setUserPw(userPw);
		dto.setUserAddr(userAddr);
		dto.setUserPh1(userPh1);
		
		MemberDAO dao = new MemberDAO();
		Integer i = dao.memberInsert(dto);
		if (i != null) {
			MailAction mail = new MailAction();
			mail.sendMail(dto);
		}
		
	}
	}
