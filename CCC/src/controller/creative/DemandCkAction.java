package controller.creative;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.DAO.CreativeDAO;

public class DemandCkAction {
	public Integer execute(HttpServletRequest request) {
		Integer i = 0;
		HttpSession session = request.getSession();
		String userEmail = (String)session.getAttribute("logEmail");
		
		CreativeDAO dao = new CreativeDAO();
		i = dao.demandCk(userEmail);
		return i;
}

	
	}
