package controller.Resume;

import javax.servlet.http.HttpServletRequest;

import model.DAO.ResumebackendDAO;
import model.DTO.ResumebackendDTO;

public class ResumsInfoModifyAction {
	public void execute(HttpServletRequest request) {
		String yesNo =  request.getParameter("yesNo");
		
		ResumebackendDTO dto = new ResumebackendDTO();
		dto.setYesNo(yesNo);
		
		ResumebackendDAO  dao = new ResumebackendDAO();
		dao.ResumeUpdate(dto);
		
	}
}
