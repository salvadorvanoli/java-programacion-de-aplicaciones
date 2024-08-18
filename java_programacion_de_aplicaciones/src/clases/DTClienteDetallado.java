package clases;
import java.util.List;
import java.util.ArrayList;

public class DTClienteDetallado extends DTCliente {
	
	private String nombre;
	private String apellido;
	private DTFecha fechaNac;
	private String foto;
	
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public DTFecha getFechaNac() {
		return fechaNac;
	}
	public void setFechaNac(DTFecha fechaNac) {
		this.fechaNac = fechaNac;
	}
	public String getFoto() {
		return foto;
	}
	public void setFoto(String foto) {
		this.foto = foto;
	}
	public DTClienteDetallado() {
		super();
	}
	
	
}
