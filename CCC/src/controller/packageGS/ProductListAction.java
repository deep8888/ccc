package controller.packageGS;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.DAO.ProductDAO;
import model.DTO.ProductDTO;

public class ProductListAction {
	public void execute(HttpServletRequest request) {
		HttpSession session=request.getSession();
		String classesNum=request.getParameter("classesNum");
		ProductDAO dao = new ProductDAO();
		List<ProductDTO> list = dao.productSelectAll(classesNum);
		request.setAttribute("list1234", list);
		System.out.println(list.size());
		request.setAttribute("classesNum", classesNum);
		
	}
}
