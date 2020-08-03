package controller.notBoard;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import controller.PageAction;
import model.DAO.NoticeBoardDAO;
import model.DTO.NoticeBoardDTO;

public class NoticeListAction {
   public void excute(HttpServletRequest request) {
	 //페이징코드
	 		int page = 1;
	 		if (request.getParameter("page")!= null) {
	 			page = Integer.parseInt(request.getParameter("page"));
	 		}
	 		int limit = 10;
	 		int limitPage = 10;
	 		//end
      NoticeBoardDAO dao = new NoticeBoardDAO();
      List<NoticeBoardDTO> list = dao.notSelectAll(page, limit);
      request.setAttribute("listSet", list);
      
      int count = dao.notCount();
      request.setAttribute("notCount", count);
      PageAction pageAction = new PageAction();
		pageAction.page(request, count, limit, limitPage, page, "notList.not?");
   }
}