package controller.Resume;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import model.DAO.ResumebackendDAO;
import model.DTO.ResumebackendDTO;

public class ResumeListAction {
 public void execute(HttpServletRequest request) {
	 String resumeNum = request.getParameter("resumeNum");
	 ResumebackendDAO dao = new  ResumebackendDAO();
	 List<ResumebackendDTO> list = dao.resumeSelect(resumeNum);
	 request.setAttribute("list", list);
	 System.out.println(list.size());
 }
}
