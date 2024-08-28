package interfaces;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

import clases.Categoria;
import clases.ISistema;
import clases.Producto;

import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.ImageIcon;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionListener;
//import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;
import javax.swing.event.TreeSelectionEvent;

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
		treeCat.addTreeSelectionListener(new TreeSelectionListener() {
            @Override
            public void valueChanged(TreeSelectionEvent e) {
                // Obtener el nodo seleccionado
                TreePath path = treeCat.getSelectionPath();
                if (path != null) {
                    Object selectedNode = path.getLastPathComponent();
                    if (selectedNode instanceof Categoria) {
                        Categoria categoriaSeleccionada = (Categoria) selectedNode;
                        System.out.println("Categoría seleccionada: " + categoriaSeleccionada.getNombreCat());

                        // Actualizar el JComboBox con los productos
                        comboBoxProd.removeAllItems();
                        for (Producto producto : categoriaSeleccionada.getProductos()) {
                            comboBoxProd.addItem(producto);
                        }
                    }
                }
            }
        });
		treeCat.setBounds(51, 46, 131, 78);
		getContentPane().add(treeCat);

	}
}
