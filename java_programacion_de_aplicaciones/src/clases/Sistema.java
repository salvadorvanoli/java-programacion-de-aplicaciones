package clases;

import java.util.ArrayList;
import java.util.List;

import java.util.HashMap;
import java.util.Map;

import java.time.LocalDate;

// Importamos las excepciones necesarias

import excepciones.UsuarioNoExisteException;
import excepciones.UsuarioRepetidoException;
import excepciones.CategoriaNoExisteException;
import excepciones.CategoriaNoPuedeTenerProductosException;
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
	// private List<Producto> listaOrden;
	
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
	
	@Override
	public List<Usuario> getUsuarios(){
		return this.usuarios;
	}
	

	@Override
	public HashMap<Integer, OrdenDeCompra> getOrdenes(){
		return this.ordenes;
	}
	
	@Override
	public HashMap<String, Categoria> getCategorias(){
		return this.categorias;
	}
	
	@Override
	public Usuario getUsuarioActual() {
		return this.usuarioActual;
	}
	
	@Override
	public OrdenDeCompra getOrdenDeCompraActual() {
		return this.ordenActual;
	}
	
	@Override
	public Categoria getCategoriaActual() {
		return this.categoriaActual;
	}
	
	@Override
	public Producto getProductoActual() {
		return this.productoActual;
	}
	
	@Override
	public DTFecha getFechaActual() {
		// Obtener la fecha actual
        LocalDate fechaActual = LocalDate.now();

        // Extraer el día, mes y año
        int dia = fechaActual.getDayOfMonth();
        int mes = fechaActual.getMonthValue();
        int anio = fechaActual.getYear();
        
        return new DTFecha(dia, mes, anio);
	}
	
	@Override // NO ES NECESARIO QUE SEA BOOL
	public boolean altaUsuarioCliente(String nickname, String email, String nombre, String apellido, DTFecha fechaNac, String imagen) throws UsuarioRepetidoException {
		for (Usuario user : this.usuarios) {
			if (user.getEmail().equalsIgnoreCase(email)) {
				throw new UsuarioRepetidoException("Ya existe un usuario registrado con el email " + '"' + email + '"' + '.');
			}
			if (user.getNickname().equalsIgnoreCase(nickname)) {
				throw new UsuarioRepetidoException("Ya existe un usuario registrado con el nickname"  + '"' + nickname + '"' + '.');
			}
		}
		Cliente nuevo = new Cliente(nickname, nombre, apellido, email, fechaNac, imagen); // ESTO HAY QUE CAMBIARLO
		this.usuarios.add(nuevo);
		return true;
	}
	
	@Override // NO ES NECESARIO QUE SEA BOOL
	public boolean altaUsuarioProveedor(String nickname, String email, String nombre, String apellido, DTFecha fechaNac, String nomCompania, String linkWeb, String imagen) throws UsuarioRepetidoException {
		for (Usuario user : this.usuarios) {
			if (user.getEmail().equalsIgnoreCase(email)) {
				throw new UsuarioRepetidoException("Ya existe un usuario registrado con el email " + '"' + email + '"' + '.');
			}
			if (user.getNickname().equalsIgnoreCase(nickname)) {
				throw new UsuarioRepetidoException("Ya existe un usuario registrado con el nickname " + '"' + nickname + '"' + '.');
			}
		}
		Proveedor nuevo = new Proveedor(nickname, nombre, apellido, email, fechaNac, imagen, nomCompania, linkWeb);
		this.usuarios.add(nuevo);
		return true;
	}
	
	/*
	@Override
	public boolean registrarProducto(String titulo, int numReferencia, String descrip, String especificaciones, int precio) throws ProductoRepetidoException {
		if (this.usuarioActual == null || ! (this.usuarioActual instanceof Proveedor)) {
			throw new NullPointerException("No se ha elegido un proveedor previamente.");
		}
		for (Categoria cat : this.categorias.values()) {
			for (Producto prod : cat.getProductos()) {
				if (prod.getNombreProducto().equalsIgnoreCase(titulo)) {
					if (prod.getNumReferencia() == numReferencia) {
						throw new ProductoRepetidoException("Ya existe un producto de nombre " + '"' + titulo + '"' + " y número de referencia " + '"' + numReferencia + '"' + '.');
					}
				}
			}
		}
		Proveedor proveedor = (Proveedor) this.usuarioActual;
		Producto prod = new Producto(titulo, descrip, especificaciones, numReferencia, precio, null, null, proveedor); // Esto esta re mal
		proveedor.agregarProducto(prod);
		this.productoActual = prod;
		return true;
	}
	*/
	
	
	@Override
	public boolean registrarProducto(String titulo, int numReferencia, String descrip, String especificaciones, float precio, List<Categoria> categorias, List<String> imagenes) throws ProductoRepetidoException, CategoriaNoPuedeTenerProductosException {
		if (this.usuarioActual == null || ! (this.usuarioActual instanceof Proveedor)) {
			throw new NullPointerException("No se ha elegido un proveedor previamente.");
		}
		/*
		for (Categoria cat : this.categorias.values()) {
			for (Producto prod : cat.getProductos()) {
				if (prod.getNombreProducto().equalsIgnoreCase(titulo)) {
					throw new ProductoRepetidoException("Ya existe un producto de nombre " + '"' + titulo + '"' + '.');
				} else if (prod.getNumReferencia() == numReferencia) {
					throw new ProductoRepetidoException("Ya existe un producto de número de referencia " + '"' + numReferencia + '"' + '.');
				}
			}
		}
		*/
		try {
			this.existeProducto(titulo, numReferencia);
		} catch (ProductoRepetidoException e) {
			throw new ProductoRepetidoException(e.getMessage());
		}
		
		String categoriasSinProductos = "";
		for(Categoria cat : categorias) {
			if(!cat.isTieneProductos()) {
				if(categoriasSinProductos != "") {
					categoriasSinProductos += ", ";
				}
				categoriasSinProductos += cat.getNombreCat();
			}
		}
		
		if (categoriasSinProductos != "") {
	        throw new CategoriaNoPuedeTenerProductosException("Las categorías " + categoriasSinProductos + " no puede contener productos.");
	    }
		Proveedor proveedor = (Proveedor) this.usuarioActual;
		Producto prod = new Producto(titulo, descrip, especificaciones, numReferencia, precio, imagenes, categorias, proveedor); // Esto esta re mal
		proveedor.agregarProducto(prod);
		this.productoActual = prod;
		this.agregarProductoACategorias(categorias);
		return true;
	}
	
	
	@Override // Lo podría leer directamente
	public DTProductoDetallado verInformacionProducto() {
		if (this.productoActual == null) {
			throw new NullPointerException("No se ha elegido un producto previamente.");
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
	public boolean elegirCategoria(String nombreCat) throws CategoriaNoExisteException {
	    Categoria cat = buscarCategoriaRecursivamente(nombreCat, this.categorias);
	    if (cat == null) {
	        throw new CategoriaNoExisteException("La categoría de nombre " + '"' + nombreCat + '"' + " no existe.");
	    }
	    this.categoriaActual = cat;
	    return true;
	}

	@Override
	public Categoria buscarCategoriaRecursivamente(String nombreCat, HashMap<String, Categoria> categorias) {
	    for (Map.Entry<String, Categoria> entry : categorias.entrySet()) {
	        Categoria categoria = entry.getValue();
	        if (categoria.getNombreCat().equals(nombreCat)) {
	            return categoria;
	        }
	        Categoria catEncontrada = buscarCategoriaRecursivamente(nombreCat, categoria.getHijos());
	        if (catEncontrada != null) {
	            return catEncontrada;
	        }
	    }
	    return null;
	}
	
	@Override
	public boolean existeCategoria(String nombreCategoria) {
        for (Categoria categoria : getCategorias().values()) {
            if (categoria.getNombreCat().equals(nombreCategoria) || existeCategoriaRecursivamente(categoria, nombreCategoria)) {
                return true;
            }
        }
        return false;
    }

    private boolean existeCategoriaRecursivamente(Categoria categoria, String nombreCategoria) {
        for (Categoria hijo : categoria.getHijos().values()) {
            if (hijo.getNombreCat().equals(nombreCategoria) || existeCategoriaRecursivamente(hijo, nombreCategoria)) {
                return true;
            }
        }
        return false;
    }

	@Override
	public List<DTProducto> listarProductos(){
		if (this.categoriaActual == null) {
			throw new NullPointerException("No se ha elegido una categoría previamente.");
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
			throw new NullPointerException("No se ha elegido una categoría previamente.");
		}
		Producto prod = this.categoriaActual.seleccionarProducto(nombreProd);
		if (prod == null) {
			throw new ProductoNoExisteException("El producto de nombre " + '"' + nombreProd + '"' + " no existe.");
		}
		this.productoActual = prod;
		return true;
	}
	/*
	public boolean elegirProducto(String nombreProd) throws ProductoNoExisteException {
		if (this.categoriaActual == null) {
			throw new NullPointerException("No se ha elegido una categoría previamente.");
		}
		for (Producto prod : this.categoriaActual.getProductos()) {
			if (prod.getNombre() == nombreProd) {
				this.productoActual = prod;
				return true; // Capaz hacemos que no retorne nada
			}
		}
		throw new ProductoNoExisteException("El producto de nombre " + '"' + nombreProd + '"' + " no existe.");
	}
	*/
	
	@Override
	public Categoria altaCategoria(String nombre, boolean tieneProductos, Categoria padre) throws CategoriaRepetidaException{
        if (this.categorias.containsKey(nombre)) {
            throw new CategoriaRepetidaException("Ya existe una categoría con el nombre " + '"' + nombre + '"' + '.');
        }
		Categoria cat = new Categoria(nombre, tieneProductos, padre);
		if (padre == null) {
			this.categorias.put(nombre, cat);
		} else {
			padre.agregarHijo(nombre, cat);
		}
		return cat;
	}

	@Override
	public List<DTOrdenDeCompra> listarOrdenesDeCompra(){
		List<DTOrdenDeCompra> lista = new ArrayList<>();
		if (this.usuarioActual != null && (this.usuarioActual instanceof Cliente)) {
			Cliente cli = (Cliente) this.usuarioActual;
			for (OrdenDeCompra ord : cli.getOrdenesDeCompras()) {
				DTOrdenDeCompra dt = ord.getDTOrden();
				lista.add(dt);
			}
		} else {
			for (OrdenDeCompra ord : this.ordenes.values()) {
				DTOrdenDeCompra dt = ord.getDTOrden(); // Capaz la función no se llama así
				lista.add(dt);
			}
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
            throw new OrdenDeCompraNoExisteException("La orden de compra número " + '"' + numero + '"' + " no existe.");
        }
        this.ordenActual = ord;
        return true; // No es necesario que sea bool
	}
	
	
	// FUNCION VER INFORMACION ORDEN DE COMPRA
	
	
	@Override
	public DTOrdenDeCompraDetallada verInformacionOrdenDeCompra() {
		if (this.ordenActual == null) {
			throw new NullPointerException("No se ha elegido una orden de compra previamente.");
		}
		return this.ordenActual.getDTOrdenDetallada();
	}
	
	
	// FUNCION GENERAR CODIGO ORDEN
	
	@Override
	public void agregarOrden(List<Cantidad> cantidad) {
		if (this.usuarioActual instanceof Cliente) {
	        Cliente clienteActual = (Cliente) this.usuarioActual;
	        
	        int codigoOrden = this.generarCodigoOrden();
	        OrdenDeCompra nueva = new OrdenDeCompra(codigoOrden, this.getFechaActual(), clienteActual, null);
	        
	        for (Cantidad cant : cantidad) {
	        	nueva.agregarProducto(cant.getProducto(), cant.getCantidad());
	        }
	        
	        this.ordenes.put(codigoOrden, nueva);
	        
	        List<OrdenDeCompra> ordenes = clienteActual.getOrdenesDeCompras();
	        ordenes.add(nueva);
	        clienteActual.setOrdenesDeCompras(ordenes);
	        
	    } else {
	        throw new IllegalArgumentException("El usuario actual no es un cliente.");
	    }
	}
	
	@Override
	public int generarCodigoOrden() {
		if (this.ordenes.isEmpty()) {
			return 1;
		}
		int numero = 0;
		for (int key : this.ordenes.keySet()) {
			if (key >= numero) {
				numero = key+1;
			}
		}
		return numero;
	}
	
	
	// FUNCION DAR ALTA ORDEN DE COMPRA
	
	/*
	@Override
	public DTOrdenDeCompraDetallada darAltaOrden() throws UsuarioNoExisteException {
		if (this.usuarioActual == null) {
			throw new NullPointerException("No se ha elegido un cliente previamente.");
		}
		if (this.usuarioActual instanceof Proveedor) {
			throw new UsuarioNoExisteException("El usuario de nickname " + '"' + this.usuarioActual.getNickname() + '"' + " existe, pero no es un cliente.");
		}
		if (this.listaOrden.isEmpty()) {
			throw new IllegalStateException("No se han elegido productos previamente.");
		}
		int numero = this.generarCodigoOrden();
		DTFecha fecha = this.getFechaActual();
		Cliente cli = (Cliente) this.usuarioActual;
		OrdenDeCompra ord = new OrdenDeCompra(numero, fecha, cli);
		this.ordenes.put(numero, ord);
		for (Producto prod : this.listaOrden) {
			ord.agregarProducto(prod, numero); // No se de donde sacar el producto
		}
		this.listaOrden.clear();
		return ord.getDTOrdenDetallada();
	}
	*/
	
	/* ALTERNATIVA A LA FUNCION DAR ALTA ORDEN */
	@Override
	public DTOrdenDeCompraDetallada darAltaOrden() throws UsuarioNoExisteException {
		if (this.usuarioActual == null) {
			throw new NullPointerException("No se ha elegido un cliente previamente.");
		}
		if (this.usuarioActual instanceof Proveedor) {
			throw new UsuarioNoExisteException("El usuario de nickname " + '"' + this.usuarioActual.getNickname() + '"' + " existe, pero no es un cliente.");
		}
		if (this.listaOrden.isEmpty()) {
			throw new IllegalStateException("No se han elegido productos previamente.");
		}
		int numero = this.generarCodigoOrden();
		DTFecha fecha = this.getFechaActual();
		Cliente cli = (Cliente) this.usuarioActual;
		OrdenDeCompra ord = new OrdenDeCompra(numero, fecha, cli, this.listaOrden);
		this.ordenes.put(numero, ord);
		this.listaOrden.clear();
		return ord.getDTOrdenDetallada();
	}
	
	
	
	// FUNCION CANCELAR ORDEN DE COMPRA
	

	@Override
	public void cancelarOrdenDeCompra(int numero) throws OrdenDeCompraNoExisteException {
		OrdenDeCompra ord = this.ordenes.get(numero);
        if (ord == null){
            throw new OrdenDeCompraNoExisteException("La orden de compra número " + '"' + numero + '"' + " no existe.");
        }
        this.ordenes.remove(numero);
        ord.desvincularCliente();
        ord.setCantidad(null);
        return;
	}
	
	
	// FUNCION AGREGAR PRODUCTO
	
	/* Versión anterior, con fallas
	public boolean agregarProducto(String nombreProducto, int cantidad) throws ProductoNoExisteException {
		if (this.categoriaActual == null) {
			throw new NullPointerException("No se ha elegido una categoría previamente.");
		}
		Producto prod = this.categoriaActual.seleccionarProducto(nombreProducto);
		if (prod == null) {
			throw new ProductoNoExisteException("El producto de nombre " + '"' + nombreProducto + '"' + " no existe.");
		}
		
		this.listaOrden.add(prod);
		return true;
	}
	*/
	
	
	@Override
	public boolean agregarProducto(String nombreProducto, int cantidad) throws ProductoNoExisteException {
		if (cantidad < 1) {
			throw new IllegalArgumentException("La cantidad de un producto no puede ser menor a 1.");
		}
		if (this.categoriaActual == null) {
			throw new NullPointerException("No se ha elegido una categoría previamente.");
		}
		Producto prod = this.categoriaActual.seleccionarProducto(nombreProducto);
		if (prod == null) {
			throw new ProductoNoExisteException("El producto de nombre " + '"' + nombreProducto + '"' + " no existe.");
		}
		Cantidad cant = new Cantidad(prod.getDTProducto(), cantidad);
		this.listaOrden.add(cant);
		return true;
	}
	

	@Override
	public List<DTCliente> listarClientes(){
		/*
		if (this.usuarios.isEmpty()) {
			throw new IllegalArgumentException("El sistema no tiene usuarios.");
		}
		*/
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
			if (user.getNickname().equalsIgnoreCase(nickname)) {
				if (user instanceof Cliente) {
					Cliente cli = (Cliente) user;
					this.usuarioActual = cli;
					return true; // No es necesario que sea booleano
				}
				throw new UsuarioNoExisteException("El usuario de nickname " + '"' + nickname + '"' + " existe, pero no es un cliente.");
			}
		}
		throw new UsuarioNoExisteException("El usuario de nickname " + '"' + nickname + '"' + " no existe.");
	}
	
	@Override
	public DTClienteDetallado verInformacionCliente() {
		if (this.usuarioActual == null || ! (this.usuarioActual instanceof Cliente)) {
			throw new NullPointerException("No se ha elegido un cliente previamente.");
		}
		Cliente cli = (Cliente) this.usuarioActual;
		return cli.getDTClienteDetallado();
	}
	
	//@Override
	private void quitarProductoDeCategoriasSistema(Categoria cat) {
		for(Categoria hijo : cat.getHijos().values()) {
			hijo.getProductos().remove(this.productoActual);
			quitarProductoDeCategoriasSistema(hijo);
		}
	}

	@Override
	public void quitarProductoDeCategorias(boolean seAgreganCategorias) {
		if (this.productoActual == null) {
			throw new NullPointerException("No se ha elegido un producto previamente.");
		}
		if (seAgreganCategorias) {
			for(Categoria cat : this.categorias.values()) {
				cat.getProductos().remove(this.productoActual);
				quitarProductoDeCategoriasSistema(cat);
			}
		}
	}
	
	// Funciones que no estaban
	@Override
	public void agregarProductoACategorias(List<Categoria> listaCat) {
		if (this.productoActual == null) {
			throw new NullPointerException("No se ha elegido un producto previamente.");
		}
		if (listaCat != null && ! (listaCat.isEmpty())) {
			for (Categoria cat : listaCat) {
				cat.agregarProducto(this.productoActual);
			}
		}
	}
	
	public void agregarCategoriasAProducto(List<Categoria> listaCat) {
		if (this.productoActual == null) {
			throw new NullPointerException("No se ha elegido un producto previamente.");
		}
		if (listaCat != null && ! (listaCat.isEmpty())) {
			this.productoActual.setCategorias(listaCat);
		}
	}
	
	@Override
	public void existeProducto(String nombreProd, int numReferencia) throws ProductoRepetidoException {		
		for (Categoria categoria : this.categorias.values()) {
			try {
				buscarProductoEnCategoria(categoria, nombreProd, numReferencia);
			} catch (ProductoRepetidoException e) {
				throw new ProductoRepetidoException(e.getMessage());
			}
	    }
	}

	//@Override
	private void buscarProductoEnCategoria(Categoria categoria, String nombreProd, int numReferencia) throws ProductoRepetidoException { // Hay que probar esto
	    for (Producto producto : categoria.getProductos()) {
	        if (producto.getNombreProducto().equalsIgnoreCase(nombreProd)) {
	        	throw new ProductoRepetidoException("Ya existe un producto con ese nombre en el sistema.");
	        }
	        if (producto.getNumReferencia() == numReferencia){
	        	throw new ProductoRepetidoException("Ya existe un producto con ese número de referencia en el sistema.");
	        }
	    }

	    for (Categoria subcategoria : categoria.getHijos().values()) {
	    	try {
				buscarProductoEnCategoria(subcategoria, nombreProd, numReferencia);
			} catch (ProductoRepetidoException e) {
				throw new ProductoRepetidoException(e.getMessage());
			}
	    }
	}
	
	@Override
	public void modificarDatosProducto(String nombreProd, int numReferencia, String descripcion, float precio, String especificacion) throws ProductoRepetidoException {
		if (this.productoActual == null) {
			throw new NullPointerException("No se ha elegido un producto previamente.");
		}
		if (precio <= 0) {
			throw new IllegalArgumentException("El precio elegido no puede ser menor o igual a 0.");
		}
		try {
			existeProducto(nombreProd, numReferencia);
		} catch (ProductoRepetidoException e) {
			throw new ProductoRepetidoException(e.getMessage());
		}
		this.productoActual.setNombreProducto(nombreProd);
		this.productoActual.setNumReferencia(numReferencia);
		this.productoActual.setDescripcion(descripcion);
		this.productoActual.setEspecificacion(especificacion);
		this.productoActual.setPrecio(precio);
	}
	
	// ESTA RECONTRA MAL
	@Override
	public void modificarImagenesProducto(List<String> imagenes) {
		if (this.productoActual == null) {
			throw new NullPointerException("No se ha elegido un producto previamente.");
		}
		if (imagenes != null && ! (imagenes.isEmpty())) {
			this.productoActual.setImagenes(imagenes);
		}
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
			if (user.getNickname().equalsIgnoreCase(nickname)) {
				if (user instanceof Proveedor) {
					Proveedor pr = (Proveedor) user;
					this.usuarioActual = pr;
					return;
					// return true; // No es necesario que sea booleano
				}
				throw new UsuarioNoExisteException("El usuario de nickname " + '"' + nickname + '"' + " existe, pero no es un proveedor.");
			}
		}
		throw new UsuarioNoExisteException("El usuario de nickname " + '"' + nickname + '"' + " no existe.");
	}
	
	public DTProveedorDetallado verInformacionProveedor() {
		if (this.usuarioActual == null || ! (this.usuarioActual instanceof Proveedor)) {
			throw new NullPointerException("No se ha elegido un proveedor previamente.");
		}
		Proveedor pr = (Proveedor) this.usuarioActual;
		return pr.getDTProveedorDetallado();
	}
	
	public void setTodoNull() {
		this.ordenActual = null;
		this.categoriaActual = null;
		this.productoActual = null;
		this.usuarioActual = null;
		this.listaOrden.clear();
	}

	@Override
	public void crearCasos() {
		// TODO Auto-generated method stub
		DTFecha fecha1 = new DTFecha(2, 4, 2024);
        DTFecha fecha2 = new DTFecha(6, 8, 2024);
       
        Categoria cat1 = new Categoria( "Liquidos", false, null);
        Categoria cat3 = new Categoria( "Electronicos",  false, null);
        Categoria cat2 = new Categoria( "Intrumentos Electricos",  false, cat3);
        
        List<Categoria> c1= new ArrayList<>();
        List<Categoria> c2= new ArrayList<>();
        List<Categoria> c3= new ArrayList<>();
        c1.add(cat3);
        c1.add(cat2);
        c2.add(cat1);
        c3.add(cat2);
        
        String imagen1 = "/Images/Chico1.png";
        String imagen2 = "/Images/Chico2.png";
        String imagen3 = "/Images/Chico3.png";
        String imagen4 = "/Images/Chica1.png";
        String imagen5 = "/Images/Chica2.png";
        String imagen6 = "/Images/Chica3.png";
        
        Cliente cl1 = new Cliente("Salva", "Salvador", "Santurio", "Salva.Santu@example.com", fecha1, imagen2);
        Cliente cl2 = new Cliente("Otto", "Nadia", "Gorría", "Pancnqueso1012@example.com", fecha2, imagen5);
        Cliente cl3 = new Cliente("Protowarro", "Samuel", "Veintmilla", "Protowarro22@example.com", fecha2, imagen1);
        
        Proveedor pr1 = new Proveedor("elIsma", "Isma", "Belardo", "lalala@example.com", fecha1, imagen3, "Sugar Cane Bank", "http://SugarCaneBank.com");
        Proveedor pr2 = new Proveedor("Maria_02", "Amy", "Casadevino", "amy.casadevino@example.com", fecha2, imagen4, "Mary on a cross Enterprise", "http://MaryOnACross.com");
        Proveedor pr3 = new Proveedor("Zo3", "Zoe", "Gatusso", "zoe.gatu@example.com", fecha2, imagen6, "Flamin-Go", "http://FlaminGo.com");
        
        Producto producto1 = new Producto("Agua Fresca", "Muy refrescante.", "Mineralizada", 999, 72.5f, null, c2,  pr3);
        Producto producto2 = new Producto("Guitarra", "Guitarra electrica de ebano.", "Hambucker Doble", 998, 16500.0f, null, c1,  pr2);
        Producto producto3 = new Producto("Control Remoto", "Util para televisores de alta calidad.", "Pilas AAA", 997, 350.20f, null, c3,  pr1);
        
        OrdenDeCompra orden1 = new OrdenDeCompra(88, fecha1, cl1, null);
        orden1.setPrecioTotal(1350.50f);
        
        OrdenDeCompra orden2 = new OrdenDeCompra(77, fecha2, cl2, null);
        orden2.setPrecioTotal(555.75f);
        
        OrdenDeCompra orden3 = new OrdenDeCompra(66, fecha1, cl3, null);
        orden3.setPrecioTotal(625.50f);
        
        orden1.agregarProducto(producto1.getDTProducto(), 15);
        orden1.agregarProducto(producto2.getDTProducto(), 3);
        
        orden2.agregarProducto(producto3.getDTProducto(), 20);
        orden2.agregarProducto(producto1.getDTProducto(), 45);
        
        orden3.agregarProducto(producto3.getDTProducto(), 1000);
        orden3.agregarProducto(producto2.getDTProducto(), 1);
        
		ordenes.put(1, orden1);
		ordenes.put(2, orden2);
		ordenes.put(2, orden3);
		
		this.usuarios.add(cl1);
		this.usuarios.add(cl2);
		this.usuarios.add(pr1);
		this.usuarios.add(pr2);

        int count = 0;
        
        for (Categoria cat : this.categorias.values()) {
        	count++;
        	List<Categoria> lista = new ArrayList<>();
        	lista.add(cat);
        	if (count == 1) {
        		cat.agregarProducto(producto1);
        		producto1.setCategorias(lista);
        	} else if (count == 2) {
        		cat2.agregarProducto(producto2);
        		producto2.setCategorias(lista);
        	} else if (count == 3) {
        		cat3.agregarProducto(producto3);
        		producto3.setCategorias(lista);
        	}
        }
       
		
	}
	
	
	
}