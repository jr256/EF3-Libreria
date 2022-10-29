package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import db.MysqlConexion;
import entidades.Cliente;
import entidades.Estado;
import entidades.TipoDocumento;
import interfaces.ClienteInterface;

public class ClienteModelo implements ClienteInterface {

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
			String sql = "SELECT Id,Documento FROM tipo_documento";			
			pst = con.prepareStatement(sql);
			rst = pst.executeQuery();
			
			while (rst.next()) {
				
				Estado tipoDocumento = new Estado();
				tipoDocumento.setId(rst.getString("Id"));
				tipoDocumento.setEstado(rst.getString("Estado"));				
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
	public int registrarCliente(Cliente cliente) {
		
		int envio = 0;
		Connection con = null;
		PreparedStatement pst = null;
		
		try {
			
			con = MysqlConexion.getConexion();
			String sql = "INSERT INTO cliente VALUES (null,?,?,?,?,?)";
			pst = con.prepareStatement(sql);
			
			pst.setString(1, cliente.getNombreCliente());
			pst.setString(2, cliente.getIdTipoDocumento());
			pst.setString(3, cliente.getNumeroDocumento());
			pst.setString(4, cliente.getNombreCliente());
			pst.setString(5, cliente.getIdEstado());
			pst.setString(6, cliente.getDireccion());
			
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
		
		return null;
	}

	
	
	@Override
	public int eliminarCliente(String idCliente) {
	
		return 0;
	}
	
	

	@Override
	public int editarCliente(Cliente cliente) {
		
		return 0;
	}
	
	

	@Override
	public Cliente obtenerCliente(String idCliente) {
		
		return null;
	}



}
