package controller.packageGS;

import javax.servlet.http.HttpServletRequest;

public class ProductSubmitAction {
	public void execute(HttpServletRequest request) {
		String classesNum=request.getParameter("classesNum");
		request.setAttribute("classesNum", classesNum);
		
	}
}
