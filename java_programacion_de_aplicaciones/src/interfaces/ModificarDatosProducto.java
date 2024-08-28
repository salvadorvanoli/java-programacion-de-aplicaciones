package interfaces;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;

import clases.ISistema;

import javax.swing.JTextArea;
import javax.swing.ImageIcon;
import javax.swing.JTree;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JFileChooser;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ModificarDatosProducto extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private ISistema sistema;
	private Main menu;
	private JTextField textFieldNombre;
	private JTextField textFieldNumReferencia;
	private JTextField textFieldPrecio;

	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModificarDatosProducto frame = new ModificarDatosProducto();
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
	public ModificarDatosProducto(ISistema sistema) {
		setFrameIcon(new ImageIcon(ModificarDatosProducto.class.getResource("/Images/Flamin-Go.png")));
		setTitle("Flamin-Go");
		setClosable(true);
		setBounds(100, 100, 574, 581);
		getContentPane().setLayout(null);
		
		this.sistema = sistema;
		
		JLabel labelSeleccionCategoria = new JLabel("Selecciona una de las categorías listadas debajo *");
		labelSeleccionCategoria.setBounds(10, 54, 239, 28);
		getContentPane().add(labelSeleccionCategoria);
		
		JLabel labelSeleccionProducto = new JLabel("Selecciona uno de los productos listados debajo *");
		labelSeleccionProducto.setBounds(285, 54, 239, 28);
		getContentPane().add(labelSeleccionProducto);
		
		JComboBox seleccionProducto = new JComboBox();
		seleccionProducto.setBounds(264, 93, 283, 28);
		getContentPane().add(seleccionProducto);
		
		JLabel labelDatosAModificar = new JLabel("A continuación, modifica los datos a tu elección");
		labelDatosAModificar.setBounds(10, 214, 309, 28);
		getContentPane().add(labelDatosAModificar);
		
		JLabel labelNuevoNombreProducto = new JLabel("Nombre");
		labelNuevoNombreProducto.setBounds(10, 272, 42, 28);
		getContentPane().add(labelNuevoNombreProducto);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setColumns(10);
		textFieldNombre.setBounds(62, 276, 175, 20);
		getContentPane().add(textFieldNombre);
		
		JLabel labelNuevoNumReferenciaProducto = new JLabel("Num. Referencia");
		labelNuevoNumReferenciaProducto.setBounds(10, 311, 100, 28);
		getContentPane().add(labelNuevoNumReferenciaProducto);
		
		textFieldNumReferencia = new JTextField();
		textFieldNumReferencia.setColumns(10);
		textFieldNumReferencia.setBounds(108, 315, 129, 20);
		getContentPane().add(textFieldNumReferencia);
		
		JLabel labelNuevoPrecioProducto = new JLabel("Precio");
		labelNuevoPrecioProducto.setBounds(10, 350, 100, 28);
		getContentPane().add(labelNuevoPrecioProducto);
		
		textFieldPrecio = new JTextField();
		textFieldPrecio.setColumns(10);
		textFieldPrecio.setBounds(62, 354, 175, 20);
		getContentPane().add(textFieldPrecio);
		
		JLabel labelNuevaDescripcionProducto = new JLabel("Descripción");
		labelNuevaDescripcionProducto.setBounds(271, 272, 100, 28);
		getContentPane().add(labelNuevaDescripcionProducto);
		
		JTextArea textFieldDescripcion = new JTextArea();
		textFieldDescripcion.setColumns(10);
		textFieldDescripcion.setBounds(358, 274, 189, 62);
		getContentPane().add(textFieldDescripcion);
		
		JLabel labelNuevaEspecificacionProducto = new JLabel("Especificación");
		labelNuevaEspecificacionProducto.setBounds(271, 350, 100, 28);
		getContentPane().add(labelNuevaEspecificacionProducto);
		
		JTextArea textFieldEspecificacion = new JTextArea();
		textFieldEspecificacion.setColumns(10);
		textFieldEspecificacion.setBounds(358, 352, 189, 63);
		getContentPane().add(textFieldEspecificacion);
		
		JTree treeCategorias = new JTree();
		treeCategorias.setBounds(68, 93, 117, 92);
		getContentPane().add(treeCategorias);
		
		JLabel lblTitulo = new JLabel("Modificar datos de un Producto");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTitulo.setBounds(10, 11, 537, 29);
		getContentPane().add(lblTitulo);
		
		JButton btnNuevasCategoiras = new JButton("Elegir nuevas Categorías");
		btnNuevasCategoiras.setBounds(62, 458, 151, 28);
		getContentPane().add(btnNuevasCategoiras);
		
		JButton btnNuevasImagenes = new JButton("Elegir nuevas Imágenes");
		btnNuevasImagenes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNuevasImagenes.setBounds(321, 458, 151, 28);
		getContentPane().add(btnNuevasImagenes);

	}
}
