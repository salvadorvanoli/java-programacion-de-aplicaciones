package interfaces;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;

import clases.DTFecha;
import clases.ISistema;
import excepciones.UsuarioRepetidoException;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.Color;
import javax.swing.ImageIcon;
import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Calendar;
import java.util.Date;
import java.awt.event.ActionEvent;

public class RegistrarProveedor extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private JTextField textNick;
	private JTextField textMail;
	private JTextField textNom;
	private JTextField textApe;
	private JTextField textCompan;
	private JTextField textLink;
	private JDateChooser DateFecha;
	private String rutaImagen = "";


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
		setResizable(true);
		ImageIcon icon = new ImageIcon(AltaDeCategoria.class.getResource("/Images/Flamin-Go.png"));
		Image img = icon.getImage().getScaledInstance(16, 16, Image.SCALE_SMOOTH);
		setFrameIcon(new ImageIcon(img));
		setTitle("Flamin-Go");
		setClosable(true);
		setBounds(100, 100, 385, 522);
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
		ButtonImg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 JFileChooser fileChooser = new JFileChooser();
	                fileChooser.setDialogTitle("Seleccione una imagen");
	                // Filtrar por imágenes
	                fileChooser.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("Imágenes", "jpg", "png", "jpeg", "gif"));
	                
	                int userSelection = fileChooser.showOpenDialog(RegistrarProveedor.this);
	                
	                if (userSelection == JFileChooser.APPROVE_OPTION) {
	                    File fileToUpload = fileChooser.getSelectedFile();
	                    rutaImagen = fileToUpload.getAbsolutePath();  // Guardar la ruta de la imagen
	                    JOptionPane.showMessageDialog(RegistrarProveedor.this, "Imagen seleccionada: " + rutaImagen, "Imagen", JOptionPane.INFORMATION_MESSAGE);
	                }
			}
		});
		ButtonImg.setBounds(38, 386, 144, 20);
		getContentPane().add(ButtonImg);
		
		JButton ButtonReg = new JButton("Registrar");
		ButtonReg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(chequearFormulario()) {
						String nickname = textNick.getText();
						String correo = textMail.getText();
						String nombre = textNom.getText();
						String apellido = textApe.getText();
						String comp = textCompan.getText();
						String link = textLink.getText();
						Date fechaN = DateFecha.getDate();	
						Calendar calendar = Calendar.getInstance();
				        calendar.setTime(fechaN);
				        int dia = calendar.get(Calendar.DAY_OF_MONTH);
				        int mes = calendar.get(Calendar.MONTH) + 1;
				        int anio = calendar.get(Calendar.YEAR);
				        DTFecha dtFecha = new DTFecha(dia, mes, anio);
						sistema.altaUsuarioProveedor(nickname, correo, nombre, apellido, dtFecha, comp, link, rutaImagen);
						
						JOptionPane.showMessageDialog(RegistrarProveedor.this, "El Proveedor se ha creado.", "Registrar Proveedor",
								JOptionPane.INFORMATION_MESSAGE);
						limpiarFormulario();
						setVisible(false);
					}
				}
				catch(UsuarioRepetidoException e1){
					JOptionPane.showMessageDialog(RegistrarProveedor.this, e1.getMessage(), "Registrar Proveedor", JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		ButtonReg.setBackground(new Color(250, 214, 235));
		ButtonReg.setBounds(256, 433, 89, 23);
		getContentPane().add(ButtonReg);
		
		DateFecha = new JDateChooser();
		DateFecha.setBounds(38, 337, 144, 20);
		getContentPane().add(DateFecha);
		
		JButton ButtonCancel = new JButton("Cancelar");
		ButtonCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiarFormulario();
				setVisible(false);
			}
		});
		ButtonCancel.setBounds(38, 433, 89, 23);
		getContentPane().add(ButtonCancel);

	}
	
	private void limpiarFormulario() {
		textNick.setText("");
		textNom.setText("");
		textApe.setText("");
		textMail.setText("");
		textCompan.setText("");
		textLink.setText("");
		DateFecha.setDate(null);
		rutaImagen = "";
	}
	private boolean chequearFormulario() {
		String nickname = textNick.getText();
		String correo = textMail.getText();
		String nombre = textNom.getText();
		String apellido = textApe.getText();
		//Date fechaN = DateFecha.getDate();
		String comp = textCompan.getText();
		String link = textLink.getText();
		
		if (nickname.isEmpty() || correo.isEmpty() || nombre.isEmpty() || apellido.isEmpty() || DateFecha.getDate() == null || comp.isEmpty() || link.isEmpty()) {
			JOptionPane.showMessageDialog(this, "No puede haber campos vacíos", "Registrar ",
					JOptionPane.ERROR_MESSAGE);
			return false;
		}
		return true;
}
}
