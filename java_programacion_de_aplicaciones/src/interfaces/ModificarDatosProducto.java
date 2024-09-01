package interfaces;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;

import clases.ISistema;
import clases.Producto;
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
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
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
	private JTextArea textAreaCategorias;
	//private JTextArea textAreaImagenes;
	private JButton btnNuevasImagenes;
	private JButton btnNuevasCategorias;
	private JButton btnAceptar;
	private String textoCategoriasOriginal;
	// private String textoImagenesOriginal;
	private JButton btnVerImagenes;
	private JInternalFrame vistaImagenes;
	
	private List<Categoria> nuevasCategorias;
	private List<String> nuevasImagenes;
	
	public void setNuevasCategorias(List<Categoria> nuevasCategorias) {
		this.nuevasCategorias = nuevasCategorias;
	}
	
	public void setTextAreaCategorias(String text) {
		this.textAreaCategorias.setText(text);
	}
	
	public String getTextAreaCategorias() {
		return this.textAreaCategorias.getText();
	}
	
	public void alternarCampos(boolean habilitar) {
		this.textFieldNombre.setEnabled(habilitar);
		this.textFieldNumReferencia.setEnabled(habilitar);
		this.textFieldPrecio.setEnabled(habilitar);
		this.textAreaDescripcion.setEnabled(habilitar);
		this.textAreaEspecificacion.setEnabled(habilitar);
		this.textAreaCategorias.setEnabled(habilitar);
		//this.textAreaImagenes.setEnabled(habilitar);
		this.btnNuevasImagenes.setEnabled(habilitar);
		this.btnNuevasCategorias.setEnabled(habilitar);
		this.btnAceptar.setEnabled(habilitar);
		this.btnVerImagenes.setEnabled(habilitar);
	}
	
	private void limpiarCampos() {
		this.JTreeSeleccionCategoriaPadre.setSelectionRow(-1);
		this.seleccionProducto.setSelectedIndex(-1);
		this.textFieldNombre.setText("");
		this.textFieldNumReferencia.setText("");
		this.textFieldPrecio.setText("");
		this.textAreaDescripcion.setText("");
		this.textAreaEspecificacion.setText("");
		this.textAreaCategorias.setText("");
		//this.textAreaImagenes.setText("");
		this.nuevasCategorias = new ArrayList<>();
		this.nuevasImagenes = new ArrayList<>();
	}
	
	public void limpiarListaProductos() {
		this.seleccionProducto.removeAllItems();
	}
	
	private boolean camposCompletos() {
		return ! (this.textFieldNombre.getText().isBlank() || this.textFieldNombre.getText().isEmpty()) &&
				! (this.textFieldNumReferencia.getText().isBlank() || this.textFieldNumReferencia.getText().isEmpty()) &&
				! (this.textFieldPrecio.getText().isBlank() || this.textFieldPrecio.getText().isEmpty()) &&
				! (this.textAreaDescripcion.getText().isBlank() || this.textAreaDescripcion.getText().isEmpty()) &&
				! (this.textAreaEspecificacion.getText().isBlank() || this.textAreaEspecificacion.getText().isEmpty());
	}
	
	private boolean checkNumReferencia() {
		try {
			int numReferencia = Integer.valueOf(this.textFieldNumReferencia.getText());
			return numReferencia > 0;
		} catch (NumberFormatException e) {
			return false;
		}
	}
	
	private boolean checkPrecio() {
		try {
			float precio = Float.valueOf(this.textFieldPrecio.getText());
			return precio > 0;
		} catch (NumberFormatException e) {
			return false;
		}
	}
	
	
	private void camposValidos() {
		if (!this.camposCompletos()) {
			throw new IllegalStateException("Aún hay campos vacíos.");
		}
		if (!this.checkNumReferencia()) {
			throw new NumberFormatException("El número de referencia debe ser un valor entero positivo.");
		}
		if (!this.checkPrecio()) {
			throw new NumberFormatException("El precio debe ser un valor entero (o decimal) mayor que 0.");
		}
	}

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
		setBounds(100, 100, 638, 725);
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
				if (treeCategorias.getSelectionRows().length > 0 && treeCategorias.getSelectionRows()[0] > 0) {
					DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) treeCategorias.getLastSelectedPathComponent(); // Consigo el elemento del JTree seleccionado por el usuario
	                if (selectedNode == null) {
	                	JOptionPane.showMessageDialog(null, "Ninguna categoría fue seleccionada", "Error", JOptionPane.ERROR_MESSAGE);
	                } else {
	                	Object node = selectedNode.getUserObject();
	                	if (node instanceof Categoria) {
			                try {
			                	sistema.elegirCategoria(selectedNode.toString());
			                	cargarProductos();
			                } catch (CategoriaNoExisteException exc) {
			                	JOptionPane.showMessageDialog(null, exc.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			                }
	                	} else {
	                		//bt
	                	}
	                }
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
                	alternarCampos(true);
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
                        textAreaCategorias.setText("");
                        for (String cat : prodDetallado.getCategorias()) {
                        	textAreaCategorias.setText(textAreaCategorias.getText() + cat + System.lineSeparator());
                        }
                        // textAreaImagenes.setText("");
                        nuevasImagenes = prodDetallado.getImagenes();
                        /*
                        for (String image : prodDetallado.getImagenes()) {
                        	nuevasImagenes.add(image);
                        	// textAreaImagenes.setText(textAreaImagenes.getText() + image + System.lineSeparator());
                        }
                        */
                        textoCategoriasOriginal = textAreaCategorias.getText();
                        // textoImagenesOriginal = textAreaImagenes.getText();
                    } catch (ProductoNoExisteException exc) {
                    	JOptionPane.showMessageDialog(null, exc.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                	limpiarCampos();
                	alternarCampos(false);
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
		
		JButton btnNuevasCategorias = new JButton("Elegir nuevas Categorías");
		btnNuevasCategorias.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// infoClienteInternalFrame.toBack();
				menu.getModificarCategoriasProductoInternalFrame().cargarJTree();
				menu.getMenuPrincipal().getContentPane().add(menu.getModificarCategoriasProductoInternalFrame());
				// infoOrdenInternalFrame.toFront(); // Traigo el internal frame al frente
				menu.getModificarCategoriasProductoInternalFrame().setVisible(true);
				menu.getModificarCategoriasProductoInternalFrame().setLocation(0, 0);  // Ajustar la posición del InternalFrame
				menu.getMenuPrincipal().revalidate();
				menu.getMenuPrincipal().repaint();
			}
		});
		btnNuevasCategorias.setBounds(40, 507, 189, 28);
		getContentPane().add(btnNuevasCategorias);
		
		this.btnNuevasCategorias = btnNuevasCategorias;
		
		JButton btnNuevasImagenes = new JButton("Elegir nuevas Imágenes");
		btnNuevasImagenes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// Crear un JFileChooser
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setMultiSelectionEnabled(true); // Permitir seleccionar múltiples archivos
                fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY); // Solo archivos, no directorios

                // Filtro para permitir solo imágenes
                FileNameExtensionFilter imageFilter = new FileNameExtensionFilter("Archivos de Imagen (JPG, PNG)", "jpg", "jpeg", "png");
                fileChooser.setFileFilter(imageFilter); // Establecer el filtro
                fileChooser.setAcceptAllFileFilterUsed(false);

                // Mostrar el diálogo de selección de archivos
                int result = fileChooser.showOpenDialog(menu.getMenuPrincipal());
                
                if (result == JFileChooser.APPROVE_OPTION) {
                    // Obtener los archivos seleccionados
                    File[] selectedFiles = fileChooser.getSelectedFiles();
                    
                    // String textImagenesAnt = textAreaImagenes.getText();
                    // textAreaImagenes.setText("");

                    List<String> rutasImagenes = new ArrayList<>();
                    // Mostrar los archivos seleccionados en la consola
                    for (File file : selectedFiles) {
                    	if (imageFilter.accept(file)) {
                    		rutasImagenes.add(file.getAbsolutePath());
                    		//textAreaImagenes.setText(textAreaImagenes.getText() + file.getAbsolutePath() + System.lineSeparator());
                    	} else {
                    		rutasImagenes.clear();
                    		//textAreaImagenes.setText(textImagenesAnt);
        		            JOptionPane.showMessageDialog(null, "Un archivo elegido no coincide con el tipo aceptado (jpg, jpeg o png).", "Error", JOptionPane.ERROR_MESSAGE);
        		            break;
                    	}
                    }
                    if (!(rutasImagenes.isEmpty())){
                    	nuevasImagenes = rutasImagenes;
                    	// textoImagenesOriginal = textAreaImagenes.getText();
                    } /*else {
                    	textAreaImagenes.setText(textImagenesAnt);
                    }*/
                } /* else {
                	
                	JOptionPane.showMessageDialog(null, "Se eligieron archivos no válidos", "Error", JOptionPane.ERROR_MESSAGE);
                }*/

				
				
				
				
				
				
				
				/*
				// infoClienteInternalFrame.toBack();
				menu.getMenuPrincipal().getContentPane().add(menu.getModificarImagenesProductoInternalFrame());
				// infoOrdenInternalFrame.toFront(); // Traigo el internal frame al frente
				menu.getModificarImagenesProductoInternalFrame().setVisible(true);
				menu.getModificarImagenesProductoInternalFrame().setLocation(0, 0);  // Ajustar la posición del InternalFrame
				menu.getMenuPrincipal().revalidate();
				menu.getMenuPrincipal().repaint();
				*/
			}
		});
		btnNuevasImagenes.setBounds(388, 507, 189, 28);
		getContentPane().add(btnNuevasImagenes);
		
		this.btnNuevasImagenes = btnNuevasImagenes;
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					camposValidos();
					String nombreProd = textFieldNombre.getText().trim();
					int numReferencia = Integer.valueOf(textFieldNumReferencia.getText().trim());
					float precio = Float.valueOf(textFieldPrecio.getText().trim());
					String descripcion = textAreaDescripcion.getText().trim();
					String especificacion = textAreaEspecificacion.getText().trim();
					sistema.modificarDatosProducto(nombreProd, numReferencia, descripcion, precio, especificacion);
					sistema.modificarImagenesProducto(nuevasImagenes);
					boolean sePuedenModificarCategorias = (nuevasCategorias != null && ! (nuevasCategorias.isEmpty()));
					sistema.quitarProductoDeCategorias(sePuedenModificarCategorias);
					sistema.agregarCategoriasAProducto(nuevasCategorias);
					sistema.agregarProductoACategorias(nuevasCategorias);
			        JOptionPane.showMessageDialog(null, "Orden realizada con éxito", "Éxito", JOptionPane.INFORMATION_MESSAGE);
			        cargarProductos();
				} catch (Exception exc) {
		            JOptionPane.showMessageDialog(null, exc.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		btnAceptar.setBounds(256, 643, 100, 29);
		getContentPane().add(btnAceptar);
		
		this.btnAceptar = btnAceptar;
		
		JTextArea textAreaCategorias = new JTextArea();
		textAreaCategorias.setEditable(false);
		textAreaCategorias.setBounds(40, 546, 189, 101);
		getContentPane().add(textAreaCategorias);
		
		this.textAreaCategorias = textAreaCategorias;
		
		/*
		JTextArea textAreaImagenes = new JTextArea();
		textAreaImagenes.setEditable(false);
		textAreaImagenes.setBounds(388, 546, 189, 101);
		getContentPane().add(textAreaImagenes);
		
		 this.textAreaImagenes = textAreaImagenes;
		*/
		
		JButton btnVerImagenes = new JButton("Ver Imagenes");
		btnVerImagenes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (nuevasImagenes != null && ! (nuevasImagenes.isEmpty())) {
					// Crear el JInternalFrame
					vistaImagenes = new JInternalFrame("Galería de Imágenes", true, true, true, true);
					vistaImagenes.setSize(600, 400);
					vistaImagenes.getContentPane().setLayout(new BorderLayout());

			        // Crear un JPanel para contener las imágenes
			        JPanel panelImagenes = new JPanel();
			        panelImagenes.setLayout(new FlowLayout());

			        // Cargar y agregar las imágenes al panel
			        for (String ruta : nuevasImagenes) {
			            File archivoImagen = new File(ruta);
			            if (archivoImagen.exists()) {
			                ImageIcon icono = new ImageIcon(ruta);
			                JLabel etiquetaImagen = new JLabel(icono);
			                panelImagenes.add(etiquetaImagen);
			            } else {
        		            JOptionPane.showMessageDialog(null, "Archivo no encontrado: " + ruta, "Error", JOptionPane.ERROR_MESSAGE);
			            }
			        }

			        // Añadir el panel al JInternalFrame
			        JScrollPane scrollPane = new JScrollPane(panelImagenes);
			        vistaImagenes.getContentPane().add(scrollPane, BorderLayout.CENTER);

			        // Añadir el JInternalFrame al JDesktopPane
			        menu.getMenuPrincipal().getContentPane().add(vistaImagenes);
			        vistaImagenes.setVisible(true);
				} else {
	            	JOptionPane.showMessageDialog(null, "El producto actual no posee imágenes y las mismas no han sido seleccionadas", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnVerImagenes.setBounds(418, 576, 129, 28);
		getContentPane().add(btnVerImagenes);
		
		this.btnVerImagenes = btnVerImagenes;
		
		alternarCampos(false);

		this.addInternalFrameListener(new InternalFrameAdapter() {
            @Override
            public void internalFrameClosing(InternalFrameEvent e) {
            	sistema.setTodoNull();
            	limpiarCampos();
            	JTreeSeleccionCategoriaPadre.setSelectionRow(-1);
            	dispose();
            }
        });


	}
	
	public void cargarJTree() {
		DefaultMutableTreeNode root = new DefaultMutableTreeNode("Categorías");
		
		for (Categoria cat : sistema.getCategorias().values()) {
			this.cargarCategoriaJTree(cat, root); // ROOT SERIA EL NODO RAIZ (PODEMOS PONERLE CATEGORIA NOMAS)
		}
		
		DefaultTreeModel treeModel = new DefaultTreeModel(root);
        this.JTreeSeleccionCategoriaPadre.setModel(treeModel);
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

	/*
    private void limpiarCampos() {
        this.seleccionProducto.removeAllItems();
        
        if (this.JTreeSeleccionCategoriaPadre != null) {
            // Vaciar el JTree
            this.JTreeSeleccionCategoriaPadre.setModel(new DefaultTreeModel(new DefaultMutableTreeNode("Categorías")));
        }
    }
    */
    
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
