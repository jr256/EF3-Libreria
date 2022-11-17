package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import db.MysqlConexion;
import entidades.Usuario;
import interfaces.AutenticacionInterface;

public class AutenticacionModelo implements AutenticacionInterface  {

	@Override
	public Usuario verificarInicioSesion(String correo, String clave) {
		
		Usuario usuario = null;		
		PreparedStatement pst = null;
		Connection con = null;
		ResultSet rst = null;
		
		try {			
			con = MysqlConexion.getConexion();			
			String mysql = "CALL usp_Usuario_Autenticacion(?,?)";				
				
			pst = con.prepareCall(mysql);
			pst.setString(1, correo);
			pst.setString(2, clave);			
			rst = pst.executeQuery();
			
			if (rst.next()) {
				usuario = new Usuario();
				usuario.setIdUsuario(rst.getString("Id"));
				usuario.setNombres(rst.getString("Nombres"));
				usuario.setApellidos(rst.getString("Apellidos"));				
				usuario.setCorreo(rst.getString("Correo"));
				
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
		
		return usuario;
			
	}

}
