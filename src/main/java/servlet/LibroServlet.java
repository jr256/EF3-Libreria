package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAOFactory;
import entidades.Libro;
import interfaces.LibroInterface;

/**
 * Servlet implementation class LibroServlet
 */
@WebServlet("/LibroServlet")
public class LibroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LibroServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
	    	
	String type = req.getParameter("type");
	if (type.equals("list")) {
		listarLibro(req, resp);
	} else if (type.equals("register")) {    		
		String Id = req.getParameter("Id");
		
		if (Id.isEmpty()) {
			registrarLibro(req, resp);
		} else {
			editarLibro(req, resp);
		}
		    		
	} else if (type.equals("info")) {
		getLibro(req, resp);    		
	} else if (type.equals("delete")) {
		eliminarLibro(req, resp);  		
	} 
	    	
	
}

	protected void listarLibro (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		DAOFactory daoFactory = DAOFactory.getDaoFactory(DAOFactory.MYSQL);
		LibroInterface dao = daoFactory.getLibro();
		
		List<Libro> data = dao.listarLibros();
		request.setAttribute("data", data);
		request.getRequestDispatcher("libro.jsp").forward(request, response);
	}
	
	protected void registrarLibro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("txtId");
		String titulo = request.getParameter("txtTitulo");
		String isbn = request.getParameter("txtIsbn");
		String autor = request.getParameter("txtAutor");
		String idEditorial = request.getParameter("txtIdEditorial");
		String fechaPublicacion = request.getParameter("txtFechaPublicacion");
		String precio = request.getParameter("txtPrecio");
		String idCategoria = request.getParameter("txtIdCategoria");
		String stock = request.getParameter("txtStock");
		String idEstado = request.getParameter("txtIdEstado");
		
		Libro libro = new Libro();
		libro.setId(id);
		libro.setTitulo(titulo);
		libro.setIsbn(isbn);
		libro.setAutor(autor);
		libro.setIdEditorial(idEditorial);
		libro.setFechaPublicacion(fechaPublicacion);
		libro.setPrecio(precio);
		libro.setIdCategoria(idCategoria);
		libro.setStock(stock);
		libro.setIdEstado(idEstado);
		
		DAOFactory daoFactory = DAOFactory.getDaoFactory(DAOFactory.MYSQL);
		LibroInterface dao = daoFactory.getLibro();
		
		
		int value = dao.registrarLibro(libro);
		if (value == 1) {
			listarLibro(request, response);
		} else {
			request.setAttribute("mensaje", "Ocurrió un problema");
			request.getRequestDispatcher("libro.jsp").forward(request, response);
		}
	}

	protected void editarLibro (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("txtId");
		String titulo = request.getParameter("txtTitulo");
		String isbn = request.getParameter("txtIsbn");
		String autor = request.getParameter("txtAutor");
		String idEditorial = request.getParameter("txtIdEditorial");
		String fechaPublicacion = request.getParameter("txtFechaPublicacion");
		String precio = request.getParameter("txtPrecio");
		String idCategoria = request.getParameter("txtIdCategoria");
		String stock = request.getParameter("txtStock");
		String idEstado = request.getParameter("txtIdEstado");
		
		Libro libro = new Libro();
		libro.setId(id);
		libro.setTitulo(titulo);
		libro.setIsbn(isbn);
		libro.setAutor(autor);
		libro.setIdEditorial(idEditorial);
		libro.setFechaPublicacion(fechaPublicacion);
		libro.setPrecio(precio);
		libro.setIdCategoria(idCategoria);
		libro.setStock(stock);
		libro.setIdEstado(idEstado);
		
		DAOFactory daoFactory = DAOFactory.getDaoFactory(DAOFactory.MYSQL);
		LibroInterface dao = daoFactory.getLibro();
		
		int value = dao.editarLibro(libro);
		if (value == 1) {
			listarLibro(request, response);
		} else {
			request.setAttribute("mensaje", "Ocurrió un problema");
			request.getRequestDispatcher("libro.jsp").forward(request, response);
		}
	}

	protected void getLibro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("Id");
	
		DAOFactory daoFactory = DAOFactory.getDaoFactory(DAOFactory.MYSQL);
		LibroInterface dao = daoFactory.getLibro();
		
		Libro libro = dao.getLibro(id);
		List<Libro> data = dao.listarLibros();
		
		request.setAttribute("subjectData", libro);
		request.setAttribute("data", data);
		request.getRequestDispatcher("libro.jsp").forward(request, response);
	}
	
	protected void eliminarLibro (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		DAOFactory daoFactory = DAOFactory.getDaoFactory(DAOFactory.MYSQL);
		LibroInterface dao = daoFactory.getLibro();
		
		int value = dao.eliminarLibro(id);
		if (value == 1) {
			configuracionInicial(request, response);
		} else {
			
		}
	}
	
	protected void configuracionInicial(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		DAOFactory daoFactory = DAOFactory.getDaoFactory(DAOFactory.MYSQL);
		LibroInterface dao = daoFactory.getLibro();
		List<Libro> data = dao.listarLibros();
		
		req.setAttribute("data", data);
		req.setAttribute("dataEstudiantes", data);
		req.getRequestDispatcher("libro.jsp").forward(req, resp);
		
	}

}
