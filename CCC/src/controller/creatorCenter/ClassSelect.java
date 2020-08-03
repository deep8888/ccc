package controller.creatorCenter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.DAO.ClassesDAO;
import model.DTO.ClassesDTO;

public class ClassSelect {
	public void excute(HttpServletRequest request) {
		String classNum ="";
		HttpSession session = request.getSession();
		System.out.println("클래스넘버(request) : "+request.getParameter("classesNum"));
		// classNum 세팅
		if(request.getParameter("classesNum") != null) {
			classNum = request.getParameter("classesNum");	
			session.setAttribute("classNum", classNum);
		}else {
			classNum = (String) session.getAttribute("classNum");
		}
		String userEmail = (String) session.getAttribute("logEmail");
		ClassesDAO dao = new ClassesDAO();
		ClassesDTO dto = dao.classSingleSelect(userEmail, classNum);
		
		System.out.println("ClassSelect == request classNum 세팅 : "+ classNum);
		session.setAttribute("cla", dto);
	}
}
