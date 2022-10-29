package interfaces;

import java.util.List;

import entidades.Editorial;

public interface EditorialInterface {
	public int registrarEditorial(Editorial editorial);
	public int editarEditorial(Editorial editorial);
	public int eliminarEditorial(String idEditorial);
	public List<Editorial> listarEditorial();
	public Editorial getEditorial(String idEditorial);
	

}
