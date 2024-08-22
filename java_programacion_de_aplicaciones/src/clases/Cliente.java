package clases;

import java.util.ArrayList;
import java.util.List;

public class Cliente extends Usuario{
		private List <OrdenDeCompra> OrdenesDeCompras = new ArrayList<>();
		private List <Comentario> Comentarios = new ArrayList<>();
		
		public Cliente(String nickName, String nombre, String apellido, String email, DTFecha fecha, String foto, List <OrdenDeCompra> OrdenesDeCompras, List <Comentario> Comentarios){
			super(nickName, nombre, apellido, email, fecha, foto);
			this.OrdenesDeCompras = OrdenesDeCompras;
			this.Comentarios = Comentarios;
		}
		
		public DTCliente getDTCliente() {
			DTCliente c = new DTCliente(this.getNickname(), this.getEmail());
			return c;
		}
		
		public void desvincularOrdenDeCompra(int numero){
			
		}
		
		public void setOrdenesDeCompras(List <OrdenDeCompra> OrdenesDeCompras){
			this.OrdenesDeCompras = OrdenesDeCompras;
		}
		
		public void setComentarios(List <Comentario> Comentarios){
			this.Comentarios = Comentarios;
		}
		
		public List <OrdenDeCompra> getOrdenesDeCompras(){
			return this.OrdenesDeCompras;
		}
		
		public List <Comentario> getComentarios( ){
			return this.Comentarios;
		}
}
