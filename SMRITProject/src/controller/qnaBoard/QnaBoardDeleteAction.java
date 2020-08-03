package controller.qnaBoard;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.DAO.QnaBoardDAO;
import model.DTO.QnaBoardDTO;

public class QnaBoardDeleteAction {
	public void execute(HttpServletRequest request) {
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e1) {
					e1.printStackTrace();
		}
			
		HttpSession session = request.getSession();
		String userId= (String)session.getAttribute("logId");
		String boardNum = request.getParameter("boardNum");
		String boardPass = request.getParameter("boardPass");
		
		QnaBoardDTO dto = new QnaBoardDTO();
		
		dto.setBoardNum(Long.parseLong(boardNum));
		dto.setBoardPass(boardPass);
		dto.setUserId(userId);
		
		QnaBoardDAO dao = new QnaBoardDAO();
		dao.qnaDelete(dto);
		
		
		
	}
}
