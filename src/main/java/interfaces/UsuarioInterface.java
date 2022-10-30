package interfaces;

import java.util.List;

import entidades.Usuario;

public interface UsuarioInterface {
	
	public int registrarUsuario(Usuario usuario);
	
	public List<Usuario> listarUsuarios();
	

}
