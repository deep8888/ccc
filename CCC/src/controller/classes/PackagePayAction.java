package controller.classes;

import javax.servlet.http.HttpServletRequest;

import model.DAO.ClassesDAO;
import model.DTO.PackageDTO;

public class PackagePayAction {
	public void execute(HttpServletRequest request) {
		ClassesDAO dao=new ClassesDAO();
		String classesNum=request.getParameter("classesNum");
		PackageDTO pacdto=dao.packageSelect(classesNum);
		request.setAttribute("pacdto", pacdto);
		String packages=request.getParameter("packages");
		request.setAttribute("packages", packages);
	}

}
