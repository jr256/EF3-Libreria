package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import db.MysqlConexion;
import entidades.Cliente;
import entidades.Estado;
import entidades.TipoDocumento;
import interfaces.ClienteInterface;

public class ClienteModelo implements ClienteInterface {

	private static Logger log = Logger.getLogger(Cliente.class.getName());
	
	@Override
	public List<TipoDocumento> listarTipoDocumentos() {
		
		List<TipoDocumento> listado = new ArrayList<TipoDocumento>();
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rst = null;
		
		try {			
			
			con = MysqlConexion.getConexion();			
			String sql = "SELECT Id,Documento FROM tipo_documento";			
			pst = con.prepareStatement(sql);
			rst = pst.executeQuery();
			
			while (rst.next()) {
				
				TipoDocumento tipoDocumento = new TipoDocumento();
				tipoDocumento.setId(rst.getString("Id"));
				tipoDocumento.setDocumento(rst.getString("Documento"));				
				listado.add(tipoDocumento);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rst != null) rst.close();
				if (pst != null) pst.close();
				if (con != null) con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return listado;
		
	}
	
	@Override
	public List<Estado> listarEstados() {
		
		List<Estado> listado = new ArrayList<Estado>();
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rst = null;
		
		try {			
			
			con = MysqlConexion.getConexion();			
			String sql = "SELECT Id, Estado FROM estado";			
			pst = con.prepareStatement(sql);
			rst = pst.executeQuery();
			
			while (rst.next()) {
				
				Estado estado = new Estado();
				estado.setId(rst.getString("Id"));
				estado.setEstado(rst.getString("Estado"));				
				listado.add(estado);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rst != null) rst.close();
				if (pst != null) pst.close();
				if (con != null) con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return listado;
	}
	
	

	@Override
	public int registrarCliente(Cliente cliente) {
		
		int envio = 0;
		Connection con = null;
		PreparedStatement pst = null;
		
		try {
			
			con = MysqlConexion.getConexion();
			String sql = "CALL usp_Cliente_Insertar(?,?,?,?,?)";
			pst = con.prepareCall(sql);
			
			pst.setString(1, cliente.getIdTipoDocumento());
			pst.setString(2, cliente.getNumeroDocumento());
			pst.setString(3, cliente.getNombreCliente());
			pst.setString(4, cliente.getIdEstado());
			pst.setString(5, cliente.getDireccion());
			
			log.info("SQL Query de inserción ----> " + pst);
			
			envio = pst.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pst != null) pst.close();
				if (con != null) con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return envio;
		
	}

	
	
	@Override
	public List<Cliente> listarClientes() {
		
		List<Cliente> listado = new ArrayList<Cliente>();
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rst = null;
		
		try {
			
			con = MysqlConexion.getConexion();			
			String sql = "CALL usp_Cliente_ListarTodos";
						
			pst = con.prepareCall(sql);
			rst = pst.executeQuery();
			
			while (rst.next()) {
				
				Cliente cliente = new Cliente();
				cliente.setId(rst.getString("Id"));
				cliente.setIdTipoDocumento(rst.getString("IdTipoDocumento"));
				cliente.setTipoDocumento(rst.getString("Documento"));
				cliente.setNumeroDocumento(rst.getString("NumeroDocumento"));
				cliente.setNombreCliente(rst.getString("Cliente"));		
				cliente.setIdTipoDocumento(rst.getString("IdEstado"));
				cliente.setEstado(rst.getString("Estado"));
				cliente.setDireccion(rst.getString("Direccion"));
				
				listado.add(cliente);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rst != null) rst.close();
				if (pst != null) pst.close();
				if (con != null) con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return listado;
		
	}

	
	
	@Override
	public int eliminarCliente(String idCliente) {
	
		int envio = 0;		
		Connection con = null;
		PreparedStatement pst = null;
		
		try {
			
			con = MysqlConexion.getConexion();			
			String sql = "CALL usp_Cliente_Eliminar(?)";
			pst = con.prepareCall(sql);
			pst.setString(1, idCliente);			
			envio = pst.executeUpdate();
						
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pst != null) pst.close();
				if (con != null) con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return envio;
	}
	
	

	@Override
	public int editarCliente(Cliente cliente) {
		
		int envio = 0;
		Connection con = null;
		PreparedStatement pst = null;
		
		try {
			
			con = MysqlConexion.getConexion();			
			String mysql = "CALL usp_Cliente_Actualizar(?,?,?,?,?,?)";
			pst = con.prepareCall(mysql);
			
			pst.setString(1, cliente.getIdTipoDocumento());
			pst.setString(2, cliente.getNumeroDocumento());
			pst.setString(3, cliente.getNombreCliente());
			pst.setString(4, cliente.getIdEstado());
			pst.setString(5, cliente.getDireccion());
			pst.setString(6, cliente.getId());
			
			log.info("SQL Query de actualización ----> " + pst);
			envio = pst.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pst != null) pst.close();
				if (con != null) con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return envio;
		
	}
	
	

	@Override
	public Cliente obtenerCliente(String idCliente) {
		
		Cliente cliente = null;
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rst = null;
		
		try {
			
			con = MysqlConexion.getConexion();
			String mysql = "CALL usp_Cliente_BuscarPorId(?)";
			pst = con.prepareCall(mysql);
			pst.setString(1, idCliente);			
			rst = pst.executeQuery();
			
			if(rst.next()) {
				
				cliente = new Cliente();				
				cliente.setId(rst.getString("Id"));
				cliente.setIdTipoDocumento(rst.getString("IdTipoDocumento"));
				cliente.setTipoDocumento(rst.getString("Documento"));
				cliente.setNumeroDocumento(rst.getString("NumeroDocumento"));
				cliente.setNombreCliente(rst.getString("Cliente"));
				cliente.setIdEstado(rst.getString("IdEstado"));
				cliente.setEstado(rst.getString("Estado"));
				cliente.setDireccion(rst.getString("Direccion"));
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rst != null) rst.close();
				if (pst != null) pst.close();
				if (con != null) con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return cliente;
		
	}



}
