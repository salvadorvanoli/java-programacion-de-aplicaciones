package interfaces;
import java.awt.EventQueue;
import java.util.ArrayList;
import clases.DTOrdenDeCompra;
import clases.DTOrdenDeCompraDetallada;
import clases.Cantidad;
import clases.DTCliente;

import java.util.List;
import javax.swing.JInternalFrame;
import javax.swing.SwingUtilities;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import clases.Producto;
import excepciones.OrdenDeCompraNoExisteException;

import javax.swing.JInternalFrame;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import clases.ISistema;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.Font;

public class VerInfoOrdenDeCompra extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private ISistema sistema;
	private JComboBox<DTOrdenDeCompra> ordenes;

	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VerInfoOrdenDeCompra frame = new VerInfoOrdenDeCompra();
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
	public VerInfoOrdenDeCompra(ISistema sistema) {
		setClosable(true);
		setFrameIcon(new ImageIcon(VerInfoOrdenDeCompra.class.getResource("/Images/Flamin-Go.png")));
		setTitle("Flamin-Go");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		this.sistema = sistema;
		
		JComboBox<DTOrdenDeCompra> comboBox = new JComboBox<DTOrdenDeCompra>();
		comboBox.setEditable(true);
		comboBox.setBounds(24, 62, 149, 22);
		getContentPane().add(comboBox);
		
		ordenes = comboBox;
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(24, 119, 189, 98);
		getContentPane().add(scrollPane);
		
		JTextArea ordenDetalles = new JTextArea();
		scrollPane.setViewportView(ordenDetalles);
		
		
		
		///////////// CASO DE PRUEBA -> COMENTARLO Y DES-COMENTAR LO DE ABAJO PARA QUE FUNCIONE NORMAL//////////
       /* Producto producto1 = new Producto("Producto A", "q", "w", 1, 3, null, null, null);
        Producto producto2 = new Producto("Producto B", "q", "w", 1, 3, null, null, null);
        Producto producto3 = new Producto("Producto C", "q", "w", 1, 3, null, null, null);
        Producto producto4 = new Producto("Producto D", "q", "w", 1, 3, null, null, null);
        Producto producto5 = new Producto("Producto E", "q", "w", 1, 3, null, null, null);
        Producto producto6 = new Producto("Producto F", "q", "w", 1, 3, null, null, null);

        // Crear cantidades para la primera orden
        Cantidad cantidad1_1 = new Cantidad(producto1, 10);
        Cantidad cantidad1_2 = new Cantidad(producto2, 5);
        Cantidad cantidad1_3 = new Cantidad(producto3, 2);

        // Crear cantidades para la segunda orden
        Cantidad cantidad2_1 = new Cantidad(producto4, 7);
        Cantidad cantidad2_2 = new Cantidad(producto5, 3);
        Cantidad cantidad2_3 = new Cantidad(producto6, 1);

        // Crear cantidades para la tercera orden
        Cantidad cantidad3_1 = new Cantidad(producto1, 8);
        Cantidad cantidad3_2 = new Cantidad(producto4, 6);
        Cantidad cantidad3_3 = new Cantidad(producto6, 4);

        // Crear listas de cantidades para cada orden
        List<Cantidad> cantidadesOrden1 = new ArrayList<>();
        cantidadesOrden1.add(cantidad1_1);
        cantidadesOrden1.add(cantidad1_2);
        cantidadesOrden1.add(cantidad1_3);

        List<Cantidad> cantidadesOrden2 = new ArrayList<>();
        cantidadesOrden2.add(cantidad2_1);
        cantidadesOrden2.add(cantidad2_2);
        cantidadesOrden2.add(cantidad2_3);

        List<Cantidad> cantidadesOrden3 = new ArrayList<>();
        cantidadesOrden3.add(cantidad3_1);
        cantidadesOrden3.add(cantidad3_2);
        cantidadesOrden3.add(cantidad3_3);

        // Crear instancias de DTOrdenDeCompra
        DTOrdenDeCompra orden1 = new DTOrdenDeCompra(1, null, cantidadesOrden1);
        DTOrdenDeCompra orden2 = new DTOrdenDeCompra(2, null, cantidadesOrden2);
        DTOrdenDeCompra orden3 = new DTOrdenDeCompra(3, null, cantidadesOrden3);

        // Crear una lista de órdenes de compra
        List<DTOrdenDeCompra> listaOrdenes = new ArrayList<>();
        listaOrdenes.add(orden1);
        listaOrdenes.add(orden2);
        listaOrdenes.add(orden3);
        
        //Iterar sobre la lista y agregar cada DTOrdenDeCompra al JComboBox
 		for (DTOrdenDeCompra ordenDetalles1 : listaOrdenes) {
 		    comboBox.addItem(ordenDetalles1); 
 		} */
 
        
		comboBox.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        // Obtenego la orden seleccionada
		        DTOrdenDeCompra ordenSeleccionada = (DTOrdenDeCompra) comboBox.getSelectedItem();
		        
		        if (ordenSeleccionada != null) {
		            try {
		            	sistema.elegirOrdenDeCompra(ordenSeleccionada.getNumero());
		            	DTOrdenDeCompraDetallada detalles = sistema.verInformacionOrdenDeCompra();
		            	ordenDetalles.setText(detalles.toString());
		            } catch (OrdenDeCompraNoExisteException exc) {
		            	// FALTA POPUP
		            }
		        }
		    }
		});

		
		JLabel lblNewLabel = new JLabel("Seleccionar orden de compra:");
		lblNewLabel.setBounds(24, 45, 149, 14);
		getContentPane().add(lblNewLabel);
		
		
		
		JLabel lblNewLabel_1 = new JLabel("Orden de compra:");
		lblNewLabel_1.setBounds(24, 95, 120, 14);
		getContentPane().add(lblNewLabel_1);
		
		JButton borrar = new JButton("Consultar otra orden");
		borrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 ordenDetalles.setText("");
				 comboBox.setSelectedIndex(-1); 
			}
		});
		borrar.setBounds(253, 236, 149, 23);
		getContentPane().add(borrar);
		
		JLabel lblNewLabel_2 = new JLabel("Ver informacion de orden de compra");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(50, 11, 308, 23);
		getContentPane().add(lblNewLabel_2);

	}
	
public List<DTOrdenDeCompra> getOrdenesDeCompra(){
		
		if (this.sistema == null) {
			// tiro el error
			throw new NullPointerException ("Error: El sistema no existe."); // FALTA POPUP
		}
		List<DTOrdenDeCompra> lista = null;
		
		try {
			lista = this.sistema.listarOrdenesDeCompra();
		} catch (IllegalArgumentException e) {
			throw new IllegalStateException (e.getMessage()); // FALTA POPUP DE ERROR
		}
		
		if (lista.isEmpty()) {
			throw new IllegalStateException ("Error: El sistema no tiene ordenes de compra."); // FALTA POPUP
		}
		
		return lista;
		
	}

	public void cargarOrdenesDeCompra() {
		List<DTOrdenDeCompra> lista = null;
		
		try {
			lista = this.getOrdenesDeCompra();
		} catch (IllegalArgumentException e) {
			throw new IllegalStateException (e.getMessage()); // FALTA POPUP DE ERROR
		}
		
		this.ordenes.removeAllItems();
		
		for (DTOrdenDeCompra item : lista) {
			this.ordenes.addItem(item);
		}
		
	}

}