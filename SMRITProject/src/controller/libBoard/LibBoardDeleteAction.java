package controller.libBoard;

import java.io.File;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.DAO.LibBoardDAO;
import model.DTO.LibBoardDTO;

public class LibBoardDeleteAction {
	public void execute(HttpServletRequest request) {
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}

		String boardNum = request.getParameter("num");
	 System.out.println(boardNum);
		LibBoardDAO dao = new LibBoardDAO();
		LibBoardDTO dto = dao.libSelectAll(1, 1, boardNum).get(0);
		int i = dao.libBoardDel(boardNum);
		
		File file = null;
		String path = request.getServletContext().getRealPath("/lib_Board/upload");
		if (i >= 1) { // 파일삭제
			file = new File(path + "/" + dto.getStoreFileName());
			if (file.exists()) {
				file.delete();
			}
		}

	}

}
