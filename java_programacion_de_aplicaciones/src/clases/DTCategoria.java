package clases;
import java.util.List;
import java.util.ArrayList;

public class DTCategoria {
	
	private String nombreCat;
	private List<Categoria> hijas;
	
	public String getNombreCat() {
		return nombreCat;
	}
	public void setNombreCat(String nombreCat) {
		this.nombreCat = nombreCat;
	}
	public List<Categoria> getHijas() {
		return hijas;
	}
	public void setHijas(List<Categoria> hijas) {
		this.hijas = hijas;
	}
	
	public DTCategoria(String nombreCat, List<Categoria> hijas) {
		super();
		this.nombreCat = nombreCat;
		this.hijas = hijas;
	}
	
}
