package interfaces;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JToolBar;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JTextField;
import javax.swing.JInternalFrame;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class Principal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField nuevoNombreProducto;
	private JTextField nuevoNumReferenciaProducto;
	private JTextArea nuevaDescripcionProducto;
	private JTextField nuevoPrecioProducto;
	private JTextArea nuevaEspecificacionProducto;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
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
	public Principal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 647, 695);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Sesión");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Cliente");
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Proveedor");
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Administrador");
		mnNewMenu.add(mntmNewMenuItem_2);
		
		JMenu mnNewMenu_1 = new JMenu("Casos de usos");
		menuBar.add(mnNewMenu_1);
		
		JMenu mnNewMenu_2 = new JMenu("Registros");
		mnNewMenu_1.add(mnNewMenu_2);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Usuario");
		mnNewMenu_2.add(mntmNewMenuItem_3);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Producto");
		mnNewMenu_2.add(mntmNewMenuItem_4);
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("Categoría");
		mnNewMenu_2.add(mntmNewMenuItem_5);
		
		JMenuItem mntmNewMenuItem_12 = new JMenuItem("Orden de compra");
		mnNewMenu_2.add(mntmNewMenuItem_12);
		
		JMenu mnNewMenu_3 = new JMenu("Consultas");
		mnNewMenu_1.add(mnNewMenu_3);
		
		JMenuItem mntmNewMenuItem_6 = new JMenuItem("Información cliente");
		mnNewMenu_3.add(mntmNewMenuItem_6);
		
		JMenuItem mntmNewMenuItem_7 = new JMenuItem("Información proveedor");
		mnNewMenu_3.add(mntmNewMenuItem_7);
		
		JMenuItem mntmNewMenuItem_8 = new JMenuItem("Información producto");
		mnNewMenu_3.add(mntmNewMenuItem_8);
		
		JMenuItem mntmNewMenuItem_9 = new JMenuItem("Información Orden de Compra");
		mnNewMenu_3.add(mntmNewMenuItem_9);
		
		JMenu mnNewMenu_4 = new JMenu("Modificaciones");
		mnNewMenu_1.add(mnNewMenu_4);
		
		JMenuItem mntmNewMenuItem_10 = new JMenuItem("Producto");
		mnNewMenu_4.add(mntmNewMenuItem_10);
		
		JMenu mnNewMenu_5 = new JMenu("Supresiones");
		mnNewMenu_1.add(mnNewMenu_5);
		
		JMenuItem mntmNewMenuItem_11 = new JMenuItem("Orden de Compra");
		mnNewMenu_5.add(mntmNewMenuItem_11);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JInternalFrame verInformacionCliente = new JInternalFrame("Ver Información de un Cliente");
		verInformacionCliente.setClosable(true);
		verInformacionCliente.setBounds(236, 512, 385, 541);
		contentPane.add(verInformacionCliente);
		verInformacionCliente.getContentPane().setLayout(null);
		
		JComboBox seleccionCliente = new JComboBox();
		seleccionCliente.setBounds(10, 60, 352, 22);
		verInformacionCliente.getContentPane().add(seleccionCliente);
		
		JLabel labelClientesSistema = new JLabel("Selecciona uno de los clientes del sistema especificados debajo *");
		labelClientesSistema.setBounds(10, 21, 309, 28);
		verInformacionCliente.getContentPane().add(labelClientesSistema);
		
		JTextArea txtMostrarInfoCliente = new JTextArea();
		txtMostrarInfoCliente.setText("Aquí se mostrará la información del\r\ncliente elegido.");
		txtMostrarInfoCliente.setBounds(10, 93, 352, 152);
		verInformacionCliente.getContentPane().add(txtMostrarInfoCliente);
		
		JComboBox seleccionOrdenDeCompra = new JComboBox();
		seleccionOrdenDeCompra.setBounds(10, 315, 349, 22);
		verInformacionCliente.getContentPane().add(seleccionOrdenDeCompra);
		
		JLabel labelOrdenesDeCompra1 = new JLabel("Selecciona una de las ordenes de compra del cliente");
		labelOrdenesDeCompra1.setBounds(10, 264, 349, 28);
		verInformacionCliente.getContentPane().add(labelOrdenesDeCompra1);
		
		JTextArea txtMostrarInfoOrdenDeCompra = new JTextArea();
		txtMostrarInfoOrdenDeCompra.setText("Aquí se mostrará la información de la\r\norden de compra elegida.");
		txtMostrarInfoOrdenDeCompra.setBounds(10, 348, 349, 152);
		verInformacionCliente.getContentPane().add(txtMostrarInfoOrdenDeCompra);
		
		JLabel labelOrdenesDeCompra2 = new JLabel("especificado para inspeccionarla");
		labelOrdenesDeCompra2.setBounds(10, 283, 197, 22);
		verInformacionCliente.getContentPane().add(labelOrdenesDeCompra2);
		
		JInternalFrame modificarDatosProducto = new JInternalFrame("Modificar datos de un Producto");
		modificarDatosProducto.setClosable(true);
		modificarDatosProducto.setBounds(10, 21, 611, 469);
		contentPane.add(modificarDatosProducto);
		modificarDatosProducto.getContentPane().setLayout(null);
		
		JLabel labelSeleccionCategoria = new JLabel("Selecciona una de las categorías listadas debajo *");
		labelSeleccionCategoria.setBounds(10, 11, 309, 28);
		modificarDatosProducto.getContentPane().add(labelSeleccionCategoria);
		
		JComboBox seleccionCategoria = new JComboBox();
		seleccionCategoria.setBounds(10, 39, 352, 22);
		modificarDatosProducto.getContentPane().add(seleccionCategoria);
		
		JLabel labelSeleccionProducto = new JLabel("Selecciona uno de los productos listados debajo *");
		labelSeleccionProducto.setBounds(10, 81, 309, 28);
		modificarDatosProducto.getContentPane().add(labelSeleccionProducto);
		
		JComboBox seleccionProducto = new JComboBox();
		seleccionProducto.setBounds(10, 109, 352, 22);
		modificarDatosProducto.getContentPane().add(seleccionProducto);
		
		JLabel labelDatosAModificar = new JLabel("A continuación, modifica los datos a tu elección");
		labelDatosAModificar.setBounds(10, 151, 309, 28);
		modificarDatosProducto.getContentPane().add(labelDatosAModificar);
		
		JLabel labelNuevoNombreProducto = new JLabel("Nombre:");
		labelNuevoNombreProducto.setBounds(10, 209, 100, 28);
		modificarDatosProducto.getContentPane().add(labelNuevoNombreProducto);
		
		nuevoNombreProducto = new JTextField();
		nuevoNombreProducto.setBounds(120, 213, 117, 20);
		modificarDatosProducto.getContentPane().add(nuevoNombreProducto);
		nuevoNombreProducto.setColumns(10);
		
		JLabel labelNuevoNumReferenciaProducto = new JLabel("Num. Referencia:");
		labelNuevoNumReferenciaProducto.setBounds(10, 248, 100, 28);
		modificarDatosProducto.getContentPane().add(labelNuevoNumReferenciaProducto);
		
		nuevoNumReferenciaProducto = new JTextField();
		nuevoNumReferenciaProducto.setColumns(10);
		nuevoNumReferenciaProducto.setBounds(120, 252, 117, 20);
		modificarDatosProducto.getContentPane().add(nuevoNumReferenciaProducto);
		
		JLabel labelNuevaDescripcionProducto = new JLabel("Descripción:");
		labelNuevaDescripcionProducto.setBounds(301, 209, 100, 28);
		modificarDatosProducto.getContentPane().add(labelNuevaDescripcionProducto);
		
		nuevaDescripcionProducto = new JTextArea();
		nuevaDescripcionProducto.setColumns(10);
		nuevaDescripcionProducto.setBounds(388, 211, 165, 62);
		modificarDatosProducto.getContentPane().add(nuevaDescripcionProducto);
		
		JLabel labelNuevoPrecioProducto = new JLabel("Precio:");
		labelNuevoPrecioProducto.setBounds(10, 287, 100, 28);
		modificarDatosProducto.getContentPane().add(labelNuevoPrecioProducto);
		
		nuevoPrecioProducto = new JTextField();
		nuevoPrecioProducto.setColumns(10);
		nuevoPrecioProducto.setBounds(120, 291, 117, 20);
		modificarDatosProducto.getContentPane().add(nuevoPrecioProducto);
		
		JLabel labelNuevaEspecificacionProducto = new JLabel("Especificación:");
		labelNuevaEspecificacionProducto.setBounds(301, 287, 100, 28);
		modificarDatosProducto.getContentPane().add(labelNuevaEspecificacionProducto);
		
		nuevaEspecificacionProducto = new JTextArea();
		nuevaEspecificacionProducto.setColumns(10);
		nuevaEspecificacionProducto.setBounds(388, 289, 166, 63);
		modificarDatosProducto.getContentPane().add(nuevaEspecificacionProducto);
		modificarDatosProducto.setVisible(true);
		verInformacionCliente.setVisible(true);
	}
}
