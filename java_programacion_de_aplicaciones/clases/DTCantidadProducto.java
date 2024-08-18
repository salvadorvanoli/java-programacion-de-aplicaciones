package clases;

public class DTCantidadProducto {
	
	private Cantidad cantidad;
	private DTProducto producto;
	private float subtotal;
	
	//constructor
	public DTCantidadProducto(Cantidad cantidad, DTProducto producto, float subtotal) {
		super();
		this.cantidad = cantidad;
		this.producto = producto;
		this.subtotal = subtotal;
	}
	
	//setters y getters
	public Cantidad getCantidad() {
		return cantidad;
	}
	
	public void setCantidad(Cantidad cantidad) {
		this.cantidad = cantidad;
	}
	
	public DTProducto getProducto() {
		return producto;
	}
	
	public void setProducto(DTProducto producto) {
		this.producto = producto;
	}
	
	public float getSubtotal() {
		return subtotal;
	}
	
	public void setSubtotal(float subtotal) {
		this.subtotal = subtotal;
	}	
	
}
