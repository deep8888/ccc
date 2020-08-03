package controller.creative;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.catalina.connector.Response;

import model.DAO.MemberDAO;
import model.DAO.NoticeBoardDAO;
import model.DTO.MemberDTO;
import model.DTO.NoticeBoardDTO;

public class CreativeStartAction {
	public void execute(HttpServletRequest request) {
		
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e1) {
					e1.printStackTrace();
		}
		HttpSession session = request.getSession();
		String userEmail= (String)session.getAttribute("logEmail");
		
		
		MemberDAO dao = new MemberDAO();
		MemberDTO dto = dao.CrSelect(userEmail);
		request.setAttribute("memberDTO", dto);
		
			
		
	}
}
