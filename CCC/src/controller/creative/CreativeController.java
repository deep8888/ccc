package controller.creative;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CreativeController extends HttpServlet implements Servlet {
	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String requestURI = request.getRequestURI();
		String contexPath = request.getContextPath();
		String command = requestURI.substring(contexPath.length());

		if (command.equals("/cr/creative.cr")) {
			CreativeStartAction action = new CreativeStartAction();
			action.execute(request);
			HttpSession session = request.getSession();
			if (session.getAttribute("logEmail") != null) {
				DemandCkAction action1 = new DemandCkAction();
				int i = action1.execute(request);
				System.out.println(i);
				if (i == 0) {
					RequestDispatcher dispatcher = request.getRequestDispatcher("/creative/creativeStart.jsp");
					dispatcher.forward(request, response);
				} else {
					response.sendRedirect("creativehelp.cr");
				}

			}
		} else if (command.equals("/cr/creativeStart.cr")) { // 수요조사 페이지
			CreativeDetailAction action = new CreativeDetailAction();
			action.execute(request);
			HttpSession session = request.getSession();
			if (session.getAttribute("logEmail") != null) {
				RequestDispatcher dispatcher = request.getRequestDispatcher("/creative/creativeStart2.jsp");
				dispatcher.forward(request, response);

			}

		} else if (command.equals("/cr/creativeStart2.cr")) { // 수요조사 페이지
			HttpSession session = request.getSession();
			if (session.getAttribute("logEmail") != null) {
				RequestDispatcher dispatcher = request.getRequestDispatcher("/creative/creativeStart3.jsp");
				dispatcher.forward(request, response);
			}
		} else if (command.equals("/cr/creativeStart3.cr")) { // 수요조사 페이지
			DemandInsertAction action = new DemandInsertAction();
			action.execute(request);
			HttpSession session = request.getSession();
			if (session.getAttribute("logEmail") != null) {
				RequestDispatcher dispatcher = request.getRequestDispatcher("/creative/creativeStart4.jsp");
				dispatcher.forward(request, response);
			}
		} else if (command.equals("/cr/creativehelp.cr")) { // 수요조사 페이지
			DemandCkAction action1 = new DemandCkAction();
			int i = action1.execute(request);
			System.out.println(i);
			if (i != 0) {
//				RequestDispatcher dispatcher = request.getRequestDispatcher("../creatorCenter/main/classCreateMain.jsp");
//				dispatcher.forward(request, response);
				
				
				response.sendRedirect("../cen/classCreateExit.cen");
				
				
			} else {
				response.sendRedirect("../creativehelp.ccc");
			}

		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);
	}

}
