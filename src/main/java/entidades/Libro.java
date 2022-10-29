package entidades;

import java.sql.Date;

public class Libro {
	
	private int Id;
	private String Titulo;
	private String Isbn;
	private String Autor;
	private int IdEditorial;
	private Date FechaPublicacion;
	private double Precio;
	private int IdCategoria;
	private int Stock;
	private int idEstado;
	
	
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getTitulo() {
		return Titulo;
	}
	public void setTitulo(String titulo) {
		Titulo = titulo;
	}
	public String getIsbn() {
		return Isbn;
	}
	public void setIsbn(String isbn) {
		Isbn = isbn;
	}
	public String getAutor() {
		return Autor;
	}
	public void setAutor(String autor) {
		Autor = autor;
	}
	public int getIdEditorial() {
		return IdEditorial;
	}
	public void setIdEditorial(int idEditorial) {
		IdEditorial = idEditorial;
	}
	public Date getFechaPublicacion() {
		return FechaPublicacion;
	}
	public void setFechaPublicacion(Date fechaPublicacion) {
		FechaPublicacion = fechaPublicacion;
	}
	public double getPrecio() {
		return Precio;
	}
	public void setPrecio(double precio) {
		Precio = precio;
	}
	public int getIdCategoria() {
		return IdCategoria;
	}
	public void setIdCategoria(int idCategoria) {
		IdCategoria = idCategoria;
	}
	public int getStock() {
		return Stock;
	}
	public void setStock(int stock) {
		Stock = stock;
	}
	public int getIdEstado() {
		return idEstado;
	}
	public void setIdEstado(int idEstado) {
		this.idEstado = idEstado;
	}
	
	
	
	
}