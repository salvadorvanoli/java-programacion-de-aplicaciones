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

public class VerInformacionCliente extends JInternalFrame {
	
	private ISistema sistema;
	private JComboBox<DTCliente> seleccionCliente;
	private JTextArea txtMostrarInfoCliente;
	private JButton btnVerInfoOrdenes;
	
	public JButton getBtnVerInfoOrdenes() {
		return this.btnVerInfoOrdenes;
	}

	private static final long serialVersionUID = 1L;

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
	public VerInformacionCliente(ISistema sistema) {
		
		this.sistema = sistema;
		
		setFrameIcon(new ImageIcon(VerInformacionCliente.class.getResource("/Images/Flamin-Go.png")));
		setClosable(true);
		setTitle("Flamin-Go");
		setBounds(100, 100, 461, 349);
		getContentPane().setLayout(null);
		
		JLabel labelClientesSistema = new JLabel("Selecciona uno de los clientes del sistema especificados debajo *");
		labelClientesSistema.setBounds(41, 11, 309, 28);
		getContentPane().add(labelClientesSistema);
		
		JComboBox<DTCliente> seleccionCliente = new JComboBox<DTCliente>();
		seleccionCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DTCliente seleccionado = (DTCliente) seleccionCliente.getSelectedItem();
                if (seleccionado != null) {
                	String textoSeleccion = seleccionado.toString();
                    String nickname = textoSeleccion.split(" - ")[0].split(": ")[1];
                    nickname = nickname.strip();
                    try {
                        sistema.elegirCliente((String) nickname);
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
		seleccionCliente.setBounds(41, 50, 352, 22);
		getContentPane().add(seleccionCliente);
		
		this.seleccionCliente = seleccionCliente;
		
		JTextArea txtMostrarInfoCliente = new JTextArea();
		txtMostrarInfoCliente.setText("Aquí se mostrará la información del\r\ncliente elegido.");
		txtMostrarInfoCliente.setBounds(41, 83, 352, 152);
		getContentPane().add(txtMostrarInfoCliente);
		
		this.txtMostrarInfoCliente = txtMostrarInfoCliente;
		
		JButton btnVerInfoOrdenes = new JButton("Ver Ordenes de Compra");
		btnVerInfoOrdenes.setBounds(133, 264, 177, 23);
		getContentPane().add(btnVerInfoOrdenes);
		
		this.btnVerInfoOrdenes = btnVerInfoOrdenes;

	}
	
	public List<DTCliente> getClientes(){
		
		if (this.sistema == null) {
			// tiro el error
			throw new NullPointerException ("Error: El sistema no existe.");
		}
		List<DTCliente> lista = null;
		
		try {
			lista = this.sistema.listarClientes();
		} catch (IllegalArgumentException e) {
			throw new IllegalStateException (e.getMessage()); // FALTA POPUP DE ERROR
		}
		
		if (lista.isEmpty()) {
			this.btnVerInfoOrdenes.setEnabled(false);
			throw new IllegalStateException ("Error: El sistema no tiene clientes.");
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
