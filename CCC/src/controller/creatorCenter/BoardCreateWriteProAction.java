package controller.creatorCenter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.DAO.BoardCreateDAO;
import model.DTO.BoardCreateDTO;

public class BoardCreateWriteProAction {
	public void execute(HttpServletRequest request) {
		String boardName = request.getParameter("boardName");
		String boardPass = request.getParameter("boardPass");
		String boardSubject = request.getParameter("boardSubject");
		String boardContent= request.getParameter("boardContent");
		HttpSession session = request.getSession();
		String userEmail= (String)session.getAttribute("logEmail");
		String ipAddr = request.getRemoteAddr();
		
		BoardCreateDTO dto = new BoardCreateDTO();
		dto.setBoardContent(boardContent);
		dto.setBoardName(boardName);
		dto.setBoardPass(boardPass);
		dto.setBoardSubject(boardSubject);
		dto.setIpAddr(ipAddr);
		dto.setUserEmail(userEmail);
		
		BoardCreateDAO dao = new BoardCreateDAO();
		dao.crInsert(dto);
		
		
		
	}
}
