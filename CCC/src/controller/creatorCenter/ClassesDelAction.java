package controller.creatorCenter;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.DAO.ClassesDAO;
import model.DAO.ProductDAO;
import model.DTO.ClassesDTO;

public class ClassesDelAction {
	public void execute(HttpServletRequest request) {
		HttpSession session = request.getSession();
		String logEmail = (String) session.getAttribute("logEmail");
		String classesNum = request.getParameter("classesNum");
		ProductDAO pdao = new ProductDAO();
		//pdao.productDel(classesNum);
		// 상품삭제
		
		ClassesDAO cdao=new ClassesDAO();
		cdao.classesListDel(classesNum);
		// 클래스 리스트 삭제
		
		ClassesDTO dto=cdao.ClassesSelectUser(logEmail,classesNum).get(0);
		int i=cdao.classesDel(classesNum);
		File file=null;
		String path=request.getServletContext().getRealPath("/creatorCenter/upload");
		if(i>=1) {
			file=new File(path+"/"+dto.getClassesPhoto());
			if(file.exists()) {
				file.delete();
			}
		}
		 

	}

}
