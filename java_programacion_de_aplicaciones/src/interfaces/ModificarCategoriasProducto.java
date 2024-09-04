package interfaces;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

import javax.swing.SwingConstants;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;
import javax.swing.JTree;
import javax.swing.JButton;

import clases.Categoria;
import clases.DTProducto;

// Importamos clases de "clases"

import clases.ISistema;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ModificarCategoriasProducto extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private ISistema sistema;
	private ModificarDatosProducto internalFramePadre;
	private List<Categoria> nuevasCategorias;
	private JTree JTreeSeleccionNuevasCategorias;
	private String nuevoTextoCategorias;
	
	
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
	public ModificarCategoriasProducto(ISistema sistema, ModificarDatosProducto internalFramePadre) {
		
		this.sistema = sistema;
		this.nuevasCategorias = new ArrayList<>();
		this.internalFramePadre = internalFramePadre;
		
		ImageIcon icon = new ImageIcon(AltaDeCategoria.class.getResource("/Images/Flamin-Go.png"));
		Image img = icon.getImage().getScaledInstance(16, 16, Image.SCALE_SMOOTH);
		setFrameIcon(new ImageIcon(img));
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
		
		JTree JTreeSeleccionNuevasCategorias = new JTree();
		JTreeSeleccionNuevasCategorias.getSelectionModel().setSelectionMode(TreeSelectionModel.DISCONTIGUOUS_TREE_SELECTION); // Configurar el TreeSelectionModel para selección múltiple no contigua
		JTreeSeleccionNuevasCategorias.setBounds(30, 91, 163, 106);
		getContentPane().add(JTreeSeleccionNuevasCategorias);
		
		// Añadir un TreeSelectionListener para manejar la selección
		JTreeSeleccionNuevasCategorias.addTreeSelectionListener(new TreeSelectionListener() {
            @Override
            public void valueChanged(TreeSelectionEvent e) {
            	// Obtener todas las rutas seleccionadas
            	TreePath[] selectedPaths = JTreeSeleccionNuevasCategorias.getSelectionPaths();
            	
            	if (selectedPaths != null) {
            		nuevoTextoCategorias = "";
	            	nuevasCategorias.clear();
	                for (TreePath item : selectedPaths) {
	                	DefaultMutableTreeNode node = (DefaultMutableTreeNode) item.getLastPathComponent();
	                	Object userObject = node.getUserObject();
	                	if (userObject instanceof Categoria) {
	                		Categoria cat = (Categoria) userObject;
	                		nuevasCategorias.add(cat);
	                		nuevoTextoCategorias += cat.getNombreCat() + System.lineSeparator();
	                	}
	                }
            	}
            }
        });
		
		this.JTreeSeleccionNuevasCategorias = JTreeSeleccionNuevasCategorias;
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (! (nuevoTextoCategorias.isBlank()) && ! (nuevoTextoCategorias.isEmpty())) {
					internalFramePadre.setTextAreaCategorias(nuevoTextoCategorias);
				}
				internalFramePadre.setNuevasCategorias(nuevasCategorias);
			}
		});
		btnAceptar.setBounds(224, 132, 89, 23);
		getContentPane().add(btnAceptar);

	}
	
	
	public void cargarJTree() {
		DefaultMutableTreeNode root = new DefaultMutableTreeNode("Categorías");
		
		for (Categoria cat : sistema.getCategorias().values()) {
			this.cargarCategoriaJTree(cat, root); // ROOT SERIA EL NODO RAIZ (PODEMOS PONERLE CATEGORIA NOMAS)
		}
		
		DefaultTreeModel treeModel = new DefaultTreeModel(root);
        this.JTreeSeleccionNuevasCategorias.setModel(treeModel);
	}
	
	
	public void cargarCategoriaJTree(Categoria cat, DefaultMutableTreeNode nodo) {
		DefaultMutableTreeNode newNodo = new DefaultMutableTreeNode(cat);
		if (!(cat.getHijos().values().isEmpty())) {
			for (Categoria hijo : cat.getHijos().values()) {
				cargarCategoriaJTree(hijo, newNodo);
			}
		}
		nodo.add(newNodo);
	}

}
