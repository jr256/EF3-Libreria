package interfaces;

import entidades.Usuario;

public interface AutenticacionInterface {
	
	public Usuario verificarInicioSesion(String correo, String clave);
}
