package interfaces;

import java.util.List;
import entidades.Categoria;

public interface CategoriaInterface {
	
	public int registrarCategoria(Categoria categoria);
	public int editarCategoria(Categoria categoria);
	public int eliminarCategoria(String idCategoria);
	public List<Categoria> listarCategoria();
	public Categoria getCategoria(String idCategoria);
	

}
