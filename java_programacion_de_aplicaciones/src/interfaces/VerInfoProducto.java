package interfaces;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.ImageIcon;

public class VerInfoProducto extends JInternalFrame {

	private static final long serialVersionUID = 1L;

	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VerInfoProducto frame = new VerInfoProducto();
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
	public VerInfoProducto() {
		setFrameIcon(new ImageIcon("C:\\Users\\felip\\Downloads\\Diseño sin título (1).png"));
		setTitle("Flamin-Go");
		setClosable(true);
		setBounds(100, 100, 331, 505);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Seleccione una categoría del sistema");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_3.setBounds(0, 22, 313, 14);
		getContentPane().add(lblNewLabel_3);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(30, 47, 255, 22);
		getContentPane().add(comboBox);
		
		JLabel lblNewLabel_3_1 = new JLabel("Seleccione un producto");
		lblNewLabel_3_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_3_1.setBounds(0, 98, 313, 14);
		getContentPane().add(lblNewLabel_3_1);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(30, 123, 255, 22);
		getContentPane().add(comboBox_1);
		
		JTextArea txtrAquSeMostrarn = new JTextArea();
		txtrAquSeMostrarn.setText("Aquí se mostrarán los datos \r\ndel producto");
		txtrAquSeMostrarn.setBounds(30, 193, 255, 256);
		getContentPane().add(txtrAquSeMostrarn);

	}

}
