package interfaces;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;

import clases.ISistema;
import excepciones.ProductoNoExisteException;

import javax.swing.JTextArea;
import javax.swing.ImageIcon;
import javax.swing.JTree;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JFileChooser;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

//Importamos clases del package "clases"

import clases.DTCliente;
import clases.DTProducto;
import clases.DTProductoDetallado;

public class ModificarDatosProducto extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private ISistema sistema;
	private Main menu;
	private JComboBox<DTProducto> seleccionProducto;
	private JTextField textFieldNombre;
	private JTextField textFieldNumReferencia;
	private JTextField textFieldPrecio;
	private JTextArea textAreaDescripcion;
	private JTextArea textAreaEspecificacion;

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
	public ModificarDatosProducto(ISistema sistema, Main menu) {
		setFrameIcon(new ImageIcon(ModificarDatosProducto.class.getResource("/Images/Flamin-Go.png")));
		setTitle("Flamin-Go");
		setClosable(true);
		setBounds(100, 100, 574, 581);
		getContentPane().setLayout(null);
		
		this.sistema = sistema;
		this.menu = menu;
		
		JLabel lblTitulo = new JLabel("Modificar datos de un Producto");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTitulo.setBounds(10, 11, 537, 29);
		getContentPane().add(lblTitulo);
		
		JLabel labelSeleccionCategoria = new JLabel("Selecciona una de las categorías listadas debajo *");
		labelSeleccionCategoria.setBounds(10, 54, 239, 28);
		getContentPane().add(labelSeleccionCategoria);
		
		JTree treeCategorias = new JTree();
		treeCategorias.setBounds(68, 93, 117, 92);
		getContentPane().add(treeCategorias);
		
		JLabel labelSeleccionProducto = new JLabel("Selecciona uno de los productos listados debajo *");
		labelSeleccionProducto.setBounds(285, 54, 239, 28);
		getContentPane().add(labelSeleccionProducto);
		
		JComboBox<DTProducto> seleccionProducto = new JComboBox<DTProducto>();
		seleccionProducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DTProducto seleccionado = (DTProducto) seleccionProducto.getSelectedItem(); // TENEMOS QUE INCLUIR EL NUMERO DE REFERENCIA EN DTPRODUCTO
                if (seleccionado != null) {
                    String nombre = seleccionado.getNombre();
                    // String numReferencia = seleccionado.getNumReferencia();
                    try {
                        sistema.elegirProducto(nombre/*, numReferencia*/);
                        DTProductoDetallado prodDetallado = sistema.verInformacionProducto();
                        textFieldNombre.setText(prodDetallado.getNombre());
                        textFieldNumReferencia.setText(String.valueOf(prodDetallado.getNumReferencia()));
                        textFieldPrecio.setText(String.valueOf(prodDetallado.getPrecio()));
                        textAreaDescripcion.setText(prodDetallado.getDescricpion());
                        textAreaEspecificacion.setText(prodDetallado.getEspecificaciones());
                    } catch (ProductoNoExisteException e1) {
                        // CREAR UNA VENTANA DE ERROR
                    }
                } else {
                    // CREAR UNA VENTANA DE ERROR
                }
			}
		});
		seleccionProducto.setBounds(264, 93, 283, 28);
		getContentPane().add(seleccionProducto);
		
		this.seleccionProducto = seleccionProducto;
		
		JLabel labelDatosAModificar = new JLabel("A continuación, modifica los datos a tu elección");
		labelDatosAModificar.setBounds(10, 214, 309, 28);
		getContentPane().add(labelDatosAModificar);
		
		JLabel labelNuevoNombreProducto = new JLabel("Nombre");
		labelNuevoNombreProducto.setBounds(10, 272, 42, 28);
		getContentPane().add(labelNuevoNombreProducto);
		
		JTextField textFieldNombre = new JTextField();
		textFieldNombre.setColumns(10);
		textFieldNombre.setBounds(62, 276, 175, 20);
		getContentPane().add(textFieldNombre);
		
		this.textFieldNombre = textFieldNombre;
		
		JLabel labelNuevoNumReferenciaProducto = new JLabel("Num. Referencia");
		labelNuevoNumReferenciaProducto.setBounds(10, 311, 100, 28);
		getContentPane().add(labelNuevoNumReferenciaProducto);
		
		JTextField textFieldNumReferencia = new JTextField();
		textFieldNumReferencia.setColumns(10);
		textFieldNumReferencia.setBounds(108, 315, 129, 20);
		getContentPane().add(textFieldNumReferencia);
		
		this.textFieldNumReferencia = textFieldNumReferencia;
		
		JLabel labelNuevoPrecioProducto = new JLabel("Precio");
		labelNuevoPrecioProducto.setBounds(10, 350, 100, 28);
		getContentPane().add(labelNuevoPrecioProducto);
		
		JTextField textFieldPrecio = new JTextField();
		textFieldPrecio.setColumns(10);
		textFieldPrecio.setBounds(62, 354, 175, 20);
		getContentPane().add(textFieldPrecio);
		
		this.textFieldPrecio = textFieldPrecio;
		
		JLabel labelNuevaDescripcionProducto = new JLabel("Descripción");
		labelNuevaDescripcionProducto.setBounds(271, 272, 100, 28);
		getContentPane().add(labelNuevaDescripcionProducto);
		
		JTextArea textAreaDescripcion = new JTextArea();
		textAreaDescripcion.setColumns(10);
		textAreaDescripcion.setBounds(358, 274, 189, 62);
		getContentPane().add(textAreaDescripcion);
		
		this.textAreaDescripcion = textAreaDescripcion;
		
		JLabel labelNuevaEspecificacionProducto = new JLabel("Especificación");
		labelNuevaEspecificacionProducto.setBounds(271, 350, 100, 28);
		getContentPane().add(labelNuevaEspecificacionProducto);
		
		JTextArea textAreaEspecificacion = new JTextArea();
		textAreaEspecificacion.setColumns(10);
		textAreaEspecificacion.setBounds(358, 352, 189, 63);
		getContentPane().add(textAreaEspecificacion);
		
		this.textAreaEspecificacion = textAreaEspecificacion;
		
		JButton btnNuevasCategoiras = new JButton("Elegir nuevas Categorías");
		btnNuevasCategoiras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// infoClienteInternalFrame.toBack();
				menu.getMenuPrincipal().getContentPane().add(menu.getModificarCategoriasProductoInternalFrame());
				// infoOrdenInternalFrame.toFront(); // Traigo el internal frame al frente
				menu.getModificarCategoriasProductoInternalFrame().setVisible(true);
				menu.getModificarCategoriasProductoInternalFrame().setLocation(0, 0);  // Ajustar la posición del InternalFrame
				menu.getMenuPrincipal().revalidate();
				menu.getMenuPrincipal().repaint();
			}
		});
		btnNuevasCategoiras.setBounds(62, 458, 151, 28);
		getContentPane().add(btnNuevasCategoiras);
		
		JButton btnNuevasImagenes = new JButton("Elegir nuevas Imágenes");
		btnNuevasImagenes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// infoClienteInternalFrame.toBack();
				menu.getMenuPrincipal().getContentPane().add(menu.getModificarImagenesProductoInternalFrame());
				// infoOrdenInternalFrame.toFront(); // Traigo el internal frame al frente
				menu.getModificarImagenesProductoInternalFrame().setVisible(true);
				menu.getModificarImagenesProductoInternalFrame().setLocation(0, 0);  // Ajustar la posición del InternalFrame
				menu.getMenuPrincipal().revalidate();
				menu.getMenuPrincipal().repaint();
			}
		});
		btnNuevasImagenes.setBounds(321, 458, 151, 28);
		getContentPane().add(btnNuevasImagenes);

	}
}
