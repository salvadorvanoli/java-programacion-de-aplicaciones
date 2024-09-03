package interfaces;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

import clases.Categoria;
import clases.DTProducto;
import clases.DTProveedor;
import clases.ISistema;
import excepciones.CategoriaNoExisteException;
import excepciones.ProductoRepetidoException;
import excepciones.UsuarioNoExisteException;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTree;


@SuppressWarnings("unused")
public class RegistrarProducto extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private JTextField campoNumRef;
	private JTree JTreeSeleccionCategoriaPadre;
	private ISistema sistema;
	private JComboBox <DTProveedor> boxProveedor;
	private JTextField campoNombre;
	private JTextField campoEspecificacion;
	private JTextArea campoDescripcion;
	private JTextField campoPrecio;
	private JTree treeCategorias;
	private List<Categoria> Categorias;
	private List<String> Imagenes;
	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistrarProducto frame = new RegistrarProducto();
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
	
	
	public List<Categoria> listaCategorias() {
		return this.Categorias;
	}
	
	public List<String> listaImagenes() {
		return this.Imagenes;
	}
	
	public void cargarImagen(String a){
		this.Imagenes.add(a);
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
	
	
	
	public void limpiarCampos() {
		this.boxProveedor.setSelectedIndex(-1);
		this.JTreeSeleccionCategoriaPadre.setSelectionRow(-1);
		this.campoNombre.setText("");
		this.campoNumRef.setText("");
		this.campoPrecio.setText("");
		this.campoDescripcion.setText("");
		this.campoEspecificacion.setText("");
		this.Categorias = new ArrayList<>();
		this.Imagenes = new ArrayList<>();
	}
	
	private boolean camposCompletos() {
		return ! (this.campoNombre.getText().isBlank() || this.campoNombre.getText().isEmpty()) &&
				! (this.campoEspecificacion.getText().isBlank() || this.campoEspecificacion.getText().isEmpty()) &&
				! (this.campoPrecio.getText().isBlank() || this.campoPrecio.getText().isEmpty()) &&
				! (this.campoDescripcion.getText().isBlank() || this.campoDescripcion.getText().isEmpty()) &&
				! (this.campoNumRef.getText().isBlank() || this.campoNumRef.getText().isEmpty()) &&
				! (boxProveedor.getSelectedIndex() == -1 || boxProveedor.getSelectedItem() == null) &&
				! (treeCategorias.getSelectionPath() == null);
	}
	
	private boolean checkNumReferencia() {
		try {
			int numReferencia = Integer.valueOf(this.campoNumRef.getText());
			return numReferencia > 0;
		} catch (NumberFormatException e) {
			return false;
		}
	}
	
	private boolean checkPrecio() {
		try {
			float precio = Float.valueOf(this.campoPrecio.getText());
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
	
	
	public void mostrarInformacion() {
	    JOptionPane.showMessageDialog(
	        this,                          // 'this' se refiere al componente actual, usa null si no tienes un componente padre específico
	        "Todo ha salido bien.",        // El mensaje de información
	        "Éxito",                       // El título de la ventana
	        JOptionPane.INFORMATION_MESSAGE // El tipo de mensaje (en este caso, un mensaje de información)
	    );
	}
		
	public RegistrarProducto(ISistema sistema) {
		this.sistema = sistema;
		getContentPane().setBackground(new Color(240, 240, 240));
		setClosable(true);
		setBackground(new Color(255, 192, 203));
		setFrameIcon(new ImageIcon(RegistrarProducto.class.getResource("/Images/Flamin-Go.png")));
		setTitle("Flamin-Go\r\n");
		setBounds(100, 100, 514, 328);
		getContentPane().setLayout(null);
		
		JTextField campoNombre = new JTextField();
		campoNombre.setColumns(10);
		campoNombre.setBounds(42, 50, 86, 20);
		getContentPane().add(campoNombre);
		
		this.campoNombre = campoNombre;
		
		JLabel TextoNombre = new JLabel("* Nombre ");
		TextoNombre.setBounds(42, 36, 86, 14);
		getContentPane().add(TextoNombre);
	
		JLabel TextoEspecificacion = new JLabel("* Especificación");
		TextoEspecificacion.setBounds(149, 36, 109, 14);
		getContentPane().add(TextoEspecificacion);
		
		JTextField campoEspecificacion = new JTextField();
		campoEspecificacion.setColumns(10);
		campoEspecificacion.setBounds(150, 50, 86, 20);
		getContentPane().add(campoEspecificacion);
		
		this.campoEspecificacion = campoEspecificacion;
		
		JTextArea campoDescripcion = new JTextArea();
		campoDescripcion.setBounds(42, 100, 194, 77);
		getContentPane().add(campoDescripcion);
		
		this.campoDescripcion = campoDescripcion;
		
		JLabel TextoDescripcion = new JLabel("* Descripción");
		TextoDescripcion.setBounds(42, 86, 148, 14);
		getContentPane().add(TextoDescripcion);
		
		JLabel TextoPrecio = new JLabel("* Precio ");
		TextoPrecio.setBounds(42, 188, 60, 14);
		getContentPane().add(TextoPrecio);
		
		JTextField campoPrecio = new JTextField();
		campoPrecio.setColumns(10);
		campoPrecio.setBounds(42, 202, 79, 20);
		getContentPane().add(campoPrecio);
		
		this.campoPrecio = campoPrecio;
		
		JLabel TextoImagen = new JLabel("Imagen");
		TextoImagen.setBounds(150, 188, 78, 14);
		getContentPane().add(TextoImagen);
		
		JButton BotonSeleccionImagen = new JButton("Seleccion...");
		BotonSeleccionImagen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setDialogTitle("Selecciona una imagen");
                fileChooser.setFileFilter(new javax.swing.filechooser.FileFilter() {
                    @Override
                    public boolean accept(File file) {
                        String[] validExtensions = { "jpg", "jpeg", "png"};
                        for (String ext : validExtensions) {
                            if (file.isFile() && file.getName().toLowerCase().endsWith(ext)) {
                            	cargarImagen(file.getPath());
                                return true;
                            }
                        }
                        return file.isDirectory();
                    }

                    @Override
                    public String getDescription() {
                        return "Archivos de imagen (*.jpg, *.jpeg, *.png)";
                    }
                });

                int returnValue = fileChooser.showOpenDialog(null);
                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    JOptionPane.showMessageDialog(null, "Seleccionaste: " + selectedFile.getAbsolutePath());
                }
            }
        });
		
		BotonSeleccionImagen.setFont(new Font("Tahoma", Font.PLAIN, 10));
		BotonSeleccionImagen.setBounds(150, 201, 86, 23);
		getContentPane().add(BotonSeleccionImagen);
		
		JLabel TextoTitulo = new JLabel("Registrar Producto");
		TextoTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		TextoTitulo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		TextoTitulo.setBounds(0, 0, 498, 29);
		getContentPane().add(TextoTitulo);
		
		JLabel TextoProveedor = new JLabel("* Seleccione un proveedor:");
		TextoProveedor.setBounds(268, 188, 183, 14);
		getContentPane().add(TextoProveedor);
		
		JLabel TextoCategoria = new JLabel("*Selecciona una categoria");
		TextoCategoria.setBounds(268, 36, 183, 14);
		getContentPane().add(TextoCategoria);
		
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
			                	Categoria cat = (Categoria) node;
			                	sistema.elegirCategoria(cat.getNombreCat());
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
		treeCategorias.setBounds(268, 50, 194, 118);
		getContentPane().add(treeCategorias);
		
		this.treeCategorias = treeCategorias;
		
		this.JTreeSeleccionCategoriaPadre = treeCategorias;
		cargarJTree();
		
		JLabel TextoNum = new JLabel("* Numero de Referencia");
		TextoNum.setBounds(42, 230, 148, 14);
		getContentPane().add(TextoNum);
		
		JTextField campoNumRef = new JTextField();
		campoNumRef.setColumns(10);
		campoNumRef.setBounds(42, 244, 116, 20);
		getContentPane().add(campoNumRef);
		
		this.campoNumRef = campoNumRef;
		
		this.addInternalFrameListener(new InternalFrameAdapter() {
	         @Override
	         public void internalFrameClosing(InternalFrameEvent e) {
	        	 limpiarCampos();
	        	 dispose();
	         }
	    });
	
		JComboBox <DTProveedor> boxProveedor = new JComboBox<DTProveedor>(sistema.listarProveedores().toArray(new DTProveedor[0]));
		boxProveedor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DTProveedor selectedItem = (DTProveedor) boxProveedor.getSelectedItem();
				if(selectedItem != null) {
					String nick = selectedItem.getNickname();
					try {
						sistema.elegirProveedor(nick);
					} catch (UsuarioNoExisteException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		boxProveedor.setEditable(true);
		boxProveedor.setBounds(268, 202, 194, 20);
		getContentPane().add(boxProveedor);
		
		this.boxProveedor = boxProveedor;
	
		JButton BotonRegistrar = new JButton("Registrar");
		BotonRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String nombre = null;
				String descrip = null;
				String especificacion = null;
				int numReferencia = -1;
				float precio = -1;
				List<Categoria> categoria = null;
				List<String> imagenes = null;
		
				
				try {
					camposValidos();	
					nombre = campoNombre.getText();
					descrip = campoDescripcion.getText();
					especificacion = campoEspecificacion.getText();
					numReferencia = Integer.valueOf(campoNumRef.getText().trim());
					precio = Float.valueOf(campoPrecio.getText().trim());
					categoria = listaCategorias();
					imagenes = listaImagenes();
					// titulo,  numReferencia,  descrip,  especificaciones,  precio, List<Categoria> categorias, List<String> imagenes
					sistema.registrarProducto(nombre, numReferencia, descrip, especificacion, precio, categoria, imagenes);
					mostrarInformacion();
					limpiarCampos();
				} catch(Exception exc) {
					JOptionPane.showMessageDialog(null, exc.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
					return;
				}
			}
		});
		BotonRegistrar.setBackground(new Color(255, 157, 176));
		BotonRegistrar.setBounds(384, 264, 104, 23);
		getContentPane().add(BotonRegistrar);
			
	}
}
