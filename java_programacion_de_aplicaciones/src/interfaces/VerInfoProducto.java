package interfaces;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

import clases.ISistema;

import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.ImageIcon;
import javax.swing.JTree;

public class VerInfoProducto extends JInternalFrame {

	private static final long serialVersionUID = 1L;

	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VerInfoProducto frame = new VerInfoProducto();
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
	public VerInfoProducto(ISistema sistema) {
		setFrameIcon(new ImageIcon(VerInfoProducto.class.getResource("/Images/Flamin-Go.png")));
		setTitle("Flamin-Go");
		setClosable(true);
		setBounds(100, 100, 331, 505);
		getContentPane().setLayout(null);
		
		JLabel LabelSelectCat = new JLabel("Seleccione una categoría del sistema");
		LabelSelectCat.setHorizontalAlignment(SwingConstants.CENTER);
		LabelSelectCat.setFont(new Font("Tahoma", Font.PLAIN, 13));
		LabelSelectCat.setBounds(0, 22, 313, 14);
		getContentPane().add(LabelSelectCat);
		
		JLabel LabelProd = new JLabel("Seleccione un producto");
		LabelProd.setHorizontalAlignment(SwingConstants.CENTER);
		LabelProd.setFont(new Font("Tahoma", Font.PLAIN, 13));
		LabelProd.setBounds(0, 135, 313, 14);
		getContentPane().add(LabelProd);
		
		JComboBox comboBoxProd = new JComboBox();
		comboBoxProd.setBounds(30, 160, 255, 22);
		getContentPane().add(comboBoxProd);
		
		JTextArea TextDatosProd = new JTextArea();
		TextDatosProd.setText("Aquí se mostrarán los datos \r\ndel producto");
		TextDatosProd.setBounds(30, 193, 255, 256);
		getContentPane().add(TextDatosProd);
		
		JTree treeCat = new JTree();
		treeCat.setBounds(51, 46, 131, 78);
		getContentPane().add(treeCat);

	}
}
