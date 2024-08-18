package clases;
import java.util.ArrayList;
import java.util.List;

public class Categoria {
    private String nombreCat;
    private List<Producto> productos;
    private List<Categoria> categorias;

    // Constructor
    public Categoria(String nombreCat) {
        this.nombreCat = nombreCat;
        this.productos = new ArrayList<>();
    }

    // Getter para nombreCat
    public String getNombreCat() {
        return nombreCat;
    }

    // Método para obtener los datos básicos de la categoría
    public DTCategoria getDTCategoria() {
        return new DTCategoria(nombreCat);
    }

    // Método para listar los productos de la categoría
    public List<DTProducto> listarProductos() {
        List<DTProducto> listaProductos = new ArrayList<>();
        for (Producto producto : productos) {
            listaProductos.add(producto.getDTProducto());
        }
        return listaProductos;
    }

    // Método para seleccionar un producto por su nombre
    public Producto seleccionarProducto(String nombreProducto) {
        for (Producto producto : productos) {
            if (producto.getNombreProducto().equalsIgnoreCase(nombreProducto)) {
                return producto;
            }
        }
        return null; // Devuelve null si no se encuentra el producto
    }

    // Método para quitar un producto de la categoría
    public boolean quitarProducto(Producto p) {
        return productos.remove(p);
    }

    // Método para agregar un producto a la categoría
    public void agregarProducto(Producto p) {
        productos.add(p);
    }
}