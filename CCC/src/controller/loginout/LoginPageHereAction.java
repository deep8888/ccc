package controller.loginout;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.DAO.MemberDAO;
import model.DTO.MemberDTO;

public class LoginPageHereAction {
	public void execute(HttpServletRequest request) {
		String logPage = request.getHeader("referer");
		request.setAttribute("logPage", logPage);	
		HttpSession session = request.getSession();
		String userEmail= (String)session.getAttribute("logEmail");
		if (userEmail != null) {
			MemberDAO dao = new MemberDAO();
			List<MemberDTO> list = dao.loginSelect(userEmail);
			request.setAttribute("memberDTO", list.get(0));
		}
		
		
		}
}
