package interfaces;

import java.awt.BorderLayout;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

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


public class VerInfoProducto extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private JTree treeCat;
	private JComboBox<String> comboBoxProd;
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
		//hola
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
				
				if(comboBoxProd.getSelectedItem() == null) {
					return;
				}
				
				String nombreProducto = (String) comboBoxProd.getSelectedItem();
				System.out.println(nombreProducto);

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
						
						List<String> imagenes = sistema.verInformacionProducto().getImagenes();
						
						textNom.setText(nomDet);
						textDesc.setText(descDet);
						textPrec.setText(precDet);
						textProv.setText(provDet);
						textCat.setText(catDet);
						textRef.setText(numDet);
						//textImg.setText(imgDet);
						mostrarImagenesEnInternalFrame(imagenes);						
						//TextDatosProd.setText(ProductoDetallado);
					} catch (ProductoNoExisteException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
		
				
                //////////////ACA////////////////
			}
		});
		comboBoxProd.setBounds(30, 160, 255, 22);
		getContentPane().add(comboBoxProd);
		
		
		treeCat = new JTree();
		cargarDatos();
		treeCat.setBounds(51, 46, 143, 78);
		getContentPane().add(treeCat);
		//this.treeCat = treeCat;
		
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
                        cargarProductosEnComboBox(sistema.getCategoriaActual());
                    } catch (CategoriaNoExisteException e1) {
                        // MANEJAR ERROR
                    }
                }
			}
		});
		
		ButtonConfCat.setBounds(225, 67, 88, 36);
		getContentPane().add(ButtonConfCat);
		
		JLabel LabelNom = new JLabel("Nombre:");
		LabelNom.setBounds(30, 198, 48, 14);
		getContentPane().add(LabelNom);
		
		textNom = new JTextField();
		textNom.setBounds(88, 193, 197, 20);
		getContentPane().add(textNom);
		textNom.setColumns(10);
		this.textNom = textNom;
		
		JLabel labelDesc = new JLabel("Descripción:");
		labelDesc.setBounds(30, 226, 60, 14);
		getContentPane().add(labelDesc);
		
		textDesc = new JTextField();
		textDesc.setColumns(10);
		textDesc.setBounds(97, 223, 188, 42);
		getContentPane().add(textDesc);
		this.textDesc = textDesc;
		
		JLabel labelPrec = new JLabel("Precio:");
		labelPrec.setBounds(30, 279, 60, 14);
		getContentPane().add(labelPrec);
		
		textPrec = new JTextField();
		textPrec.setColumns(10);
		textPrec.setBounds(97, 276, 88, 20);
		getContentPane().add(textPrec);
		this.textPrec = textPrec;
		
		
		JLabel labelRef = new JLabel("N° de Referencia:");
		labelRef.setBounds(30, 310, 91, 14);
		getContentPane().add(labelRef);
		
		textRef = new JTextField();
		textRef.setColumns(10);
		textRef.setBounds(131, 307, 154, 20);
		getContentPane().add(textRef);
		this.textRef = textRef;
		
		JLabel labelCat = new JLabel("Categorías:");
		labelCat.setBounds(30, 340, 60, 14);
		getContentPane().add(labelCat);
		
		textCat = new JTextField();
		textCat.setColumns(10);
		textCat.setBounds(97, 337, 188, 42);
		getContentPane().add(textCat);
		this.textCat = textCat;
		
		textProv = new JTextField();
		textProv.setColumns(10);
		textProv.setBounds(97, 390, 188, 20);
		getContentPane().add(textProv);
		this.textProv = textProv;
		
		JLabel labelProv = new JLabel("Proveedor:");
		labelProv.setBounds(30, 393, 60, 14);
		getContentPane().add(labelProv);
		

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
	        	String nombre = producto.getNombre();
	        	//int codigo = producto.getNumReferencia();
	            comboBoxProd.addItem(nombre);

	        }
	    }
	}
	
	private void mostrarImagenesEnInternalFrame(List<String> rutasImagenes) {
        // Crear el JInternalFrame
        JInternalFrame internalFrame = new JInternalFrame("Galería de Imágenes", true, true, true, true);
        internalFrame.setSize(600, 400);
        internalFrame.getContentPane().setLayout(new BorderLayout());

        // Crear un JPanel para contener las imágenes
        JPanel panelImagenes = new JPanel();
        panelImagenes.setLayout(new FlowLayout());

        // Rutas de las imágenes (debes modificar las rutas según tu caso)
       

        // Cargar y agregar las imágenes al panel
        for (String ruta : rutasImagenes) {
            File archivoImagen = new File(ruta);
            if (archivoImagen.exists()) {
                ImageIcon icono = new ImageIcon(ruta);
                JLabel etiquetaImagen = new JLabel(icono);
                panelImagenes.add(etiquetaImagen);
            } else {
                System.out.println("Archivo no encontrado: " + ruta);
            }
        }

        // Añadir el panel al JInternalFrame
        JScrollPane scrollPane = new JScrollPane(panelImagenes);
        internalFrame.getContentPane().add(scrollPane, BorderLayout.CENTER);

        // Añadir el JInternalFrame al JDesktopPane
        this.main.getMenuPrincipal().getContentPane().add(internalFrame);
        internalFrame.setVisible(true);
    }
}


