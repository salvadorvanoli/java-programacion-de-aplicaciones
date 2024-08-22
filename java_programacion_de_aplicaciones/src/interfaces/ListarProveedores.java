package interfaces;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.ImageIcon;

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
		setTitle("Elija un Proveedor");
		setFrameIcon(new ImageIcon("C:\\Users\\felip\\Downloads\\Diseño sin título (1).png"));
		getContentPane().setBackground(new Color(255, 192, 203));
		setBounds(100, 100, 142, 160);
		getContentPane().setLayout(null);
		
		JLabel TextoProveedor = new JLabel("Eleccion:");
		TextoProveedor.setHorizontalAlignment(SwingConstants.CENTER);
		TextoProveedor.setBounds(16, 11, 91, 14);
		getContentPane().add(TextoProveedor);
		
		JComboBox<Object> comboBox = new JComboBox<Object>();
		comboBox.setBounds(16, 25, 91, 14);
		getContentPane().add(comboBox);
		
		JLabel Nick_1 = new JLabel("Nick");
		Nick_1.setHorizontalAlignment(SwingConstants.CENTER);
		Nick_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		Nick_1.setBounds(0, 45, 127, 28);
		getContentPane().add(Nick_1);
		
		JLabel Email_2 = new JLabel("Email");
		Email_2.setHorizontalAlignment(SwingConstants.CENTER);
		Email_2.setFont(new Font("Tahoma", Font.PLAIN, 11));
		Email_2.setBounds(0, 72, 127, 28);
		getContentPane().add(Email_2);
		
		JButton BotonConfirmar = new JButton("Confirmar");
		BotonConfirmar.setBounds(16, 107, 91, 23);
		getContentPane().add(BotonConfirmar);

	}

}
