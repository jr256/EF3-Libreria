package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAOFactory;
import entidades.Usuario;
import interfaces.AutenticacionInterface;
import util.Constantes;
import util.SesionProyecto;

/**
 * Servlet implementation class InicioSesionServlet
 */
@WebServlet("/InicioSesionServlet")
public class InicioSesionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InicioSesionServlet() {
        super();
       
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
String type = request.getParameter("type");
    	
    	if (type.equals("login")) {
    		
    		String correo = request.getParameter("txtCorreo");
        	String clave = request.getParameter("txtClave");
        	
        	DAOFactory daoFactory = DAOFactory.getDaoFactory(DAOFactory.MYSQL);
        	AutenticacionInterface dao = daoFactory.getAutenticacion();
        	
        	Usuario usuario = dao.verificarInicioSesion(correo, clave);
        	if (usuario != null) {
        	    		
        		SesionProyecto session = new SesionProyecto();
        		session.saveSessionTimeOut(request, 30);
        		session.saveSessionString(request, Constantes.NAME, usuario.getNombres());
        		session.saveSessionString(request, Constantes.LASTNAME, usuario.getApellidos());
        		        		
        		System.out.println(usuario.getNombres());
        		System.out.println(usuario.getApellidos());
        		
        		session.saveSessionString(request, Constantes.EMAIL, usuario.getCorreo());
        		
        		response.sendRedirect("inicio.jsp");
        		
        	} else {
        		request.setAttribute("mensaje", "Error en usuario y/o contraseña");
        		request.getRequestDispatcher("login.jsp").forward(request, response);
        	}
    		
    	} else if (type.equals("logout")){
    		
    		SesionProyecto session = new SesionProyecto();
    		session.invalidateSession(request);
    		
    		response.sendRedirect("login.jsp");
    	}
	}

}
