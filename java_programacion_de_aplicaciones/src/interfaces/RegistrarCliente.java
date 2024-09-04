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
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.awt.event.ActionEvent;

public class RegistrarCliente extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private JTextField textNick;
	private JTextField textMail;
	private JTextField textNom;
	private JTextField textApe;
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
		setResizable(true);
		ImageIcon icon = new ImageIcon(AltaDeCategoria.class.getResource("/Images/Flamin-Go.png"));
		Image img = icon.getImage().getScaledInstance(16, 16, Image.SCALE_SMOOTH);
		setFrameIcon(new ImageIcon(img));
		setTitle("Flamin-Go");
		setClosable(true);
		setBounds(100, 100, 416, 436);
		getContentPane().setLayout(null);
		
		JLabel LabelRegCli = new JLabel("Registrar Cliente");
		LabelRegCli.setHorizontalAlignment(SwingConstants.CENTER);
		LabelRegCli.setFont(new Font("Tahoma", Font.PLAIN, 16));
		LabelRegCli.setBounds(0, 11, 400, 29);
		getContentPane().add(LabelRegCli);
		
		JLabel LabelNick = new JLabel("Nickname");
		LabelNick.setBounds(38, 54, 77, 14);
		getContentPane().add(LabelNick);
		
		textNick = new JTextField();
		textNick.setColumns(10);
		textNick.setBounds(151, 51, 222, 20);
		getContentPane().add(textNick);
		
		JLabel LabelMail = new JLabel("Correo Electrónico");
		LabelMail.setBounds(38, 98, 115, 14);
		getContentPane().add(LabelMail);
		
		textMail = new JTextField();
		textMail.setColumns(10);
		textMail.setBounds(193, 95, 180, 20);
		getContentPane().add(textMail);
		
		JLabel LabelNom = new JLabel("Nombre");
		LabelNom.setBounds(38, 143, 77, 14);
		getContentPane().add(LabelNom);
		
		textNom = new JTextField();
		textNom.setColumns(10);
		textNom.setBounds(141, 140, 232, 20);
		getContentPane().add(textNom);
		
		JLabel LabelApe = new JLabel("Apellido");
		LabelApe.setBounds(38, 188, 77, 14);
		getContentPane().add(LabelApe);
		
		textApe = new JTextField();
		textApe.setColumns(10);
		textApe.setBounds(141, 185, 232, 20);
		getContentPane().add(textApe);
		
		JLabel LabelFecha = new JLabel("Fecha de Nacimiento");
		LabelFecha.setBounds(38, 233, 132, 14);
		getContentPane().add(LabelFecha);
		
		JButton ButtonImg = new JButton("Asignar una imagen");
		ButtonImg.setBounds(38, 309, 169, 20);
		getContentPane().add(ButtonImg);
		
		ButtonImg.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setDialogTitle("Seleccione una imagen");
                // Filtrar por imágenes
                fileChooser.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("Imágenes", "jpg", "png", "jpeg"));
                
                int userSelection = fileChooser.showOpenDialog(RegistrarCliente.this);
                
                if (userSelection == JFileChooser.APPROVE_OPTION) {
                    File fileToUpload = fileChooser.getSelectedFile();
                    rutaImagen = fileToUpload.getAbsolutePath();  // Guardar la ruta de la imagen
                    JOptionPane.showMessageDialog(RegistrarCliente.this, "Imagen seleccionada: " + rutaImagen, "Imagen", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
		DateFecha = new JDateChooser();
		DateFecha.setBounds(38, 258, 144, 20);
		getContentPane().add(DateFecha);
		//this.DateFecha = DateFecha;
		
		JButton ButtonReg = new JButton("Registrar");
		ButtonReg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					if (chequearFormulario()) {
						String nickname = textNick.getText();
						String correo = textMail.getText();
						String nombre = textNom.getText();
						String apellido = textApe.getText();
						Date fechaN = DateFecha.getDate();
						Calendar calendar = Calendar.getInstance();
				        calendar.setTime(fechaN);
				        int dia = calendar.get(Calendar.DAY_OF_MONTH);
				        int mes = calendar.get(Calendar.MONTH) + 1;
				        int anio = calendar.get(Calendar.YEAR);
				        DTFecha dtFecha = new DTFecha(dia, mes, anio);
						sistema.altaUsuarioCliente(nickname, correo, nombre, apellido, dtFecha, rutaImagen);
						
						JOptionPane.showMessageDialog(RegistrarCliente.this, "El Cliente se ha creado.", "Registrar Cliente",
								JOptionPane.INFORMATION_MESSAGE);
						limpiarFormulario();
						setVisible(false);
					}
				}
				catch(UsuarioRepetidoException e){
					JOptionPane.showMessageDialog(RegistrarCliente.this, e.getMessage(), "Registrar Cliente", JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		ButtonReg.setBackground(new Color(240, 240, 240));
		ButtonReg.setBounds(268, 354, 105, 23);
		getContentPane().add(ButtonReg);
		
		JButton ButtonCancel = new JButton("Cancelar");
		ButtonCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiarFormulario();
				setVisible(false);
			}
		});
		ButtonCancel.setBounds(38, 354, 105, 23);
		getContentPane().add(ButtonCancel);
	}
	
	//metodos
	
	private void limpiarFormulario() {
		textNick.setText("");
		textNom.setText("");
		textApe.setText("");
		textMail.setText("");
		DateFecha.setDate(null);
		rutaImagen = "";
	}
		
	private boolean chequearFormulario() {
			String nickname = textNick.getText();
			String correo = textMail.getText();
			String nombre = textNom.getText();
			String apellido = textApe.getText();
			//Date fechaN = DateFecha.getDate();
			if (nickname.isEmpty() || correo.isEmpty() || nombre.isEmpty() || apellido.isEmpty() || DateFecha.getDate() == null) {
				JOptionPane.showMessageDialog(RegistrarCliente.this, "No puede haber campos vacíos", "Registrar ",
						JOptionPane.ERROR_MESSAGE);
				return false;
			}
			return true;
	}
			
	
	
}

