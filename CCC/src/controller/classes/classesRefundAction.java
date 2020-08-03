package controller.classes;

import javax.servlet.http.HttpServletRequest;

import model.DAO.ClassesDAO;

public class classesRefundAction {
	public void execute(HttpServletRequest request) {
		String purchaseNum=request.getParameter("purchaseNum");
		ClassesDAO dao=new ClassesDAO();
		dao.purchaseRefund(purchaseNum);
		
		
	}

}
