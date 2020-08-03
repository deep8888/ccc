package controller.notBoard;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.DAO.NoticeBoardDAO;
import model.DTO.NoticeBoardDTO;

public class NoticeBoardModifyAction {
	public void execute(HttpServletRequest request) {
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e1) {
					e1.printStackTrace();
		}
		HttpSession session = request.getSession();
		String userEmail= (String)session.getAttribute("logEmail");
		String boardNum = request.getParameter("boardNum");
		String boardSubject = request.getParameter("boardSubject");
		String boardContent = request.getParameter("boardContent");
		String boardPass = request.getParameter("boardPass");
		
		NoticeBoardDTO dto = new NoticeBoardDTO();
		
		dto.setBoardContent(boardContent);
		dto.setBoardNum(Long.parseLong(boardNum));
		dto.setBoardPass(boardPass);
		dto.setBoardSubject(boardSubject);
		dto.setUserEmail(userEmail);
		
		NoticeBoardDAO dao = new NoticeBoardDAO();
		dao.notUpdate(dto);
		
		
	}

	}
