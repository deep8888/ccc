package controller.packageGS;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PackagGSController extends HttpServlet implements Servlet{
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String rquestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = rquestURI.substring(contextPath.length());
		if (command.equals("/pd/productList.pd")) {
			ProductListAction action = new ProductListAction();
			action.execute(request);
			String path = "/packageGS/packageGS_List.jsp";
			RequestDispatcher dispatcher = request.getRequestDispatcher(path);
			dispatcher.forward(request, response);
		}else if (command.equals("/pd/productForm.pd")) {
			ProductSubmitAction action=new ProductSubmitAction();
			action.execute(request);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/packageGS/packageGS_Form.jsp");
			dispatcher.forward(request, response);
		}else if (command.equals("/pd/productForm2.pd")) {
			ProductWriteAction action = new ProductWriteAction();
			String classesNum=action.execute(request); 
			response.sendRedirect("../cen/classCreateExit.cen");
		}else if(command.equals("/pd/productDel.pd")) {
			ProductDelAction action=new ProductDelAction();
			action.execute(request);
			response.sendRedirect("../cen/classCreateExit.cen");
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(req, resp);
	}

}
