package controller.Resume;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ResumeController extends HttpServlet implements Servlet{
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = requestURI.substring(contextPath.length());
		if (command.equals("/res/hi.res")) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/hi.jsp");
			dispatcher.forward(request, response);	
		}else if (command.equals("/res/Dutieslist.res")) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/Resume/Dutieslist.jsp");
			dispatcher.forward(request, response);
		}else if (command.equals("/res/jobbackend.res")) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/Resume/Job_Backend.jsp");
			dispatcher.forward(request, response);
		}else if (command.equals("/res/endWritePro.res")) {
			//ResumeWriteActtion action = new ResumeWriteActtion();
			//action.execute(request);      //페이지 로드에서 읽기랑 쓰기랑 공유해서 오류. 
			RequestDispatcher dispatcher = request.getRequestDispatcher("/Resume/Resumefile/Resumebackend.jsp");
			dispatcher.forward(request, response);
		}else if (command.equals("/res/endWriteProAction.res")) {  //쓰기 추가
			ResumeWriteActtion action = new ResumeWriteActtion();
			action.execute(request);      
			response.sendRedirect("Dutieslist.res"); //등록이 완료되면 이력지원리스트 페이지로 이동하게 함.
		}else if (command.equals("/res/jobcommerce.res")) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/Resume/Job_Commerce.jsp");
			dispatcher.forward(request, response);
		}else if (command.equals("/res/jobcommercelife.res")) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/Resume/job_Commerce_Life.jsp");
			dispatcher.forward(request, response);
		}else if (command.equals("/res/jobcommerceMD.res")) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/Resume/job_Commerce_MD.jsp");
			dispatcher.forward(request, response);
		}else if (command.equals("/res/joblogistic.res")) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/Resume/job_Logistic.jsp");
			dispatcher.forward(request, response);
		}else if (command.equals("/res/ResemailCk.res")) {
			ResumeListAction action = new ResumeListAction();
			action.execute(request);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/Resume/Resume_YesNoList.jsp");
			dispatcher.forward(request, response);
		}else if (command.equals("/res/ResumeDetail.res")) {
			ResumeListAction action = new ResumeListAction();
			action.execute(request);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/Resume/Resumefile/resumeOKNo.jsp");
			dispatcher.forward(request, response);
		}else if (command.equals("/res/RessumeInfoModifyPro.res")) {
			RessumeDetailListAction action = new RessumeDetailListAction();
			action.execute(request);
			response.sendRedirect("ResemailCk.res");
		}else if (command.equals("/res/Resemailyesno.res")) {//지원자 합격결과 
			RequestDispatcher dispatcher = request.getRequestDispatcher("/Resume/job_inquiry.jsp");
			dispatcher.forward(request, response);
		}else if (command.equals("/res/ResselectPro.res")) {
			ResselectAction action = new ResselectAction();
			action.execute(request);
				RequestDispatcher dispatcher = request.getRequestDispatcher("/Resume/ResumeOk.jsp");
				dispatcher.forward(request, response);
		}
				//else if (command.equals("/res/Resumefail.res")) {
//			RequestDispatcher dispatcher = request.getRequestDispatcher("/Resume/Resume_fail.jsp");
//			dispatcher.forward(request, response);
//			
//			
//		}
	}
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(req, resp);
	}@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(req, resp);
	}
}
