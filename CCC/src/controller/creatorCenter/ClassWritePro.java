package controller.creatorCenter;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import model.DAO.ClassesDAO;
import model.DTO.ClassesDTO;

public class ClassWritePro {
	public String excute(HttpServletRequest request) {
		String filePath = "/creatorCenter/upload";
		String realPath = request.getServletContext().getRealPath(filePath);
		int fileSize = 1024*1024*5;
		
		
		HttpSession session = request.getSession();
		String userEmail = (String) session.getAttribute("logEmail");
		String classNum = (String) session.getAttribute("classNum");
		System.out.println("---기본정보 수정---");
		System.out.println(classNum);
		ClassesDTO dto = new ClassesDTO();
		ClassesDAO dao = new ClassesDAO();
		MultipartRequest multi = null;
		try {
			multi = new MultipartRequest(request, realPath, fileSize,"UTF-8", new DefaultFileRenamePolicy());
			// 클래스 영상 등록 처리시에만 ClassesListDTO에 세팅
			System.out.println("== 기본정보 저장  ==");
			System.out.println(multi.getFilesystemName("classesPhoto"));
				dto.setClassesSubject(multi.getParameter("classSubject"));
				dto.setClassesPhoto(multi.getParameter("classImg"));
				dto.setClassesContent(multi.getParameter("classContent"));
				dto.setClassCategory(multi.getParameter("classCategory"));
				dto.setClassSubMent(multi.getParameter("classSubMent"));
				dto.setClassesPrice(Long.parseLong(multi.getParameter("classPrice")));
				dto.setClassesNum(classNum);
				dto.setUserEmail(userEmail);
				classNum = dao.ClassWritePro(dto);
				if(multi.getFile("classesPhoto") != null) {
					dto.setClassesPhoto(multi.getFilesystemName("classesPhoto"));
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
		dao.ClassStepUpdate(userEmail, classNum, 1);
		session.setAttribute("stepChk", 1);
		
		return classNum;
	}
}
