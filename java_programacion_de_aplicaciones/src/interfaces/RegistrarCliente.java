package interfaces;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
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
		
		ButtonImg.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setDialogTitle("Seleccione una imagen");
                // Filtrar por imágenes
                fileChooser.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("Imágenes", "jpg", "png", "jpeg", "gif"));
                
                int userSelection = fileChooser.showOpenDialog(RegistrarCliente.this);
                
                if (userSelection == JFileChooser.APPROVE_OPTION) {
                    File fileToUpload = fileChooser.getSelectedFile();
                    rutaImagen = fileToUpload.getAbsolutePath();  // Guardar la ruta de la imagen
                    JOptionPane.showMessageDialog(RegistrarCliente.this, "Imagen seleccionada: " + rutaImagen, "Imagen", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
		JDateChooser DateFecha = new JDateChooser();
		DateFecha.setBounds(38, 258, 144, 20);
		getContentPane().add(DateFecha);

		
		/*private void limpiarFormulario() {
			textNick.setText("");
			textNom.setText("");
			textApe.setText("");
			textMail.setText("");
			DateFecha.setDate(null);
			//FALTA CONTEMPLAR IMAGEN
		}*/
		
		JButton ButtonReg = new JButton("Registrar");
		ButtonReg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String nickname = textNick.getText();
				String correo = textMail.getText();
				String nombre = textNom.getText();
				String apellido = textApe.getText();
				Date fechaN = DateFecha.getDate();	
				DTFecha fechaPrueb = null; //QUITAR ESTO DESPUES
				chequearFormulario();
				//como es lo de la fecha
				SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
				String fechastring = dateFormat.format(fechaN);
				try {
					sistema.altaUsuarioCliente(nickname, correo, nombre, apellido, fechaPrueb, rutaImagen);
					
					JOptionPane.showMessageDialog(RegistrarCliente.this, "El Cliente se ha creado.", "Registrar Cliente",
							JOptionPane.INFORMATION_MESSAGE);
				}
				catch(UsuarioRepetidoException e){
					JOptionPane.showMessageDialog(RegistrarCliente.this, e.getMessage(), "Registrar Cliente", JOptionPane.ERROR_MESSAGE);
				}
				limpiarFormulario();
				setVisible(false);
			}
		});
		ButtonReg.setBackground(new Color(250, 214, 235));
		ButtonReg.setBounds(255, 335, 89, 23);
		getContentPane().add(ButtonReg);
	}
	
	//metodos
	
	private void limpiarFormulario() {
		textNick.setText("");
		textNom.setText("");
		textApe.setText("");
		textMail.setText("");
		DateFecha.setDate(null);
		//Falta la imagen
	}
		
	private boolean chequearFormulario() {
			String nickname = textNick.getText();
			String correo = textMail.getText();
			String nombre = textNom.getText();
			String apellido = textApe.getText();
			Date fechaN = DateFecha.getDate();
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			String fechastring = dateFormat.format(fechaN);
			if (nickname.isEmpty() || correo.isEmpty() || nombre.isEmpty() || apellido.isEmpty() || fechastring.isEmpty()) {
				JOptionPane.showMessageDialog(RegistrarCliente.this, "No puede haber campos vacíos", "Registrar ",
						JOptionPane.ERROR_MESSAGE);
				return false;
			}
			return true;
	}
			
	
	
}

