package controller.creatorCenter;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.DAO.BoardCreateDAO;
import model.DTO.BoardCreateDTO;

public class BoardOptionAction {
	public void execute(HttpServletRequest request) {
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e1) {
					e1.printStackTrace();
		}
		HttpSession session = request.getSession();
		String boardNum = request.getParameter("boardNum");
		String boardStep = request.getParameter("step");
		if (boardStep.equals("일반")) {
			boardStep= null;
		}
		System.out.println(boardStep);
		System.out.println(boardNum);
		BoardCreateDTO dto = new BoardCreateDTO();
		dto.setBoardStep(boardStep);
		dto.setBoardNum(Long.parseLong(boardNum));
	
		
		BoardCreateDAO dao = new BoardCreateDAO();
		dao.BoardStepUpdate(dto);
	}
}
