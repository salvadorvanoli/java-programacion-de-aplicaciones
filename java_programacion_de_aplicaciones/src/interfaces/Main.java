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
import excepciones.UsuarioNoExisteException;
import clases.DTFecha;
import clases.ISistema;
import java.awt.Toolkit;

import clases.Cliente;
import clases.DTCliente;

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
    
    // Dos pestañas más (sirven para manejar el caso de uso ModificarDatosProducto
    private ModificarCategoriasProducto modificarCategoriasProductoInternalFrame;
    private ModificarImagenesProducto modificarImagenesProductoInternalFrame;
    
    // Agregamos getters de todo lo que posee el Main (con la idea de manejar otros casos de uso desde fuera)
    
    public JFrame getMenuPrincipal() {
    	return this.menuPrincipal;
    }
    
    public AltaDeCategoria getAltaCategoriaInternalFrame() {
    	return this.altaCategoriaInternalFrame;
    }
    
    public CancelarOrdenDeCompra getCancelarOrdenInternalFrame(){
    	return this.cancelarOrdenInternalFrame;
    }
    
    public GenerarOrdenDeCompra getGenerarOrdenInternalFrame() {
    	return this.generarOrdenInternalFrame;
    }
    
    public InfoProveedorDetallado getInfoProveedorInternalFrame() {
    	return this.infoProveedorInternalFrame;
    }
    
    public ListarProveedores getListarProveedoresInternalFrame(){
    	return this.listarProveedoresInternalFrame;
    }
    
    public ModificarDatosProducto getModificarProductoInternalFrame() {
    	return this.modificarProductoInternalFrame;
    }
    
    public RegistrarCliente getRegistrarClienteInternalFrame() {
    	return this.registrarClienteInternalFrame;
    }
    
    public RegistrarProducto getRegistrarProductoInternalFrame() {
    	return this.registrarProductoInternalFrame;
    }
    
    public RegistrarProveedor getRegistrarProveedorInternalFrame() {
    	return this.registrarProveedorInternalFrame;
    }
    
    public VerInfoOrdenDeCompra getInfoOrdenInternalFrame() {
    	return this.infoOrdenInternalFrame;
    }
    
    public VerInfoProducto getInfoProductoInternalFrame() {
    	return this.infoProductoInternalFrame;
    }
    
    public VerInformacionCliente getInfoClienteInternalFrame() {
    	return this.infoClienteInternalFrame;
    }
    
    public ModificarCategoriasProducto getModificarCategoriasProductoInternalFrame() {
    	return this.modificarCategoriasProductoInternalFrame;
    }
    
    public ModificarImagenesProducto getModificarImagenesProductoInternalFrame() {
    	return this.modificarImagenesProductoInternalFrame;
    }

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
		
		altaCategoriaInternalFrame = new AltaDeCategoria(sistema);
		altaCategoriaInternalFrame.setVisible(false);
		
	    cancelarOrdenInternalFrame = new CancelarOrdenDeCompra(sistema);
	    cancelarOrdenInternalFrame.setVisible(false);
	    
	    generarOrdenInternalFrame = new GenerarOrdenDeCompra(sistema);
	    generarOrdenInternalFrame.setVisible(false);
	    
	    infoProveedorInternalFrame = new InfoProveedorDetallado(sistema);
	    infoProveedorInternalFrame.setVisible(false);
	    
	    listarProveedoresInternalFrame = new ListarProveedores(sistema);
	    listarProveedoresInternalFrame.setVisible(false);
	    
	    modificarProductoInternalFrame = new ModificarDatosProducto(sistema, this);
	    modificarProductoInternalFrame.setVisible(false);
	    
	    registrarClienteInternalFrame = new RegistrarCliente(sistema);
	    registrarClienteInternalFrame.setVisible(false);
	    
	    registrarProductoInternalFrame = new RegistrarProducto(sistema);
	    registrarProductoInternalFrame.setVisible(false);
	    
	    registrarProveedorInternalFrame = new RegistrarProveedor(sistema);
	    registrarProveedorInternalFrame.setVisible(false);
	    
	    infoOrdenInternalFrame = new VerInfoOrdenDeCompra(sistema);
	    infoOrdenInternalFrame.setVisible(false);
	    
	    infoProductoInternalFrame = new VerInfoProducto(sistema, this);
	    infoProductoInternalFrame.setVisible(false);
	    
	    infoClienteInternalFrame = new VerInformacionCliente(sistema, this);
	    infoClienteInternalFrame.setVisible(false);
	    
	    modificarCategoriasProductoInternalFrame = new ModificarCategoriasProducto(sistema, modificarProductoInternalFrame);
	    modificarCategoriasProductoInternalFrame.setVisible(false);
	    
	    modificarImagenesProductoInternalFrame = new ModificarImagenesProducto(sistema);
	    modificarImagenesProductoInternalFrame.setVisible(false);
	    
	    // AGREGUÉ UN ADDEVENTLISTENER EN EL MAIN (PERO ES SOBRE OTRO CASO DE USO).
	    
	    /*
	    infoClienteInternalFrame.getBtnVerInfoOrdenes().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// infoClienteInternalFrame.toBack();
				menuPrincipal.getContentPane().add(infoOrdenInternalFrame);
				// infoOrdenInternalFrame.toFront(); // Traigo el internal frame al frente
                infoOrdenInternalFrame.setVisible(true);
                infoOrdenInternalFrame.setLocation(0, 0);  // Ajustar la posición del InternalFrame
                menuPrincipal.revalidate();
                menuPrincipal.repaint();
			}
		});
		*/
	    
	    menuPrincipal.getContentPane().setLayout(null);   
	}
	
	private void initialize() {
		menuPrincipal = new JFrame();
		menuPrincipal.setIconImage(Toolkit.getDefaultToolkit().getImage(Main.class.getResource("/Images/Flamin-Go.png")));
		menuPrincipal.setTitle("Flamin-Go");
		
		menuPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		menuPrincipal.setBounds(100, 100, 647, 695);
		
		JMenuBar menuBar = new JMenuBar();
		menuPrincipal.setJMenuBar(menuBar);
		
		JMenu SesionMainMenu = new JMenu("Sesión");
		menuBar.add(SesionMainMenu);
		
		JMenuItem SesionCliente = new JMenuItem("Cliente");
		SesionMainMenu.add(SesionCliente);
		
		JMenuItem SesionProveedor = new JMenuItem("Proveedor");
		SesionMainMenu.add(SesionProveedor);
		
		JMenuItem SesionAdministrador = new JMenuItem("Administrador");
		SesionMainMenu.add(SesionAdministrador);
		
		JMenu CasosDeUsoMainMenu = new JMenu("Casos de usos");
		menuBar.add(CasosDeUsoMainMenu);
		
		JMenu CasosDeUsoRegistros = new JMenu("Registros");
		CasosDeUsoMainMenu.add(CasosDeUsoRegistros);
		
		// REGISTRAR CLIENTE
		
		JMenuItem CasosDeUsoRegistrosCliente = new JMenuItem("Cliente");
		CasosDeUsoRegistros.add(CasosDeUsoRegistrosCliente);
		CasosDeUsoRegistros.add(CasosDeUsoRegistrosCliente);
		CasosDeUsoRegistrosCliente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuPrincipal.getContentPane().add(registrarClienteInternalFrame);
                registrarClienteInternalFrame.setVisible(true);
                registrarClienteInternalFrame.setLocation(0, 0);  // Ajustar la posición del InternalFrame
                menuPrincipal.revalidate();
                menuPrincipal.repaint();
            }
        });
		
		// REGISTRAR PROVEEDOR
		
		JMenuItem CasosDeUsoRegistrosProveedor = new JMenuItem("Proveedor");
		CasosDeUsoRegistros.add(CasosDeUsoRegistrosProveedor);
		CasosDeUsoRegistrosProveedor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuPrincipal.getContentPane().add(registrarProveedorInternalFrame);
                registrarProveedorInternalFrame.setVisible(true);
                registrarProveedorInternalFrame.setLocation(0, 0);  // Ajustar la posición del InternalFrame
                menuPrincipal.revalidate();
                menuPrincipal.repaint();
            }
        });
		
		// REGISTRAR PRODUCTO
		
		JMenuItem CasosDeUsoRegistrosProducto = new JMenuItem("Producto");
		CasosDeUsoRegistros.add(CasosDeUsoRegistrosProducto);
		CasosDeUsoRegistrosProducto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuPrincipal.getContentPane().add(registrarProductoInternalFrame);
                registrarProductoInternalFrame.setVisible(true);
                registrarProductoInternalFrame.setLocation(0, 0);  // Ajustar la posición del InternalFrame
                menuPrincipal.revalidate();
                menuPrincipal.repaint();
            }
        });
		
		// REGISTRAR CATEGORIA
		
		JMenuItem CasosDeUsoRegistrosCategoria = new JMenuItem("Categoría");
		CasosDeUsoRegistros.add(CasosDeUsoRegistrosCategoria);
		CasosDeUsoRegistrosCategoria.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuPrincipal.getContentPane().add(altaCategoriaInternalFrame);
                altaCategoriaInternalFrame.setVisible(true);
                altaCategoriaInternalFrame.setLocation(0, 0);  // Ajustar la posición del InternalFrame
                menuPrincipal.revalidate();
                menuPrincipal.repaint();
            }
        });
		
		// REGISTRAR ORDEN DE COMPRA
		
		JMenuItem CasosDeUsoRegistrosOrdenDeCompra = new JMenuItem("Orden de compra");
		CasosDeUsoRegistros.add(CasosDeUsoRegistrosOrdenDeCompra);
		CasosDeUsoRegistrosOrdenDeCompra.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	generarOrdenInternalFrame.cargarClientes();
                menuPrincipal.getContentPane().add(generarOrdenInternalFrame);
                generarOrdenInternalFrame.setVisible(true);
                generarOrdenInternalFrame.setLocation(0, 0);  // Ajustar la posición del InternalFrame
                menuPrincipal.revalidate();
                menuPrincipal.repaint();
            }
        });
		
		JMenu CasosDeUsoConsultas = new JMenu("Consultas");
		CasosDeUsoMainMenu.add(CasosDeUsoConsultas);
		
		// INFORMACIÓN CLIENTE
		
		JMenuItem CasosDeUsoConsultasInformacionCliente = new JMenuItem("Información cliente");
		CasosDeUsoConsultas.add(CasosDeUsoConsultasInformacionCliente);
		CasosDeUsoConsultasInformacionCliente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	try {
	            	infoClienteInternalFrame.cargarClientes();
	                menuPrincipal.getContentPane().add(infoClienteInternalFrame);
	                infoClienteInternalFrame.setVisible(true);
	                infoClienteInternalFrame.setLocation(0, 0);  // Ajustar la posición del InternalFrame
	                menuPrincipal.revalidate();
	                menuPrincipal.repaint();
            	} catch (Exception exc) {
            		System.out.println(exc.getMessage()); // ACA TENEMOS QUE AGREGAR QUE SE MUESTRE UN POPUP
            		infoClienteInternalFrame.setVisible(false);
            	}
            }
        });
		
		// INFORMACIÓN PROVEEDOR
		
		JMenuItem CasosDeUsoConsultasInformacionProveedor = new JMenuItem("Información proveedor");
		CasosDeUsoConsultas.add(CasosDeUsoConsultasInformacionProveedor);
		CasosDeUsoConsultasInformacionProveedor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuPrincipal.getContentPane().add(infoProveedorInternalFrame);
                infoProveedorInternalFrame.setVisible(true);
                infoProveedorInternalFrame.setLocation(0, 0);  // Ajustar la posición del InternalFrame
                menuPrincipal.revalidate();
                menuPrincipal.repaint();
            }
        });
		
		// INFORMACIÓN PRODUCTO
		
		JMenuItem CasosDeUsoConsultasInformacionProducto = new JMenuItem("Información producto");
		CasosDeUsoConsultas.add(CasosDeUsoConsultasInformacionProducto);
		CasosDeUsoConsultasInformacionProducto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuPrincipal.getContentPane().add(infoProductoInternalFrame);
                infoProductoInternalFrame.setVisible(true);
                infoProductoInternalFrame.setLocation(0, 0);  // Ajustar la posición del InternalFrame
                menuPrincipal.revalidate();
                menuPrincipal.repaint();
            }
        });
		
		// INFORMACIÓN ORDEN DE COMPRA
		
		JMenuItem CasosDeUsoConsultasInformacionOrdenDeCompra = new JMenuItem("Información Orden de Compra");
		CasosDeUsoConsultas.add(CasosDeUsoConsultasInformacionOrdenDeCompra);
		CasosDeUsoConsultasInformacionOrdenDeCompra.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	infoOrdenInternalFrame.cargarOrdenesDeCompra();
                menuPrincipal.getContentPane().add(infoOrdenInternalFrame);
                infoOrdenInternalFrame.setVisible(true);
                infoOrdenInternalFrame.setLocation(0, 0);  // Ajustar la posición del InternalFrame
                menuPrincipal.revalidate();
                menuPrincipal.repaint();
            }
        });
		
		JMenu CasosDeUsoModificaciones = new JMenu("Modificaciones");
		CasosDeUsoMainMenu.add(CasosDeUsoModificaciones);
		
		// MODIFICAR PRODUCTO
		
		JMenuItem CasosDeUsoModificacionesProducto = new JMenuItem("Producto");
		CasosDeUsoModificaciones.add(CasosDeUsoModificacionesProducto);
		CasosDeUsoModificacionesProducto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	modificarProductoInternalFrame.cargarJTree();
            	modificarProductoInternalFrame.limpiarListaProductos();
                menuPrincipal.getContentPane().add(modificarProductoInternalFrame);
                modificarProductoInternalFrame.setVisible(true);
                modificarProductoInternalFrame.setLocation(0, 0);  // Ajustar la posición del InternalFrame
                menuPrincipal.revalidate();
                menuPrincipal.repaint();
            }
        });
		
		JMenu CasosDeUsoSupresiones = new JMenu("Supresiones");
		CasosDeUsoMainMenu.add(CasosDeUsoSupresiones);
		
		// ELIMINAR ORDEN DE COMPRA
		
		JMenuItem CasosDeUsoSupresionesOrdenDeCompra = new JMenuItem("Orden de Compra");
		CasosDeUsoSupresiones.add(CasosDeUsoSupresionesOrdenDeCompra);
		CasosDeUsoSupresionesOrdenDeCompra.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuPrincipal.getContentPane().add(cancelarOrdenInternalFrame);
                cancelarOrdenInternalFrame.setVisible(true);
                cancelarOrdenInternalFrame.setLocation(0, 0);  // Ajustar la posición del InternalFrame
                menuPrincipal.revalidate();
                menuPrincipal.repaint();
            }
        });
	}

}
