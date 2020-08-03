package controller.creatorCenter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.DAO.CreativeDAO;
import model.DTO.CreativeDTO;

public class CreatorInfoSelect {
	public void excute(HttpServletRequest request) {
		HttpSession session = request.getSession();
		String userEmail = (String) session.getAttribute("logEmail");
		CreativeDTO creDto = new CreativeDTO();
		CreativeDAO dao = new CreativeDAO();
		creDto = dao.CreatorInfoSelect(userEmail);
		
		System.out.println("크리에이터 저장 return 받은 값");
		System.out.println("닉네임: "+creDto.getCreatorNname());
		System.out.println("번호: "+creDto.getCreatorPh1());
		
		session.setAttribute("creDto", creDto);
	}
}
