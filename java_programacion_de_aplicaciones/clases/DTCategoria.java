package clases;
import java.util.List;

public class DTCategoria {
	
	private String nombreCat;
	private List<Categoria> hijas;
	
	//constructor
	public DTCategoria(String nombreCat) {
		super();
		this.nombreCat = nombreCat;
	}
	
	//getters y setters
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
	
}
