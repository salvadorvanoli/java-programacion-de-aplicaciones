package interfaces;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import java.awt.Font;
import javax.swing.SwingConstants;

import clases.DTProveedor;
import clases.DTProveedorDetallado;
import clases.ISistema;
import excepciones.UsuarioNoExisteException;

import javax.swing.JButton;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

public class ListarProveedores extends JInternalFrame {

	private static final long serialVersionUID = 1L;

	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListarProveedores frame = new ListarProveedores();
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
	
	private void limpiarFormulario(JTextArea campoInfoProv){
		campoInfoProv.setText("");
	}
	
	
	public ListarProveedores(ISistema sistema) {
		setClosable(true);
		setTitle("Flamin-Go");
		setFrameIcon(new ImageIcon(ListarProveedores.class.getResource("/Images/Flamin-Go.png")));
		getContentPane().setBackground(new Color(240, 240, 240));
		setBounds(100, 100, 264, 319);
		getContentPane().setLayout(null);
		
		JLabel TextoProveedor = new JLabel("Selecciona un Proveedor\r\n");
		TextoProveedor.setFont(new Font("Tahoma", Font.PLAIN, 16));
		TextoProveedor.setHorizontalAlignment(SwingConstants.CENTER);
		TextoProveedor.setBounds(0, 11, 247, 14);
		getContentPane().add(TextoProveedor);
		
		JTextArea campoInfoProv = new JTextArea();
		campoInfoProv.setBounds(41, 91, 166, 127);
		getContentPane().add(campoInfoProv);
		
		JComboBox <DTProveedor> boxProveedor = new JComboBox<>(sistema.listarProveedores().toArray(new DTProveedor[0]));
		boxProveedor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DTProveedor selectedItem = (DTProveedor) boxProveedor.getSelectedItem();
				String nick = selectedItem.getNickname();
				try {
					sistema.elegirProveedor(nick);
				} catch (UsuarioNoExisteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				DTProveedorDetallado prov = sistema.verInformacionProveedor();
				campoInfoProv.setText("NickName: "+ prov.getNickname() + "\nEmail: " + prov.getEmail() + "\nApellido: " + prov.getApellido() + "\nNombre: " + prov.getNombre() + "\nNombre de Compania" + prov.getNomCompania() + "\nLink: " + prov.getLink()); //setear la info del detallado
			}
		});
		boxProveedor.setEditable(true);
		boxProveedor.setBounds(41, 36, 166, 14);
		getContentPane().add(boxProveedor);
		
		JLabel labelInfo = new JLabel("Informacion:");
		labelInfo.setBounds(41, 66, 66, 14);
		getContentPane().add(labelInfo);
		
		JButton botonAceptar = new JButton("Aceptar");
		botonAceptar.setBounds(80, 255, 79, 23);
		getContentPane().add(botonAceptar);
		
		
	}
}

