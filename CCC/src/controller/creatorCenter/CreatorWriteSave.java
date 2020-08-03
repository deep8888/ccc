package controller.creatorCenter;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import model.DAO.ClassesDAO;
import model.DAO.CreativeDAO;
import model.DTO.CreativeDTO;

public class CreatorWriteSave {
	public void excute(HttpServletRequest request) {
		String filePath = "/creatorCenter/upload";
		String realPath = request.getServletContext().getRealPath(filePath);
		int fileSize = 1024*1025*5;
		
		HttpSession session = request.getSession();
		String userEmail = (String) session.getAttribute("logEmail");
		String classNum = (String) session.getAttribute("classNum");
		System.out.println("크리에이터 정보 수정 userEmail : "+userEmail);
		CreativeDTO dto = new CreativeDTO();
		CreativeDAO dao = new CreativeDAO();
		MultipartRequest multi = null;
		try {
			multi = new MultipartRequest(request, realPath, fileSize, "UTF-8", new DefaultFileRenamePolicy());
			//dto.setUserEmail(userEmail);
			dto.setCreatorNname(multi.getParameter("creatorNname"));
			dto.setCreatorIntro(multi.getParameter("creatorIntro"));
			dto.setCreatorPh1(multi.getParameter("creatorPh"));
			dto.setUserEmail(userEmail);
			if(multi.getFile("creatorImg") != null) {
				dto.setCreatorPhoto(multi.getFilesystemName("creatorImg"));
				int i = dao.fileUpdate(dto);
			/*
			 * File file = null; if(i >= 1) { String fileName = realPath + "/" +
			 * multi.getParameter("fileDel"); file = new File(fileName);
			 * if(file.exists())file.delete(); else System.out.println("파일이 없슴."); }
			 */
			}else {
				System.out.println("파일 null");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ClassesDAO sDao = new ClassesDAO();
		sDao.ClassStepUpdate(userEmail, classNum, 3);
		session.setAttribute("stepChk", 3);
		
		dao.CreatorWriteSave(dto);
	}
}
