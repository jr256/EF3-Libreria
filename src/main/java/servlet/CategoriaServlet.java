package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAOFactory;
import entidades.Categoria;
import interfaces.CategoriaInterface;


/**
 * Servlet implementation class CategoriaServlet
 */
@WebServlet("/CategoriaServlet")
public class CategoriaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CategoriaServlet() {
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
    			registrarCategoria(request, response);
    		}else {
    			editarCategoria(request, response);
    		}
    		}else if (type.equals("delete")) {
    			eliminarCategoria(request, response);
    		}else if(type.equals("info")) {
    			obtenerCategoria(request, response);
    	}
	}
	
	
	
	
	protected void configuracionInicial(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		DAOFactory daoFactory = DAOFactory.getDaoFactory(DAOFactory.MYSQL);
		CategoriaInterface dao = daoFactory.getCategoria();
		List<Categoria> dataCategoria = dao.listarCategoria();
		
		req.setAttribute("data", dataCategoria);
		req.getRequestDispatcher("categoria.jsp").forward(req, resp);
		
	}
	
	protected void registrarCategoria(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    	String nombre = request.getParameter("txtNombre");
	
    	Categoria categoria = new Categoria();
    	categoria.setCategoria(nombre);;

    	
    	DAOFactory daoFactory = DAOFactory.getDaoFactory(DAOFactory.MYSQL);
    	CategoriaInterface dao = daoFactory.getCategoria();
    	
    	int value = dao.registrarCategoria(categoria);
    	if (value == 1) {
    		configuracionInicial(request, response);
    	} else {

    	}
	}
	
	
	protected void eliminarCategoria(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String id = request.getParameter("id");        	
    	DAOFactory daoFactory = DAOFactory.getDaoFactory(DAOFactory.MYSQL);
    	CategoriaInterface dao = daoFactory.getCategoria();
    	
		int value = dao.eliminarCategoria(id);
		if (value == 1) {
			configuracionInicial(request, response);
		} else {
			
		}
	}
	
    protected void obtenerCategoria(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String Id = request.getParameter("id");
		
    	DAOFactory daoFactory = DAOFactory.getDaoFactory(DAOFactory.MYSQL);
    	CategoriaInterface dao = daoFactory.getCategoria();
    	
    	Categoria categoria = dao.getCategoria(Id);
    	List<Categoria> listEditorial = dao.listarCategoria();
    	
    	request.setAttribute("categoriadata", categoria);
    	request.setAttribute("data", listEditorial);
    	request.getRequestDispatcher("categoria.jsp").forward(request, response);	
	}
    
    
	protected void editarCategoria(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String id = req.getParameter("Id");
    	String nombre = req.getParameter("txtNombre");
		
    	Categoria categoria = new Categoria();
    	categoria.setId(id);
    	categoria.setCategoria(nombre);
		
		DAOFactory daoFactory = DAOFactory.getDaoFactory(DAOFactory.MYSQL);
		CategoriaInterface dao = daoFactory.getCategoria();
		int value = dao.editarCategoria(categoria);
		if(value == 1) {
			configuracionInicial(req, resp);
		}else {
			req.setAttribute("Mensaje", "Ocurrió un problema");
			req.getRequestDispatcher("categoria.jsp").forward(req, resp);
		}
	}
	
	
	
	
	
	
	

}
