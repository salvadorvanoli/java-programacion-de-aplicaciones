package interfaces;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JFileChooser;
import javax.swing.JButton;

public class ModificarImagenesProducto extends JInternalFrame {

	private static final long serialVersionUID = 1L;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModificarImagenesProducto frame = new ModificarImagenesProducto();
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
	public ModificarImagenesProducto() {
		setFrameIcon(new ImageIcon(VerInformacionCliente.class.getResource("/Images/Flamin-Go.png")));
		setClosable(true);
		setTitle("Flamin-Go");
		getContentPane().setLayout(null);
		
		JLabel lblTitulo = new JLabel("Modificar Imágenes de un Producto");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTitulo.setBounds(10, 11, 452, 29);
		getContentPane().add(lblTitulo);
		
		JFileChooser fileChooserImagenes = new JFileChooser();
		fileChooserImagenes.setBounds(10, 79, 452, 285);
		getContentPane().add(fileChooserImagenes);
		
		JLabel lblSeleccionarImagenes = new JLabel("A continuación, seleccione las Imágenes que considere");
		lblSeleccionarImagenes.setHorizontalAlignment(SwingConstants.CENTER);
		lblSeleccionarImagenes.setBounds(64, 41, 330, 29);
		getContentPane().add(lblSeleccionarImagenes);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(173, 386, 113, 23);
		getContentPane().add(btnAceptar);
		setBounds(100, 100, 488, 464);

	}

}
