package controller.creatorCenter;

import javax.servlet.http.HttpServletRequest;

import model.DAO.BoardCreateDAO;
import model.DTO.BoardCreateDTO;

public class BoardCreateDetailAction {
	public void execute(HttpServletRequest request) {
		String num = request.getParameter("num");
		
		BoardCreateDAO dao = new BoardCreateDAO();
		dao.updateReadCount(num, "boardcreate");
		BoardCreateDTO dto = dao.cenOneSelect(num);
		request.setAttribute("dto", dto);
				
	}
}
