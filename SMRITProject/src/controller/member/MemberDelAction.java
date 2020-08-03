package controller.member;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

import model.DAO.MemberDAO;
import model.DTO.MemberDTO;

public class MemberDelAction {
	public void execute(HttpServletRequest request) {
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e1) {
					e1.printStackTrace();
		}
		
		String userId = request.getParameter("userId");
		String userPw = request.getParameter("userPw");
		MemberDTO dto = new MemberDTO();
		dto.setUserId(userId);
		dto.setUserPw(userPw);		
		MemberDAO dao = new MemberDAO();
		dao.memberDelete(dto);
		
		
		
		
}
}
