package controller.creative;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.DAO.CreativeDAO;
import model.DTO.CreativeDTO;

public class CreativeDetailAction {
	public void execute(HttpServletRequest request) {
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e1) {
					e1.printStackTrace();
		}
		
		//Email,전화번호 컬럼은 FK로 가져옴 
		//디비가 완성되지 않아 임시 테스트로 별개로 추가함.
		HttpSession session = request.getSession();
		String userEmail= (String)session.getAttribute("logEmail");
		String userPh1 = request.getParameter("userPh1");
		String applyPath = request.getParameter("applyPath");
		
		System.out.println(userEmail);
		System.out.println(userPh1);
		System.out.println(applyPath);
		
		CreativeDTO dto = new CreativeDTO();
		dto.setUserPh1(userPh1);
		dto.setApplyPath(applyPath);
		dto.setUserEmail(userEmail);
				
		CreativeDAO dao = new CreativeDAO();
		dao.creativeUpdate(dto);
		
	}
}
