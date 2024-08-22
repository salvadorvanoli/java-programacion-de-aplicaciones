package clases;
// import java.util.ArrayList;
import java.util.List;

import excepciones.CategoriaNoExisteException;
import excepciones.CategoriaRepetidaException;
import excepciones.OrdenDeCompraNoExisteException;
// import excepciones.UsuarioNoExisteException;
import excepciones.UsuarioRepetidoException;
import excepciones.ProductoNoExisteException;
// import excepciones.ProductoRepetidoException;
import excepciones.UsuarioNoExisteException;

public abstract class ISistema{
	
	public ISistema() {};
	
	// Falta destructor (busqué y creo que no tiene)
	
	// Le puse abstract a todo pero no se si esta bien
	
	public abstract boolean AltaUsuarioCliente(String nickname, String email, String nombre, String apellido, DTFecha fechaNac, String imagen) throws UsuarioRepetidoException;
	
	public abstract boolean AltaUsuarioProveedor(String nickname, String email, String nombre, String apellido, DTFecha fechaNac, String nomCompania, String linkWeb, String imagen) throws UsuarioRepetidoException;

	public abstract boolean RegistrarProducto(String titulo, String numReferencia, String descrip, String especificaciones, int precio, Proveedor proveedor);
	
	public abstract DTProductoDetallado verInformaciónProducto(int numReferencia);

	public abstract List<DTCategoria> listarCategorias();

	public abstract boolean elegirCategoria(String nombreCat) throws CategoriaNoExisteException;

	public abstract List<DTProducto> listarProductos();
	
	public abstract boolean elegirProducto(String nombreProd) throws ProductoNoExisteException; // ESTA LA AGREGUÉ DESPUÉS

	public abstract void altaCategoria(String nombre, boolean tieneProductos, Categoria padre) throws CategoriaRepetidaException;

	public abstract List<DTOrdenDeCompra> listarOrdenesDeCompra();

	public abstract boolean elegirOrdenDeCompra(int numero) throws OrdenDeCompraNoExisteException;
	
	public abstract DTOrdenDeCompraDetallada verInformacionOrdenDeCompra(int numero);

	public abstract DTOrdenDeCompraDetallada darAltaOrden();

	public abstract void cancelarOrdenDeCompra(int numero) throws OrdenDeCompraNoExisteException;

	public abstract boolean agregarProducto(String nombreProducto, int cantidad) throws ProductoNoExisteException;

	public abstract List<DTCliente> listarClientes();

	public abstract boolean elegirCliente(String nickname) throws UsuarioNoExisteException;
	
	public abstract DTClienteDetallado verInformacionCliente();

	public abstract void quitarProductoDeCategorias();
}