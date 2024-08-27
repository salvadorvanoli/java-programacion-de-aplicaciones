package interfaces;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import java.awt.Choice;
import javax.swing.JButton;
import java.awt.TextArea;
import java.awt.Font;
import javax.swing.SwingConstants;

import clases.ISistema;

import javax.swing.ImageIcon;

public class CancelarOrdenDeCompra extends JInternalFrame {

	private static final long serialVersionUID = 1L;

	/**
	 * Launch the application.
	 */
	/*
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
	*/

	/**
	 * Create the frame.
	 * @param sistema 
	 */
	public CancelarOrdenDeCompra(ISistema sistema) {
		setClosable(true);
		setTitle("Flamin-Go");
		setFrameIcon(new ImageIcon(CancelarOrdenDeCompra.class.getResource("/Images/Flamin-Go.png")));
		setBounds(100, 100, 590, 315);
		getContentPane().setLayout(null);
		
		JTextPane tituloCancelarOrdenDeCompra = new JTextPane();
		tituloCancelarOrdenDeCompra.setText("Bienvenido a la interfaz de eliminación de órdenes de compra, elija una y seleccione \"Eliminar\"");
		tituloCancelarOrdenDeCompra.setBounds(10, 62, 534, 20);
		getContentPane().add(tituloCancelarOrdenDeCompra);
		
		JLabel labelSelectOrdenCancelarOrdenDeCompra = new JLabel("Seleccione la orden de compra *");
		labelSelectOrdenCancelarOrdenDeCompra.setBounds(27, 104, 162, 14);
		getContentPane().add(labelSelectOrdenCancelarOrdenDeCompra);
		
		Choice selectOrdenCancelarOrdenDeCompra = new Choice();
		selectOrdenCancelarOrdenDeCompra.setBounds(27, 124, 153, 20);
		getContentPane().add(selectOrdenCancelarOrdenDeCompra);
		
		JButton eliminarOrdenCancelarOrdenDeCompra = new JButton("Eliminar");
		eliminarOrdenCancelarOrdenDeCompra.setBounds(196, 121, 89, 23);
		getContentPane().add(eliminarOrdenCancelarOrdenDeCompra);
		
		TextArea textAreaInfoOrdenDeCompra = new TextArea();
		textAreaInfoOrdenDeCompra.setText("Aquí irá el texto con la info de la orden de compra");
		textAreaInfoOrdenDeCompra.setBounds(308, 104, 249, 120);
		getContentPane().add(textAreaInfoOrdenDeCompra);
		
		JTextPane obligatorioCancelarOrdenDeCompra = new JTextPane();
		obligatorioCancelarOrdenDeCompra.setText("Los elementos marcados con * son obligatorios");
		obligatorioCancelarOrdenDeCompra.setBounds(10, 181, 231, 20);
		getContentPane().add(obligatorioCancelarOrdenDeCompra);
		
		JButton cancelarCancelarOrdenDeCompra = new JButton("Cancelar");
		cancelarCancelarOrdenDeCompra.setBounds(373, 251, 89, 23);
		getContentPane().add(cancelarCancelarOrdenDeCompra);
		
		JButton aceptarCancelarOrdenDeCompra = new JButton("Aceptar");
		aceptarCancelarOrdenDeCompra.setBounds(472, 251, 89, 23);
		getContentPane().add(aceptarCancelarOrdenDeCompra);
		
		JLabel tituloPrincipalEliminarOrdenDeCompra = new JLabel("Eliminar Orden de Compra");
		tituloPrincipalEliminarOrdenDeCompra.setHorizontalAlignment(SwingConstants.CENTER);
		tituloPrincipalEliminarOrdenDeCompra.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tituloPrincipalEliminarOrdenDeCompra.setBounds(183, 23, 199, 23);
		getContentPane().add(tituloPrincipalEliminarOrdenDeCompra);

	}

}
