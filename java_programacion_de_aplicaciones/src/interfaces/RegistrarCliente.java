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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RegistrarCliente extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private JTextField textNick;
	private JTextField textMail;
	private JTextField textNom;
	private JTextField textApe;

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
	 * @param sistema 
	 */
	public RegistrarCliente(ISistema sistema) {
		setFrameIcon(new ImageIcon(RegistrarCliente.class.getResource("/Images/Flamin-Go.png")));
		setTitle("Flamin-Go");
		setClosable(true);
		setBounds(100, 100, 385, 405);
		getContentPane().setLayout(null);
		
		JLabel LabelRegCli = new JLabel("Registrar Cliente");
		LabelRegCli.setHorizontalAlignment(SwingConstants.CENTER);
		LabelRegCli.setFont(new Font("Tahoma", Font.PLAIN, 16));
		LabelRegCli.setBounds(0, 11, 369, 29);
		getContentPane().add(LabelRegCli);
		
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
		
		JLabel LabelFecha = new JLabel("Fecha de Nacimiento");
		LabelFecha.setBounds(38, 233, 102, 14);
		getContentPane().add(LabelFecha);
		
		JButton ButtonImg = new JButton("Asignar una imagen");
		ButtonImg.setBounds(38, 319, 144, 20);
		getContentPane().add(ButtonImg);
		
		JButton ButtonReg = new JButton("Registrar");
		ButtonReg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nickname = textNicknameCliente.getText();
			}
		});
		ButtonReg.setBackground(new Color(250, 214, 235));
		ButtonReg.setBounds(255, 335, 89, 23);
		getContentPane().add(ButtonReg);
		
		JDateChooser DateFecha = new JDateChooser();
		DateFecha.setBounds(38, 258, 144, 20);
		getContentPane().add(DateFecha);

	}
}
