package interfaces;
import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class VerInfoOrdenDeCompra extends JInternalFrame {

	private static final long serialVersionUID = 1L;

	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VerInfoOrdenDeCompra frame = new VerInfoOrdenDeCompra();
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
	public VerInfoOrdenDeCompra() {
		setFrameIcon(new ImageIcon(VerInfoOrdenDeCompra.class.getResource("/Images/Flamin-Go.png")));
		setTitle("Ver información de orden de compra");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setToolTipText("Puede ingresar el código");
		comboBox.setEditable(true);
		comboBox.setBounds(24, 39, 99, 22);
		getContentPane().add(comboBox);
		
		JLabel lblNewLabel = new JLabel("Seleccionar orden de compra:");
		lblNewLabel.setBounds(24, 14, 149, 14);
		getContentPane().add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(24, 119, 189, 98);
		getContentPane().add(scrollPane);
		
		JList list = new JList();
		scrollPane.setViewportView(list);
		
		JLabel lblNewLabel_1 = new JLabel("Orden de compra:");
		lblNewLabel_1.setBounds(24, 95, 120, 14);
		getContentPane().add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Consultar otra orden");
		btnNewButton.setBounds(168, 236, 149, 23);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Aceptar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(327, 236, 89, 23);
		getContentPane().add(btnNewButton_1);

	}

}
