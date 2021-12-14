package ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clases.Cliente;
import db.gestorDB1;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Font;

public class anyadirCliente extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	

	/**
	 * Create the frame.
	 */
	public anyadirCliente(ArrayList<Cliente> clientes) {
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 717, 438);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Anyadir");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clientes.add(new Cliente(Integer.parseInt(textField.getText()), textField_1.getText(), textField_2.getText(),Integer.parseInt(textField_3.getText()), 0));
				gestorDB1.insertCliente(new Cliente(Integer.parseInt(textField.getText()), textField_1.getText(), textField_2.getText(),Integer.parseInt(textField_3.getText()), 0));
			
			}
		});
		btnNewButton.setBounds(170, 338, 89, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("id");
		lblNewLabel.setBounds(93, 119, 49, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNombre = new JLabel("nombre");
		lblNombre.setBounds(93, 152, 49, 14);
		contentPane.add(lblNombre);
		
		JLabel lblApellido = new JLabel("apellido");
		lblApellido.setBounds(93, 193, 49, 14);
		contentPane.add(lblApellido);
		
		JLabel lblEdad = new JLabel("edad");
		lblEdad.setBounds(93, 235, 49, 14);
		contentPane.add(lblEdad);
		
		textField = new JTextField();
		textField.setBounds(185, 116, 96, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(185, 149, 96, 20);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(185, 190, 96, 20);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(185, 232, 96, 20);
		contentPane.add(textField_3);
		
		JLabel lblNewLabel_1 = new JLabel("NUEVO CLIENTE");
		lblNewLabel_1.setFont(new Font("Britannic Bold", Font.BOLD, 18));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(10, 25, 683, 23);
		contentPane.add(lblNewLabel_1);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(e->{
				VentanaAdmin ventAd = new VentanaAdmin();
				ventAd.setVisible(true);
				anyadirCliente.this.setVisible(false);
				
		});
		btnVolver.setBounds(422, 338, 89, 23);
		contentPane.add(btnVolver);
	}
}
