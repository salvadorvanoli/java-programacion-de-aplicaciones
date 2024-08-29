package interfaces;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;

import clases.ISistema;
import excepciones.ProductoNoExisteException;
import excepciones.UsuarioNoExisteException;

import javax.swing.JTextArea;
import javax.swing.ImageIcon;
import javax.swing.JTree;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.JFileChooser;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.awt.event.ActionEvent;

import excepciones.CategoriaNoExisteException;

//Importamos clases del package "clases"

import clases.DTCliente;
import clases.DTProducto;
import clases.DTProductoDetallado;
import clases.Categoria;

import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;

public class ModificarDatosProducto extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private ISistema sistema;
	private Main menu;
	private JTree JTreeSeleccionCategoriaPadre;
	private JComboBox<DTProducto> seleccionProducto;
	private JTextField textFieldNombre;
	private JTextField textFieldNumReferencia;
	private JTextField textFieldPrecio;
	private JTextArea textAreaDescripcion;
	private JTextArea textAreaEspecificacion;

	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModificarDatosProducto frame = new ModificarDatosProducto();
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
	public ModificarDatosProducto(ISistema sistema, Main menu) {
		setFrameIcon(new ImageIcon(ModificarDatosProducto.class.getResource("/Images/Flamin-Go.png")));
		setTitle("Flamin-Go");
		setClosable(true);
		setBounds(100, 100, 636, 666);
		getContentPane().setLayout(null);
		
		this.sistema = sistema;
		this.menu = menu;
		
		JLabel lblTitulo = new JLabel("Modificar datos de un Producto");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTitulo.setBounds(10, 11, 537, 29);
		getContentPane().add(lblTitulo);
		
		JLabel labelSeleccionCategoria = new JLabel("Selecciona una de las categorías listadas debajo *");
		labelSeleccionCategoria.setHorizontalAlignment(SwingConstants.CENTER);
		labelSeleccionCategoria.setBounds(20, 54, 304, 28);
		getContentPane().add(labelSeleccionCategoria);
		
		JTree treeCategorias = new JTree();
		treeCategorias.addTreeSelectionListener(new TreeSelectionListener() {
			@Override
			public void valueChanged(TreeSelectionEvent e) {
				System.out.println("GOLALDASLDASDAS");
				DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) treeCategorias.getLastSelectedPathComponent(); // Consigo el elemento del JTree seleccionado por el usuario
                if (selectedNode == null) {
                	// ERROR CON POPUP
                }
                System.out.println("2222222222222222");
                try {
                	System.out.println(selectedNode.toString());
                	sistema.elegirCategoria(selectedNode.toString());
                	cargarProductos();
                	System.out.println("333333333333");
                } catch (CategoriaNoExisteException e1) {
                	
                }
                
			}
		});
		treeCategorias.setBounds(53, 93, 240, 171);
		getContentPane().add(treeCategorias);
		
		this.JTreeSeleccionCategoriaPadre = treeCategorias;
		
		cargarJTree();
		
		JLabel labelSeleccionProducto = new JLabel("Selecciona uno de los productos de la lista *");
		labelSeleccionProducto.setHorizontalAlignment(SwingConstants.CENTER);
		labelSeleccionProducto.setBounds(303, 116, 304, 28);
		getContentPane().add(labelSeleccionProducto);
		
		JComboBox<DTProducto> seleccionProducto = new JComboBox<DTProducto>();
		seleccionProducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DTProducto seleccionado = (DTProducto) seleccionProducto.getSelectedItem(); // TENEMOS QUE INCLUIR EL NUMERO DE REFERENCIA EN DTPRODUCTO
                if (seleccionado != null) {
                    String nombre = seleccionado.getNombre();
                    // String numReferencia = seleccionado.getNumReferencia();
                    try {
                        sistema.elegirProducto(nombre/*, numReferencia*/);
                        DTProductoDetallado prodDetallado = sistema.verInformacionProducto();
                        textFieldNombre.setText(prodDetallado.getNombre());
                        textFieldNumReferencia.setText(String.valueOf(prodDetallado.getNumReferencia()));
                        textFieldPrecio.setText(String.valueOf(prodDetallado.getPrecio()));
                        textAreaDescripcion.setText(prodDetallado.getDescripcion());
                        textAreaEspecificacion.setText(prodDetallado.getEspecificaciones());
                    } catch (ProductoNoExisteException e1) {
                        // CREAR UNA VENTANA DE ERROR
                    }
                } else {
                    // CREAR UNA VENTANA DE ERROR
                }
			}
		});
		seleccionProducto.setBounds(315, 167, 283, 28);
		getContentPane().add(seleccionProducto);
		
		this.seleccionProducto = seleccionProducto;
		
		JLabel labelDatosAModificar = new JLabel("A continuación, modifica los datos a tu elección");
		labelDatosAModificar.setHorizontalAlignment(SwingConstants.CENTER);
		labelDatosAModificar.setBounds(10, 293, 600, 28);
		getContentPane().add(labelDatosAModificar);
		
		JLabel labelNuevoNombreProducto = new JLabel("Nombre");
		labelNuevoNombreProducto.setBounds(40, 332, 87, 28);
		getContentPane().add(labelNuevoNombreProducto);
		
		JTextField textFieldNombre = new JTextField();
		textFieldNombre.setColumns(10);
		textFieldNombre.setBounds(138, 336, 129, 20);
		getContentPane().add(textFieldNombre);
		
		this.textFieldNombre = textFieldNombre;
		
		JLabel labelNuevoNumReferenciaProducto = new JLabel("Num. Referencia");
		labelNuevoNumReferenciaProducto.setBounds(40, 371, 100, 28);
		getContentPane().add(labelNuevoNumReferenciaProducto);
		
		JTextField textFieldNumReferencia = new JTextField();
		textFieldNumReferencia.setColumns(10);
		textFieldNumReferencia.setBounds(138, 375, 129, 20);
		getContentPane().add(textFieldNumReferencia);
		
		this.textFieldNumReferencia = textFieldNumReferencia;
		
		JLabel labelNuevoPrecioProducto = new JLabel("Precio");
		labelNuevoPrecioProducto.setBounds(40, 410, 87, 28);
		getContentPane().add(labelNuevoPrecioProducto);
		
		JTextField textFieldPrecio = new JTextField();
		textFieldPrecio.setColumns(10);
		textFieldPrecio.setBounds(138, 414, 129, 20);
		getContentPane().add(textFieldPrecio);
		
		this.textFieldPrecio = textFieldPrecio;
		
		JLabel labelNuevaDescripcionProducto = new JLabel("Descripción");
		labelNuevaDescripcionProducto.setBounds(301, 332, 100, 28);
		getContentPane().add(labelNuevaDescripcionProducto);
		
		JTextArea textAreaDescripcion = new JTextArea();
		textAreaDescripcion.setColumns(10);
		textAreaDescripcion.setBounds(388, 334, 189, 62);
		getContentPane().add(textAreaDescripcion);
		
		this.textAreaDescripcion = textAreaDescripcion;
		
		JLabel labelNuevaEspecificacionProducto = new JLabel("Especificación");
		labelNuevaEspecificacionProducto.setBounds(301, 410, 100, 28);
		getContentPane().add(labelNuevaEspecificacionProducto);
		
		JTextArea textAreaEspecificacion = new JTextArea();
		textAreaEspecificacion.setColumns(10);
		textAreaEspecificacion.setBounds(388, 412, 189, 63);
		getContentPane().add(textAreaEspecificacion);
		
		this.textAreaEspecificacion = textAreaEspecificacion;
		
		JButton btnNuevasCategoiras = new JButton("Elegir nuevas Categorías");
		btnNuevasCategoiras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// infoClienteInternalFrame.toBack();
				menu.getMenuPrincipal().getContentPane().add(menu.getModificarCategoriasProductoInternalFrame());
				// infoOrdenInternalFrame.toFront(); // Traigo el internal frame al frente
				menu.getModificarCategoriasProductoInternalFrame().setVisible(true);
				menu.getModificarCategoriasProductoInternalFrame().setLocation(0, 0);  // Ajustar la posición del InternalFrame
				menu.getMenuPrincipal().revalidate();
				menu.getMenuPrincipal().repaint();
			}
		});
		btnNuevasCategoiras.setBounds(78, 507, 189, 28);
		getContentPane().add(btnNuevasCategoiras);
		
		JButton btnNuevasImagenes = new JButton("Elegir nuevas Imágenes");
		btnNuevasImagenes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// infoClienteInternalFrame.toBack();
				menu.getMenuPrincipal().getContentPane().add(menu.getModificarImagenesProductoInternalFrame());
				// infoOrdenInternalFrame.toFront(); // Traigo el internal frame al frente
				menu.getModificarImagenesProductoInternalFrame().setVisible(true);
				menu.getModificarImagenesProductoInternalFrame().setLocation(0, 0);  // Ajustar la posición del InternalFrame
				menu.getMenuPrincipal().revalidate();
				menu.getMenuPrincipal().repaint();
			}
		});
		btnNuevasImagenes.setBounds(331, 507, 189, 28);
		getContentPane().add(btnNuevasImagenes);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(249, 580, 100, 29);
		getContentPane().add(btnAceptar);
		
		this.addInternalFrameListener(new InternalFrameAdapter() {
            @Override
            public void internalFrameClosing(InternalFrameEvent e) {
            	sistema.setTodoNull();
            	dispose();
            }
        });


	}
	
	
	private void cargarJTree() {
        // Vaciar el JTree
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("Categorías");

        HashMap<String, Categoria> categorias = sistema.getCategorias();

        if (categorias == null || categorias.isEmpty()) {
            // MOSTRAR POPUP DE ERROR
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
        this.JTreeSeleccionCategoriaPadre.setModel(treeModel);
    }

	/*
    @Override
    public void setVisible(boolean visible) {
        super.setVisible(visible);
        if (visible) {
            cargarDatos(); // Usar la variable de instancia
        } else {
            limpiarCampos();
        }
    }
    */

    private void limpiarCampos() {
        this.seleccionProducto.removeAllItems();
        
        if (this.JTreeSeleccionCategoriaPadre != null) {
            // Vaciar el JTree
            this.JTreeSeleccionCategoriaPadre.setModel(new DefaultTreeModel(new DefaultMutableTreeNode("Categorías")));
        }
    }
    
    public void cargarProductos() {
		List<DTProducto> lista = null;
		
		try {
			lista = this.sistema.listarProductos();
		} catch (NullPointerException e) {
			throw new NullPointerException (e.getMessage()); // FALTA POPUP DE ERROR
		}
		
		this.seleccionProducto.removeAllItems();
		
		for (DTProducto prod : lista) {
			this.seleccionProducto.addItem(prod);
		}
		
	}
	
	
}
