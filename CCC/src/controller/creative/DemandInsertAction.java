package controller.creative;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.DAO.CreativeDAO;

public class DemandInsertAction {
	public void execute(HttpServletRequest request) {
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e1) {
					e1.printStackTrace();
		}
		HttpSession session = request.getSession();
		String userEmail = (String)session.getAttribute("logEmail");
		String demandOk = "수요조사완료";
		CreativeDAO dao = new CreativeDAO();
		dao.demandInsert(userEmail,demandOk);
		
		
}

	
	}
