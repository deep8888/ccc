package controller.qnaBoard;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.catalina.connector.Response;

import model.DAO.QnaBoardDAO;
import model.DTO.QnaBoardDTO;

public class QnaWriteProAction {
	public void execute(HttpServletRequest request) {
		String boardName = request.getParameter("boardName");
		String boardPass = request.getParameter("boardPass");
		String boardSubject = request.getParameter("boardSubject");
		String boardContent= request.getParameter("boardContent");
		HttpSession session = request.getSession();
		String userId= (String)session.getAttribute("logId");
		String ipAddr = request.getRemoteAddr();
		
		QnaBoardDTO dto = new QnaBoardDTO();
		dto.setBoardContent(boardContent);
		dto.setBoardName(boardName);
		dto.setBoardPass(boardPass);
		dto.setBoardSubject(boardSubject);
		dto.setIpAddr(ipAddr);
		dto.setUserId(userId);
		
		QnaBoardDAO dao = new QnaBoardDAO();
		dao.qnaInsert(dto);
		
		
		
	}
}
