package interfaces;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTextArea;

import clases.DTCliente;
import clases.DTClienteDetallado;
import clases.ISistema;
import excepciones.OrdenDeCompraNoExisteException;
import excepciones.UsuarioNoExisteException;

import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;

import java.util.List;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import javax.swing.JTextField;

public class VerInformacionCliente extends JInternalFrame {
	
	private static final long serialVersionUID = 1L;
	private Main menu;
	private ISistema sistema;
	private JComboBox<DTCliente> seleccionCliente;
	private JTextArea txtMostrarInfoCliente;
	private JButton btnVerInfoOrdenes;
	private JTextField textFieldNickname;
	private JTextField textFieldEmail;
	private JTextField textFieldNombre;
	private JTextField textFieldApellido;
	private JTextField textFieldFechaNac;
	private String imagen;
	private JButton btnVerFoto;
	private JInternalFrame vistaFoto;
	
	public JButton getBtnVerInfoOrdenes() {
		return this.btnVerInfoOrdenes;
	}
	
	public void limpiarCampos() {
		this.seleccionCliente.setSelectedIndex(-1);
		this.textFieldNickname.setText("");
		this.textFieldEmail.setText("");
		this.textFieldNombre.setText("");
		this.textFieldApellido.setText("");
		this.textFieldFechaNac.setText("");
		this.imagen = "";
	}

	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VerInformacionCliente frame = new VerInformacionCliente();
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
	public VerInformacionCliente(ISistema sistema, Main menu) {
		
		this.sistema = sistema;
		this.menu = menu;
		
		ImageIcon icon = new ImageIcon(AltaDeCategoria.class.getResource("/Images/Flamin-Go.png"));
		Image img = icon.getImage().getScaledInstance(16, 16, Image.SCALE_SMOOTH);
		setFrameIcon(new ImageIcon(img));
		
		setClosable(true);
		setTitle("Flamin-Go");
		setBounds(100, 100, 526, 366);
		getContentPane().setLayout(null);
		
		JLabel labelClientesSistema = new JLabel("Selecciona uno de los clientes del sistema especificados debajo *");
		labelClientesSistema.setHorizontalAlignment(SwingConstants.CENTER);
		labelClientesSistema.setBounds(10, 48, 490, 28);
		getContentPane().add(labelClientesSistema);
		
		JComboBox<DTCliente> seleccionCliente = new JComboBox<DTCliente>();
		seleccionCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DTCliente seleccionado = (DTCliente) seleccionCliente.getSelectedItem();
                if (seleccionado != null) {
                    String nickname = seleccionado.getNickname();
                    try {
                        sistema.elegirCliente(nickname);
                        DTClienteDetallado informacionDetalladaCliente = sistema.verInformacionCliente();
                        textFieldNickname.setText(nickname);
                        textFieldEmail.setText(informacionDetalladaCliente.getEmail());
                        textFieldNombre.setText(informacionDetalladaCliente.getNombre());
                        textFieldApellido.setText(informacionDetalladaCliente.getApellido());
                        textFieldFechaNac.setText(informacionDetalladaCliente.getFechaNac().toString());
                        imagen = informacionDetalladaCliente.getFoto();
                        if (menu.getInfoOrdenInternalFrame() != null && menu.getInfoOrdenInternalFrame().isVisible()) {
                        	menu.getInfoOrdenInternalFrame().cargarOrdenesDeCompra();
                        }
                    } catch (UsuarioNoExisteException e1) {
                        // CREAR UNA VENTANA DE ERROR
                    }
                } else {
                    // CREAR UNA VENTANA DE ERROR
                }
			}
		});
		seleccionCliente.setBounds(10, 87, 490, 22);
		getContentPane().add(seleccionCliente);
		
		this.seleccionCliente = seleccionCliente;
		
		JButton btnVerInfoOrdenes = new JButton("Ver Ordenes de Compra");
		btnVerInfoOrdenes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (sistema.listarOrdenesDeCompra() != null) {
					// infoClienteInternalFrame.toBack();
					menu.getInfoOrdenInternalFrame().cargarOrdenesDeCompra();
					menu.getMenuPrincipal().getContentPane().add(menu.getInfoOrdenInternalFrame());
					// infoOrdenInternalFrame.toFront(); // Traigo el internal frame al frente
					menu.getInfoOrdenInternalFrame().setVisible(true);
					menu.getInfoOrdenInternalFrame().setLocation(0, 0);  // Ajustar la posición del InternalFrame
					menu.getMenuPrincipal().revalidate();
					menu.getMenuPrincipal().repaint();
				}
			}
		});
		btnVerInfoOrdenes.setBounds(166, 283, 177, 23);
		getContentPane().add(btnVerInfoOrdenes);
		
		this.btnVerInfoOrdenes = btnVerInfoOrdenes;
		
		JLabel lblVerInfoCliente = new JLabel("Ver información de un Cliente");
		lblVerInfoCliente.setHorizontalAlignment(SwingConstants.CENTER);
		lblVerInfoCliente.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblVerInfoCliente.setBounds(10, 11, 490, 29);
		getContentPane().add(lblVerInfoCliente);
		
		JLabel lblNickname = new JLabel("Nickname");
		lblNickname.setBounds(20, 138, 81, 21);
		getContentPane().add(lblNickname);
		
		JTextField textFieldNickname = new JTextField();
		textFieldNickname.setBounds(106, 139, 129, 20);
		getContentPane().add(textFieldNickname);
		textFieldNickname.setColumns(10);
		
		this.textFieldNickname = textFieldNickname;
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(20, 179, 81, 21);
		getContentPane().add(lblEmail);
		
		JTextField textFieldEmail = new JTextField();
		textFieldEmail.setColumns(10);
		textFieldEmail.setBounds(106, 180, 129, 20);
		getContentPane().add(textFieldEmail);
		
		this.textFieldEmail = textFieldEmail;
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(273, 138, 81, 21);
		getContentPane().add(lblNombre);
		
		JTextField textFieldNombre = new JTextField();
		textFieldNombre.setColumns(10);
		textFieldNombre.setBounds(359, 139, 129, 20);
		getContentPane().add(textFieldNombre);
		
		this.textFieldNombre = textFieldNombre;
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setBounds(273, 179, 81, 21);
		getContentPane().add(lblApellido);
		
		JTextField textFieldApellido = new JTextField();
		textFieldApellido.setColumns(10);
		textFieldApellido.setBounds(359, 180, 129, 20);
		getContentPane().add(textFieldApellido);
		
		this.textFieldApellido = textFieldApellido;
		
		JLabel lblFechaNac = new JLabel("Fecha nac.");
		lblFechaNac.setBounds(20, 221, 81, 21);
		getContentPane().add(lblFechaNac);
		
		JTextField textFieldFechaNac = new JTextField();
		textFieldFechaNac.setColumns(10);
		textFieldFechaNac.setBounds(106, 222, 129, 20);
		getContentPane().add(textFieldFechaNac);
		
		this.textFieldFechaNac = textFieldFechaNac;
		
		JButton btnVerFoto = new JButton("Ver foto");
		btnVerFoto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if ( imagen != null && (! imagen.isBlank()) && ! (imagen.isEmpty())) {

			        // Cargar y agregar la imagen al panel
		            File archivoImagen = new File(imagen);
		            if (archivoImagen.exists()) {
		            	
		            	// Crear el JInternalFrame
						vistaFoto = new JInternalFrame("Flamin-Go", true, true, true, true);
						vistaFoto.setFrameIcon(new ImageIcon(ModificarDatosProducto.class.getResource("/Images/Flamin-Go.png")));
						vistaFoto.setSize(600, 400);
						vistaFoto.getContentPane().setLayout(new BorderLayout());
						
				        // Crear un JPanel para contener las imágenes
				        JPanel panelImagenes = new JPanel();
				        panelImagenes.setLayout(new FlowLayout());
		            	
		                ImageIcon icono = new ImageIcon(imagen);
		                JLabel etiquetaImagen = new JLabel(icono);
		                panelImagenes.add(etiquetaImagen);
		                
		                // Añadir el panel al JInternalFrame
				        JScrollPane scrollPane = new JScrollPane(panelImagenes);
				        vistaFoto.getContentPane().add(scrollPane, BorderLayout.CENTER);

				        // Añadir el JInternalFrame al JDesktopPane
				        menu.getMenuPrincipal().getContentPane().add(vistaFoto);
				        vistaFoto.setVisible(true);
		            } else {
    		            JOptionPane.showMessageDialog(null, "Archivo no encontrado: " + imagen, "Error", JOptionPane.ERROR_MESSAGE);
		            }
				} else {
	            	JOptionPane.showMessageDialog(null, "El cliente actual no tiene foto de perfil", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnVerFoto.setBounds(329, 218, 103, 28);
		getContentPane().add(btnVerFoto);
		
		this.btnVerFoto = btnVerFoto;

	}
	
	public List<DTCliente> getClientes(){
		
		if (this.sistema == null) {
			// tiro el error
			throw new NullPointerException ("Error: El sistema no existe."); // FALTA POPUP
		}
		List<DTCliente> lista = null;
		
		try {
			lista = this.sistema.listarClientes();
		} catch (IllegalArgumentException e) {
			throw new IllegalStateException (e.getMessage()); // FALTA POPUP DE ERROR
		}
		
		if (lista.isEmpty()) {
			throw new IllegalStateException ("Error: El sistema no tiene clientes."); // FALTA POPUP
		}
		
		return lista;
		
	}

	public void cargarClientes() {
		List<DTCliente> lista = null;
		
		try {
			lista = this.getClientes();
		} catch (IllegalArgumentException e) {
			throw new IllegalStateException (e.getMessage()); // FALTA POPUP DE ERROR
		}
		
		this.seleccionCliente.removeAllItems();
		
		for (DTCliente cli : lista) {
			this.seleccionCliente.addItem(cli);
		}
		
	}
}
