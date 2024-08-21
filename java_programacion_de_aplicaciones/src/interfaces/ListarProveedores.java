package interfaces;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Rectangle;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import java.awt.Color;

public class ListarProveedores extends JInternalFrame {

	private static final long serialVersionUID = 1L;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListarProveedores frame = new ListarProveedores();
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
	public ListarProveedores() {
		setBackground(new Color(255, 192, 203));
		setFrameIcon(new ImageIcon("C:\\Users\\felip\\Downloads\\Diseño sin título (1).png"));
		setSize(new Dimension(286, 300));
		setBounds(new Rectangle(0, 0, 160, 183));
		setTitle("Elija un Proveedor");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Elija un proveedor");
		lblNewLabel.setBounds(154, 55, 91, 14);
		getContentPane().add(lblNewLabel);
		
		JComboBox<?> comboBox = new JComboBox<Object>();
		comboBox.setBounds(154, 80, 91, 14);
		getContentPane().add(comboBox);
		
		JLabel Nick_1 = new JLabel("Nick");
		Nick_1.setHorizontalAlignment(SwingConstants.CENTER);
		Nick_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		Nick_1.setBounds(138, 100, 127, 28);
		getContentPane().add(Nick_1);
		
		JLabel Email_2 = new JLabel("Email");
		Email_2.setHorizontalAlignment(SwingConstants.CENTER);
		Email_2.setFont(new Font("Tahoma", Font.PLAIN, 11));
		Email_2.setBounds(138, 127, 127, 28);
		getContentPane().add(Email_2);
		
		JButton BotonConfirmar = new JButton("Confirmar");
		BotonConfirmar.setBounds(154, 162, 91, 23);
		getContentPane().add(BotonConfirmar);

	}
}
