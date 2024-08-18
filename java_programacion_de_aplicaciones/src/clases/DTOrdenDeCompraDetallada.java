package clases;
import java.util.List;
import java.util.ArrayList;

public class DTOrdenDeCompraDetallada extends DTOrdenDeCompra{
	private List<DTCantidadProducto> productosCantidad;

	public DTOrdenDeCompraDetallada(int numero, DTFecha fecha, List<DTCantidadProducto> lista) {
		super(numero, fecha, lista);
	}

	public List<DTCantidadProducto> getProductosCantidad() {
		return productosCantidad;
	}

	public void setProductosCantidad(List<DTCantidadProducto> productosCantidad) {
		this.productosCantidad = productosCantidad;
	}
	
	
	
}
