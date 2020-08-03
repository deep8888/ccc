package controller.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.DAO.MemberDAO;

public class PwModifyProAction {
	public Integer execute(HttpServletRequest request) {
		HttpSession session = request.getSession();
		String userEmail = (String)session.getAttribute("logEmail");
		String userPw = request.getParameter("pw");
		String newPw = request.getParameter("newPw");
		
		MemberDAO dao = new MemberDAO();
		Integer i = dao.passUpdate(userEmail, userPw, newPw);
		return i;
		
		
	}
}
