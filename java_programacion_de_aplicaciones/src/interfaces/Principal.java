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
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextArea;

public class Principal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_4;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_5;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_14;
	private JTextField textField_15;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;

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
		
		JInternalFrame RegistrarCliente = new JInternalFrame("Registrar Usuario");
		RegistrarCliente.setBackground(new Color(253, 238, 247));
		RegistrarCliente.setClosable(true);
		RegistrarCliente.setBounds(-274, 49, 385, 399);
		contentPane.add(RegistrarCliente);
		RegistrarCliente.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(106, 51, 222, 20);
		RegistrarCliente.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Registrar Cliente");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(0, 11, 369, 29);
		RegistrarCliente.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nickname");
		lblNewLabel_1.setBounds(38, 54, 48, 14);
		RegistrarCliente.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Correo Electrónico");
		lblNewLabel_1_2.setBounds(38, 98, 89, 14);
		RegistrarCliente.getContentPane().add(lblNewLabel_1_2);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(148, 95, 180, 20);
		RegistrarCliente.getContentPane().add(textField_4);
		
		JLabel lblNewLabel_1_1 = new JLabel("Nombre");
		lblNewLabel_1_1.setBounds(38, 143, 48, 14);
		RegistrarCliente.getContentPane().add(lblNewLabel_1_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(96, 140, 232, 20);
		RegistrarCliente.getContentPane().add(textField_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Apellido");
		lblNewLabel_1_1_1.setBounds(38, 188, 48, 14);
		RegistrarCliente.getContentPane().add(lblNewLabel_1_1_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(96, 185, 232, 20);
		RegistrarCliente.getContentPane().add(textField_2);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Fecha de Nacimiento");
		lblNewLabel_1_2_1.setBounds(38, 233, 102, 14);
		RegistrarCliente.getContentPane().add(lblNewLabel_1_2_1);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(38, 258, 37, 20);
		RegistrarCliente.getContentPane().add(textField_3);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("/");
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_1_1_1.setBounds(85, 260, 5, 14);
		RegistrarCliente.getContentPane().add(lblNewLabel_1_1_1_1);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(162, 258, 37, 20);
		RegistrarCliente.getContentPane().add(textField_6);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("/");
		lblNewLabel_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_1_1_1_1.setBounds(147, 260, 5, 14);
		RegistrarCliente.getContentPane().add(lblNewLabel_1_1_1_1_1);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(100, 258, 37, 20);
		RegistrarCliente.getContentPane().add(textField_7);
		
		JLabel lblNewLabel_1_1_1_2 = new JLabel("Día");
		lblNewLabel_1_1_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1_2.setBounds(38, 281, 37, 14);
		RegistrarCliente.getContentPane().add(lblNewLabel_1_1_1_2);
		
		JLabel lblNewLabel_1_1_1_2_1 = new JLabel("Mes");
		lblNewLabel_1_1_1_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1_2_1.setBounds(100, 281, 37, 14);
		RegistrarCliente.getContentPane().add(lblNewLabel_1_1_1_2_1);
		
		JLabel lblNewLabel_1_1_1_2_1_1 = new JLabel("Año");
		lblNewLabel_1_1_1_2_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1_2_1_1.setBounds(162, 281, 37, 14);
		RegistrarCliente.getContentPane().add(lblNewLabel_1_1_1_2_1_1);
		
		JButton lblNewLabel_2 = new JButton("Asignar una imagen");
		lblNewLabel_2.setBounds(38, 319, 144, 20);
		RegistrarCliente.getContentPane().add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("Registrar");
		btnNewButton.setBackground(new Color(250, 214, 235));
		btnNewButton.setBounds(255, 335, 89, 23);
		RegistrarCliente.getContentPane().add(btnNewButton);
		
		JInternalFrame RegistrarProveedor = new JInternalFrame("Registrar Usuario");
		RegistrarProveedor.setClosable(true);
		RegistrarProveedor.getContentPane().setBackground(new Color(253, 238, 247));
		RegistrarProveedor.setBounds(-319, 11, 385, 486);
		contentPane.add(RegistrarProveedor);
		RegistrarProveedor.getContentPane().setLayout(null);
		
		JLabel lblNewLabel_1_3 = new JLabel("Nickname");
		lblNewLabel_1_3.setBounds(38, 54, 48, 14);
		RegistrarProveedor.getContentPane().add(lblNewLabel_1_3);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(106, 51, 222, 20);
		RegistrarProveedor.getContentPane().add(textField_5);
		
		JLabel lblNewLabel_1_2_2 = new JLabel("Correo Electrónico");
		lblNewLabel_1_2_2.setBounds(38, 98, 89, 14);
		RegistrarProveedor.getContentPane().add(lblNewLabel_1_2_2);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(148, 95, 180, 20);
		RegistrarProveedor.getContentPane().add(textField_8);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Nombre");
		lblNewLabel_1_1_2.setBounds(38, 143, 48, 14);
		RegistrarProveedor.getContentPane().add(lblNewLabel_1_1_2);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(96, 140, 232, 20);
		RegistrarProveedor.getContentPane().add(textField_9);
		
		JLabel lblNewLabel_1_1_1_3 = new JLabel("Apellido");
		lblNewLabel_1_1_1_3.setBounds(38, 188, 48, 14);
		RegistrarProveedor.getContentPane().add(lblNewLabel_1_1_1_3);
		
		textField_10 = new JTextField();
		textField_10.setColumns(10);
		textField_10.setBounds(96, 185, 232, 20);
		RegistrarProveedor.getContentPane().add(textField_10);
		
		JLabel lblRegistrarProovedor = new JLabel("Registrar Proveedor");
		lblRegistrarProovedor.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegistrarProovedor.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblRegistrarProovedor.setBounds(0, 11, 369, 29);
		RegistrarProveedor.getContentPane().add(lblRegistrarProovedor);
		
		JLabel lblNewLabel_1_1_2_1 = new JLabel("Nombre de la Compañía");
		lblNewLabel_1_1_2_1.setBounds(38, 227, 118, 14);
		RegistrarProveedor.getContentPane().add(lblNewLabel_1_1_2_1);
		
		textField_14 = new JTextField();
		textField_14.setColumns(10);
		textField_14.setBounds(172, 224, 156, 20);
		RegistrarProveedor.getContentPane().add(textField_14);
		
		JLabel lblNewLabel_1_1_1_3_1 = new JLabel("Link Web");
		lblNewLabel_1_1_1_3_1.setBounds(38, 272, 48, 14);
		RegistrarProveedor.getContentPane().add(lblNewLabel_1_1_1_3_1);
		
		textField_15 = new JTextField();
		textField_15.setColumns(10);
		textField_15.setBounds(96, 269, 232, 20);
		RegistrarProveedor.getContentPane().add(textField_15);
		
		textField_11 = new JTextField();
		textField_11.setColumns(10);
		textField_11.setBounds(38, 337, 37, 20);
		RegistrarProveedor.getContentPane().add(textField_11);
		
		JLabel lblNewLabel_1_2_1_2 = new JLabel("Fecha de Nacimiento");
		lblNewLabel_1_2_1_2.setBounds(38, 312, 102, 14);
		RegistrarProveedor.getContentPane().add(lblNewLabel_1_2_1_2);
		
		JLabel lblNewLabel_1_1_1_2_2 = new JLabel("Día");
		lblNewLabel_1_1_1_2_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1_2_2.setBounds(38, 360, 37, 14);
		RegistrarProveedor.getContentPane().add(lblNewLabel_1_1_1_2_2);
		
		JLabel lblNewLabel_1_1_1_1_2 = new JLabel("/");
		lblNewLabel_1_1_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_1_1_1_2.setBounds(85, 339, 5, 14);
		RegistrarProveedor.getContentPane().add(lblNewLabel_1_1_1_1_2);
		
		textField_12 = new JTextField();
		textField_12.setColumns(10);
		textField_12.setBounds(100, 337, 37, 20);
		RegistrarProveedor.getContentPane().add(textField_12);
		
		JLabel lblNewLabel_1_1_1_2_1_2 = new JLabel("Mes");
		lblNewLabel_1_1_1_2_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1_2_1_2.setBounds(100, 360, 37, 14);
		RegistrarProveedor.getContentPane().add(lblNewLabel_1_1_1_2_1_2);
		
		JLabel lblNewLabel_1_1_1_1_1_1 = new JLabel("/");
		lblNewLabel_1_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_1_1_1_1_1.setBounds(147, 339, 5, 14);
		RegistrarProveedor.getContentPane().add(lblNewLabel_1_1_1_1_1_1);
		
		textField_13 = new JTextField();
		textField_13.setColumns(10);
		textField_13.setBounds(162, 337, 37, 20);
		RegistrarProveedor.getContentPane().add(textField_13);
		
		JLabel lblNewLabel_1_1_1_2_1_1_1 = new JLabel("Año");
		lblNewLabel_1_1_1_2_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1_2_1_1_1.setBounds(162, 360, 37, 14);
		RegistrarProveedor.getContentPane().add(lblNewLabel_1_1_1_2_1_1_1);
		
		JButton lblNewLabel_2_1 = new JButton("Asignar una imagen");
		lblNewLabel_2_1.setBounds(38, 398, 144, 20);
		RegistrarProveedor.getContentPane().add(lblNewLabel_2_1);
		
		JButton btnNewButton_1 = new JButton("Registrar");
		btnNewButton_1.setBackground(new Color(250, 214, 235));
		btnNewButton_1.setBounds(256, 422, 89, 23);
		RegistrarProveedor.getContentPane().add(btnNewButton_1);
		
		JInternalFrame VerInfoProducto = new JInternalFrame("Ver Información de Producto");
		VerInfoProducto.setClosable(true);
		VerInfoProducto.setBounds(148, 49, 329, 469);
		contentPane.add(VerInfoProducto);
		VerInfoProducto.getContentPane().setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Seleccione una categoría del sistema");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_3.setBounds(0, 22, 313, 14);
		VerInfoProducto.getContentPane().add(lblNewLabel_3);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(30, 47, 255, 22);
		VerInfoProducto.getContentPane().add(comboBox);
		
		JLabel lblNewLabel_3_1 = new JLabel("Seleccione un producto");
		lblNewLabel_3_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_3_1.setBounds(0, 98, 313, 14);
		VerInfoProducto.getContentPane().add(lblNewLabel_3_1);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(30, 123, 255, 22);
		VerInfoProducto.getContentPane().add(comboBox_1);
		
		JTextArea txtrAquSeMostrarn = new JTextArea();
		txtrAquSeMostrarn.setText("Aquí se mostrarán los datos \r\ndel producto");
		txtrAquSeMostrarn.setBounds(30, 193, 255, 221);
		VerInfoProducto.getContentPane().add(txtrAquSeMostrarn);
		VerInfoProducto.setVisible(true);
		RegistrarProveedor.setVisible(true);
		RegistrarCliente.setVisible(true);
	}
}
