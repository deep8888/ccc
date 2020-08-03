package controller.Resume;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import model.DAO.ResumebackendDAO;
import model.DTO.ResumebackendDTO;

public class ResumeWriteActtion {
	public void execute(HttpServletRequest request) {
		try {
			request.setCharacterEncoding("utf-8");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		String filePath = "/Resume/upload";
		String realPath = request.getServletContext().getRealPath(filePath);
		int fileSize= 1024*1024*5;
		ResumebackendDTO dto = new ResumebackendDTO();
		String ipAddr = request.getRemoteAddr();
		HttpSession session = request.getSession();
		String resumeEmail = (String)session.getAttribute("logEmail");
		try {
			MultipartRequest multi = new MultipartRequest(request, realPath, fileSize, "utf-8", new DefaultFileRenamePolicy());
			dto.setResumeName(multi.getParameter("ResumeName"));
			dto.setResumeEmail(multi.getParameter("ResumeEmail"));
			dto.setResumePhcon(multi.getParameter("ResumePhCon"));
			dto.setResumeContent(multi.getParameter("ResumeContent"));
			dto.setGithubUrl(multi.getParameter("githubURL"));
			dto.setPortUrl(multi.getParameter("portURL"));
			dto.setDepartmentName(multi.getParameter("departmentName"));
			dto.setIpAddr(ipAddr);
			dto.setOriginalFileName(multi.getOriginalFileName("fileUp"));
			dto.setStoreFileName(multi.getFilesystemName("fileUp"));
			dto.setYesNo(multi.getParameter("YesNo"));
			File file=multi.getFile("fileUp");
			dto.setFileSize(file.length());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		ResumebackendDAO dao = new ResumebackendDAO();
		dao.resInsert(dto);
	}
}
