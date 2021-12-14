package ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clases.Cliente;
import clases.Concesionario;
import db.gestorDB1;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class anyadirConcesionario extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;



	/**
	 * Create the frame.
	 */
	public anyadirConcesionario(ArrayList<Concesionario> concesionarios) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 769, 548);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("NUEVO CLIENTE");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Britannic Bold", Font.BOLD, 18));
		lblNewLabel_1.setBounds(10, 37, 735, 23);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("Id");
		lblNewLabel.setBounds(80, 181, 49, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(80, 228, 49, 14);
		contentPane.add(lblNombre);
		
		JLabel lblDireccion = new JLabel("Direccion");
		lblDireccion.setBounds(80, 270, 49, 14);
		contentPane.add(lblDireccion);
		
		JLabel lblNumeroTrabajadores = new JLabel("Numero Trabajadores");
		lblNumeroTrabajadores.setBounds(80, 322, 125, 14);
		contentPane.add(lblNumeroTrabajadores);
		
		textField = new JTextField();
		textField.setBounds(261, 178, 96, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(261, 225, 96, 20);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(261, 267, 96, 20);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(261, 319, 96, 20);
		contentPane.add(textField_3);
		
		JButton btnNewButton = new JButton("Anyadir");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				concesionarios.add(new Concesionario(Integer.parseInt(textField.getText()), textField_1.getText(), null,textField_2.getText(), Integer.parseInt(textField_3.getText())));
				gestorDB1.insertConcesionario(Integer.parseInt(textField.getText()), textField_1.getText(), null,textField_2.getText(),Integer.parseInt(textField_3.getText()));
				
			}
		});
		btnNewButton.setBounds(183, 455, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(e->{
				VentanaAdmin ventAd = new VentanaAdmin();
				ventAd.setVisible(true);
				anyadirConcesionario.this.setVisible(false);
		});
		btnVolver.setBounds(372, 455, 89, 23);
		contentPane.add(btnVolver);
	}
}
