package controller.classes;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.DAO.ClassesDAO;
import model.DTO.ClassesDTO;
import model.DTO.PurchaseDTO;

public class ClassesPurchaseAction {
	public void execute(HttpServletRequest request) {
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String classesNum=request.getParameter("classesNum");
		String purchasePrice=request.getParameter("classesPrice");
		HttpSession session=request.getSession();
		String userEmail=(String) session.getAttribute("logEmail");
		PurchaseDTO dto=new PurchaseDTO();
		dto.setUserEmail(userEmail);
		dto.setClassesNum(classesNum);
		dto.setPurchasePrice(Long.parseLong(purchasePrice));
		
		ClassesDAO dao=new ClassesDAO();
		dao.purchaseInsert(dto);
		
		// buy_count 올리기
		ClassesDTO cdto=new ClassesDTO();
		cdto.setClassesNum(classesNum);
		dao.buyCountUp(cdto);
		
		
	}

}
