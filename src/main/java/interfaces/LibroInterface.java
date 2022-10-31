package interfaces;

import java.util.List;

import entidades.Categoria;
import entidades.Editorial;
import entidades.Estado;
import entidades.Libro;

public interface LibroInterface {

	public List<Libro> listarLibros();
	
	public int registrarLibro (Libro libro);
	
	public Libro obtenerLibro(String Id);
	
	public int editarLibro (Libro libro);
	
	public int eliminarLibro(String Id);
	
	public List<Editorial> listarEditorial();
	
	public List<Categoria> listarCategoria();
	
	public List<Estado> listarEstado();
}
