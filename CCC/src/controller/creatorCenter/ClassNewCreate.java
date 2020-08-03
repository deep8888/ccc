package controller.creatorCenter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.DAO.ClassesDAO;

public class ClassNewCreate {
	public void excute(HttpServletRequest request) {
		String filePath = "/creatorCenter/upload";
		String realPath = request.getServletContext().getRealPath(filePath);
		int fileSize = 1024*1024*5;
		
		HttpSession session = request.getSession();
		String userEmail = (String) session.getAttribute("logEmail");
		if(userEmail != null) {
			ClassesDAO dao = new ClassesDAO();
			String claNum = dao.ClassNewCreate(userEmail);
			session.setAttribute("classNum", claNum);
		}
	}
}
