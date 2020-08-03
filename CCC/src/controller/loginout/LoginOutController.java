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

import controller.classes.ClassesPayAction;
import controller.classes.ClassesSelectAction;

public class LoginOutController extends HttpServlet implements Servlet{
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String requestURI = request.getRequestURI();
	String contexPath = request.getContextPath();
	String command = requestURI.substring(contexPath.length());
	if (command.equals("/main.ccc")) { //메인 페이지
		//쿠키
		CookieAction action = new CookieAction();
		action.execute(request);
		ClassesPayAction Caction=new ClassesPayAction();
		Caction.execute(request);
		RequestDispatcher dispatcher = request.getRequestDispatcher("main.jsp");
		dispatcher.forward(request, response);
		
	}else if(command.equals("/login/loginPro.ccc")) {
		LoginProAction action = new LoginProAction();
		action.execute(request, response);
		
	}else if (command.equals("/login/logOutPro.ccc")) {
		Cookie cookie = new Cookie("autologin", "");
		cookie.setPath("/");
		cookie.setMaxAge(0); //쿠기 유통기한
		response.addCookie(cookie);
		//세션 전에 쿠기삭제해야됨.
		
		HttpSession session = request.getSession();
		session.invalidate();
		response.sendRedirect("../main.ccc");
		
	}else if (command.equals("/login/memberLogin.ccc")) { //로그인페이지
		System.out.println(request.getHeader("referer"));
		LoginPageHereAction action= new LoginPageHereAction();
		action.execute(request);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/member/loginpop.jsp");
		dispatcher.forward(request, response);
	}else if (command.equals("/creative.ccc")) { 
		ClassesSelectAction action=new ClassesSelectAction();
		action.execute(request);
		RequestDispatcher dispatcher = request.getRequestDispatcher("creative.jsp");
		dispatcher.forward(request, response);
	}else if (command.equals("/creativehelp.ccc")) {
		RequestDispatcher dispatcher = request.getRequestDispatcher("creativehelp.jsp");
		dispatcher.forward(request, response);
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
