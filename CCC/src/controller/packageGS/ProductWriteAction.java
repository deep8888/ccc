package controller.packageGS;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;

import model.DAO.ProductDAO;
import model.DTO.ProductDTO;

public class ProductWriteAction {
	public String execute(HttpServletRequest request) {
		try {
			request.setCharacterEncoding("utf-8");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		HttpSession session = request.getSession();
		String userEmail=(String) session.getAttribute("logEmail");
		ProductDTO dto = new ProductDTO();
			dto.setClassesNum(request.getParameter("classesNum"));
			dto.setProductContent(request.getParameter("productContent"));
			dto.setProductName(request.getParameter("productName"));
			dto.setProductNum(request.getParameter("productNum"));
			dto.setProductPrice(Long.parseLong(request.getParameter("productPrice")));
			dto.setUserEmail(userEmail);
		
		ProductDAO dao = new ProductDAO();
		dao.productInsert(dto);
	
		return dto.getClassesNum();
	}


	}

