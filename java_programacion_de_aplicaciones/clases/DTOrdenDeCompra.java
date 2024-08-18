package clases;

public class DTOrdenDeCompra {
	private int numero;
	private DTFecha fecha;
	private float precioTotal;
	private Cliente cliente;
	
	//getters y setters
	public int getNumero() {
		return numero;
	}
	
	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	public DTFecha getFecha() {
		return fecha;
	}
	
	public void setFecha(DTFecha fecha) {
		this.fecha = fecha;
	}
	
	public float getPrecioTotal() {
		return precioTotal;
	}
	
	public void setPrecioTotal(float precioTotal) {
		this.precioTotal = precioTotal;
	}
	
	//constructor
	public DTOrdenDeCompra(int numero, DTFecha fecha) {
		super();
		this.numero = numero;
		this.fecha = fecha;
	}
	
}
