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
				libro.setId(rst.getInt("Id"));
				libro.setTitulo(rst.getString("Titulo"));
				libro.setIsbn(rst.getString("Isbn"));
				libro.setAutor(rst.getString("Autor"));
				libro.setIdEditorial(rst.getInt("IdEditorial"));
				libro.setFechaPublicacion(rst.getDate("FechaPublicacion"));
				libro.setPrecio(rst.getDouble("Precio"));
				libro.setIdCategoria(rst.getInt("IdCategoria"));
				libro.setStock(rst.getInt("Stock"));
				libro.setIdEstado(rst.getInt("IdEstado"));
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
			String sql = "INSERT INTO cliente VALUES (null,?,?,?,null,?,?,null, null, null)";
			pst = cnn.prepareStatement(sql);
			
			pst.setString(1, libro.getTitulo());
			pst.setString(2, libro.getIsbn());
			pst.setString(3, libro.getAutor());
			pst.setInt(4, libro.getIdEditorial());
			pst.setDate(5, libro.getFechaPublicacion());
			pst.setDouble(6, libro.getPrecio());
			pst.setInt(7, libro.getIdCategoria());
			pst.setInt(8, libro.getStock());
			pst.setInt(9, libro.getIdEstado());
			
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

}
