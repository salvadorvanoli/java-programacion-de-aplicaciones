package interfaces;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import java.awt.Choice;
import javax.swing.JButton;
import java.awt.TextArea;
import java.awt.Font;
import javax.swing.SwingConstants;

import clases.DTFecha;
import clases.DTOrdenDeCompra;
import clases.ISistema;
import excepciones.OrdenDeCompraNoExisteException;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class CancelarOrdenDeCompra extends JInternalFrame {

    private static final long serialVersionUID = 1L;
    private JComboBox<String> selectOrdenCancelarOrdenDeCompra;
    private TextArea textAreaInfoOrdenDeCompra;
    private ISistema sistema;
    
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
        setBounds(100, 100, 590, 412);
        getContentPane().setLayout(null);
        
        JTextPane tituloCancelarOrdenDeCompra = new JTextPane();
        tituloCancelarOrdenDeCompra.setEditable(false);
        tituloCancelarOrdenDeCompra.setText("Bienvenido a la interfaz de eliminación de órdenes de compra, elija una y seleccione \"Eliminar\"");
        tituloCancelarOrdenDeCompra.setBounds(10, 62, 534, 20);
        getContentPane().add(tituloCancelarOrdenDeCompra);
        
        JLabel labelSelectOrdenCancelarOrdenDeCompra = new JLabel("Seleccione la orden de compra *");
        labelSelectOrdenCancelarOrdenDeCompra.setBounds(27, 104, 224, 14);
        getContentPane().add(labelSelectOrdenCancelarOrdenDeCompra);
        
        selectOrdenCancelarOrdenDeCompra = new JComboBox<>();
        selectOrdenCancelarOrdenDeCompra.setBounds(22, 129, 423, 22);
        getContentPane().add(selectOrdenCancelarOrdenDeCompra);

        selectOrdenCancelarOrdenDeCompra.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String seleccionado = (String) selectOrdenCancelarOrdenDeCompra.getSelectedItem();
                if (seleccionado != null && seleccionado.contains(" - ")) {
                    String numeroOrdenStr = seleccionado.split(" - ")[0];
                    int numeroOrden = Integer.parseInt(numeroOrdenStr);
                    try {
                        sistema.elegirOrdenDeCompra(numeroOrden);
                        String informacionDetalladaOrdenDeCompra = sistema.getOrdenDeCompraActual().toString();
                        textAreaInfoOrdenDeCompra.setText(informacionDetalladaOrdenDeCompra);
                    } catch (OrdenDeCompraNoExisteException e1) {
                        // CREAR UNA VENTANA DE ERROR
                    }
                } else {
                    // CREAR UNA VENTANA DE ERROR
                }
            }
        });

        textAreaInfoOrdenDeCompra = new TextArea();
        textAreaInfoOrdenDeCompra.setText("Aquí irá el texto con la información de la orden de compra");
        textAreaInfoOrdenDeCompra.setBounds(22, 168, 522, 188);
        getContentPane().add(textAreaInfoOrdenDeCompra);

        JButton eliminarOrdenCancelarOrdenDeCompra = new JButton("Eliminar");
        eliminarOrdenCancelarOrdenDeCompra.setBounds(455, 129, 89, 23);
        getContentPane().add(eliminarOrdenCancelarOrdenDeCompra);
        
        JLabel tituloPrincipalCancelarOrdenDeCompra = new JLabel("Cancelar Orden de Compra");
        tituloPrincipalCancelarOrdenDeCompra.setVerticalAlignment(SwingConstants.TOP);
        tituloPrincipalCancelarOrdenDeCompra.setHorizontalAlignment(SwingConstants.CENTER);
        tituloPrincipalCancelarOrdenDeCompra.setFont(new Font("Tahoma", Font.PLAIN, 16));
        tituloPrincipalCancelarOrdenDeCompra.setBounds(189, 22, 192, 20);
        getContentPane().add(tituloPrincipalCancelarOrdenDeCompra);
        eliminarOrdenCancelarOrdenDeCompra.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String seleccionado = (String) selectOrdenCancelarOrdenDeCompra.getSelectedItem();
                if (seleccionado != null && seleccionado.contains(" - ")) {
                    String numeroOrdenStr = seleccionado.split(" - ")[0];
                    int numeroOrden = Integer.parseInt(numeroOrdenStr);
                    try {
                        sistema.cancelarOrdenDeCompra(numeroOrden);
                        cargarOrdenesDeCompra();
                    } catch (OrdenDeCompraNoExisteException e1) {
                        // CREAR UNA VENTANA DE ERROR
                    }
                } else {
                    // CREAR UNA VENTANA DE ERROR
                }
            }
        });
    }
    
    private void cargarOrdenesDeCompra() {
        selectOrdenCancelarOrdenDeCompra.removeAllItems(); // Limpiar el JComboBox
        List<DTOrdenDeCompra> lista = sistema.listarOrdenesDeCompra();
        if(lista.isEmpty()) {
        	textAreaInfoOrdenDeCompra.setText("Aquí irá el texto con la información de la orden de compra");
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
            cargarOrdenesDeCompra(); // Recargar las órdenes de compra cada vez que se muestra la ventana
        }
    }
}
