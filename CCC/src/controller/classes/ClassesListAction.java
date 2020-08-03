package controller.classes;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.DAO.ClassesDAO;
import model.DTO.ClassesListDTO;
import model.DTO.ClassesListPackageDTO;

public class ClassesListAction {
	public void execute(HttpServletRequest request) {
		
		String classesNum=request.getParameter("classesNum");
		String classesListNum=request.getParameter("classesListNum");
		ClassesDAO dao=new ClassesDAO();
		ClassesListPackageDTO dto=dao.ClassesListSelect(classesNum);
		request.setAttribute("clpdto", dto);
		List<ClassesListDTO> cllist=dao.ClassesListSelectAll(classesListNum);
		request.setAttribute("cllist", cllist);
	}

}
