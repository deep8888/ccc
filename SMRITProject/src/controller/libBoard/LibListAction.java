package controller.libBoard;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import controller.PageAction;
import model.DAO.LibBoardDAO;
import model.DTO.LibBoardDTO;

public class LibListAction {
   public void excute(HttpServletRequest request) {
	 //페이징코드
	   int page = 1;
		if (request.getParameter("page")!= null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		int limit = 10;
		int limitPage = 10;
		//end 
	   String num = null;
      LibBoardDAO dao = new LibBoardDAO();
      List<LibBoardDTO> list = dao.libSelectAll(page, limit, num);
      request.setAttribute("list", list);
      
      int count = dao.libCount();
      request.setAttribute("libCount", count);
      
      PageAction pageAction = new PageAction();
		pageAction.page(request, count, limit, limitPage, page, "libBoardList.lib?");
		
   }
}