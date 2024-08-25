import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JList;
import java.awt.BorderLayout;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import java.util.HashMap;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class Generar_Orden_de_Compra extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Generar_Orden_de_Compra frame = new Generar_Orden_de_Compra();
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
	public Generar_Orden_de_Compra() {
		setFrameIcon(new ImageIcon("C:\\Users\\felip\\Downloads\\Diseño sin título (1).png"));
		setTitle("Generar orden de compra");
		setBounds(100, 100, 445, 300);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(32, 113, 124, 70);
		getContentPane().add(scrollPane);
		
		JTree tree = new JTree();
		scrollPane.setViewportView(tree);
		tree.setName("");
		tree.setToggleClickCount(1);
		tree.setToolTipText("Selecciona el producto dentro de las categorías");
		tree.setModel(new DefaultTreeModel(
			new DefaultMutableTreeNode("Categoría") {
				{
					DefaultMutableTreeNode node_1;
					DefaultMutableTreeNode node_2;
					node_1 = new DefaultMutableTreeNode("Electrónicos");
						node_2 = new DefaultMutableTreeNode("Celulares");
							node_2.add(new DefaultMutableTreeNode("a"));
							node_2.add(new DefaultMutableTreeNode("b"));
						node_1.add(node_2);
						node_2 = new DefaultMutableTreeNode("Laptops");
							node_2.add(new DefaultMutableTreeNode("a"));
							node_2.add(new DefaultMutableTreeNode("b"));
						node_1.add(node_2);
					getContentPane().add(node_1);
					node_1 = new DefaultMutableTreeNode("Farmacia");
						node_2 = new DefaultMutableTreeNode("(empty)");
							node_2.add(new DefaultMutableTreeNode(""));
						node_1.add(node_2);
					getContentPane().add(node_1);
					node_1 = new DefaultMutableTreeNode("Ropa");
						node_1.add(new DefaultMutableTreeNode(""));
					getContentPane().add(node_1);
					node_1 = new DefaultMutableTreeNode("Nada");
						node_1.add(new DefaultMutableTreeNode("a"));
					getContentPane().add(node_1);
				}
			}
		));
		
		JComboBox comboBox = new JComboBox();
		comboBox.setEditable(true);
		comboBox.setBounds(32, 46, 114, 22);
		getContentPane().add(comboBox);
		
		JLabel lblNewLabel = new JLabel("Seleccionar cliente:");
		lblNewLabel.setBounds(32, 21, 102, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Seleccionar producto:");
		lblNewLabel_1.setBounds(32, 88, 114, 14);
		getContentPane().add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(86, 194, 30, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Cantidad:");
		lblNewLabel_2.setBounds(32, 197, 59, 14);
		getContentPane().add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("Agregar a la orden");
		btnNewButton.setBounds(32, 225, 124, 23);
		getContentPane().add(btnNewButton);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_1.setBounds(245, 48, 154, 83);
		getContentPane().add(scrollPane_1);
		
		JList list = new JList();
		scrollPane_1.setColumnHeaderView(list);
		
		JLabel lblNewLabel_3 = new JLabel("Orden provisoria:");
		lblNewLabel_3.setBounds(245, 21, 135, 14);
		getContentPane().add(lblNewLabel_3);
		
		JButton btnNewButton_1 = new JButton("Descartar linea");
		btnNewButton_1.setEnabled(false);
		btnNewButton_1.setBounds(245, 143, 114, 23);
		getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Cancelar");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_2.setBounds(216, 236, 89, 23);
		getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Dar de alta");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_3.setBounds(315, 236, 89, 23);
		getContentPane().add(btnNewButton_3);

	}
}
