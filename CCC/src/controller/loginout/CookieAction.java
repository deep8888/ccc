package controller.loginout;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class CookieAction {
	public void execute(HttpServletRequest reqeust) {
		Cookie [] cookies = reqeust.getCookies();
		HttpSession session = reqeust.getSession();
		
		if (cookies != null && cookies.length > 0) {
			for (Cookie c : cookies) {
				if (c.getName().startsWith("email")) {
					reqeust.setAttribute("isEmail", c.getValue());
				}
				if (c.getName().startsWith("auto")) {
					session.setAttribute("logEmail", c.getValue());
				}
				if (c.getName().startsWith("master")) {
					session.setAttribute("logMaster", c.getValue());
				}
			}
		}
	}
}
