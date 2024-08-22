package interfaces;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JButton;

public class RegistrarProducto extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
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

	/**
	 * Create the frame.
	 */
	public RegistrarProducto() {
		setBackground(new Color(255, 192, 203));
		setFrameIcon(new ImageIcon("C:\\Users\\felip\\Downloads\\Diseño sin título (1).png"));
		setTitle("Registrar Producto");
		setBounds(100, 100, 222, 235);
		getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(10, 26, 86, 20);
		getContentPane().add(textField);
		
		JLabel TextoNombre = new JLabel("Nombre");
		TextoNombre.setBounds(17, 11, 46, 14);
		getContentPane().add(TextoNombre);
		
		JLabel TextoEspecificacion = new JLabel("Especificación");
		TextoEspecificacion.setBounds(117, 11, 71, 14);
		getContentPane().add(TextoEspecificacion);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(110, 26, 86, 20);
		getContentPane().add(textField_1);
		
		JTextArea CampoDescripcion = new JTextArea();
		CampoDescripcion.setBounds(10, 70, 186, 43);
		getContentPane().add(CampoDescripcion);
		
		JLabel TextoDescripcion = new JLabel("Descripción");
		TextoDescripcion.setBounds(10, 56, 54, 14);
		getContentPane().add(TextoDescripcion);
		
		JLabel TextoPrecio = new JLabel("Precio");
		TextoPrecio.setBounds(10, 126, 29, 14);
		getContentPane().add(TextoPrecio);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(10, 140, 86, 20);
		getContentPane().add(textField_2);
		
		JLabel TextoImagen = new JLabel("Imagen");
		TextoImagen.setBounds(110, 126, 46, 14);
		getContentPane().add(TextoImagen);
		
		JButton BotonSeleccionImagen = new JButton("Seleccionar...");
		BotonSeleccionImagen.setBounds(110, 139, 89, 23);
		getContentPane().add(BotonSeleccionImagen);
		
		JButton BotonRegistrar = new JButton("Registrar");
		BotonRegistrar.setBounds(52, 171, 104, 23);
		getContentPane().add(BotonRegistrar);

	}
}
