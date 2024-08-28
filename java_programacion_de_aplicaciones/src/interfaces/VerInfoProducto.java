package interfaces;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.SwingConstants;

import clases.Categoria;
import clases.DTOrdenDeCompra;
import clases.DTProducto;
import clases.DTProductoDetallado;
import clases.ISistema;
import clases.Producto;
import excepciones.CategoriaNoExisteException;

import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.ImageIcon;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultTreeModel;
//import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VerInfoProducto extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private JTree treeCat;
	private JComboBox<String> comboBoxProd;
	private JTextArea TextDatosProd;
	private ISistema sistema;
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
		setBounds(100, 100, 380, 505);
		getContentPane().setLayout(null);
		
		JLabel LabelSelectCat = new JLabel("Seleccione una categoría del sistema y luego \"Confirmar\"");
		LabelSelectCat.setHorizontalAlignment(SwingConstants.CENTER);
		LabelSelectCat.setFont(new Font("Tahoma", Font.PLAIN, 13));
		LabelSelectCat.setBounds(0, 22, 364, 14);
		getContentPane().add(LabelSelectCat);
		
		JLabel LabelProd = new JLabel("Seleccione un producto");
		LabelProd.setHorizontalAlignment(SwingConstants.CENTER);
		LabelProd.setFont(new Font("Tahoma", Font.PLAIN, 13));
		LabelProd.setBounds(0, 135, 313, 14);
		getContentPane().add(LabelProd);
		
		comboBoxProd = new JComboBox<>();
		comboBoxProd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ProductoDetallado = sistema.getProductoActual().toString();
                TextDatosProd.setText(ProductoDetallado);
                //////////////ACA////////////////
			}
		});
		comboBoxProd.setBounds(30, 160, 255, 22);
		getContentPane().add(comboBoxProd);
		
		JTextArea TextDatosProd = new JTextArea();
		TextDatosProd.setEditable(false);
		TextDatosProd.setText("Aquí se mostrarán los datos \r\ndel producto");
		TextDatosProd.setBounds(30, 193, 255, 256);
		getContentPane().add(TextDatosProd);
		
		
		treeCat = new JTree();
		cargarDatos();
		treeCat.setBounds(51, 46, 143, 78);
		getContentPane().add(treeCat);
		
		JButton ButtonConfCat = new JButton("Confirmar\r\n");
		ButtonConfCat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) treeCat.getLastSelectedPathComponent();
                Categoria categoriaActual = null;

                if (selectedNode != null && !selectedNode.toString().equals("Categorías")) {
                    String nombreCat = selectedNode.toString();
                    try {
                        sistema.elegirCategoria(nombreCat);
                        categoriaActual = sistema.getCategoriaActual();
                    } catch (CategoriaNoExisteException e1) {
                        // MANEJAR ERROR
                    }
                    cargarProductosEnComboBox(sistema.getCategoriaActual());
                }
			}
		});
		
		ButtonConfCat.setBounds(225, 67, 88, 36);
		getContentPane().add(ButtonConfCat);

	}
	
	private void cargarDatos() {
        // Vaciar el JTree
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("Categorías");

        HashMap<String, Categoria> categorias = sistema.getCategorias();

        if (categorias == null || categorias.isEmpty()) {
            // Si no hay categorías, no agregar nodos
            treeCat.setModel(new DefaultTreeModel(root));
            return;
        }

        // Crear un mapa para guardar los nodos de categoría por nombre
        Map<String, DefaultMutableTreeNode> nodoMap = new HashMap<>();

        // Crear nodos para cada categoría y almacenarlos en el mapa
        for (Map.Entry<String, Categoria> entry : categorias.entrySet()) {
            Categoria categoria = entry.getValue();
            DefaultMutableTreeNode node = new DefaultMutableTreeNode(categoria.getNombreCat());
            nodoMap.put(categoria.getNombreCat(), node);
        }

        // Agregar nodos hijos a sus nodos padres
        for (Map.Entry<String, Categoria> entry : categorias.entrySet()) {
            Categoria categoria = entry.getValue();
            DefaultMutableTreeNode node = nodoMap.get(categoria.getNombreCat());
            Categoria padre = categoria.getPadre();

            if (padre != null) {
                DefaultMutableTreeNode parentNode = nodoMap.get(padre.getNombreCat());
                if (parentNode != null) {
                    parentNode.add(node);
                } else {
                    // Si el padre no está en el mapa, agregar el nodo al nodo raíz
                    root.add(node);
                }
            } else {
                // Si no tiene padre, agregar al nodo raíz
                root.add(node);
            }
        }

        // Crear el modelo de árbol y asignarlo al JTree
        DefaultTreeModel treeModel = new DefaultTreeModel(root);
        treeCat.setModel(treeModel);
    }
	
	
	// Método para cargar los productos de una categoría en el JComboBox
	private void cargarProductosEnComboBox(Categoria categoriaSeleccionada) {
	    // Limpiar el JComboBox
	    comboBoxProd.removeAllItems();
	    List<DTProducto> lista = sistema.listarProductos();
        if(lista.isEmpty()) {
        	TextDatosProd.setText("Aquí se mostraran los datos del Producto");
        }
	    // Verificar si la categoría tiene productos
	    if (categoriaSeleccionada != null && categoriaSeleccionada.getProductos() != null) {
	        // Llenar el JComboBox con los productos de la categoría seleccionada
	        for (DTProducto producto : lista) {
	        	String nombre = producto.getNombre();
	        	//int codigo = producto.getNumReferencia();
	            comboBoxProd.addItem(nombre);
	        }
	    }
	}


}


