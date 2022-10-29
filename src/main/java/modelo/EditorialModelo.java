package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import db.MysqlConexion;

import entidades.Editorial;
import interfaces.EditorialInterface;

public class EditorialModelo implements EditorialInterface {

	@Override
	public int registrarEditorial(Editorial editorial) {
		int envio = 0;
		Connection con = null;
		PreparedStatement pst = null;
		
		try {
			
			con = MysqlConexion.getConexion();
			String sql = "insert into editorial values(null, ?)";
			pst = con.prepareStatement(sql);
			
			pst.setString(1, editorial.getEditorial());
	
			envio = pst.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pst != null) pst.close();
				if(con != null) pst.close();				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return envio;
	}

	@Override
	public int editarEditorial(Editorial editorial) {
		int value = 0;
		Connection cn = null;
		PreparedStatement pstm = null;
		
		try {
			cn = MysqlConexion.getConexion();
			String mySql = "update editorial set Editorial = ? where Id = ?";
			
			pstm = cn.prepareStatement(mySql);
			pstm.setString(1, editorial.getEditorial());
			pstm.setString(2, editorial.getId());
			
			value = pstm.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstm != null) pstm.close();
				if(cn != null) cn.close();
			} catch (Exception e) {
				  e.printStackTrace();
			}
		}
		return value;
	}

	@Override
	public int eliminarEditorial(String idEditorial) {
		int salida = 0;	
		Connection cn = null;
		PreparedStatement pstm = null;
		
		try {	
			cn = MysqlConexion.getConexion();
			
			String sql = "delete from editorial where Id = ?";
			pstm = cn.prepareStatement(sql);
			pstm.setString(1, idEditorial);
			
			salida = pstm.executeUpdate();
		
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) pstm.close();
				if (cn != null) cn.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}		
		return salida;
	}

	@Override
	public List<Editorial> listarEditorial() {
		List<Editorial> listEditorial = new ArrayList<Editorial>();
		Connection cn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		try {
			cn = MysqlConexion.getConexion();
			String sql = "select Id, Editorial from editorial";
			pstm = cn.prepareStatement(sql);
			rs = pstm.executeQuery();
			
			while (rs.next()) {
				Editorial editorial = new Editorial();
				editorial.setId(rs.getString("Id"));
				editorial.setEditorial(rs.getString("Editorial"));
		
				listEditorial.add(editorial);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) rs.close();
				if (pstm != null) pstm.close();
				if (cn != null) cn.close();
			} catch (Exception e) {
				
			}
		}
		return listEditorial;
	}

	@Override
	public Editorial getEditorial(String idEditorial) {
		
		Editorial editorial = null;
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		try {
			
			con = MysqlConexion.getConexion();
			String sql = "select * from editorial where id = ?";
			pst = con.prepareStatement(sql);
			pst.setString(1, idEditorial);
			
			
			rs = pst.executeQuery();
			if(rs.next()) {
				editorial = new Editorial();
				editorial.setId(rs.getString("Id"));
				editorial.setEditorial(rs.getString("Editorial"));
				
			}

			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) rs.close();
				if(pst != null) pst.close();
				if(con != null) pst.close();				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return editorial;
	}
	
	
	
	
}
