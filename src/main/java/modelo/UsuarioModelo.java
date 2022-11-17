package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import db.MysqlConexion;
import entidades.Usuario;
import interfaces.UsuarioInterface;

public class UsuarioModelo implements UsuarioInterface {

	@Override
	public int registrarUsuario(Usuario usuario) {
		
		int salida = 0;
		Connection con = null;
		PreparedStatement pst = null;
		
		try {			
			
			con = MysqlConexion.getConexion();			
			String sql = "CALL usp_Usuario_Insertar(?, ?, ?, ?)";
			pst = con.prepareCall(sql);
			
			pst.setString(1,usuario.getNombres());
			pst.setString(2,usuario.getApellidos());
			pst.setString(3,usuario.getCorreo());
			pst.setString(4,usuario.getClave());
						
			salida = pst.executeUpdate();
			
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
		return salida;
	
	}

	@Override
	public List<Usuario> listarUsuarios() {
		
		List<Usuario> listaUsuarios = new ArrayList<Usuario>();
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rst = null;
		
		try {			
			con = MysqlConexion.getConexion();			
			String sql = "CALL usp_Usuario_ListarTodos";			
			pst = con.prepareCall(sql);
			rst = pst.executeQuery();
			
			while (rst.next()) {				
				Usuario usuario = new Usuario();
				usuario.setIdUsuario(rst.getString("Id"));
				usuario.setNombres(rst.getString("Nombres"));
				usuario.setApellidos(rst.getString("Apellidos"));
				usuario.setCorreo(rst.getString("Correo"));
				usuario.setClave(rst.getString("Clave"));				
				
				listaUsuarios.add(usuario);
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
		
		return listaUsuarios;
	}

}
