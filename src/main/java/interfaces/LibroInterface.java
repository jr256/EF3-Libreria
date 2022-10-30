package interfaces;

import java.util.List;

import entidades.Libro;

public interface LibroInterface {

	public List<Libro> listarLibros();
	
	public int registrarLibro (Libro libro);
	
	public Libro getLibro(String Id);
	
	public int editarLibro (Libro libro);
	
	public int eliminarLibro(String Id);
}
