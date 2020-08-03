package controller.creatorCenter;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import controller.PageAction;
import model.DAO.BoardCreateDAO;
import model.DTO.BoardCreateDTO;

public class BoardCreateSelect {
	public void execute(HttpServletRequest request) {
		// 페이징코드
		int page = 1;
		if (request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		int limit = 10;
		int limitPage = 10;
		// end
		BoardCreateDAO dao = new BoardCreateDAO();
		List<BoardCreateDTO> list = dao.crSelectAll(page, limit);
		request.setAttribute("listSet", list);

		int count = dao.crCount();
		request.setAttribute("crCount", count);
		PageAction pageAction = new PageAction();
		pageAction.page(request, count, limit, limitPage, page, "CreatBoard.cen?");

	}
}
