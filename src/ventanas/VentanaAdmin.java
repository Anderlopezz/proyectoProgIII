package ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class VentanaAdmin extends JFrame {

	private JPanel contentPane;
	

	/**
	 * Create the frame.
	 */
	public VentanaAdmin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 848, 545);
		contentPane = new JPanel();
		contentPane.setForeground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnVehiculos = new JButton("VEHICULOS");
		btnVehiculos.addActionListener(e->{
			VehiculosPanel vp = new VehiculosPanel();
			vp.setVisible(true);
			VentanaAdmin.this.setVisible(false);
//		btnVehiculos.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				VehiculosPanel vp = new VehiculosPanel();
//				vp.setVisible(true);
//				VentanaAdmin.this.setVisible(false);
//			}
		});
		btnVehiculos.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnVehiculos.setForeground(Color.BLACK);
		btnVehiculos.setBounds(344, 202, 164, 48);
		contentPane.add(btnVehiculos);
		
		JButton btnConcesionario = new JButton("CONCESIONARIO");
		btnVehiculos.addActionListener(e->{
			ConcesionarioPanel cp = new ConcesionarioPanel();
			cp.setVisible(true);
			VentanaAdmin.this.setVisible(false);
		});
		btnConcesionario.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnConcesionario.setBounds(344, 284, 164, 48);
		contentPane.add(btnConcesionario);
		
		JButton btnClientes = new JButton("CLIENTES");
		btnClientes.addActionListener(e->{
			ClientesPanel clp = new ClientesPanel();
			clp.setVisible(true);
			VentanaAdmin.this.setVisible(false);

		});
		btnClientes.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnClientes.setBounds(344, 357, 164, 48);
		contentPane.add(btnClientes);
		
		JLabel lblNewLabel = new JLabel("MENU");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel.setBounds(0, 80, 834, 29);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setIcon(new ImageIcon(VentanaAdmin.class.getResource("/image/auto-car-dealer-logo-design-600w-568160641.jpg")));
		lblNewLabel_1.setBounds(0, 0, 256, 508);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setIcon(new ImageIcon(VentanaAdmin.class.getResource("/image/auto-car-dealer-logo-design-600w-568160641.jpg")));
		lblNewLabel_2.setBounds(606, 0, 228, 508);
		contentPane.add(lblNewLabel_2);
	}
}
