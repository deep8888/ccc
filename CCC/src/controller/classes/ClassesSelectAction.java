package controller.classes;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import model.DAO.ClassesDAO;
import model.DTO.ClassesDTO;

public class ClassesSelectAction {
	public void execute(HttpServletRequest request) {
		ClassesDAO dao = new ClassesDAO();
		List<ClassesDTO> list = dao.ClassesSelect(null);
		request.setAttribute("list", list);
		List<ClassesDTO> Notlist = dao.ClassesSelectNotOpen();
		request.setAttribute("NotOpenlist", Notlist);

	
	}

}
