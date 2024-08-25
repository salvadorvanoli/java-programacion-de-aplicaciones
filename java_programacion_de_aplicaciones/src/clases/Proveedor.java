package clases;

import java.util.ArrayList;
import java.util.List;

public class Proveedor extends Usuario{
	
		private String nomCompania;
		private String link;
		private List <Producto> Productos;
		
		public Proveedor(String nickName, String nombre, String apellido, String email, DTFecha fecha, String foto, String nomCompania, String link){
			super(nickName, nombre, apellido, email, fecha, foto);
			this.link = link;
			this.nomCompania = nomCompania;
			this.Productos  = new ArrayList<>();
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
		
		public void setProductos(List <Producto> Productos){
			this.Productos = Productos; 
		}
		
		public String getlink(){
			return this.link;
		}
		
		public String getnomCompania(){
			return this.nomCompania;
		}
	
		public List <Producto> getProductos(){
			return this.Productos;
		}
		
		public DTProveedor getDTProveedor(){
			DTProveedor c = new DTProveedor(this.getNickname(), this.getEmail());
			return c;
		}
		
		public DTProveedorDetallado getDTProveedorDetallado(){
			DTProveedorDetallado c = new DTProveedorDetallado(this.getNickname(), this.getEmail(), this.getNombre(),this.getApellido(), this.getFechaNac(), this.getFoto(), this.getnomCompania(), this.getlink());
			return c;
		}
		
}
