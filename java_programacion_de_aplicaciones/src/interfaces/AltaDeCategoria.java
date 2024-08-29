package interfaces;

import clases.Categoria;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import java.awt.Choice;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.SwingConstants;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

import clases.ISistema;
import excepciones.CategoriaNoExisteException;
import excepciones.CategoriaRepetidaException;
import excepciones.OrdenDeCompraNoExisteException;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JTree;

public class AltaDeCategoria extends JInternalFrame {

    private static final long serialVersionUID = 1L;
    private JTextField inputNombreDeLaCategoria;
    private JTree selectCategoriaPadreAltaDeCategoria;
    private JCheckBox contieneProductosCheckbox;
    private ISistema sistema; // Variable de instancia para ISistema

    public AltaDeCategoria(ISistema sistema) {
        this.sistema = sistema; // Guardar el sistema en la variable de instancia

        // Inicializar el frame
        setClosable(true);
        setFrameIcon(new ImageIcon(AltaDeCategoria.class.getResource("/Images/Flamin-Go.png")));
        setTitle("Flamin-Go");
        setBounds(100, 100, 590, 625);
        getContentPane().setLayout(null);

        // Inicializar los componentes
        JTextPane tituloAltaDeCategoria = new JTextPane();
        tituloAltaDeCategoria.setEditable(false);
        tituloAltaDeCategoria.setText("Bienvenido a la interfaz de creación de una categoría, rellene el formulario e ingrese \"Crear\" para dar de alta la categoría.");
        tituloAltaDeCategoria.setBounds(10, 66, 535, 34);
        getContentPane().add(tituloAltaDeCategoria);

        JLabel labelNombreCategoriaAltaDeCategoria = new JLabel("Nombre de la categoría *");
        labelNombreCategoriaAltaDeCategoria.setBounds(30, 103, 170, 14);
        getContentPane().add(labelNombreCategoriaAltaDeCategoria);

        inputNombreDeLaCategoria = new JTextField();
        inputNombreDeLaCategoria.setColumns(10);
        inputNombreDeLaCategoria.setBounds(30, 128, 515, 20);
        getContentPane().add(inputNombreDeLaCategoria);

        contieneProductosCheckbox = new JCheckBox("Contiene productos");
        contieneProductosCheckbox.setBounds(30, 155, 170, 23);
        getContentPane().add(contieneProductosCheckbox);

        JLabel labelSelectDeCategoriaAltaDeCategoria = new JLabel("Seleccione una categoría a la que pertenezca (no seleccione ninguna si es categoría raíz)");
        labelSelectDeCategoriaAltaDeCategoria.setBounds(31, 193, 664, 14);
        getContentPane().add(labelSelectDeCategoriaAltaDeCategoria);

        JTextPane obligatorioAltaDeCategoria = new JTextPane();
        obligatorioAltaDeCategoria.setEditable(false);
        obligatorioAltaDeCategoria.setText("Los elementos marcados con * son obligatorios");
        obligatorioAltaDeCategoria.setBounds(30, 492, 306, 20);
        getContentPane().add(obligatorioAltaDeCategoria);

        JLabel tituloPrincipalAltaDeCategoria = new JLabel("Alta de Categoría");
        tituloPrincipalAltaDeCategoria.setHorizontalAlignment(SwingConstants.CENTER);
        tituloPrincipalAltaDeCategoria.setFont(new Font("Tahoma", Font.PLAIN, 16));
        tituloPrincipalAltaDeCategoria.setBounds(221, 21, 128, 34);
        getContentPane().add(tituloPrincipalAltaDeCategoria);

        selectCategoriaPadreAltaDeCategoria = new JTree();
        selectCategoriaPadreAltaDeCategoria.setBounds(30, 218, 501, 263);
        getContentPane().add(selectCategoriaPadreAltaDeCategoria);

        JButton crearBtnAltaDeCategoria = new JButton("Crear");
        crearBtnAltaDeCategoria.setBounds(231, 540, 89, 23);
        getContentPane().add(crearBtnAltaDeCategoria);

        // Llamar al método para cargar datos al inicializar el frame
        cargarDatos();

        // Modificación en el evento de crear una nueva categoría
        crearBtnAltaDeCategoria.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 1. Extraer el nombre de la categoría
                String nombreCategoria = inputNombreDeLaCategoria.getText().trim();
                
                if(nombreCategoria.isEmpty() || nombreCategoria.isBlank()) {
                	JOptionPane.showMessageDialog(null, "Debe agregar un nombre a la categoría", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                	// 2. Determinar el valor del booleano
                    boolean contieneProductos = contieneProductosCheckbox.isSelected();
                    
                    // 3. Obtener la categoría padre
                    DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) selectCategoriaPadreAltaDeCategoria.getLastSelectedPathComponent();
                    Categoria categoriaPadre = null;

                    if (selectedNode != null && !selectedNode.toString().equals("Categorías")) {
                        String nombrePadre = selectedNode.toString();
                        try {
                            sistema.elegirCategoria(nombrePadre);
                            categoriaPadre = sistema.getCategoriaActual();
                        } catch (CategoriaNoExisteException e1) {
                            // MANEJAR ERROR
                        }
                    }
                    
                    // 4. Llamar al método altaCategoria
                    try {
                        sistema.altaCategoria(nombreCategoria, contieneProductos, categoriaPadre);

                        // Limpiar los campos después de la creación
                        limpiarCampos();
                    } catch (CategoriaRepetidaException e1) {
                        // MANEJAR ERROR
                    }
                    
                    // Volver a cargar los datos
                    cargarDatos();
                }
            }
        });
    }

    private void cargarDatos() {
        // Vaciar el JTree
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("Categorías");

        HashMap<String, Categoria> categorias = sistema.getCategorias();

        if (categorias == null || categorias.isEmpty()) {
            // Si no hay categorías, no agregar nodos
            selectCategoriaPadreAltaDeCategoria.setModel(new DefaultTreeModel(root));
            return;
        }

        // Agregar las categorías raíz al árbol
        for (Map.Entry<String, Categoria> entry : categorias.entrySet()) {
            Categoria categoria = entry.getValue();
            DefaultMutableTreeNode node = new DefaultMutableTreeNode(categoria.getNombreCat());
            root.add(node);
            
            // Llamar a la función recursiva para agregar hijos
            agregarHijosRecursivamente(categoria, node);
        }

        // Crear el modelo de árbol y asignarlo al JTree
        DefaultTreeModel treeModel = new DefaultTreeModel(root);
        selectCategoriaPadreAltaDeCategoria.setModel(treeModel);
    }

    // Método recursivo para agregar hijos al nodo del árbol
    private void agregarHijosRecursivamente(Categoria categoria, DefaultMutableTreeNode nodoPadre) {
        HashMap<String, Categoria> hijos = categoria.getHijos();

        for (Map.Entry<String, Categoria> entry : hijos.entrySet()) {
            Categoria hijo = entry.getValue();
            DefaultMutableTreeNode nodoHijo = new DefaultMutableTreeNode(hijo.getNombreCat());
            nodoPadre.add(nodoHijo);
            
            // Llamar recursivamente para los hijos del hijo
            agregarHijosRecursivamente(hijo, nodoHijo);
        }
    }

    @Override
    public void setVisible(boolean visible) {
        super.setVisible(visible);
        if (visible) {
            cargarDatos(); // Usar la variable de instancia
        } else {
            limpiarCampos();
        }
    }

    private void limpiarCampos() {
        if (inputNombreDeLaCategoria != null) {
            // Vaciar el campo de texto
            inputNombreDeLaCategoria.setText("");
        }
        
        if (contieneProductosCheckbox != null) {
            // Deseleccionar el checkbox
            contieneProductosCheckbox.setSelected(false);
        }
        
        if (selectCategoriaPadreAltaDeCategoria != null) {
            // Vaciar el JTree
            selectCategoriaPadreAltaDeCategoria.setModel(new DefaultTreeModel(new DefaultMutableTreeNode("Categorías")));
        }
    }
}