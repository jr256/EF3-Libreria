package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import db.MysqlConexion;
import entidades.Categoria;
import interfaces.CategoriaInterface;

public class CategoriaModelo implements CategoriaInterface {

	@Override
	public int registrarCategoria(Categoria categoria) {
		int envio = 0;
		Connection con = null;
		PreparedStatement pst = null;
		
		try {
			
			con = MysqlConexion.getConexion();
			String sql = "CALL usp_Categoria_Insertar(?)";
			pst = con.prepareCall(sql);
			
			pst.setString(1, categoria.getCategoria());
	
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
	public int editarCategoria(Categoria categoria) {
		int value = 0;
		Connection cn = null;
		PreparedStatement pstm = null;
		
		try {
			cn = MysqlConexion.getConexion();
			String mySql = "CALL usp_Categoria_Actualizar(?,?)";
			
			pstm = cn.prepareCall(mySql);
			pstm.setString(1, categoria.getCategoria());
			pstm.setString(2, categoria.getId());
			
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
	public int eliminarCategoria(String idCategoria) {
		int salida = 0;	
		Connection cn = null;
		PreparedStatement pstm = null;
		
		try {	
			cn = MysqlConexion.getConexion();
			
			String sql = "CALL usp_Categoria_Eliminar(?)";
			pstm = cn.prepareCall(sql);
			pstm.setString(1, idCategoria);
			
			salida = pstm.executeUpdate();
		
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) pstm.close();
				if (cn != null) cn.close();
			} catch (Exception e) {
				e.getStackTrace();
			}
		}		
		return salida;
	}

	@Override
	public List<Categoria> listarCategoria() {
		List<Categoria> listCategoria = new ArrayList<Categoria>();
		Connection cn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		try {
			cn = MysqlConexion.getConexion();
			String sql = "CALL usp_Categoria_ListarTodos";
			pstm = cn.prepareCall(sql);
			rs = pstm.executeQuery();
			
			while (rs.next()) {
				Categoria categoria = new Categoria();
				categoria.setId(rs.getString("Id"));
				categoria.setCategoria(rs.getString("Categoria"));
		
				listCategoria.add(categoria);
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
		return listCategoria;
		
	}

	@Override
	public Categoria getCategoria(String idCategoria) {
		
		Categoria categoria = null;
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		try {
			
			con = MysqlConexion.getConexion();
			String sql = "CALL usp_Categoria_BuscarPorId(?)";
			pst = con.prepareCall(sql);
			pst.setString(1, idCategoria);
			
			
			rs = pst.executeQuery();
			if(rs.next()) {
				categoria = new Categoria();
				categoria.setId(rs.getString("Id"));
				categoria.setCategoria(rs.getString("Categoria"));
				
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
		
		return categoria;
	}

}
