package controller.member;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

import controller.PassMailAction;
import controller.RamdomPassword;
import model.DAO.MemberDAO;
import model.DTO.MemberDTO;

public class PassCkProAction {

	public Integer execute(HttpServletRequest request) {
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e1) {
					e1.printStackTrace();
		}
		String userName = request.getParameter("userName");
		String userEmail= request.getParameter("userEmail");
		String userPh1 = request.getParameter("userPh1");
		String userPw = RamdomPassword.getRamdomPassword(6);
		System.out.println(userPw);
		MemberDTO dto = new MemberDTO();
		dto.setUserPw(userPw);
		dto.setUserName(userName);
		dto.setUserEmail(userEmail);
		dto.setUserPh1(userPh1);
		MemberDAO dao = new MemberDAO();
		String userPass = dao.checkPass(userName,userEmail,userPh1);
		request.setAttribute("userPass", userPass);
		Integer i = dao.checkPassInsert(dto);
		
		if(userPass == null) {
			return i;
		}else {
			i =1;
			if (i != null) {
				PassMailAction mail = new PassMailAction();
				mail.sendMail(dto);
			}
			return i;
		}
	}
	
}
