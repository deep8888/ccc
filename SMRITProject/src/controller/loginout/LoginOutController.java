package controller.loginout;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginOutController extends HttpServlet implements Servlet{
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String requestURI = request.getRequestURI();
	String contexPath = request.getContextPath();
	String command = requestURI.substring(contexPath.length());
	if (command.equals("/main.main")) {
		//쿠키
		CookieAction action = new CookieAction();
		action.execute(request);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/main/main.jsp");
		dispatcher.forward(request, response);
		
	}else if(command.equals("/login/loginPro.main")) {
		LoginProAction action = new LoginProAction();
		action.execute(request, response);
		
	}else if (command.equals("/login/logOutPro.main")) {
		Cookie cookie = new Cookie("autologin", "");
		cookie.setPath("/");
		cookie.setMaxAge(0); //쿠기 유통기한
		response.addCookie(cookie);
		//세션 전에 쿠기삭제해야됨.
		
		HttpSession session = request.getSession();
		session.invalidate();
		response.sendRedirect("../main.main");
		
	}
	
	}
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	doProcess(req,resp);
}

@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	doProcess(req,resp);
	}
}
