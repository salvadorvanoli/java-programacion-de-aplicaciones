package clases;
import java.util.ArrayList;
import java.util.List;

public abstract class ISistema{
	
	public ISistema();
	
	// Falta destructor (busqué y creo que no tiene)
	
	// Le puse abstract a todo pero no se si esta bien
	
	public abstract boolean AltaUsuarioCliente(String nickname, String email, String nombre, String apellido, DTFecha fechaNac, String imagen);
	
	public abstract boolean AltaUsuarioProveedor(String nickname, String email, String nombre, String apellido, DTFecha fechaNac, String nomCompania, String linkWeb, String imagen);

	public abstract boolean RegistrarProducto(String titulo, String numReferencia, String descrip, String especificaciones, int precio, Proveedor proveedor);
	
	public abstract DTProductoDetallado verInformaciónProducto(int numReferencia);

	public abstract List<DTCategoria> listarCategorias();

	public abstract boolean elegirCategoria(String nombreCat);

	public abstract List<DTProducto> listarProductos();
	
	public abstract boolean elegirProducto(String nombreProd); // ESTA LA AGREGUÉ DESPUÉS

	public abstract void altaCategoria(String nombre, boolean tieneProductos, Categoria padre);

	public abstract List<DTOrdenDeCompra> listarOrdenesDeCompra();

	public abstract boolean elegirOrdenDeCompra(int numero);

	public abstract DTOrdenDeCompraDetallada darAltaOrden();

	public abstract void cancelarOrdenDeCompra(int numero);

	public abstract boolean agregarProducto(String nombreProducto, int cantidad);

	public abstract List<DTCliente> listarClientes();

	public abstract boolean elegirCliente(String email);

	public abstract void quitarProductoDeCategorias();
}