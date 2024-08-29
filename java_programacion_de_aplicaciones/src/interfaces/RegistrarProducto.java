package interfaces;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.Font;
import javax.swing.SwingConstants;

import clases.Categoria;
import clases.DTProveedor;
import clases.ISistema;
import clases.Proveedor;
import excepciones.ProductoRepetidoException;
import excepciones.UsuarioNoExisteException;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class RegistrarProducto extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	 

	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistrarProducto frame = new RegistrarProducto();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	*/

	/**
	 * Create the frame.
	 * @param sistema 
	 */
	
	private void limpiarFormulario(JTextField campoNombre, JTextField campoEspecificacion, JTextField campoPrecio) {
		campoNombre.setText("");
		campoEspecificacion.setText("");
		campoPrecio.setText("");
		//FALTA CONTEMPLAR IMAGEN
	}
	
	private boolean checkFormulario(JTextField campoNombre, JTextField campoEspecificacion, JTextField campoPrecio, JTextArea campoDescripcion, JComboBox boxProveedor){
		String nombre = campoNombre.getText();
		String descrip = campoDescripcion.getText();
		String especificacion = campoEspecificacion.getText();
		String precioString = campoPrecio.getText();
		DTProveedor eleccionProv = null;
		eleccionProv = (DTProveedor) boxProveedor.getSelectedItem(); 
		
		if(nombre.isEmpty() || descrip.isEmpty() || especificacion.isEmpty() || precioString.isEmpty() || eleccionProv == null){
			JOptionPane.showInputDialog(this, "No puede haber campos vacios", "Registrar Producto", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		
		return true;
	}
	
	public RegistrarProducto(ISistema sistema) {
		getContentPane().setBackground(new Color(240, 240, 240));
		setClosable(true);
		setBackground(new Color(255, 192, 203));
		setFrameIcon(new ImageIcon(RegistrarProducto.class.getResource("/Images/Flamin-Go.png")));
		setTitle("Flamin-Go\r\n");
		setBounds(100, 100, 294, 250);
		getContentPane().setLayout(null);
		
		JTextField campoNombre = new JTextField();
		campoNombre.setColumns(10);
		campoNombre.setBounds(42, 40, 86, 20);
		getContentPane().add(campoNombre);
		
		JLabel TextoNombre = new JLabel("Nombre");
		TextoNombre.setBounds(49, 25, 46, 14);
		getContentPane().add(TextoNombre);
		
		JLabel TextoEspecificacion = new JLabel("Especificación");
		TextoEspecificacion.setBounds(157, 25, 71, 14);
		getContentPane().add(TextoEspecificacion);
		
		JTextField campoEspecificacion = new JTextField();
		campoEspecificacion.setColumns(10);
		campoEspecificacion.setBounds(150, 40, 86, 20);
		getContentPane().add(campoEspecificacion);
		
		JTextArea campoDescripcion = new JTextArea();
		campoDescripcion.setBounds(42, 85, 194, 43);
		getContentPane().add(campoDescripcion);
		
		JLabel TextoDescripcion = new JLabel("Descripción");
		TextoDescripcion.setBounds(42, 71, 54, 14);
		getContentPane().add(TextoDescripcion);
		
		JLabel TextoPrecio = new JLabel("Precio");
		TextoPrecio.setBounds(42, 139, 29, 14);
		getContentPane().add(TextoPrecio);
		
		JTextField campoPrecio = new JTextField();
		campoPrecio.setColumns(10);
		campoPrecio.setBounds(42, 153, 86, 20);
		getContentPane().add(campoPrecio);
		
		JLabel TextoImagen = new JLabel("Imagen");
		TextoImagen.setBounds(157, 139, 46, 14);
		getContentPane().add(TextoImagen);
		
		JButton BotonSeleccionImagen = new JButton("Seleccionar...");
		BotonSeleccionImagen.setBounds(152, 152, 84, 23);
		getContentPane().add(BotonSeleccionImagen);
		
		JLabel TextoTitulo = new JLabel("Registrar Producto");
		TextoTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		TextoTitulo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		TextoTitulo.setBounds(0, 0, 278, 29);
		getContentPane().add(TextoTitulo);
	
		JComboBox <DTProveedor> boxProveedor = new JComboBox<>(sistema.listarProveedores().toArray(new DTProveedor[0]));
		boxProveedor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DTProveedor selectedItem = (DTProveedor) boxProveedor.getSelectedItem();
				String nick = selectedItem.getNickname();
				try {
					sistema.elegirProveedor(nick);
				} catch (UsuarioNoExisteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		boxProveedor.setEditable(true);
		boxProveedor.setBounds(41, 36, 166, 14);
		getContentPane().add(boxProveedor);
	
		JButton BotonRegistrar = new JButton("Registrar");
		BotonRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				checkFormulario(campoNombre, campoEspecificacion, campoPrecio, campoDescripcion, boxProveedor);
				String nombre = campoNombre.getText();
				String descrip = campoDescripcion.getText();
				String especificacion = campoEspecificacion.getText();
				int numReferencia =0/*aca iria un generador de num*/ ;
				int precio = Integer.parseInt(campoPrecio.getText());
				//List<String> imagenes;
				//List<Categoria> categorias;
				Proveedor proveedor;/* falta proveedor actual*/
				try {
					sistema.registrarProducto(nombre, numReferencia, descrip, especificacion, precio);
				} catch (ProductoRepetidoException e1) {
					//aun no se q va aca
				}
				limpiarFormulario(campoNombre, campoEspecificacion, campoPrecio);
			}
		});
		
		BotonRegistrar.setBounds(84, 184, 104, 23);
		getContentPane().add(BotonRegistrar);
		
		
	}
}
