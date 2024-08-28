package clases;
import java.util.List;
import java.util.ArrayList;

public class Cantidad {
	
	private Producto producto;
	private int cantidad;
	
	public Producto getProducto() {
		return producto;
	}
	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	public Cantidad(int cantidad) {
		super();
		this.cantidad = cantidad;
	}
	
	public void linkProducto(Producto producto) {
		this.producto = producto;
	}
	
	public float getSubtotal() {
		return this.cantidad*this.producto.getPrecio();
	}
	
	public Cantidad(Producto producto, int cantidad) {
		super();
		this.producto = producto;
		this.cantidad = cantidad;
	}
	
	public DTCantidadProducto getDTCantidadProducto() {
		return new DTCantidadProducto(this, this.producto.getDTProducto(), this.getSubtotal());
	}
	
	public String toString() {
		return "Nombre del producto: " + this.producto.getNombreProducto() + System.lineSeparator()
		+ "Codigo del producto: " + this.producto.getNumReferencia() + System.lineSeparator()
        + "Cantidad del producto = " + this.cantidad + ";" + System.lineSeparator();
	}
}
