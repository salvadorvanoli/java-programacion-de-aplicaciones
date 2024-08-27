package interfaces;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import java.awt.Rectangle;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import clases.ISistema;

import java.awt.Font;
import java.awt.Dimension;
import javax.swing.JTextArea;

public class InfoProveedorDetallado extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private JTextArea Info1;

	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InfoProveedorDetallado frame = new InfoProveedorDetallado();
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
	public InfoProveedorDetallado(ISistema sistema) {
		setClosable(true);
		setBackground(Color.WHITE);
		setFrameIcon(new ImageIcon(InfoProveedorDetallado.class.getResource("/Images/Flamin-Go.png")));
		setTitle("Flamin-Go");
		setBounds(new Rectangle(0, 0, 256, 220));
		setBounds(100, 100, 256, 243);
		getContentPane().setLayout(null);
		
		JLabel Foto = new JLabel("Foto");
		Foto.setHorizontalAlignment(SwingConstants.CENTER);
		Foto.setBounds(120, 25, 120, 109);
		getContentPane().add(Foto);
		
		Info1 = new JTextArea();
		Info1.setBackground(Color.WHITE);
		Info1.setText("Datos1");
		Info1.setBounds(0, 25, 120, 109);
		getContentPane().add(Info1);
		
		JTextArea Info2 = new JTextArea();
		Info2.setBackground(Color.WHITE);
		Info2.setText("Datos2\r\n");
		Info2.setBounds(0, 131, 240, 82);
		getContentPane().add(Info2);
		
		JLabel lblNewLabel = new JLabel("Informacion Del Proveedor\r\n");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(0, 11, 240, 14);
		getContentPane().add(lblNewLabel);

	}
}
