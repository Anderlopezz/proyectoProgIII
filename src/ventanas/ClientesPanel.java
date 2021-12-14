package ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clases.Cliente;

import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

public class ClientesPanel extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public ClientesPanel() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 845, 542);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblClientes = new JLabel("CLIENTES");
		lblClientes.setHorizontalAlignment(SwingConstants.CENTER);
		lblClientes.setFont(new Font("Britannic Bold", Font.BOLD, 18));
		lblClientes.setBounds(10, 33, 814, 35);
		contentPane.add(lblClientes);
				
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(e->{
			VentanaAdmin ventAd = new VentanaAdmin();
			ventAd.setVisible(true);
			ClientesPanel.this.setVisible(false);
		});
		btnVolver.setBounds(343, 441, 108, 35);
		contentPane.add(btnVolver);
	
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(170, 113, 448, 292);
		contentPane.add(scrollPane);
		
		/**
		 * @author Ander  Lopez
		 */
		
		JList listClientes = new JList();
		listClientes.setBounds(170, 113, 448, 292);
		contentPane.add(listClientes);
		
		ArrayList<Cliente> selectCliente = db.gestorDB1.selectAllClientes();
		//DefaultListModel<Cliente>model=new DefaultListModel<Cliente>();
		DefaultListModel<Cliente>model1=new DefaultListModel<Cliente>();
		for (Cliente c : selectCliente) {
			model1.addElement(c);
		}
		listClientes.setModel(model1);
		
		scrollPane.setViewportView(listClientes);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(e->{
			int index= listClientes.getSelectedIndex();
			DefaultListModel modelo = (DefaultListModel) listClientes.getModel();
			modelo.remove(index);
			listClientes.setModel(modelo);
		});
		btnEliminar.setBounds(671, 263, 108, 35);
		contentPane.add(btnEliminar);
	    
	    
	    
		JButton btnAnyadir = new JButton("Anyadir");
		btnAnyadir.addActionListener(e->{
			anyadirCliente ventanaAnyadir = new anyadirCliente(selectCliente);
			ventanaAnyadir.setVisible(true);
			ClientesPanel.this.setVisible(false);
		});

		btnAnyadir.setBounds(671, 187, 108, 35);
		contentPane.add(btnAnyadir);
	
		
		
	}
}
