package interfaces;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import java.awt.Choice;
import javax.swing.JButton;

public class AltaDeCategoria extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AltaDeCategoria frame = new AltaDeCategoria();
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
	public AltaDeCategoria() {
		setBounds(100, 100, 590, 290);
		getContentPane().setLayout(null);
		
		JTextPane tituloAltaDeCategoria = new JTextPane();
		tituloAltaDeCategoria.setText("Bienvenido a la interfaz de creación de una categoría, rellene el formulario e ingrese \"Aceptar\" para continuar.");
		tituloAltaDeCategoria.setBounds(10, 11, 535, 20);
		getContentPane().add(tituloAltaDeCategoria);
		
		JLabel labelNombreCategoriaAltaDeCategoria = new JLabel("Nombre de la categoría *");
		labelNombreCategoriaAltaDeCategoria.setBounds(30, 42, 128, 14);
		getContentPane().add(labelNombreCategoriaAltaDeCategoria);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(30, 67, 147, 20);
		getContentPane().add(textField);
		
		JCheckBox contieneProductosCheckbox = new JCheckBox("Contiene productos");
		contieneProductosCheckbox.setBounds(30, 94, 119, 23);
		getContentPane().add(contieneProductosCheckbox);
		
		JLabel labelSelectDeCategoriaAltaDeCategoria = new JLabel("Seleccione una categoría a la que pertenezca");
		labelSelectDeCategoriaAltaDeCategoria.setBounds(31, 132, 244, 14);
		getContentPane().add(labelSelectDeCategoriaAltaDeCategoria);
		
		Choice selectCategoriaPadreAltaDeCategoria = new Choice();
		selectCategoriaPadreAltaDeCategoria.setBounds(30, 158, 147, 20);
		getContentPane().add(selectCategoriaPadreAltaDeCategoria);
		
		JTextPane obligatorioAltaDeCategoria = new JTextPane();
		obligatorioAltaDeCategoria.setText("Los elementos marcados con * son obligatorios");
		obligatorioAltaDeCategoria.setBounds(10, 194, 231, 20);
		getContentPane().add(obligatorioAltaDeCategoria);
		
		JButton cancelarAltaDeCategoria = new JButton("Cancelar");
		cancelarAltaDeCategoria.setBounds(373, 226, 89, 23);
		getContentPane().add(cancelarAltaDeCategoria);
		
		JButton aceptarAltaDeCategoria = new JButton("Aceptar");
		aceptarAltaDeCategoria.setBounds(472, 226, 89, 23);
		getContentPane().add(aceptarAltaDeCategoria);

	}
}
