package controller.notBoard;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NoticeBoardController extends HttpServlet implements Servlet{

	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String requestURI = request.getRequestURI();
		String contexPath = request.getContextPath();
		String command = requestURI.substring(contexPath.length());
		
	 if (command.equals("/not/notList.not")) {
		 NoticeListAction action = new NoticeListAction();
		 action.excute(request);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/Notice_Board/notice_board_list.jsp");
		dispatcher.forward(request, response);
	}else if(command.equals("/not/noticeWrite.not")) {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/Notice_Board/notice_board_write.jsp");
		dispatcher.forward(request, response);
	}else if(command.equals("/not/noticeWritePro.not")) {
		NoticeWriteProAction action= new NoticeWriteProAction();
		action.execute(request);
		response.sendRedirect("notList.not");
	}else if(command.equals("/not/noticeDetail.not")) {
		String path="/Notice_Board/notice_board_view.jsp";
		NoticeDetailAction action = new NoticeDetailAction();
		action.execute(request);
		RequestDispatcher dispatcher = request.getRequestDispatcher(path);
		dispatcher.forward(request, response);
	}else if(command.equals("/not/noticeModify.not")) {
		NoticeDetailAction action = new NoticeDetailAction();
		action.execute(request);
		String path="/Notice_Board/notice_board_modify.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(path);
		dispatcher.forward(request, response);
	}else if(command.equals("/not/noticeModifyPro.not")) {
		NoticeBoardModifyAction action = new NoticeBoardModifyAction();
		action.execute(request);
		response.sendRedirect("noticeDetail.not?num="+ request.getParameter("boardNum"));
	}else if(command.equals("/not/noticeDelete.not")) {
		String path="/Notice_Board/notice_board_delete.jsp";
		request.setAttribute("boardNum", request.getParameter("num"));
		RequestDispatcher dispatcher = request.getRequestDispatcher(path);
		dispatcher.forward(request, response);
	}else if(command.equals("/not/noticeDeletePro.not")) {
		NoticeBoardDeleteAction action = new NoticeBoardDeleteAction();
		action.execute(request);
		response.sendRedirect("notList.not");
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
