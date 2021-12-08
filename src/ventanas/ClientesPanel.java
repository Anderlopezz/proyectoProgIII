package ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clases.Cliente;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class ClientesPanel extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClientesPanel frame = new ClientesPanel();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

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
		
		JButton btnAnyadir = new JButton("Anyadir");
		btnAnyadir.setBounds(671, 187, 108, 35);
		contentPane.add(btnAnyadir);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(671, 263, 108, 35);
		contentPane.add(btnEliminar);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(e->{
			VentanaAdmin ventAd = new VentanaAdmin();
			ventAd.setVisible(true);
			ClientesPanel.this.setVisible(false);
		});
		btnVolver.setBounds(343, 441, 108, 35);
		contentPane.add(btnVolver);
		
		
		JList listClientes = new JList();
		listClientes.setBounds(170, 113, 448, 292);
		contentPane.add(listClientes);
		
		ArrayList<Cliente> selectCliente = db.gestorDB1.selectAllClientes(sql);
		//DefaultListModel<Cliente>model=new DefaultListModel<Cliente>();
		DefaultListModel<Cliente>model1=new DefaultListModel<Cliente>();
		for (Cliente c : selectCliente) {
			model1.add(c);
		}
		
		
		
	}

}
