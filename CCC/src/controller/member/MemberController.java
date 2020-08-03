package controller.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.classes.ClassesSelectAction;
import controller.classes.PurchaseListAction2;
import controller.classes.refundConfirmAction;

public class MemberController extends HttpServlet implements Servlet {

	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = requestURI.substring(contextPath.length());
		if (command.equals("/mem/memberRegist.mem")) { // 회원가입 페이지
			RequestDispatcher dispatcher = request.getRequestDispatcher("/member/signup.jsp");
			dispatcher.forward(request, response);
		} else if (command.equals("/mem/memberOk.mem")) {
			MemberOkAction action = new MemberOkAction();
			action.execute(request);
			HttpSession session = request.getSession();
			if (session.getAttribute("logEmail") != null) {
				response.sendRedirect("../member/usersuccess.jsp");
			} else {
				response.sendRedirect("../member/usersuccess.jsp");
			}
		} else if (command.equals("/mem/memberJoinOk.mem")) {
			MemberJoinOkAction action = new MemberJoinOkAction();
			String path = action.execute(request);
			RequestDispatcher dispatcher = request.getRequestDispatcher(path);
			dispatcher.forward(request, response);
		} else if (command.equals("/mem/memberDetail.mem")) {
			refundConfirmAction raction =new refundConfirmAction();
			raction.execute(request);
			
			PurchaseListAction2 Paction = new PurchaseListAction2();
			Paction.execute(request);
			MemberDetailAction action = new MemberDetailAction();
			action.execute(request);
			ClassesSelectAction Caction =new ClassesSelectAction();
			Caction.execute(request);
			String path = "/member/memberDetail.jsp";
			RequestDispatcher dispatcher = request.getRequestDispatcher(path);
			dispatcher.forward(request, response);
		} else if (command.equals("/mem/memberPw.mem")) {
			String path = "/member/memberInfoPw.jsp";
			RequestDispatcher dispatcher = request.getRequestDispatcher(path);
			dispatcher.forward(request, response);
		} else if (command.equals("/mem/memberInfoCng.mem")) {
			MemberInfoCngAction action = new MemberInfoCngAction();
			Integer i = action.execute(request);
			if (i == 1) {
				MemberDetailAction action1 = new MemberDetailAction();
				action1.execute(request);
				request.setAttribute("memChk", "true");
				String path = "/member/memberInfoPro.jsp";
				RequestDispatcher dispatcher = request.getRequestDispatcher(path);
				dispatcher.forward(request, response);
			} else if (i == 0) {
				response.sendRedirect("memberPw.mem");
			}
		} else if (command.equals("/mem/memberInfoPro.mem")) {
			MemberModifyAction action = new MemberModifyAction();
			action.execute(request);
			// 사용자
			if (request.getParameter("memChk") != null && request.getParameter("memChk").equals("true")) {
				response.sendRedirect("memberDetail.mem");
			} else {
				// 관리자
				String num = request.getParameter("email");
				response.sendRedirect("memberInfo.mem?userEmail=" + num);
			}
		} else if (command.equals("/mem/memberInfo.mem")) {
			// 관리자회원전보 수정
			MemberInfoAction action = new MemberInfoAction();
			action.execute(request);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/member/memberInfo.jsp");
			dispatcher.forward(request, response);
		} else if (command.equals("/mem/memberPwForm.mem")) {
			String path = "/member/pwModify.jsp";
			RequestDispatcher dispatcher = request.getRequestDispatcher(path);
			dispatcher.forward(request, response);
		} else if (command.equals("/mem/pwModify1.mem")) {
			PwModifyAction action = new PwModifyAction();
			Integer i = action.execute(request);
			if (i == 1) {
				String path = "/member/pwModify_1.jsp";
				RequestDispatcher dispatcher = request.getRequestDispatcher(path);
				dispatcher.forward(request, response);
			} else if (i == 0) {
				response.sendRedirect("memberPwForm.mem");
			}

		} else if (command.equals("/mem/pwModifyPro.mem")) {
			PwModifyProAction action = new PwModifyProAction();
			Integer i = action.execute(request);
			if (i == 1) {
				String path = "/member/pwModifyOk.jsp";
				RequestDispatcher dispatcher = request.getRequestDispatcher(path);
				dispatcher.forward(request, response);
			} else if (i == 0) {
				response.sendRedirect("memberPwForm.mem");
			}
		} else if (command.equals("/mem/memberUserDel.mem")) {
			String path = "/member/userDeltePw.jsp";
			RequestDispatcher dispatcher = request.getRequestDispatcher(path);
			dispatcher.forward(request, response);
		} else if (command.equals("/mem/memberUserDelPro.mem")) {
			PwModifyAction action = new PwModifyAction();
			Integer i = action.execute(request);
			if (i == 1) {
				MemberUserDelAction action1 = new MemberUserDelAction();
				action1.execute(request);
				response.sendRedirect("../login/logOutPro.ccc");

			} else if (i == 0) {
				response.sendRedirect("memberUserDel.mem");
			}
			//아이디 찾기
		} else if (command.equals("/mem/emailCk.mem")) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/member/emailCk.jsp");
			dispatcher.forward(request, response);
				} else if (command.equals("/mem/emailCkPro.mem")) {
			EmailCkProAction action = new EmailCkProAction();
			Integer i = action.execute(request);
			if (i == 1) {// 아이디가 있습니다.
				RequestDispatcher dispatcher = request.getRequestDispatcher("/member/emailConfirm.jsp");
				dispatcher.forward(request, response);
			} else {// 아이디가 없습니다.
				response.sendRedirect("emailCkfail.mem");
			}
		}else if (command.equals("/mem/emailCkfail.mem")) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/member/emailCkfail.jsp");
			dispatcher.forward(request, response);
		//패스워드 찾기
		} else if (command.equals("/mem/passCk.mem")) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/member/passCk.jsp");
			dispatcher.forward(request, response);
		} else if (command.equals("/mem/passCkPro.mem")) {
			PassCkProAction action = new PassCkProAction();
			Integer i = action.execute(request);
			if (i == 1) {// 회원정보가 있습니다.
				RequestDispatcher dispatcher = request.getRequestDispatcher("/member/passConfirm.jsp");
				dispatcher.forward(request, response);
			} else {// 회원정보가 없습니다.
				response.sendRedirect("passCkfail.mem");
			}
		}else if (command.equals("/mem/passCkfail.mem")) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/member/passCkfail.jsp");
			dispatcher.forward(request, response);
		}else if (command.equals("/mem/userConfirm.mem")) {
			// 아이디 중복체크
			MemberConfirmAction action = new MemberConfirmAction();
			action.execute(request);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/member/userConfirm.jsp");
			dispatcher.forward(request, response);
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
