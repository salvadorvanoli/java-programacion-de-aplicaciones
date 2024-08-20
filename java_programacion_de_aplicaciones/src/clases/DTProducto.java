package clases;
import java.util.List;
import java.util.ArrayList;

public class DTProducto {
	private String nombre;
	private String descricpion;
	private float precio;
	
	
	public DTProducto(String nombre, String descricpion, float precio) {
		super();
		this.nombre = nombre;
		this.descricpion = descricpion;
		this.precio = precio;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescricpion() {
		return descricpion;
	}
	public void setDescricpion(String descricpion) {
		this.descricpion = descricpion;
	}
	public float getPrecio() {
		return precio;
	}
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	
	
}
