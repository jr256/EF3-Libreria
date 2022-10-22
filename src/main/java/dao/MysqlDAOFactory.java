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
import modelo.CategoriaModelo;
import modelo.ClienteModelo;
import modelo.DetalleEntradaModelo;
import modelo.DetalleVentaModelo;
import modelo.EntradaModelo;
import modelo.EditorialModelo;
import modelo.LibroModelo;
import modelo.ProveedorModelo;
import modelo.VentaModelo;

public class MysqlDAOFactory extends DAOFactory{

	@Override
	public ClienteInterface getCliente() {
		return new ClienteModelo();
	}

	@Override
	public ProveedorInterface getProveedor() {
		return new ProveedorModelo();
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

	@Override
	public ECompraInterface getECompra() {
		return new EntradaModelo();
	}

	@Override
	public DetalleECompraInterface getDetalleECompra() {
		return new DetalleEntradaModelo();
	}
	

}
