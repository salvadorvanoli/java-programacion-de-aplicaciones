package interfaces;
import java.awt.EventQueue;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;

import javax.swing.JOptionPane;
import clases.Categoria;
import javax.swing.JInternalFrame;
import javax.swing.JList;
import java.awt.BorderLayout;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeModel;

import clases.ISistema;

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
import javax.swing.ListSelectionModel;
import clases.Cantidad;
import clases.Producto;
import excepciones.CategoriaNoExisteException;
import excepciones.UsuarioNoExisteException;
import clases.Cliente;
import clases.DTCliente;
import java.awt.Component;
import javax.swing.SwingUtilities;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.JInternalFrame;
import java.awt.Font;

public class GenerarOrdenDeCompra extends JInternalFrame {
	public List<Cantidad> listaCantidades;

	private static final long serialVersionUID = 1L;

	// private static final Categoria  = null;
	private ISistema sistema;
	private JTextField cantidadPoner;
	private JComboBox<DTCliente> seleccionarCliente;

	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GenerarOrdenDeCompra frame = new GenerarOrdenDeCompra();
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
	public GenerarOrdenDeCompra(ISistema sistema) {
		setClosable(true);
		setFrameIcon(new ImageIcon(GenerarOrdenDeCompra.class.getResource("/Images/Flamin-Go.png")));
		setTitle("Flamin-Go");
		setBounds(100, 100, 445, 300);
		getContentPane().setLayout(null);
		
		this.sistema = sistema;
		this.listaCantidades = new ArrayList<>();
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(27, 127, 159, 70);
		getContentPane().add(scrollPane);
		
		JTree seleccionarProducto = new JTree();
		// Crear categorías
		Categoria categoriaElectronicos = new Categoria("Electronicos", true, null);
		Categoria categoriaFarmacia = new Categoria("Farmacia", true, null);

		// Crear productos para Electrónicos
		Producto laptop = new Producto("Laptop", "Descripción de Laptop", "Especificación de Laptop", 1, 1000.0f, null, null, null);
		Producto celular = new Producto("Celular", "Descripción de Celular", "Especificación de Celular", 2, 500.0f, null, null, null);

		// Crear productos para Farmacia
		Producto jarabe = new Producto("Jarabe", "Descripción de Jarabe", "Especificación de Jarabe", 3, 10.0f, null, null, null);
		Producto vitaminas = new Producto("Vitaminas", "Descripción de Vitaminas", "Especificación de Vitaminas", 4, 20.0f, null, null, null);
		
		
		// Crear nodo raíz
		DefaultMutableTreeNode root = new DefaultMutableTreeNode("Categorías");

		// Crear nodos de categorías
		DefaultMutableTreeNode nodoElectronicos = new DefaultMutableTreeNode(categoriaElectronicos);
		DefaultMutableTreeNode nodoFarmacia = new DefaultMutableTreeNode(categoriaFarmacia);

		// Crear nodos de productos para cada categoría
		DefaultMutableTreeNode nodoLaptop = new DefaultMutableTreeNode(laptop);
		DefaultMutableTreeNode nodoCelular = new DefaultMutableTreeNode(celular);
		DefaultMutableTreeNode nodoJarabe = new DefaultMutableTreeNode(jarabe);
		DefaultMutableTreeNode nodoVitaminas = new DefaultMutableTreeNode(vitaminas);
		
		
		// Agregar productos a las categorías correspondientes
		nodoElectronicos.add(nodoLaptop);
		nodoElectronicos.add(nodoCelular);

		nodoFarmacia.add(nodoJarabe);
		nodoFarmacia.add(nodoVitaminas);

		// Agregar categorías al nodo raíz
		root.add(nodoElectronicos);
		root.add(nodoFarmacia);

		// Crear el modelo del árbol con el nodo raíz
		DefaultTreeModel treeModel = new DefaultTreeModel(root);

		// Asignar el modelo al JTree
		seleccionarProducto.setModel(treeModel);

		scrollPane.setViewportView(seleccionarProducto);
		seleccionarProducto.setName("");
		seleccionarProducto.setToggleClickCount(1);
		
		
		
		
		
		
		
		
		/* SE ME OCURRIO USAR ESTO PARA CARGAR EL ARBOL */
		/*
		
		JTree seleccionarProducto = new JTree();
		
		// Crear nodo raíz
		DefaultMutableTreeNode root = new DefaultMutableTreeNode("Categorías");
		
		for (Categoria cat : sistema.getCategorias().values()) {
			this.cargarJTree(cat, root); // ROOT SERIA EL NODO RAIZ (PODEMOS PONERLE CATEGORIA NOMAS)
		}
		
		
		// Crear el modelo del árbol con el nodo raíz
		DefaultTreeModel treeModel = new DefaultTreeModel(root);

		// Asignar el modelo al JTree
		seleccionarProducto.setModel(treeModel);

		scrollPane.setViewportView(seleccionarProducto);
		seleccionarProducto.setName("");
		seleccionarProducto.setToggleClickCount(1);
		
		*/
		
		
		
		
		
		
		JComboBox<DTCliente> seleccionarCliente = new JComboBox<DTCliente>();
		seleccionarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// ACA SE TIENE QUE SELECCIONAR EL USUARIO EN EL SISTEMA
			}
		});
		seleccionarCliente.setBounds(27, 69, 124, 22);
		getContentPane().add(seleccionarCliente);

		this.seleccionarCliente = seleccionarCliente;
		
		List<DTCliente> clientes = sistema.listarClientes(); // Lista de clientes

		// Lleno el JComboBox con los clientes.
		for (DTCliente cliente : clientes) {
		    // Agregar el nickname del cliente al JComboBox
		    seleccionarCliente.addItem(cliente);
		}


		
		JLabel lblNewLabel = new JLabel("Seleccionar cliente:");
		lblNewLabel.setBounds(27, 44, 154, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Seleccionar producto:");
		lblNewLabel_1.setBounds(27, 102, 186, 14);
		getContentPane().add(lblNewLabel_1);
		
		cantidadPoner = new JTextField();
		cantidadPoner.setBounds(88, 208, 30, 20);
		getContentPane().add(cantidadPoner);
		cantidadPoner.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Cantidad:");
		lblNewLabel_2.setBounds(32, 211, 59, 14);
		getContentPane().add(lblNewLabel_2);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_1.setBounds(245, 71, 154, 83);
		getContentPane().add(scrollPane_1);
		
		JList<String> orden = new JList<>();
		DefaultListModel<String> model = new DefaultListModel<>();
		orden.setModel(model); 
		scrollPane_1.setViewportView(orden);
		
		
//////////////////botón para agregar línea///////////
		JButton agregar = new JButton("Agregar a la orden");
		agregar.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        try {
		            //Obtenengo los valores seleccionados
		            DTCliente cliente = (DTCliente) seleccionarCliente.getSelectedItem();
		            sistema.elegirCliente(cliente.getNickname());
		            
		            // Obtener el nodo
		            DefaultMutableTreeNode nodoSeleccionado = (DefaultMutableTreeNode) seleccionarProducto.getLastSelectedPathComponent();
		            
		            //Definir la variable 'producto'
		            Producto producto = null;
		            
		            // Verifico si el nodo seleccionado no es nulo y si contiene un Producto
		            if (nodoSeleccionado != null && nodoSeleccionado.getUserObject() instanceof Producto) {
		                producto = (Producto) nodoSeleccionado.getUserObject();
		            }
		            
		            //Verificar si 'producto' sigue siendo null
		            if (producto == null) {
		                throw new NullPointerException("Seleccione un producto");
		            }
		            
		            // Obtener la cantidad del JTextField
		            String cantidadTexto = cantidadPoner.getText();
		            
		            // Verificar si la cantidad no está vacía
		            if (cantidadTexto.trim().isEmpty()) {
		                throw new NumberFormatException("El campo de cantidad está vacío.");
		            }
		            
		            // Convertir la cantidad a entero
		            int cantidad = Integer.parseInt(cantidadTexto);
		            
		            // Verificar si la cantidad es mayor que cero
		            if (cantidad <= 0) {
		                throw new NumberFormatException("La cantidad debe ser mayor que cero.");
		            }
		            
		            // Crear una nueva instancia de Cantidad
		            Cantidad nuevaCantidad = new Cantidad(producto, cantidad);
		            
		            // Guardar la instancia en la lista
		            listaCantidades.add(nuevaCantidad);
		            
		            // Agregar una representación de la cantidad a la JList
		            model.addElement(nuevaCantidad.toString2());
		            
		            System.out.println("LLEGUE HASTA ACAAAA");
		            
		            // Limpiar los campos
		            cantidadPoner.setText("");
		            
		        } catch (NumberFormatException ex) {
		            JOptionPane.showMessageDialog(null, "Ingrese una cantidad válida.", "Error", JOptionPane.ERROR_MESSAGE);
		        } catch (NullPointerException ex) {
		            JOptionPane.showMessageDialog(null, "Seleccione un producto.", "Error", JOptionPane.ERROR_MESSAGE);
		        } catch (UsuarioNoExisteException e1) {
		            // TODO Auto-generated catch block
		            e1.printStackTrace();
		        }
		    }
		});

		
			

	
		agregar.setBounds(32, 236, 149, 23);
		getContentPane().add(agregar);
		

		
		JLabel lblNewLabel_3 = new JLabel("Orden provisoria:");
		lblNewLabel_3.setBounds(245, 44, 135, 14);
		getContentPane().add(lblNewLabel_3);
		
		
//////////////////botón para descartar línea///////////
		JButton descartar = new JButton("Descartar linea");
		descartar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Verifico si se ha seleccionado algún elemento en la JList
			    int selectedIndex = orden.getSelectedIndex();
			    if (selectedIndex != -1) {
			        String cantidadStr = model.getElementAt(selectedIndex);

			        // Eliminar el elemento de la JList
			        model.remove(selectedIndex);

			        // Encontrar la instancia correspondiente en la lista de Cantidades y eliminarla
			        Cantidad cantidadAEliminar = null;
			        for (Cantidad c : listaCantidades) {
			            if (c.toString().equals(cantidadStr)) {
			                cantidadAEliminar = c;
			                break;
			            }
			        }
			        
			        if (cantidadAEliminar != null) {
			            listaCantidades.remove(cantidadAEliminar);
			        }
			    } else {
			        // Mostrar mensaje si no se ha seleccionado ningún elemento
			        JOptionPane.showMessageDialog(null, "Seleccione un elemento para eliminar.", "Error", JOptionPane.ERROR_MESSAGE);
			    }
			}
		}); 
		
		descartar.setBounds(255, 165, 144, 23);
		getContentPane().add(descartar);
		
	//////////////////botón para cancelar///////////
		JButton cancelar = new JButton("Cancelar");
		cancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 if (listaCantidades != null) {
				        listaCantidades.clear(); // Limpio todos los elementos de la lista
				    }

				    //Borro los elementos de la JList y actualizo la vista
				    DefaultListModel model = (DefaultListModel) orden.getModel(); 
				    model.clear(); //Limpia todos los elementos del modelo
			}
		});
		cancelar.setBounds(206, 236, 99, 23);
		getContentPane().add(cancelar);
		
//////////////////botón para dar de alta///////////
		JButton btnNewButton_3 = new JButton("Dar de alta");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					 
						
				    if (listaCantidades == null || listaCantidades.isEmpty()) {
				        throw new Exception("No ha ingresado nada aún");
				    } else {
				    	
				    	//aca va el codigo de agregar uno a uno( se llama a "sistema" es decir sistema.agreagrProducto...
				    	sistema.agregarOrden(listaCantidades);
				    	
				        // Mostrar el mensaje de éxito
				        JOptionPane.showMessageDialog(null, "Orden realizada con éxito", "Éxito", JOptionPane.INFORMATION_MESSAGE);

				        // Cerrar el JInternalFrame
				        JInternalFrame internalFrame = (JInternalFrame) SwingUtilities.getAncestorOfClass(JInternalFrame.class, (Component) e.getSource());
				        if (internalFrame != null) {
				            internalFrame.dispose();
				        }
				    }
				} catch (Exception ex) {
				    // Mostrar el mensaje de error
				    JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				}

				{
					 if (listaCantidades != null) {
					        listaCantidades.clear(); // Limpio todos los elementos de la lista
					    }

					    //Borro los elementos de la JList y actualizo la vista
					    DefaultListModel model = (DefaultListModel) orden.getModel(); 
					    model.clear(); //Limpia todos los elementos del modelo
				}
			}
		});
		btnNewButton_3.setBounds(315, 236, 104, 23);
		getContentPane().add(btnNewButton_3);
		
		JLabel lblNewLabel_4 = new JLabel("Generar Orden de Compra");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_4.setBounds(27, 11, 212, 22);
		getContentPane().add(lblNewLabel_4);

		
		//sistema.darAltaOrden(no se que parametros poner, falta hacerla);
		

	}
	
	public List<DTCliente> getClientes(){
		
		if (this.sistema == null) {
			// tiro el error
			throw new NullPointerException ("Error: El sistema no existe."); // FALTA POPUP
		}
		List<DTCliente> lista = null;
		
		try {
			lista = this.sistema.listarClientes();
		} catch (IllegalArgumentException e) {
			throw new IllegalStateException (e.getMessage()); // FALTA POPUP DE ERROR
		}
		
		if (lista.isEmpty()) {
			throw new IllegalStateException ("Error: El sistema no tiene clientes."); // FALTA POPUP
		}
		
		return lista;
		
	}

	public void cargarClientes() {
		List<DTCliente> lista = null;
		
		try {
			lista = this.getClientes();
		} catch (IllegalArgumentException e) {
			throw new IllegalStateException (e.getMessage()); // FALTA POPUP DE ERROR
		}
		
		this.seleccionarCliente.removeAllItems();
		
		for (DTCliente cli : lista) {
			this.seleccionarCliente.addItem(cli);
		}
		
	}
	
	// Esta funcion la agregué para ir creando recursivamente el JTree
	
	public void cargarJTree(Categoria cat, DefaultMutableTreeNode nodo) {
		DefaultMutableTreeNode newNodo = new DefaultMutableTreeNode(cat);
		if (!(cat.getProductos().isEmpty())) {
			for (Producto prod : cat.getProductos()) {
				DefaultMutableTreeNode nodoProd = new DefaultMutableTreeNode(prod);
				newNodo.add(nodoProd);
			}
		}
		if (!(cat.getHijos().values().isEmpty())) {
			for (Categoria hijo : cat.getHijos().values()) {
				cargarJTree(hijo, newNodo);
			}
		}
		nodo.add(newNodo);
	}

	
	
}
