package controller.notBoard;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.catalina.connector.Response;

import model.DAO.NoticeBoardDAO;
import model.DTO.NoticeBoardDTO;

public class NoticeWriteProAction {
	public void execute(HttpServletRequest request) {
		String boardName = request.getParameter("boardName");
		String boardPass = request.getParameter("boardPass");
		String boardSubject = request.getParameter("boardSubject");
		String boardContent= request.getParameter("boardContent");
		HttpSession session = request.getSession();
		String userEmail= (String)session.getAttribute("logEmail");
		String ipAddr = request.getRemoteAddr();
		
		NoticeBoardDTO dto = new NoticeBoardDTO();
		dto.setBoardContent(boardContent);
		dto.setBoardName(boardName);
		dto.setBoardPass(boardPass);
		dto.setBoardSubject(boardSubject);
		dto.setIpAddr(ipAddr);
		dto.setUserEmail(userEmail);
		
		NoticeBoardDAO dao = new NoticeBoardDAO();
		dao.notInsert(dto);
		
		
		
	}
}
