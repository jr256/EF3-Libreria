package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAOFactory;
import entidades.Usuario;
import interfaces.UsuarioInterface;

/**
 * Servlet implementation class UsuarioServlet
 */
@WebServlet("/UsuarioServlet")
public class UsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UsuarioServlet() {
        super();
        
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String type = request.getParameter("type");
    	if (type.equals("list")) {
    		listarUsuarios(request, response);
    	} else if (type.equals("registrar")) {    		
    		registrarUsuario(request, response);  		    		    		
    	}
	}
	
protected void listarUsuarios(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	DAOFactory daoFactory = DAOFactory.getDaoFactory(DAOFactory.MYSQL);
    	UsuarioInterface dao = daoFactory.getUsuario();
    	
    	List<Usuario> data = dao.listarUsuarios();
    	request.setAttribute("data", data);
    	request.getRequestDispatcher("usuario.jsp").forward(request, response);
	}
	
    protected void registrarUsuario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String nombres = request.getParameter("txtNombres");
    	String apellidos = request.getParameter("txtApellidos");
    	String correo = request.getParameter("txtCorreo");
    	String clave = request.getParameter("txtClave");
    	    	
    	Usuario usuario = new Usuario();
    	usuario.setNombres(nombres);
    	usuario.setApellidos(apellidos);
    	usuario.setCorreo(correo);    	
    	usuario.setClave(clave);
    	
    	
    	DAOFactory daoFactory = DAOFactory.getDaoFactory(DAOFactory.MYSQL);
    	UsuarioInterface dao = daoFactory.getUsuario();
    	
    	
    	int value = dao.registrarUsuario(usuario);
    	if (value == 1) {
    		listarUsuarios(request, response);
    	} else {
    		request.setAttribute("mensaje", "Ocurrió un problema");
    		request.getRequestDispatcher("usuario.jsp").forward(request, response);
    	}
	}

}
