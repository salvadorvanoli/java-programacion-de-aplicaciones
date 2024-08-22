package interfaces;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import java.awt.Font;
import javax.swing.SwingConstants;

public class verInformacionCliente extends JInternalFrame {

	private static final long serialVersionUID = 1L;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					verInformacionCliente frame = new verInformacionCliente();
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
	public verInformacionCliente() {
		setClosable(true);
		setTitle("Ver Información de un Cliente");
		setBounds(100, 100, 461, 537);
		getContentPane().setLayout(null);
		
		JLabel labelClientesSistema = new JLabel("Selecciona uno de los clientes del sistema especificados debajo *");
		labelClientesSistema.setHorizontalAlignment(SwingConstants.CENTER);
		labelClientesSistema.setBounds(41, 51, 352, 28);
		getContentPane().add(labelClientesSistema);
		
		JComboBox seleccionCliente = new JComboBox();
		seleccionCliente.setBounds(41, 78, 352, 22);
		getContentPane().add(seleccionCliente);
		
		JTextArea txtMostrarInfoCliente = new JTextArea();
		txtMostrarInfoCliente.setText("Aquí se mostrará la información del\r\ncliente elegido.");
		txtMostrarInfoCliente.setBounds(41, 111, 352, 152);
		getContentPane().add(txtMostrarInfoCliente);
		
		JLabel labelOrdenesDeCompra1 = new JLabel("Selecciona una de las ordenes de compra del cliente");
		labelOrdenesDeCompra1.setHorizontalAlignment(SwingConstants.CENTER);
		labelOrdenesDeCompra1.setBounds(41, 284, 352, 28);
		getContentPane().add(labelOrdenesDeCompra1);
		
		JLabel labelOrdenesDeCompra2 = new JLabel("especificado para inspeccionarla");
		labelOrdenesDeCompra2.setHorizontalAlignment(SwingConstants.CENTER);
		labelOrdenesDeCompra2.setBounds(41, 303, 352, 22);
		getContentPane().add(labelOrdenesDeCompra2);
		
		JComboBox seleccionOrdenDeCompra = new JComboBox();
		seleccionOrdenDeCompra.setBounds(41, 326, 352, 22);
		getContentPane().add(seleccionOrdenDeCompra);
		
		JTextArea txtMostrarInfoOrdenDeCompra = new JTextArea();
		txtMostrarInfoOrdenDeCompra.setText("Aquí se mostrará la información de la\r\norden de compra elegida.");
		txtMostrarInfoOrdenDeCompra.setBounds(41, 359, 352, 131);
		getContentPane().add(txtMostrarInfoOrdenDeCompra);
		
		JLabel lblVerInformacinDe = new JLabel("Ver Información de un Cliente");
		lblVerInformacinDe.setHorizontalAlignment(SwingConstants.CENTER);
		lblVerInformacinDe.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblVerInformacinDe.setBounds(41, 11, 352, 29);
		getContentPane().add(lblVerInformacinDe);

	}
}
