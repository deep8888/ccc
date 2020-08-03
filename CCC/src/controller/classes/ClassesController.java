package controller.classes;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ClassesController extends HttpServlet implements Servlet {

	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = requestURI.substring(contextPath.length());

		if (command.equals("/classSubmit.cs")) {
			ClassesListAction action = new ClassesListAction();
			action.execute(request);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/classes/classSubmit.jsp");
			dispatcher.forward(request, response);

		} else if (command.equals("/classesPay.cs")) {
			PurchaseListAction action = new PurchaseListAction();
			action.execute(request);
			PackagePayAction paction = new PackagePayAction();
			paction.execute(request);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/classes/classesPay.jsp");
			dispatcher.forward(request, response);

		} else if (command.equals("/ClassesPaySub.cs")) {
			PackagePayAction action = new PackagePayAction();
			action.execute(request);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/classes/classPaySubmit.jsp");
			dispatcher.forward(request, response);
		} else if (command.equals("/classesPaid.cs")) {
			ClassesPurchaseAction action = new ClassesPurchaseAction();
			action.execute(request);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/classes/final.jsp");
			dispatcher.forward(request, response);
		} else if (command.equals("/classesListView.cs")) {
			ClassesListAction claction = new ClassesListAction();
			claction.execute(request);
			PurchaseListAction action = new PurchaseListAction();
			action.execute(request);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/classes/purchaseList.jsp");
			dispatcher.forward(request, response);
		} else if (command.equals("/classesDetailView.cs")) {
			PurchaseListAction action = new PurchaseListAction();
			action.execute(request);
			ClassesListAction claction = new ClassesListAction();
			claction.execute(request);
			refundConfirmAction raction =new refundConfirmAction();
			raction.execute(request);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/classes/classView.jsp");
			dispatcher.forward(request, response);
		}else if(command.equals("/mem/classesViewAdmin.cs")) {
			ClassesListAction action=new ClassesListAction();
			action.execute(request);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/classes/classViewAdmin.jsp");
			dispatcher.forward(request, response);
		}else if(command.equals("/mem/classesAdminSubmit.cs")) {
			ClassesAdminSubmitAction action=new ClassesAdminSubmitAction();
			action.execute(request);
			response.sendRedirect("memberDetail.mem");
		}else if(command.equals("/classesRefund.cs")) {
			classesRefundAction action=new classesRefundAction();
			action.execute(request);
			response.sendRedirect("mem/memberDetail.mem");
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

}
