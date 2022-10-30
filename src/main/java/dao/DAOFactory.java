package dao;

import interfaces.AutenticacionInterface;
import interfaces.CategoriaInterface;
import interfaces.ClienteInterface;
import interfaces.EditorialInterface;
import interfaces.LibroInterface;
import interfaces.UsuarioInterface;

public abstract class DAOFactory {
	
	public static final int MYSQL = 1;
	public static final int SQLSERVER = 2;
	public static final int ORACLE = 3;
	
	public abstract AutenticacionInterface getAutenticacion();
	public abstract UsuarioInterface getUsuario();
	
	public abstract ClienteInterface getCliente();
	public abstract LibroInterface getLibro();
	public abstract EditorialInterface getEditorial();
	public abstract CategoriaInterface getCategoria();
	
	
	public static DAOFactory getDaoFactory(int tipo) {
		
			switch (tipo) {
			case MYSQL:
				return new MysqlDAOFactory();
			case SQLSERVER:
				return null;			
			case ORACLE:
				return null;
			default:
				return null;
			}
		
	}

}
