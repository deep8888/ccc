package controller.notBoard;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.DAO.NoticeBoardDAO;
import model.DTO.NoticeBoardDTO;

public class NoticeBoardDeleteAction {
	public void execute(HttpServletRequest request) {
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e1) {
					e1.printStackTrace();
		}
			
		HttpSession session = request.getSession();
		String userEmail= (String)session.getAttribute("logEmail");
		String boardNum = request.getParameter("boardNum");
		String boardPass = request.getParameter("boardPass");
		
		NoticeBoardDTO dto = new NoticeBoardDTO();
		
		dto.setBoardNum(Long.parseLong(boardNum));
		dto.setBoardPass(boardPass);
		dto.setUserEmail(userEmail);
		
		NoticeBoardDAO dao = new NoticeBoardDAO();
		dao.notDelete(dto);
		
		
		
	}
}
