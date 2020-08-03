package controller.member;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.DAO.MemberDAO;
import model.DTO.MemberDTO;

public class MemberDetailAction {
	public void execute(HttpServletRequest request) {
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e1) {
					e1.printStackTrace();
		}
		HttpSession session = request.getSession();
		String userEmail= (String)session.getAttribute("logEmail");
		MemberDAO dao = new MemberDAO();
		List<MemberDTO> list = dao.memberSelect(1,1,userEmail);
		request.setAttribute("memberDTO", list.get(0));
		request.setAttribute("userEmail", userEmail);
	}
}
