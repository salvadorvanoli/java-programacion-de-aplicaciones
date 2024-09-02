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
		
		DTFecha fecha1 = new DTFecha(2, 4, 2024);
        DTFecha fecha2 = new DTFecha(6, 8, 2024);
        
        Cliente cl1 = new Cliente("a", "a", "a", "a", fecha1, "a");
        Cliente cl2 = new Cliente("b", "b", "b", "b", fecha2, "b");
        
        Proveedor pr1 = new Proveedor("nick1", "Juan", "Pérez", "juan.perez@example.com", fecha1, "foto1.jpg", "Compania1", "http://compania1.com");
        Proveedor pr2 = new Proveedor("nick2", "María", "Gómez", "maria.gomez@example.com", fecha2, "foto2.png", "Compania2", "http://compania2.com");
        
        // Crear listas de imágenes y categorías
        List<String> imagenes = new ArrayList<>();
        imagenes.add("imagen1.jpg");
        imagenes.add("imagen2.jpg");
        
        // Crear una instancia de Producto con todos los campos llenos
        Producto producto = new Producto(
            "aa",          // nombreProducto
            "ae",     // descripcion
            "ai",   // especificacion
            12345,                           // numReferencia
            99.99f,                          // precio
            imagenes,                        // lista de imágenes
            null,                      // lista de categorías
            pr1                        // proveedor
        );
        
        Producto producto2 = new Producto(
                "ba",          // nombreProducto
                "be",     // descripcion
                "bi",   // especificacion
                1234567,                           // numReferencia
                99.99f,                          // precio
                imagenes,                        // lista de imágenes
                null,                      // lista de categorías
                pr1                        // proveedor
            );
        
        Producto producto3 = new Producto(
                "ca",          // nombreProducto
                "ce",     // descripcion
                "ci",   // especificacion
                12345678,                           // numReferencia
                99.99f,                          // precio
                imagenes,                        // lista de imágenes
                null,                      // lista de categorías
                pr2                        // proveedor
            );
        
        // Crear dos órdenes de compra
        OrdenDeCompra orden1 = new OrdenDeCompra(1, fecha1, cl1, null);
        orden1.setPrecioTotal(100.50f);
        OrdenDeCompra orden2 = new OrdenDeCompra(2, fecha2, cl2, null);
        orden2.setPrecioTotal(200.75f);
        
        orden1.agregarProducto(producto, 5);
        orden1.agregarProducto(producto2, 64);
        
        orden2.agregarProducto(producto3, 7);
        orden2.agregarProducto(producto, 69);
        
		ordenes.put(1, orden1);
		ordenes.put(2, orden2);
		
		this.usuarios.add(cl1);
		this.usuarios.add(cl2);
		this.usuarios.add(pr1);
		this.usuarios.add(pr2);
        
        try {
        	Categoria cat = new Categoria("A", true, null);
			altaCategoria("A", true, null);
			altaCategoria("B", true, cat);
			altaCategoria("C", true, null);
		} catch (CategoriaRepetidaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        int count = 0;
        
        for (Categoria cat : this.categorias.values()) {
        	count++;
        	List<Categoria> lista = new ArrayList<>();
        	lista.add(cat);
        	if (count == 1) {
        		cat.agregarProducto(producto);
        		producto.setCategorias(lista);
        	} else if (count == 2) {
        		cat.agregarProducto(producto2);
        		producto2.setCategorias(lista);
        	} else if (count == 3) {
        		cat.agregarProducto(producto3);
        		producto3.setCategorias(lista);
        	}
        }
        
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
				throw new UsuarioRepetidoException("Ya existe un cliente registrado con el email " + '"' + email + '"' + '.');
			}
			if (user.getNickname().equalsIgnoreCase(nickname)) {
				throw new UsuarioRepetidoException("Ya existe un cliente registrado con el nickname"  + '"' + nickname + '"' + '.');
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
				throw new UsuarioRepetidoException("Ya existe un proveedor registrado con el email " + '"' + email + '"' + '.');
			}
			if (user.getNickname().equalsIgnoreCase(nickname)) {
				throw new UsuarioRepetidoException("Ya existe un proveedor registrado con el nickname " + '"' + nickname + '"' + '.');
			}
		}
		Proveedor nuevo = new Proveedor(nickname, nombre, apellido, email, fechaNac, imagen, nomCompania, linkWeb);
		this.usuarios.add(nuevo);
		return true;
	}
	
	// ESTA FUNCION HAY QUE RE CHEQUEARLA
	@Override
	public boolean registrarProducto(String titulo, int numReferencia, String descrip, String especificaciones, float precio) throws ProductoRepetidoException {
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
	
	/* OTRA FORMA
	@Override
	public boolean registrarProducto(String titulo, int numReferencia, String descrip, String especificaciones, int precio) throws ProductoRepetidoException {
		if (this.usuarioActual == null || ! (this.usuarioActual instanceof Proveedor)) {
			throw new NullPointerException("No se ha elegido un proveedor previamente.");
		}
		for (Categoria cat : this.categorias.values()) {
			for (Producto prod : cat.getProductos()) {
				if (prod.getNombreProducto().equalsIgnoreCase(titulo)) {
					throw new ProductoRepetidoException("Ya existe un producto de nombre " + '"' + titulo + '"' + '.');
				} else if (prod.getNumReferencia() == numReferencia) {
					throw new ProductoRepetidoException("Ya existe un producto de número de referencia " + '"' + numReferencia + '"' + '.');
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
		Cantidad cant = new Cantidad(prod, cantidad);
		this.listaOrden.add(cant);
		return true;
	}
	

	@Override
	public List<DTCliente> listarClientes(){
		if (this.usuarios.isEmpty()) {
			throw new IllegalArgumentException("El sistema no tiene usuarios.");
		}
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
				cat.getProductos().add(this.productoActual);
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
	public boolean existeProducto(String nombreProd, int numReferencia) {
	    if (this.productoActual == null) {
			throw new NullPointerException("No se ha elegido un producto previamente.");
	    }
		
		for (Categoria categoria : this.categorias.values()) {
	        if (buscarProductoEnCategoria(categoria, nombreProd, numReferencia)) {
	            return true;
	        }
	    }
	    return false;
	}

	//@Override
	private boolean buscarProductoEnCategoria(Categoria categoria, String nombreProd, int numReferencia) { // Hay que probar esto
	    for (Producto producto : categoria.getProductos()) {
	        if (producto.getNombreProducto().equalsIgnoreCase(nombreProd) || 
	            producto.getNumReferencia() == numReferencia) {
	        	if (producto != this.productoActual) {
	        		return true;
	        	}
	        }
	    }

	    for (Categoria subcategoria : categoria.getHijos().values()) {
	        if (buscarProductoEnCategoria(subcategoria, nombreProd, numReferencia)) {
	            return true;
	        }
	    }

	    return false;
	}
	
	@Override
	public void modificarDatosProducto(String nombreProd, int numReferencia, String descripcion, float precio, String especificacion) throws ProductoRepetidoException {
		if (this.productoActual == null) {
			throw new NullPointerException("No se ha elegido un producto previamente.");
		}
		if (precio <= 0) {
			throw new IllegalArgumentException("El precio elegido no puede ser menor o igual a 0.");
		}
		if (existeProducto(nombreProd, numReferencia)) {
			throw new IllegalArgumentException("Ya existe un producto con el nombre o con el número de referencia especificados");
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
	
	
	
}