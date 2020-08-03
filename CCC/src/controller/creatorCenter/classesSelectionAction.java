package controller.creatorCenter;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.DAO.ClassesDAO;
import model.DTO.ClassesDTO;
public class classesSelectionAction {
	public void execute(HttpServletRequest request) {
		HttpSession session=request.getSession();
		String userEmail=(String) session.getAttribute("logEmail");
		ClassesDAO dao = new ClassesDAO();
		System.out.println("classesSelectionAction 진입");
		System.out.println(userEmail);
		List<ClassesDTO> list = dao.ClassesSelectUser(userEmail,null);
		request.setAttribute("list", list);
		
		
	}

}
