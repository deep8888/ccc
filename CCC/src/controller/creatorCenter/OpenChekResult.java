package controller.creatorCenter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.DAO.ClassesDAO;
import model.DAO.CreativeDAO;

public class OpenChekResult {
	public void excute(HttpServletRequest request) {
		HttpSession session = request.getSession();
		
		String userEmail = (String) session.getAttribute("logEmail");
		String classNum = (String) session.getAttribute("classNum");
		CreativeDAO dao = new CreativeDAO();
		Integer i = dao.OpenCheckResUpdate(userEmail, classNum);
		if(i>0) {
			System.out.println("세션 업데이트 --> "+i);
			session.setAttribute("openRes", true);
		}
		
		ClassesDAO sDao = new ClassesDAO();
		sDao.ClassStepUpdate(userEmail, classNum, 4);
		session.setAttribute("stepChk", 4);
	}
}
