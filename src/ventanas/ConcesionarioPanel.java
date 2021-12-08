package ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class ConcesionarioPanel extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldAnyadir;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConcesionarioPanel frame = new ConcesionarioPanel();
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
	public ConcesionarioPanel() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 848, 546);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JButton btnAnyadir = new JButton("Anyadir");
		btnAnyadir.setBounds(696, 206, 108, 35);
		contentPane.add(btnAnyadir);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(696, 310, 108, 35);
		contentPane.add(btnEliminar);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(e->{
			VentanaAdmin ventAd = new VentanaAdmin();
			ventAd.setVisible(true);
			ConcesionarioPanel.this.setVisible(false);
		});
		btnVolver.setBounds(361, 463, 108, 35);
		contentPane.add(btnVolver);
		
		textFieldAnyadir = new JTextField();
		textFieldAnyadir.setBounds(696, 262, 96, 20);
		contentPane.add(textFieldAnyadir);
		textFieldAnyadir.setColumns(10);
		
		
		JList listConcesionarios = new JList();
		listConcesionarios.setBounds(179, 127, 448, 292);
		contentPane.add(listConcesionarios);
		
		JLabel lblNewLabel = new JLabel("CONCESIONARIOS");
		lblNewLabel.setFont(new Font("Britannic Bold", Font.BOLD, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 30, 814, 35);
		contentPane.add(lblNewLabel);
		
		
	}
}
