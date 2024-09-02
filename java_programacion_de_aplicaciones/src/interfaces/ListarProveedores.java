package interfaces;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;

import clases.DTProveedor;
import clases.DTProveedorDetallado;
import clases.ISistema;
import excepciones.UsuarioNoExisteException;

import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class ListarProveedores extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private ISistema sistema;
	private JComboBox <DTProveedor> boxProveedor;

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
	
	private void limpiarFormulario(JTextField campoNick, JTextField campoNombre, JTextField campoEmail, JTextField campoApellido, JTextField campoLink, JTextField campoFecha, JTextField campoCompañia){
		campoNick.setText("");
		campoNombre.setText("");
		campoEmail.setText("");
		campoApellido.setText("");
		campoLink.setText("");
		campoFecha.setText("");
		campoCompañia.setText("");
		
	}
	
	public ListarProveedores(ISistema sistema) {
		setTitle("Flamin-Go");
		setFrameIcon(new ImageIcon(ListarProveedores.class.getResource("/Images/Flamin-Go.png")));
		getContentPane().setBackground(new Color(240, 240, 240));
		setBounds(100, 100, 328, 376);
		getContentPane().setLayout(null);
		
		this.sistema = sistema;
		
		JLabel labelProveedor = new JLabel("Selecciona un Proveedor\r\n");
		labelProveedor.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labelProveedor.setHorizontalAlignment(SwingConstants.CENTER);
		labelProveedor.setBounds(0, 11, 312, 14);
		getContentPane().add(labelProveedor);
		
		JLabel labelNick = new JLabel("Nickname");
		labelNick.setBounds(10, 64, 48, 14);
		getContentPane().add(labelNick);
		
		JTextField campoNick = new JTextField();
		campoNick.setColumns(10);
		campoNick.setBounds(78, 61, 222, 20);
		campoNick.setEditable(false);
		getContentPane().add(campoNick);
		
		JLabel labelCorreo = new JLabel("Correo Electrónico");
		labelCorreo.setBounds(10, 108, 89, 14);
		getContentPane().add(labelCorreo);
		
		JTextField campoEmail = new JTextField();
		campoEmail.setColumns(10);
		campoEmail.setBounds(120, 105, 180, 20);
		campoEmail.setEditable(false);
		getContentPane().add(campoEmail);
		
		JLabel labelNombre = new JLabel("Nombre");
		labelNombre.setBounds(10, 153, 48, 14);
		getContentPane().add(labelNombre);
		
		JTextField campoNombre = new JTextField();
		campoNombre.setColumns(10);
		campoNombre.setBounds(68, 150, 232, 20);
		campoNombre.setEditable(false);
		getContentPane().add(campoNombre);
		
		JLabel labelApellido = new JLabel("Apellido");
		labelApellido.setBounds(10, 198, 48, 14);
		getContentPane().add(labelApellido);
		
		JTextField campoApellido = new JTextField();
		campoApellido.setColumns(10);
		campoApellido.setBounds(68, 195, 232, 20);
		campoApellido.setEditable(false);
		getContentPane().add(campoApellido);
		
		JTextField campoCompañia = new JTextField();
		campoCompañia.setColumns(10);
		campoCompañia.setBounds(144, 234, 156, 20);
		campoCompañia.setEditable(false);
		getContentPane().add(campoCompañia);
		
		JLabel labelCompañia = new JLabel("Nombre de la Compañía");
		labelCompañia.setBounds(10, 237, 118, 14);
		getContentPane().add(labelCompañia);
		
		JLabel labelLink = new JLabel("Link Web");
		labelLink.setBounds(10, 282, 48, 14);
		getContentPane().add(labelLink);
		
		JTextField campoLink = new JTextField();
		campoLink.setColumns(10);
		campoLink.setBounds(68, 279, 232, 20);
		campoLink.setEditable(false);
		getContentPane().add(campoLink);
		
		JLabel labelFecha = new JLabel("Fecha de nacimiento");
		labelFecha.setBounds(12, 319, 98, 14);
		getContentPane().add(labelFecha);
		
		JTextField campoFecha = new JTextField();
		campoFecha.setColumns(10);
		campoFecha.setBounds(122, 316, 79, 20);
		campoFecha.setEditable(false);
		getContentPane().add(campoFecha);

		
		JComboBox <DTProveedor> boxProveedor = new JComboBox<DTProveedor>();
		boxProveedor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DTProveedor selectedItem = (DTProveedor) boxProveedor.getSelectedItem();
				if (selectedItem != null) {
					String nick = selectedItem.getNickname();
					try {
						sistema.elegirProveedor(nick);
						DTProveedorDetallado prov = sistema.verInformacionProveedor();
						campoNick.setText(prov.getNickname());
						campoNombre.setText(prov.getNombre());
						campoEmail.setText(prov.getEmail());
						campoApellido.setText(prov.getApellido());
						campoLink.setText(prov.getLink());
						campoFecha.setText(prov.getFechaNac().toString());
						campoCompañia.setText(prov.getNomCompania());
					} catch (UsuarioNoExisteException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		boxProveedor.setEditable(true);
		boxProveedor.setBounds(78, 36, 156, 14);
		getContentPane().add(boxProveedor);
		
		this.boxProveedor = boxProveedor;
		
		this.addInternalFrameListener(new InternalFrameAdapter() {
	         @Override
	         public void internalFrameClosing(InternalFrameEvent e) {
	        	 limpiarFormulario(campoNick, campoNombre, campoEmail, campoApellido, campoLink, campoFecha, campoCompañia);
	        	 dispose();
	         }
	    });
			
	}
	
	
}
