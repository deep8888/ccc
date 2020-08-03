package controller.classes;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.DAO.ClassesDAO;
import model.DTO.ClassesListDTO;
import model.DTO.PurchaseDTO;

public class PurchaseListAction {
	public void execute(HttpServletRequest request) {
		HttpSession session=request.getSession();
		String userEmail=(String) session.getAttribute("logEmail");
		ClassesDAO dao=new ClassesDAO();
		List<PurchaseDTO> list=dao.purchaseSelect(userEmail,null);
		request.setAttribute("list", list);
		
		
		
		
		
	}

}
