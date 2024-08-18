package clases;
import java.util.List;
import java.util.ArrayList;

public class DTOrdenDeCompraDetallada extends DTOrdenDeCompra{
	
	private List<DTCantidadProducto> productosCantidad;

	//constructor
	public DTOrdenDeCompraDetallada(int numero, DTFecha fecha, List<Cantidad> cantidad) {
		super(numero, fecha, cantidad);
	}
	
	//setters y getters
	public List<DTCantidadProducto> getProductosCantidad() {
		return productosCantidad;
	}

	public void setProductosCantidad(List<DTCantidadProducto> productosCantidad) {
		this.productosCantidad = productosCantidad;
	}
	
	
	
}
