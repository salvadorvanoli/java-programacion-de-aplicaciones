package clases;
import java.util.List;
import java.util.ArrayList;

public class DTOrdenDeCompraDetallada extends DTOrdenDeCompra{
	private List<DTCantidadProducto> productosCantidad;

	public DTOrdenDeCompraDetallada(int numero, Cliente cliente, float precio, DTFecha fecha, List<Cantidad> cantidad, List<DTCantidadProducto> lista) {
		super(numero, cliente, precio, fecha, cantidad);
		this.productosCantidad = lista;
	}

	public List<DTCantidadProducto> getProductosCantidad() {
		return productosCantidad;
	}

	public void setProductosCantidad(List<DTCantidadProducto> productosCantidad) {
		this.productosCantidad = productosCantidad;
	}

	@Override
	public String toString(){
	    String retorno = "Orden de Compra " + this.getNumero() + System.lineSeparator()
	                + "Fecha: " + this.getFecha() + System.lineSeparator()
	                + "Precio total: " + this.getPrecioTotal() + System.lineSeparator()
	                + "Nombre cliente: " + this.getCliente().getNickname() + System.lineSeparator()
	                + System.lineSeparator() +  "-------------------- PRODUCTOS --------------------" + System.lineSeparator() + System.lineSeparator();
	    Integer i = 1;
	    for (DTCantidadProducto prod : this.productosCantidad){
	        retorno += "Producto número " + i.toString() + ": "  + System.lineSeparator() + prod.toString() + System.lineSeparator();
	        i++;
	    }
	    return retorno;
	}
	
	
	
}
