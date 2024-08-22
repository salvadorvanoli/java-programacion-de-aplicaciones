package interfaces;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import java.awt.Font;

public class modificarDatosProducto extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					modificarDatosProducto frame = new modificarDatosProducto();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public modificarDatosProducto() {
		setTitle("Modificar los datos de un Producto");
		setClosable(true);
		setBounds(100, 100, 574, 402);
		getContentPane().setLayout(null);
		
		JLabel labelSeleccionCategoria = new JLabel("Selecciona una de las categorías listadas debajo *");
		labelSeleccionCategoria.setHorizontalAlignment(SwingConstants.CENTER);
		labelSeleccionCategoria.setBounds(10, 48, 538, 28);
		getContentPane().add(labelSeleccionCategoria);
		
		JComboBox seleccionCategoria = new JComboBox();
		seleccionCategoria.setBounds(10, 76, 538, 22);
		getContentPane().add(seleccionCategoria);
		
		JLabel labelSeleccionProducto = new JLabel("Selecciona uno de los productos listados debajo *");
		labelSeleccionProducto.setHorizontalAlignment(SwingConstants.CENTER);
		labelSeleccionProducto.setBounds(10, 109, 538, 28);
		getContentPane().add(labelSeleccionProducto);
		
		JComboBox seleccionProducto = new JComboBox();
		seleccionProducto.setBounds(10, 137, 538, 22);
		getContentPane().add(seleccionProducto);
		
		JLabel labelDatosAModificar = new JLabel("A continuación, modifica los datos a tu elección");
		labelDatosAModificar.setHorizontalAlignment(SwingConstants.CENTER);
		labelDatosAModificar.setBounds(10, 170, 543, 28);
		getContentPane().add(labelDatosAModificar);
		
		JLabel labelNuevoNombreProducto = new JLabel("Nombre:");
		labelNuevoNombreProducto.setBounds(10, 209, 100, 28);
		getContentPane().add(labelNuevoNombreProducto);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(120, 213, 117, 20);
		getContentPane().add(textField);
		
		JLabel labelNuevoNumReferenciaProducto = new JLabel("Num. Referencia:");
		labelNuevoNumReferenciaProducto.setBounds(10, 248, 100, 28);
		getContentPane().add(labelNuevoNumReferenciaProducto);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(120, 252, 117, 20);
		getContentPane().add(textField_1);
		
		JLabel labelNuevoPrecioProducto = new JLabel("Precio:");
		labelNuevoPrecioProducto.setBounds(10, 287, 100, 28);
		getContentPane().add(labelNuevoPrecioProducto);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(120, 291, 117, 20);
		getContentPane().add(textField_2);
		
		JLabel labelNuevaDescripcionProducto = new JLabel("Descripción:");
		labelNuevaDescripcionProducto.setBounds(301, 209, 100, 28);
		getContentPane().add(labelNuevaDescripcionProducto);
		
		JTextArea nuevaDescripcionProducto = new JTextArea();
		nuevaDescripcionProducto.setColumns(10);
		nuevaDescripcionProducto.setBounds(388, 211, 165, 62);
		getContentPane().add(nuevaDescripcionProducto);
		
		JLabel labelNuevaEspecificacionProducto = new JLabel("Especificación:");
		labelNuevaEspecificacionProducto.setBounds(301, 287, 100, 28);
		getContentPane().add(labelNuevaEspecificacionProducto);
		
		JTextArea nuevaEspecificacionProducto = new JTextArea();
		nuevaEspecificacionProducto.setColumns(10);
		nuevaEspecificacionProducto.setBounds(388, 289, 166, 63);
		getContentPane().add(nuevaEspecificacionProducto);
		
		JLabel lblModificarDatosDe = new JLabel("Modificar Datos de un Producto");
		lblModificarDatosDe.setHorizontalAlignment(SwingConstants.CENTER);
		lblModificarDatosDe.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblModificarDatosDe.setBounds(10, 11, 538, 29);
		getContentPane().add(lblModificarDatosDe);

	}

}
