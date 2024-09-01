package interfaces;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Choice;
import javax.swing.JButton;
import java.awt.TextArea;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import clases.DTCantidadProducto;
import clases.DTFecha;
import clases.DTOrdenDeCompra;
import clases.DTOrdenDeCompraDetallada;
import clases.ISistema;
import excepciones.OrdenDeCompraNoExisteException;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

public class CancelarOrdenDeCompra extends JInternalFrame {

    private static final long serialVersionUID = 1L;
    private JComboBox<String> selectOrdenCancelarOrdenDeCompra;
    private ISistema sistema;
    private JTextField numOrdenTextField;
    private JTextField fechaTextField;
    private JTextField totalTextField;
    private JTextField nicknameTextField;
    private JTextField nombreProductoTextField;
    private JTextField precioUnitarioTextField;
    private JTextField cantidadDelProductoTextField;
    private JTextField subtotalDeLaLineaTextField;
    private JList<String> lineasList;
    
    public CancelarOrdenDeCompra(ISistema sistema) {
        this.sistema = sistema; // Guardar la referencia al sistema
        inicializarComponentes();
        cargarOrdenesDeCompra(); // Cargar las órdenes de compra al inicializar la ventana
    }

    private void inicializarComponentes() {
        // Inicializa todos los componentes aquí, excepto la carga de datos en el JComboBox
        setClosable(true);
        setTitle("Flamin-Go");
        setFrameIcon(new ImageIcon(CancelarOrdenDeCompra.class.getResource("/Images/Flamin-Go.png")));
        setBounds(100, 100, 590, 628);
        getContentPane().setLayout(null);
        
        JTextPane tituloCancelarOrdenDeCompra = new JTextPane();
        tituloCancelarOrdenDeCompra.setEditable(false);
        tituloCancelarOrdenDeCompra.setText("Bienvenido a la interfaz de eliminación de órdenes de compra, elija una y seleccione \"Eliminar\"");
        tituloCancelarOrdenDeCompra.setBounds(10, 62, 534, 20);
        getContentPane().add(tituloCancelarOrdenDeCompra);
        
        JLabel labelSelectOrdenCancelarOrdenDeCompra = new JLabel("Seleccione la orden de compra *");
        labelSelectOrdenCancelarOrdenDeCompra.setBounds(27, 125, 224, 14);
        getContentPane().add(labelSelectOrdenCancelarOrdenDeCompra);
        
        selectOrdenCancelarOrdenDeCompra = new JComboBox<>();
        selectOrdenCancelarOrdenDeCompra.setBounds(27, 161, 423, 22);
        getContentPane().add(selectOrdenCancelarOrdenDeCompra);

        JButton eliminarOrdenCancelarOrdenDeCompra = new JButton("Eliminar");
        eliminarOrdenCancelarOrdenDeCompra.setBounds(455, 161, 89, 23);
        getContentPane().add(eliminarOrdenCancelarOrdenDeCompra);
        
        JLabel tituloPrincipalCancelarOrdenDeCompra = new JLabel("Cancelar Orden de Compra");
        tituloPrincipalCancelarOrdenDeCompra.setVerticalAlignment(SwingConstants.TOP);
        tituloPrincipalCancelarOrdenDeCompra.setHorizontalAlignment(SwingConstants.CENTER);
        tituloPrincipalCancelarOrdenDeCompra.setFont(new Font("Tahoma", Font.PLAIN, 16));
        tituloPrincipalCancelarOrdenDeCompra.setBounds(189, 22, 192, 20);
        getContentPane().add(tituloPrincipalCancelarOrdenDeCompra);
        
        numOrdenTextField = new JTextField();
        numOrdenTextField.setEditable(false);
        numOrdenTextField.setBounds(27, 228, 112, 20);
        getContentPane().add(numOrdenTextField);
        numOrdenTextField.setColumns(10);
        
        fechaTextField = new JTextField();
        fechaTextField.setEditable(false);
        fechaTextField.setBounds(270, 228, 111, 20);
        getContentPane().add(fechaTextField);
        fechaTextField.setColumns(10);
        
        totalTextField = new JTextField();
        totalTextField.setEditable(false);
        totalTextField.setBounds(27, 292, 112, 20);
        getContentPane().add(totalTextField);
        totalTextField.setColumns(10);
        
        nicknameTextField = new JTextField();
        nicknameTextField.setEditable(false);
        nicknameTextField.setColumns(10);
        nicknameTextField.setBounds(270, 292, 112, 20);
        getContentPane().add(nicknameTextField);
        
        JLabel numOrdenLabel = new JLabel("Número de orden");
        numOrdenLabel.setBounds(149, 231, 224, 14);
        getContentPane().add(numOrdenLabel);
        
        JLabel fechaLabel = new JLabel("Fecha");
        fechaLabel.setBounds(391, 231, 224, 14);
        getContentPane().add(fechaLabel);
        
        JLabel totalLabel = new JLabel("Total");
        totalLabel.setBounds(149, 295, 224, 14);
        getContentPane().add(totalLabel);
        
        JLabel nicknameLabel = new JLabel("Nickname Cliente");
        nicknameLabel.setBounds(391, 295, 224, 14);
        getContentPane().add(nicknameLabel);
        
        JLabel productosLabel = new JLabel("Lineas de la orden de compra");
        productosLabel.setBounds(191, 347, 224, 14);
        getContentPane().add(productosLabel);
        
        JScrollPane scrollLineasList = new JScrollPane();
        scrollLineasList.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollLineasList.setBounds(27, 383, 224, 188);
        getContentPane().add(scrollLineasList);
        
        lineasList = new JList<>(new DefaultListModel<>());
        scrollLineasList.setViewportView(lineasList);
        
        nombreProductoTextField = new JTextField();
        nombreProductoTextField.setEditable(false);
        nombreProductoTextField.setColumns(10);
        nombreProductoTextField.setBounds(270, 385, 112, 20);
        getContentPane().add(nombreProductoTextField);
        
        precioUnitarioTextField = new JTextField();
        precioUnitarioTextField.setEditable(false);
        precioUnitarioTextField.setColumns(10);
        precioUnitarioTextField.setBounds(269, 429, 112, 20);
        getContentPane().add(precioUnitarioTextField);
        
        cantidadDelProductoTextField = new JTextField();
        cantidadDelProductoTextField.setEditable(false);
        cantidadDelProductoTextField.setColumns(10);
        cantidadDelProductoTextField.setBounds(269, 477, 112, 20);
        getContentPane().add(cantidadDelProductoTextField);
        
        subtotalDeLaLineaTextField = new JTextField();
        subtotalDeLaLineaTextField.setEditable(false);
        subtotalDeLaLineaTextField.setColumns(10);
        subtotalDeLaLineaTextField.setBounds(270, 528, 112, 20);
        getContentPane().add(subtotalDeLaLineaTextField);
        
        JLabel nombreDelProductoLabel = new JLabel("Nombre del producto");
        nombreDelProductoLabel.setBounds(391, 385, 224, 14);
        getContentPane().add(nombreDelProductoLabel);
        
        JLabel precioUnitarioDelProductoLabel = new JLabel("Precio unitario del producto");
        precioUnitarioDelProductoLabel.setBounds(391, 432, 224, 14);
        getContentPane().add(precioUnitarioDelProductoLabel);
        
        JLabel cantidadDelProductoLabel = new JLabel("Cantidad del producto");
        cantidadDelProductoLabel.setBounds(391, 480, 224, 14);
        getContentPane().add(cantidadDelProductoLabel);
        
        JLabel subtotalDeLaLineaLabel = new JLabel("Subtotal de la línea");
        subtotalDeLaLineaLabel.setBounds(391, 531, 224, 14);
        getContentPane().add(subtotalDeLaLineaLabel);

        selectOrdenCancelarOrdenDeCompra.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String seleccionado = (String) selectOrdenCancelarOrdenDeCompra.getSelectedItem();
                if (seleccionado != null && seleccionado.contains(" - ")) {
                    String numeroOrdenStr = seleccionado.split(" - ")[0];
                    int numeroOrden = Integer.parseInt(numeroOrdenStr);
                    try {
                    	limpiarCampos();
                        sistema.elegirOrdenDeCompra(numeroOrden);
                        String informacionDetalladaOrdenDeCompra = sistema.getOrdenDeCompraActual().toString();
                        
                        // NUEVA FORMA DE MOSTRAR DATOS
                        
                        DTOrdenDeCompraDetallada orden = sistema.verInformacionOrdenDeCompra();
                        
                        numOrdenTextField.setText(String.valueOf(orden.getNumero()));
                        
                        DTFecha fecha = orden.getFecha();
                        String fechaFormateada = String.format("%02d/%02d/%04d", fecha.getDia(), fecha.getMes(), fecha.getAnio());
                        fechaTextField.setText(fechaFormateada);
                        
                        totalTextField.setText(String.valueOf(orden.getPrecioTotal()));
                        
                        nicknameTextField.setText(orden.getCliente().getNickname());
                        
                        // Obtener el modelo de la lista
                        DefaultListModel<String> listModel = (DefaultListModel<String>) lineasList.getModel();
                        listModel.clear();
                        
                        for (DTCantidadProducto cantProd : orden.getProductosCantidad()) {
                            // Agregar el nombre del producto al modelo de la lista
                            listModel.addElement(cantProd.getProducto().getNombre());
                        }
                    } catch (OrdenDeCompraNoExisteException e1) {
                    	JOptionPane.showMessageDialog(null, "La orden de compra seleccionada no existe", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                	// Ignorar
                }
            }
        });
        
        lineasList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) { // Esto previene que el evento se dispare dos veces
                    String selectedProductName = lineasList.getSelectedValue();
                    if (selectedProductName != null) {
                        // Buscar el producto correspondiente y mostrar la información detallada en productosTextArea
                        DTOrdenDeCompraDetallada orden = sistema.verInformacionOrdenDeCompra();
                        
                        for (DTCantidadProducto cantProd : orden.getProductosCantidad()) {
                            if (cantProd.getProducto().getNombre().equals(selectedProductName)) {
                                
                                nombreProductoTextField.setText(cantProd.getProducto().getNombre());
                                cantidadDelProductoTextField.setText(String.valueOf(cantProd.getCantidad().getCantidad()));
                                precioUnitarioTextField.setText(String.valueOf(cantProd.getProducto().getPrecio()));
                                subtotalDeLaLineaTextField.setText(String.valueOf(cantProd.getSubtotal()));
                                
                                break;
                            }
                        }
                    }
                }
            }
        });

        eliminarOrdenCancelarOrdenDeCompra.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String seleccionado = (String) selectOrdenCancelarOrdenDeCompra.getSelectedItem();
                if (seleccionado != null && seleccionado.contains(" - ")) {
                    String numeroOrdenStr = seleccionado.split(" - ")[0];
                    int numeroOrden = Integer.parseInt(numeroOrdenStr);
                    try {
                        sistema.cancelarOrdenDeCompra(numeroOrden);
                        limpiarCampos();
                        cargarOrdenesDeCompra();
                    } catch (OrdenDeCompraNoExisteException e1) {
                    	JOptionPane.showMessageDialog(null, "No hay ninguna orden de compra seleccionada", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                	JOptionPane.showMessageDialog(null, "No hay ninguna orden de compra seleccionada", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
    
    private void cargarOrdenesDeCompra() {
        selectOrdenCancelarOrdenDeCompra.removeAllItems(); // Limpiar el JComboBox
        List<DTOrdenDeCompra> lista = sistema.listarOrdenesDeCompra();
        if(lista.isEmpty()) {
        	
        	
        }
        for (DTOrdenDeCompra orden : lista) {
            DTFecha fecha = orden.getFecha();
            String fechaFormateada = String.format("%02d/%02d/%04d", fecha.getDia(), fecha.getMes(), fecha.getAnio());
            String opcion = orden.getNumero() + " - " + fechaFormateada;
            selectOrdenCancelarOrdenDeCompra.addItem(opcion);
        }
    }

    @Override
    public void setVisible(boolean aFlag) {
        super.setVisible(aFlag);
        if (aFlag) {
        	limpiarCampos();
            cargarOrdenesDeCompra(); // Recargar las órdenes de compra cada vez que se muestra la ventana
        }
    }
    
    private void limpiarCampos() {
        numOrdenTextField.setText("");
        fechaTextField.setText("");
        totalTextField.setText("");
        nicknameTextField.setText("");
        nombreProductoTextField.setText("");
        precioUnitarioTextField.setText("");
        cantidadDelProductoTextField.setText("");
        subtotalDeLaLineaTextField.setText("");
        ((DefaultListModel<String>) lineasList.getModel()).clear();
    }
}
