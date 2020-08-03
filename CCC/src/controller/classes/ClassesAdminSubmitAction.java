package controller.classes;

import javax.servlet.http.HttpServletRequest;

import model.DAO.ClassesDAO;

public class ClassesAdminSubmitAction {
	public void execute(HttpServletRequest request) {
		String classesNum=request.getParameter("classesNum");
		ClassesDAO dao=new ClassesDAO();
		dao.classesAdminSubmit(classesNum);
		
	}

}
