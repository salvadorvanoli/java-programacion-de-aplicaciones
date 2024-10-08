package clases;
import java.util.HashMap;
// import java.util.ArrayList;
import java.util.List;

import excepciones.CategoriaNoExisteException;
import excepciones.CategoriaRepetidaException;
import excepciones.OrdenDeCompraNoExisteException;
// import excepciones.UsuarioNoExisteException;
import excepciones.UsuarioRepetidoException;
import excepciones.ProductoNoExisteException;
import excepciones.ProductoRepetidoException;
// import excepciones.ProductoRepetidoException;
import excepciones.UsuarioNoExisteException;

public abstract class ISistema{
	
	public ISistema() {};
	
	// También agrego los getters
	
	public abstract List<Usuario> getUsuarios();
	
	public abstract HashMap<Integer, OrdenDeCompra> getOrdenes();
	
	public abstract HashMap<String, Categoria> getCategorias();
	
	public abstract Usuario getUsuarioActual();
	
	public abstract OrdenDeCompra getOrdenDeCompraActual();
	
	public abstract Categoria getCategoriaActual();
	
	public abstract Producto getProductoActual();
	
	// Falta destructor (busqué y creo que no tiene)
	
	// Le puse abstract a todo pero no se si esta bien
	
	public abstract DTFecha getFechaActual();
	
	public abstract boolean altaUsuarioCliente(String nickname, String email, String nombre, String apellido, DTFecha fechaNac, String imagen) throws UsuarioRepetidoException;
	
	public abstract boolean altaUsuarioProveedor(String nickname, String email, String nombre, String apellido, DTFecha fechaNac, String nomCompania, String linkWeb, String imagen) throws UsuarioRepetidoException;

	public abstract boolean registrarProducto(String titulo, int numReferencia, String descrip, String especificaciones, int precio) throws ProductoRepetidoException;
	
	public abstract DTProductoDetallado verInformacionProducto();

	public abstract List<DTCategoria> listarCategorias();

	public abstract boolean elegirCategoria(String nombreCat) throws CategoriaNoExisteException;

	public abstract List<DTProducto> listarProductos();
	
	public abstract boolean elegirProducto(String nombreProd) throws ProductoNoExisteException; // ESTA LA AGREGUÉ DESPUÉS

	public abstract void altaCategoria(String nombre, boolean tieneProductos, Categoria padre) throws CategoriaRepetidaException;

	public abstract List<DTOrdenDeCompra> listarOrdenesDeCompra();

	public abstract boolean elegirOrdenDeCompra(int numero) throws OrdenDeCompraNoExisteException;
	
	public abstract DTOrdenDeCompraDetallada verInformacionOrdenDeCompra(int numero);
	
	public abstract int generarCodigoOrden();

	public abstract DTOrdenDeCompraDetallada darAltaOrden() throws UsuarioNoExisteException;

	public abstract void cancelarOrdenDeCompra(int numero) throws OrdenDeCompraNoExisteException;

	public abstract boolean agregarProducto(String nombreProducto, int cantidad) throws ProductoNoExisteException;

	public abstract List<DTCliente> listarClientes();

	public abstract boolean elegirCliente(String nickname) throws UsuarioNoExisteException;
	
	public abstract DTClienteDetallado verInformacionCliente();

	public abstract void quitarProductoDeCategorias();
	
	public abstract void agregarProductoACategorias(List<Categoria> listaCat);
	
	public abstract void agregarCategoriasAProducto(List<Categoria> listaCat);
	
	public abstract void modificarDatosProducto(String nombreProd, int numReferencia, String descripcion, float precio, String especificacion) throws ProductoRepetidoException;
	
	public abstract void modificarImagenesProducto(List<String> imagenes);
	
	public abstract List<DTProveedor> listarProveedores();
	
	public abstract void elegirProveedor(String nickname) throws UsuarioNoExisteException;
	
	public abstract DTProveedorDetallado verInformacionProveedor();
	
	public abstract void setTodoNull();
}