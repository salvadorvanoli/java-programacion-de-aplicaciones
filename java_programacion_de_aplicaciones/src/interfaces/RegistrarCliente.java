package interfaces;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.ImageIcon;
import com.toedter.calendar.JDateChooser;

public class RegistrarCliente extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistrarCliente frame = new RegistrarCliente();
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
	 */
	public RegistrarCliente() {
		setFrameIcon(new ImageIcon("C:\\Users\\felip\\Downloads\\Diseño sin título (1).png"));
		setTitle("Flamin-Go");
		setClosable(true);
		setBounds(100, 100, 385, 405);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Registrar Cliente");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(0, 11, 369, 29);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nickname");
		lblNewLabel_1.setBounds(38, 54, 48, 14);
		getContentPane().add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(106, 51, 222, 20);
		getContentPane().add(textField);
		
		JLabel lblNewLabel_1_2 = new JLabel("Correo Electrónico");
		lblNewLabel_1_2.setBounds(38, 98, 89, 14);
		getContentPane().add(lblNewLabel_1_2);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(148, 95, 180, 20);
		getContentPane().add(textField_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Nombre");
		lblNewLabel_1_1.setBounds(38, 143, 48, 14);
		getContentPane().add(lblNewLabel_1_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(96, 140, 232, 20);
		getContentPane().add(textField_2);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Apellido");
		lblNewLabel_1_1_1.setBounds(38, 188, 48, 14);
		getContentPane().add(lblNewLabel_1_1_1);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(96, 185, 232, 20);
		getContentPane().add(textField_3);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Fecha de Nacimiento");
		lblNewLabel_1_2_1.setBounds(38, 233, 102, 14);
		getContentPane().add(lblNewLabel_1_2_1);
		
		JButton lblNewLabel_2 = new JButton("Asignar una imagen");
		lblNewLabel_2.setBounds(38, 319, 144, 20);
		getContentPane().add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("Registrar");
		btnNewButton.setBackground(new Color(250, 214, 235));
		btnNewButton.setBounds(255, 335, 89, 23);
		getContentPane().add(btnNewButton);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(38, 258, 144, 20);
		getContentPane().add(dateChooser);

	}
}
