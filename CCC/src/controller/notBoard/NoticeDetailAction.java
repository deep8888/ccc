package controller.notBoard;

import javax.servlet.http.HttpServletRequest;

import model.DAO.NoticeBoardDAO;
import model.DTO.NoticeBoardDTO;

public class NoticeDetailAction {
	public void execute(HttpServletRequest request) {
		String num = request.getParameter("num");
		
		NoticeBoardDAO dao = new NoticeBoardDAO();
		dao.updateReadCount(num, "noticeboard");
		NoticeBoardDTO dto = dao.NotOneSelect(num);
		request.setAttribute("dto", dto);
				
	}
}
