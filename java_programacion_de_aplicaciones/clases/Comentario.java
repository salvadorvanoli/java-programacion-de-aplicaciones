package clases;
import java.util.List;

public class Comentario {

	private String id;
	private String contenido;
	private List<Comentario> comentarios;
	private Cliente cliente;
	private Producto producto;
		
	//constructor
	public Comentario(String id, String contenido, List<Comentario> comentarios, Cliente cliente,
			Producto producto) {
		super();
		this.id = id;
		this.contenido = contenido;
		this.comentarios = comentarios;
		this.cliente = cliente;
		this.producto = producto;
	}
		
	//setters y getters
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getContenido() {
		return contenido;
	}
	
	public void setContenido(String contenido) {
		this.contenido = contenido;
	}
	
	public Comentario(String id, String contenido) {
		super();
		this.id = id;
		this.contenido = contenido;
	}
	
	public Cliente getCliente() {
		return cliente;
	}
	
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public Producto getProducto() {
		return producto;
	}
	
	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	
	public List<Comentario> getComentarios() {
		return comentarios;
	}
	
	public void setComentarios(List<Comentario> comentarios) {
		this.comentarios = comentarios;
	}
					
}
