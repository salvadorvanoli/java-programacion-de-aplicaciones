package interfaces;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import java.awt.Font;
import javax.swing.SwingConstants;

import clases.ISistema;

import javax.swing.JButton;
import java.awt.Color;
import javax.swing.ImageIcon;

public class ListarProveedores extends JInternalFrame {

	private static final long serialVersionUID = 1L;

	/**
	 * Launch the application.
	 */
	/*
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
	*/

	/**
	 * Create the frame.
	 * @param sistema 
	 */
	public ListarProveedores(ISistema sistema) {
		setClosable(true);
		setTitle("Flamin-Go");
		setFrameIcon(new ImageIcon(ListarProveedores.class.getResource("/Images/Flamin-Go.png")));
		getContentPane().setBackground(new Color(255, 192, 203));
		setBounds(100, 100, 186, 160);
		getContentPane().setLayout(null);
		
		JLabel TextoProveedor = new JLabel("Elija un Proveedor\r\n");
		TextoProveedor.setFont(new Font("Tahoma", Font.PLAIN, 16));
		TextoProveedor.setHorizontalAlignment(SwingConstants.CENTER);
		TextoProveedor.setBounds(0, 11, 178, 14);
		getContentPane().add(TextoProveedor);
		
		JComboBox<Object> comboBox = new JComboBox<Object>();
		comboBox.setBounds(41, 34, 91, 14);
		getContentPane().add(comboBox);
		
		JLabel Nick_1 = new JLabel("Nick");
		Nick_1.setHorizontalAlignment(SwingConstants.CENTER);
		Nick_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		Nick_1.setBounds(0, 47, 178, 28);
		getContentPane().add(Nick_1);
		
		JLabel Email_2 = new JLabel("Email");
		Email_2.setHorizontalAlignment(SwingConstants.CENTER);
		Email_2.setFont(new Font("Tahoma", Font.PLAIN, 11));
		Email_2.setBounds(0, 72, 178, 28);
		getContentPane().add(Email_2);
		
		JButton BotonConfirmar = new JButton("Confirmar");
		BotonConfirmar.setBounds(41, 107, 91, 23);
		getContentPane().add(BotonConfirmar);

	}

}
