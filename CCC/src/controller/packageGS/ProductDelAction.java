package controller.packageGS;

import javax.servlet.http.HttpServletRequest;

import model.DAO.ProductDAO;

public class ProductDelAction {
	public void execute(HttpServletRequest request) {
		String classesNum=request.getParameter("classesNum");
		String productNum=request.getParameter("productNum");
		ProductDAO dao=new ProductDAO();
		dao.productDel(classesNum, productNum);
		
	}

}
