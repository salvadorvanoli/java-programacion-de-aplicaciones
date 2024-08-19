package clases;

import java.util.ArrayList;
import java.util.List;

public class Proveedor extends Usuario{
	
		private String nomCompania;
		private String link;
		private List <Producto> Productos = new ArrayList<>();
		
		public Proveedor(String nickName, String nombre, String apellido, String email, DTFecha fecha, String foto, String nomCompania, String link, List <Producto> Productos){
			super(nickName, nombre, apellido, email, fecha, foto);
			this.link = link;
			this.nomCompania = nomCompania;
			this.Productos = Productos;
		}
		
		public void agregarProducto(Producto producto){
			this.Productos.add(producto);
		}
		
		public void setlink(String link){
			this.link = link;
		}
		
		public void setnomCompania(String nomCompania){
			this.nomCompania = nomCompania;
		}
		
		public String getlink(){
			return this.link;
		}
		
		public String getnomCompania(){
			return this.nomCompania;
		}
	
		public void setProductos(List <Producto> Productos){
			this.Productos = Productos; 
		}
		
		public List <Producto> getProductos(){
			return this.Productos;
		}
}
