package controller.creatorCenter;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.DAO.ClassesListDAO;
import model.DTO.ClassesListDTO;

public class ClassListSelect {
	public void excute(HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		String classNum = (String) session.getAttribute("classNum");
		ClassesListDAO listDAO = new ClassesListDAO();
		List<ClassesListDTO> list = listDAO.ClassListSelect(classNum);
		
		session.setAttribute("list", list);
	}
}
