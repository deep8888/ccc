package controller.member;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

import model.DAO.MemberDAO;
import model.DTO.MemberDTO;

public class MemberModifyAction {
		public void execute(HttpServletRequest request) {
			try {
				request.setCharacterEncoding("utf-8");
			} catch (UnsupportedEncodingException e1) {
						e1.printStackTrace();
			}
			String userEmail = request.getParameter("userEmail");
			String userAddr = request.getParameter("userAddr");
			String userPh1 = request.getParameter("userPh1");
		
			MemberDTO dto = new MemberDTO();
			dto.setUserAddr(userAddr);
			dto.setUserEmail(userEmail);
			dto.setUserPh1(userPh1);
			
			
			MemberDAO dao = new MemberDAO();
			dao.memberUpdate(dto);
			
			
			
		}
		
}
