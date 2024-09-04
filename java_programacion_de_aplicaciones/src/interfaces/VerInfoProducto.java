package interfaces;

import java.awt.BorderLayout;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.Font;
import java.awt.Image;
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
import excepciones.ProductoNoExisteException;
import javax.swing.JInternalFrame;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JTextArea;
import javax.swing.ImageIcon;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
//import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JScrollBar;
import javax.swing.ScrollPaneConstants;


public class VerInfoProducto extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private JTree treeCat;
	private JComboBox<DTProducto> comboBoxProd;
	//private JTextArea TextDatosProd;
	private ISistema sistema;
	private JTextField textNom;
	private JTextField textDesc;
	private JTextField textPrec;
	private JTextField textRef;
	private JTextField textCat;
	private JTextField textProv;
	private JTextField textImg;
	private JDesktopPane desktopPane;
	private JButton ButtonImg;
	private Main main;
	
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
	public VerInfoProducto(ISistema sistema, Main main) {
		setResizable(true);
		this.sistema = sistema;
		this.main = main;
		ImageIcon icon = new ImageIcon(AltaDeCategoria.class.getResource("/Images/Flamin-Go.png"));
		Image img = icon.getImage().getScaledInstance(16, 16, Image.SCALE_SMOOTH);
		setFrameIcon(new ImageIcon(img));
		setTitle("Flamin-Go");
		setClosable(true);
		setBounds(100, 100, 436, 560);
		getContentPane().setLayout(null);
		
		JLabel LabelSelectCat = new JLabel("Seleccione una categoría del sistema y luego \"Confirmar\"");
		LabelSelectCat.setHorizontalAlignment(SwingConstants.CENTER);
		LabelSelectCat.setFont(new Font("Tahoma", Font.PLAIN, 13));
		LabelSelectCat.setBounds(0, 11, 420, 14);
		getContentPane().add(LabelSelectCat);
		
		JLabel LabelProd = new JLabel("Seleccione un producto");
		LabelProd.setHorizontalAlignment(SwingConstants.CENTER);
		LabelProd.setFont(new Font("Tahoma", Font.PLAIN, 13));
		LabelProd.setBounds(0, 203, 420, 14);
		getContentPane().add(LabelProd);
		
		this.comboBoxProd = new JComboBox<DTProducto>();
		comboBoxProd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(comboBoxProd.getSelectedItem() == null || comboBoxProd.getSelectedIndex() == -1) {
                    ButtonImg.setEnabled(false);
                    return;
                }
				
				DTProducto producto = (DTProducto) comboBoxProd.getSelectedItem();
				String nombreProducto = producto.getNombre();

					try {
						sistema.elegirProducto(nombreProducto);
						//String ProductoDetallado = sistema.verInformacionProducto().toString();
						String nomDet = sistema.verInformacionProducto().getNombre().toString();
						String descDet = sistema.verInformacionProducto().getDescripcion().toString();
								Float prec = sistema.verInformacionProducto().getPrecio();
						String precDet = Float.toString(prec);
						
						String nickProvDet = sistema.verInformacionProducto().getProveedor().getNickname();
						String mailProvDet = sistema.verInformacionProducto().getProveedor().getEmail();
						String provDet = nickProvDet + " - " + mailProvDet;
						String catDet = sistema.verInformacionProducto().getCategorias().toString();
								Integer num = sistema.verInformacionProducto().getNumReferencia();
						String numDet = Integer.toString(num);
						//String imgDet = sistema.verInformacionProducto().getImagenes().toString();
						
						//List<String> imagenes = sistema.verInformacionProducto().getImagenes();
						
						textNom.setText(nomDet);
						textDesc.setText(descDet);
						textPrec.setText(precDet);
						textProv.setText(provDet);
						textCat.setText(catDet);
						textRef.setText(numDet);
						ButtonImg.setEnabled(true);
						//textImg.setText(imgDet);
						//mostrarImagenesEnInternalFrame(imagenes);						
						//TextDatosProd.setText(ProductoDetallado);
					} catch (ProductoNoExisteException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
		
				
                //////////////ACA////////////////
			}
		});
		comboBoxProd.setBounds(86, 228, 255, 22);
		getContentPane().add(comboBoxProd);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(46, 49, 169, 133);
		getContentPane().add(scrollPane);
		
		
		treeCat = new JTree();
		scrollPane.setViewportView(treeCat);
		cargarJTree();
		//this.treeCat = treeCat;
		
		JButton ButtonConfCat = new JButton("Confirmar\r\n");
		ButtonConfCat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) treeCat.getLastSelectedPathComponent();
                

                if (selectedNode != null && !selectedNode.toString().equals("Categorías")) {
                    String nombreCat = selectedNode.toString();
                    try {
                        sistema.elegirCategoria(nombreCat);
                        // categoriaActual = sistema.getCategoriaActual();
                        // cargarProductosEnComboBox(sistema.getCategoriaActual());
                        cargarProductos();
                    } catch (CategoriaNoExisteException e1) {
                        // MANEJAR ERROR
                    }
                }
			}
		});
		
		ButtonConfCat.setBounds(225, 97, 115, 36);
		getContentPane().add(ButtonConfCat);
		
		JLabel LabelNom = new JLabel("Nombre:");
		LabelNom.setBounds(60, 273, 67, 14);
		getContentPane().add(LabelNom);
		
		JTextField textNom = new JTextField();
		textNom.setEditable(false);
		textNom.setBounds(126, 268, 231, 20);
		getContentPane().add(textNom);
		textNom.setColumns(10);
		this.textNom = textNom;
		
		JLabel labelDesc = new JLabel("Descripción:");
		labelDesc.setBounds(60, 301, 76, 14);
		getContentPane().add(labelDesc);
		
		JTextField textDesc = new JTextField();
		textDesc.setEditable(false);
		textDesc.setColumns(10);
		textDesc.setBounds(135, 298, 222, 42);
		getContentPane().add(textDesc);
		this.textDesc = textDesc;
		
		JLabel labelPrec = new JLabel("Precio:");
		labelPrec.setBounds(60, 354, 67, 14);
		getContentPane().add(labelPrec);
		
		JTextField textPrec = new JTextField();
		textPrec.setEditable(false);
		textPrec.setColumns(10);
		textPrec.setBounds(135, 351, 222, 20);
		getContentPane().add(textPrec);
		this.textPrec = textPrec;
		
		
		JLabel labelRef = new JLabel("N° de Referencia:");
		labelRef.setBounds(60, 385, 115, 14);
		getContentPane().add(labelRef);
		
		JTextField textRef = new JTextField();
		textRef.setEditable(false);
		textRef.setColumns(10);
		textRef.setBounds(169, 382, 188, 20);
		getContentPane().add(textRef);
		this.textRef = textRef;
		
		JLabel labelCat = new JLabel("Categorías:");
		labelCat.setBounds(60, 415, 88, 14);
		getContentPane().add(labelCat);
		
		JTextField textCat = new JTextField();
		textCat.setEditable(false);
		textCat.setColumns(10);
		textCat.setBounds(135, 412, 222, 42);
		getContentPane().add(textCat);
		this.textCat = textCat;
		
		JTextField textProv = new JTextField();
		textProv.setEditable(false);
		textProv.setColumns(10);
		textProv.setBounds(135, 465, 222, 20);
		getContentPane().add(textProv);
		this.textProv = textProv;
		
		JLabel labelProv = new JLabel("Proveedor:");
		labelProv.setBounds(60, 468, 88, 14);
		getContentPane().add(labelProv);
		
		ButtonImg = new JButton("Ver Imágenes");
		ButtonImg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List<String> imagenes = sistema.verInformacionProducto().getImagenes();
				mostrarImagenesEnInternalFrame(imagenes);						

			}
		});
		ButtonImg.setBounds(214, 496, 143, 23);
		getContentPane().add(ButtonImg);
		ButtonImg.setEnabled(false);
		
		
		

	}
	
	/*
	
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
	*/
	
	/*
	// Método para cargar los productos de una categoría en el JComboBox
	private void cargarProductosEnComboBox(Categoria categoriaSeleccionada) {
	    // Limpiar el JComboBox
	    comboBoxProd.removeAllItems();
	    List<DTProducto> lista = sistema.listarProductos();
        if(lista.isEmpty()) {
        	//TextDatosProd.setText("Aquí se mostraran los datos del Producto");
        	textNom.setText("[Nombre del Producto]");
        	textDesc.setText("[Descripción del Producto]");
        	textPrec.setText("[Precio del Producto]");
        	textProv.setText("[Proveedor del Producto]");
        	textCat.setText("[Categorías del Producto]");
        	textRef.setText("[N° de Referencia del Producto]");
        	//textImg.setText("[Imágenes del Producto]");
        }
	    // Verificar si la categoría tiene productos
	    if (categoriaSeleccionada != null && categoriaSeleccionada.getProductos() != null) {
	        // Llenar el JComboBox con los productos de la categoría seleccionada
	        for (DTProducto producto : lista) {
	        	// int codigo = producto.getNumReferencia();
	            comboBoxProd.addItem(producto);

	        }
	    }
	}
	*/
	
	public void limpiarCampos() {
		// Limpiar el JComboBox
	    comboBoxProd.removeAllItems();
    	textNom.setText("[Nombre del Producto]");
    	textDesc.setText("[Descripción del Producto]");
    	textPrec.setText("[Precio del Producto]");
    	textProv.setText("[Proveedor del Producto]");
    	textCat.setText("[Categorías del Producto]");
    	textRef.setText("[N° de Referencia del Producto]");
    	//textImg.setText("[Imágenes del Producto]");
	}
	
	public void cargarJTree() {
		DefaultMutableTreeNode root = new DefaultMutableTreeNode("Categorías");
		
		for (Categoria cat : sistema.getCategorias().values()) {
			this.cargarCategoriaJTree(cat, root); // ROOT SERIA EL NODO RAIZ (PODEMOS PONERLE CATEGORIA NOMAS)
		}
		
		DefaultTreeModel treeModel = new DefaultTreeModel(root);
        this.treeCat.setModel(treeModel);
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
	
	public void cargarProductos() {
		List<DTProducto> lista = null;
		
		try {
			lista = this.sistema.listarProductos();
		} catch (NullPointerException e) {
			throw new NullPointerException (e.getMessage()); // FALTA POPUP DE ERROR
		}
		
		this.comboBoxProd.removeAllItems();
		
		for (DTProducto prod : lista) {
			this.comboBoxProd.addItem(prod);
		}
		this.comboBoxProd.setSelectedIndex(-1);
	}
	
	private void mostrarImagenesEnInternalFrame(List<String> rutasImagenes) {
		
		if (rutasImagenes != null && ! (rutasImagenes.isEmpty())) {

	        boolean hayImagenes = false;
	        
	        // Crear un JPanel para contener las imágenes
	        JPanel panelImagenes = new JPanel();
	        panelImagenes.setLayout(new FlowLayout());
	
	        // Cargar y agregar las imágenes al panel
	        for (String ruta : rutasImagenes) {
	            File archivoImagen = new File(ruta);
	            if (archivoImagen.exists()) {
	                ImageIcon icono = new ImageIcon(ruta);
	                JLabel etiquetaImagen = new JLabel(icono);
	                panelImagenes.add(etiquetaImagen);
	                hayImagenes = true;
	            } else {
	                JOptionPane.showMessageDialog(null, "Archivo no encontrado: " + ruta, "Error", JOptionPane.ERROR_MESSAGE);
	            }
	        }
	        
	        if (hayImagenes) {
	        	// Crear el JInternalFrame
	            JInternalFrame internalFrame = new JInternalFrame("Galería de Imágenes", true, true, true, true);
	            internalFrame.setSize(600, 400);
	            internalFrame.getContentPane().setLayout(new BorderLayout());
	            
	            // Añadir el panel al JInternalFrame
	            JScrollPane scrollPane = new JScrollPane(panelImagenes);
	            internalFrame.getContentPane().add(scrollPane, BorderLayout.CENTER);
	
	            // Añadir el JInternalFrame al JDesktopPane
	            this.main.getMenuPrincipal().getContentPane().add(internalFrame);
	            internalFrame.setVisible(true);
	            
	        } else {
	        	// MOSTRAR ERROR
	        }
        
		} else {
			// MOSTRAR ERROR
		}
    }
}


