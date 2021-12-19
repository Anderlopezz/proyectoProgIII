package ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import clases.Coche;
import clases.Concesionario;
import clases.Moto;
import clases.Vehiculo;
import db.gestorDB1;

import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VehiculosPanel extends JFrame {

	
	private ArrayList<Coche> coches;
	private ArrayList<Moto> motos;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VehiculosPanel frame = new VehiculosPanel();
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
	public VehiculosPanel() {
		this.coches =  gestorDB1.selectAllCoches();
		this.motos =  gestorDB1.selectAllMotos();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 829, 533);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(141, 69, 449, 339);
		contentPane.add(scrollPane);
		
		JList listVehiculos = new JList();
		listVehiculos.setBounds(141, 69, 449, 339);
		contentPane.add(listVehiculos);
		
		ArrayList<Vehiculo> vehiculos = leertodos(this.motos, this.coches);
		DefaultListModel<Vehiculo> model1= new DefaultListModel<Vehiculo>();
		for (Vehiculo vehiculo : vehiculos) {
			model1.addElement(vehiculo);
		}
		listVehiculos.setModel(model1);
		
		JButton btnNewButton = new JButton("Anyadir");
		btnNewButton.addActionListener(e->{
			anyadirVehiculo aV = new anyadirVehiculo(this.motos, this.coches);
			aV.setVisible(true);
			VehiculosPanel.this.setVisible(false);
		});
		btnNewButton.setBounds(651, 148, 154, 23);
		contentPane.add(btnNewButton);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(e->{
			int index= listVehiculos.getSelectedIndex();
			DefaultListModel modelo = (DefaultListModel) listVehiculos.getModel();
			if(listVehiculos.getSelectedValue() instanceof Coche) {
				gestorDB1.deleteCoche(((Coche)listVehiculos.getSelectedValue()).getId());
			}else {
				gestorDB1.deleteMoto(((Moto)listVehiculos.getSelectedValue()).getId());
			}
			modelo.remove(index);
			listVehiculos.setModel(modelo);
			
			//System.out.println(((Concesionario)listConcesionarios.getSelectedValue()).getIdConcesionario());
//	gestorDB1.deleteConcesionario(((Concesionario)listConcesionarios.getSelectedValue()).getIdConcesionario());
		});
		btnEliminar.setBounds(651, 272, 154, 23);
		contentPane.add(btnEliminar);
		
		JLabel lblVehiculos = new JLabel("VEHICULOS");
		lblVehiculos.setHorizontalAlignment(SwingConstants.CENTER);
		lblVehiculos.setFont(new Font("Britannic Bold", Font.BOLD, 18));
		lblVehiculos.setBounds(10, 11, 814, 35);
		contentPane.add(lblVehiculos);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(e->{
			VentanaAdmin ventAd = new VentanaAdmin();
			ventAd.setVisible(true);
			VehiculosPanel.this.setVisible(false);
		});
		
		btnVolver.setBounds(337, 449, 89, 23);
		contentPane.add(btnVolver);
		
		JButton btnNewButton_1 = new JButton("Ordenar Precio");
		btnNewButton_1.addActionListener(e->{
			ArrayList<Vehiculo> listaOrdenada = utils.Ordenamiento.mergeSortNum(vehiculos);
			//listaOrdenada.stream().forEach(w->System.out.println(w));
			
			
			DefaultListModel<Vehiculo>model2=new DefaultListModel<Vehiculo>();
			for (Vehiculo c : listaOrdenada) {
				model2.addElement(c);
			}
			listVehiculos.setModel(model2);
			
			
		});
		btnNewButton_1.setBounds(651, 411, 154, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("Ordenar Km");
		btnNewButton_1_1.addActionListener(e->{
			ArrayList<Vehiculo> listaOrdenada = utils.Ordenamiento.mergeSortNumKm(vehiculos);
			DefaultListModel<Vehiculo>model2=new DefaultListModel<Vehiculo>();
			for (Vehiculo c : listaOrdenada) {
				model2.addElement(c);
			}
			listVehiculos.setModel(model2);
			
		});
		btnNewButton_1_1.setBounds(651, 363, 154, 23);
		contentPane.add(btnNewButton_1_1);
		
		
		//
		
		
		//
		
		scrollPane.setViewportView(listVehiculos);
	}
	
	
	
	public static ArrayList<Vehiculo> leertodos(ArrayList<Moto> motos, ArrayList<Coche> coches){
		ArrayList<Vehiculo> vehiculos = new ArrayList<>();
		
		
		
		
		for (Moto moto : motos) {
			vehiculos.add((Vehiculo)moto);
			
		}
		for (Coche coche : coches) {
			vehiculos.add((Vehiculo)coche);
		}
		
		return vehiculos;
	}
}
