package dao;

import interfaces.AutenticacionInterface;
import interfaces.CategoriaInterface;
import interfaces.ClienteInterface;
import interfaces.EditorialInterface;
import interfaces.LibroInterface;
import interfaces.UsuarioInterface;
import modelo.AutenticacionModelo;
import modelo.CategoriaModelo;
import modelo.ClienteModelo;
import modelo.EditorialModelo;
import modelo.LibroModelo;
import modelo.UsuarioModelo;

public class MysqlDAOFactory extends DAOFactory{

	@Override
	public ClienteInterface getCliente() {
		return new ClienteModelo();
	}

	@Override
	public LibroInterface getLibro() {
		return new LibroModelo();
	}

	@Override
	public EditorialInterface getEditorial() {
		return new EditorialModelo();
	}

	@Override
	public CategoriaInterface getCategoria() {
		return new CategoriaModelo();
	}

	@Override
	public AutenticacionInterface getAutenticacion() {
		return new AutenticacionModelo();
	}

	@Override
	public UsuarioInterface getUsuario() {
		return new UsuarioModelo();
	}

	

}
