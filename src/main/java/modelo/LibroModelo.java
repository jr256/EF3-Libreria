package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import entidades.Categoria;
import entidades.Cliente;
import entidades.Editorial;
import entidades.Estado;
import entidades.Libro;
import interfaces.LibroInterface;
import db.MysqlConexion;

public class LibroModelo implements LibroInterface {

	private static Logger log = Logger.getLogger(Cliente.class.getName());
	
	
	public List<Libro> listarLibros() {
		
		List<Libro> listaLibro = new ArrayList<Libro>();
		Connection cnn = null;
		PreparedStatement pst = null;
		ResultSet rst = null;	
		try {
			cnn = MysqlConexion.getConexion();
			String sql = "CALL usp_Libro_ListarTodos";
			pst = cnn.prepareCall(sql);
			rst = pst.executeQuery();
			
			while(rst.next()) {
				Libro libro = new Libro();
				libro.setId(rst.getString("Id"));
				libro.setTitulo(rst.getString("Titulo"));
				libro.setIsbn(rst.getString("Isbn"));
				libro.setAutor(rst.getString("Autor"));
				libro.setIdEditorial(rst.getString("IdEditorial"));
				libro.setEditorial(rst.getString("Editorial"));
				libro.setFechaPublicacion(rst.getString("FechaPublicacion"));
				libro.setPrecio(rst.getDouble("Precio"));
				libro.setIdCategoria(rst.getString("IdCategoria"));
				libro.setCategoria(rst.getString("Categoria"));
				libro.setStock(rst.getInt("Stock"));
				libro.setIdEstado(rst.getString("IdEstado"));
				libro.setEstado(rst.getString("Estado"));
				listaLibro.add(libro);	
			}			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rst != null) rst.close();
				if(pst != null) pst.close();
				if(cnn != null) cnn.close();			
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return listaLibro;
	}
	
	
	public int registrarLibro(Libro libro) {
		
		int book = 0;
		Connection cnn = null;
		PreparedStatement pst = null;
		try {
			cnn = MysqlConexion.getConexion();
			String sql = "CALL usp_Libro_Insertar(?,?,?,?,?,?,?,?,?)";
			pst = cnn.prepareCall(sql);
			
			pst.setString(1, libro.getTitulo());
			pst.setString(2, libro.getIsbn());
			pst.setString(3, libro.getAutor());
			pst.setString(4, libro.getIdEditorial());
			pst.setString(5, libro.getFechaPublicacion());
			pst.setDouble(6, libro.getPrecio());
			pst.setString(7, libro.getIdCategoria());
			pst.setInt(8, libro.getStock());
			pst.setString(9, libro.getIdEstado());
			
			book = pst.executeUpdate();	
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pst != null) pst.close();
				if(cnn != null) pst.close();				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}		
		return book;
	}

		
	public int editarLibro (Libro libro) {
			
			int libros = 0;
			Connection cnn = null;
			PreparedStatement pstm = null;
			try {
				cnn = MysqlConexion.getConexion();
				String sql = "CALL usp_Libro_Actualizar(?,?,?,?,?,?,?,?,?,?)";
				
				pstm = cnn.prepareCall(sql);
				pstm.setString(1, libro.getTitulo());
				pstm.setString(2, libro.getIsbn());
				pstm.setString(3, libro.getAutor());
				pstm.setString(4, libro.getIdEditorial());
				pstm.setString(5, libro.getFechaPublicacion());
				pstm.setDouble(6, libro.getPrecio());
				pstm.setString(7, libro.getIdCategoria());
				pstm.setInt(8, libro.getStock());
				pstm.setString(9, libro.getIdEstado());
				pstm.setString(10, libro.getId());		
				
				log.info("SQL Query de actualización ----> " + pstm);
				
				libros = pstm.executeUpdate();
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					if (pstm != null) pstm.close();
					if (cnn != null) cnn.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			return libros;
		}

		
	public int eliminarLibro(String Id) {
			
			int libros = 0;
			Connection cnn = null;
			PreparedStatement pstm = null;
			
			try {
				cnn = MysqlConexion.getConexion();
				String sql = "CALL usp_Libro_Eliminar(?)";
				pstm = cnn.prepareCall(sql);
				pstm.setString(1, Id);
				libros = pstm.executeUpdate();
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					if (pstm != null) pstm.close();
					if (cnn != null) cnn.close();
				} catch (Exception e) {
					
				}
			}
			return libros;
		}

		
	public Libro obtenerLibro (String Id) {
			Libro libro = null;
			Connection cnn = null;
			PreparedStatement psmt = null;
			ResultSet rst = null;
			try {
				cnn = MysqlConexion.getConexion();
				String mysql = "CALL usp_Libro_BuscarPorId(?)";
				psmt = cnn.prepareCall(mysql);
				psmt.setString(1, Id);
				log.info("SQL Query de consulta ----> " + psmt);
				rst = psmt.executeQuery();
				if(rst.next()) {
					libro = new Libro();
					libro.setId(rst.getString("Id"));
					libro.setTitulo(rst.getString("Titulo"));
					libro.setIsbn(rst.getString("Isbn"));
					libro.setAutor(rst.getString("Autor"));
					libro.setIdEditorial(rst.getString("IdEditorial"));
					libro.setEditorial(rst.getString("Editorial"));
					libro.setFechaPublicacion(rst.getString("FechaPublicacion"));
					libro.setPrecio(rst.getDouble("Precio"));
					libro.setIdCategoria(rst.getString("IdCategoria"));
					libro.setCategoria(rst.getString("Categoria"));
					libro.setStock(rst.getInt("Stock"));
					libro.setIdEstado(rst.getString("IdEstado"));
					libro.setEstado(rst.getString("Estado"));
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					if (rst != null) rst.close();
					if (psmt != null) psmt.close();
					if (cnn != null) cnn.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			return libro;
		}
		
		
	public List<Editorial> listarEditorial() {
			
			List<Editorial> listaEditorial = new ArrayList<Editorial>();
			Connection cnn = null;
			PreparedStatement pstm = null;
			ResultSet rs = null;
			
			try {
				cnn = MysqlConexion.getConexion();
				String sql = "SELECT * FROM editorial";
				pstm = cnn.prepareStatement(sql);
				rs = pstm.executeQuery();
				while (rs.next()) {
					
					Editorial editorial = new Editorial();
					editorial.setId(rs.getString("Id"));
					editorial.setEditorial(rs.getString("Editorial"));
					listaEditorial.add(editorial);
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					if (rs != null) rs.close();
					if (pstm != null) pstm.close();
					if (cnn != null) cnn.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			return listaEditorial;
		}

		
	public List<Categoria> listarCategoria() {
			
			List<Categoria> listaCategoria = new ArrayList<Categoria>();
			Connection cnn = null;
			PreparedStatement pstm = null;
			ResultSet rs = null;
			
			try {
				cnn = MysqlConexion.getConexion();
				String sql = "SELECT * FROM categoria";
				pstm = cnn.prepareStatement(sql);
				rs = pstm.executeQuery();
				while (rs.next()) {
					
					Categoria categoria = new Categoria();
					categoria.setId(rs.getString("Id"));
					categoria.setCategoria(rs.getString("Categoria"));
					listaCategoria.add(categoria);
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					if (rs != null) rs.close();
					if (pstm != null) pstm.close();
					if (cnn != null) cnn.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			return listaCategoria;
		}
		
	public List<Estado> listarEstado() {
			
			List<Estado> listaEstado = new ArrayList<Estado>();
			Connection cnn = null;
			PreparedStatement pstm = null;
			ResultSet rs = null;
			
			try {
				cnn = MysqlConexion.getConexion();
				String sql = "SELECT * FROM estado";
				pstm = cnn.prepareStatement(sql);
				rs = pstm.executeQuery();
				while (rs.next()) {
					
					Estado estado = new Estado();
					estado.setId(rs.getString("Id"));
					estado.setEstado(rs.getString("Estado"));
					listaEstado.add(estado);
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					if (rs != null) rs.close();
					if (pstm != null) pstm.close();
					if (cnn != null) cnn.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			return listaEstado;
		}

}