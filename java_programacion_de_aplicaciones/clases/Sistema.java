package clases;
import java.util.ArrayList;
import java.util.List;

public class Sistema extends ISistema {
	
	private List<Usuario> usuarios;
	private Usuario usuarioActual;
	
	private List<OrdenDeCompra> ordenes;
	private OrdenDeCompra ordenActual;
	
	private List<Categoria> categorias;
	private Categoria categoriaActual;
	
	private Producto productoActual;
	
	public Sistema() {
		this.usuarios = new ArrayList<>();
		this.ordenes = new ArrayList<>();
		this.categorias = new ArrayList<>();
		this.usuarioActual = null;
		this.ordenActual = null;
		this.categoriaActual = null;
	}
	
	@Override // NO ES NECESARIO QUE SEA BOOL
	public bool AltaUsuarioCliente(String nickname, String email, String nombre, String apellido, DTFecha fechaNac, String imagen) {
		for (Usuario user : this.usuarios) {
			if (user.getEmail() == email) {
				throw new Exception("Error: Ya existe un cliente registrado con el email " + '"' + email + '"' + '.');
			}
			if (user.getNickname() == nickname) {
				throw new Exception("Error: Ya existe un cliente registrado con el nickname"  + '"' + nickname + '"' + '.');
			}
		}
		Cliente nuevo = new Cliente(nickname, email, nombre, apellido, fechaNac, imagen);
		this.usuarios.add(nuevo);
		return true;
	}
	
	@Override // NO ES NECESARIO QUE SEA BOOL
	public bool AltaUsuarioProveedor(String nickname, String email, String nombre, String apellido, DTFecha fechaNac, String nomCompania, String linkWeb, String imagen) {
		for (Usuario user : this.usuarios) {
			if (user.getEmail() == email) {
				throw new Exception("Error: Ya existe un proveedor registrado con el email " + '"' + email + '"' + '.');
			}
			if (user.getNickname() == nickname) {
				throw new Exception("Error: Ya existe un proveedor registrado con el nickname " + '"' + nickname + '"' + '.');
			}
		}
		Proveedor nuevo = new Proveedor(nickname, email, nombre, apellido, fechaNac, nomCompania, linkWeb, imagen);
		this.usuarios.add(nuevo);
		return true;
	}
	
	@Override
	public bool RegistrarProducto(String titulo, String numReferencia, String descrip, String especificaciones, int precio, Proveedor proveedor) {
		
		// NO SUPE COMO HACERLA
		
	}
	
	@Override // Lo podria leer directamente
	public DTProductoDetallado verInformaciónProducto(int numReferencia) {
		if (this.productoActual == NULL) {
			throw new Exception("Error: No se ha elegido un producto previamente.");
		}
		return this.productoActual.getDTProductoDetallado();
	}

	@Override
	public List<DTCategoria> listarCategorias(){
		List<DTCategoria> lista = new ArrayList<>();
		for (Categoria cat : this.categorias) {
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
	public bool elegirCategoria(String nombreCat) { // No creo que sea necesario que sean bool (todos los elegir)
		for (Categoria cat : this.categorias) {
			if (cat.getNombre() == nombreCat) {
				this.categoriaActual = cat;
				return true;
			}
		}
		throw new Exception("Error: La categoría de nombre " + '"' + nombreCat + '"' + " no existe.");
	}

	@Override
	public List<DTProducto> listarProductos(){
		if (this.categoriaActual == null) {
			throw new Exception("Error: No se ha elegido una categoría previamente.");
		}
		List<DTCategoria> lista = new ArrayList<>();
		for (Producto prod : this.categoriaActual.getProductos()) {
			DTProducto dt = prod.getDTProducto();
			lista.add(dt);
		}
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
	public bool elegirProducto(String nombreProd) {
		if (this.categoriaActual == null) {
			throw new Exception("Error: No se ha elegido una categoría previamente.");
		}
		for (Producto prod : this.categoriaActual.getProductos()) {
			if (prod.getNombre() == nombreProd) {
				this.productoActual = prod;
				return true; // Capaz hacemos que no retorne nada
			}
		}
		throw new Exception("Error: El producto de nombre " + '"' + nombreProd + '"' + " no existe.");
	}
	
	@Override
	public void altaCategoria(String nombre, bool tieneProductos, Categoria padre) {
		for (Categoria cat : this.categorias) {
			if (cat.getNombre() == nombre) {
				throw new Exception("Error: Ya existe una categoría con el nombre " + '"' + nombre + '"' + '.');
			}
		}
		Categoria cat = new Categoria(nombre, tieneProductos, padre);
		this.categorias.add(cat);
	}

	@Override
	public List<DTOrdenDeCompra> listarOrdenesDeCompra(){
		List<DTCategoria> lista = new ArrayList<>();
		for (OrdenDeCompra ord : this.ordenes) {
			DTOrdenDeCompra dt = prod.getDTOrden(); // Capaz la función no se llama así
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
	public bool elegirOrdenDeCompra(int numero) {
		for (OrdenDeCompra ord : this.ordenes) {
			if (ord.getNumero() == numero) {
				this.ordenActual = ord;
				return true; // No es necesario que sea bool
			}
		}
		throw new Exception("Error: La orden de compra número " + '"' + numero + '"' + " no existe.");
	}
	
	@Override
	public void verInformacionOrdenDeCompra(int numero) {
		if (this.ordenActual == null) {
			throw new Exception("Error: No se ha elegido una orden de compra previamente.");
		}
		DTOrdenDeCompra dt = this.ordenActual.getDTOrden(); // Capaz la función no se llama así
		System.out.println("---ORDEN DE COMPRA---" + "\n" + dt.toString()); // TENEMOS QUE SOBREESCRIBIR EL METODO toString de la clase DTOrdenDeCompra
	}

	@Override
	public DTOrdenCompraDetallada darAltaOrden() {
		
		// NO SUPE COMO HACERLA
		
	}

	@Override
	public void cancelarOrdenDeCompra(int numero) {
		for (OrdenDeCompra ord : this.ordenes) {
			if (ord.getNumero() == numero) {
				this.ordenes.remove(ord);
				ord.desvincularCliente();
				ord.setCantidades = null;
				return;
			}
		}
		throw new Exception("Error: La orden de compra número " + '"' + numero + '"' + " no existe.");
	}

	@Override
	public bool agregarProducto(String nombreProducto, int cantidad) {
		
		// NO SUPE COMO HACERLA
		
	}

	@Override
	public List<DTCliente> listarClientes(){
		List<DTCliente> lista = new ArrayList<>();
		for (Usuario user : this.usuarios) {
			if (user instanceof Cliente) {
				DTCliente dt = user.getDTCliente();
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
	public bool elegirCliente(String email) {
		for (Usuario user : this.usuarios) {
			if (user.getEmail() == email) {
				if (user instanceof Cliente) {
					this.usuarioActual = user;
					return true; // No es necesario que sea booleano
				}
				throw new Exception("Error: El usuario de email " + '"' + email + '"' + " existe, pero no es un cliente.");
			}
		}
		throw new Exception("Error: El usuario de email " + '"' + email + '"' + " no existe.");
	}

	@Override
	public void quitarProductoDeCategorias() {
		if (this.productoActual == NULL) {
			throw new Exception("Error: No se ha elegido un producto previamente.");
		}
		for(Categoria cat : this.categorias) {
			cat.remove(this.productoActual);
		}
	}
	
	// Funciones que no estaban
	
	public void agregarProductoACategorias(List<Categoria> listaCat) {
		if (this.productoActual == NULL) {
			throw new Exception("Error: No se ha elegido un producto previamente.");
		}
		for (Categoria cat : listaCat) {
			cat.add(this.productoActual);
		}
	}
	
	public void agregarCategorias(List<Categoria> listaCat) {
		if (this.productoActual == NULL) {
			throw new Exception("Error: No se ha elegido un producto previamente.");
		}
		this.productoActual.setCategorias(listaCat);
	}
	
	public void modificarDatosProducto(String nombreProd, int numReferencia, String descripcion, float precio, String especificacion) {
		if (precio <= 0) {
			throw new Exception("Error: El precio elegido no puede ser menor o igual a 0.");
		}
		// FALTA SEGUIR
	}
	
}