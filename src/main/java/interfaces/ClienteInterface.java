package interfaces;

import java.util.List;

import entidades.Cliente;
import entidades.Estado;
import entidades.TipoDocumento;

public interface ClienteInterface {
	
	public List<TipoDocumento> listarTipoDocumentos();
	
	public List<Estado> listarEstados();
	
	public int registrarCliente(Cliente cliente);
	
	public List<Cliente> listarClientes();
	
	public int eliminarCliente(String idCliente);
	
	public int editarCliente(Cliente cliente);
	
	public Cliente obtenerCliente(String idCliente);

}
