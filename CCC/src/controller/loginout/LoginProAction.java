package controller.loginout;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.DAO.MemberDAO;

public class LoginProAction {

	public void execute(HttpServletRequest request, HttpServletResponse response) {

		String logPage = request.getParameter("logPage");

		String userEmail = request.getParameter("userEmail");
		String userPw = request.getParameter("userPw");
		MemberDAO dao = new MemberDAO();
		Integer i = dao.memberLoginCk(userEmail, userPw);
		Integer master = dao.masterLoginCk(userEmail);

		System.out.println(master);
		HttpSession session = request.getSession();
		// 관리자계정 로그인
		if (i >= 1 && master >= 1) {
			session.setAttribute("logEmail", userEmail);
			session.setAttribute("logMaster", userEmail);
			// 쿠키생성
			String idStore = request.getParameter("idStore");
			String autologin = request.getParameter("autologin");
			System.out.println(autologin);
			System.out.println(idStore);
			if (autologin != null && autologin.equals("auto")) {
				Cookie cookie = new Cookie("autologin", userEmail);
				cookie.setPath("/");
				cookie.setMaxAge(60 * 60 * 24 * 30); // 쿠기 유통기한
				response.addCookie(cookie);
			}
			if (idStore != null && idStore.equals("store")) {
				Cookie cookie = new Cookie("idStore", userEmail);
				cookie.setPath("/");
				cookie.setMaxAge(60 * 60 * 24 * 30); // 쿠기 유통기한
				response.addCookie(cookie);
				// 쿠키 생성완료
			} else {
				Cookie cookie = new Cookie("idStore", userEmail);
				cookie.setPath("/");
				cookie.setMaxAge(0); // 쿠기 유통기한
				response.addCookie(cookie);
			}
			response.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=utf-8");

			/*try {
				PrintWriter out = response.getWriter();

				out.print("<script>");
				if (master >= 1) {
					out.print("alert('관리자계정으로 로그인 했습니다.');");
					
				}
				out.print("location.href='memberLogin.ccc'");
				out.print("</script>");
				out.close();

			} catch (Exception e) {
				e.printStackTrace();
			}*/

			try {
				response.sendRedirect(logPage);

			} catch (IOException e) {
				e.printStackTrace();
			}

		}

		// 일반 로그인
		else if (i >= 1 && master == 0) {
			session.setAttribute("logEmail", userEmail);
			// 쿠키생성
			
			String idStore = request.getParameter("idStore");
			String autologin = request.getParameter("autologin");
			
			if (autologin != null && autologin.equals("auto")) {
				Cookie cookie = new Cookie("autologin", userEmail);
				cookie.setPath("/");
				cookie.setMaxAge(60 * 60 * 24 * 30); // 쿠기 유통기한
				response.addCookie(cookie);
			}
			if (idStore != null && idStore.equals("store")) {
				Cookie cookie = new Cookie("idStore", userEmail);
				cookie.setPath("/");
				cookie.setMaxAge(60 * 60 * 24 * 30); // 쿠기 유통기한
				response.addCookie(cookie);
				// 쿠키 생성완료
			} else {
				Cookie cookie = new Cookie("idStore", userEmail);
				cookie.setPath("/");
				cookie.setMaxAge(0); // 쿠기 유통기한
				response.addCookie(cookie);
			}
			try {
				response.sendRedirect(logPage);

			} catch (IOException e) {
				e.printStackTrace();
			}

		} else {
			response.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=utf-8");

			try {
				PrintWriter out = response.getWriter();

				out.print("<script>");
				if (i == 0) {
					out.print("alert('비밀번호가 틀렸습니다.');");
				} else if (i == -1) {
					out.print("alert('이메일이 틀렸습니다.');");
				}
				out.print("location.href='memberLogin.ccc'");
				out.print("</script>");
				out.close();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
}
