package controller.creatorCenter;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.DAO.BoardCreateDAO;
import model.DTO.BoardCreateDTO;

public class BoardCreateModifyAction {
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
		
		BoardCreateDTO dto = new BoardCreateDTO();
		
		dto.setBoardContent(boardContent);
		dto.setBoardNum(Long.parseLong(boardNum));
		dto.setBoardPass(boardPass);
		dto.setBoardSubject(boardSubject);
		dto.setUserEmail(userEmail);
		
		BoardCreateDAO dao = new BoardCreateDAO();
		dao.crUpdate(dto);
		
		
	}

	}
