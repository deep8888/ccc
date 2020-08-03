package controller.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.DAO.MemberDAO;

public class MemberUserDelAction {
	public void execute(HttpServletRequest request) {
		HttpSession session = request.getSession();
		String userEmail = (String)session.getAttribute("logEmail");
		String userPw = request.getParameter("userPw");
		MemberDAO dao = new MemberDAO();
		dao.userMemberDel(userEmail, userPw);
		
	}
}
