package clases;

public class Cantidad {
	
	private Producto producto;
	private int cantidad;
	
	//constructor
	public Cantidad(Producto producto, int cantidad) {
		super();
		this.producto = producto;
		this.cantidad = cantidad;
	}
		
	//setters y getters
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
	
		
}
