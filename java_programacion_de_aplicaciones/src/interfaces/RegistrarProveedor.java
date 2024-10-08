package interfaces;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

import clases.ISistema;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.ImageIcon;
import com.toedter.calendar.JDateChooser;

public class RegistrarProveedor extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistrarProveedor frame = new RegistrarProveedor();
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
	public RegistrarProveedor(ISistema sistema) {
		setFrameIcon(new ImageIcon(RegistrarProveedor.class.getResource("/Images/Flamin-Go.png")));
		setTitle("Flamin-Go");
		setClosable(true);
		setBounds(100, 100, 385, 491);
		getContentPane().setLayout(null);
		
		JLabel lblRegistrarProovedor = new JLabel("Registrar Proveedor");
		lblRegistrarProovedor.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegistrarProovedor.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblRegistrarProovedor.setBounds(0, 11, 369, 29);
		getContentPane().add(lblRegistrarProovedor);
		
		JLabel lblNewLabel_1_3 = new JLabel("Nickname");
		lblNewLabel_1_3.setBounds(38, 54, 48, 14);
		getContentPane().add(lblNewLabel_1_3);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(106, 51, 222, 20);
		getContentPane().add(textField);
		
		JLabel lblNewLabel_1_2_2 = new JLabel("Correo Electrónico");
		lblNewLabel_1_2_2.setBounds(38, 98, 89, 14);
		getContentPane().add(lblNewLabel_1_2_2);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(148, 95, 180, 20);
		getContentPane().add(textField_1);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Nombre");
		lblNewLabel_1_1_2.setBounds(38, 143, 48, 14);
		getContentPane().add(lblNewLabel_1_1_2);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(96, 140, 232, 20);
		getContentPane().add(textField_2);
		
		JLabel lblNewLabel_1_1_1_3 = new JLabel("Apellido");
		lblNewLabel_1_1_1_3.setBounds(38, 188, 48, 14);
		getContentPane().add(lblNewLabel_1_1_1_3);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(96, 185, 232, 20);
		getContentPane().add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(172, 224, 156, 20);
		getContentPane().add(textField_4);
		
		JLabel lblNewLabel_1_1_2_1 = new JLabel("Nombre de la Compañía");
		lblNewLabel_1_1_2_1.setBounds(38, 227, 118, 14);
		getContentPane().add(lblNewLabel_1_1_2_1);
		
		JLabel lblNewLabel_1_1_1_3_1 = new JLabel("Link Web");
		lblNewLabel_1_1_1_3_1.setBounds(38, 272, 48, 14);
		getContentPane().add(lblNewLabel_1_1_1_3_1);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(96, 269, 232, 20);
		getContentPane().add(textField_5);
		
		JLabel lblNewLabel_1_2_1_2 = new JLabel("Fecha de Nacimiento");
		lblNewLabel_1_2_1_2.setBounds(38, 312, 102, 14);
		getContentPane().add(lblNewLabel_1_2_1_2);
		
		JButton lblNewLabel_2_1 = new JButton("Asignar una imagen");
		lblNewLabel_2_1.setBounds(38, 398, 144, 20);
		getContentPane().add(lblNewLabel_2_1);
		
		JButton btnNewButton_1 = new JButton("Registrar");
		btnNewButton_1.setBackground(new Color(250, 214, 235));
		btnNewButton_1.setBounds(256, 422, 89, 23);
		getContentPane().add(btnNewButton_1);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(38, 337, 144, 20);
		getContentPane().add(dateChooser);

	}
}
