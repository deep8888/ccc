package controller.creatorCenter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class SessionResetAction {
	public void excute(HttpServletRequest request) throws Exception{
		
		HttpSession session = request.getSession();
		String userEmail = (String) session.getAttribute("logEmail");
		String classNum = (String) session.getAttribute("classNum");
		System.out.println("세션 실행 전 ----");
		System.out.println("변수 userEmail : "+userEmail);
		System.out.println("변수 classNum : "+classNum);
		
		session.invalidate();
		
		
		HttpSession session_2 = request.getSession();
		session_2.setAttribute("logEmail", userEmail);
		session_2.setAttribute("classNum", classNum);
		
		System.out.println(" 세션 초기화 실행 후 ----");
		System.out.println("변수 userEmail : "+userEmail);
		System.out.println("변수 classNum : "+classNum);
		System.out.println("openRes : "+session_2.getAttribute("openRes"));
		System.out.println("logEmail : "+session_2.getAttribute("logEmail"));
		System.out.println("classNum : "+session_2.getAttribute("classNum"));
	}
}
