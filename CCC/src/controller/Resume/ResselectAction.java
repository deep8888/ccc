package controller.Resume;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

import model.DAO.ResumebackendDAO;
//컨트롤러 먼저 만들고 페이지 연결 , 액션만들고 거기에 이름과 전화번호 받아온거를 가지고 디비 검색  ,파리미터 값 받아오고  파라미터 값을 컨트롤러에서 if문으로 ex dao오에서 if 로 해서 0이나 1로 인트값으로 주고 
//1이면 합격 0이면 불합격으로 만들것 
public class ResselectAction {
	public void execute(HttpServletRequest request) {
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		int i = 0;
		String resumeName = request.getParameter("ResumeName");
		System.out.println(resumeName);
		String resumePhcon = request.getParameter("resumePhcon");
		System.out.println(resumePhcon);
		String departmentName = request.getParameter("departmentName");
		ResumebackendDAO dao = new ResumebackendDAO();
		String YesNo = dao.checkYesNo(resumeName,resumePhcon,departmentName);
		request.setAttribute("YesNo", YesNo);
		i++;
	}
}
