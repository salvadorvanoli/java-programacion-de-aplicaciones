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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
		getContentPane().setBackground(new Color(240, 240, 240));
		setBounds(100, 100, 264, 181);
		getContentPane().setLayout(null);
		
		JLabel TextoProveedor = new JLabel("Elija un Proveedor\r\n");
		TextoProveedor.setFont(new Font("Tahoma", Font.PLAIN, 16));
		TextoProveedor.setHorizontalAlignment(SwingConstants.CENTER);
		TextoProveedor.setBounds(0, 11, 247, 14);
		getContentPane().add(TextoProveedor);
		
		JComboBox<Object> comboBox = new JComboBox<Object>();
		comboBox.setBounds(71, 36, 103, 14);
		getContentPane().add(comboBox);
		
		JLabel Nick_1 = new JLabel("Nick");
		Nick_1.setHorizontalAlignment(SwingConstants.CENTER);
		Nick_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		Nick_1.setBounds(0, 48, 247, 28);
		getContentPane().add(Nick_1);
		
		JLabel Email_2 = new JLabel("Email");
		Email_2.setHorizontalAlignment(SwingConstants.CENTER);
		Email_2.setFont(new Font("Tahoma", Font.PLAIN, 11));
		Email_2.setBounds(0, 75, 247, 28);
		getContentPane().add(Email_2);
		
		JButton BotonConfirmar = new JButton("Confirmar");
		BotonConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menuPrincipal.getContentPane().add(infoProveedorInternalFrame);
                infoProveedorInternalFrame.setVisible(true);
                infoProveedorInternalFrame.setLocation(0, 0);  // Ajustar la posición del InternalFrame
                menuPrincipal.revalidate();
                menuPrincipal.repaint();
			}
		});
		BotonConfirmar.setBounds(71, 102, 103, 23);
		getContentPane().add(BotonConfirmar);
	}
}
