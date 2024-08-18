package clases;
import java.util.ArrayList;
import java.util.List;

public abstract class ISistema{
	
	public ISistema();
	
	// Falta destructor (busqué y creo que no tiene)
	
	// Le puse abstract a todo pero no se si esta bien
	
	public abstract bool AltaUsuarioCliente(String nickname, String email, String nombre, String apellido, DTFecha fechaNac, String imagen);
	
	public abstract bool AltaUsuarioProveedor(String nickname, String email, String nombre, String apellido, DTFecha fechaNac, String nomCompania, String linkWeb, String imagen);

	public abstract bool RegistrarProducto(String titulo, String numReferencia, String descrip, String especificaciones, int precio, Proveedor proveedor);
	
	public abstract DTProductoDetallado verInformaciónProducto(int numReferencia);

	public abstract List<DTCategoria> listarCategorias();

	public abstract bool elegirCategoria(String nombreCat);

	public abstract List<DTProducto> listarProductos();

	public abstract void altaCategoria(String nombre, bool tieneProductos, Categoría padre);

	public abstract List<DTOrdenDeCompra> listarOrdenesDeCompra();

	public abstract bool elegirOrdenDeCompra(int numero);

	public abstract DTOrdenCompraDetallada darAltaOrden();

	public abstract void cancelarOrdenDeCompra(int numero);

	public abstract bool agregarProducto(String nombreProducto, int cantidad);

	public abstract List<DTCliente> listarClientes();

	public abstract bool elegirCliente(String email);

	public abstract void quitarProductoDeCategorias();
}