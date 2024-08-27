package interfaces;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextArea;

import clases.DTCliente;
import clases.ISistema;

import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.util.List;

public class VerInformacionCliente extends JInternalFrame {
	
	private ISistema sistema;

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
		setBounds(100, 100, 461, 537);
		getContentPane().setLayout(null);
		
		JLabel labelClientesSistema = new JLabel("Selecciona uno de los clientes del sistema especificados debajo *");
		labelClientesSistema.setBounds(41, 11, 309, 28);
		getContentPane().add(labelClientesSistema);
		
		JComboBox<DTCliente> seleccionCliente = new JComboBox<DTCliente>();
		seleccionCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seleccionCliente.get
			}
		});
		seleccionCliente.setBounds(41, 50, 352, 22);
		getContentPane().add(seleccionCliente);
		
		JTextArea txtMostrarInfoCliente = new JTextArea();
		txtMostrarInfoCliente.setText("Aquí se mostrará la información del\r\ncliente elegido.");
		txtMostrarInfoCliente.setBounds(41, 83, 352, 152);
		getContentPane().add(txtMostrarInfoCliente);
		
		JLabel labelOrdenesDeCompra1 = new JLabel("Selecciona una de las ordenes de compra del cliente");
		labelOrdenesDeCompra1.setBounds(41, 254, 349, 28);
		getContentPane().add(labelOrdenesDeCompra1);
		
		JLabel labelOrdenesDeCompra2 = new JLabel("especificado para inspeccionarla");
		labelOrdenesDeCompra2.setBounds(41, 273, 197, 22);
		getContentPane().add(labelOrdenesDeCompra2);
		
		JComboBox seleccionOrdenDeCompra = new JComboBox();
		seleccionOrdenDeCompra.setBounds(41, 305, 349, 22);
		getContentPane().add(seleccionOrdenDeCompra);
		
		JTextArea txtMostrarInfoOrdenDeCompra = new JTextArea();
		txtMostrarInfoOrdenDeCompra.setText("Aquí se mostrará la información de la\r\norden de compra elegida.");
		txtMostrarInfoOrdenDeCompra.setBounds(41, 338, 349, 152);
		getContentPane().add(txtMostrarInfoOrdenDeCompra);

	}
	
	public List<DTCliente> getClientes(){
		if (sistema == null) {
			// tiro el error
		}
		List<Cliente> = this.sistema
	}
	
}
