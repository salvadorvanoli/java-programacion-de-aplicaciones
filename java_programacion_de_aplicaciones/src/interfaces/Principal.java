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
import javax.swing.JCheckBox;
import javax.swing.Box;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Choice;
import javax.swing.JList;
import java.awt.List;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import java.awt.TextArea;

public class Principal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField inputNombreCategoriaAltaDeCategoria;
	private JTextPane tituloAltaDeCategoria;

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
		
		JInternalFrame altaCategoriaInternalFrame = new JInternalFrame("AltaDeCategoría");
		altaCategoriaInternalFrame.setBounds(10, 0, 600, 290);
		contentPane.add(altaCategoriaInternalFrame);
		altaCategoriaInternalFrame.getContentPane().setLayout(null);
		
		JCheckBox contieneProductosCheckbox = new JCheckBox("Contiene productos");
		contieneProductosCheckbox.setBounds(44, 94, 119, 23);
		altaCategoriaInternalFrame.getContentPane().add(contieneProductosCheckbox);
		
		tituloAltaDeCategoria = new JTextPane();
		tituloAltaDeCategoria.setText("Bienvenido a la interfaz de creación de una categoría, rellene el formulario e ingrese \"Aceptar\" para continuar.");
		tituloAltaDeCategoria.setBounds(24, 11, 535, 20);
		altaCategoriaInternalFrame.getContentPane().add(tituloAltaDeCategoria);
		
		inputNombreCategoriaAltaDeCategoria = new JTextField();
		inputNombreCategoriaAltaDeCategoria.setBounds(44, 67, 147, 20);
		altaCategoriaInternalFrame.getContentPane().add(inputNombreCategoriaAltaDeCategoria);
		inputNombreCategoriaAltaDeCategoria.setColumns(10);
		
		JLabel labelNombreCategoriaAltaDeCategoria = new JLabel("Nombre de la categoría *");
		labelNombreCategoriaAltaDeCategoria.setBounds(44, 42, 128, 14);
		altaCategoriaInternalFrame.getContentPane().add(labelNombreCategoriaAltaDeCategoria);
		
		JButton cancelarAltaDeCategoria = new JButton("Cancelar");
		cancelarAltaDeCategoria.setBounds(387, 226, 89, 23);
		altaCategoriaInternalFrame.getContentPane().add(cancelarAltaDeCategoria);
		
		JButton aceptarAltaDeCategoria = new JButton("Aceptar");
		aceptarAltaDeCategoria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		aceptarAltaDeCategoria.setBounds(486, 226, 89, 23);
		altaCategoriaInternalFrame.getContentPane().add(aceptarAltaDeCategoria);
		
		Choice selectCategoriaPadreAltaDeCategoria = new Choice();
		selectCategoriaPadreAltaDeCategoria.setBounds(44, 158, 147, 20);
		altaCategoriaInternalFrame.getContentPane().add(selectCategoriaPadreAltaDeCategoria);
		
		JLabel labelSelectDeCategoriaAltaDeCategoria = new JLabel("Seleccione una categoría a la que pertenezca");
		labelSelectDeCategoriaAltaDeCategoria.setBounds(45, 132, 244, 14);
		altaCategoriaInternalFrame.getContentPane().add(labelSelectDeCategoriaAltaDeCategoria);
		
		JTextPane obligatorioAltaDeCategoria = new JTextPane();
		obligatorioAltaDeCategoria.setText("Los elementos marcados con * son obligatorios");
		obligatorioAltaDeCategoria.setBounds(24, 194, 231, 20);
		altaCategoriaInternalFrame.getContentPane().add(obligatorioAltaDeCategoria);
		
		JInternalFrame ordenDeCompraInternalFrame = new JInternalFrame("CancelarOrdenDeCompra");
		ordenDeCompraInternalFrame.setBounds(10, 301, 600, 264);
		contentPane.add(ordenDeCompraInternalFrame);
		ordenDeCompraInternalFrame.getContentPane().setLayout(null);
		
		JTextPane tituloCancelarOrdenDeCompra = new JTextPane();
		tituloCancelarOrdenDeCompra.setText("Bienvenido a la interfaz de eliminación de órdenes de compra, elija una y seleccione \"Eliminar\"");
		tituloCancelarOrdenDeCompra.setBounds(27, 11, 534, 20);
		ordenDeCompraInternalFrame.getContentPane().add(tituloCancelarOrdenDeCompra);
		
		JLabel labelSelectOrdenCancelarOrdenDeCompra = new JLabel("Seleccione la orden de compra *");
		labelSelectOrdenCancelarOrdenDeCompra.setBounds(44, 53, 162, 14);
		ordenDeCompraInternalFrame.getContentPane().add(labelSelectOrdenCancelarOrdenDeCompra);
		
		Choice selectOrdenCancelarOrdenDeCompra = new Choice();
		selectOrdenCancelarOrdenDeCompra.setBounds(44, 73, 153, 20);
		ordenDeCompraInternalFrame.getContentPane().add(selectOrdenCancelarOrdenDeCompra);
		
		JButton cancelarCancelarOrdenDeCompra = new JButton("Cancelar");
		cancelarCancelarOrdenDeCompra.setBounds(390, 200, 89, 23);
		ordenDeCompraInternalFrame.getContentPane().add(cancelarCancelarOrdenDeCompra);
		
		JButton aceptarCancelarOrdenDeCompra = new JButton("Aceptar");
		aceptarCancelarOrdenDeCompra.setBounds(489, 200, 89, 23);
		ordenDeCompraInternalFrame.getContentPane().add(aceptarCancelarOrdenDeCompra);
		
		JButton eliminarOrdenCancelarOrdenDeCompra = new JButton("Eliminar");
		eliminarOrdenCancelarOrdenDeCompra.setBounds(213, 70, 89, 23);
		ordenDeCompraInternalFrame.getContentPane().add(eliminarOrdenCancelarOrdenDeCompra);
		
		JTextPane obligatorioCancelarOrdenDeCompra = new JTextPane();
		obligatorioCancelarOrdenDeCompra.setText("Los elementos marcados con * son obligatorios");
		obligatorioCancelarOrdenDeCompra.setBounds(27, 130, 231, 20);
		ordenDeCompraInternalFrame.getContentPane().add(obligatorioCancelarOrdenDeCompra);
		
		TextArea textAreaInfoOrdenDeCompra = new TextArea();
		textAreaInfoOrdenDeCompra.setText("Aquí irá el texto con la info de la orden de compra");
		textAreaInfoOrdenDeCompra.setBounds(325, 53, 249, 120);
		ordenDeCompraInternalFrame.getContentPane().add(textAreaInfoOrdenDeCompra);
		ordenDeCompraInternalFrame.setVisible(true);
		altaCategoriaInternalFrame.setVisible(true);
	}
}
