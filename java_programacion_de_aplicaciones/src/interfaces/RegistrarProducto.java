package interfaces;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;

import clases.ISistema;

public class RegistrarProducto extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistrarProducto frame = new RegistrarProducto();
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
	public RegistrarProducto(ISistema sistema) {
		getContentPane().setBackground(new Color(240, 240, 240));
		setClosable(true);
		setBackground(new Color(255, 192, 203));
		setFrameIcon(new ImageIcon(RegistrarProducto.class.getResource("/Images/Flamin-Go.png")));
		setTitle("Flamin-Go\r\n");
		setBounds(100, 100, 294, 250);
		getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(42, 40, 86, 20);
		getContentPane().add(textField);
		
		JLabel TextoNombre = new JLabel("Nombre");
		TextoNombre.setBounds(49, 25, 46, 14);
		getContentPane().add(TextoNombre);
		
		JLabel TextoEspecificacion = new JLabel("Especificación");
		TextoEspecificacion.setBounds(157, 25, 71, 14);
		getContentPane().add(TextoEspecificacion);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(150, 40, 86, 20);
		getContentPane().add(textField_1);
		
		JTextArea CampoDescripcion = new JTextArea();
		CampoDescripcion.setBounds(42, 85, 194, 43);
		getContentPane().add(CampoDescripcion);
		
		JLabel TextoDescripcion = new JLabel("Descripción");
		TextoDescripcion.setBounds(42, 71, 54, 14);
		getContentPane().add(TextoDescripcion);
		
		JLabel TextoPrecio = new JLabel("Precio");
		TextoPrecio.setBounds(42, 139, 29, 14);
		getContentPane().add(TextoPrecio);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(42, 153, 86, 20);
		getContentPane().add(textField_2);
		
		JLabel TextoImagen = new JLabel("Imagen");
		TextoImagen.setBounds(157, 139, 46, 14);
		getContentPane().add(TextoImagen);
		
		JButton BotonSeleccionImagen = new JButton("Seleccionar...");
		BotonSeleccionImagen.setBounds(152, 152, 84, 23);
		getContentPane().add(BotonSeleccionImagen);
		
		JButton BotonRegistrar = new JButton("Registrar");
		BotonRegistrar.setBounds(84, 184, 104, 23);
		getContentPane().add(BotonRegistrar);
		
		JLabel lblNewLabel = new JLabel("Registrar Producto");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(0, 0, 278, 29);
		getContentPane().add(lblNewLabel);

	}
}
