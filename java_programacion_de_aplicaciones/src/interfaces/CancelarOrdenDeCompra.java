package interfaces;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import java.awt.Choice;
import javax.swing.JButton;
import java.awt.TextArea;

public class CancelarOrdenDeCompra extends JInternalFrame {

	private static final long serialVersionUID = 1L;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CancelarOrdenDeCompra frame = new CancelarOrdenDeCompra();
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
	public CancelarOrdenDeCompra() {
		setBounds(100, 100, 590, 268);
		getContentPane().setLayout(null);
		
		JTextPane tituloCancelarOrdenDeCompra = new JTextPane();
		tituloCancelarOrdenDeCompra.setText("Bienvenido a la interfaz de eliminación de órdenes de compra, elija una y seleccione \"Eliminar\"");
		tituloCancelarOrdenDeCompra.setBounds(10, 11, 534, 20);
		getContentPane().add(tituloCancelarOrdenDeCompra);
		
		JLabel labelSelectOrdenCancelarOrdenDeCompra = new JLabel("Seleccione la orden de compra *");
		labelSelectOrdenCancelarOrdenDeCompra.setBounds(27, 53, 162, 14);
		getContentPane().add(labelSelectOrdenCancelarOrdenDeCompra);
		
		Choice selectOrdenCancelarOrdenDeCompra = new Choice();
		selectOrdenCancelarOrdenDeCompra.setBounds(27, 73, 153, 20);
		getContentPane().add(selectOrdenCancelarOrdenDeCompra);
		
		JButton eliminarOrdenCancelarOrdenDeCompra = new JButton("Eliminar");
		eliminarOrdenCancelarOrdenDeCompra.setBounds(196, 70, 89, 23);
		getContentPane().add(eliminarOrdenCancelarOrdenDeCompra);
		
		TextArea textAreaInfoOrdenDeCompra = new TextArea();
		textAreaInfoOrdenDeCompra.setText("Aquí irá el texto con la info de la orden de compra");
		textAreaInfoOrdenDeCompra.setBounds(308, 53, 249, 120);
		getContentPane().add(textAreaInfoOrdenDeCompra);
		
		JTextPane obligatorioCancelarOrdenDeCompra = new JTextPane();
		obligatorioCancelarOrdenDeCompra.setText("Los elementos marcados con * son obligatorios");
		obligatorioCancelarOrdenDeCompra.setBounds(10, 130, 231, 20);
		getContentPane().add(obligatorioCancelarOrdenDeCompra);
		
		JButton cancelarCancelarOrdenDeCompra = new JButton("Cancelar");
		cancelarCancelarOrdenDeCompra.setBounds(373, 200, 89, 23);
		getContentPane().add(cancelarCancelarOrdenDeCompra);
		
		JButton aceptarCancelarOrdenDeCompra = new JButton("Aceptar");
		aceptarCancelarOrdenDeCompra.setBounds(472, 200, 89, 23);
		getContentPane().add(aceptarCancelarOrdenDeCompra);

	}

}
