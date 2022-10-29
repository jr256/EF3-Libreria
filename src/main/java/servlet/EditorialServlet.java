package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAOFactory;
import entidades.Editorial;
import interfaces.EditorialInterface;


/**
 * Servlet implementation class EditorialServlet
 */
@WebServlet("/EditorialServlet")
public class EditorialServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditorialServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
		String type = request.getParameter("type");
    	if (type.equals("list")) {
    		configuracionInicial(request, response);
    	} else if (type.equals("register")) {    		
    		String Id = request.getParameter("Id");
    		if (Id.isEmpty()) {
    			registrarEditorial(request, response);
    		}else {
    			editarEditorial(request, response);
    		}
    		}else if (type.equals("delete")) {
    			eliminarEditorial(request, response);
    		}else if(type.equals("info")) {
    			obtenerEditorial(request, response);
    	}
	}
	
	
	
	protected void configuracionInicial(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		DAOFactory daoFactory = DAOFactory.getDaoFactory(DAOFactory.MYSQL);
		EditorialInterface dao = daoFactory.getEditorial();
		List<Editorial> dataEditorial = dao.listarEditorial();
		
		req.setAttribute("data", dataEditorial);
		req.getRequestDispatcher("editorial.jsp").forward(req, resp);
		
	}
	
	
	protected void registrarEditorial(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    	String nombre = request.getParameter("txtNombre");
	
    	Editorial editorial = new Editorial();
    	editorial.setEditorial(nombre);;

    	
    	DAOFactory daoFactory = DAOFactory.getDaoFactory(DAOFactory.MYSQL);
    	EditorialInterface dao = daoFactory.getEditorial();
    	
    	int value = dao.registrarEditorial(editorial);
    	if (value == 1) {
    		configuracionInicial(request, response);
    	} else {

    	}
	}
	
	protected void eliminarEditorial(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String id = request.getParameter("id");        	
    	DAOFactory daoFactory = DAOFactory.getDaoFactory(DAOFactory.MYSQL);
    	EditorialInterface dao = daoFactory.getEditorial();
    	
		int value = dao.eliminarEditorial(id);
		if (value == 1) {
			configuracionInicial(request, response);
		} else {
			
		}
	}
	
    protected void obtenerEditorial(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String Id = request.getParameter("id");
		
    	DAOFactory daoFactory = DAOFactory.getDaoFactory(DAOFactory.MYSQL);
    	EditorialInterface dao = daoFactory.getEditorial();
    	
    	Editorial editorial = dao.getEditorial(Id);
    	List<Editorial> listEditorial = dao.listarEditorial();
    	
    	request.setAttribute("editorialdata", editorial);
    	request.setAttribute("data", listEditorial);
    	request.getRequestDispatcher("editorial.jsp").forward(request, response);	
	}
    
    
	protected void editarEditorial(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String id = req.getParameter("Id");
    	String nombre = req.getParameter("txtNombre");
		
		Editorial editorial = new Editorial();
		editorial.setId(id);
		editorial.setEditorial(nombre);
		
		DAOFactory daoFactory = DAOFactory.getDaoFactory(DAOFactory.MYSQL);
		EditorialInterface dao = daoFactory.getEditorial();
		int value = dao.editarEditorial(editorial);
		if(value == 1) {
			configuracionInicial(req, resp);
		}else {
			req.setAttribute("Mensaje", "Ocurrió un problema");
			req.getRequestDispatcher("editorial.jsp").forward(req, resp);
		}
	}
	
	
	
	

}
