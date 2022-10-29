package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entidades.Libro;
import interfaces.LibroInterface;
import db.MysqlConexion;

public class LibroModelo implements LibroInterface {

	public List<Libro> listarLibros() {
		
		List<Libro> listaLibro = new ArrayList<Libro>();
		Connection cnn = null;
		PreparedStatement pst = null;
		ResultSet rst = null;	
		try {
			cnn = MysqlConexion.getConexion();
			String sql = "SELECT Id, Titulo, Isbn, Autor, IdEditorial, FechaPublicacion,"
					+ "Precio, IdCategoria, Stock, IdEstado FROM libro";
			pst = cnn.prepareStatement(sql);
			rst = pst.executeQuery();
			
			while(rst.next()) {
				Libro libro = new Libro();
				libro.setId(rst.getString("Id"));
				libro.setTitulo(rst.getString("Titulo"));
				libro.setIsbn(rst.getString("Isbn"));
				libro.setAutor(rst.getString("Autor"));
				libro.setIdEditorial(rst.getString("IdEditorial"));
				libro.setFechaPublicacion(rst.getString("FechaPublicacion"));
				libro.setPrecio(rst.getString("Precio"));
				libro.setIdCategoria(rst.getString("IdCategoria"));
				libro.setStock(rst.getString("Stock"));
				libro.setIdEstado(rst.getString("IdEstado"));
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
			String sql = "INSERT INTO libro VALUES (null,?,?,?,null,?,?,null, null, null)";
			pst = cnn.prepareStatement(sql);
			
			pst.setString(1, libro.getTitulo());
			pst.setString(2, libro.getIsbn());
			pst.setString(3, libro.getAutor());
			pst.setString(4, libro.getIdEditorial());
			pst.setString(5, libro.getFechaPublicacion());
			pst.setString(6, libro.getPrecio());
			pst.setString(7, libro.getIdCategoria());
			pst.setString(8, libro.getStock());
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
				String sql = "UPDATE libro SET Titulo = ?, Isbn = ?, Autor = ?"
						+ ", IdEditorial = ?, FechaPublicacion = ?,"
						+ "Precio = ?, IdCategoria = ?, Stock = ?, IdEstado = ? WHERE Id = ?";
				
				pstm = cnn.prepareStatement(sql);
				pstm.setString(1, libro.getTitulo());
				pstm.setString(2, libro.getIsbn());
				pstm.setString(3, libro.getAutor());
				pstm.setString(4, libro.getIdEditorial());
				pstm.setString(5, libro.getFechaPublicacion());
				pstm.setString(6, libro.getPrecio());
				pstm.setString(7, libro.getIdCategoria());
				pstm.setString(8, libro.getStock());
				pstm.setString(9, libro.getIdEstado());
				pstm.setString(10, libro.getId());				
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
				String sql = "DELETE FROM libro WHERE Id = ?";
				pstm = cnn.prepareStatement(sql);
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

		
		public Libro getLibro (String Id) {
			Libro libro = null;
			Connection cnn = null;
			PreparedStatement psmt = null;
			ResultSet rst = null;
			try {
				cnn = MysqlConexion.getConexion();
				String mysql = "SELECT Id, Titulo, Isbn, Autor, IdEditorial, FechaPublicacion,"
						+ "Precio, IdCategoria, Stock, IdEstado FROM libro WHERE Id = ?";
				psmt = cnn.prepareStatement(mysql);
				psmt.setString(1, Id);
				rst = psmt.executeQuery();
				if(rst.next()) {
					libro = new Libro();
					libro.setId(rst.getString("Id"));
					libro.setTitulo(rst.getString("Titulo"));
					libro.setIsbn(rst.getString("Isbn"));
					libro.setAutor(rst.getString("Autor"));
					libro.setIdEditorial(rst.getString("IdEditorial"));
					libro.setFechaPublicacion(rst.getString("FechaPublicacion"));
					libro.setPrecio(rst.getString("Precio"));
					libro.setIdCategoria(rst.getString("IdCategoria"));
					libro.setStock(rst.getString("Stock"));
					libro.setIdEstado(rst.getString("IdEstado"));
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

}