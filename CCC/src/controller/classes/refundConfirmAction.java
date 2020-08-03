package controller.classes;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import model.DAO.ClassesDAO;
import model.DTO.PurchaseDTO;

public class refundConfirmAction {
	public void execute(HttpServletRequest request) {
		ClassesDAO dao=new ClassesDAO();
		List<PurchaseDTO> list= dao.purchaseSelectAll();
		request.setAttribute("refundlist", list);
		List<PurchaseDTO> list2= dao.purchaseSelectAll2();
		request.setAttribute("refundlist2", list2);
		
		String purchaseNum=request.getParameter("purchaseNum");
		dao.submitOk(purchaseNum);
		
		
		
		
	}

}
