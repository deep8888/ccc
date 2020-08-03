package controller.creatorCenter;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.DAO.ClassesDAO;
import model.DAO.ClassesListDAO;
import model.DTO.ClassesListDTO;

public class ClassAddURL {
	public String excute(HttpServletRequest request) {
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HttpSession session = request.getSession();

		String[] classListSubject = request.getParameterValues("classListSubject");
		String[] classUrl = request.getParameterValues("classUrl");
		String[] classListNum = request.getParameterValues("classOrderNum");
		String classNum = (String) session.getAttribute("classNum");
		String userEmail = (String) session.getAttribute("logEmail");
		System.out.println("classNum : " + classNum);

		String[] cln = request.getParameterValues("classOrderNum2");
		String[] cLS = request.getParameterValues("classListSubject2");
		String[] cU = request.getParameterValues("classUrl2");
		
		ClassesListDAO dao = new ClassesListDAO();
		Integer rel = dao.classesListYn(classNum);
        	       
		if (rel == 0) {
			for (int i = 0; i <= classListNum.length - 1; i++) {
				dao.ClassListAdd(classUrl[i], classListSubject[i], classListNum[i], classNum);
			}
		}
		else if (classListNum != null) {
			for (int i = 0; i <= classListNum.length - 1; i++) {
				
				dao.ClassListUpdate(classUrl[i], classListSubject[i], classListNum[i], classNum);
			}
		}
		
		if (cln != null) {
			for (int i = 0; i <= cln.length-1; i++) {
  				dao.ClassListAdd2(cU[i], cLS[i], cln[i], classNum);
  			}
  		}
	    	
		  
		

		ClassesDAO sDao = new ClassesDAO();
		sDao.ClassStepUpdate(userEmail, classNum, 2);

		request.setAttribute("stepChk", 2);

		return classNum;
	}
}
