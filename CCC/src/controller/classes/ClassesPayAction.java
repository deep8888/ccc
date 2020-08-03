package controller.classes;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import model.DAO.ClassesDAO;
import model.DTO.ClassesDTO;

public class ClassesPayAction {
	public void execute(HttpServletRequest request) {
		ClassesDAO dao=new ClassesDAO();
		List<ClassesDTO> list=dao.ClassesSelect(null);
		request.setAttribute("list", list);
		String packages=request.getParameter("packages");
		request.setAttribute("packages", packages);
		
		
	}

}
