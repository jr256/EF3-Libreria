package dao;

import interfaces.CategoriaInterface;
import interfaces.ClienteInterface;
import interfaces.DetalleVentaInterface;
import interfaces.EditorialInterface;
import interfaces.LibroInterface;
import interfaces.VentaInterface;
import modelo.CategoriaModelo;
import modelo.ClienteModelo;
import modelo.DetalleVentaModelo;
import modelo.EditorialModelo;
import modelo.LibroModelo;
import modelo.VentaModelo;

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
	public VentaInterface getVenta() {
		return new VentaModelo();
	}

	@Override
	public DetalleVentaInterface getDetalleVenta() {
		return new DetalleVentaModelo();
	}

	

}
