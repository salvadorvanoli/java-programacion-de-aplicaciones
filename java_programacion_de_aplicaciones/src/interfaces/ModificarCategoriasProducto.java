package interfaces;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTree;
import javax.swing.JButton;

// Importamos clases de "clases"

import clases.ISistema;

public class ModificarCategoriasProducto extends JInternalFrame {

	private static final long serialVersionUID = 1L;

	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModificarCategoriasProducto frame = new ModificarCategoriasProducto();
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
	 */
	public ModificarCategoriasProducto(ISistema sistema) {
		setFrameIcon(new ImageIcon(VerInformacionCliente.class.getResource("/Images/Flamin-Go.png")));
		setClosable(true);
		setTitle("Flamin-Go");
		setBounds(100, 100, 366, 254);
		getContentPane().setLayout(null);
		
		JLabel lblTitulo = new JLabel("Modificar Categorías de un Producto");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTitulo.setBounds(10, 11, 330, 29);
		getContentPane().add(lblTitulo);
		
		JLabel lblSeleccionarCategorias = new JLabel("A continuación, seleccione las Categorías que considere");
		lblSeleccionarCategorias.setHorizontalAlignment(SwingConstants.CENTER);
		lblSeleccionarCategorias.setBounds(10, 51, 330, 29);
		getContentPane().add(lblSeleccionarCategorias);
		
		JTree tree = new JTree();
		tree.setBounds(30, 91, 163, 106);
		getContentPane().add(tree);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(224, 132, 89, 23);
		getContentPane().add(btnAceptar);

	}

}
