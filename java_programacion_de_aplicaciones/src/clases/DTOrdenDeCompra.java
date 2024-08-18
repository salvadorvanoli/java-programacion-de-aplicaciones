package clases;
import java.util.List;
import java.util.ArrayList;

public class DTOrdenDeCompra {
	private int numero;
	private DTFecha fecha;
	private float precioTotal;
	private Cliente cliente;
	
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
	public DTOrdenDeCompra(int numero, DTFecha fecha) {
		super();
		this.numero = numero;
		this.fecha = fecha;
	}
	
}
