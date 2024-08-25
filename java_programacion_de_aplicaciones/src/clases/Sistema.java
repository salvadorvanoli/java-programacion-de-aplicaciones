package clases;

import java.util.ArrayList;
import java.util.List;

import java.util.HashMap;
import java.util.Map;

// Importamos las excepciones necesarias

import excepciones.UsuarioNoExisteException;
import excepciones.UsuarioRepetidoException;
import excepciones.CategoriaNoExisteException;
import excepciones.CategoriaRepetidaException;
import excepciones.ProductoNoExisteException;
import excepciones.ProductoRepetidoException;
import excepciones.OrdenDeCompraNoExisteException;
import excepciones.OrdenDeCompraRepetidaException;

public class Sistema extends ISistema {
	
	private List<Usuario> usuarios;
	private Usuario usuarioActual;
	
	private HashMap<Integer, OrdenDeCompra> ordenes;
	private OrdenDeCompra ordenActual;
	
	private HashMap<String, Categoria> categorias;
	private Categoria categoriaActual;
	
	private Producto productoActual;
	
	private List<Cantidad> listaOrden; // ESTO ES RE ILEGAL
	
	public Sistema() {
		this.usuarios = new ArrayList<>();
		this.ordenes = new HashMap<Integer, OrdenDeCompra>();
		this.categorias = new HashMap<String, Categoria>();
		this.usuarioActual = null;
		this.ordenActual = null;
		this.categoriaActual = null;
		this.productoActual = null;
		this.listaOrden = new ArrayList<>();
	}
	
	@Override // NO ES NECESARIO QUE SEA BOOL
	public boolean altaUsuarioCliente(String nickname, String email, String nombre, String apellido, DTFecha fechaNac, String imagen) throws UsuarioRepetidoException {
		for (Usuario user : this.usuarios) {
			if (user.getEmail() == email) {
				throw new UsuarioRepetidoException("Error: Ya existe un cliente registrado con el email " + '"' + email + '"' + '.');
			}
			if (user.getNickname() == nickname) {
				throw new UsuarioRepetidoException("Error: Ya existe un cliente registrado con el nickname"  + '"' + nickname + '"' + '.');
			}
		}
		Cliente nuevo = new Cliente(nickname, nombre, apellido, email, fechaNac, imagen); // ESTO HAY QUE CAMBIARLO
		this.usuarios.add(nuevo);
		return true;
	}
	
	@Override // NO ES NECESARIO QUE SEA BOOL
	public boolean altaUsuarioProveedor(String nickname, String email, String nombre, String apellido, DTFecha fechaNac, String nomCompania, String linkWeb, String imagen) throws UsuarioRepetidoException {
		for (Usuario user : this.usuarios) {
			if (user.getEmail() == email) {
				throw new UsuarioRepetidoException("Error: Ya existe un proveedor registrado con el email " + '"' + email + '"' + '.');
			}
			if (user.getNickname() == nickname) {
				throw new UsuarioRepetidoException("Error: Ya existe un proveedor registrado con el nickname " + '"' + nickname + '"' + '.');
			}
		}
		Proveedor nuevo = new Proveedor(nickname, nombre, apellido, email, fechaNac, imagen, nomCompania, linkWeb);
		this.usuarios.add(nuevo);
		return true;
	}
	
	// ESTA FUNCION HAY QUE RE CHEQUEARLA
	@Override
	public boolean registrarProducto(String titulo, int numReferencia, String descrip, String especificaciones, int precio, Proveedor proveedor) throws ProductoRepetidoException {
		for (Categoria cat : this.categorias.values()) {
			for (Producto prod : cat.getProductos()) {
				if (prod.getNombreProducto() == titulo) {
					if (prod.getNumReferencia() == numReferencia) {
						throw new ProductoRepetidoException("Error: Ya existe un producto de nombre " + '"' + nombreProd + '"' + " y número de referencia " + '"' + numReferencia + '"' + '.');
					}
				}
			}
		}
		Producto prod = new Producto(titulo, descrip, especificaciones, numReferencia, precio, null, null, proveedor); // Esto esta re mal
		proveedor.agregarProducto(prod);
		this.productoActual = prod;
		return true;
	}
	
	@Override // Lo podría leer directamente
	public DTProductoDetallado verInformacionProducto(int numReferencia) {
		if (this.productoActual == null) {
			throw new NullPointerException("Error: No se ha elegido un producto previamente.");
		}
		return this.productoActual.getDTProductoDetallado();
	}

	@Override
	public List<DTCategoria> listarCategorias(){
		List<DTCategoria> lista = new ArrayList<>();
		for (Categoria cat : this.categorias.values()) {
			DTCategoria dt = cat.getDTCategoria();
			lista.add(dt);
		}
		return lista;
	}
	
	/* OTRA FORMA --> No se recorre dos veces la lista (para hacerla y para imprimirla)
	@Override
	public void listarCategorias(){
		System.out.println("---CATEGORIAS---\n");
		int count = 1;
		for (Categoria cat : this.categorias) {
			DTCategoria dt = cat.getDTCategoria();
			System.out.println("CATEGORIA " + count + "\n" +  dt.toString()); // TENEMOS QUE SOBREESCRIBIR EL METODO toString de la clase DTCategoria
			count++;
		}
	}
	*/

	@Override
	public boolean elegirCategoria(String nombreCat) throws CategoriaNoExisteException { // No creo que sea necesario que sean bool (todos los elegir)
		Categoria cat = this.categorias.get(nombreCat);
        if (cat == null){
            throw new CategoriaNoExisteException("Error: La categoría de nombre " + '"' + nombreCat + '"' + " no existe.");
        }
        this.categoriaActual = cat;
        return true;
	}

	@Override
	public List<DTProducto> listarProductos(){
		if (this.categoriaActual == null) {
			throw new NullPointerException("Error: No se ha elegido una categoría previamente.");
		}
		List<DTProducto> lista = this.categoriaActual.listarProductos();
		return lista;
	}
	
	/* OTRA FORMA --> No se recorre dos veces la lista (para hacerla y para imprimirla)
	@Override
	public void listarProductos(){
		System.out.println("---PRODUCTOS---\n");
		int count = 1;
		for (Producto prod : this.categoriaActual.getProductos()) {
			DTProducto dt = cat.getDTProducto();
			System.out.println("PRODUCTO " + count + "\n" +  dt.toString()); // TENEMOS QUE SOBREESCRIBIR EL METODO toString de la clase DTProducto
			count++;
		}
	}
	*/

	// No se si incluir el numero de referencia (para buscar el producto)
	@Override
	public boolean elegirProducto(String nombreProd) throws ProductoNoExisteException {
		if (this.categoriaActual == null) {
			throw new NullPointerException("Error: No se ha elegido una categoría previamente.");
		}
		Producto prod = this.categoriaActual.seleccionarProducto(nombreProd);
		if (prod == null) {
			throw new ProductoNoExisteException("Error: El producto de nombre " + '"' + nombreProd + '"' + " no existe.");
		}
		this.productoActual = prod;
		return true;
	}
	/*
	public boolean elegirProducto(String nombreProd) throws ProductoNoExisteException {
		if (this.categoriaActual == null) {
			throw new NullPointerException("Error: No se ha elegido una categoría previamente.");
		}
		for (Producto prod : this.categoriaActual.getProductos()) {
			if (prod.getNombre() == nombreProd) {
				this.productoActual = prod;
				return true; // Capaz hacemos que no retorne nada
			}
		}
		throw new ProductoNoExisteException("Error: El producto de nombre " + '"' + nombreProd + '"' + " no existe.");
	}
	*/
	
	@Override
	public void altaCategoria(String nombre, boolean tieneProductos, Categoria padre) throws CategoriaRepetidaException{
        if (this.categorias.containsKey(nombre)) {
            throw new CategoriaRepetidaException("Error: Ya existe una categoría con el nombre " + '"' + nombre + '"' + '.');
        }
		Categoria cat = new Categoria(nombre, tieneProductos, padre);
		this.categorias.put(nombre, cat);
	}

	@Override
	public List<DTOrdenDeCompra> listarOrdenesDeCompra(){
		List<DTOrdenDeCompra> lista = new ArrayList<>();
		for (OrdenDeCompra ord : this.ordenes.values()) {
			DTOrdenDeCompra dt = ord.getDTOrden(); // Capaz la función no se llama así
			lista.add(dt);
		}
		return lista;
	}
	
	/* OTRA FORMA --> No se recorre dos veces la lista (para hacerla y para imprimirla)
	@Override
	public void listarOrdenesDeCompra(){
		System.out.println("---ORDENES DE COMPRA---\n");
		int count = 1;
		for (OrdenDeCompra ord : this.ordenes) {
			DTOrdenDeCompra dt = ord.getDTOrden(); // Capaz la función no se llama así
			System.out.println("ORDEN DE COMPRA " + count + "\n" +  dt.toString()); // TENEMOS QUE SOBREESCRIBIR EL METODO toString de la clase DTOrdenDeCompra
			count++;
		}
	}
	*/

	@Override
	public boolean elegirOrdenDeCompra(int numero) throws OrdenDeCompraNoExisteException {
        OrdenDeCompra ord = this.ordenes.get(numero);
        if (ord == null) {
            throw new OrdenDeCompraNoExisteException("Error: La orden de compra número " + '"' + numero + '"' + " no existe.");
        }
        this.ordenActual = ord;
        return true; // No es necesario que sea bool
	}
	
	@Override
	public DTOrdenDeCompraDetallada verInformacionOrdenDeCompra(int numero) {
		if (this.ordenActual == null) {
			throw new NullPointerException("Error: No se ha elegido una orden de compra previamente.");
		}
		return this.ordenActual.getDTOrdenDetallada();
	}
	
	@Override
	public int generarCodigoOrden() {
		if (this.ordenes.isEmpty()) {
			return 1;
		}
		int numero = 0;
		for (int key : this.ordenes.keySet()) {
			if (key > numero) {
				numero = key;
			}
		}
		return numero;
	}

	@Override
	public DTOrdenDeCompraDetallada darAltaOrden() {
		int numero = this.generarCodigoOrden(); // SEGUIR CON ESTOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO
	}

	@Override
	public void cancelarOrdenDeCompra(int numero) throws OrdenDeCompraNoExisteException {
		OrdenDeCompra ord = this.ordenes.get(numero);
        if (ord == null){
            throw new OrdenDeCompraNoExisteException("Error: La orden de compra número " + '"' + numero + '"' + " no existe.");
        }
        this.ordenes.remove(numero);
        ord.desvincularCliente();
        ord.setCantidad(null);
        return;
	}

	@Override
	public boolean agregarProducto(String nombreProducto, int cantidad) throws ProductoNoExisteException {
		if (this.categoriaActual == null) {
			throw new NullPointerException("Error: No se ha elegido una categoría previamente.");
		}
		Producto prod = this.categoriaActual.seleccionarProducto(nombreProducto);
		if (prod == null) {
			throw new ProductoNoExisteException("Error: El producto de nombre " + '"' + nombreProducto + '"' + " no existe.");
		}
		Cantidad cant = new Cantidad(prod, cantidad);
		this.listaOrden.add(cant);
		return true;
	}

	@Override
	public List<DTCliente> listarClientes(){
		List<DTCliente> lista = new ArrayList<>();
		for (Usuario user : this.usuarios) {
			if (user instanceof Cliente) {
				Cliente cl = (Cliente) user;
				DTCliente dt = cl.getDTCliente();
				lista.add(dt);
			}
		}
		return lista;
	}
	
	/* OTRA FORMA PARA NO ITERAR 2 VECES
	@Override
	public void listarClientes(){
		int count = 1;
		for (Usuario user : this.usuarios) {
			if (user instanceof Cliente) {
				DTCliente dt = user.getDTCliente();
				System.out.println("CLIENTE " + count + "\n" +  dt.toString()); // TENEMOS QUE SOBREESCRIBIR EL METODO toString de la clase DTCliente
				count++;
			}
		}
	}
	*/

	@Override
	public boolean elegirCliente(String nickname) throws UsuarioNoExisteException {
		for (Usuario user : this.usuarios) {
			if (user.getNickname() == nickname) {
				if (user instanceof Cliente) {
					Cliente cli = (Cliente) user;
					this.usuarioActual = cli;
					return true; // No es necesario que sea booleano
				}
				throw new UsuarioNoExisteException("Error: El usuario de nickname " + '"' + nickname + '"' + " existe, pero no es un cliente.");
			}
		}
		throw new UsuarioNoExisteException("Error: El usuario de nickname " + '"' + nickname + '"' + " no existe.");
	}
	
	@Override
	public DTClienteDetallado verInformacionCliente() {
		if (this.usuarioActual == null || ! (this.usuarioActual instanceof Cliente)) {
			throw new NullPointerException("Error: No se ha elegido un cliente previamente.");
		}
		Cliente cli = (Cliente) this.usuarioActual;
		return cli.getDTClienteDetallado();
	}

	@Override
	public void quitarProductoDeCategorias() {
		if (this.productoActual == null) {
			throw new NullPointerException("Error: No se ha elegido un producto previamente.");
		}
		for(Categoria cat : this.categorias.values()) {
			cat.getProductos().remove(this.productoActual);
		}
	}
	
	// Funciones que no estaban
	@Override
	public void agregarProductoACategorias(List<Categoria> listaCat) {
		if (this.productoActual == null) {
			throw new NullPointerException("Error: No se ha elegido un producto previamente.");
		}
		for (Categoria cat : listaCat) {
			cat.getProductos().add(this.productoActual);
		}
	}
	
	public void agregarCategorias(List<Categoria> listaCat) {
		if (this.productoActual == null) {
			throw new NullPointerException("Error: No se ha elegido un producto previamente.");
		}
		this.productoActual.setCategorias(listaCat);
	}
	
	@Override
	public void modificarDatosProducto(String nombreProd, int numReferencia, String descripcion, float precio, String especificacion) {
		if (this.productoActual == null) {
			throw new NullPointerException("Error: No se ha elegido un producto previamente.");
		}
		if (precio <= 0) {
			throw new IllegalArgumentException("Error: El precio elegido no puede ser menor o igual a 0.");
		}
		for (Categoria cat : this.categorias.values()) {
			for (Producto prod : cat.getProductos()) {
				if (prod.getNombreProducto() == nombreProd) {
					if (prod.getNumReferencia() == numReferencia) {
						throw new ProductoRepetidoException("Error: Ya existe un producto de nombre " + '"' + nombreProd + '"' + " y número de referencia " + '"' + numReferencia + '"' + '.');
					}
				}
			}
		}
		this.productoActual.setNombreProducto(nombreProd);
		this.productoActual.setNumReferencia(numReferencia);
		this.productoActual.setDescripcion(descripcion);
		this.productoActual.setPrecio(precio);
		this.productoActual.setEspecificacion(especificacion);
	}
	
	// ESTA RECONTRA MAL
	@Override
	public void modificarImagenesProducto(List<String> imagenes) {
		if (this.productoActual == null) {
			throw new NullPointerException("Error: No se ha elegido un producto previamente.");
		}
		this.productoActual.setImagenes(imagenes);
	}
	
	public List<DTProveedor> listarProveedores(){
		List<DTProveedor> lista = new ArrayList<>();
		for (Usuario user : this.usuarios) {
			if (user instanceof Proveedor) {
				Proveedor pr = (Proveedor) user;
				DTProveedor dt = pr.getDTProveedor();
				lista.add(dt);
			}
		}
		return lista;
	}
	
	public void elegirProveedor(String nickname) throws UsuarioNoExisteException {
		for (Usuario user : this.usuarios) {
			if (user.getNickname() == nickname) {
				if (user instanceof Proveedor) {
					Proveedor pr = (Proveedor) user;
					this.usuarioActual = pr;
					return;
					// return true; // No es necesario que sea booleano
				}
				throw new UsuarioNoExisteException("Error: El usuario de nickname " + '"' + nickname + '"' + " existe, pero no es un proveedor.");
			}
		}
		throw new UsuarioNoExisteException("Error: El usuario de nickname " + '"' + nickname + '"' + " no existe.");
	}
	
	public DTProveedorDetallado verInformacionProveedor() {
		if (this.usuarioActual == null || ! (this.usuarioActual instanceof Proveedor)) {
			throw new NullPointerException("Error: No se ha elegido un proveedor previamente.");
		}
		Proveedor pr = (Proveedor) this.usuarioActual;
		return pr.getDTProveedorDetallado();
	}
	
	
}