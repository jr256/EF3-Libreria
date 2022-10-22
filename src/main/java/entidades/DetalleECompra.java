package entidades;

public class DetalleECompra {
	
	private int id;
	private int idECompra;
	private int idProducto;
	private int cantidad;
	private double costo;
	private double valorBruto;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdECompra() {
		return idECompra;
	}
	public void setIdECompra(int idECompra) {
		this.idECompra = idECompra;
	}
	public int getIdProducto() {
		return idProducto;
	}
	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public double getCosto() {
		return costo;
	}
	public void setCosto(double costo) {
		this.costo = costo;
	}
	public double getValorBruto() {
		return valorBruto;
	}
	public void setValorBruto(double valorBruto) {
		this.valorBruto = valorBruto;
	}
	
	

}
