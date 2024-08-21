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
import javax.swing.JTable;
import java.awt.GridLayout;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JSeparator;

public class Principal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField CampoNombre;
	private JTextField CampoEspecificacion;
	private JTextField CampoPrecio;

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
		RegistrarProducto.setBounds(47, 24, 235, 232);
		RegistrarProducto.setPreferredSize(new Dimension(250, 300));
		RegistrarProducto.setFrameIcon(new ImageIcon("C:\\Users\\felip\\Downloads\\Diseño sin título (1).png"));
		RegistrarProducto.setClosable(true);
		RegistrarProducto.setResizable(true);
		contentPane.add(RegistrarProducto);
		RegistrarProducto.getContentPane().setLayout(null);
		
		JLabel TextoDescripcion = new JLabel("Descripción");
		TextoDescripcion.setBounds(10, 55, 54, 14);
		RegistrarProducto.getContentPane().add(TextoDescripcion);
		
		CampoNombre = new JTextField();
		CampoNombre.setBounds(10, 25, 86, 20);
		RegistrarProducto.getContentPane().add(CampoNombre);
		CampoNombre.setColumns(10);
		
		CampoEspecificacion = new JTextField();
		CampoEspecificacion.setColumns(10);
		CampoEspecificacion.setBounds(110, 25, 86, 20);
		RegistrarProducto.getContentPane().add(CampoEspecificacion);
		
		JLabel TextoNombre = new JLabel("Nombre");
		TextoNombre.setBounds(10, 11, 46, 14);
		RegistrarProducto.getContentPane().add(TextoNombre);
		
		JTextArea CampoDescripcion = new JTextArea();
		CampoDescripcion.setBounds(10, 69, 186, 43);
		RegistrarProducto.getContentPane().add(CampoDescripcion);
		
		JLabel TextoEspecificacion = new JLabel("Especificación");
		TextoEspecificacion.setBounds(110, 11, 71, 14);
		RegistrarProducto.getContentPane().add(TextoEspecificacion);
		
		JLabel TextoPrecio = new JLabel("Precio");
		TextoPrecio.setBounds(10, 125, 29, 14);
		RegistrarProducto.getContentPane().add(TextoPrecio);
		
		CampoPrecio = new JTextField();
		CampoPrecio.setColumns(10);
		CampoPrecio.setBounds(10, 139, 86, 20);
		RegistrarProducto.getContentPane().add(CampoPrecio);
		
		JLabel TextoImagen = new JLabel("Imagen");
		TextoImagen.setBounds(110, 125, 46, 14);
		RegistrarProducto.getContentPane().add(TextoImagen);
		
		JButton BotonSeleccionImagen = new JButton("Seleccionar...");
		BotonSeleccionImagen.setBounds(110, 138, 89, 23);
		RegistrarProducto.getContentPane().add(BotonSeleccionImagen);
		
		JButton BotonRegistrar = new JButton("Registrar");
		BotonRegistrar.setBounds(52, 170, 104, 23);
		RegistrarProducto.getContentPane().add(BotonRegistrar);
		
		JInternalFrame VerInfoProveedor = new JInternalFrame("Información del Proveedor");
		VerInfoProveedor.setClosable(true);
		VerInfoProveedor.setResizable(true);
		VerInfoProveedor.setFrameIcon(new ImageIcon("C:\\Users\\felip\\Downloads\\Diseño sin título (1).png"));
		VerInfoProveedor.setBounds(325, 215, 256, 220);
		contentPane.add(VerInfoProveedor);
		VerInfoProveedor.getContentPane().setLayout(null);
		
		JLabel Nick = new JLabel("Nick");
		Nick.setBackground(new Color(0, 0, 0));
		Nick.setBounds(0, 1, 120, 28);
		Nick.setHorizontalAlignment(SwingConstants.CENTER);
		Nick.setFont(new Font("Tahoma", Font.PLAIN, 11));
		VerInfoProveedor.getContentPane().add(Nick);
		
		JLabel Foto = new JLabel("Foto");
		Foto.setHorizontalAlignment(SwingConstants.CENTER);
		Foto.setBounds(120, 1, 120, 109);
		VerInfoProveedor.getContentPane().add(Foto);
		
		JLabel Nombre = new JLabel("Nombre");
		Nombre.setSize(new Dimension(19, 14));
		Nombre.setMinimumSize(new Dimension(19, 14));
		Nombre.setMaximumSize(new Dimension(19, 14));
		Nombre.setBounds(0, 28, 120, 28);
		Nombre.setHorizontalAlignment(SwingConstants.CENTER);
		Nombre.setFont(new Font("Tahoma", Font.PLAIN, 11));
		VerInfoProveedor.getContentPane().add(Nombre);
		
		JLabel Apellido = new JLabel("Apellido");
		Apellido.setBounds(0, 55, 120, 28);
		Apellido.setHorizontalAlignment(SwingConstants.CENTER);
		Apellido.setFont(new Font("Tahoma", Font.PLAIN, 11));
		VerInfoProveedor.getContentPane().add(Apellido);
		
		JLabel FechaNacimiento = new JLabel("Fecha de Nacimiento");
		FechaNacimiento.setHorizontalAlignment(SwingConstants.CENTER);
		FechaNacimiento.setBounds(0, 109, 120, 28);
		VerInfoProveedor.getContentPane().add(FechaNacimiento);
		
		JLabel Email = new JLabel("Email");
		Email.setBounds(0, 136, 240, 28);
		Email.setHorizontalAlignment(SwingConstants.CENTER);
		Email.setFont(new Font("Tahoma", Font.PLAIN, 11));
		VerInfoProveedor.getContentPane().add(Email);
		
		JLabel label_2 = new JLabel("");
		label_2.setBounds(120, 127, 120, 42);
		VerInfoProveedor.getContentPane().add(label_2);
		
		JLabel NombreCompania = new JLabel("Nombre Compania");
		NombreCompania.setHorizontalAlignment(SwingConstants.CENTER);
		NombreCompania.setBounds(0, 82, 120, 28);
		VerInfoProveedor.getContentPane().add(NombreCompania);
		
		JLabel Link = new JLabel("Link");
		Link.setHorizontalAlignment(SwingConstants.CENTER);
		Link.setBounds(0, 163, 240, 28);
		VerInfoProveedor.getContentPane().add(Link);
		VerInfoProveedor.setVisible(true);
		RegistrarProducto.setVisible(true);
	}
}
