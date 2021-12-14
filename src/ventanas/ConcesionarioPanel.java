package ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clases.Cliente;
import clases.Concesionario;

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

public class ConcesionarioPanel extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public ConcesionarioPanel() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 848, 546);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(e->{
			VentanaAdmin ventAd = new VentanaAdmin();
			ventAd.setVisible(true);
			ConcesionarioPanel.this.setVisible(false);
		});
		btnVolver.setBounds(361, 463, 108, 35);
		contentPane.add(btnVolver);
		
		
		JLabel lblNewLabel = new JLabel("CONCESIONARIOS");
		lblNewLabel.setFont(new Font("Britannic Bold", Font.BOLD, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 30, 814, 35);
		contentPane.add(lblNewLabel);
		
		JList listConcesionarios = new JList();
		listConcesionarios.setBounds(179, 127, 448, 292);
		contentPane.add(listConcesionarios);
		
		ArrayList<Concesionario> selectConcesionario = db.gestorDB1.selectAllConcesionarios();
		//DefaultListModel<Cliente>model=new DefaultListModel<Cliente>();
		DefaultListModel<Concesionario>model1=new DefaultListModel<Concesionario>();
		for (Concesionario c : selectConcesionario) {
			model1.addElement(c);
		}
		listConcesionarios.setModel(model1);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(e->{
			int index= listConcesionarios.getSelectedIndex();
			DefaultListModel modelo = (DefaultListModel) listConcesionarios.getModel();
			modelo.remove(index);
			listConcesionarios.setModel(modelo);
		});
		btnEliminar.setBounds(696, 310, 108, 35);
		contentPane.add(btnEliminar);
		
		JButton btnAnyadir = new JButton("Anyadir");
		btnAnyadir.addActionListener(e->{
				anyadirConcesionario ventanaAnyadirC = new anyadirConcesionario(selectConcesionario);
				ventanaAnyadirC.setVisible(true);
				ConcesionarioPanel.this.setVisible(false);
			
		});
		btnAnyadir.setBounds(696, 206, 108, 35);
		contentPane.add(btnAnyadir);
	}
}
