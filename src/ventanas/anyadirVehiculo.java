package ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clases.Cliente;
import clases.Coche;
import clases.Moto;
import db.gestorDB1;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class anyadirVehiculo extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldId;
	private JTextField textFieldMarca;
	private JTextField textFieldModelo;
	private JTextField textFieldColor;
	private JTextField textFieldPrecio;
	private JTextField textFieldKm;

	
	

	/**
	 * Create the frame.
	 */
	public anyadirVehiculo(ArrayList<Moto> motos, ArrayList<Coche> coches) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 801, 532);
		contentPane = new JPanel();
		contentPane.setForeground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Id");
		lblNewLabel.setBounds(83, 128, 49, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblMarca = new JLabel("Marca");
		lblMarca.setBounds(83, 179, 49, 14);
		contentPane.add(lblMarca);
		
		JLabel lblModelo = new JLabel("Modelo");
		lblModelo.setBounds(83, 229, 49, 14);
		contentPane.add(lblModelo);
		
		JLabel lblColor = new JLabel("Color");
		lblColor.setBounds(83, 283, 49, 14);
		contentPane.add(lblColor);
		
		JLabel lblPrecio = new JLabel("Precio");
		lblPrecio.setBounds(83, 332, 49, 14);
		contentPane.add(lblPrecio);
		
		JLabel lblKilometros = new JLabel("Kilometros");
		lblKilometros.setBounds(83, 379, 80, 14);
		contentPane.add(lblKilometros);
		
		textFieldId = new JTextField();
		textFieldId.setBounds(237, 125, 121, 20);
		contentPane.add(textFieldId);
		textFieldId.setColumns(10);
		
		textFieldMarca = new JTextField();
		textFieldMarca.setColumns(10);
		textFieldMarca.setBounds(237, 176, 121, 20);
		contentPane.add(textFieldMarca);
		
		textFieldModelo = new JTextField();
		textFieldModelo.setColumns(10);
		textFieldModelo.setBounds(237, 226, 121, 20);
		contentPane.add(textFieldModelo);
		
		textFieldColor = new JTextField();
		textFieldColor.setColumns(10);
		textFieldColor.setBounds(237, 280, 121, 20);
		contentPane.add(textFieldColor);
		
		textFieldPrecio = new JTextField();
		textFieldPrecio.setColumns(10);
		textFieldPrecio.setBounds(237, 329, 121, 20);
		contentPane.add(textFieldPrecio);
		
		textFieldKm = new JTextField();
		textFieldKm.setColumns(10);
		textFieldKm.setBounds(237, 376, 121, 20);
		contentPane.add(textFieldKm);
		
		JButton btnNewButtonCoche = new JButton("Anyadir Coche");
		btnNewButtonCoche.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Coche c = new Coche(Integer.parseInt(textFieldId.getText()), textFieldMarca.getText(), textFieldModelo.getText(), textFieldColor.getText(),Integer.parseInt(textFieldPrecio.getText()),Integer.parseInt(textFieldKm.getText()));
				coches.add(c);
				gestorDB1.insertCoche(c);
			}
		});
		btnNewButtonCoche.setBounds(560, 175, 121, 23);
		contentPane.add(btnNewButtonCoche);
		
		JButton btnNewButtonMoto = new JButton("Anyadir Moto");
		btnNewButtonMoto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Moto m = new Moto(Integer.parseInt(textFieldId.getText()), textFieldMarca.getText(), textFieldModelo.getText(), textFieldColor.getText(),Integer.parseInt(textFieldPrecio.getText()),Integer.parseInt(textFieldKm.getText()));
				motos.add(m);
				gestorDB1.insertMoto(m);
			
			}
		});
		btnNewButtonMoto.setBounds(560, 263, 121, 23);
		contentPane.add(btnNewButtonMoto);
		
		JButton btnNewButtonVolver = new JButton("Volver");
		btnNewButtonVolver.addActionListener(e->{
			VentanaAdmin ventAd = new VentanaAdmin();
			ventAd.setVisible(true);
			anyadirVehiculo.this.setVisible(false);
			
	});
	
		btnNewButtonVolver.setBounds(353, 448, 89, 23);
		contentPane.add(btnNewButtonVolver);
	}
}
