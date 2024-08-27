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
	private JTextField textNick;
	private JTextField textMail;
	private JTextField textNom;
	private JTextField textApe;
	private JTextField textCompan;
	private JTextField textLink;

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
		
		JLabel LabelRegProv = new JLabel("Registrar Proveedor");
		LabelRegProv.setHorizontalAlignment(SwingConstants.CENTER);
		LabelRegProv.setFont(new Font("Tahoma", Font.PLAIN, 16));
		LabelRegProv.setBounds(0, 11, 369, 29);
		getContentPane().add(LabelRegProv);
		
		JLabel LabelNick = new JLabel("Nickname");
		LabelNick.setBounds(38, 54, 48, 14);
		getContentPane().add(LabelNick);
		
		textNick = new JTextField();
		textNick.setColumns(10);
		textNick.setBounds(106, 51, 222, 20);
		getContentPane().add(textNick);
		
		JLabel LabelMail = new JLabel("Correo Electrónico");
		LabelMail.setBounds(38, 98, 89, 14);
		getContentPane().add(LabelMail);
		
		textMail = new JTextField();
		textMail.setColumns(10);
		textMail.setBounds(148, 95, 180, 20);
		getContentPane().add(textMail);
		
		JLabel LabelNom = new JLabel("Nombre");
		LabelNom.setBounds(38, 143, 48, 14);
		getContentPane().add(LabelNom);
		
		textNom = new JTextField();
		textNom.setColumns(10);
		textNom.setBounds(96, 140, 232, 20);
		getContentPane().add(textNom);
		
		JLabel LabelApe = new JLabel("Apellido");
		LabelApe.setBounds(38, 188, 48, 14);
		getContentPane().add(LabelApe);
		
		textApe = new JTextField();
		textApe.setColumns(10);
		textApe.setBounds(96, 185, 232, 20);
		getContentPane().add(textApe);
		
		textCompan = new JTextField();
		textCompan.setColumns(10);
		textCompan.setBounds(172, 224, 156, 20);
		getContentPane().add(textCompan);
		
		JLabel LabelCompan = new JLabel("Nombre de la Compañía");
		LabelCompan.setBounds(38, 227, 118, 14);
		getContentPane().add(LabelCompan);
		
		JLabel LabelLink = new JLabel("Link Web");
		LabelLink.setBounds(38, 272, 48, 14);
		getContentPane().add(LabelLink);
		
		textLink = new JTextField();
		textLink.setColumns(10);
		textLink.setBounds(96, 269, 232, 20);
		getContentPane().add(textLink);
		
		JLabel LabelFecha = new JLabel("Fecha de Nacimiento");
		LabelFecha.setBounds(38, 312, 102, 14);
		getContentPane().add(LabelFecha);
		
		JButton ButtonImg = new JButton("Asignar una imagen");
		ButtonImg.setBounds(38, 398, 144, 20);
		getContentPane().add(ButtonImg);
		
		JButton ButtonReg = new JButton("Registrar");
		ButtonReg.setBackground(new Color(250, 214, 235));
		ButtonReg.setBounds(256, 422, 89, 23);
		getContentPane().add(ButtonReg);
		
		JDateChooser DateFecha = new JDateChooser();
		DateFecha.setBounds(38, 337, 144, 20);
		getContentPane().add(DateFecha);

	}
}
