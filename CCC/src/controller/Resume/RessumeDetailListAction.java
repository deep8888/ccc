package controller.Resume;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;

import model.DAO.ResumebackendDAO;
import model.DTO.ResumebackendDTO;

public class RessumeDetailListAction {  //합격여부 
	public String execute(HttpServletRequest request) {
		
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		String resumeNum = null;
		String yesNo = null;
	
		//HttpSession session = request.getSession();
		//String userEmail = (String) session.getAttribute("logEmail");
		ResumebackendDAO dao = new ResumebackendDAO();
		ResumebackendDTO dto = new ResumebackendDTO();
	
		try {
			resumeNum = request.getParameter("resumeNum");
			System.out.println(resumeNum);
			yesNo = request.getParameter("yesNo");
			System.out.println(yesNo);
			dto.setResumeNum(Long.parseLong(resumeNum));
			dto.setYesNo(yesNo);
			dao.resumeYesNoUpdate(dto);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resumeNum;
	}
		

}
