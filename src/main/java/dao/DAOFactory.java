package dao;

import interfaces.CategoriaInterface;
import interfaces.ClienteInterface;
import interfaces.DetalleECompraInterface;
import interfaces.DetalleVentaInterface;
import interfaces.ECompraInterface;
import interfaces.EditorialInterface;
import interfaces.LibroInterface;
import interfaces.ProveedorInterface;
import interfaces.VentaInterface;

public abstract class DAOFactory {
	
	public static final int MYSQL = 1;
	public static final int SQLSERVER = 2;
	public static final int ORACLE = 3;
	
	public abstract ClienteInterface getCliente();
	public abstract ProveedorInterface getProveedor();
	public abstract LibroInterface getLibro();
	public abstract EditorialInterface getEditorial();
	public abstract CategoriaInterface getCategoria();
	
	public abstract VentaInterface getVenta();
	public abstract DetalleVentaInterface getDetalleVenta();
	public abstract ECompraInterface getECompra();
	public abstract DetalleECompraInterface getDetalleECompra();

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
