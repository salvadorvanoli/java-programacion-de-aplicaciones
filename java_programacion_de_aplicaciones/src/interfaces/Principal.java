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
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.Rectangle;
import javax.swing.ImageIcon;
import java.awt.Dimension;
import java.awt.BorderLayout;
import javax.swing.JTextArea;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JScrollBar;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Principal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
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
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\felip\\Downloads\\Diseño sin título (1).png"));
		setBackground(new Color(255, 255, 255));
		setTitle("FlaminGo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 647, 695);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu MenuSesión = new JMenu("Sesión");
		menuBar.add(MenuSesión);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Cliente");
		MenuSesión.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Proveedor");
		MenuSesión.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Administrador");
		MenuSesión.add(mntmNewMenuItem_2);
		
		JMenu MenuCasosDeUsos = new JMenu("Casos de usos");
		menuBar.add(MenuCasosDeUsos);
		
		JMenu mnNewMenu_2 = new JMenu("Registros");
		MenuCasosDeUsos.add(mnNewMenu_2);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Usuario");
		mnNewMenu_2.add(mntmNewMenuItem_3);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Producto");
		mnNewMenu_2.add(mntmNewMenuItem_4);
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("Categoría");
		mnNewMenu_2.add(mntmNewMenuItem_5);
		
		JMenuItem mntmNewMenuItem_12 = new JMenuItem("Orden de compra");
		mnNewMenu_2.add(mntmNewMenuItem_12);
		
		JMenu mnNewMenu_3 = new JMenu("Consultas");
		MenuCasosDeUsos.add(mnNewMenu_3);
		
		JMenuItem mntmNewMenuItem_6 = new JMenuItem("Información cliente");
		mnNewMenu_3.add(mntmNewMenuItem_6);
		
		JMenuItem mntmNewMenuItem_7 = new JMenuItem("Información proveedor");
		mnNewMenu_3.add(mntmNewMenuItem_7);
		
		JMenuItem mntmNewMenuItem_8 = new JMenuItem("Información producto");
		mnNewMenu_3.add(mntmNewMenuItem_8);
		
		JMenuItem mntmNewMenuItem_9 = new JMenuItem("Información Orden de Compra");
		mnNewMenu_3.add(mntmNewMenuItem_9);
		
		JMenu mnNewMenu_4 = new JMenu("Modificaciones");
		MenuCasosDeUsos.add(mnNewMenu_4);
		
		JMenuItem mntmNewMenuItem_10 = new JMenuItem("Producto");
		mnNewMenu_4.add(mntmNewMenuItem_10);
		
		JMenu mnNewMenu_5 = new JMenu("Supresiones");
		MenuCasosDeUsos.add(mnNewMenu_5);
		
		JMenuItem mntmNewMenuItem_11 = new JMenuItem("Orden de Compra");
		mnNewMenu_5.add(mntmNewMenuItem_11);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 153, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JInternalFrame RegistrarProducto = new JInternalFrame("Registrar Producto");
		RegistrarProducto.setBounds(207, 28, 235, 205);
		RegistrarProducto.setPreferredSize(new Dimension(250, 300));
		RegistrarProducto.setFrameIcon(new ImageIcon("C:\\Users\\felip\\Downloads\\Diseño sin título (1).png"));
		RegistrarProducto.setClosable(true);
		RegistrarProducto.setResizable(true);
		contentPane.add(RegistrarProducto);
		RegistrarProducto.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Descripción");
		lblNewLabel.setBounds(10, 55, 54, 14);
		RegistrarProducto.getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(10, 25, 86, 20);
		RegistrarProducto.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(110, 25, 86, 20);
		RegistrarProducto.getContentPane().add(textField_1);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre");
		lblNewLabel_1.setBounds(10, 11, 46, 14);
		RegistrarProducto.getContentPane().add(lblNewLabel_1);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(10, 69, 186, 43);
		RegistrarProducto.getContentPane().add(textArea);
		
		JLabel lblNewLabel_1_1 = new JLabel("Especificación");
		lblNewLabel_1_1.setBounds(110, 11, 71, 14);
		RegistrarProducto.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Precio");
		lblNewLabel_1_2.setBounds(10, 125, 29, 14);
		RegistrarProducto.getContentPane().add(lblNewLabel_1_2);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(10, 139, 71, 20);
		RegistrarProducto.getContentPane().add(textField_2);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Imagen");
		lblNewLabel_1_2_1.setBounds(110, 125, 46, 14);
		RegistrarProducto.getContentPane().add(lblNewLabel_1_2_1);
		
		JButton btnNewButton = new JButton("Seleccionar");
		btnNewButton.setBounds(107, 138, 89, 23);
		RegistrarProducto.getContentPane().add(btnNewButton);
		RegistrarProducto.setVisible(true);
	}
}
