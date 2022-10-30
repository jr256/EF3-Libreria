package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAOFactory;
import entidades.Cliente;
import entidades.Estado;
import entidades.TipoDocumento;
import interfaces.ClienteInterface;

/**
 * Servlet implementation class ClienteServlet
 */
@WebServlet("/ClienteServlet")
public class ClienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClienteServlet() {
        super();
        
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String type = request.getParameter("type");
		if (type.equals("list")) {
			configuracionInicial(request, response);
		} else if (type.equals("register")) {			
			String idCliente = request.getParameter("idCliente");
			if (idCliente.isEmpty()) {
				registrarCliente(request, response);
			} else {
				editarCliente(request, response);
			}
			
		} else if (type.equals("delete")) {
			eliminarCliente(request, response);
		} else if (type.equals("info")) {
			obtenerCliente(request, response);
		}
	}
	
	
	protected void configuracionInicial(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		DAOFactory daoFactory = DAOFactory.getDaoFactory(DAOFactory.MYSQL);
		ClienteInterface dao = daoFactory.getCliente();
		
		List<TipoDocumento> listadoTipoDoc = dao.listarTipoDocumentos();
		List<Estado> listadoEstado = dao.listarEstados();
		List<Cliente> listadoCliente = dao.listarClientes();
		
		request.setAttribute("dataTipoDocumentos", listadoTipoDoc);
		request.setAttribute("dataEstados", listadoEstado);
		request.setAttribute("dataClientes", listadoCliente);
		request.getRequestDispatcher("cliente.jsp").forward(request, response);
		
	}
	
	protected void registrarCliente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String tipoDocumento = request.getParameter("cboTipoDocumento");
		String numeroDocumento = request.getParameter("txtNumeroDocumento");
		String nombreCliente = request.getParameter("txtNombreCliente");
		String estadoCliente = request.getParameter("cboEstado");
		String direccion = request.getParameter("txtDireccion");
		
		Cliente cliente = new Cliente();
		cliente.setIdTipoDocumento(tipoDocumento);
		cliente.setNumeroDocumento(numeroDocumento);
		cliente.setNombreCliente(nombreCliente);
		cliente.setIdEstado(estadoCliente);
		cliente.setDireccion(direccion);
		
		DAOFactory daoFactory = DAOFactory.getDaoFactory(DAOFactory.MYSQL);
		ClienteInterface dao = daoFactory.getCliente();		
		int value = dao.registrarCliente(cliente);
		
		if (value == 1) {
			configuracionInicial(request, response);
		} else {
			
		}
				
	}
	
	protected void eliminarCliente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String id = request.getParameter("id");
		DAOFactory daoFactory = DAOFactory.getDaoFactory(DAOFactory.MYSQL);
		ClienteInterface dao = daoFactory.getCliente();
		
		int value = dao.eliminarCliente(id);
		if (value == 1) {
			configuracionInicial(request, response);
		} else {
			
		}
	}
	
	
	protected void obtenerCliente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		
		String idCliente = request.getParameter("id");
		DAOFactory daoFactory = DAOFactory.getDaoFactory(DAOFactory.MYSQL);
		ClienteInterface dao = daoFactory.getCliente();
		Cliente cliente = dao.obtenerCliente(idCliente);
		
		List<TipoDocumento> listadoTipoDoc = dao.listarTipoDocumentos();
		List<Estado> listadoEstado = dao.listarEstados();
		List<Cliente> listadoCliente = dao.listarClientes();
		
		request.setAttribute("dataCliente", cliente);
		request.setAttribute("dataTipoDocumentos", listadoTipoDoc);
		request.setAttribute("dataEstados", listadoEstado);
		request.setAttribute("dataClientes", listadoCliente);
		request.getRequestDispatcher("cliente.jsp").forward(request, response);
		
	}
	
	protected void editarCliente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("idCliente");
		String tipoDocumento = request.getParameter("cboTipoDocumento");
		String numeroDocumento = request.getParameter("txtNumeroDocumento");
		String nombreCliente = request.getParameter("txtNombreCliente");
		String estadoCliente = request.getParameter("cboEstado");
		String direccion = request.getParameter("txtDireccion");
		
		Cliente cliente = new Cliente();
		cliente.setId(id);
		cliente.setTipoDocumento(tipoDocumento);
		cliente.setNumeroDocumento(numeroDocumento);
		cliente.setNombreCliente(nombreCliente);
		cliente.setEstado(estadoCliente);
		cliente.setDireccion(direccion);
		
		DAOFactory daoFactory = DAOFactory.getDaoFactory(DAOFactory.MYSQL);
		ClienteInterface dao = daoFactory.getCliente();
		int value = dao.editarCliente(cliente);
		
		if (value == 1) {
			configuracionInicial(request, response);
		} else {
			request.setAttribute("mensaje", "Ocurrió un problema");
			request.getRequestDispatcher("cliente.jsp").forward(request, response);
		}
	}

}
