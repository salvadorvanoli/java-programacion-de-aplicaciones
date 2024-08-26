package interfaces;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
*/

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

// Importamos la capa de lógica
import clases.SistemaFactory;
import clases.ISistema;
import java.awt.Toolkit;

public class Main {
	
	private JFrame menuPrincipal;
    private ISistema sistema;
    private AltaDeCategoria altaCategoriaInternalFrame;
    private CancelarOrdenDeCompra cancelarOrdenInternalFrame;
    private GenerarOrdenDeCompra generarOrdenInternalFrame;
    private InfoProveedorDetallado infoProveedorInternalFrame;
    private ListarProveedores listarProveedoresInternalFrame;
    private ModificarDatosProducto modificarProductoInternalFrame;
    private RegistrarCliente registrarClienteInternalFrame;
    private RegistrarProducto registrarProductoInternalFrame;
    private RegistrarProveedor registrarProveedorInternalFrame;
    private VerInfoOrdenDeCompra infoOrdenInternalFrame;
    private VerInfoProducto infoProductoInternalFrame;
    private VerInformacionCliente infoClienteInternalFrame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
					frame.menuPrincipal.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Main() {
		initialize();
		
		SistemaFactory fabrica = SistemaFactory.getInstancia();
		sistema = fabrica.getISistema();
		
		// Creamos cada uno de los InternalFrame (uno por caso de uso) y lo seteamos en invisible.
		
		altaCategoriaInternalFrame = new AltaDeCategoria();
		altaCategoriaInternalFrame.setVisible(false);
		
	    cancelarOrdenInternalFrame = new CancelarOrdenDeCompra();
	    cancelarOrdenInternalFrame.setVisible(false);
	    
	    generarOrdenInternalFrame = new GenerarOrdenDeCompra();
	    generarOrdenInternalFrame.setVisible(false);
	    
	    infoProveedorInternalFrame = new InfoProveedorDetallado();
	    infoProveedorInternalFrame.setVisible(false);
	    
	    listarProveedoresInternalFrame = new ListarProveedores();
	    listarProveedoresInternalFrame.setVisible(false);
	    
	    modificarProductoInternalFrame = new ModificarDatosProducto();
	    modificarProductoInternalFrame.setVisible(false);
	    
	    registrarClienteInternalFrame = new RegistrarCliente();
	    registrarClienteInternalFrame.setVisible(false);
	    
	    registrarProductoInternalFrame = new RegistrarProducto();
	    registrarProductoInternalFrame.setVisible(false);
	    
	    registrarProveedorInternalFrame = new RegistrarProveedor();
	    registrarProveedorInternalFrame.setVisible(false);
	    
	    infoOrdenInternalFrame = new VerInfoOrdenDeCompra();
	    infoOrdenInternalFrame.setVisible(false);
	    
	    infoProductoInternalFrame = new VerInfoProducto();
	    infoProductoInternalFrame.setVisible(false);
	    
	    infoClienteInternalFrame = new VerInformacionCliente();
	    infoClienteInternalFrame.setVisible(false);
	    
	    // ESTO LO AGREGUE YO
	    /*
	    JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		menuPrincipal.setContentPane(contentPane);
		*/
		// HASTA ACA
	    
	    menuPrincipal.getContentPane().setLayout(null);
	    
	    /*
	    menuPrincipal.getContentPane().add(altaCategoriaInternalFrame);
	    menuPrincipal.getContentPane().add(cancelarOrdenInternalFrame);
	    menuPrincipal.getContentPane().add(generarOrdenInternalFrame);
	    menuPrincipal.getContentPane().add(infoProveedorInternalFrame);
	    menuPrincipal.getContentPane().add(listarProveedoresInternalFrame);
	    menuPrincipal.getContentPane().add(modificarProductoInternalFrame);
	    menuPrincipal.getContentPane().add(registrarClienteInternalFrame);
	    menuPrincipal.getContentPane().add(registrarProductoInternalFrame);
	    menuPrincipal.getContentPane().add(registrarProveedorInternalFrame);
	    menuPrincipal.getContentPane().add(infoOrdenInternalFrame);
	    menuPrincipal.getContentPane().add(infoProductoInternalFrame);
	    menuPrincipal.getContentPane().add(infoClienteInternalFrame);
	    */
	    
	    /*
		altaCategoriaInternalFrame.setVisible(false);
	    cancelarOrdenInternalFrame.setVisible(false);
	    generarOrdenInternalFrame.setVisible(false);
	    infoProveedorInternalFrame.setVisible(false);
	    listarProveedoresInternalFrame.setVisible(false);
	    modificarProductoInternalFrame.setVisible(false);
	    registrarClienteInternalFrame.setVisible(false);
	    registrarProductoInternalFrame.setVisible(false);
	    registrarProveedorInternalFrame.setVisible(false);
	    infoOrdenInternalFrame.setVisible(false);
	    infoProductoInternalFrame.setVisible(false);
	    infoClienteInternalFrame.setVisible(false);
	    */
	    
	}
	
	private void initialize() {
		menuPrincipal = new JFrame();
		menuPrincipal.setIconImage(Toolkit.getDefaultToolkit().getImage(Main.class.getResource("/Images/Flamin-Go.png")));
		menuPrincipal.setTitle("Flamin-Go");
		
		menuPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		menuPrincipal.setBounds(100, 100, 647, 695);
		
		JMenuBar menuBar = new JMenuBar();
		menuPrincipal.setJMenuBar(menuBar);
		
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
		mntmNewMenuItem_5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuPrincipal.getContentPane().add(altaCategoriaInternalFrame);
                altaCategoriaInternalFrame.setVisible(true);
                altaCategoriaInternalFrame.setLocation(0, 0);  // Ajustar la posición del InternalFrame
                menuPrincipal.revalidate();
                menuPrincipal.repaint();
            }
        });
		
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
		
		/*
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		*/
	}

}
