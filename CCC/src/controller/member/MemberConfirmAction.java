package controller.member;

import javax.servlet.http.HttpServletRequest;

import model.DAO.MemberDAO;

public class MemberConfirmAction {
	public void execute(HttpServletRequest request) {
		String userEmail=request.getParameter("userEmail");
		MemberDAO dao=new MemberDAO();
		String confirmEmail=dao.memberConfirm(userEmail);
		request.setAttribute("userEmail", userEmail);
		request.setAttribute("confirmEmail", confirmEmail);
		
	}
}
