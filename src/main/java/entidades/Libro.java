package entidades;

public class Libro {
	
	private String Id;
	private String Titulo;
	private String Isbn;
	private String Autor;
	private String IdEditorial;
	private String Editorial;//
	private String FechaPublicacion;
	private String Precio;
	private String IdCategoria;
	private String Categoria;//
	private String Stock;
	private String idEstado;
	private String Estado;//
	
	
	
	public String getId() {
		return Id;
	}
	public void setId(String id) {
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
	public String getIdEditorial() {
		return IdEditorial;
	}
	public void setIdEditorial(String idEditorial) {
		IdEditorial = idEditorial;
	}
	public String getFechaPublicacion() {
		return FechaPublicacion;
	}
	public void setFechaPublicacion(String fechaPublicacion) {
		FechaPublicacion = fechaPublicacion;
	}
	public String getPrecio() {
		return Precio;
	}
	public void setPrecio(String precio) {
		Precio = precio;
	}
	public String getIdCategoria() {
		return IdCategoria;
	}
	public void setIdCategoria(String idCategoria) {
		IdCategoria = idCategoria;
	}
	public String getStock() {
		return Stock;
	}
	public void setStock(String stock) {
		Stock = stock;
	}
	public String getIdEstado() {
		return idEstado;
	}
	public void setIdEstado(String idEstado) {
		this.idEstado = idEstado;
	}
	public String getEditorial() {
		return Editorial;
	}
	public void setEditorial(String editorial) {
		Editorial = editorial;
	}
	public String getCategoria() {
		return Categoria;
	}
	public void setCategoria(String categoria) {
		Categoria = categoria;
	}
	public String getEstado() {
		return Estado;
	}
	public void setEstado(String estado) {
		Estado = estado;
	}
	
	
}