package controller.member;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

import model.DAO.MemberDAO;
import model.DTO.MemberDTO;

public class EmailCkProAction {

	public Integer execute(HttpServletRequest request) {
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e1) {
					e1.printStackTrace();
		}
		int i = 0;
		String userName = request.getParameter("userName");
		System.out.println(userName);
		String userPh1 = request.getParameter("userPh1");
		System.out.println(userPh1);
		MemberDAO dao = new MemberDAO();
		String userEmail = dao.checkEmail(userName,userPh1);
		request.setAttribute("userEmail", userEmail);
		if(userEmail == null) {
			return i;
		}else {
			i =1;
			return i;
		}
	}
	
}
