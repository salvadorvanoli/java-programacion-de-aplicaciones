package interfaces;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTextArea;

import clases.DTCliente;

import clases.ISistema;
import excepciones.OrdenDeCompraNoExisteException;
import excepciones.UsuarioNoExisteException;

import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.util.List;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;

public class VerInformacionCliente extends JInternalFrame {
	
	private ISistema sistema;
	private JComboBox<DTCliente> seleccionCliente;
	private JTextArea txtMostrarInfoCliente;
	private JButton btnVerInfoOrdenes;
	private Main menu;
	
	public JButton getBtnVerInfoOrdenes() {
		return this.btnVerInfoOrdenes;
	}

	private static final long serialVersionUID = 1L;
	private JTextField textFieldNickname;
	private JTextField textFieldEmail;
	private JTextField textFieldNombre;
	private JTextField textFieldApellido;
	private JTextField textFieldFechaNac;

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
		
		setFrameIcon(new ImageIcon(VerInformacionCliente.class.getResource("/Images/Flamin-Go.png")));
		setClosable(true);
		setTitle("Flamin-Go");
		setBounds(100, 100, 526, 619);
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
                        String informacionDetalladaCliente = sistema.verInformacionCliente().toString();
                        txtMostrarInfoCliente.setText(informacionDetalladaCliente);
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
		
		JTextArea txtMostrarInfoCliente = new JTextArea();
		txtMostrarInfoCliente.setText("Aquí se mostrará la información del\r\ncliente elegido.");
		txtMostrarInfoCliente.setBounds(43, 120, 435, 152);
		getContentPane().add(txtMostrarInfoCliente);
		
		this.txtMostrarInfoCliente = txtMostrarInfoCliente;
		
		JButton btnVerInfoOrdenes = new JButton("Ver Ordenes de Compra");
		btnVerInfoOrdenes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// infoClienteInternalFrame.toBack();
				menu.getMenuPrincipal().getContentPane().add(menu.getInfoOrdenInternalFrame());
				// infoOrdenInternalFrame.toFront(); // Traigo el internal frame al frente
				menu.getInfoOrdenInternalFrame().setVisible(true);
				menu.getInfoOrdenInternalFrame().setLocation(0, 0);  // Ajustar la posición del InternalFrame
				menu.getMenuPrincipal().revalidate();
				menu.getMenuPrincipal().repaint();
			}
		});
		btnVerInfoOrdenes.setBounds(167, 529, 177, 23);
		getContentPane().add(btnVerInfoOrdenes);
		
		this.btnVerInfoOrdenes = btnVerInfoOrdenes;
		
		JLabel lblVerInfoCliente = new JLabel("Ver información de un Cliente");
		lblVerInfoCliente.setHorizontalAlignment(SwingConstants.CENTER);
		lblVerInfoCliente.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblVerInfoCliente.setBounds(10, 11, 490, 29);
		getContentPane().add(lblVerInfoCliente);
		
		JLabel lblNickname = new JLabel("Nickname");
		lblNickname.setBounds(10, 295, 81, 21);
		getContentPane().add(lblNickname);
		
		textFieldNickname = new JTextField();
		textFieldNickname.setBounds(96, 296, 129, 20);
		getContentPane().add(textFieldNickname);
		textFieldNickname.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(10, 336, 81, 21);
		getContentPane().add(lblEmail);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setColumns(10);
		textFieldEmail.setBounds(96, 337, 129, 20);
		getContentPane().add(textFieldEmail);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(263, 295, 81, 21);
		getContentPane().add(lblNombre);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setColumns(10);
		textFieldNombre.setBounds(349, 296, 129, 20);
		getContentPane().add(textFieldNombre);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setBounds(263, 336, 81, 21);
		getContentPane().add(lblApellido);
		
		textFieldApellido = new JTextField();
		textFieldApellido.setColumns(10);
		textFieldApellido.setBounds(349, 337, 129, 20);
		getContentPane().add(textFieldApellido);
		
		JLabel lblFechaNac = new JLabel("Fecha nac.");
		lblFechaNac.setBounds(10, 378, 81, 21);
		getContentPane().add(lblFechaNac);
		
		textFieldFechaNac = new JTextField();
		textFieldFechaNac.setColumns(10);
		textFieldFechaNac.setBounds(96, 379, 129, 20);
		getContentPane().add(textFieldFechaNac);
		
		JButton btnVerFoto = new JButton("Ver foto");
		btnVerFoto.setBounds(319, 375, 103, 28);
		getContentPane().add(btnVerFoto);

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
