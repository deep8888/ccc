package controller.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.DAO.MemberDAO;

public class PwModifyAction {
	public Integer execute(HttpServletRequest request) {
		Integer i = 0;
		HttpSession session = request.getSession();
		String userEmail = (String)session.getAttribute("logEmail");
		String userPw = request.getParameter("userPw");
		MemberDAO dao = new MemberDAO();
		i = dao.memberLoginCk(userEmail, userPw); //재사용 
		return i;
	}
}
