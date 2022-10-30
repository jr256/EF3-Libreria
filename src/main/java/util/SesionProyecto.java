package util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class SesionProyecto {
	
	public void saveSessionString(HttpServletRequest request, String key, String value) {
		HttpSession sesion = request.getSession();
		sesion.setAttribute(key, value);
	}
	
	public void saveSessionTimeOut(HttpServletRequest request, int time) {
		HttpSession sesion = request.getSession();
		sesion.setMaxInactiveInterval(time);
	}
	
	public void invalidateSession(HttpServletRequest request) {
		request.getSession().invalidate();
	}

}
