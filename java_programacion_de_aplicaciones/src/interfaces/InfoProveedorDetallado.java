package interfaces;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import java.awt.Rectangle;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Dimension;

public class InfoProveedorDetallado extends JInternalFrame {

	private static final long serialVersionUID = 1L;

	/**
	 * Launch the application.
	 */
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

	/**
	 * Create the frame.
	 */
	public InfoProveedorDetallado() {
		setBackground(new Color(255, 192, 203));
		setFrameIcon(new ImageIcon("C:\\Users\\felip\\Downloads\\Diseño sin título (1).png"));
		setTitle("Información del Proveedor");
		setBounds(new Rectangle(0, 0, 256, 220));
		setBounds(100, 100, 256, 221);
		getContentPane().setLayout(null);
		
		JLabel Link = new JLabel("Link");
		Link.setHorizontalAlignment(SwingConstants.CENTER);
		Link.setBounds(0, 162, 240, 28);
		getContentPane().add(Link);
		
		JLabel Email = new JLabel("Email");
		Email.setHorizontalAlignment(SwingConstants.CENTER);
		Email.setFont(new Font("Tahoma", Font.PLAIN, 11));
		Email.setBounds(0, 135, 240, 28);
		getContentPane().add(Email);
		
		JLabel FechaNacimiento = new JLabel("Fecha de Nacimiento");
		FechaNacimiento.setHorizontalAlignment(SwingConstants.CENTER);
		FechaNacimiento.setBounds(0, 108, 120, 28);
		getContentPane().add(FechaNacimiento);
		
		JLabel NombreCompania = new JLabel("Nombre Compania");
		NombreCompania.setHorizontalAlignment(SwingConstants.CENTER);
		NombreCompania.setBounds(0, 81, 120, 28);
		getContentPane().add(NombreCompania);
		
		JLabel Apellido = new JLabel("Apellido");
		Apellido.setHorizontalAlignment(SwingConstants.CENTER);
		Apellido.setFont(new Font("Tahoma", Font.PLAIN, 11));
		Apellido.setBounds(0, 54, 120, 28);
		getContentPane().add(Apellido);
		
		JLabel Nombre = new JLabel("Nombre");
		Nombre.setSize(new Dimension(19, 14));
		Nombre.setMinimumSize(new Dimension(19, 14));
		Nombre.setMaximumSize(new Dimension(19, 14));
		Nombre.setHorizontalAlignment(SwingConstants.CENTER);
		Nombre.setFont(new Font("Tahoma", Font.PLAIN, 11));
		Nombre.setBounds(0, 27, 120, 28);
		getContentPane().add(Nombre);
		
		JLabel Nick = new JLabel("Nick");
		Nick.setHorizontalAlignment(SwingConstants.CENTER);
		Nick.setFont(new Font("Tahoma", Font.PLAIN, 11));
		Nick.setBackground(Color.BLACK);
		Nick.setBounds(0, 0, 120, 28);
		getContentPane().add(Nick);
		
		JLabel Foto = new JLabel("Foto");
		Foto.setHorizontalAlignment(SwingConstants.CENTER);
		Foto.setBounds(120, 0, 120, 109);
		getContentPane().add(Foto);

	}

}
